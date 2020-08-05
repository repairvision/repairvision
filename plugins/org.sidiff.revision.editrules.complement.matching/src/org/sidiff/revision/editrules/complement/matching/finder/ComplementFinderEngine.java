package org.sidiff.revision.editrules.complement.matching.finder;

import static org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil.getLHS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.MatchImpl;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil;
import org.sidiff.revision.common.logging.util.LogTime;
import org.sidiff.revision.editrules.complement.construction.ComplementConstructor;
import org.sidiff.revision.editrules.complement.construction.ComplementRule;
import org.sidiff.revision.editrules.complement.matching.configuration.ComplementFinderSettings;
import org.sidiff.revision.editrules.complement.matching.finder.henshin.ComplementEngine;
import org.sidiff.revision.editrules.complement.matching.finder.henshin.HenshinRuleStructureSorting;
import org.sidiff.revision.editrules.complement.matching.impact.ComplementMatching;
import org.sidiff.revision.editrules.impact.graph.GraphActionImpactAnalysis;
import org.sidiff.revision.editrules.impact.graph.GraphActionImpactScope;
import org.sidiff.revision.editrules.recognition.IRecognitionEngineProvider;
import org.sidiff.revision.editrules.recognition.impl.RecognitionEngineProvider;
import org.sidiff.revision.editrules.recognition.match.RecognitionAttributeMatch;
import org.sidiff.revision.editrules.recognition.match.RecognitionEdgeMatch;
import org.sidiff.revision.editrules.recognition.match.RecognitionMatch;
import org.sidiff.revision.editrules.recognition.match.RecognitionNodeSingleMatch;
import org.sidiff.revision.editrules.recognition.match.RecognitionParameterMatch;
import org.sidiff.revision.impact.analysis.ImpactAnalyzes;

/**
 * Tries to find all complementing operation for a given edit-rule and a model difference. 
 * 
 * @author Manuel Ohrndorf
 */
public class ComplementFinderEngine {
	
	public static boolean DEBUG = false;
	
	/**
	 * Derives the (Henshin) complement rule based on a CPEO.
	 */
	private ComplementConstructor complementConstructor;
	
	/**
	 * The (Henshin) engine which applies the rules.
	 */
	private EngineImpl engine;
	
	/**
	 * Optimize Henshin CSP search plan by custom sorting of nodes to be matched:
	 */
	private boolean useCustomHenshinNodeSorting = true;
	
	/**
	 * Inconsistency impact analysis.
	 */
	private ImpactAnalyzes currentImpactAnalyzes;

	/**
	 * The working graph, i.e. the actual version of the model.
	 */
	private EGraph graphModelB;
	
	/**
	 * Partial edit-rule recognition matcher.
	 */
	private IRecognitionEngineProvider recognitionEngineProvider;

	public ComplementFinderEngine(ImpactAnalyzes currentImpactAnalyzes, EGraph graphModelB) {
		this.currentImpactAnalyzes = currentImpactAnalyzes;
		this.graphModelB = graphModelB;
	}
	
	public void start() {
		this.recognitionEngineProvider = new RecognitionEngineProvider();
		this.complementConstructor = new ComplementConstructor();
		this.engine = new ComplementEngine(!useCustomHenshinNodeSorting);
	}

	public void finish() {
		this.engine.clearCache();
		this.engine.shutdown();
	}
	
	public IRecognitionEngineProvider getRecognitionEngine() {
		return recognitionEngineProvider;
	}
	
	public ComplementFinder createComplementFinder(ComplementFinderSettings settings) {
		return new ComplementFinder(this, settings);
	}
	
	public List<Match> findComplementMatches(ComplementRule complementRule) {

		// Create complement pre-match by partial source-rule match:
		Match complementMatch = new MatchImpl(complementRule.getComplementRule());
		
		createComplementPreMatch(complementRule, complementMatch);
		checkForUnambiguousRepairContext(complementRule, complementMatch);
		
		// Check context rule (with restricted working graph):
		ArrayList<Match> complementPreMatches = new ArrayList<>();
		
		// FIXME WORKAROUND: This should be done by Henshin!
		for (Parameter parameter : complementMatch.getRule().getParameters()) {
			Object value = complementMatch.getParameterValue(parameter);
			engine.getScriptEngine().put(parameter.getName(), value);
		}

		// Optimize Henshin CSP search plan by sorting the nodes to be matched:
		if (useCustomHenshinNodeSorting) {
			HenshinRuleStructureSorting.sort(complementRule.getComplementRule(), complementMatch);
		}

		// Start complement matching:
		LogTime complementMatching = new LogTime();
		complementMatching.start();
		
		findMatches(complementRule, complementMatch, complementPreMatches);
		
		complementMatching.stop();
		
		if (DEBUG) {
			System.out.println("Re.Vision[Complement Count]: " + complementPreMatches.size());
			System.out.println("Re.Vision[Complement Time]: " + complementMatching + "ms");
		}
		
		complementPreMatches.trimToSize();
		return complementPreMatches;
	}

	private void createComplementPreMatch(ComplementRule complementRule, Match complementMatch) {
		
		// Get change context as pre-match:
		for (RecognitionMatch sourceRuleMatch : complementRule.getRecognitionMatching()) {

			if (sourceRuleMatch instanceof RecognitionEdgeMatch) {
				RecognitionEdgeMatch sourceEdgeMatch = (RecognitionEdgeMatch) sourceRuleMatch;
				
				if (sourceEdgeMatch.getAction().equals(Type.CREATE)) {
					addMatch(complementRule, complementMatch,
							sourceEdgeMatch.getEdge().getSource(),
							sourceEdgeMatch.getSrcModelBElement());
					addMatch(complementRule, complementMatch,
							sourceEdgeMatch.getEdge().getTarget(),
							sourceEdgeMatch.getTgtModelBElement());
				}
				
				else if (sourceEdgeMatch.getAction().equals(Type.DELETE)) {
					EObject src = ((RecognitionEdgeMatch) sourceRuleMatch).getSrcModelBElement();
					
					if (src != null) {
						addMatch(complementRule, complementMatch, sourceEdgeMatch.getEdge().getSource(), src);
					}
					
					EObject tgt = sourceEdgeMatch.getTgtModelBElement();
					
					if (tgt != null) {
						addMatch(complementRule, complementMatch, sourceEdgeMatch.getEdge().getTarget(), tgt);
					}
				}
			}

			else if (sourceRuleMatch instanceof RecognitionNodeSingleMatch) {
				RecognitionNodeSingleMatch sourceNodeMatch = (RecognitionNodeSingleMatch) sourceRuleMatch;
				
				if (sourceNodeMatch.getAction().equals(Type.CREATE)) {
					addMatch(complementRule, complementMatch,
							sourceNodeMatch.getNode(),
							sourceNodeMatch.getModelBElement());
				}
			}
			
			else if (sourceRuleMatch instanceof RecognitionAttributeMatch) {
				RecognitionAttributeMatch sourceAttributeMatch = (RecognitionAttributeMatch) sourceRuleMatch;
				
				if (sourceAttributeMatch.getAction().equals(Type.CREATE)) {
					addMatch(complementRule, complementMatch,
							sourceAttributeMatch.getAttribute().getNode(),
							sourceAttributeMatch.getObject());
				}
			}
			
			else if (sourceRuleMatch instanceof RecognitionParameterMatch) {
				RecognitionParameterMatch sourceParameterMatch = (RecognitionParameterMatch) sourceRuleMatch;
				addMatch(complementRule, complementMatch, 
						sourceParameterMatch.getParameter(), 
						sourceParameterMatch.getValue());
			}

			// NOTE: Ignore EditRuleNodeMulitMatches... only unique context!
		}
	}
	
	// TODO: Check the repair impact as user defined constraint in the Henshin CSP.  
	private void checkForUnambiguousRepairContext(ComplementRule complementRule, Match complementMatch) {
		GraphActionImpactScope currentImpactScope = new GraphActionImpactScope(
				complementRule.getComplementingBoundaryChanges(), 
				currentImpactAnalyzes.getPotentialImpactScope());

		Node repairContext = null;
		EObject repairContextElement = null;
		
		for (GraphElement graphElement : currentImpactScope.getChanges()) {
			if (currentImpactScope.get(graphElement).size() == 1) {
				EObject repairScopeElement = currentImpactScope.get(graphElement).get(0);
				
				if (graphElement instanceof Edge) {
					Node source = HenshinRuleAnalysisUtil.getLHS(((Edge) graphElement).getSource());
					
					if (source != null) {
						if ((repairContext == null) && (repairContextElement == null)) {
							repairContext = source;
							repairContextElement = repairScopeElement;
						} else if ((repairContext != source) || (repairContextElement != repairScopeElement)) {

								// Ambiguous context!
								repairContext = null;
								repairContextElement = null;
								break;
						}
					}
				} else if (graphElement instanceof Attribute) {
					Node container = HenshinRuleAnalysisUtil.getLHS(((Attribute) graphElement).getNode());
					
					if (container != null) {
						if ((repairContext == null) && (repairContextElement == null)) {
							repairContext = container;
							repairContextElement = repairScopeElement;
						} else if ((repairContext != container) || (repairContextElement != repairScopeElement)) {

							// Ambiguous context!
							repairContext = null;
							repairContextElement = null;
							break;
						}
					}
				}
			} else {
				
				// Ambiguous context!
				repairContext = null;
				repairContextElement = null;
				break;
			}
		}
		
		if ((repairContext != null) && (repairContextElement != null)) {
			complementMatch.setNodeTarget(repairContext, repairContextElement);
		}
	}
	
	private void findMatches(ComplementRule complementRule, Match complementMatch, ArrayList<Match> complementPreMatches) {
		Iterator<Match> matchFinder = engine.findMatches(complementRule.getComplementRule(), graphModelB, complementMatch).iterator();
		
		GraphActionImpactAnalysis currentImpact = new GraphActionImpactAnalysis(currentImpactAnalyzes.getImpactAnalysis());
		List<GraphElement> complementChanges = complementRule.getComplementingChanges();
		
//		while (matchFinder.hasNext() && (complementPreMatches.size() < 1)) {
		while (matchFinder.hasNext()) {
			Match nextMatch = matchFinder.next();
			
			// Filter complement with match by impact:
			if (currentImpact.hasImpact(complementChanges, new ComplementMatching(nextMatch))) {
				complementPreMatches.add(nextMatch);
			}
		}
	}

	private void addMatch(ComplementRule complementRule, Match complementPreMatches, 
			Parameter sourceParameter, Object value) {
		
		Parameter complementParameter = complementRule.getTrace(sourceParameter);
		
		if (complementParameter != null) {
			complementPreMatches.setParameterValue(complementParameter, value);
		}
	}
	
	private void addMatch(ComplementRule complementRule, Match complementPreMatches, 
			Node sourceNode, EObject match) {
		
		Node complementNode = getLHS(complementRule.getTrace(sourceNode));
		
		if (complementNode != null) {
			complementPreMatches.setNodeTarget(complementNode, match);
		}
	}
	
	public ComplementConstructor getComplementConstructor() {
		return complementConstructor;
	}
}
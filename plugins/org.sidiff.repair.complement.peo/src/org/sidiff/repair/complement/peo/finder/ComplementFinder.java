package org.sidiff.repair.complement.peo.finder;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.MatchImpl;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.common.henshin.ChangePatternUtil;
import org.sidiff.consistency.common.monitor.LogMonitor;
import org.sidiff.consistency.common.monitor.LogTable;
import org.sidiff.consistency.common.monitor.LogTime;
import org.sidiff.consistency.common.monitor.LogUtil;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.editrule.partialmatcher.PartialEditRuleRecognizer;
import org.sidiff.editrule.partialmatcher.pattern.RecognitionPattern;
import org.sidiff.editrule.partialmatcher.scope.RepairScope;
import org.sidiff.editrule.partialmatcher.util.debug.DebugUtil;
import org.sidiff.graphpattern.matcher.IMatching;
import org.sidiff.graphpattern.util.GraphPatternConstants;
import org.sidiff.repair.api.util.RepairAPIUtil;
import org.sidiff.repair.complement.construction.ComplementConstructor;
import org.sidiff.repair.complement.construction.ComplementRule;
import org.sidiff.repair.complement.matching.RecognitionAttributeMatch;
import org.sidiff.repair.complement.matching.RecognitionEdgeMatch;
import org.sidiff.repair.complement.matching.RecognitionMatch;
import org.sidiff.repair.complement.matching.RecognitionNodeSingleMatch;
import org.sidiff.repair.complement.matching.RecognitionParameterMatch;
import org.sidiff.repair.complement.util.ParameterBinding;

/**
 * Tries to find all complementing operation for a given edit-rule and a model difference. 
 * 
 * @author Manuel Ohrndorf
 */
public class ComplementFinder {

	/**
	 * Derives the (Henshin) complement rule based on a CPEO.
	 */
	protected ComplementConstructor complementConstructor;
	
	/**
	 * The historic model.
	 */
	protected Resource modelAResource;
	
	/**
	 * The actual model.
	 */
	protected Resource modelBResource;
	
	/**
	 * The difference between model A and B.
	 */
	protected SymmetricDifference difference;
	
	/**
	 * The (Henshin) engine which applies the rules.
	 */
	protected EngineImpl engine;

	/**
	 * The working graph, i.e. the actual version of the model.
	 */
	protected EGraph graphModelB;
	
	/**
	 * Converts an recognition to an edit rule match.
	 */
	protected Edit2RecognitionMatch matchConverter;
	
	/**
	 * Writes the recognition rule to the location of the edit rule (e.g. debugging).
	 */
	protected boolean saveRecognitionRule;
	
	/**
	 * Partial edit-rule recognition matcher.
	 */
	protected PartialEditRuleRecognizer partialEditRuleRecognizer;

	/**
	 * @param modelAResource
	 *            The historic model.
	 * @param modelBResource
	 *            The actual model.
	 * @param difference
	 *            The difference between model A and B.
	 */
	public ComplementFinder(SymmetricDifference difference, 
			Resource modelAResource, Resource modelBResource, 
			EGraph graphModelB) {
		
		assert (modelAResource.getResourceSet() == modelBResource.getResourceSet()) 
		&& (modelBResource.getResourceSet() == difference.eResource().getResourceSet());
		
		this.difference = difference;
		this.modelAResource = modelAResource;
		this.modelBResource = modelBResource;
		this.graphModelB = graphModelB;
	}
	
	public void start() {
		this.partialEditRuleRecognizer = new PartialEditRuleRecognizer();
		this.partialEditRuleRecognizer.initialize(difference);
		this.partialEditRuleRecognizer.start();
		
		this.matchConverter = new Edit2RecognitionMatch(difference);
		
		this.complementConstructor = new ComplementConstructor();
		this.engine = new EngineImpl();
	}

	public void finish() {
		this.partialEditRuleRecognizer.finish();
		this.engine.clearCache();
		this.engine.shutdown();
	}
	
	/**
	 * @param editRule
	 *            The partially executed edit-rule.
	 * @return All complementing operations for the given edit-rule.
	 */
	public List<ComplementRule> findComplementRules(IProgressMonitor monitor, LogTable runtimeLog, Rule editRule, RepairScope scope) {
		
		//// Lifting ////

		// Matching:
		RecognitionPattern recognitionPattern = partialEditRuleRecognizer.createRecognitionPattern(editRule);
		DebugUtil.printEditRule(editRule);
		
		LogTime recognitionTimer = new LogTime();
		Iterator<IMatching> matchIterator = partialEditRuleRecognizer.recognizePartialEditRule(recognitionPattern, scope, runtimeLog);
		recognitionTimer.stop();
		DebugUtil.printRecognitionTime(recognitionTimer);
		
		// Report:
		if (monitor instanceof LogMonitor) {
			LogUtil.appendTime((LogMonitor) monitor, "[Time (ms)] Recognition Time", recognitionTimer);
		}
		
		// Save recognition-rule:
		if (saveRecognitionRule) {
			ChangePatternUtil.saveGraphPattern(RepairAPIUtil.getRecognitionRuleURI(
					editRule.eResource().getURI(), GraphPatternConstants.FILE_EXTENSION),
					recognitionPattern.getGraphPattern());
		}

		//// Complement Construction ////


		List<ComplementRule> complements = new ArrayList<>(); 

		// Find partially executed edit-operations:
		while(matchIterator.hasNext()) {
			IMatching matching = matchIterator.next();
			DebugUtil.printMatching(recognitionPattern, matching);
			
			// Translate: Create partial edit-rule match from recognition-rule match:
			List<RecognitionMatch> recognitionMatch = matchConverter.createEditRuleMatch(recognitionPattern, matching);
			
			// Store new complement rule:
			if (!recognitionMatch.isEmpty()) {
				ComplementRule complementRule = complementConstructor.createComplementRule(editRule, recognitionMatch);
				
				if (complementRule != null) {
					complements.add(complementRule);
				}
			}
		}
		
		return complements;
	}
	
	public List<Match> findComplementMatches(
			ComplementRule complementRule, 
			List<ParameterBinding> parameters) {

		// Create complement pre-match by partial source-rule match:
		Match complementMatche = new MatchImpl(complementRule.getComplementRule());

		// Get change context as pre-match:
		for (RecognitionMatch sourceRuleMatch : complementRule.getRecognitionMatch()) {

			if (sourceRuleMatch instanceof RecognitionEdgeMatch) {
				RecognitionEdgeMatch sourceEdgeMatch = (RecognitionEdgeMatch) sourceRuleMatch;
				
				if (sourceEdgeMatch.getAction().equals(Type.CREATE)) {
					addMatch(complementRule, complementMatche,
							sourceEdgeMatch.getEdge().getSource(),
							sourceEdgeMatch.getSrcModelBElement());
					addMatch(complementRule, complementMatche,
							sourceEdgeMatch.getEdge().getTarget(),
							sourceEdgeMatch.getTgtModelBElement());
				}
				
				else if (sourceEdgeMatch.getAction().equals(Type.DELETE)) {
					EObject src = ((RecognitionEdgeMatch) sourceRuleMatch).getSrcModelBElement();
					
					if (src != null) {
						addMatch(complementRule, complementMatche, sourceEdgeMatch.getEdge().getSource(), src);
					}
					
					EObject tgt = sourceEdgeMatch.getTgtModelBElement();
					
					if (tgt != null) {
						addMatch(complementRule, complementMatche, sourceEdgeMatch.getEdge().getTarget(), tgt);
					}
				}
			}

			else if (sourceRuleMatch instanceof RecognitionNodeSingleMatch) {
				RecognitionNodeSingleMatch sourceNodeMatch = (RecognitionNodeSingleMatch) sourceRuleMatch;
				
				if (sourceNodeMatch.getAction().equals(Type.CREATE)) {
					addMatch(complementRule, complementMatche,
							sourceNodeMatch.getNode(),
							sourceNodeMatch.getModelBElement());
				}
			}
			
			else if (sourceRuleMatch instanceof RecognitionAttributeMatch) {
				RecognitionAttributeMatch sourceAttributeMatch = (RecognitionAttributeMatch) sourceRuleMatch;
				
				if (sourceAttributeMatch.getAction().equals(Type.CREATE)) {
					addMatch(complementRule, complementMatche,
							sourceAttributeMatch.getAttribute().getNode(),
							sourceAttributeMatch.getObject());
				}
			}
			
			else if (sourceRuleMatch instanceof RecognitionParameterMatch) {
				RecognitionParameterMatch sourceParameterMatch = (RecognitionParameterMatch) sourceRuleMatch;
				
				addMatch(complementRule, complementMatche, 
						sourceParameterMatch.getParameter(), 
						sourceParameterMatch.getValue());
			}

			// NOTE: Ignore EditRuleNodeMulitMatches... only unique context!
		}
		
		// Check context rule (with restricted working graph):
		ArrayList<Match> complementPreMatches = new ArrayList<>();
		Iterator<Match> matchFinder = engine.findMatches(
				complementRule.getComplementRule(), graphModelB, complementMatche).iterator();
		
		while (matchFinder.hasNext()) {
			Match nextMatch = matchFinder.next();
			
			// Create complement pre-match:
			complementPreMatches.add(nextMatch);
		}
		
		complementPreMatches.trimToSize();
		return complementPreMatches;
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
	
	public boolean isSaveRecognitionRule() {
		return saveRecognitionRule;
	}

	public void setSaveRecognitionRule(boolean saveRecognitionRule) {
		this.saveRecognitionRule = saveRecognitionRule;
	}
}
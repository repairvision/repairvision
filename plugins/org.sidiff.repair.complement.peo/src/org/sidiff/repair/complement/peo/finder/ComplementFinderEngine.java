package org.sidiff.repair.complement.peo.finder;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHS;

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
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.editrule.recognition.RecognitionEngine;
import org.sidiff.editrule.recognition.impact.PositiveImpactScope;
import org.sidiff.history.revision.IRevision;
import org.sidiff.repair.complement.construction.ComplementConstructor;
import org.sidiff.repair.complement.construction.ComplementRule;
import org.sidiff.repair.complement.matching.RecognitionAttributeMatch;
import org.sidiff.repair.complement.matching.RecognitionEdgeMatch;
import org.sidiff.repair.complement.matching.RecognitionMatch;
import org.sidiff.repair.complement.matching.RecognitionNodeSingleMatch;
import org.sidiff.repair.complement.matching.RecognitionParameterMatch;
import org.sidiff.repair.complement.peo.configuration.ComplementFinderSettings;
import org.sidiff.repair.complement.util.ParameterBinding;
import org.sidiff.validation.constraint.impact.ImpactAnalyzes;

/**
 * Tries to find all complementing operation for a given edit-rule and a model difference. 
 * 
 * @author Manuel Ohrndorf
 */
public class ComplementFinderEngine {

	/**
	 * Derives the (Henshin) complement rule based on a CPEO.
	 */
	protected ComplementConstructor complementConstructor;
	
	/**
	 * The (Henshin) engine which applies the rules.
	 */
	protected EngineImpl engine;
	
	/**
	 * The revision which introduces an inconsistency.
	 */
	protected IRevision revision;
	
	/**
	 * Inconsistency impact analysis.
	 */
	protected ImpactAnalyzes impact;

	/**
	 * The working graph, i.e. the actual version of the model.
	 */
	protected EGraph graphModelB;
	
	/**
	 * Converts an recognition to an edit rule match.
	 */
	protected Edit2RecognitionMatch matchConverter;
	
	/**
	 * Partial edit-rule recognition matcher.
	 */
	protected RecognitionEngine partialEditRuleRecognizer;

	/**
	 * @param modelAResource
	 *            The historic model.
	 * @param modelBResource
	 *            The actual model.
	 * @param difference
	 *            The difference between model A and B.
	 */
	public ComplementFinderEngine(IRevision revision, ImpactAnalyzes impact, EGraph graphModelB) {
		this.revision = revision;
		this.impact = impact;
		this.graphModelB = graphModelB;
	}
	
	public void start() {
		this.partialEditRuleRecognizer = new RecognitionEngine();
		this.partialEditRuleRecognizer.initialize(revision);
		this.partialEditRuleRecognizer.start();
		
		this.matchConverter = new Edit2RecognitionMatch(revision, impact);
		
		this.complementConstructor = new ComplementConstructor();
		this.engine = new EngineImpl();
	}

	public void finish() {
		this.partialEditRuleRecognizer.finish();
		this.engine.clearCache();
		this.engine.shutdown();
	}
	
	public RecognitionEngine getRecognitionEngine() {
		return partialEditRuleRecognizer;
	}
	
	public ComplementFinder createComplementFinder(Rule editRule, 
			PositiveImpactScope repairScope, PositiveImpactScope overwriteScope,
			ComplementFinderSettings settings) {
		
		return new ComplementFinder(this, editRule, repairScope, overwriteScope, settings);
	}
	
	public List<Match> findComplementMatches(
			ComplementRule complementRule, 
			List<ParameterBinding> parameters) {

		// Create complement pre-match by partial source-rule match:
		Match complementMatch = new MatchImpl(complementRule.getComplementRule());

		// Get change context as pre-match:
		for (RecognitionMatch sourceRuleMatch : complementRule.getRecognitionMatch()) {

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
				
				// FIXME WORKAROUND: Allow overwriting of attributes! Find better solution!? Filter earlier!?
				// FIXME: Create: Accessor Operation for Structural Feature
				// file:/users/mohrndorf/workspaces/sidiff-build/org.eclipse.git.evaluation_2018-11-02/modeling.mdt.ocl/plugins_org.eclipse.ocl.pivot_model_Lookup.ecore/0008_2015-06-27T12-53-05Z_323236adcbbf40b88d9362925b642167097bd466/plugins_org.eclipse.ocl.pivot_model_Lookup.ecore#_fMJ_eN6tEei97MD7GK1RmA
				// ThereMayNotBeTwoOperationsAndWithTheSameSignature
//				if (!isAttributeValueChange(complementRule, complementMatch)) {
					addMatch(complementRule, complementMatch, 
							sourceParameterMatch.getParameter(), 
							sourceParameterMatch.getValue());
//				}
			}

			// NOTE: Ignore EditRuleNodeMulitMatches... only unique context!
		}
		
		// Check context rule (with restricted working graph):
		ArrayList<Match> complementPreMatches = new ArrayList<>();
		
		// FIXME WORKAROUND: This should be done by Henshin!
		for (Parameter parameter : complementMatch.getRule().getParameters()) {
			Object value = complementMatch.getParameterValue(parameter);
			engine.getScriptEngine().put(parameter.getName(), value);
		}
		
		Iterator<Match> matchFinder = engine.findMatches(
				complementRule.getComplementRule(), graphModelB, complementMatch).iterator();
		
		// TODO: Instead of searching all matches, just filter the domain values of the parameters.
//		while (matchFinder.hasNext() && (complementPreMatches.size() < 1)) {
		while (matchFinder.hasNext()) {
			Match nextMatch = matchFinder.next();
			
			// Create complement pre-match:
			complementPreMatches.add(nextMatch);
		}
		
		complementPreMatches.trimToSize();
		return complementPreMatches;
	}
	
	private boolean isAttributeValueChange(ComplementRule complementRule, Match complementMatch) {
		for (GraphElement complementingChange : complementRule.getComplementingChanges()) {
			if (complementingChange instanceof Attribute) {
				Parameter parameter = complementMatch.getRule().getParameter(((Attribute) complementingChange).getValue());

				if (parameter != null) {
					return true;
				}
			}
		}
		return false;
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
	
	public Edit2RecognitionMatch getMatchConverter() {
		return matchConverter;
	}
}
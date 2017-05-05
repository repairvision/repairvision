package org.sidiff.editrule.partialmatcher.complement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.henshin.ChangePatternUtil;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.editrule.partialmatcher.PartialEditRuleRecognizer;
import org.sidiff.editrule.partialmatcher.pattern.RecognitionPattern;
import org.sidiff.graphpattern.common.algorithms.IAlgorithm;
import org.sidiff.graphpattern.matcher.IMatching;
import org.sidiff.graphpattern.util.GraphPatternConstants;
import org.sidiff.repair.api.matching.EOMatch;
import org.sidiff.repair.api.util.RepairAPIUtil;
import org.sidiff.repair.complement.construction.ComplementConstructor;
import org.sidiff.repair.complement.construction.ComplementRule;

/**
 * Tries to find all complementing operation for a given edit-rule and a model difference. 
 * 
 * @author Manuel Ohrndorf
 */
public class ComplementFinder implements IAlgorithm {

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
	public ComplementFinder(Resource modelAResource, Resource modelBResource, SymmetricDifference difference) {
		assert (modelAResource.getResourceSet() == modelBResource.getResourceSet()) 
		&& (modelBResource.getResourceSet() == difference.eResource().getResourceSet());
		
		this.graphModelB = new EGraphImpl(modelBResource);
		this.engine = new EngineImpl();
		
		this.partialEditRuleRecognizer = new PartialEditRuleRecognizer();
		this.partialEditRuleRecognizer.initialize(difference);
		
		this.matchConverter = new Edit2RecognitionMatch(difference);
	}
	
	@Override
	public void start() {
		this.partialEditRuleRecognizer.start();
	}

	@Override
	public void finish() {
		this.partialEditRuleRecognizer.finish();
	}
	
	/**
	 * @param editRule
	 *            The partially executed edit-rule.
	 * @return All complementing operations for the given edit-rule.
	 */
	public List<ComplementRule> searchComplementRules(Rule editRule) {
		
		//// Lifting ////

		//Matching:
		RecognitionPattern recognitionPattern = partialEditRuleRecognizer.createRecognitionPattern(editRule);
		Iterator<IMatching> matchIterator = partialEditRuleRecognizer.recognizePartialEditRule(recognitionPattern);
		
		// Save recognition-rule:
		if (saveRecognitionRule) {
			ChangePatternUtil.saveGraphPattern(RepairAPIUtil.getRecognitionRuleURI(
					editRule.eResource().getURI(), GraphPatternConstants.FILE_EXTENSION),
					recognitionPattern.getGraphPattern());
		}

		//// Complement Construction ////
		ComplementConstructor complementConstructor = 
				new ContextComplementConstructor(editRule, engine, graphModelB);

		List<ComplementRule> complements = new ArrayList<>(); 

		// Find partially executed edit-operations:
		while(matchIterator.hasNext()) {
			IMatching matching = matchIterator.next();
			
			// Translate: Create partial edit-rule match from recognition-rule match:
			List<EOMatch> editRuleMatch = matchConverter.createEditRuleMatch(recognitionPattern, matching);
			
			// Store new complement rule:
			if (!editRuleMatch.isEmpty()) {
				ComplementRule complementRule = complementConstructor.createComplementRule(editRuleMatch);
				
				if (complementRule != null) {
					complements.add(complementRule);
				}
			}
		}

		//// Initialize the Complement Transformation Engine /////
		for (ComplementRule complementRule : complements) {
			complementRule.initialize(engine, graphModelB);
		}
		
		return complements;
	}
	
	public boolean isSaveRecognitionRule() {
		return saveRecognitionRule;
	}

	public void setSaveRecognitionRule(boolean saveRecognitionRule) {
		this.saveRecognitionRule = saveRecognitionRule;
	}
}
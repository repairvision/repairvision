package org.sidiff.consistency.repair.complement.peo.finder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.graphpattern.GraphPattern;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.repair.api.matching.EOMatch;
import org.sidiff.consistency.repair.complement.construction.ComplementConstructor;
import org.sidiff.consistency.repair.complement.construction.ComplementRule;
import org.sidiff.consistency.repair.complement.peo.construction.ContextComplementConstructor;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.symmetric.SymmetricPackage;
import org.sidiff.graphpattern.matcher.IPatternMatchingEngine;
import org.sidiff.graphpattern.matcher.IPatternMatchingEngineFactory;
import org.sidiff.graphpattern.matching.IMatchGenerator;
import org.sidiff.graphpattern.matching.IMatching;

/**
 * Tries to find all complementing operation for a given edit-rule and a model difference. 
 * 
 * @author Manuel Ohrndorf
 */
public abstract class ComplementFinder {

	/**
	 * The (Henshin) engine which applies the rules.
	 */
	private EngineImpl engine;

	/**
	 * The working graph, i.e. the actual version of the model.
	 */
	private EGraph graphModelB;

	/**
	 * The resource set which contains model A / B and the difference.
	 */
	private ResourceSet modelDifference;
	
	/**
	 * Converts an recognition to an edit rule match.
	 */
	private Edit2RecognitionMatch matchConverter;

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
		this.modelDifference = difference.eResource().getResourceSet();
		this.engine = new EngineImpl();
		this.matchConverter = new Edit2RecognitionMatch(difference);
	}
	
	/**
	 * @param editRule
	 *            The partially executed edit-rule.
	 * @return All complementing operations for the given edit-rule.
	 */
	public List<ComplementRule> searchComplementRules(Rule editRule) {

		//// Edit to Recognition ////
		Edit2RecognitionRule edit2Recognition = new Edit2RecognitionRule(editRule);
		GraphPattern recognitionRule = edit2Recognition.getRecognitionRule();
		removeSymmetricDifferenceNode(recognitionRule);
		
		//// Lifting ////

		// Create working graph:
		IPatternMatchingEngine<IMatching> matchingEngine = getEngineFactory().
				createPatternMatchingEngine(recognitionRule, modelDifference);
		matchingEngine.start();

		//Matching:
		IMatchGenerator<IMatching> matchGenerator = matchingEngine.getMatchGenerator();
		Iterator<IMatching> matchIterator = matchGenerator.getResults();

		//// Complement Construction ////
		ComplementConstructor complementConstructor = 
				new ContextComplementConstructor(editRule, engine, graphModelB);

		List<ComplementRule> complements = new ArrayList<>(); 

		// Find partially executed edit-operations:
		while(matchIterator.hasNext()) {
			IMatching matching = matchIterator.next();
			
			// Translate: Create partial edit-rule match from recognition-rule match:
			List<EOMatch> editRuleMatch = matchConverter.createEditRuleMatch(edit2Recognition, matching);
			
			// Store new complement rule:
			if (!editRuleMatch.isEmpty()) {
				ComplementRule complementRule = complementConstructor.createComplementRule(editRuleMatch);
				
				if (complementRule != null) {
					complements.add(complementRule);
				}
			}
		}
		
		// Clean up matching engine:
		matchingEngine.finish();

		//// Initialize the Complement Transformation Engine /////
		for (ComplementRule complementRule : complements) {
			complementRule.initialize(engine, graphModelB);
		}
		
		return complements;
	}

	private void removeSymmetricDifferenceNode(GraphPattern recognitionRule) {
		
		for (Iterator<NodePattern> iterator = recognitionRule.getNodes().iterator(); iterator.hasNext();) {
			NodePattern node = iterator.next();
			
			if (node.getType() == SymmetricPackage.eINSTANCE.getSymmetricDifference()) {
				iterator.remove();
			}
		}
	}
	
	protected abstract IPatternMatchingEngineFactory<IMatching> getEngineFactory();
}
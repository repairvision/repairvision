package org.sidiff.repair.history.editrules.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.consistency.common.emf.DocumentType;
import org.sidiff.correspondences.CorrespondencesUtil;
import org.sidiff.correspondences.matchingmodel.MatchingModelCorrespondences;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.technical.api.TechnicalDifferenceFacade;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.difference.technical.api.util.TechnicalDifferenceUtils;
import org.sidiff.matching.api.util.MatchingUtils;
import org.sidiff.repair.history.editrules.learning.LearnEditRule;
import org.sidiff.repair.historymodel.History;
import org.sidiff.repair.historymodel.Version;
import org.sidiff.validation.constraint.api.ValidationFacade;
import org.sidiff.validation.constraint.api.util.RequiredValidation;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionNode;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.scope.ScopeNode;
import org.sidiff.validation.constraint.interpreter.scope.ScopeRecorder;

public class HistoryEditRuleGenerator {
	
	/**
	 * Needs at least one sub-rule change to be complemented!
	 */
	protected static final int MIN_EDIT_RULE_SICE = 2;

	protected History history;
	
	protected List<EditRule> rulebase = new ArrayList<>();
	
	public HistoryEditRuleGenerator(History history) {
		this.history = history;
	}
	
	public void analyzeHistory() {
		for (int i = 0; i < history.getVersions().size() - 1; i++) {
			Version vA = history.getVersions().get(i);
			Version vB = history.getVersions().get(i + 1);
			
			try {
				
				// Calculate difference:
				DifferenceSettings diffSettings =  new DifferenceSettings(
						Collections.singleton(DocumentType.getDocumentType(vA)));
//				diffSettings.setTechBuilder(TechnicalDifferenceUtils.getGenericTechnicalDifferenceBuilder());
				diffSettings.setTechBuilder(TechnicalDifferenceUtils.getTechnicalDifferenceBuilder(
						"org.sidiff.ecore.difference.technical.TechnicalDifferenceBuilderEcore"));
				diffSettings.setMatcher(MatchingUtils.getMatcherByKey(
						"EMFCompareMatcherAdapter"));
				diffSettings.setCorrespondencesService(CorrespondencesUtil.getAvailableCorrespondencesService(
						MatchingModelCorrespondences.SERVICE_ID));
				
				SymmetricDifference difference = TechnicalDifferenceFacade.deriveTechnicalDifference(
						vA.getModel(), vB.getModel(), diffSettings);
				
				// Validation:
				List<RequiredValidation[]> validationPairs = findValidationPairs(difference);
				
				// Learn edit-rules:
				for (RequiredValidation[] validationPair : validationPairs) {
					List<EditRule> editRules = calculateEditRules(difference, validationPair);
					
//					System.out.println();
//					System.out.println("## " + validationPair[0].getRule().getName() + " ##");
//					System.out.println(validationPair[0].getRequiredTree());
//					System.out.println();
//					System.out.println(validationPair[1].getRequiredTree());
					
					for (EditRule editRule : editRules) {
						integrateIntoRulebase(editRule );
					}
				}
			} catch (InvalidModelException | NoCorrespondencesException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("\nFinished Edit-Rule Generation!");
	}
	
	protected List<RequiredValidation[]> findValidationPairs(SymmetricDifference difference) 
			throws InvalidModelException, NoCorrespondencesException {
		
		System.out.println("================================================================================");
		System.out.println("=============================== ANALYZE HISTORY ================================");
		System.out.println("================================================================================");
		System.out.println("Model A: " + difference.getModelA().getURI());
		System.out.println("Model B: " + difference.getModelB().getURI());
		
		// Calculate all validation scopes:
		List<RequiredValidation> consistencyVA = ValidationFacade.analyzeRequirements(difference.getModelA());
		List<RequiredValidation> consistencyVB = ValidationFacade.analyzeRequirements(difference.getModelB());
		
//		for (RequiredValidation requiredValidation : consistencyVA) {
//			System.out.println();
//			System.out.println("## " + requiredValidation.getRule().getName() + " ##");
//			System.out.println(requiredValidation.getRequiredTree());
//		}
//		
//		for (RequiredValidation requiredValidation : consistencyVB) {
//			System.out.println();
//			System.out.println("## " + requiredValidation.getRule().getName() + " ##");
//			System.out.println(requiredValidation.getRequiredTree());
//		}
				
		// Find history validation pairs:
		List<RequiredValidation[]> validations = new ArrayList<>();
		
		for (RequiredValidation requiredA : consistencyVA) {
			EObject contextA = requiredA.getContext();
			EObject contextB = difference.getCorrespondingObjectInB(contextA);
			
			for (RequiredValidation requiredB : consistencyVB) {
				if (requiredB.getContext() == contextB) {
					RequiredValidation[] validationPair = {requiredA, requiredB};
					validations.add(validationPair);
				}
			}
		}
		
		// Create non corresponding validations:
		// TODO: Variation: Only if context is non corresponding.
		// NOTE: Use all validation - regardless whether the context is corresponding or not.
		//       - Can create create/remove rules even if no changes have been applied.
		for (RequiredValidation requiredA : consistencyVA) {
			RequiredValidation[] validationPair = {requiredA, null};
			validations.add(validationPair);
		}
		
		for (RequiredValidation requiredB : consistencyVB) {
			RequiredValidation[] validationPair = {null, requiredB};
			validations.add(validationPair);
		}
		
		return validations;
	}
	
	protected List<EditRule> calculateEditRules(SymmetricDifference difference, RequiredValidation[] validationPair) {
		List<EditRule> editRules = new ArrayList<>();

		// Consistency-Tree to Consistency-Fragments:
		getFragments(validationPair[0]).forEachRemaining(fragmentA -> {
			getFragments(validationPair[1]).forEachRemaining(fragmentB -> {

				String ruleName = LearnEditRule.generateName(getNonEmptyValidation(validationPair));
				EditRule editRule = new EditRule(ruleName, difference, fragmentA, fragmentB);
					
				// NOTE: Needs at least one sub-rule change to be complemented!
				if (editRule.getChangeCount() >= MIN_EDIT_RULE_SICE) {
					editRules.add(editRule);
				}
			});
		});
		
		return editRules;
	}
	
	private RequiredValidation getNonEmptyValidation(RequiredValidation[] validationPair) {
		if (validationPair[0] != null) {
			return validationPair[0];
		} else {
			return validationPair[1];
		}
	}
	
	protected Iterator<IScopeRecorder> getFragments(RequiredValidation validation) {
		
		if (validation == null) {
			return Collections.singleton(IScopeRecorder.DUMMY).iterator();
		} else {
			return new Iterator<IScopeRecorder>() {
				
				Iterator<List<? extends IDecisionNode>> decisions = validation.getRequiredTree().traversal();
				
				@Override
				public IScopeRecorder next() {
					
					if (decisions.hasNext()) {
						List<? extends IDecisionNode> decision = decisions.next();
						
						if (decision.size() == 1) {
							if (decision.get(0) instanceof ScopeNode) {
								return ((ScopeNode) decision.get(0)).getScope();
							} else {
								System.err.println("Scope expected: " + decision.get(0));
								return ScopeRecorder.DUMMY;
							}
						} else {
							// TODO: View on multiple scopes:
							ScopeRecorder scopes = new ScopeRecorder();
							
							for (IDecisionNode decisionNode : decision) {
								if (decisionNode instanceof ScopeNode) {
									scopes.addScope(((ScopeNode) decisionNode).getScope());
								} else {
									System.err.println("Scope expected: " + decisionNode);
								}
							}
							
							return scopes;
						}
					} else {
						throw new NoSuchElementException();
					}
				}
				
				@Override
				public boolean hasNext() {
					return decisions.hasNext();
				}
			};	
		}
	}
	
	protected void integrateIntoRulebase(EditRule editRule) {
	
		if (!containsEditRule(rulebase, editRule)) {
			rulebase.add(editRule);
		}
	}
	
	private boolean containsEditRule(List<EditRule> rulebase, EditRule editRule) {
		
		for (EditRule containedEditRule : rulebase) {
			if (containedEditRule.isEqualEditRule(editRule)) {
				return true;
			}
		}
		
		return false;
	}
	
	protected void storeRulebase(String project, String folder) {
		
		for (EditRule editRule : rulebase) {
			
			System.out.println();
			System.out.println("## " + editRule + " ##");

			for (Change change : editRule.getDifferenceSlice().getChanges()) {
				System.out.println("  " + change);
			}
			
			System.out.println();
			System.out.println("Fragment A:");
			System.out.println();
			System.out.println(editRule.getFragmentA());
			
			System.out.println();
			System.out.println("Fragment B:");
			System.out.println();
			System.out.println(editRule.getFragmentB());
			
			editRule.saveEditRule(LearnEditRule.generateURI(editRule.getName(), history.eResource()));
		}
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}

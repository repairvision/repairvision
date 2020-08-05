package org.sidiff.repair.history.editrules.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.repair.history.editrules.learn.scope.LearnEditRule;
import org.sidiff.repair.history.editrules.util.IterableHistory;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.api.DifferenceFacade;
import org.sidiff.revision.difference.api.registry.DifferenceBuilderRegistry;
import org.sidiff.revision.difference.api.registry.MatcherRegistry;
import org.sidiff.revision.difference.api.settings.DifferenceSettings;
import org.sidiff.revision.impact.changetree.IDecisionNode;
import org.sidiff.revision.impact.changetree.scope.IScopeRecorder;
import org.sidiff.revision.impact.changetree.scope.ScopeNode;
import org.sidiff.revision.impact.changetree.scope.ScopeRecorder;
import org.sidiff.validation.constraint.api.ValidationFacade;
import org.sidiff.validation.constraint.api.util.RequiredValidation;

public class EditRuleGenerator {
	
	/**
	 * Needs at least one sub-rule change to be complemented!
	 */
	protected static final int MIN_EDIT_RULE_SICE = 2;
	
	protected int rulebaseLimit = -1;

	protected List<IEditRule> rulebase = new ArrayList<>();
	
	protected String project;
	
	protected String folder;
	
	public class RulebaseLimitExceededException extends Exception {
		private static final long serialVersionUID = 1L;
	}
	
	public EditRuleGenerator(String project, String folder) {
		this.project = project;
		this.folder = folder;
	}

	public int getRulebaseLimit() {
		return rulebaseLimit;
	}
	
	public void setRulebaseLimit(int rulebaseLimit) {
		this.rulebaseLimit = rulebaseLimit;
	}
	
	public void analyzeHistory(IterableHistory historys, IProgressMonitor monitor) 
			throws RulebaseLimitExceededException {
		
		for (Resource[] history: historys) {
			if (monitor.isCanceled()) {
				break;
			}

			Resource vA = history[0];
			Resource vB = history[1];


			// Calculate difference:
			DifferenceSettings diffSettings =  new DifferenceSettings();
			//				diffSettings.setTechBuilder(TechnicalDifferenceUtils.getGenericTechnicalDifferenceBuilder());
			diffSettings.setTechBuilder(DifferenceBuilderRegistry.getTechnicalDifferenceBuilder(
					"org.sidiff.ecore.difference.technical.TechnicalDifferenceBuilderEcore"));
			diffSettings.setMatcher(MatcherRegistry.getMatcherByKey(
					"EMFCompareMatcherAdapter"));

			Difference difference = DifferenceFacade.difference(vA, vB, diffSettings);

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
			
			monitor.worked(1);
		}
		
		if (!monitor.isCanceled()) {
			System.out.println("\nFinished Edit-Rule Generation!");
		} else {
			System.out.println("\nEdit-Rule Generation Canceled!");
		}
	}
	
	protected List<RequiredValidation[]> findValidationPairs(Difference difference) {
		
		System.out.println("================================================================================");
		System.out.println("=============================== ANALYZE HISTORY ================================");
		System.out.println("================================================================================");
		System.out.println("Model A: " + difference.getModelA().getURI());
		System.out.println("Model B: " + difference.getModelB().getURI());
		
		// Calculate all validation scopes:
		List<RequiredValidation> consistencyVA = ValidationFacade.analyzeRequirements(
				difference.getModelA().getAllContents(), ValidationFacade.getConstraints(difference.getModelA()));
		List<RequiredValidation> consistencyVB = ValidationFacade.analyzeRequirements(
				difference.getModelB().getAllContents(), ValidationFacade.getConstraints(difference.getModelB()));
		
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
	
	protected List<EditRule> calculateEditRules(Difference difference, RequiredValidation[] validationPair) {
		List<EditRule> editRules = new ArrayList<>();

		// Consistency-Tree to Consistency-Fragments:
		getFragments(validationPair[0]).forEachRemaining(fragmentA -> {
			getFragments(validationPair[1]).forEachRemaining(fragmentB -> {

				String ruleName = LearnEditRule.generateName(getNonEmptyValidation(validationPair));
				EditRule editRule = new EditRule(ruleName, difference, fragmentA, fragmentB);
			
				// Store corresponding validation in description:
				String ruleDescription = LearnEditRule.generateDescription(getNonEmptyValidation(validationPair));
				editRule.setDescription(ruleDescription);
						
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
				
				Iterator<List<? extends IDecisionNode>> decisions = validation.getRequiredTree().combinations();
				
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
	
	protected void integrateIntoRulebase(EditRule editRule) throws RulebaseLimitExceededException {
	
		// TODO: Integrate edit rule description!
		
		if (!containsEditRule(rulebase, editRule)) {
			if ((rulebaseLimit == -1) || (rulebase.size() < rulebaseLimit)) {
//				rulebase.add(editRule);
				rulebase.add(new EditRuleProxy(editRule));
				storeEditRule(editRule);
			} else {
				throw new RulebaseLimitExceededException();
			}
		}
	}
	
	private boolean containsEditRule(List<IEditRule> rulebase, EditRule editRule) {
		
		for (IEditRule containedEditRule : rulebase) {
			if (containedEditRule.isEqualEditRule(editRule)) {
				return true;
			}
		}
		
		return false;
	}
	
	protected void storeEditRule(EditRule editRule) {
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

		editRule.saveEditRule(LearnEditRule.getFolder(project + "/" + folder) , editRule.getName(), false);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}

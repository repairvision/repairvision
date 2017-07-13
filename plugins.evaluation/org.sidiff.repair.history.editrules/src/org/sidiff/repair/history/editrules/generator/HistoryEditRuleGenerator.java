package org.sidiff.repair.history.editrules.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.Module;
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
import org.sidiff.repair.history.editrules.learning.DifferenceSlice;
import org.sidiff.repair.history.editrules.learning.LearnEditRule;
import org.sidiff.repair.historymodel.History;
import org.sidiff.repair.historymodel.Version;
import org.sidiff.validation.constraint.api.ValidationFacade;
import org.sidiff.validation.constraint.api.util.RequiredValidation;
import org.sidiff.validation.constraint.interpreter.scope.ScopeNode;

public class HistoryEditRuleGenerator {

	protected History history;
	
	protected List<EditRule> rulebase;
	
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
				
				// TODO: Just for testing! 
//				break;
			} catch (InvalidModelException | NoCorrespondencesException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Finished!");
	}
	
	protected List<RequiredValidation[]> findValidationPairs(SymmetricDifference difference) 
			throws InvalidModelException, NoCorrespondencesException {
		
		System.out.println("================================================================================");
		System.out.println("================================== Validation ==================================");
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
		
		return validations;
	}
	
	protected List<EditRule> calculateEditRules(SymmetricDifference difference, RequiredValidation[] validationPair) {
		List<EditRule> editRules = new ArrayList<>();
		
		// Create change-sets:
		// > Reduce/Split change-sets to minimal consistent changes.
		// > > Alternativen bei der Validierung ermitteln!?
		// > > > Nur positiv validierte Anteile
		// > > > Validierungszweige protokollieren
		// (Optimization:)
		// > Atomic lifting (with dependencies).
		
		// TODO: Consistency-Tree to Consistency-Fragments:
		if ((validationPair[0].getRequiredTree() instanceof ScopeNode) 
				&&(validationPair[0].getRequiredTree() instanceof ScopeNode)) {
			
			ScopeNode scopeA = (ScopeNode) validationPair[0].getRequiredTree();
			ScopeNode scopeB = (ScopeNode) validationPair[1].getRequiredTree();
			
			// "Record" edit-rules:
			LearnEditRule learnEditRule = new LearnEditRule(difference);
			DifferenceSlice differenceSlice = learnEditRule.learnByConsistentChange(
					validationPair[0].getContext(), scopeA.getScope().getScope(), 
					validationPair[1].getContext(), scopeB.getScope().getScope());
			
			if (differenceSlice.getChanges().size() > 2) { // TODO

				System.out.println();
				System.out.println("## " + validationPair[0].getRule().getName() + " ##");
				
				for (Change change : differenceSlice.getChanges()) {
					System.out.println("  " + change);
				}
				
				Module editRule = learnEditRule.generateEditRule(
						validationPair[0].getRule().getName() + "_" + EcoreUtil.generateUUID(),
						differenceSlice);
				
				learnEditRule.saveEditRule(editRule);
			}
		}
		
		
		return editRules;
	}
	
	protected void integrateIntoRulebase(EditRule editRule) {
		
		// Find similar/nested edit-rules:
		// > Make rules as abstract as possible.
		// > reduce to minimal context -> compare change-based.
		
		// Merge matched edit-rules (as concrete as possible):
		// > PACs/Context as alternatives (OR).
		
		rulebase.add(editRule);
	}
	
	protected void storeRulebas(String project, String folder) {
		
		// Create new project:
		
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}

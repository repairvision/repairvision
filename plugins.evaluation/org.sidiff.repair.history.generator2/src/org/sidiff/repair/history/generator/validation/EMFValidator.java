package org.sidiff.repair.history.generator.validation;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.sidiff.historymodel.HistoryModelFactory;
import org.sidiff.historymodel.ValidationError;
import org.sidiff.historymodel.ValidationSeverity;

/**
 * Delegates the validation
 * 
 * to the EMF validation framework.
 * 
 * @author kehrer, cpietsch
 */
public class EMFValidator extends BasicValidation {
	
	private static final int DOCTYPE_UML = 1;
	
	private static final int DOCTYPE_ECORE = 2;
	
	private int docType = 0;
	
	@Override
	public Collection<ValidationError> validate(Resource resource) {
		docType = getDocumentTyp(resource);
		assert (docType != 0);
		
		Collection<ValidationError> inconsistencies = new ArrayList<ValidationError>();

		for (EObject rootElement : resource.getContents()) {
			validate(rootElement, inconsistencies);
		}
		
		return inconsistencies;
	}
	
	private void validate(EObject rootElement, Collection<ValidationError> inconsistencies) {
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(rootElement);
		
		for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
			if ((childDiagnostic.getSeverity() == Diagnostic.ERROR)
					|| (childDiagnostic.getSeverity() == Diagnostic.WARNING)) {
				
				ValidationError validationError = HistoryModelFactory.eINSTANCE.createValidationError();
				validationError.setMessage(childDiagnostic.getMessage());
				validationError.setSource(childDiagnostic.getSource());
				
				if (childDiagnostic.getSeverity() == Diagnostic.ERROR) {
					validationError.setSeverity(ValidationSeverity.ERROR);
				} else if (childDiagnostic.getSeverity() == Diagnostic.WARNING) {
					validationError.setSeverity(ValidationSeverity.WARNING);
				} else {
					validationError.setSeverity(ValidationSeverity.UNKNOWN);
				}
				
				String name = childDiagnostic.getMessage().replaceAll("'.*?'", "").trim();
				name = name.replaceAll("\\s.[^\\s]*@.*?\\s", "");
				
				while (name.contains(" ")) {
					int index = name.indexOf(" ");
					name = name.replace(name.substring(index, index + 2),
							name.substring(index + 1, index + 2).toUpperCase());
				}
				name = name.replaceAll("[^\\p{Alpha}]", "");
				validationError.setName(name);
				
				for (Object obj : childDiagnostic.getData()) {
					if (obj instanceof EObject) {
						validationError.getInvalidElement().add((EObject) obj);
					}
				}
				
				validationError.setContext(getContextElement(validationError));
				inconsistencies.add(validationError);
			}
		}
	}
	
	private int getDocumentTyp(Resource resource) {
		if (resource instanceof UMLResource) {
			return DOCTYPE_UML;
		}
		if (resource.getURI().lastSegment().endsWith("ecore")) {
			return DOCTYPE_ECORE;
		}
		return 0;
	}
	
	@Override
	public boolean matchValidationError(ValidationError validationErrorA, ValidationError validationErrorB) {
		return super.matchValidationError(validationErrorA, validationErrorB);
	}
	
	@Override
	public EObject getContextElement(ValidationError validationError) {
		
		if (validationError.getContext() == null) {
			
			// Only one invalid element:
			EObject context = validationError.getInvalidElement().get(0);
			
			// Filter meta-features:
			for (EObject invalidElement : validationError.getInvalidElement()) {
				if ((invalidElement != context) && (context.eResource() == invalidElement.eResource())) {
					context = null;
					break;
				}
			}
			
			if (context != null) {
				return context;
			}
			
			// Configure context element:
			if (docType == DOCTYPE_ECORE) {
				switch (validationError.getName()) {
					case "AContainmentReferenceOfATypeWithAContainerFeaturethatRequiresInstancesToBeContainedElsewhereCannotBePopulated":
						return validationError.getInvalidElement().get(0); // EReference containment
					case "ThereMayNotBeAnOperationWithTheSameSignatureAsAnAccessorMethodForFeature":
						return validationError.getInvalidElement().get(1); // EOperation operation
					case "ThereMayNotBeTwoClassifiersNamed":
						return validationError.getInvalidElement().get(1); // EClassifier duplicated
					case "TheGenericTypeIsNotAValidSubstitutionForTypeParameter":
						return validationError.getInvalidElement().get(1); // EGenericType typeSubstitution
					case "TheFeaturesAndCannotBothBeIDs":
						return validationError.getInvalidElement().get(1); // EAttribute duplicatedID
					case "ThereMayNotBeTwoFeaturesNamed":
						return validationError.getInvalidElement().get(2); // EStructuralFeature duplicated
					case "ThereShouldNotBeAFeatureNamedAsWellAFeatureNamed":
						return validationError.getInvalidElement().get(1); // EStructuralFeature duplicated (e.g. a, A, A_)
					case "ThereMayNotBeTwoOperationsAndWithTheSameSignature":
						return validationError.getInvalidElement().get(1); // EOperation duplicated
					case "ThereMayNotBeTwoEnumeratorsNamed":
						return validationError.getInvalidElement().get(1); // EEnum duplicated
					case "ThereShouldNotBeAnEnumeratorNamedAsWellAnEnumeratorNamed":
						return validationError.getInvalidElement().get(1); // EEnum duplicated (e.g. a, A, A_)
					case "ThereMayNotBeTwoEnumeratorsWithLiteralValue":
						return validationError.getInvalidElement().get(1); // EEnumLiteral duplicated
					case "ThereMayNotBeTwoParametersNamed":
						return validationError.getInvalidElement().get(1); // EParameter duplicated
					case "ThereMayNotBeTwoTypeParametersNamed":
						return validationError.getInvalidElement().get(1); // ETypeParameter duplicated
					case "ThereMayNotBeTwoPackagesNamed":
						return validationError.getInvalidElement().get(1); // EPackage duplicated
					case "ThereMayNotBeTwoPackagesWithNamespaceURI":
						return validationError.getInvalidElement().get(0); // EPackage duplicated
					case "TheOppositeOfTheOppositeMayNotBeAReferenceDifferentFromThisOne":
						return validationError.getInvalidElement().get(0); // EReference reference
					case "TheOppositeMustBeAFeatureOfTheReferencesType":
						return validationError.getInvalidElement().get(0); // EReference reference
					case "TheOppositeOfATransientReferenceMustBeTransientIfItIsProxyResolving":
						return validationError.getInvalidElement().get(0); // EReference reference
					case "TheOppositeOfAContainmentReferenceMustNotBeAContainmentReference":
						return validationError.getInvalidElement().get(0); // EReference reference
					case "TheGenericSuperTypesAtIndexAndMustNotBeDuplicates":
						return validationError.getInvalidElement().get(1); // EGenericType duplicated
					case "TheGenericSuperTypesInstantiateInconsistently":
						return validationError.getInvalidElement().get(1); // EGenericType inconsistent
					
					case "TheFeatureOfContainsAnUnresolvedProxy":
						return validationError.getInvalidElement().get(0); // ?
					case "TheFeatureHasAMapEntryAtIndexWithAKeyThatCollidesWithThatOfTheMapEntryAtIndex":
						return validationError.getInvalidElement().get(0); // ?
					case "TheKeyMustBeFeatureOfTheReferencesType":
						return validationError.getInvalidElement().get(0); // ?
					default:
						throw new RuntimeException(
								"Please configure the context element of the consistency rule!\n" 
										+ printValidationError(validationError));
				}	
			}
			
			return validationError.getInvalidElement().get(0);
		} else {
			return validationError.getContext();
		}
	}
	
	private String printValidationError(ValidationError validationError) {
		StringBuffer string = new StringBuffer();
		string.append(validationError.getName() + ":\n");
		
		for (EObject invalidElement : validationError.getInvalidElement()) {
			string.append(getObjectID(invalidElement) + ": ");
			string.append(invalidElement + "\n");
		}
		
		return string.toString();
	}
}

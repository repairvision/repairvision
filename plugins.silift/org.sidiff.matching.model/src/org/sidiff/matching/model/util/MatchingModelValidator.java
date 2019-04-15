/**
 */
package org.sidiff.matching.model.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.sidiff.matching.model.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.sidiff.matching.model.MatchingModelPackage
 * @generated
 */
public class MatchingModelValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final MatchingModelValidator INSTANCE = new MatchingModelValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.sidiff.matching.model";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchingModelValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return MatchingModelPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case MatchingModelPackage.CORRESPONDENCE:
				return validateCorrespondence((Correspondence)value, diagnostics, context);
			case MatchingModelPackage.EXTENDABLE_OBJECT:
				return validateExtendableObject((ExtendableObject)value, diagnostics, context);
			case MatchingModelPackage.ESTRING_TO_ESTRING_MAP:
				return validateEStringToEStringMap((Map.Entry<?, ?>)value, diagnostics, context);
			case MatchingModelPackage.MATCHING:
				return validateMatching((Matching)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCorrespondence(Correspondence correspondence, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(correspondence, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(correspondence, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(correspondence, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(correspondence, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(correspondence, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(correspondence, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(correspondence, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(correspondence, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(correspondence, diagnostics, context);
		if (result || diagnostics != null) result &= validateCorrespondence_MissingMatching(correspondence, diagnostics, context);
		if (result || diagnostics != null) result &= validateCorrespondence_MatchedANotInResourceA(correspondence, diagnostics, context);
		if (result || diagnostics != null) result &= validateCorrespondence_MatchedBNotInResourceB(correspondence, diagnostics, context);
		if (result || diagnostics != null) result &= validateCorrespondence_TypeMismatch(correspondence, diagnostics, context);
		if (result || diagnostics != null) result &= validateCorrespondence_ContainerMismatchA(correspondence, diagnostics, context);
		if (result || diagnostics != null) result &= validateCorrespondence_ContainerMismatchB(correspondence, diagnostics, context);
		if (result || diagnostics != null) result &= validateCorrespondence_ContainerCorrespondenceInDifferentMatching(correspondence, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MissingMatching constraint of '<em>Correspondence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCorrespondence_MissingMatching(Correspondence correspondence, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "MissingMatching", getObjectLabel(correspondence, context) },
						 new Object[] { correspondence },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the MatchedANotInResourceA constraint of '<em>Correspondence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCorrespondence_MatchedANotInResourceA(Correspondence correspondence, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "MatchedANotInResourceA", getObjectLabel(correspondence, context) },
						 new Object[] { correspondence },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the MatchedBNotInResourceB constraint of '<em>Correspondence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCorrespondence_MatchedBNotInResourceB(Correspondence correspondence, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "MatchedBNotInResourceB", getObjectLabel(correspondence, context) },
						 new Object[] { correspondence },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the TypeMismatch constraint of '<em>Correspondence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCorrespondence_TypeMismatch(Correspondence correspondence, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "TypeMismatch", getObjectLabel(correspondence, context) },
						 new Object[] { correspondence },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the ContainerMismatchA constraint of '<em>Correspondence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCorrespondence_ContainerMismatchA(Correspondence correspondence, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "ContainerMismatchA", getObjectLabel(correspondence, context) },
						 new Object[] { correspondence },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the ContainerMismatchB constraint of '<em>Correspondence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCorrespondence_ContainerMismatchB(Correspondence correspondence, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "ContainerMismatchB", getObjectLabel(correspondence, context) },
						 new Object[] { correspondence },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the ContainerCorrespondenceInDifferentMatching constraint of '<em>Correspondence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCorrespondence_ContainerCorrespondenceInDifferentMatching(Correspondence correspondence, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "ContainerCorrespondenceInDifferentMatching", getObjectLabel(correspondence, context) },
						 new Object[] { correspondence },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExtendableObject(ExtendableObject extendableObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(extendableObject, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEStringToEStringMap(Map.Entry<?, ?> eStringToEStringMap, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)eStringToEStringMap, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMatching(Matching matching, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(matching, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(matching, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(matching, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(matching, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(matching, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(matching, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(matching, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(matching, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(matching, diagnostics, context);
		if (result || diagnostics != null) result &= validateMatching_UnmatchedANotInResourceA(matching, diagnostics, context);
		if (result || diagnostics != null) result &= validateMatching_UnmatchedBNotInResourceB(matching, diagnostics, context);
		if (result || diagnostics != null) result &= validateMatching_UnhandledElementA(matching, diagnostics, context);
		if (result || diagnostics != null) result &= validateMatching_UnhandledElementB(matching, diagnostics, context);
		return result;
	}

	/**
	 * Validates the UnmatchedANotInResourceA constraint of '<em>Matching</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMatching_UnmatchedANotInResourceA(Matching matching, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "UnmatchedANotInResourceA", getObjectLabel(matching, context) },
						 new Object[] { matching },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the UnmatchedBNotInResourceB constraint of '<em>Matching</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMatching_UnmatchedBNotInResourceB(Matching matching, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "UnmatchedBNotInResourceB", getObjectLabel(matching, context) },
						 new Object[] { matching },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the UnhandledElementA constraint of '<em>Matching</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMatching_UnhandledElementA(Matching matching, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "UnhandledElementA", getObjectLabel(matching, context) },
						 new Object[] { matching },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the UnhandledElementB constraint of '<em>Matching</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMatching_UnhandledElementB(Matching matching, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "UnhandledElementB", getObjectLabel(matching, context) },
						 new Object[] { matching },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //MatchingModelValidator

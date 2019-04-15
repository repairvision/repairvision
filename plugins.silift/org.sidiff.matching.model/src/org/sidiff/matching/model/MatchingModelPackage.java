/**
 */
package org.sidiff.matching.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.sidiff.matching.model.MatchingModelFactory
 * @model kind="package"
 * @generated
 */
public interface MatchingModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.sidiff.org/matching/model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MatchingModelPackage eINSTANCE = org.sidiff.matching.model.impl.MatchingModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sidiff.matching.model.impl.ExtendableObjectImpl <em>Extendable Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.matching.model.impl.ExtendableObjectImpl
	 * @see org.sidiff.matching.model.impl.MatchingModelPackageImpl#getExtendableObject()
	 * @generated
	 */
	int EXTENDABLE_OBJECT = 1;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDABLE_OBJECT__EXTENSIONS = 0;

	/**
	 * The number of structural features of the '<em>Extendable Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDABLE_OBJECT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.sidiff.matching.model.impl.CorrespondenceImpl <em>Correspondence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.matching.model.impl.CorrespondenceImpl
	 * @see org.sidiff.matching.model.impl.MatchingModelPackageImpl#getCorrespondence()
	 * @generated
	 */
	int CORRESPONDENCE = 0;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRESPONDENCE__EXTENSIONS = EXTENDABLE_OBJECT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Matched A</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRESPONDENCE__MATCHED_A = EXTENDABLE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Matched B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRESPONDENCE__MATCHED_B = EXTENDABLE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Container Correspondence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRESPONDENCE__CONTAINER_CORRESPONDENCE = EXTENDABLE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Containment Correspondences</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRESPONDENCE__CONTAINMENT_CORRESPONDENCES = EXTENDABLE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRESPONDENCE__ECLASS = EXTENDABLE_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Correspondence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRESPONDENCE_FEATURE_COUNT = EXTENDABLE_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.sidiff.matching.model.impl.EStringToEStringMapImpl <em>EString To EString Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.matching.model.impl.EStringToEStringMapImpl
	 * @see org.sidiff.matching.model.impl.MatchingModelPackageImpl#getEStringToEStringMap()
	 * @generated
	 */
	int ESTRING_TO_ESTRING_MAP = 2;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_ESTRING_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_ESTRING_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EString To EString Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_ESTRING_MAP_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.sidiff.matching.model.impl.MatchingImpl <em>Matching</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.matching.model.impl.MatchingImpl
	 * @see org.sidiff.matching.model.impl.MatchingModelPackageImpl#getMatching()
	 * @generated
	 */
	int MATCHING = 3;

	/**
	 * The feature id for the '<em><b>Correspondences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHING__CORRESPONDENCES = 0;

	/**
	 * The feature id for the '<em><b>Unmatched A</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHING__UNMATCHED_A = 1;

	/**
	 * The feature id for the '<em><b>Unmatched B</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHING__UNMATCHED_B = 2;

	/**
	 * The feature id for the '<em><b>EResource A</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHING__ERESOURCE_A = 3;

	/**
	 * The feature id for the '<em><b>EResource B</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHING__ERESOURCE_B = 4;

	/**
	 * The feature id for the '<em><b>Uri A</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHING__URI_A = 5;

	/**
	 * The feature id for the '<em><b>Uri B</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHING__URI_B = 6;

	/**
	 * The number of structural features of the '<em>Matching</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHING_FEATURE_COUNT = 7;

	/**
	 * Returns the meta object for class '{@link org.sidiff.matching.model.Correspondence <em>Correspondence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Correspondence</em>'.
	 * @see org.sidiff.matching.model.Correspondence
	 * @generated
	 */
	EClass getCorrespondence();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.matching.model.Correspondence#getMatchedA <em>Matched A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Matched A</em>'.
	 * @see org.sidiff.matching.model.Correspondence#getMatchedA()
	 * @see #getCorrespondence()
	 * @generated
	 */
	EReference getCorrespondence_MatchedA();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.matching.model.Correspondence#getMatchedB <em>Matched B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Matched B</em>'.
	 * @see org.sidiff.matching.model.Correspondence#getMatchedB()
	 * @see #getCorrespondence()
	 * @generated
	 */
	EReference getCorrespondence_MatchedB();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.matching.model.Correspondence#getContainerCorrespondence <em>Container Correspondence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Container Correspondence</em>'.
	 * @see org.sidiff.matching.model.Correspondence#getContainerCorrespondence()
	 * @see #getCorrespondence()
	 * @generated
	 */
	EReference getCorrespondence_ContainerCorrespondence();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.matching.model.Correspondence#getContainmentCorrespondences <em>Containment Correspondences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Containment Correspondences</em>'.
	 * @see org.sidiff.matching.model.Correspondence#getContainmentCorrespondences()
	 * @see #getCorrespondence()
	 * @generated
	 */
	EReference getCorrespondence_ContainmentCorrespondences();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.matching.model.Correspondence#getEClass <em>EClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EClass</em>'.
	 * @see org.sidiff.matching.model.Correspondence#getEClass()
	 * @see #getCorrespondence()
	 * @generated
	 */
	EReference getCorrespondence_EClass();

	/**
	 * Returns the meta object for class '{@link org.sidiff.matching.model.ExtendableObject <em>Extendable Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extendable Object</em>'.
	 * @see org.sidiff.matching.model.ExtendableObject
	 * @generated
	 */
	EClass getExtendableObject();

	/**
	 * Returns the meta object for the map '{@link org.sidiff.matching.model.ExtendableObject#getExtensions <em>Extensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Extensions</em>'.
	 * @see org.sidiff.matching.model.ExtendableObject#getExtensions()
	 * @see #getExtendableObject()
	 * @generated
	 */
	EReference getExtendableObject_Extensions();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EString To EString Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EString To EString Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true" keyOrdered="false"
	 *        valueDataType="org.eclipse.emf.ecore.EString" valueRequired="true" valueOrdered="false"
	 * @generated
	 */
	EClass getEStringToEStringMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToEStringMap()
	 * @generated
	 */
	EAttribute getEStringToEStringMap_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToEStringMap()
	 * @generated
	 */
	EAttribute getEStringToEStringMap_Value();

	/**
	 * Returns the meta object for class '{@link org.sidiff.matching.model.Matching <em>Matching</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Matching</em>'.
	 * @see org.sidiff.matching.model.Matching
	 * @generated
	 */
	EClass getMatching();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.matching.model.Matching#getCorrespondences <em>Correspondences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Correspondences</em>'.
	 * @see org.sidiff.matching.model.Matching#getCorrespondences()
	 * @see #getMatching()
	 * @generated
	 */
	EReference getMatching_Correspondences();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.matching.model.Matching#getUnmatchedA <em>Unmatched A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Unmatched A</em>'.
	 * @see org.sidiff.matching.model.Matching#getUnmatchedA()
	 * @see #getMatching()
	 * @generated
	 */
	EReference getMatching_UnmatchedA();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.matching.model.Matching#getUnmatchedB <em>Unmatched B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Unmatched B</em>'.
	 * @see org.sidiff.matching.model.Matching#getUnmatchedB()
	 * @see #getMatching()
	 * @generated
	 */
	EReference getMatching_UnmatchedB();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.matching.model.Matching#getEResourceA <em>EResource A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EResource A</em>'.
	 * @see org.sidiff.matching.model.Matching#getEResourceA()
	 * @see #getMatching()
	 * @generated
	 */
	EAttribute getMatching_EResourceA();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.matching.model.Matching#getEResourceB <em>EResource B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EResource B</em>'.
	 * @see org.sidiff.matching.model.Matching#getEResourceB()
	 * @see #getMatching()
	 * @generated
	 */
	EAttribute getMatching_EResourceB();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.matching.model.Matching#getUriA <em>Uri A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri A</em>'.
	 * @see org.sidiff.matching.model.Matching#getUriA()
	 * @see #getMatching()
	 * @generated
	 */
	EAttribute getMatching_UriA();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.matching.model.Matching#getUriB <em>Uri B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri B</em>'.
	 * @see org.sidiff.matching.model.Matching#getUriB()
	 * @see #getMatching()
	 * @generated
	 */
	EAttribute getMatching_UriB();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MatchingModelFactory getMatchingModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.sidiff.matching.model.impl.CorrespondenceImpl <em>Correspondence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.matching.model.impl.CorrespondenceImpl
		 * @see org.sidiff.matching.model.impl.MatchingModelPackageImpl#getCorrespondence()
		 * @generated
		 */
		EClass CORRESPONDENCE = eINSTANCE.getCorrespondence();

		/**
		 * The meta object literal for the '<em><b>Matched A</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORRESPONDENCE__MATCHED_A = eINSTANCE.getCorrespondence_MatchedA();

		/**
		 * The meta object literal for the '<em><b>Matched B</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORRESPONDENCE__MATCHED_B = eINSTANCE.getCorrespondence_MatchedB();

		/**
		 * The meta object literal for the '<em><b>Container Correspondence</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORRESPONDENCE__CONTAINER_CORRESPONDENCE = eINSTANCE.getCorrespondence_ContainerCorrespondence();

		/**
		 * The meta object literal for the '<em><b>Containment Correspondences</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORRESPONDENCE__CONTAINMENT_CORRESPONDENCES = eINSTANCE.getCorrespondence_ContainmentCorrespondences();

		/**
		 * The meta object literal for the '<em><b>EClass</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORRESPONDENCE__ECLASS = eINSTANCE.getCorrespondence_EClass();

		/**
		 * The meta object literal for the '{@link org.sidiff.matching.model.impl.ExtendableObjectImpl <em>Extendable Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.matching.model.impl.ExtendableObjectImpl
		 * @see org.sidiff.matching.model.impl.MatchingModelPackageImpl#getExtendableObject()
		 * @generated
		 */
		EClass EXTENDABLE_OBJECT = eINSTANCE.getExtendableObject();

		/**
		 * The meta object literal for the '<em><b>Extensions</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDABLE_OBJECT__EXTENSIONS = eINSTANCE.getExtendableObject_Extensions();

		/**
		 * The meta object literal for the '{@link org.sidiff.matching.model.impl.EStringToEStringMapImpl <em>EString To EString Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.matching.model.impl.EStringToEStringMapImpl
		 * @see org.sidiff.matching.model.impl.MatchingModelPackageImpl#getEStringToEStringMap()
		 * @generated
		 */
		EClass ESTRING_TO_ESTRING_MAP = eINSTANCE.getEStringToEStringMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTRING_TO_ESTRING_MAP__KEY = eINSTANCE.getEStringToEStringMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTRING_TO_ESTRING_MAP__VALUE = eINSTANCE.getEStringToEStringMap_Value();

		/**
		 * The meta object literal for the '{@link org.sidiff.matching.model.impl.MatchingImpl <em>Matching</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.matching.model.impl.MatchingImpl
		 * @see org.sidiff.matching.model.impl.MatchingModelPackageImpl#getMatching()
		 * @generated
		 */
		EClass MATCHING = eINSTANCE.getMatching();

		/**
		 * The meta object literal for the '<em><b>Correspondences</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCHING__CORRESPONDENCES = eINSTANCE.getMatching_Correspondences();

		/**
		 * The meta object literal for the '<em><b>Unmatched A</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCHING__UNMATCHED_A = eINSTANCE.getMatching_UnmatchedA();

		/**
		 * The meta object literal for the '<em><b>Unmatched B</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCHING__UNMATCHED_B = eINSTANCE.getMatching_UnmatchedB();

		/**
		 * The meta object literal for the '<em><b>EResource A</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCHING__ERESOURCE_A = eINSTANCE.getMatching_EResourceA();

		/**
		 * The meta object literal for the '<em><b>EResource B</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCHING__ERESOURCE_B = eINSTANCE.getMatching_EResourceB();

		/**
		 * The meta object literal for the '<em><b>Uri A</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCHING__URI_A = eINSTANCE.getMatching_UriA();

		/**
		 * The meta object literal for the '<em><b>Uri B</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCHING__URI_B = eINSTANCE.getMatching_UriB();

	}

} //MatchingModelPackage

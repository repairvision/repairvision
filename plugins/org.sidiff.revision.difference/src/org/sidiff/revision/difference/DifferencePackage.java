/**
 */
package org.sidiff.revision.difference;

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
 * @see org.sidiff.revision.difference.DifferenceFactory
 * @model kind="package"
 * @generated
 */
public interface DifferencePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "difference";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.sidiff.org/revision/difference/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "difference";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DifferencePackage eINSTANCE = org.sidiff.revision.difference.impl.DifferencePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sidiff.revision.difference.impl.DifferenceImpl <em>Difference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.difference.impl.DifferenceImpl
	 * @see org.sidiff.revision.difference.impl.DifferencePackageImpl#getDifference()
	 * @generated
	 */
	int DIFFERENCE = 0;

	/**
	 * The feature id for the '<em><b>Changes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENCE__CHANGES = 0;

	/**
	 * The feature id for the '<em><b>Correspondences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENCE__CORRESPONDENCES = 1;

	/**
	 * The feature id for the '<em><b>Uri Model A</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENCE__URI_MODEL_A = 2;

	/**
	 * The feature id for the '<em><b>Uri Model B</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENCE__URI_MODEL_B = 3;

	/**
	 * The feature id for the '<em><b>Model A</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENCE__MODEL_A = 4;

	/**
	 * The feature id for the '<em><b>Model B</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENCE__MODEL_B = 5;

	/**
	 * The number of structural features of the '<em>Difference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENCE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.difference.impl.CorrespondenceImpl <em>Correspondence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.difference.impl.CorrespondenceImpl
	 * @see org.sidiff.revision.difference.impl.DifferencePackageImpl#getCorrespondence()
	 * @generated
	 */
	int CORRESPONDENCE = 1;

	/**
	 * The feature id for the '<em><b>Matched A</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRESPONDENCE__MATCHED_A = 0;

	/**
	 * The feature id for the '<em><b>Matched B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRESPONDENCE__MATCHED_B = 1;

	/**
	 * The number of structural features of the '<em>Correspondence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRESPONDENCE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.difference.impl.ChangeImpl <em>Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.difference.impl.ChangeImpl
	 * @see org.sidiff.revision.difference.impl.DifferencePackageImpl#getChange()
	 * @generated
	 */
	int CHANGE = 2;

	/**
	 * The number of structural features of the '<em>Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.difference.impl.AddObjectImpl <em>Add Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.difference.impl.AddObjectImpl
	 * @see org.sidiff.revision.difference.impl.DifferencePackageImpl#getAddObject()
	 * @generated
	 */
	int ADD_OBJECT = 3;

	/**
	 * The feature id for the '<em><b>Obj</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_OBJECT__OBJ = CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Add Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_OBJECT_FEATURE_COUNT = CHANGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.difference.impl.RemoveObjectImpl <em>Remove Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.difference.impl.RemoveObjectImpl
	 * @see org.sidiff.revision.difference.impl.DifferencePackageImpl#getRemoveObject()
	 * @generated
	 */
	int REMOVE_OBJECT = 4;

	/**
	 * The feature id for the '<em><b>Obj</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_OBJECT__OBJ = CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Remove Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_OBJECT_FEATURE_COUNT = CHANGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.difference.impl.AddReferenceImpl <em>Add Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.difference.impl.AddReferenceImpl
	 * @see org.sidiff.revision.difference.impl.DifferencePackageImpl#getAddReference()
	 * @generated
	 */
	int ADD_REFERENCE = 5;

	/**
	 * The feature id for the '<em><b>Src</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_REFERENCE__SRC = CHANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tgt</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_REFERENCE__TGT = CHANGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_REFERENCE__TYPE = CHANGE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Add Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_REFERENCE_FEATURE_COUNT = CHANGE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.difference.impl.RemoveReferenceImpl <em>Remove Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.difference.impl.RemoveReferenceImpl
	 * @see org.sidiff.revision.difference.impl.DifferencePackageImpl#getRemoveReference()
	 * @generated
	 */
	int REMOVE_REFERENCE = 6;

	/**
	 * The feature id for the '<em><b>Src</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_REFERENCE__SRC = CHANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tgt</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_REFERENCE__TGT = CHANGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_REFERENCE__TYPE = CHANGE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Remove Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_REFERENCE_FEATURE_COUNT = CHANGE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.sidiff.revision.difference.impl.AttributeValueChangeImpl <em>Attribute Value Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.revision.difference.impl.AttributeValueChangeImpl
	 * @see org.sidiff.revision.difference.impl.DifferencePackageImpl#getAttributeValueChange()
	 * @generated
	 */
	int ATTRIBUTE_VALUE_CHANGE = 7;

	/**
	 * The feature id for the '<em><b>Obj A</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CHANGE__OBJ_A = CHANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Obj B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CHANGE__OBJ_B = CHANGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CHANGE__TYPE = CHANGE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Attribute Value Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CHANGE_FEATURE_COUNT = CHANGE_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.difference.Difference <em>Difference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Difference</em>'.
	 * @see org.sidiff.revision.difference.Difference
	 * @generated
	 */
	EClass getDifference();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.revision.difference.Difference#getChanges <em>Changes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Changes</em>'.
	 * @see org.sidiff.revision.difference.Difference#getChanges()
	 * @see #getDifference()
	 * @generated
	 */
	EReference getDifference_Changes();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.revision.difference.Difference#getUriModelA <em>Uri Model A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri Model A</em>'.
	 * @see org.sidiff.revision.difference.Difference#getUriModelA()
	 * @see #getDifference()
	 * @generated
	 */
	EAttribute getDifference_UriModelA();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.revision.difference.Difference#getUriModelB <em>Uri Model B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri Model B</em>'.
	 * @see org.sidiff.revision.difference.Difference#getUriModelB()
	 * @see #getDifference()
	 * @generated
	 */
	EAttribute getDifference_UriModelB();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.revision.difference.Difference#getModelA <em>Model A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model A</em>'.
	 * @see org.sidiff.revision.difference.Difference#getModelA()
	 * @see #getDifference()
	 * @generated
	 */
	EAttribute getDifference_ModelA();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.revision.difference.Difference#getModelB <em>Model B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model B</em>'.
	 * @see org.sidiff.revision.difference.Difference#getModelB()
	 * @see #getDifference()
	 * @generated
	 */
	EAttribute getDifference_ModelB();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.revision.difference.Difference#getCorrespondences <em>Correspondences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Correspondences</em>'.
	 * @see org.sidiff.revision.difference.Difference#getCorrespondences()
	 * @see #getDifference()
	 * @generated
	 */
	EReference getDifference_Correspondences();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.difference.Correspondence <em>Correspondence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Correspondence</em>'.
	 * @see org.sidiff.revision.difference.Correspondence
	 * @generated
	 */
	EClass getCorrespondence();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.revision.difference.Correspondence#getMatchedA <em>Matched A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Matched A</em>'.
	 * @see org.sidiff.revision.difference.Correspondence#getMatchedA()
	 * @see #getCorrespondence()
	 * @generated
	 */
	EReference getCorrespondence_MatchedA();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.revision.difference.Correspondence#getMatchedB <em>Matched B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Matched B</em>'.
	 * @see org.sidiff.revision.difference.Correspondence#getMatchedB()
	 * @see #getCorrespondence()
	 * @generated
	 */
	EReference getCorrespondence_MatchedB();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.difference.Change <em>Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Change</em>'.
	 * @see org.sidiff.revision.difference.Change
	 * @generated
	 */
	EClass getChange();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.difference.AddObject <em>Add Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Object</em>'.
	 * @see org.sidiff.revision.difference.AddObject
	 * @generated
	 */
	EClass getAddObject();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.revision.difference.AddObject#getObj <em>Obj</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Obj</em>'.
	 * @see org.sidiff.revision.difference.AddObject#getObj()
	 * @see #getAddObject()
	 * @generated
	 */
	EReference getAddObject_Obj();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.difference.RemoveObject <em>Remove Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remove Object</em>'.
	 * @see org.sidiff.revision.difference.RemoveObject
	 * @generated
	 */
	EClass getRemoveObject();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.revision.difference.RemoveObject#getObj <em>Obj</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Obj</em>'.
	 * @see org.sidiff.revision.difference.RemoveObject#getObj()
	 * @see #getRemoveObject()
	 * @generated
	 */
	EReference getRemoveObject_Obj();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.difference.AddReference <em>Add Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Reference</em>'.
	 * @see org.sidiff.revision.difference.AddReference
	 * @generated
	 */
	EClass getAddReference();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.revision.difference.AddReference#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Src</em>'.
	 * @see org.sidiff.revision.difference.AddReference#getSrc()
	 * @see #getAddReference()
	 * @generated
	 */
	EReference getAddReference_Src();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.revision.difference.AddReference#getTgt <em>Tgt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tgt</em>'.
	 * @see org.sidiff.revision.difference.AddReference#getTgt()
	 * @see #getAddReference()
	 * @generated
	 */
	EReference getAddReference_Tgt();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.revision.difference.AddReference#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.sidiff.revision.difference.AddReference#getType()
	 * @see #getAddReference()
	 * @generated
	 */
	EReference getAddReference_Type();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.difference.RemoveReference <em>Remove Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remove Reference</em>'.
	 * @see org.sidiff.revision.difference.RemoveReference
	 * @generated
	 */
	EClass getRemoveReference();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.revision.difference.RemoveReference#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Src</em>'.
	 * @see org.sidiff.revision.difference.RemoveReference#getSrc()
	 * @see #getRemoveReference()
	 * @generated
	 */
	EReference getRemoveReference_Src();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.revision.difference.RemoveReference#getTgt <em>Tgt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tgt</em>'.
	 * @see org.sidiff.revision.difference.RemoveReference#getTgt()
	 * @see #getRemoveReference()
	 * @generated
	 */
	EReference getRemoveReference_Tgt();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.revision.difference.RemoveReference#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.sidiff.revision.difference.RemoveReference#getType()
	 * @see #getRemoveReference()
	 * @generated
	 */
	EReference getRemoveReference_Type();

	/**
	 * Returns the meta object for class '{@link org.sidiff.revision.difference.AttributeValueChange <em>Attribute Value Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Value Change</em>'.
	 * @see org.sidiff.revision.difference.AttributeValueChange
	 * @generated
	 */
	EClass getAttributeValueChange();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.revision.difference.AttributeValueChange#getObjA <em>Obj A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Obj A</em>'.
	 * @see org.sidiff.revision.difference.AttributeValueChange#getObjA()
	 * @see #getAttributeValueChange()
	 * @generated
	 */
	EReference getAttributeValueChange_ObjA();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.revision.difference.AttributeValueChange#getObjB <em>Obj B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Obj B</em>'.
	 * @see org.sidiff.revision.difference.AttributeValueChange#getObjB()
	 * @see #getAttributeValueChange()
	 * @generated
	 */
	EReference getAttributeValueChange_ObjB();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.revision.difference.AttributeValueChange#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.sidiff.revision.difference.AttributeValueChange#getType()
	 * @see #getAttributeValueChange()
	 * @generated
	 */
	EReference getAttributeValueChange_Type();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DifferenceFactory getDifferenceFactory();

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
		 * The meta object literal for the '{@link org.sidiff.revision.difference.impl.DifferenceImpl <em>Difference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.difference.impl.DifferenceImpl
		 * @see org.sidiff.revision.difference.impl.DifferencePackageImpl#getDifference()
		 * @generated
		 */
		EClass DIFFERENCE = eINSTANCE.getDifference();

		/**
		 * The meta object literal for the '<em><b>Changes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIFFERENCE__CHANGES = eINSTANCE.getDifference_Changes();

		/**
		 * The meta object literal for the '<em><b>Uri Model A</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIFFERENCE__URI_MODEL_A = eINSTANCE.getDifference_UriModelA();

		/**
		 * The meta object literal for the '<em><b>Uri Model B</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIFFERENCE__URI_MODEL_B = eINSTANCE.getDifference_UriModelB();

		/**
		 * The meta object literal for the '<em><b>Model A</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIFFERENCE__MODEL_A = eINSTANCE.getDifference_ModelA();

		/**
		 * The meta object literal for the '<em><b>Model B</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIFFERENCE__MODEL_B = eINSTANCE.getDifference_ModelB();

		/**
		 * The meta object literal for the '<em><b>Correspondences</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIFFERENCE__CORRESPONDENCES = eINSTANCE.getDifference_Correspondences();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.difference.impl.CorrespondenceImpl <em>Correspondence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.difference.impl.CorrespondenceImpl
		 * @see org.sidiff.revision.difference.impl.DifferencePackageImpl#getCorrespondence()
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
		 * The meta object literal for the '{@link org.sidiff.revision.difference.impl.ChangeImpl <em>Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.difference.impl.ChangeImpl
		 * @see org.sidiff.revision.difference.impl.DifferencePackageImpl#getChange()
		 * @generated
		 */
		EClass CHANGE = eINSTANCE.getChange();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.difference.impl.AddObjectImpl <em>Add Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.difference.impl.AddObjectImpl
		 * @see org.sidiff.revision.difference.impl.DifferencePackageImpl#getAddObject()
		 * @generated
		 */
		EClass ADD_OBJECT = eINSTANCE.getAddObject();

		/**
		 * The meta object literal for the '<em><b>Obj</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADD_OBJECT__OBJ = eINSTANCE.getAddObject_Obj();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.difference.impl.RemoveObjectImpl <em>Remove Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.difference.impl.RemoveObjectImpl
		 * @see org.sidiff.revision.difference.impl.DifferencePackageImpl#getRemoveObject()
		 * @generated
		 */
		EClass REMOVE_OBJECT = eINSTANCE.getRemoveObject();

		/**
		 * The meta object literal for the '<em><b>Obj</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REMOVE_OBJECT__OBJ = eINSTANCE.getRemoveObject_Obj();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.difference.impl.AddReferenceImpl <em>Add Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.difference.impl.AddReferenceImpl
		 * @see org.sidiff.revision.difference.impl.DifferencePackageImpl#getAddReference()
		 * @generated
		 */
		EClass ADD_REFERENCE = eINSTANCE.getAddReference();

		/**
		 * The meta object literal for the '<em><b>Src</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADD_REFERENCE__SRC = eINSTANCE.getAddReference_Src();

		/**
		 * The meta object literal for the '<em><b>Tgt</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADD_REFERENCE__TGT = eINSTANCE.getAddReference_Tgt();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADD_REFERENCE__TYPE = eINSTANCE.getAddReference_Type();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.difference.impl.RemoveReferenceImpl <em>Remove Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.difference.impl.RemoveReferenceImpl
		 * @see org.sidiff.revision.difference.impl.DifferencePackageImpl#getRemoveReference()
		 * @generated
		 */
		EClass REMOVE_REFERENCE = eINSTANCE.getRemoveReference();

		/**
		 * The meta object literal for the '<em><b>Src</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REMOVE_REFERENCE__SRC = eINSTANCE.getRemoveReference_Src();

		/**
		 * The meta object literal for the '<em><b>Tgt</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REMOVE_REFERENCE__TGT = eINSTANCE.getRemoveReference_Tgt();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REMOVE_REFERENCE__TYPE = eINSTANCE.getRemoveReference_Type();

		/**
		 * The meta object literal for the '{@link org.sidiff.revision.difference.impl.AttributeValueChangeImpl <em>Attribute Value Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.revision.difference.impl.AttributeValueChangeImpl
		 * @see org.sidiff.revision.difference.impl.DifferencePackageImpl#getAttributeValueChange()
		 * @generated
		 */
		EClass ATTRIBUTE_VALUE_CHANGE = eINSTANCE.getAttributeValueChange();

		/**
		 * The meta object literal for the '<em><b>Obj A</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_VALUE_CHANGE__OBJ_A = eINSTANCE.getAttributeValueChange_ObjA();

		/**
		 * The meta object literal for the '<em><b>Obj B</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_VALUE_CHANGE__OBJ_B = eINSTANCE.getAttributeValueChange_ObjB();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_VALUE_CHANGE__TYPE = eINSTANCE.getAttributeValueChange_Type();

	}

} //DifferencePackage

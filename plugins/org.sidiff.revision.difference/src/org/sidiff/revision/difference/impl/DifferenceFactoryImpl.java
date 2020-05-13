/**
 */
package org.sidiff.revision.difference.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.sidiff.revision.difference.AddObject;
import org.sidiff.revision.difference.AddReference;
import org.sidiff.revision.difference.AttributeValueChange;
import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.DifferenceFactory;
import org.sidiff.revision.difference.DifferencePackage;
import org.sidiff.revision.difference.RemoveObject;
import org.sidiff.revision.difference.RemoveReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DifferenceFactoryImpl extends EFactoryImpl implements DifferenceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DifferenceFactory init() {
		try {
			DifferenceFactory theDifferenceFactory = (DifferenceFactory)EPackage.Registry.INSTANCE.getEFactory(DifferencePackage.eNS_URI);
			if (theDifferenceFactory != null) {
				return theDifferenceFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DifferenceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DifferenceFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DifferencePackage.DIFFERENCE: return createDifference();
			case DifferencePackage.CORRESPONDENCE: return createCorrespondence();
			case DifferencePackage.ADD_OBJECT: return createAddObject();
			case DifferencePackage.REMOVE_OBJECT: return createRemoveObject();
			case DifferencePackage.ADD_REFERENCE: return createAddReference();
			case DifferencePackage.REMOVE_REFERENCE: return createRemoveReference();
			case DifferencePackage.ATTRIBUTE_VALUE_CHANGE: return createAttributeValueChange();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Difference createDifference() {
		DifferenceImpl difference = new DifferenceImpl();
		return difference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Correspondence createCorrespondence() {
		CorrespondenceImpl correspondence = new CorrespondenceImpl();
		return correspondence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AddObject createAddObject() {
		AddObjectImpl addObject = new AddObjectImpl();
		return addObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RemoveObject createRemoveObject() {
		RemoveObjectImpl removeObject = new RemoveObjectImpl();
		return removeObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AddReference createAddReference() {
		AddReferenceImpl addReference = new AddReferenceImpl();
		return addReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RemoveReference createRemoveReference() {
		RemoveReferenceImpl removeReference = new RemoveReferenceImpl();
		return removeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AttributeValueChange createAttributeValueChange() {
		AttributeValueChangeImpl attributeValueChange = new AttributeValueChangeImpl();
		return attributeValueChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DifferencePackage getDifferencePackage() {
		return (DifferencePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DifferencePackage getPackage() {
		return DifferencePackage.eINSTANCE;
	}

} //DifferenceFactoryImpl

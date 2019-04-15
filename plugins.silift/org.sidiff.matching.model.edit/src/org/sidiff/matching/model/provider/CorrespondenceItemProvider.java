/**
 */
package org.sidiff.matching.model.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.sidiff.common.stringresolver.util.LabelPrinter;
import org.sidiff.matching.model.Correspondence;
import org.sidiff.matching.model.MatchingModelPackage;
import org.sidiff.matching.model.impl.MatchingImpl;

/**
 * This is the item provider adapter for a {@link org.sidiff.matching.model.Correspondence} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CorrespondenceItemProvider extends ExtendableObjectItemProvider {
	
	/**
	 * @generated NOT
	 */
	private String baseString = getString("_UI_Correspondence_type");
	
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CorrespondenceItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addMatchedAPropertyDescriptor(object);
			addMatchedBPropertyDescriptor(object);
			addContainerCorrespondencePropertyDescriptor(object);
			addContainmentCorrespondencesPropertyDescriptor(object);
			addEClassPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Matched A feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMatchedAPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Correspondence_matchedA_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Correspondence_matchedA_feature", "_UI_Correspondence_type"),
				 MatchingModelPackage.Literals.CORRESPONDENCE__MATCHED_A,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Matched B feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMatchedBPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Correspondence_matchedB_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Correspondence_matchedB_feature", "_UI_Correspondence_type"),
				 MatchingModelPackage.Literals.CORRESPONDENCE__MATCHED_B,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Container Correspondence feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContainerCorrespondencePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Correspondence_containerCorrespondence_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Correspondence_containerCorrespondence_feature", "_UI_Correspondence_type"),
				 MatchingModelPackage.Literals.CORRESPONDENCE__CONTAINER_CORRESPONDENCE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Containment Correspondences feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContainmentCorrespondencesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Correspondence_containmentCorrespondences_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Correspondence_containmentCorrespondences_feature", "_UI_Correspondence_type"),
				 MatchingModelPackage.Literals.CORRESPONDENCE__CONTAINMENT_CORRESPONDENCES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the EClass feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Correspondence_eClass_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Correspondence_eClass_feature", "_UI_Correspondence_type"),
				 MatchingModelPackage.Literals.CORRESPONDENCE__ECLASS,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns Correspondence.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Correspondence"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {

		if (object instanceof Correspondence) {
			EObject container = ((Correspondence) object).eContainer();

			if (container instanceof MatchingImpl) {
				LabelPrinter labelPrinter = ((MatchingImpl) container).getLabelPrinter();
				return baseString + ": " + labelPrinter.getLabel(((Correspondence) object).getMatchedA()) + " <-> " + labelPrinter.getLabel(((Correspondence) object).getMatchedB());
			}
		}
		
		return baseString;
	}

	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

}

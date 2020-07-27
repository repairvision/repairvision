/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.revision.difference.provider;


import java.io.File;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.DifferenceFactory;
import org.sidiff.revision.difference.DifferencePackage;

/**
 * This is the item provider adapter for a {@link org.sidiff.revision.difference.Difference} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DifferenceItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DifferenceItemProvider(AdapterFactory adapterFactory) {
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

			addUriModelAPropertyDescriptor(object);
			addUriModelBPropertyDescriptor(object);
			addModelAPropertyDescriptor(object);
			addModelBPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Model A feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addModelAPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Difference_modelA_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Difference_modelA_feature", "_UI_Difference_type"),
				 DifferencePackage.Literals.DIFFERENCE__MODEL_A,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Model B feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addModelBPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Difference_modelB_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Difference_modelB_feature", "_UI_Difference_type"),
				 DifferencePackage.Literals.DIFFERENCE__MODEL_B,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Uri Model A feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUriModelAPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Difference_uriModelA_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Difference_uriModelA_feature", "_UI_Difference_type"),
				 DifferencePackage.Literals.DIFFERENCE__URI_MODEL_A,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Uri Model B feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUriModelBPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Difference_uriModelB_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Difference_uriModelB_feature", "_UI_Difference_type"),
				 DifferencePackage.Literals.DIFFERENCE__URI_MODEL_B,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(DifferencePackage.Literals.DIFFERENCE__CHANGES);
			childrenFeatures.add(DifferencePackage.Literals.DIFFERENCE__CORRESPONDENCES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Difference.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("change.gif"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		Resource modelA = ((Difference)object).getModelA();
		String modelAName = new File(modelA.getURI().devicePath()).getName();
		Resource modelB = ((Difference)object).getModelB();
		String modelBName = new File(modelB.getURI().devicePath()).getName();
		String labelValue = modelAName + " <-> " + modelBName;
		
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_Difference_type") :
			getString("_UI_Difference_type") + ": " + label;
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

		switch (notification.getFeatureID(Difference.class)) {
			case DifferencePackage.DIFFERENCE__URI_MODEL_A:
			case DifferencePackage.DIFFERENCE__URI_MODEL_B:
			case DifferencePackage.DIFFERENCE__MODEL_A:
			case DifferencePackage.DIFFERENCE__MODEL_B:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DifferencePackage.DIFFERENCE__CHANGES:
			case DifferencePackage.DIFFERENCE__CORRESPONDENCES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
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

		newChildDescriptors.add
			(createChildParameter
				(DifferencePackage.Literals.DIFFERENCE__CHANGES,
				 DifferenceFactory.eINSTANCE.createAddObject()));

		newChildDescriptors.add
			(createChildParameter
				(DifferencePackage.Literals.DIFFERENCE__CHANGES,
				 DifferenceFactory.eINSTANCE.createRemoveObject()));

		newChildDescriptors.add
			(createChildParameter
				(DifferencePackage.Literals.DIFFERENCE__CHANGES,
				 DifferenceFactory.eINSTANCE.createAddReference()));

		newChildDescriptors.add
			(createChildParameter
				(DifferencePackage.Literals.DIFFERENCE__CHANGES,
				 DifferenceFactory.eINSTANCE.createRemoveReference()));

		newChildDescriptors.add
			(createChildParameter
				(DifferencePackage.Literals.DIFFERENCE__CHANGES,
				 DifferenceFactory.eINSTANCE.createAttributeValueChange()));

		newChildDescriptors.add
			(createChildParameter
				(DifferencePackage.Literals.DIFFERENCE__CORRESPONDENCES,
				 DifferenceFactory.eINSTANCE.createCorrespondence()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return DifferenceEditPlugin.INSTANCE;
	}
	
}

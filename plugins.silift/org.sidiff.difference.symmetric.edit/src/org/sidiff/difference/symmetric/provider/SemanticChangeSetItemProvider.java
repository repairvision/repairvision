/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.difference.symmetric.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
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
import org.sidiff.common.stringresolver.util.StringResolverUtil;
import org.sidiff.difference.symmetric.SemanticChangeSet;
import org.sidiff.difference.symmetric.SymmetricFactory;
import org.sidiff.difference.symmetric.SymmetricPackage;

/**
 * This is the item provider adapter for a {@link org.sidiff.difference.symmetric.SemanticChangeSet} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SemanticChangeSetItemProvider
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
	public SemanticChangeSetItemProvider(AdapterFactory adapterFactory) {
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

			addChangesPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addPriorityPropertyDescriptor(object);
			addRecognitionRNamePropertyDescriptor(object);
			addRefinementLevelPropertyDescriptor(object);
			addEditRNamePropertyDescriptor(object);
			addPartiallyOverlappingsPropertyDescriptor(object);
			addSubsetsPropertyDescriptor(object);
			addSupersetsPropertyDescriptor(object);
			addOverlayingsPropertyDescriptor(object);
			addDescriptionPropertyDescriptor(object);
			addNumberOfACsPropertyDescriptor(object);
			addNumberOfParamsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Changes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addChangesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SemanticChangeSet_changes_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SemanticChangeSet_changes_feature", "_UI_SemanticChangeSet_type"),
				 SymmetricPackage.Literals.SEMANTIC_CHANGE_SET__CHANGES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SemanticChangeSet_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SemanticChangeSet_name_feature", "_UI_SemanticChangeSet_type"),
				 SymmetricPackage.Literals.SEMANTIC_CHANGE_SET__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Priority feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPriorityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SemanticChangeSet_priority_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SemanticChangeSet_priority_feature", "_UI_SemanticChangeSet_type"),
				 SymmetricPackage.Literals.SEMANTIC_CHANGE_SET__PRIORITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Recognition RName feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRecognitionRNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SemanticChangeSet_recognitionRName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SemanticChangeSet_recognitionRName_feature", "_UI_SemanticChangeSet_type"),
				 SymmetricPackage.Literals.SEMANTIC_CHANGE_SET__RECOGNITION_RNAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Refinement Level feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRefinementLevelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SemanticChangeSet_refinementLevel_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SemanticChangeSet_refinementLevel_feature", "_UI_SemanticChangeSet_type"),
				 SymmetricPackage.Literals.SEMANTIC_CHANGE_SET__REFINEMENT_LEVEL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Edit RName feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEditRNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SemanticChangeSet_editRName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SemanticChangeSet_editRName_feature", "_UI_SemanticChangeSet_type"),
				 SymmetricPackage.Literals.SEMANTIC_CHANGE_SET__EDIT_RNAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Partially Overlappings feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPartiallyOverlappingsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SemanticChangeSet_partiallyOverlappings_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SemanticChangeSet_partiallyOverlappings_feature", "_UI_SemanticChangeSet_type"),
				 SymmetricPackage.Literals.SEMANTIC_CHANGE_SET__PARTIALLY_OVERLAPPINGS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Subsets feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSubsetsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SemanticChangeSet_subsets_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SemanticChangeSet_subsets_feature", "_UI_SemanticChangeSet_type"),
				 SymmetricPackage.Literals.SEMANTIC_CHANGE_SET__SUBSETS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Supersets feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSupersetsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SemanticChangeSet_supersets_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SemanticChangeSet_supersets_feature", "_UI_SemanticChangeSet_type"),
				 SymmetricPackage.Literals.SEMANTIC_CHANGE_SET__SUPERSETS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Overlayings feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOverlayingsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SemanticChangeSet_overlayings_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SemanticChangeSet_overlayings_feature", "_UI_SemanticChangeSet_type"),
				 SymmetricPackage.Literals.SEMANTIC_CHANGE_SET__OVERLAYINGS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Description feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SemanticChangeSet_description_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SemanticChangeSet_description_feature", "_UI_SemanticChangeSet_type"),
				 SymmetricPackage.Literals.SEMANTIC_CHANGE_SET__DESCRIPTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Number Of ACs feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNumberOfACsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SemanticChangeSet_numberOfACs_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SemanticChangeSet_numberOfACs_feature", "_UI_SemanticChangeSet_type"),
				 SymmetricPackage.Literals.SEMANTIC_CHANGE_SET__NUMBER_OF_ACS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Number Of Params feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNumberOfParamsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SemanticChangeSet_numberOfParams_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SemanticChangeSet_numberOfParams_feature", "_UI_SemanticChangeSet_type"),
				 SymmetricPackage.Literals.SEMANTIC_CHANGE_SET__NUMBER_OF_PARAMS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
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
			childrenFeatures.add(SymmetricPackage.Literals.SEMANTIC_CHANGE_SET__CHANGES);
			childrenFeatures.add(SymmetricPackage.Literals.SEMANTIC_CHANGE_SET__JOINS);
			childrenFeatures.add(SymmetricPackage.Literals.SEMANTIC_CHANGE_SET__SPLITS);
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
	 * This returns SemanticChangeSet.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("changeset.gif"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		if(object instanceof SemanticChangeSet){
			return StringResolverUtil.getAvailableStringResolver(SymmetricPackage.eNS_URI).resolve((EObject)object);		
		}
		return getString("_UI_SemanticChangeSet_type");
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

		switch (notification.getFeatureID(SemanticChangeSet.class)) {
			case SymmetricPackage.SEMANTIC_CHANGE_SET__NAME:
			case SymmetricPackage.SEMANTIC_CHANGE_SET__PRIORITY:
			case SymmetricPackage.SEMANTIC_CHANGE_SET__RECOGNITION_RNAME:
			case SymmetricPackage.SEMANTIC_CHANGE_SET__REFINEMENT_LEVEL:
			case SymmetricPackage.SEMANTIC_CHANGE_SET__EDIT_RNAME:
			case SymmetricPackage.SEMANTIC_CHANGE_SET__DESCRIPTION:
			case SymmetricPackage.SEMANTIC_CHANGE_SET__NUMBER_OF_ACS:
			case SymmetricPackage.SEMANTIC_CHANGE_SET__NUMBER_OF_PARAMS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case SymmetricPackage.SEMANTIC_CHANGE_SET__JOINS:
			case SymmetricPackage.SEMANTIC_CHANGE_SET__SPLITS:
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
				(SymmetricPackage.Literals.SEMANTIC_CHANGE_SET__JOINS,
				 SymmetricFactory.eINSTANCE.createFragmentJoin()));

		newChildDescriptors.add
			(createChildParameter
				(SymmetricPackage.Literals.SEMANTIC_CHANGE_SET__SPLITS,
				 SymmetricFactory.eINSTANCE.createFragmentSplit()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return SymmetricEditPlugin.INSTANCE;
	}

}

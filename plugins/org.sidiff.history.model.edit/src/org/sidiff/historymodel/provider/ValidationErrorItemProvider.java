/**
 */
package org.sidiff.historymodel.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
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
import org.sidiff.historymodel.HistoryModelFactory;
import org.sidiff.historymodel.HistoryModelPackage;
import org.sidiff.historymodel.ValidationError;
import org.sidiff.historymodel.ValidationSeverity;

/**
 * This is the item provider adapter for a {@link org.sidiff.historymodel.ValidationError} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ValidationErrorItemProvider 
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
	public ValidationErrorItemProvider(AdapterFactory adapterFactory) {
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

			addNamePropertyDescriptor(object);
			addIntroducedInPropertyDescriptor(object);
			addResolvedInPropertyDescriptor(object);
			addMessagePropertyDescriptor(object);
			addSourcePropertyDescriptor(object);
			addSeverityPropertyDescriptor(object);
			addIntroducedPropertyDescriptor(object);
			addResolvedPropertyDescriptor(object);
			addPrecPropertyDescriptor(object);
			addSuccPropertyDescriptor(object);
			addInvalidElementPropertyDescriptor(object);
			addContextPropertyDescriptor(object);
			addResolvedByUndoPropertyDescriptor(object);
			addChangeSetsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
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
				 getString("_UI_ValidationError_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ValidationError_name_feature", "_UI_ValidationError_type"),
				 HistoryModelPackage.Literals.VALIDATION_ERROR__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Introduced In feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIntroducedInPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ValidationError_introducedIn_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ValidationError_introducedIn_feature", "_UI_ValidationError_type"),
				 HistoryModelPackage.Literals.VALIDATION_ERROR__INTRODUCED_IN,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Resolved In feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResolvedInPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ValidationError_resolvedIn_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ValidationError_resolvedIn_feature", "_UI_ValidationError_type"),
				 HistoryModelPackage.Literals.VALIDATION_ERROR__RESOLVED_IN,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Message feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMessagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ValidationError_message_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ValidationError_message_feature", "_UI_ValidationError_type"),
				 HistoryModelPackage.Literals.VALIDATION_ERROR__MESSAGE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Source feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourcePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ValidationError_source_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ValidationError_source_feature", "_UI_ValidationError_type"),
				 HistoryModelPackage.Literals.VALIDATION_ERROR__SOURCE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Severity feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSeverityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ValidationError_severity_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ValidationError_severity_feature", "_UI_ValidationError_type"),
				 HistoryModelPackage.Literals.VALIDATION_ERROR__SEVERITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Introduced feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIntroducedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ValidationError_introduced_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ValidationError_introduced_feature", "_UI_ValidationError_type"),
				 HistoryModelPackage.Literals.VALIDATION_ERROR__INTRODUCED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Resolved feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResolvedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ValidationError_resolved_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ValidationError_resolved_feature", "_UI_ValidationError_type"),
				 HistoryModelPackage.Literals.VALIDATION_ERROR__RESOLVED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Prec feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPrecPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ValidationError_prec_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ValidationError_prec_feature", "_UI_ValidationError_type"),
				 HistoryModelPackage.Literals.VALIDATION_ERROR__PREC,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Succ feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSuccPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ValidationError_succ_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ValidationError_succ_feature", "_UI_ValidationError_type"),
				 HistoryModelPackage.Literals.VALIDATION_ERROR__SUCC,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Invalid Element feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInvalidElementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ValidationError_invalidElement_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ValidationError_invalidElement_feature", "_UI_ValidationError_type"),
				 HistoryModelPackage.Literals.VALIDATION_ERROR__INVALID_ELEMENT,
				 false,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Context feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContextPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ValidationError_context_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ValidationError_context_feature", "_UI_ValidationError_type"),
				 HistoryModelPackage.Literals.VALIDATION_ERROR__CONTEXT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Resolved By Undo feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResolvedByUndoPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ValidationError_resolvedByUndo_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ValidationError_resolvedByUndo_feature", "_UI_ValidationError_type"),
				 HistoryModelPackage.Literals.VALIDATION_ERROR__RESOLVED_BY_UNDO,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Change Sets feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addChangeSetsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ValidationError_changeSets_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ValidationError_changeSets_feature", "_UI_ValidationError_type"),
				 HistoryModelPackage.Literals.VALIDATION_ERROR__CHANGE_SETS,
				 true,
				 false,
				 true,
				 null,
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
			childrenFeatures.add(HistoryModelPackage.Literals.VALIDATION_ERROR__INVALID_ELEMENT);
			childrenFeatures.add(HistoryModelPackage.Literals.VALIDATION_ERROR__CHANGE_SETS);
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
	 * This returns ValidationError.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		
		if (object instanceof ValidationError) {
			ValidationError validationError = (ValidationError) object;
			
			if(validationError.getSeverity().equals(ValidationSeverity.ERROR)){
				if(validationError.isIntroduced() && validationError.isResolved()){
					return overlayImage(object, getResourceLocator().getImage("full/obj16/error_1"));
				} else {
					return overlayImage(object, getResourceLocator().getImage("full/obj16/error_2"));
				}
			}
			
			else if(validationError.getSeverity().equals(ValidationSeverity.WARNING)){
				if(validationError.isIntroduced() && validationError.isResolved()){
					return overlayImage(object, getResourceLocator().getImage("full/obj16/warning_1"));
				} else {
					return overlayImage(object, getResourceLocator().getImage("full/obj16/warning_2"));
				}
			}
		}
		
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ValidationError"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		ValidationError validationError = (ValidationError)object;
		String label = validationError.getMessage();
		return label == null || label.length() == 0 ?
			getString("_UI_ValidationError_type") :
			getString("_UI_ValidationError_type") + " " + label;
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

		switch (notification.getFeatureID(org.sidiff.historymodel.ValidationError.class)) {
			case HistoryModelPackage.VALIDATION_ERROR__NAME:
			case HistoryModelPackage.VALIDATION_ERROR__MESSAGE:
			case HistoryModelPackage.VALIDATION_ERROR__SOURCE:
			case HistoryModelPackage.VALIDATION_ERROR__SEVERITY:
			case HistoryModelPackage.VALIDATION_ERROR__INTRODUCED:
			case HistoryModelPackage.VALIDATION_ERROR__RESOLVED:
			case HistoryModelPackage.VALIDATION_ERROR__RESOLVED_BY_UNDO:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case HistoryModelPackage.VALIDATION_ERROR__CHANGE_SETS:
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
				(HistoryModelPackage.Literals.VALIDATION_ERROR__CHANGE_SETS,
				 HistoryModelFactory.eINSTANCE.createChangeSet()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ModelEditPlugin.INSTANCE;
	}

}

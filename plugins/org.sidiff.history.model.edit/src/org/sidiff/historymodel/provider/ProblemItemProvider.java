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
import org.sidiff.historymodel.Problem;
import org.sidiff.historymodel.ProblemSeverity;

/**
 * This is the item provider adapter for a {@link org.sidiff.historymodel.Problem} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ProblemItemProvider 
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
	public ProblemItemProvider(AdapterFactory adapterFactory) {
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

			addVersionPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addIntroducedInPropertyDescriptor(object);
			addIntroducedPropertyDescriptor(object);
			addResolvedInPropertyDescriptor(object);
			addResolvedPropertyDescriptor(object);
			addMessagePropertyDescriptor(object);
			addSeverityPropertyDescriptor(object);
			addPredecessorPropertyDescriptor(object);
			addSuccessorPropertyDescriptor(object);
			addInvalidElementsPropertyDescriptor(object);
			addContextElementPropertyDescriptor(object);
			addModificationsPropertyDescriptor(object);
			addModificationClassificationPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Version feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVersionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Problem_version_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Problem_version_feature", "_UI_Problem_type"),
				 HistoryModelPackage.Literals.PROBLEM__VERSION,
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
				 getString("_UI_Problem_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Problem_name_feature", "_UI_Problem_type"),
				 HistoryModelPackage.Literals.PROBLEM__NAME,
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
				 getString("_UI_Problem_introducedIn_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Problem_introducedIn_feature", "_UI_Problem_type"),
				 HistoryModelPackage.Literals.PROBLEM__INTRODUCED_IN,
				 true,
				 false,
				 true,
				 null,
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
				 getString("_UI_Problem_introduced_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Problem_introduced_feature", "_UI_Problem_type"),
				 HistoryModelPackage.Literals.PROBLEM__INTRODUCED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
				 getString("_UI_Problem_resolvedIn_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Problem_resolvedIn_feature", "_UI_Problem_type"),
				 HistoryModelPackage.Literals.PROBLEM__RESOLVED_IN,
				 true,
				 false,
				 true,
				 null,
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
				 getString("_UI_Problem_resolved_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Problem_resolved_feature", "_UI_Problem_type"),
				 HistoryModelPackage.Literals.PROBLEM__RESOLVED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
				 getString("_UI_Problem_message_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Problem_message_feature", "_UI_Problem_type"),
				 HistoryModelPackage.Literals.PROBLEM__MESSAGE,
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
				 getString("_UI_Problem_severity_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Problem_severity_feature", "_UI_Problem_type"),
				 HistoryModelPackage.Literals.PROBLEM__SEVERITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Predecessor feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPredecessorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Problem_predecessor_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Problem_predecessor_feature", "_UI_Problem_type"),
				 HistoryModelPackage.Literals.PROBLEM__PREDECESSOR,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Successor feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSuccessorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Problem_successor_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Problem_successor_feature", "_UI_Problem_type"),
				 HistoryModelPackage.Literals.PROBLEM__SUCCESSOR,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Invalid Elements feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInvalidElementsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Problem_invalidElements_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Problem_invalidElements_feature", "_UI_Problem_type"),
				 HistoryModelPackage.Literals.PROBLEM__INVALID_ELEMENTS,
				 false,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Context Element feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContextElementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Problem_contextElement_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Problem_contextElement_feature", "_UI_Problem_type"),
				 HistoryModelPackage.Literals.PROBLEM__CONTEXT_ELEMENT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Modifications feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addModificationsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Problem_modifications_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Problem_modifications_feature", "_UI_Problem_type"),
				 HistoryModelPackage.Literals.PROBLEM__MODIFICATIONS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Modification Classification feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addModificationClassificationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Problem_modificationClassification_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Problem_modificationClassification_feature", "_UI_Problem_type"),
				 HistoryModelPackage.Literals.PROBLEM__MODIFICATION_CLASSIFICATION,
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
			childrenFeatures.add(HistoryModelPackage.Literals.PROBLEM__INVALID_ELEMENTS);
			childrenFeatures.add(HistoryModelPackage.Literals.PROBLEM__MODIFICATIONS);
			childrenFeatures.add(HistoryModelPackage.Literals.PROBLEM__ANNOTATIONS);
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
	 * This returns Problem.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		
		if (object instanceof Problem) {
			Problem validationError = (Problem) object;
			
			if(validationError.getSeverity().equals(ProblemSeverity.ERROR)){
				if(validationError.isIntroduced() && validationError.isResolved()){
					return overlayImage(object, getResourceLocator().getImage("full/obj16/error_1"));
				} else {
					return overlayImage(object, getResourceLocator().getImage("full/obj16/error_2"));
				}
			}
			
			else if(validationError.getSeverity().equals(ProblemSeverity.WARNING)){
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
		Problem validationError = (Problem) object;
		StringBuilder label = new StringBuilder(validationError.getMessage());
		
		if (label == null || label.length() == 0) {
			label.append(getString("_UI_Version_problems_feature"));
		} else {
			label.insert(0, "Problem: ").toString();
		}
		
		if (validationError.getIntroducedIn() == validationError.getVersion()) {
			label.insert(0, "[Introduced] ");
		}
		
		if (validationError.getResolvedIn() == validationError.getVersion().getSuccessor()) {
			label.insert(0, "[Resolved] ");
		}
		

		return label.toString();
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

		switch (notification.getFeatureID(Problem.class)) {
			case HistoryModelPackage.PROBLEM__NAME:
			case HistoryModelPackage.PROBLEM__INTRODUCED:
			case HistoryModelPackage.PROBLEM__RESOLVED:
			case HistoryModelPackage.PROBLEM__MESSAGE:
			case HistoryModelPackage.PROBLEM__SEVERITY:
			case HistoryModelPackage.PROBLEM__MODIFICATION_CLASSIFICATION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case HistoryModelPackage.PROBLEM__MODIFICATIONS:
			case HistoryModelPackage.PROBLEM__ANNOTATIONS:
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
				(HistoryModelPackage.Literals.PROBLEM__MODIFICATIONS,
				 HistoryModelFactory.eINSTANCE.createChangeSet()));

		newChildDescriptors.add
			(createChildParameter
				(HistoryModelPackage.Literals.PROBLEM__ANNOTATIONS,
				 HistoryModelFactory.eINSTANCE.createAnnotation()));
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

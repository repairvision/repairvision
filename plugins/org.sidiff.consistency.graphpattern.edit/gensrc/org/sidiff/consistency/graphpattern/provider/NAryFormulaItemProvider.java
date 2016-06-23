/**
 */
package org.sidiff.consistency.graphpattern.provider;


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

import org.sidiff.consistency.graphpattern.GraphpatternFactory;
import org.sidiff.consistency.graphpattern.GraphpatternPackage;
import org.sidiff.consistency.graphpattern.NAryFormula;

/**
 * This is the item provider adapter for a {@link org.sidiff.consistency.graphpattern.NAryFormula} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class NAryFormulaItemProvider 
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
	public NAryFormulaItemProvider(AdapterFactory adapterFactory) {
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

			addResultsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Results feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResultsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_NAryFormula_results_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_NAryFormula_results_feature", "_UI_NAryFormula_type"),
				 GraphpatternPackage.Literals.NARY_FORMULA__RESULTS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
			childrenFeatures.add(GraphpatternPackage.Literals.NARY_FORMULA__FORMULAS);
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
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_NAryFormula_type");
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

		switch (notification.getFeatureID(NAryFormula.class)) {
			case GraphpatternPackage.NARY_FORMULA__RESULTS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case GraphpatternPackage.NARY_FORMULA__FORMULAS:
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
				(GraphpatternPackage.Literals.NARY_FORMULA__FORMULAS,
				 GraphpatternFactory.eINSTANCE.createAnd()));

		newChildDescriptors.add
			(createChildParameter
				(GraphpatternPackage.Literals.NARY_FORMULA__FORMULAS,
				 GraphpatternFactory.eINSTANCE.createOr()));

		newChildDescriptors.add
			(createChildParameter
				(GraphpatternPackage.Literals.NARY_FORMULA__FORMULAS,
				 GraphpatternFactory.eINSTANCE.createIff()));

		newChildDescriptors.add
			(createChildParameter
				(GraphpatternPackage.Literals.NARY_FORMULA__FORMULAS,
				 GraphpatternFactory.eINSTANCE.createIf()));

		newChildDescriptors.add
			(createChildParameter
				(GraphpatternPackage.Literals.NARY_FORMULA__FORMULAS,
				 GraphpatternFactory.eINSTANCE.createNot()));

		newChildDescriptors.add
			(createChildParameter
				(GraphpatternPackage.Literals.NARY_FORMULA__FORMULAS,
				 GraphpatternFactory.eINSTANCE.createXor()));

		newChildDescriptors.add
			(createChildParameter
				(GraphpatternPackage.Literals.NARY_FORMULA__FORMULAS,
				 GraphpatternFactory.eINSTANCE.createAndGroup()));

		newChildDescriptors.add
			(createChildParameter
				(GraphpatternPackage.Literals.NARY_FORMULA__FORMULAS,
				 GraphpatternFactory.eINSTANCE.createOrGroup()));

		newChildDescriptors.add
			(createChildParameter
				(GraphpatternPackage.Literals.NARY_FORMULA__FORMULAS,
				 GraphpatternFactory.eINSTANCE.createGraphConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(GraphpatternPackage.Literals.NARY_FORMULA__FORMULAS,
				 GraphpatternFactory.eINSTANCE.createXorGroup()));

		newChildDescriptors.add
			(createChildParameter
				(GraphpatternPackage.Literals.NARY_FORMULA__FORMULAS,
				 GraphpatternFactory.eINSTANCE.createIffGroup()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return GraphpatternEditPlugin.INSTANCE;
	}

}

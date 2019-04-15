/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.difference.symmetric.provider;


import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.sidiff.difference.symmetric.SemanticChangeSet;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.symmetric.SymmetricFactory;
import org.sidiff.difference.symmetric.SymmetricPackage;
import org.sidiff.difference.symmetric.util.DifferenceAnalysisUtil;

/**
 * This is the item provider adapter for a {@link org.sidiff.difference.symmetric.SymmetricDifference} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SymmetricDifferenceItemProvider
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
	public SymmetricDifferenceItemProvider(AdapterFactory adapterFactory) {
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

			addModelAPropertyDescriptor(object);
			addModelBPropertyDescriptor(object);
			addUriModelAPropertyDescriptor(object);
			addUriModelBPropertyDescriptor(object);
			addNotOverlappingsPropertyDescriptor(object);
			addMatchingPropertyDescriptor(object);
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
				 getString("_UI_SymmetricDifference_modelA_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SymmetricDifference_modelA_feature", "_UI_SymmetricDifference_type"),
				 SymmetricPackage.Literals.SYMMETRIC_DIFFERENCE__MODEL_A,
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
				 getString("_UI_SymmetricDifference_modelB_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SymmetricDifference_modelB_feature", "_UI_SymmetricDifference_type"),
				 SymmetricPackage.Literals.SYMMETRIC_DIFFERENCE__MODEL_B,
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
				 getString("_UI_SymmetricDifference_uriModelA_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SymmetricDifference_uriModelA_feature", "_UI_SymmetricDifference_type"),
				 SymmetricPackage.Literals.SYMMETRIC_DIFFERENCE__URI_MODEL_A,
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
				 getString("_UI_SymmetricDifference_uriModelB_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SymmetricDifference_uriModelB_feature", "_UI_SymmetricDifference_type"),
				 SymmetricPackage.Literals.SYMMETRIC_DIFFERENCE__URI_MODEL_B,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Not Overlappings feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNotOverlappingsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SymmetricDifference_notOverlappings_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SymmetricDifference_notOverlappings_feature", "_UI_SymmetricDifference_type"),
				 SymmetricPackage.Literals.SYMMETRIC_DIFFERENCE__NOT_OVERLAPPINGS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Matching feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMatchingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SymmetricDifference_matching_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SymmetricDifference_matching_feature", "_UI_SymmetricDifference_type"),
				 SymmetricPackage.Literals.SYMMETRIC_DIFFERENCE__MATCHING,
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
			childrenFeatures.add(SymmetricPackage.Literals.SYMMETRIC_DIFFERENCE__CHANGES);
			childrenFeatures.add(SymmetricPackage.Literals.SYMMETRIC_DIFFERENCE__CHANGE_SETS);
			childrenFeatures.add(SymmetricPackage.Literals.SYMMETRIC_DIFFERENCE__UNUSED_CHANGE_SETS);
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
		Resource modelA = ((SymmetricDifference)object).getModelA();
		String modelAName = new File(modelA.getURI().devicePath()).getName();
		Resource modelB = ((SymmetricDifference)object).getModelB();
		String modelBName = new File(modelB.getURI().devicePath()).getName();
		String labelValue = modelAName + " <-> " + modelBName;
		
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_SymmetricDifference_type") :
			getString("_UI_SymmetricDifference_type") + ": " + label;
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

		switch (notification.getFeatureID(SymmetricDifference.class)) {
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__MODEL_A:
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__MODEL_B:
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__URI_MODEL_A:
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__URI_MODEL_B:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__CHANGES:
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__CHANGE_SETS:
			case SymmetricPackage.SYMMETRIC_DIFFERENCE__UNUSED_CHANGE_SETS:
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
				(SymmetricPackage.Literals.SYMMETRIC_DIFFERENCE__CHANGES,
				 SymmetricFactory.eINSTANCE.createAddObject()));

		newChildDescriptors.add
			(createChildParameter
				(SymmetricPackage.Literals.SYMMETRIC_DIFFERENCE__CHANGES,
				 SymmetricFactory.eINSTANCE.createRemoveObject()));

		newChildDescriptors.add
			(createChildParameter
				(SymmetricPackage.Literals.SYMMETRIC_DIFFERENCE__CHANGES,
				 SymmetricFactory.eINSTANCE.createAddReference()));

		newChildDescriptors.add
			(createChildParameter
				(SymmetricPackage.Literals.SYMMETRIC_DIFFERENCE__CHANGES,
				 SymmetricFactory.eINSTANCE.createRemoveReference()));

		newChildDescriptors.add
			(createChildParameter
				(SymmetricPackage.Literals.SYMMETRIC_DIFFERENCE__CHANGES,
				 SymmetricFactory.eINSTANCE.createAttributeValueChange()));

		newChildDescriptors.add
			(createChildParameter
				(SymmetricPackage.Literals.SYMMETRIC_DIFFERENCE__CHANGE_SETS,
				 SymmetricFactory.eINSTANCE.createSemanticChangeSet()));
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

	protected List<Object> children = null;
	/**
	 * @generated NOT
	 */
	@Override
	public Collection<?> getChildren(Object object) {	

		if(children == null){
			// We can be sure we have a difference here
			SymmetricDifference difference = (SymmetricDifference) object;
			
			// Create a result-list
			children = new ArrayList<Object>();		
			
			// These children must be filtered
			children.addAll(DifferenceAnalysisUtil.getRemainingChanges(difference));
			children.addAll(getNonAggregatedChangeSets(difference));
			
			children.add(difference.getMatching());

// TODO: Should be only visible on demand
//			if(difference.getUnusedChangeSets().size() != 0){
//				children.add(new UnusedChangeSetsItemProvider(adapterFactory, difference));
//			}
		}
		return children;
	}
	
	
	/**
	 * @generated NOT
	 */
	public Object getCorrespondences(){
		for(Object obj : children){
			if(obj instanceof CorrespondencesItemProvider){
				return children.get(children.indexOf(obj));
			}
			
		}
		return null;
	}
	/**
	 * @generated NOT
	 */
	public Object getUnusedChangeSets(){
		for(Object obj : children){
			if(obj instanceof UnusedChangeSetsItemProvider){
				return children.get(children.indexOf(obj));
			}
			
		}
		return null;
	}
	
	/**
	 * @param difference
	 * @return all changes which are not grouped by a semantic change set.
	 * @generated NOT
	 */
	private List<EObject> getNonAggregatedChangeSets(SymmetricDifference difference){		
		ArrayList<EObject> res = new ArrayList<EObject>();
		for (SemanticChangeSet cs : difference.getChangeSets()) {
			if (cs.eContainer() instanceof SymmetricDifference){
				res.add(cs);
			}
		}
		
		return res;
	}
	
	/**
	 * generated NOT
	 */
	@Override
	public void dispose(){
		super.dispose() ;
		if (children != null){
			for(Object obj : children){
				if(obj instanceof ItemProviderAdapter)
					((IDisposable)children.get(children.indexOf(obj))).dispose();
			}
			
		}
	}
	
}

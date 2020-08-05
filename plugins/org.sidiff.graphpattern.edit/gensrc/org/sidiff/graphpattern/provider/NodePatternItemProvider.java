/**
 */
package org.sidiff.graphpattern.provider;


import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.GraphpatternPackage;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.edit.util.ColorServices;
import org.sidiff.graphpattern.edit.util.LabelServices;
import org.sidiff.revision.common.emf.ItemProviderUtil;

/**
 * This is the item provider adapter for a {@link org.sidiff.graphpattern.NodePattern} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class NodePatternItemProvider 
	extends GraphElementItemProvider {
	
	/**
	 * @generated NOT
	 */
	private Map<EClass, Object> iconLibrary = new HashMap<>();
	
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodePatternItemProvider(AdapterFactory adapterFactory) {
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

			addTypePropertyDescriptor(object);
			addIncomingsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_NodePattern_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_NodePattern_type_feature", "_UI_NodePattern_type"),
				 GraphpatternPackage.Literals.NODE_PATTERN__TYPE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Incomings feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIncomingsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_NodePattern_incomings_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_NodePattern_incomings_feature", "_UI_NodePattern_type"),
				 GraphpatternPackage.Literals.NODE_PATTERN__INCOMINGS,
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
			childrenFeatures.add(GraphpatternPackage.Literals.NODE_PATTERN__OUTGOINGS);
			childrenFeatures.add(GraphpatternPackage.Literals.NODE_PATTERN__ATTRIBUTES);
			childrenFeatures.add(GraphpatternPackage.Literals.NODE_PATTERN__MATCHING);
			childrenFeatures.add(GraphpatternPackage.Literals.NODE_PATTERN__ASSOCIATIONS);
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
	 * This returns NodePattern.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		EClass type = ((NodePattern)object).getType();
		
		if (type != null) {
			Object image = iconLibrary.get(type);
					
			if (image == null) {
				image = ItemProviderUtil.getImageByType(type);
				
				if (image != null) {
					iconLibrary.put(type, image);
					return image;
				}
			}
			
			if (image != null) {
				return image;
			}
		}

		return overlayImage(object, getResourceLocator().getImage("full/obj16/NodePattern"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		return LabelServices.getLabel((NodePattern) object); 
//		return getString("_UI_NodePattern_type");
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public Object getForeground(Object object) {
		int[] color = ColorServices.getNodeLabelColor(object);
		
		if (color != null) {
			URI foreground = URI.createURI("color://rgb/" + color[0] + "/" + color[1] + "/" + color[2]);
			return foreground;
		} else {
			return super.getForeground(object);
		}
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

		switch (notification.getFeatureID(NodePattern.class)) {
			case GraphpatternPackage.NODE_PATTERN__OUTGOINGS:
			case GraphpatternPackage.NODE_PATTERN__ATTRIBUTES:
			case GraphpatternPackage.NODE_PATTERN__MATCHING:
			case GraphpatternPackage.NODE_PATTERN__ASSOCIATIONS:
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
				(GraphpatternPackage.Literals.NODE_PATTERN__OUTGOINGS,
				 GraphpatternFactory.eINSTANCE.createEdgePattern()));

		newChildDescriptors.add
			(createChildParameter
				(GraphpatternPackage.Literals.NODE_PATTERN__ATTRIBUTES,
				 GraphpatternFactory.eINSTANCE.createAttributePattern()));

		newChildDescriptors.add
			(createChildParameter
				(GraphpatternPackage.Literals.NODE_PATTERN__ASSOCIATIONS,
				 GraphpatternFactory.eINSTANCE.createAssociation()));
	}

}

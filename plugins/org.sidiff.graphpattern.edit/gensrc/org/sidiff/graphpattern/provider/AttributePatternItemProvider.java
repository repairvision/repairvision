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
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.GraphpatternPackage;
import org.sidiff.graphpattern.edit.util.ColorServices;
import org.sidiff.graphpattern.edit.util.LabelServices;
import org.sidiff.revision.common.emf.ItemProviderUtil;

/**
 * This is the item provider adapter for a {@link org.sidiff.graphpattern.AttributePattern} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AttributePatternItemProvider 
	extends GraphElementItemProvider {
	
	/**
	 * @generated NOT
	 */
	private Map<EAttribute, Object> iconLibrary = new HashMap<>();
	
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributePatternItemProvider(AdapterFactory adapterFactory) {
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

			addValuePropertyDescriptor(object);
			addTypePropertyDescriptor(object);
			addConstantPropertyDescriptor(object);
			addVariablesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AttributePattern_value_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AttributePattern_value_feature", "_UI_AttributePattern_type"),
				 GraphpatternPackage.Literals.ATTRIBUTE_PATTERN__VALUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
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
				 getString("_UI_AttributePattern_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AttributePattern_type_feature", "_UI_AttributePattern_type"),
				 GraphpatternPackage.Literals.ATTRIBUTE_PATTERN__TYPE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Constant feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConstantPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AttributePattern_constant_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AttributePattern_constant_feature", "_UI_AttributePattern_type"),
				 GraphpatternPackage.Literals.ATTRIBUTE_PATTERN__CONSTANT,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Variables feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVariablesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AttributePattern_variables_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AttributePattern_variables_feature", "_UI_AttributePattern_type"),
				 GraphpatternPackage.Literals.ATTRIBUTE_PATTERN__VARIABLES,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns AttributePattern.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		EAttribute type = ((AttributePattern)object).getType();
		
		if (type != null) {
			Object image = iconLibrary.get(type);
					
			if (image == null) {
				image = ItemProviderUtil.getImageByObject(type);
				
				if (image != null) {
					iconLibrary.put(type, image);
					return image;
				}
			} 
			
			if (image != null) {
				return image;
			}
		}
		
		return overlayImage(object, getResourceLocator().getImage("full/obj16/AttributePattern"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		AttributePattern attributePattern = (AttributePattern) object;
		return LabelServices.getLabel(attributePattern);
		
//		String label = ((AttributePattern)object).getValue();
//		return label == null || label.length() == 0 ?
//			getString("_UI_AttributePattern_type") :
//			getString("_UI_AttributePattern_type") + " " + label;
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public Object getForeground(Object object) {
		int[] color = ColorServices.getAttributeLabelColor(object);
		
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

		switch (notification.getFeatureID(AttributePattern.class)) {
			case GraphpatternPackage.ATTRIBUTE_PATTERN__VALUE:
			case GraphpatternPackage.ATTRIBUTE_PATTERN__CONSTANT:
			case GraphpatternPackage.ATTRIBUTE_PATTERN__VARIABLES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
	}

}

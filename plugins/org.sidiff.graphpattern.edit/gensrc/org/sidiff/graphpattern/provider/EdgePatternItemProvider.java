/**
 */
package org.sidiff.graphpattern.provider;


import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphpatternPackage;
import org.sidiff.graphpattern.edit.commands.SetEdgePatternTypeCommand;
import org.sidiff.graphpattern.edit.util.ColorServices;
import org.sidiff.graphpattern.edit.util.ItemProviderUtil;
import org.sidiff.graphpattern.edit.util.LabelServices;

/**
 * This is the item provider adapter for a {@link org.sidiff.graphpattern.EdgePattern} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EdgePatternItemProvider 
	extends GraphElementItemProvider {
	
	/**
	 * @generated NOT
	 */
	private Map<EReference, Object> iconLibrary = new HashMap<>();
	
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EdgePatternItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * @generated NOT
	 */
	@Override
	protected Command createSetCommand(
			EditingDomain domain, 
			EObject owner, EStructuralFeature feature, 
			Object value, int index) {
		
		// EdgePatter.setType(): Set consistent edge opposite types:
		if (feature == GraphpatternPackage.Literals.EDGE_PATTERN__TYPE) {
			return new SetEdgePatternTypeCommand(domain, owner, feature, value);
		}
		
		return super.createSetCommand(domain, owner, feature, value, index);
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

			addTargetPropertyDescriptor(object);
			addOppositePropertyDescriptor(object);
			addTypePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Target feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EdgePattern_target_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EdgePattern_target_feature", "_UI_EdgePattern_type"),
				 GraphpatternPackage.Literals.EDGE_PATTERN__TARGET,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Opposite feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOppositePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EdgePattern_opposite_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EdgePattern_opposite_feature", "_UI_EdgePattern_type"),
				 GraphpatternPackage.Literals.EDGE_PATTERN__OPPOSITE,
				 true,
				 false,
				 true,
				 null,
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
				 getString("_UI_EdgePattern_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EdgePattern_type_feature", "_UI_EdgePattern_type"),
				 GraphpatternPackage.Literals.EDGE_PATTERN__TYPE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns EdgePattern.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		EReference type = ((EdgePattern)object).getType();
		
		if (type != null) {
			Object image = iconLibrary.get(type);
					
			if (image == null) {
				image = ItemProviderUtil.getImageByObject(type);
				
				if (image != null) {
					iconLibrary.put(type, image);
				}
			} 
			
			if (image != null) {
				return image;
			}
		}
		
		return overlayImage(object, getResourceLocator().getImage("full/obj16/EdgePattern"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		EdgePattern edgePattern = (EdgePattern) object;
		return LabelServices.getLabel(edgePattern);
//		return getString("_UI_EdgePattern_type") + " " + edgePattern.isCrossReference();
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public Object getForeground(Object object) {
		int[] color = ColorServices.getEdgeLabelColor(object);
		
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

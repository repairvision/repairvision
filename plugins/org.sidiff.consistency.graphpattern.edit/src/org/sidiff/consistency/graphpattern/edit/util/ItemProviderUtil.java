package org.sidiff.consistency.graphpattern.edit.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;

/**
 * @author Manuel Ohrndorf
 */
public class ItemProviderUtil {

	/**
	 * The (EMF) item provider adapter factory to retrieve the {@link MatchingElement} item provider.
	 */
	protected static ComposedAdapterFactory adapterFactory;
	
	static {
		// Initialize the the (EMF) item provider adapter factory.
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
	}
	/**
	 * Fetches the label image specific to this object instance.
	 * 
	 * @param object
	 *            The object to label.
	 * @return The label image specific to this object instance or <code>null</code>.
	 */
	public static Object getImageByObject(Object object) {
		IItemLabelProvider itemLabelProvider = (IItemLabelProvider) adapterFactory.adapt(
				object, IItemLabelProvider.class);
		
		if (itemLabelProvider != null) {
			return itemLabelProvider.getImage(object);
		} else {
			return null;
		}
	}
	
	/**
	 * Fetches the label image specific to the given type.
	 * 
	 * @param type
	 *            The type.
	 * @return The label image specific to the given type or <code>null</code>.
	 */
	public static Object getImageByType(EClass type) {
		if (type != null) {
			EObject tmp = type.getEPackage().getEFactoryInstance().create(type);
			return getImageByObject(tmp);
		}
		return null;
	}
	
	/**
	 * Fetches the label text specific to this object instance.
	 * 
	 * @param object
	 *            The object to label.
	 * @return The label text specific to this object instance.
	 */
	public static String getTextByObject(Object object) {
		
		if (object != null) {
			IItemLabelProvider itemLabelProvider = (IItemLabelProvider) adapterFactory.adapt(
					object, IItemLabelProvider.class);
			
			if (itemLabelProvider != null) {
				return itemLabelProvider.getText(object);
			} else {
				return object.toString();
			}
		} else {
			return "null";
		}
	}
	
	
	/**
	 * Fetches the label image specific to the given type.
	 * 
	 * @param type
	 *            The type.
	 * @return The label image specific to the given type or <code>null</code>.
	 */
	public static Object getTextByType(EClass type) {
		if (type != null) {
			EObject tmp = type.getEPackage().getEFactoryInstance().create(type);
			return getTextByObject(tmp);
		}
		return null;
	}
}

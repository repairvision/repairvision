package org.sidiff.common.emf;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.xmi.XMIResource;

/**
 * Utility class which provides shortcut functions to several EMF related operations.
 * 
 * @author wenzel, mrindt
 * 
 */
public class EMFUtil {

	/**
	 * Returns an Iterable that iterates over all elements contained in the given element (eAllContents()). It allows to iterate over the content in for-each loops.
	 * 
	 * @param element
	 * @return
	 */
	public static Iterable<EObject> getEAllContentAsIterable(final EObject element) {
		return new Iterable<EObject>() {
			@Override
			public Iterator<EObject> iterator() {
				return new Iterator<EObject>() {
					TreeIterator<EObject> iterator = element.eAllContents();

					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}

					@Override
					public EObject next() {
						return iterator.next();
					}

					@Override
					public boolean hasNext() {
						return iterator.hasNext();
					}
				};
			}
		};
	}

	/**
	 * Returns an Iterable that iterates over all elements contained in the given resource (getAllContents()). It allows to iterate over the content in for-each loops.
	 * 
	 * @param element
	 * @return
	 */
	public static Iterable<EObject> getAllContentAsIterable(final Resource resource) {
		return new Iterable<EObject>() {
			@Override
			public Iterator<EObject> iterator() {
				return new Iterator<EObject>() {
					TreeIterator<EObject> iterator = resource.getAllContents();

					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}

					@Override
					public EObject next() {
						return iterator.next();
					}

					@Override
					public boolean hasNext() {
						return iterator.hasNext();
					}
				};
			}
		};
	}

	public static Map<EObject, EObject> copyAll(Collection<? extends EObject> eObjects){
		Copier copier = new Copier();
		copier.copyAll(eObjects);
		copier.copyReferences();
		
	
		return copier;
	}

	/**
	 * Returns the xmi:id attribute value for the given eObject as a <tt>String</tt>. Returns <b>null</b> in case there's no containing resource or the eObject simply didn't have a xmi:id attribute.
	 */
	public static String getXmiId(EObject eObject) {
		String objectID = null;
		if (eObject != null && eObject.eResource() instanceof XMIResource) {
			objectID = ((XMIResource) eObject.eResource()).getID(eObject);
		}
		return objectID;
	}
	
	/**
	 * Sets the xmi:id attribute value for the given eObject
	 * 
	 * @param eObject
	 * 				the object for that the id is set
	 * @param id
	 * 				the id that is set
	 */
	public static void setXmiId(EObject eObject, String id){
		if (eObject.eResource() instanceof XMIResource) {
			((XMIResource) eObject.eResource()).setID(eObject, id);
		}
	}
}

/**
 */
package org.sidiff.graphpattern.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource Factory</b> associated with the package.
 * <!-- end-user-doc -->
 * @see org.sidiff.graphpattern.util.GraphpatternResourceImpl
 * @generated
 */
public class GraphpatternResourceFactoryImpl extends ResourceFactoryImpl {
	/**
	 * Creates an instance of the resource factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphpatternResourceFactoryImpl() {
		super();
	}
	
	/**
	 * Do nothing while saving the URI.
	 */
	@SuppressWarnings("unused")
	private static class DoNotDeresolve extends URIHandlerImpl {
		@Override
		public URI deresolve(URI uri) {
			return uri;
		}
	}	

	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Resource createResource(URI uri) {
		GraphpatternResourceImpl result = new GraphpatternResourceImpl(uri);
		return result;
	}

} //GraphpatternResourceFactoryImpl

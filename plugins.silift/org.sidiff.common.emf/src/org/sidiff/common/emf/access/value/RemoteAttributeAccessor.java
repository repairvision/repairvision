package org.sidiff.common.emf.access.value;

import org.eclipse.emf.ecore.*;

/**
 * Accessor-API-Interface to encapsulate specific RemoteEAttribute Accessor-engines.  
 */
public interface RemoteAttributeAccessor {

	/**
	 * Causes the translation of a (may engine specific) textual remote EAttribute description into
	 * a Engine specific RemoteEAttribute-Object-Instance for futher usage.
	 *  
	 * @param eClass Starting point of the remote attribute description.
	 * @param eAttributePath An engine specific, textual description.
	 * @return A engine specific handle to the path semantic.
	 */
	public RemoteAttribute translateRemoteAttribute(EClass eClass, String eAttributePath);
	
	/**
	 * Resolves the EAttribute of given RemoteEAttribute.
	 * The Method may returns null if no EAttribute could be determed, or the
	 * underlaying engine is still not able to lookup the EAttribute. 
	 * 
	 * @param remoteEAttribute The RemoteEAttribute witchs resultype shoult be inferd.
	 * @return The EAttribute that was adressed by the given remoteEAttribute.
	 */
	public EAttribute getEAttribute(RemoteAttribute remoteEAttribute);
	
	/**
	 * Evaluates the RemoteEAttribute on a given Node.
	 * 
	 * @param context The context node the evaluation starts.
	 * @param remoteEAttribute Handle to a translated expression.
	 * 
	 * @return A result, regarding the EAttribute-Type
	 */
	public <T> T computeRemoteAttributeValue(EObject context,RemoteAttribute remoteEAttribute);
	
}

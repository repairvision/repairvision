package org.sidiff.revision.configuration;

import java.util.Set;

/**
 * Access to the singletons of different components.
 * 
 * @author Manuel Ohrndorf
 */
public interface SingletonsConfiguration {

	/**
	 * @param component  The class type of the associated component.
	 * @param singletons The new singletons.
	 * @return The old singletons; or <code>null</code>.
	 */
	Singletons addSingletons(Class<?> component, Singletons singletons);

	/**
	 * @param singletons The singleton configurations to be removed.
	 * @return The removed singletons; or <code>null</code>.
	 */
	Singletons removeSingletons(Class<?> component);

	/**
	 * @param component The class type of the associated component.
	 * @return The associated singletons; or <code>null</code>.
	 */
	Singletons singletons(Class<?> component);

	/**
	 * @return All singletons stored in this configuration.
	 */
	Set<Singletons> singletons();
}

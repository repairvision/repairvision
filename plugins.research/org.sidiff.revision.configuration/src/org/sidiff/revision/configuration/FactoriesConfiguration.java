package org.sidiff.revision.configuration;

import java.util.Set;

/**
 * Access to the Factories of different components.
 * 
 * @author Manuel Ohrndorf
 */
public interface FactoriesConfiguration {

	/**
	 * @param component The class type of the associated component.
	 * @param Factories The new factories.
	 * @return The old Factories; or <code>null</code>.
	 */
	Factories addFactories(Class<?> component, Factories Factories);

	/**
	 * @param Factories The singleton configurations to be removed.
	 * @return The removed factories; or <code>null</code>.
	 */
	Factories removeFactories(Class<?> component);

	/**
	 * @param component The class type of the associated component.
	 * @return The associated factories; or <code>null</code>.
	 */
	Factories factories(Class<?> component);

	/**
	 * @return All factories stored in this configuration.
	 */
	Set<Factories> factories();
}

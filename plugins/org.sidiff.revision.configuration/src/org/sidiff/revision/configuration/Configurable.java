package org.sidiff.revision.configuration;

import java.util.Set;

/**
 * Creates the default settings for a component.
 * 
 * @author Manuel Ohrndorf
 */
public interface Configurable {

	/**
	 * Creates the default settings for this component.
	 * 
	 * @param config A configuration container.
	 * @param reset  Reset existing properties.
	 */
	void createDefaultSettings(Configuration config, boolean reset);

	/**
	 * @return All used/required settings properties of this component.
	 */
	Set<? extends Enum<?>> settings();

	/**
	 * Creates the default bindings for this component.
	 * 
	 * @param config A configuration container.
	 * @param reset  Reset existing bindings.
	 */
	void createDefaultBindings(Configuration config, boolean reset);

	/**
	 * @return All used/required bindings (class type to object) of this component.
	 */
	Set<Class<?>> bindings();
}

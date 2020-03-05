package org.sidiff.revision.configuration;

import java.util.Set;

/**
 * Stores one (singleton) object binding per type ({@link Bindings}). Settings
 * ({@link Settings}) are stored by its enumeration class type. The
 * configuration supports direct access to settings properties.
 * 
 * @author Manuel Ohrndorf
 */
public interface Configuration extends Bindings {

	/**
	 * @param <P>        The type defining the properties of the associated
	 *                   settings.
	 * @param definition The class type defining the properties of the associated
	 *                   settings.
	 * @return The associated settings; or <code>null</code>.
	 */
	<P extends Enum<?>> Settings<P> settings(Class<P> properties);

	/**
	 * @param property The class type defining the properties of the associated
	 *                 settings.
	 * @return The removed settings object.
	 */
	<P extends Enum<?>> Settings<P> remove(Class<P> properties);

	/**
	 * @return All settings stored in this configuration.
	 */
	Set<Settings<? extends Enum<?>>> settings();

	/**
	 * @param property A property of a setting contained by the configuration.
	 * @return The value of the property; or <code>null</code>.
	 */
	Object get(Enum<?> property);

	/**
	 * @param property A property of a setting. The setting will be created in the
	 *                 configuration if it is not already existing.
	 * @param value    The new value of the property
	 * @return The old value of the property; or <code>null</code>.
	 */
	Object set(Enum<?> property, Object value);
}

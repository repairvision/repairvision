package org.sidiff.revision.configuration;

import java.util.Set;

/**
 * Access to the settings of different components.
 * 
 * @author Manuel Ohrndorf
 */
public interface SettingsConfiguration {

	/**
	 * @param <P>        The type defining the properties of the associated
	 *                   settings.
	 * @param properties The class type defining the properties of the associated
	 *                   settings.
	 * @param settings   The new settings object.
	 * @return The old settings object; or <code>null</code>.
	 */
	<P extends Enum<?>> Settings<P> addSettings(Class<P> properties, Settings<P> settings);

	/**
	 * @param <P>      The type defining the properties of the associated settings.
	 * @param property The class type defining the properties of the associated
	 *                 settings.
	 * @return The removed settings object.
	 */
	<P extends Enum<?>> Settings<P> removeSettings(Class<P> properties);

	/**
	 * @param <P>        The type defining the properties of the associated
	 *                   settings.
	 * @param definition The class type defining the properties of the associated
	 *                   settings.
	 * @return The associated settings; or <code>null</code>.
	 */
	<P extends Enum<?>> Settings<P> settings(Class<P> properties);

	/**
	 * @return All settings stored in this configuration.
	 */
	Set<Settings<? extends Enum<?>>> settings();
}

package org.sidiff.revision.configuration;

import java.util.Set;

/**
 * Stores one (singleton) object binding per type ({@link Singletons}). Class
 * types mapped to class types can be used as Factories
 * {@link #create(Class, Object...)}. Settings ({@link Settings}) are stored by
 * its enumeration class type. The configuration supports direct access to
 * settings properties.
 * 
 * @author Manuel Ohrndorf
 */
public interface Configuration extends Singletons, Factories {

	/**
	 * @param <P>        The type defining the properties of the associated
	 *                   settings.
	 * @param properties The class type defining the properties of the associated
	 *                   settings.
	 * @param settings   The new settings object.
	 * @return The old settings object; or <code>null</code>.
	 */
	<P extends Enum<?>> Settings<P> add(Class<P> properties, Settings<P> settings);

	/**
	 * @param <P>      The type defining the properties of the associated settings.
	 * @param property The class type defining the properties of the associated
	 *                 settings.
	 * @return The removed settings object.
	 */
	<P extends Enum<?>> Settings<P> remove(Class<P> properties);

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

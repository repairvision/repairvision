package org.sidiff.revision.configuration;

import java.util.Set;

/**
 * Stores property-value pairs. The properties are defined by an enumeration.
 * 
 * @author Manuel Ohrndorf
 */
public interface Settings<P extends Enum<?>> extends Singletons, Factories {

	/**
	 * @return All enumeration literal that define the properties.
	 */
	Set<P> properties();

	/**
	 * @param property A settings property.
	 * @return The associated value.
	 */
	Object property(P property);

	/**
	 * @param property A settings property.
	 * @param value    The new associated value.
	 * @return The old associated value.
	 */
	Object setProperty(P property, Object value);

}

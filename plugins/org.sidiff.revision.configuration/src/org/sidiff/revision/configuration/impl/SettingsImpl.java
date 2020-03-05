package org.sidiff.revision.configuration.impl;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

import org.sidiff.revision.configuration.Settings;

/**
 * A (enum) map based implementation to store properties.
 * 
 * @author Manuel Ohrndorf
 * @see Settings
 * @see BindingImpl
 */
public class SettingsImpl<P extends Enum<?>> extends BindingImpl implements Settings<P> {

	private Map<P, Object> properties;
	
	@Override
	public Set<P> properties() {
		if (properties == null) {
			return Collections.emptySet();
		} else {
			return Collections.unmodifiableSet(getProperties().keySet());
		}
	}

	@Override
	public Object get(P property) {
		if (properties == null) {
			return null;
		} else {
			return getProperties().get(property);
		}
	}

	@Override
	public Object set(P property, Object value) {
		if (value == null) {
			return getProperties().remove(property);
		} else {
			return getProperties().put(property, value);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Map<P, Object> getProperties() {
		if (properties == null) {
			this.properties = new EnumMap(properties);
		}
		return properties;
	}
}

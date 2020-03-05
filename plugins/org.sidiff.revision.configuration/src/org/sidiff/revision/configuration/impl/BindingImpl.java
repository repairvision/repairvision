package org.sidiff.revision.configuration.impl;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.sidiff.revision.configuration.Bindings;

/**
 * A (insertion-ordered) map based implementation of {@link Bindings}.
 * 
 * @author Manuel Ohrndorf
 * @see Bindings
 */
public class BindingImpl implements Bindings {

	private Map<Class<?>, Object> bindings;

	@Override
	public Set<Class<?>> bindings() {
		if (bindings == null) {
			return Collections.emptySet();
		} else {
			return Collections.unmodifiableSet(getBindings().keySet());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(Class<T> type) {
		if (bindings == null) {
			return null;
		} else {
			return (T) getBindings().get(type);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T set(Class<T> type, T binding) {
		if (binding == null) {
			return (T) getBindings().remove(type);
		} else {
			return (T) getBindings().put(type, binding);
		}
	}
	
	private Map<Class<?>, Object> getBindings() {
		if (bindings == null) {
			this.bindings = new LinkedHashMap<>();
		}
		return bindings;
	}
}

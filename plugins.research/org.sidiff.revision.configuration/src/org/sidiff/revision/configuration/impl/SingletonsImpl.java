package org.sidiff.revision.configuration.impl;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.sidiff.revision.configuration.Singletons;

/**
 * A (insertion-ordered) map based singleton settings implementation.
 * 
 * @author Manuel Ohrndorf
 */
public class SingletonsImpl implements Singletons {

	private Map<Class<?>, Object> singletons;

	@Override
	public Set<Class<?>> singletons() {
		if (singletons == null) {
			return Collections.emptySet();
		} else {
			return Collections.unmodifiableSet(getSingletons().keySet());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(Class<T> type) {
		if (singletons == null) {
			return null;
		} else {
			return (T) getSingletons().get(type);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T set(Class<T> type, T binding) {
		if (binding == null) {
			return (T) getSingletons().remove(type);
		} else {
			return (T) getSingletons().put(type, binding);
		}
	}

	private Map<Class<?>, Object> getSingletons() {
		if (singletons == null) {
			this.singletons = new LinkedHashMap<>();
		}
		return singletons;
	}
}

package org.sidiff.revision.configuration.impl;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.sidiff.revision.configuration.Factories;
import org.sidiff.revision.configuration.Factory;

/**
 * A (insertion-ordered) map based factory settings implementation.
 * 
 * @author Manuel Ohrndorf
 */
public class FactoriesImpl implements Factories {

	private Map<Class<?>, Factory<?>> factories;

	@Override
	public Set<Class<?>> factories() {
		if (factories == null) {
			return Collections.emptySet();
		} else {
			return Collections.unmodifiableSet(getFactories().keySet());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> Factory<T> get(Class<T> type) {
		if (factories == null) {
			return null;
		} else {
			return (Factory<T>) getFactories().get(type);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> Factory<T> set(Class<T> type, Factory<T> factory) {
		if (factory == null) {
			return (Factory<T>) getFactories().remove(type);
		} else {
			return (Factory<T>) getFactories().put(type, factory);
		}
	}

	private Map<Class<?>, Factory<?>> getFactories() {
		if (factories == null) {
			this.factories = new LinkedHashMap<>();
		}
		return factories;
	}

	@Override
	public <T> T create(Class<T> type) {
		Factory<T> factory = get(type);
		
		if (factory != null) {
			return factory.create();
		} else {
			return null;
		}
	}
}

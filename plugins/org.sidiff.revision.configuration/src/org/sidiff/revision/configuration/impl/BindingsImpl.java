package org.sidiff.revision.configuration.impl;

import java.beans.Expression;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.sidiff.revision.configuration.Factories;
import org.sidiff.revision.configuration.Singletons;

/**
 * A (insertion-ordered) map based singleton and factory settings
 * implementation.
 * 
 * @author Manuel Ohrndorf
 */
public class BindingsImpl implements Singletons, Factories {

	private Map<Class<?>, Object> singletons;

	private Map<Class<?>, Class<?>> factories;

	// Singletons:

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
	public <T> T singleton(Class<T> type) {
		if (singletons == null) {
			return null;
		} else {
			return (T) getSingletons().get(type);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T setSingleton(Class<T> type, T binding) {
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

	// Factories:

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
	public <T> Class<? extends T> factory(Class<T> type) {
		if (factories == null) {
			return null;
		} else {
			return (Class<? extends T>) getFactories().get(type);
		}
	}

	@Override
	public Class<?> setFactory(Class<?> type, Class<?> binding) {
		if (binding == null) {
			return getFactories().remove(type);
		} else {
			return getFactories().put(type, binding);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T create(Class<T> type, Object... constructorArguments) {
		try {
			return (T) new Expression(factory(type), "new", constructorArguments).getValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private Map<Class<?>, Class<?>> getFactories() {
		if (factories == null) {
			this.factories = new LinkedHashMap<>();
		}
		return factories;
	}
}

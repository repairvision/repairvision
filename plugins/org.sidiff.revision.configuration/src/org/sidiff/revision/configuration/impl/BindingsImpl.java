package org.sidiff.revision.configuration.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.sidiff.revision.configuration.Factories;
import org.sidiff.revision.configuration.Singletons;

/**
 * A (insertion-ordered) map based singleton and factory settings implementation.
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

	@SuppressWarnings("unchecked")
	@Override
	public <T> T setFactory(Class<T> type, Class<? extends T> binding) {
		if (binding == null) {
			return (T) getFactories().remove(type);
		} else {
			return (T) getFactories().put(type, binding);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T create(Class<T> type, Object... constructor) {
		try {
			Class<?>[] parameterTypes = Arrays.asList(constructor).stream().map(Object::getClass)
					.collect(Collectors.toList()).toArray(new Class<?>[0]);
			return (T) ((Class<?>) factory(type)).getDeclaredConstructor(parameterTypes).newInstance(constructor);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
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

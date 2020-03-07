package org.sidiff.revision.configuration.impl;

import java.beans.Expression;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.sidiff.revision.configuration.Factories;

/**
 * A (insertion-ordered) map based factory settings implementation.
 * 
 * @author Manuel Ohrndorf
 */
public class FactoriesImpl implements Factories {

	private Map<Class<?>, Class<?>> factories;

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
	public <T> Class<? extends T> get(Class<T> type) {
		if (factories == null) {
			return null;
		} else {
			return (Class<? extends T>) getFactories().get(type);
		}
	}

	@Override
	public Class<?> set(Class<?> type, Class<?> binding) {
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
			return (T) new Expression(get(type), "new", constructorArguments).getValue();
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

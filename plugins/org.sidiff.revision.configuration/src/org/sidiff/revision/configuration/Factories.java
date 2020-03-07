package org.sidiff.revision.configuration;

import java.util.Set;

/**
 * Stores one (factory) (sub) class type binding per type ({@link Factories}).
 * 
 * @author Manuel Ohrndorf
 */
public interface Factories {

	/**
	 * @return All current factories as set of the bound types.
	 */
	Set<Class<?>> factories();

	/**
	 * @param <T>  The type of the binding.
	 * @param type The class type of the binding.
	 * @return The (sub) class type that is bound to the type; or <code>null</code>.
	 */
	<T> Class<? extends T> get(Class<T> type);

	/**
	 * @param <T>     The type of the binding.
	 * @param type    The class type of the binding
	 * @param binding The (sub) class type that should be bound to the type.
	 * @return The old class type that was bound to the type; or <code>null</code>.
	 */
	Class<?> set(Class<?> type, Class<?> binding);

	/**
	 * @param <T>                  The type of the object to be created.
	 * @param type                 The type of the object to be created.
	 * @param constructorArguments The constructor arguments.
	 * @return A new instance of the given type, based on the concrete bound type.
	 */
	<T> T create(Class<T> type, Object... constructorArguments);
}

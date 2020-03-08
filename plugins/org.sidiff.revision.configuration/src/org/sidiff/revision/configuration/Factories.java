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
	<T> Factory<T> get(Class<T> type);

	/**
	 * @param <T>     The type of the factory.
	 * @param type    The class type of factory
	 * @param factory The factory that should be bound to the type.
	 * @return The old class type that was bound to the type; or <code>null</code>.
	 */
	<T> Factory<T> set(Class<T> type, Factory<T> factory);

	/**
	 * @param <T>                  The type of the object to be created.
	 * @param type                 The type of the object to be created.
	 * @return A new instance of the given type, based on the concrete bound type.
	 */
	<T> T create(Class<T> type);
}

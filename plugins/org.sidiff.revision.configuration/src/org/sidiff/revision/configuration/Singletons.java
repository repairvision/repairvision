package org.sidiff.revision.configuration;

import java.util.Set;

/**
 * Stores one (singleton) object binding per type ({@link Singletons}).
 * 
 * @author Manuel Ohrndorf
 */
public interface Singletons {

	/**
	 * @return All current bindings as set of the bound types.
	 */
	Set<Class<?>> singletons();

	/**
	 * @param <T>  The type of the binding.
	 * @param type The class type of the binding.
	 * @return The object that is bound to the type; or <code>null</code>.
	 */
	<T> T get(Class<T> type);

	/**
	 * @param <T>     The type of the binding.
	 * @param type    The class type of the binding
	 * @param binding The object that should be bound to the type.
	 * @return The old object that was bound to the type; or <code>null</code>.
	 */
	<T> T set(Class<T> type, T binding);

}

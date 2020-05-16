package org.sidiff.revision.configuration;

/**
 * A functional interface for wrapping a factory.
 * 
 * @author Manuel Ohrndorf
 */
@FunctionalInterface
public interface Factory<T> {

	/**
	 * @return The new instance of {@link #T}
	 */
	T create();
}

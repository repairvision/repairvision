package org.sidiff.revision.configuration.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.sidiff.revision.configuration.Configurable;
import org.sidiff.revision.configuration.Configuration;
import org.sidiff.revision.configuration.annotations.ConfigField;
import org.sidiff.revision.configuration.annotations.ConfigProperties;

/**
 * {@link Configuration} and {@link Configurable} convenience methods.
 * 
 * @author Manuel Ohrndorf
 */
public class ConfigUtil {

	/**
	 * @param configurable A configurable object.
	 * @return The configuration properties contained in the annotated field
	 *         ({@link ConfigField}); or <code>null</code>.
	 */
	@SuppressWarnings("unchecked")
	public static Class<? extends Enum<?>> getConfigProperties(Configurable configurable) {
		for (Class<?> type : configurable.getClass().getDeclaredClasses()) {
			if (type.isEnum() && type.isAnnotationPresent(ConfigProperties.class)) {
				return (Class<? extends Enum<?>>) type;
			}
		}
		return null;
	}

	/**
	 * Reads a value from the (first) field with a specific annotation.
	 * 
	 * @param configurable A configurable object.
	 * @return The value contained in the annotated field; or <code>null</code>.
	 */
	public static Object read(Configurable configurable, Class<? extends Annotation> annotation) {
		for (Field field : configurable.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(annotation)) {
				try {
					return field.get(configurable);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	/**
	 * Writes a value into all fields with a specific annotation.
	 * 
	 * @param target     The configuration contained in the annotated field
	 *                   ({@link ConfigField}); or <code>null</code>.
	 * @param annotation The annotation of the field(s).
	 * @param value      The value to write.
	 */
	public static void write(Configurable configurable, Class<? extends Annotation> annotation, Object value) {
		for (Field field : configurable.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(annotation)) {
				try {
					boolean accessible = field.isAccessible();
					field.setAccessible(true);
					field.set(configurable, value);
					field.setAccessible(accessible);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

package org.sidiff.revision.configuration.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.sidiff.revision.configuration.Configurable;
import org.sidiff.revision.configuration.Configuration;
import org.sidiff.revision.configuration.Settings;
import org.sidiff.revision.configuration.annotations.ConfigField;
import org.sidiff.revision.configuration.annotations.ConfigProperties;
import org.sidiff.revision.configuration.annotations.ConfigSettings;

/**
 * {@link Configuration} and {@link Configurable} convenience methods.
 * 
 * @author Manuel Ohrndorf
 */
public class ConfigUtil {

	/**
	 * @param elements The types of the set.
	 * @return A set containing all given types.
	 */
	public static Set<Class<?>> createTypeSet(Class<?>... elements) {
		if (elements.length == 0) {
			return Collections.emptySet();
		} else if (elements.length == 1) {
			return Collections.singleton(elements[0]);
		} else {
			return new HashSet<>(Arrays.asList(elements));
		}
		
	}

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
	 * @param configurable A configurable object.
	 * @return The settings contained in the annotated field
	 *         ({@link ConfigSettings}); or <code>null</code>.
	 */
	public static Settings<? extends Enum<?>> getConfigSettings(Configurable configurable) {
		for (Field field : configurable.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(ConfigSettings.class)) {
				try {
					return (Settings<?>) field.get(configurable);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	/**
	 * @param configurable A configurable object.
	 * @return The configuration contained in the annotated field
	 *         ({@link ConfigField}); or <code>null</code>.
	 */
	public static Configuration getConfigField(Configurable configurable) {
		for (Field field : configurable.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(ConfigField.class)) {
				try {
					return (Configuration) field.get(configurable);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	/**
	 * Injects a value into all fields with a specific annotation.
	 * 
	 * @param target     The object which need injection.
	 * @param annotation The annotation of the field(s).
	 * @param value      The value to be injected.
	 */
	public static void inject(Object target, Class<? extends Annotation> annotation, Object value) {
		for (Field field : target.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(annotation)) {
				try {
					field.set(target, value);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

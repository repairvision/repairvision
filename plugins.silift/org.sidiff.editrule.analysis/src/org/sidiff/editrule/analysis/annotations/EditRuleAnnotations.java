
package org.sidiff.editrule.analysis.annotations;

import java.util.Iterator;

import org.eclipse.emf.henshin.model.Annotation;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.ModelElement;
import org.eclipse.emf.henshin.model.Module;

/**
 * Handles the edit-rule annotations.
 * 
 * @author Manuel Ohrndorf
 */
public class EditRuleAnnotations {
	
	/**
	 * Default application condition type; if none was set:
	 */
	public static Condition DEFAULT_CONDITION_TYPE = Condition.post;
	
	/**
	 * <ul>
	 * <li>priority: < integer ></li>
	 * <li>condition: < pre > | < post >
	 * </li>
	 * </ul>
	 */
	public static enum ModuleAnnotations {
		priority,
		condition
	}
	
	/**
	 * Application condition types:
	 */
	public static enum Condition {
		pre,
		post
	}
	
	/**
	 * Test if the annotation is known edit-rule flag.
	 * 
	 * @param annotation
	 *            The annotation to test.
	 * @return <code>true</code> if the annotation is known; <code>false</code> otherwise.
	 */
	public static boolean isKnownAnnotation(Annotation annotation) {
		ModuleAnnotations known = null;
		
		try {
			known = ModuleAnnotations.valueOf(annotation.getKey());
		} catch (Exception e) {
			return false;
		}
		
		if (known != null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Converts an annotation type ({@link EditRuleAnnotations.ModuleAnnotations},
	 * {@link EditRuleAnnotations.Condition}) to a string.
	 * 
	 * @param type
	 *            The annotation type.
	 * @return The type name as a string.
	 */
	public static String getAnnotationKey(Enum<?> type) {
		return type.name();
	}
	
	/**
	 * Returns the the application condition type (pre or post) of an application condition graph.
	 * 
	 * @param applicationCondition
	 *            The application condition graph.
	 * @return The application condition type (pre or post).
	 */
	public static Condition getCondition(Graph applicationCondition) {
		String value = getAnnotation(applicationCondition, ModuleAnnotations.condition);
		
		if (value != null) {
			return Condition.valueOf(value);
		}
		
		return DEFAULT_CONDITION_TYPE;
	}
	
	/**
	 * Sets the annotation {@link EditRuleAnnotations.ModuleAnnotations}.condition:
	 * 
	 * @param applicationCondition
	 *            The application condition graph.
	 * @param value
	 *            The application condition type (pre or post).
	 */
	public static void setCondition(Graph applicationCondition, Condition value) {
		setAnnotation(applicationCondition, ModuleAnnotations.condition, getAnnotationKey(value));
	}
	
	/**
	 * Removes the annotation {@link EditRuleAnnotations.ModuleAnnotations}.condition:
	 * 
	 * @param applicationCondition
	 *            The application condition graph.
	 */
	public static void removeCondition(Graph applicationCondition) {
		removeAnnotation(applicationCondition, ModuleAnnotations.condition);
	}
	
	/**
	 * Adds the annotation {@link EditRuleAnnotations.ModuleAnnotations}.condition:
	 * 
	 * @param applicationCondition
	 *            The application condition graph.
	 * @param value
	 *            The application condition type (pre or post).
	 */
	public static void addCondition(Graph applicationCondition, Condition value) {
		createAnnotation(applicationCondition, ModuleAnnotations.priority, getAnnotationKey(value));
	}
	
	/**
	 * Returns the the post processing priority of the given module.
	 * 
	 * @param editRule
	 *            The edit-rule module.
	 * @return The post processing priority or <code>null</code>.
	 */
	public static Integer getPriority(Module editRule) {
		String value = getAnnotation(editRule, ModuleAnnotations.priority);
		
		if (value != null) {
			return Integer.valueOf(value);
		}
		
		return null;
	}
	
	/**
	 * Sets the annotation {@link EditRuleAnnotations.ModuleAnnotations}.priority:
	 * 
	 * @param editRule
	 *            The edit-rule module.
	 * @param value
	 *            The post processing priority.
	 */
	public static void setPriority(Module editRule, int value) {
		setAnnotation(editRule, ModuleAnnotations.priority, value + "");
	}
	
	/**
	 * Sets the annotation {@link EditRuleAnnotations.ModuleAnnotations}.priority:
	 * 
	 * @param editRule
	 *            The edit-rule module.
	 */
	public static void removePriority(Module editRule) {
		removeAnnotation(editRule, ModuleAnnotations.priority);
	}
	
	/**
	 * Adds the annotation {@link EditRuleAnnotations.ModuleAnnotations}.priority:
	 * 
	 * @param editRule
	 *            The edit-rule module.
	 * @param priority
	 *            The post processing priority.
	 */
	public static void addPriority(Module editRule, int priority) {
		createAnnotation(editRule, ModuleAnnotations.priority, priority + "");
	}
	
	/**
	 * Creates a new Henshin annotation.
	 * 
	 * @param element
	 *            The Henshin model element.
	 * @param type
	 *            The annotation key as type.
	 * @param value
	 *            The annotation value.
	 */
	private static void createAnnotation(ModelElement element, Enum<?> type, String value) {
		Annotation annotation = HenshinFactory.eINSTANCE.createAnnotation();
		annotation.setKey(getAnnotationKey(type));
		annotation.setValue(value);
		element.getAnnotations().add(annotation);
	}
	
	/**
	 * Returns a Henshin annotation.
	 * 
	 * @param element
	 *            The Henshin model element.
	 * @param type
	 *            The annotation key as type.
	 * @return The annotation value.
	 */
	private static String getAnnotation(ModelElement element, Enum<?> type) {
		String key = getAnnotationKey(type);
		
		for (Iterator<Annotation> it = element.getAnnotations().iterator(); it.hasNext();) {
			Annotation annotation = it.next();
			
			if (annotation.getKey().equals(key)) {
				return annotation.getValue();
			}
		}
		
		return null;
	}
	
	/**
	 * Removes a Henshin annotation.
	 * 
	 * @param element
	 *            The Henshin model element.
	 * @param type
	 *            The annotation key as type.
	 */
	private static void removeAnnotation(ModelElement element, Enum<?> type) {
		String key = getAnnotationKey(type);
		
		for (Iterator<Annotation> it = element.getAnnotations().iterator(); it.hasNext();) {
			Annotation annotation = it.next();
			
			if (annotation.getKey().equals(key)) {
				it.remove();
				break;
			}
		}
	}
	
	/**
	 * Sets a Henshin annotation.
	 * 
	 * @param element
	 *            The Henshin model element.
	 * @param type
	 *            The annotation key as type.
	 * @param value
	 *            The annotation value.
	 */
	private static void setAnnotation(ModelElement element, Enum<?> type, String value) {
		String key = getAnnotationKey(type);
		boolean found = false;
		
		// Search existing annotation:
		for (Iterator<Annotation> it = element.getAnnotations().iterator(); it.hasNext();) {
			Annotation annotation = it.next();
			
			if (annotation.getKey().equals(key)) {
				found = true;
				annotation.setValue(value);
				break;
			}
		}
		
		// Create a new annotation if necessary:
		if (!found) {
			createAnnotation(element, type, value);
		}
	}
}

package org.sidiff.validation.constraint.project;

/**
 * Defines the default structure of a constraint library plug-in.
 * 
 * @author Manuel Ohrndorf
 */
public class ConstraintPlugin {

	public static String CONSTRAINT_INTERPRETER_DEPENDENCIE =  "org.sidiff.validation.constraint.interpreter";
	
	/**
	 * Plug-in which offers the extension point schema of {@link #EXTENSION_POINT_ID}.
	 */
	public static String EXTENSION_POINT_DEPENDENCIE = "org.sidiff.validation.constraint.project";
	
	/**
	 * Extension point which registers a constraint library.
	 */
	public static String EXTENSION_POINT_ID  = "org.sidiff.validation.constraint.project.library";
	
	/**
	 * {@link #EXTENSION_POINT_ID} element which registers a constraint library.
	 */
	public static String EXTENSION_POINT_ELEMENT_LIBRARY = "library";
	
	/**
	 * {@link #EXTENSION_POINT_ELEMENT_RULEBASE} attribute which defines the name of the constraint library.
	 */
	public static String EXTENSION_POINT_ATTRIBUTE_LIBRARY_LIBRARY = "library";
		
}

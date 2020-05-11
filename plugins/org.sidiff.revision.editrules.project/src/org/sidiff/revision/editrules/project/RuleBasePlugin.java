package org.sidiff.revision.editrules.project;

/**
 * Defines the default structure of a rulebase plug-in.
 * 
 * @author Manuel Ohrndorf
 */
public class RuleBasePlugin {

	/**
	 * Plug-in which offers the extension point schema of {@link #EXTENSION_POINT_ID}.
	 */
	public static String EXTENSION_POINT_DEPENDENCIE = "org.sidiff.revision.editrules.project";
	
	/**
	 * Extension point which registers a rulebase.
	 */
	public static String EXTENSION_POINT_ID  = "org.sidiff.revision.editrules.project.rulebase";
	
	/**
	 * {@link #EXTENSION_POINT_ID} element which registers a rulebase.
	 */
	public static String EXTENSION_POINT_ELEMENT_RULEBASE = "rulebase";
	
	/**
	 * {@link #EXTENSION_POINT_ELEMENT_RULEBASE} attribute which defines the name of the rulebase.
	 */
	public static String EXTENSION_POINT_ATTRIBUTE_RULEBASE_NAME = "name";
	
	/**
	 * {@link #EXTENSION_POINT_ELEMENT_RULEBASE} attribute which defines the document type of the rulebase.
	 */
	public static String EXTENSION_POINT_ATTRIBUTE_RULEBASE_DOCUMENT_TYPE = "document-type";
	
	/**
	 * {@link #EXTENSION_POINT_ELEMENT_RULEBASE} attribute which defines the folder containing the Henshin edit rules.
	 */
	public static String EXTENSION_POINT_ATTRIBUTE_RULEBASE_FOLDER = "folder";
	
	/**
	 * The base folder which contains the Henshin edit-rules.
	 */
	public static final String EDIT_RULE_FOLDER = "editrules";
	
	/**
	 * The base folder which contains the ASG pattern examples.
	 */
	public static final String EXAMPLE_FOLDER = "examples";

	/**
	 * The plug-in relative path to the ASG patterns file.
	 */
	public static final String GRAPHPATTERN_FILE = "patterns/patterns.graphpattern";
	
	/**
	 * The plug-in relative path to the Graph-Pattern based edit rule file.
	 */
	public static final String GRAPHPATTERN_EDIT_RULE_FILE = "patterns/editrules.graphpattern";
	
}

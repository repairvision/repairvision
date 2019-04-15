package org.sidiff.editrule.analysis.conditions;

/**
 * Configuration of edit-rule specific features/interpretations.
 * 
 * @author Manuel Ohrndorf
 */
public class EditRuleConditionsConfiguration {

	/**
	 * Configuration if a << preserve >> edge will be interpreted as a precondition.
	 * 
	 * @return <code>true</code> if it will be interpreted as a precondition;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isPreservedEdgePreCondition() {
		return false;
	}

	/**
	 * Configuration if a << preserve >> edge will be interpreted as a postcondition
	 * 
	 * @return <code>true</code> if it will be interpreted as a postcondition;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isPreservedEdgePostCondition() {
		return true;
	}

	/**
	 * Configuration if a << preserve / delete >> attribute in a << preserve >> node
	 * will be interpreted as a precondition.
	 * 
	 * @return <code>true</code> if it will be interpreted as a precondition;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isPreservedAttributePreCondition() {
		return false;
	}

	/**
	 * Configuration if a << preserve / delete >> attribute in a << preserve >>
	 * node will be interpreted as a postcondition.
	 * 
	 * @return <code>true</code> if it will be interpreted as a postcondition;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isPreservedAttributePostCondition() {
		return true;
	}
}

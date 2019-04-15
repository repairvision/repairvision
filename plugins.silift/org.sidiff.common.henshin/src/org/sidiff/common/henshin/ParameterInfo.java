package org.sidiff.common.henshin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.ParameterMapping;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;

/**
 * Utility functions for Henshin parameters.
 * 
 * @author kehrer, mohrndorf, cpietsch
 */
public class ParameterInfo {

	public enum ParameterDirection {
		IN, OUT
	};

	public enum ParameterKind {
		OBJECT, VALUE
	};

	/**
	 * Prüft, ob Parameter ein IN Parameter oder ein OUT Parameter ist.
	 * Ausschlaggebend dafür sind die ParameterMappings der Unit. <br/>
	 * 
	 * 
	 * Anmerkung: Die frühere Ausprägung INOUT ist obsolet; INOUT Parameter
	 * werden als IN Parameter angesehen.
	 * 
	 * @param parameter
	 * @return
	 */
	public static ParameterDirection getParameterDirection(Parameter parameter) {
		assert (isUnitParameter(parameter)) : "The IN/OUT-query is currently only supported for unit parameters!";

		EList<ParameterMapping> mappings = parameter.getUnit().getParameterMappings();

		boolean in = false;
		boolean out = false;

		// Go through the parameter mappings
		for (ParameterMapping mapping : mappings) {
			if (mapping.getTarget().equals(parameter)) {
				out = true;
			} else if (mapping.getSource().equals(parameter)) {
				in = true;
			}
		}

		if (in && out) {
			return ParameterDirection.IN;
		} else if (out) {
			return ParameterDirection.OUT;
		} else if (in) {
			return ParameterDirection.IN;
		} else {
			assert (false) : "Unmapped parameter?: " + parameter.getName();
		}

		return null;
	}

	/**
	 * Checks whether the given parameter is a value parameter or a object
	 * parameter. Parameters of type EDataType or one of its subclasses are
	 * considered as object parameter.
	 * 
	 * Note that this method returns null if no type can be found
	 * 
	 * @param parameter
	 * @return
	 */
	public static ParameterKind getParameterKind(Parameter parameter) {
		EClassifier type = getRealType(parameter);
		if (type == null) {
			return null;
		}

		if (EDataType.class.isAssignableFrom(type.getClass())) {
			return ParameterKind.VALUE;
		} else {
			return ParameterKind.OBJECT;
		}
	}

	/**
	 * Get the node that is identified by this parameter. Remark: There might be
	 * a node which is identified by the given parameter.name both in LHS and in
	 * RHS. So the second parameter <code>lhs</code> determines whether to
	 * search in LHS (true) or in RHS (false).
	 * 
	 * Please note that this method only supports OBJECT-parameter.
	 * 
	 * @param parameter
	 * @param lhs
	 *            true: search in LHS false: search in RHS
	 * 
	 * @return the Node which is finally identified by the given
	 *         object-parameter
	 */
	public static Node getInnermostIdentifiedNode(Parameter parameter, boolean lhs) {
		assert (getParameterKind(parameter).equals(ParameterKind.OBJECT)) : "Nodes are only identified by object parameters. However, "
				+ parameter.getName() + " is a value parameter!";

		Parameter oppositeParameter = getInnermostParameter(parameter);
		Rule rule = (Rule) oppositeParameter.eContainer();

		if (lhs) {
			// Check LHS
			Node node = rule.getLhs().getNode(oppositeParameter.getName());
			if (node != null) {
				return node;
			}
		} else {
			// Check RHS
			// the next step is necessary since rule.getNodeByName searches only
			// in LHS
			for (Node n : rule.getRhs().getNodes()) {
				if (oppositeParameter.getName().equals(n.getName())) {
					return n;
				}
			}
		}

		return null;
	}

	/**
	 * Gets the type of the given parameter.<br/>
	 * Works both for OBJECT and VALUE parameters.
	 * 
	 * @param parameter
	 * @param checkDeclaredType
	 *            try to use the type definition which is statically declared in
	 *            the parameter declaration
	 * @return
	 */
	public static EClassifier getRealType(Parameter parameter, boolean checkDeclaredType) {

		if (checkDeclaredType && parameter.getType() != null) {
			return parameter.getType();
		}

		Parameter oppositeParameter = getInnermostParameter(parameter);

		// Begin Assertions
		assert (oppositeParameter != null) : "Unmapped parameter" + parameter.getName();
		assert (!(isUnitParameter(parameter) && parameter == oppositeParameter)) : "Unmapped Unit parameter"
				+ parameter.getName();
		// End Assertions

		Rule rule = (Rule) oppositeParameter.eContainer();
		Node node = null;

		// Check LHS
		node = rule.getLhs().getNode(oppositeParameter.getName());
		if (node != null) {
			return node.getType();
		}

		// Check RHS
		// the next step is necessary since rule.getNodeByName searches only in
		// LHS
		for (Node n : rule.getRhs().getNodes()) {
			if ((n.getName() != null) && (n.getName().equals(oppositeParameter.getName()))) {
				node = n;
				return node.getType();
			}
		}

		// node not found in RHS/LHS : oppositeParameter points to an attribute
		return findTypeOfAnAttribute(oppositeParameter);
	}

	/**
	 * Gets the type of the given parameter.<br/>
	 * Works both for OBJECT and VALUE parameters.
	 * 
	 * Note that this variant of getRealType() checks the declared type of the
	 * parameter, i.e. calls getRealType(parameter,true).
	 * 
	 * @param parameter
	 * @return
	 */
	public static EClassifier getRealType(Parameter parameter) {
		return getRealType(parameter, true);
	}

	private static EDataType findTypeOfAnAttribute(Parameter oppositeParameter) {

		// container must be Rule here
		assert (oppositeParameter.eContainer() instanceof Rule) : "Can only find attributes in Rules!";

		Rule rule = (Rule) oppositeParameter.eContainer();

		// get all attributes under all nodes of RHS
		EList<Node> rightNodes = rule.getRhs().getNodes();
		List<Attribute> rightAttributes = new ArrayList<Attribute>();
		for (Node rN : rightNodes) {
			rightAttributes.addAll(rN.getAttributes());
		}

		// get the type (if its the correct attribute)
		for (Attribute rA : rightAttributes) {
			if (getUsedParameters(rule, rA).contains(oppositeParameter)) {
				return rA.getType().getEAttributeType();
			}
		}

		// try to find attribute under LHS, if it is not under RHS

		// get all attributes under all nodes of LHS
		EList<Node> leftNodes = rule.getLhs().getNodes();
		List<Attribute> leftAttributes = new ArrayList<Attribute>();
		for (Node lN : leftNodes) {
			leftAttributes.addAll(lN.getAttributes());
		}

		// get the type (if its the correct attribute)
		for (Attribute lA : leftAttributes) {
			if (getUsedParameters(rule, lA).contains(oppositeParameter)) {
				return lA.getType().getEAttributeType();
			}
		}

		return null;
	}

	/**
	 * Returns the innermost parameter for a given parameter by following the
	 * parameter mappings towards the innermost units. <br/>
	 * Unit parameters are followed by means of the explicit parameter mappings,
	 * rule parameters are followed by means of the implicit mappings given by
	 * parameter name equality. <br/>
	 * 
	 * 
	 * @param parameter
	 * @return
	 */
	public static Parameter getInnermostParameter(Parameter parameter) {
		if (isUnitParameter(parameter)) {
			// Go through the mappings and find the opposite parameter
			for (ParameterMapping mapping : parameter.getUnit().getParameterMappings()) {

				/** if its an outgoing-parameter (outPort) **/
				if (mapping.getTarget().equals(parameter)) {
					return getInnermostParameter(mapping.getSource());
				}

				/** if its an incoming-parameter **/
				else if (mapping.getSource().equals(parameter)) {
					return getInnermostParameter(mapping.getTarget());
				}
			}
		} else {
			// Rule parameter
			// => these are implicitly mapped to inner rules by name equality
			Rule kr = (Rule) parameter.getUnit();
			for (Rule mr : kr.getMultiRules()) {
				for (Parameter mrp : mr.getParameters()) {
					if (mrp.getName().equals(parameter.getName())) {
						return getInnermostParameter(mrp);
					}
				}
			}
		}

		// No more mappings: We must have reached innermost parameter
		return parameter;
	}

	/**
	 * Returns the outermost parameter for a given parameter by following the
	 * parameter mappings towards the outermost unit, i.e. the mainUnit. <br/>
	 * Unit parameters are followed by means of the explicit parameter mappings,
	 * rule parameters are followed by means of the implicit mappings given by
	 * parameter name equality. <br/>
	 * 
	 * Please note that if no outermost parameter can be found for a rule
	 * parameter because this parameter is a rule internal parameter, this
	 * method returns <code>null</code>.
	 * 
	 * 
	 * @param parameter
	 * @return
	 */
	public static Parameter getOutermostParameter(Parameter parameter) {
		if (isUnitParameter(parameter)) {
			// wir untertuetzen derzeit keine Schachtelung von Units
			// ==> parameter ist bereit outermost
			assert (parameter.getUnit().getName().equals(INamingConventions.MAIN_UNIT)) : "Geschachtelte Units !?";
			return parameter;

		} else {
			// Rule parameter
			Rule rule = (Rule) parameter.getUnit();
			if (rule.getRootRule() == rule) {
				// rule is a kernel rule
				Unit mainUnit = rule.getModule().getUnit(INamingConventions.MAIN_UNIT);
				for (ParameterMapping mapping : mainUnit.getParameterMappings()) {
					if (mapping.getSource().equals(parameter)) {
						return mapping.getTarget();
					}
					if (mapping.getTarget().equals(parameter)) {
						return mapping.getSource();
					}
				}

			} else {
				// rule is a multi rule
				Rule kernelRule = (Rule) rule.eContainer();
				for (Parameter krp : kernelRule.getParameters()) {
					if (krp.getName().equals(parameter.getName())) {
						return getOutermostParameter(krp);
					}
				}
			}
		}

		// it's just an internal rule parameter
		return null;
	}

	/**
	 * Parses the parameter from a Henshin attribute.
	 * 
	 * FIXME: That isn't really perfect. Check the Henshin script interpreter
	 * syntax. I.e., check if parameter is a variable in the Syntax-Tree of the
	 * JavaScript Expression.
	 * 
	 * @param rule
	 *            the rule which contains the node which contains the attribute.
	 * @param attribute
	 *            the Henshin attribute.
	 * @return a list of parsed parameters.
	 */
	public static Set<Parameter> getUsedParameters(Rule rule, Attribute attribute) {

		Set<Parameter> parameters = new HashSet<Parameter>();
		String value = attribute.getValue();

		// Remove string parts
		int readingQuotes = 0;
		StringBuffer parameterAttribute = new StringBuffer();

		for (int i = 0; i < value.length(); i++) {
			char c = value.charAt(i);

			if (c == '\"') {
				if (i > 0) {
					if (value.charAt(i - 1) != '\\') {
						readingQuotes++;
					}
				} else {
					readingQuotes++;
				}
			} else {
				if (readingQuotes % 2 == 0) {
					parameterAttribute.append(c);
				}
			}
		}

		// Split by operators
		String[] parametersString = parameterAttribute.toString().split("[+-/*]");

		for (String stringP : parametersString) {
			String p = stringP.trim();

			// Filter functions
			if (!Pattern.matches(".+\\(.*\\)", p)) {

				p = p.replace("(", "");
				p = p.replace(")", "");
				p = p.trim();

				Parameter parameter = rule.getParameter(p);

				if (parameter != null) {
					parameters.add(parameter);
				}
			}
		}
		return parameters;
	}

	/**
	 * Is param a unit parameter..?
	 * 
	 * @param param
	 * @return
	 */
	public static boolean isUnitParameter(Parameter param) {
		assert (param != null && param.getUnit() != null);
		return !isRuleParameter(param);
	}

	/**
	 * Is param a rule parameter..?
	 * 
	 * @param param
	 * @return
	 */
	public static boolean isRuleParameter(Parameter param) {
		assert (param != null && param.getUnit() != null);
		return param.getUnit() instanceof Rule;
	}
}

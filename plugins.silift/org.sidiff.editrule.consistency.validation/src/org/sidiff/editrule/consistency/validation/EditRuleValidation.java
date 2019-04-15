package org.sidiff.editrule.consistency.validation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.NamedElement;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.henshin.ParameterInfo;

/**
 * Code of an Edit-Rule validation error.
 */
public class EditRuleValidation {

	public Module editModule;

	/**
	 * The object(s) violating a constraint.
	 */
	public List<Object> violatings = new LinkedList<Object>();

	/**
	 * 
	 */
	public ValidationType validationType;

	/**
	 * A message which informs the user.
	 */
	public String infoMessage = "N/A";

	/**
	 * An indicator of the severity of the problem.
	 * 
	 * @see Diagnostic#ERROR
	 * @see Diagnostic#WARNING
	 * @see Diagnostic#INFO
	 * @see Diagnostic#OK
	 */
	public int severity = Diagnostic.ERROR;

	private EditRuleValidation(String infoMessage, Module editModule, ValidationType validationType) {
		super();
		this.infoMessage = infoMessage;
		this.editModule = editModule;
		this.validationType = validationType;
	}

	/**
	 * Creates a new Edit-Rule validation info.
	 * 
	 * @param infoMessage
	 *            A message which informs the user.
	 * @param severity
	 *            An indicator of the severity of the problem.
	 * @param violatingObj
	 *            The object which violates a constraint.
	 * 
	 * @see Diagnostic#ERROR
	 * @see Diagnostic#WARNING
	 * @see Diagnostic#INFO
	 * @see Diagnostic#OK
	 */
	public EditRuleValidation(String infoMessage, int severity, Module editModule, ValidationType validationType,
			Object... violatingObj) {

		this(infoMessage, editModule, validationType);
		this.severity = severity;

		for (int i = 0; i < violatingObj.length; i++) {
			violatings.add(violatingObj[i]);
		}

	}

	/**
	 * Creates a new Edit-Rule validation info.
	 * 
	 * @param infoMessage
	 *            A message which informs the user.
	 * @param violatingObj
	 *            The object which violates a constraint.
	 */
	public EditRuleValidation(String infoMessage, Module editModule, ValidationType validationType,
			Object... violatingObj) {

		this(infoMessage, editModule, validationType);

		for (int i = 0; i < violatingObj.length; i++) {
			violatings.add(violatingObj[i]);
		}

	}

	@Override
	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("[" + getSeverityAsString() + "] " + infoMessage + "\n");
		out.append("  Type: " + validationType + "\n");
		out.append("  Module: " + editModule);

		for (Object obj : violatings) {
			out.append("\n    " + getObjectAsString(obj));
		}

		return out.toString();
	}

	private String getSeverityAsString() {
		String s_severity = "";

		switch (severity) {
		case Diagnostic.ERROR:
			s_severity = "ERROR";
			break;
		case Diagnostic.WARNING:
			s_severity = "WARNING";
			break;
		case Diagnostic.INFO:
			s_severity = "INFO";
			break;
		case Diagnostic.OK:
			s_severity = "OK";
			break;
		}

		return s_severity;
	}

	private String getObjectAsString(Object obj) {
		if (obj instanceof Node) {
			return getObjectAsString((Node) obj);
		}
		if (obj instanceof Edge) {
			return getObjectAsString((Edge) obj);
		}
		if (obj instanceof Parameter) {
			return getObjectAsString((Parameter) obj);
		}

		return obj.toString();
	}

	private String getObjectAsString(Node node) {
		return "<" + getPathToRootRule(node) + ">" + node.toString();
	}

	private String getObjectAsString(Edge edge) {
		return "<" + getPathToRootRule(edge) + ">" + edge.toString();
	}
	
	private String getObjectAsString(Parameter parameter) {
		if (ParameterInfo.isUnitParameter(parameter)){
			return "<" + parameter.eContainer() + ">" + parameter.toString();
		} else {
			return "<" + getPathToRootRule(parameter) + ">" + parameter.toString();
		}		
	}
	
	private String getPathToRootRule(EObject object) {
		List<EObject> pathToRule = new ArrayList<EObject>();
		EObject parent = object.eContainer();

		while (!isRootRule(parent)) {
			pathToRule.add(parent);
			parent = parent.eContainer();
		}
		assert (parent instanceof Rule);
		pathToRule.add(parent);

		String res = "";
		for (int i = pathToRule.size() - 1; i >= 0; i--) {
			EObject segment = pathToRule.get(i);
			if (segment instanceof NamedElement) {
				res += ((NamedElement) segment).getName();
			} else {
				res += segment.eClass().getName();
			}
			res += ".";
		}

		return res;
	}

	private boolean isRootRule(EObject object) {
		if (!(object instanceof Rule)) {
			return false;
		}

		return ((Rule) object).getKernelRule() == null;
	}
}
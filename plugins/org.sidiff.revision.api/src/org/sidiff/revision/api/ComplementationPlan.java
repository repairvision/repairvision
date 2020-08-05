package org.sidiff.revision.api;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.revision.difference.Change;

/**
 * Represents a single history-based complementation.
 * 
 * @author Manuel Ohrndorf
 */
public interface ComplementationPlan {

	/**
	 * @return The corresponding partially executed edit rule.
	 */
	Rule getRecognizedEditRule();

	/**
	 * @return All already applied changes of the corresponding edit rule.
	 */
	List<GraphElement> getRecognizedChanges();
	
	/**
	 * @return The recognized changes of the model difference.
	 */
	List<Change> getRecognizedChangeSet();
	
	/**
	 * @param node
	 *            A LHS node of the recognized rule.
	 * @return All recognized matchings for the given node.
	 */
	List<EObject[]> getRecognitionDomain(Node node);
	
	/**
	 * @param recognizedGraphElement
	 *            A node/edge of the recognized edit rule.
	 * @return The corresponding node/edge of the complement rule.
	 */
	<G extends GraphElement> G getTrace(G recognizedGraphElement);
	
	/**
	 * @return The edit rule which complements the partially executed edit rule.
	 */
	Rule getComplementingEditRule();
	
	/**
	 * @return All missing changes of the corresponding edit rule.
	 */
	List<GraphElement> getComplementingChanges();
	
	/**
	 * @return All matchings based on the current parameter assignment.
	 */
	List<Match> getComplementMatches();
	
	/**
	 * @param node
	 *            A LHS node of the complement rule.
	 * @return All possible matchings based on the current parameter assignment.
	 */
	List<EObject> getComplementDomain(Node node);
	
	/**
	 * @return All parameters of the complement rule.
	 */
	List<Parameter> getParameters();
	
	/**
	 * @param parameter
	 *            The parameter of the complement rule.
	 * @return <code>true</code> if a value is assigned to the parameter;
	 *         <code>false</code> otherwise.
	 */
	boolean isSetParameter(Parameter parameter);
	
	/**
	 * @param parameter
	 *            The parameter of the complement rule.
	 * @return All possible parameter values based on the current parameter assignment.
	 */
	List<Object> getParameterDomain(Parameter parameter);
	
	/**
	 * @param parameter The parameter of the complement rule.
	 * @param type      The type of the values
	 * @return All possible parameter values based on the current parameter
	 *         assignment.
	 */
	<T> List<T> getParameterDomain(Parameter parameter, Class<T> type);
	
	/**
	 * @param parameter
	 *            A parameter of the complement rule.
	 * @param value
	 *            An input value of the complement rule.
	 */
	void setParameterValue(Parameter parameter, Object value);
	
	/**
	 * @return The parameter input.
	 */
	Object getParameterValue(Parameter parameter);
}
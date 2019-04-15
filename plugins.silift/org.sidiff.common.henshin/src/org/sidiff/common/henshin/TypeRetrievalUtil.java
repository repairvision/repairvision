package org.sidiff.common.henshin;

import java.util.*;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.henshin.model.*;

/**
 * This class contains type retrieval methods
 *
 */
public class TypeRetrievalUtil {

	public static enum ParameterKind {IN, OUT};
	
	/**
	 * Finds out if parameter is an inport or outport. Input the complete mainUnit ParameterMappings.
	 * @param mappings
	 * @param parameter
	 * @return ParameterKind (IN or OUT)
	 */
	public static ParameterKind getParameterKind(EList<ParameterMapping> mappings, Parameter parameter) {

		// Go through the mappings and find the parameterKind
		for (ParameterMapping mapping : mappings) {
			// if its an outgoing-parameter (outPort)
			if (mapping.getTarget().equals(parameter)) {
				return ParameterKind.OUT;
			}
			// if its an incoming-parameter (inPort)
			else if (mapping.getSource().equals(parameter)) {
				return ParameterKind.IN;
			}
		}
		return null;
	}

	/**
	 * Walks through the given ParameterMappings recursively and searches for the connected types.
	 * To search for types in all ParameterMappings of a TransformationSystem, take the mainUnit mappings.
	 * Note: Since a parameter can be mapped to several rules simultaneously, it can be possible that a parameter
	 * has more than one connected type.
	 * @param mappings
	 * @param parameter
	 * @return List of EClassifiers
	 */
	public static List<EClassifier> getRealType(EList<ParameterMapping> mappings, Parameter parameter) {

		List<EClassifier> types = new ArrayList<EClassifier>();
		Parameter oppositeParameter = null;
		EClassifier type = null;
		Rule rule = null;
		Node node = null;

		// Go through the mappings and find the type of the opposite ending
		for (ParameterMapping mapping : mappings) {

			/** if its an outgoing-parameter (outPort) **/
			if (mapping.getTarget().equals(parameter)) {
				oppositeParameter = mapping.getSource();

				// container == Rule
				if (oppositeParameter.eContainer() instanceof Rule) {
					rule = (Rule) oppositeParameter.eContainer();
					// the next step is necessary since rule.getNodeByName
					// searches only in LHS
					for (Node n : rule.getRhs().getNodes()) {
						String nameOfN= n.getName();
						if (nameOfN!=null && nameOfN.equals(oppositeParameter.getName())) {
							node = n;
							break;
						}
					}
					if (node != null) {
						type = node.getType();
						if(!types.contains(type)) {
							types.add(type);
						}
					}
					// node == null : oppositeParameter points to an attribute
					else {
						for(EClassifier ec: findTypeOfAnAttribute(oppositeParameter)) {
							if(!types.contains(ec)) {
								types.add(ec);
							}		
						}
					}
				}
				// container == TransformationUnit
				else if (!(oppositeParameter.eContainer() instanceof Rule)) {
					Unit unit = (Unit) oppositeParameter.eContainer();
					for(EClassifier ec: getRealType(unit.getParameterMappings(), oppositeParameter)) {
						if(!types.contains(ec)) {
							types.add(ec);
						}
					}
				}
			}
			/** if its an incoming-parameter (inPort) **/
			else if (mapping.getSource().equals(parameter)) {
				oppositeParameter = mapping.getTarget();

				// container == Rule
				if (oppositeParameter.eContainer() instanceof Rule) {
					rule = (Rule) oppositeParameter.eContainer();
					node = HenshinRuleAnalysisUtilEx.getNodeByName(rule, oppositeParameter.getName(), true);
					if (node != null) {
						type = node.getType();
						if(!types.contains(type)) {
							types.add(type);
						}
					}
					// node == null : oppositeParameter points to an attribute
					else {
						for(EClassifier ec: findTypeOfAnAttribute(oppositeParameter)) {
							if(!types.contains(ec)) {
								types.add(ec);
							}		
						}
					}
				}

				// container == TransformationUnit
				else if (!(oppositeParameter.eContainer() instanceof Rule)) {
					Unit unit = (Unit) oppositeParameter.eContainer();
					for(EClassifier ec: getRealType(unit.getParameterMappings(), oppositeParameter)) {
						if(!types.contains(ec)) {
							types.add(ec);
						}
					}
				}
			}
		}

		return types;
	}

	public static List<EClassifier> findTypeOfAnAttribute(Parameter oppositeParameter) {

		List<EClassifier> types = new ArrayList<EClassifier>();
		EClassifier type = null;
		
		// container == Rule
		if (oppositeParameter.eContainer() instanceof Rule) {

			Rule rule = (Rule) oppositeParameter.eContainer();

			// get all attributes under all nodes of RHS
			EList<Node> rightNodes = rule.getRhs().getNodes();
			List<Attribute> rightAttributes = new ArrayList<Attribute>();
			for (Node rN : rightNodes) {
				rightAttributes.addAll(rN.getAttributes());
			}

			// get the actually type (if its the correct attribute)
			for (Attribute rA : rightAttributes) {
				if (rA.getValue().equals(oppositeParameter.getName())) {
					type = rA.getType().getEAttributeType();
					if(!types.contains(type)) {
						types.add(type);
					}
				}
			}

			// try to find attribute under LHS, if it is not under RHS
			if (type == null) {
				// get all attributes under all nodes of LHS
				EList<Node> leftNodes = rule.getLhs().getNodes();
				List<Attribute> leftAttributes = new ArrayList<Attribute>();
				for (Node lN : leftNodes) {
					leftAttributes.addAll(lN.getAttributes());
				}

				// get the actually type (if its the correct attribute)
				for (Attribute lA : leftAttributes) {
					if (lA.getValue().equals(oppositeParameter.getName())) {
						type = lA.getType().getEAttributeType();
						if(!types.contains(type)) {
							types.add(type);
						}
					}
				}
			}
		}
		// container == TransformationSystem
		else {
			Unit unit = (Unit) oppositeParameter.eContainer();
			for(EClassifier ec: getRealType(unit.getParameterMappings(), oppositeParameter)) {
				if(!types.contains(ec)) {
					types.add(ec);
				}
			}
		}
		return types;
	}

	/**
	 * This method does the following:
	 * In case the Parameter is connected to an Attribute under a Node
	 * it will fetch the container Node type (as Class<?>, since Refactor needs this).
	 * In case the Parameter is connected to a Node it will return null
	 * because the Node has no Node container.
	 * 
	 * @param parameter
	 * @return
	 */
	public static Class<?> getContainerNodeType(Parameter parameter) {
		
		Rule rule = null;
		Class<?> containerNodeType = null;
		
		/** find the Parameter *********************************************/
		Parameter target = ParameterInfo.getInnermostParameter(parameter);
		rule = (Rule) target.eContainer();

		/** now find the container node of the Parameter and its Node type */		
		// find attribute under LHS nodes
		for(Node lhsN :rule.getLhs().getNodes()) {
			for(Attribute aInLhsN: lhsN.getAttributes()) {
				if(aInLhsN.getValue().equals(parameter.getName())) {
					Node containerNode = aInLhsN.getNode();
					containerNodeType = containerNode.getType().getInstanceClass();
					break;
				}
			}
			if(containerNodeType!=null) break;
		}
		// find attribute under RHS nodes
		for(Node rhsN :rule.getRhs().getNodes()) {
			for(Attribute aInRhsN: rhsN.getAttributes()) {
				if(aInRhsN.getValue().equals(parameter.getName())) {
					Node containerNode = aInRhsN.getNode();
					containerNodeType = containerNode.getType().getInstanceClass();
					break;
				}
			}
			if(containerNodeType!=null) break;
		}
		
		// if still null, then the parameter stands for a node object
		// and therefore has no container node.
		return containerNodeType;
	}
}

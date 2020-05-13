package org.sidiff.editrule.consistency.validation;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.equalReferenceType;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getForbidEdges;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHSIntersectRHSEdges;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHSMinusRHSEdges;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRHSMinusLHSEdges;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRHSMinusLHSNodes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRequireEdges;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isLHSNode;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isRHSNode;
import static org.sidiff.common.henshin.ParameterInfo.getOutermostParameter;
import static org.sidiff.common.henshin.ParameterInfo.getParameterDirection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.henshin.model.And;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.BinaryFormula;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Mapping;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.NestedCondition;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.ParameterMapping;
import org.eclipse.emf.henshin.model.PriorityUnit;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.SequentialUnit;
import org.eclipse.emf.henshin.model.Unit;
import org.sidiff.common.henshin.ApplicationCondition;
import org.sidiff.common.henshin.HenshinModuleAnalysis;
import org.sidiff.common.henshin.HenshinMultiRuleAnalysis;
import org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx;
import org.sidiff.common.henshin.INamingConventions;
import org.sidiff.common.henshin.ParameterInfo;
import org.sidiff.common.henshin.ParameterInfo.ParameterDirection;
import org.sidiff.common.henshin.view.NodePair;

/**
 * Checks the Edit-Rule constraints.
 */
// TODO: propagate to rulebase validation...
public class EditRuleValidator {

	public static List<EditRuleValidation> calculateEditRuleValidations(Module editModule) {
		List<EditRuleValidation> validations = new ArrayList<EditRuleValidation>();

		// Module, mainUnit
		validations.addAll(EditRuleValidator.validateEditRule_ruleOrganization(editModule));
		validations.addAll(EditRuleValidator.validateEditRule_mainUnit(editModule));
		validations.addAll(EditRuleValidator.validateEditRule_mainUnitType(editModule));
		validations.addAll(EditRuleValidator.validateEditRule_mainUnitComposition(editModule));

		// Parameters
		validations.addAll(EditRuleValidator.validateEditRule_noUnusedParameters(editModule));
		validations.addAll(EditRuleValidator.validateEditRule_uniqueParameterNames(editModule));
		validations.addAll(EditRuleValidator.validateEditRule_mappedAllRuleObjectInParameters(editModule));
		validations.addAll(EditRuleValidator.validateEditRule_mappedAllCreateNodes(editModule));
		validations.addAll(EditRuleValidator.validateEditRule_mappedAllValueSettingParameters(editModule));
		validations.addAll(EditRuleValidator.validateEditRule_correctParameterTyping(editModule));

		// Internal structure of Henshin rules
		validations.addAll(EditRuleValidator.validateEditRule_consistentEOpposite(editModule));
		validations.addAll(EditRuleValidator.validateEditRule_derivedEdges(editModule));
		validations.addAll(EditRuleValidator.validateEditRule_atLeastOneAction(editModule));

		// Application conditions (NACs/PACs)
		validations.addAll(EditRuleValidator.validateEditRule_acComposition(editModule));
		validations.addAll(EditRuleValidator.validateEditRule_lhsBoundaries(editModule));

		// Multi-Rules
		validations.addAll(EditRuleValidator.validateEditRule_multiRuleNodeEmbedding(editModule));
		validations.addAll(EditRuleValidator.validateEditRule_multiRuleEdgeEmbedding(editModule));
		validations.addAll(EditRuleValidator.validateEditRule_multiRuleAttributeEmbedding(editModule));
		validations.addAll(EditRuleValidator.validateEditRule_multiRuleParameterEmbedding(editModule));
		validations.addAll(EditRuleValidator.validateEditRule_uniqueMultiMappings(editModule));
		
		return validations;
	}

	/**
	 * Validates the "ruleOrganization" constraint of the Edit-Rule:
	 * 
	 * @param editModule
	 * @return
	 */
	public static List<EditRuleValidation> validateEditRule_ruleOrganization(Module editModule) {
		List<EditRuleValidation> invalids = new LinkedList<EditRuleValidation>();

		// Module should have a description
		if ((editModule.getDescription() == null) || (editModule.getDescription().equals(""))) {
			EditRuleValidation info = new EditRuleValidation("Missing Module Description!", Diagnostic.WARNING,
					editModule, ValidationType.ruleOrganization, editModule);
			invalids.add(info);
		}

		// Module must have a name
		if ((editModule.getName() == null) || (editModule.getName().equals(""))) {
			EditRuleValidation info = new EditRuleValidation("Missing Module Name!", Diagnostic.ERROR, editModule,
					ValidationType.ruleOrganization, editModule);
			invalids.add(info);

			return invalids;
		}

		return invalids;
	}

	/**
	 * Validates the "mainUnit" constraint of the Edit-Rule:
	 * 
	 * @param editModule
	 * @return
	 */
	public static List<EditRuleValidation> validateEditRule_mainUnit(Module editModule) {
		List<EditRuleValidation> invalids = new LinkedList<EditRuleValidation>();
		if (editModule.getUnit(INamingConventions.MAIN_UNIT) == null) {
			EditRuleValidation info = new EditRuleValidation("Missing main unit!", editModule, ValidationType.mainUnit,
					editModule);
			invalids.add(info);
		}

		return invalids;
	}

	/**
	 * Validates the "mainUnitType" constraint of the Edit-Rule:
	 * 
	 * @param editModule
	 * @return
	 */
	public static List<EditRuleValidation> validateEditRule_mainUnitType(Module editModule) {
		List<EditRuleValidation> invalids = new LinkedList<EditRuleValidation>();

		if (editModule.getUnit(INamingConventions.MAIN_UNIT) == null) {
			return invalids;
		}

		Unit mainUnit = editModule.getUnit(INamingConventions.MAIN_UNIT);
		if (!(mainUnit instanceof SequentialUnit || mainUnit instanceof PriorityUnit)) {
			EditRuleValidation info = new EditRuleValidation("Unsupported type of mainUnit "
					+ mainUnit.eClass().getName() + "! Only PriorityUnit and SequentialUnit are allowed at the moment",
					editModule, ValidationType.mainUnitType, mainUnit);
			invalids.add(info);
		}

		// TODO: Momentan erlauben wir auch noch PriorityUnit, sollten wir aber
		// in Zukunft verbieten

		return invalids;
	}

	/**
	 * Validates the "mainUnitComposition" constraint of the Edit-Rule:
	 * 
	 * @param editModule
	 * @return
	 */
	public static List<EditRuleValidation> validateEditRule_mainUnitComposition(Module editModule) {
		List<EditRuleValidation> invalids = new LinkedList<EditRuleValidation>();

		if (editModule.getUnit(INamingConventions.MAIN_UNIT) == null) {
			return invalids;
		}

		Unit mainUnit = editModule.getUnit(INamingConventions.MAIN_UNIT);
		// mainUnit muss genau eine Henshin-Regel beinhalten

		if (mainUnit.getSubUnits(false).size() != 1) {
			EditRuleValidation info = new EditRuleValidation("At the moment, mainUnit must contain exactly one rule!",
					editModule, ValidationType.mainUnitComposition, mainUnit);
			invalids.add(info);
			return invalids;
		}

		if (!(mainUnit.getSubUnits(false).get(0) instanceof Rule)) {
			EditRuleValidation info = new EditRuleValidation("At the moment, mainUnit must contain exactly one rule!",
					editModule, ValidationType.mainUnitComposition, mainUnit);
			invalids.add(info);
		}

		return invalids;
	}

	/**
	 * Validates the "injectiveMatching" constraint of the Edit-Rule:
	 * 
	 * @param editRule
	 * @return
	 */
	public static List<EditRuleValidation> validateEditRule_injectiveMatching(Module editRule) {
		// TODO: injectiveMatching = true (prüfen, ob wir das konzeptuell
		// wirklich fordern)

		return null;
	}

	/**
	 * Validates the "checkDangling" constraint of the Edit-Rule:
	 * 
	 * @param editRule
	 * @return
	 */
	public static List<EditRuleValidation> validateEditRule_checkDangling(Module editRule) {
		// TODO: checkDangling = true (können wir erst fordern, wenn
		// checkDangling für Kernel/Multi-Regeln korrekt funktioniert)

		return null;
	}

	/**
	 * <p>
	 * Validates the "Mapped All Unit-Parameters" constraint of the Edit-Rule:
	 * </p>
	 * <p>
	 * Unit-Parameters of a Main-Unit have to be mapped to a Rule-Parameter.
	 * </p>
	 * 
	 * @param mainUnit
	 *            The Main-Unit of the Edit-Rule.
	 */
	public static List<EditRuleValidation> validateEditRule_noUnusedParameters(Module editModule) {
		List<EditRuleValidation> invalids = new LinkedList<EditRuleValidation>();
		Unit mainUnit = editModule.getUnit(INamingConventions.MAIN_UNIT);

		if (mainUnit == null) {
			return invalids;
		}

		// Unit Parameter
		for (Parameter parameter : mainUnit.getParameters()) {
			boolean valid = false;
			for (ParameterMapping mapping : mainUnit.getParameterMappings()) {
				if ((mapping.getSource() == parameter) || (mapping.getTarget() == parameter)) {
					valid = true;
					break;
				}
			}

			if (!valid) {
				EditRuleValidation info = new EditRuleValidation("Missing unit parameter mapping!",
						mainUnit.getModule(), ValidationType.noUnusedParameters, parameter.getUnit(), parameter);
				invalids.add(info);
			}
		}

		// Regel Parameter
		for (Rule rule : HenshinModuleAnalysis.getAllRules(editModule)) {
			for (Parameter parameter : rule.getParameters()) {
				boolean valid = false;

				for (Node node : rule.getLhs().getNodes()) {
					// Find node with the same name as the parameter:
					if (node.getName() != null && node.getName().equals(parameter.getName())) {
						valid = true;
						break;
					}

					// Find attribute that uses this parameter:
					for (Attribute attribute : node.getAttributes()) {
						// FIXME: Need real parsing of attributes.
						if (attribute.getValue().contains(parameter.getName())) {
							valid = true;
							break;
						}
					}

					if (valid) {
						break;
					}
				}

				for (Node node : rule.getRhs().getNodes()) {
					// Find node with the same name as the parameter:
					if (node.getName() != null && node.getName().equals(parameter.getName())) {
						valid = true;
						break;
					}

					// Find attribute that uses this parameter:
					for (Attribute attribute : node.getAttributes()) {
						// FIXME: Need real parsing of attributes.
						if (attribute.getValue().contains(parameter.getName())) {
							valid = true;
							break;
						}
					}

					if (valid) {
						break;
					}
				}

				// Find Multi-Rule parameter mapping:
				for (Rule multiRule : rule.getMultiRules()) {
					for (Parameter multiParameter : multiRule.getParameters()) {
						if (multiParameter.getName().equals(parameter.getName())) {
							valid = true;
							break;
						}
					}

					if (valid) {
						break;
					}
				}

				// Parameter not used:
				if (!valid) {
					EditRuleValidation info = new EditRuleValidation(
							"Missing parameter target. A parameter must be used by a node or an attribute!",
							editModule, ValidationType.noUnusedParameters, parameter.getUnit(), parameter);
					invalids.add(info);
				}
			}
		}

		return invalids;
	}

	/**
	 * <p>
	 * Validates the "uniqueParameterNames" constraint of the Edit-Rule:
	 * </p>
	 * <p>
	 * Name of a parameter must be unique within its containing unit.
	 * </p>
	 * 
	 * @param editModule
	 *            The module that implements the Edit-Rule.
	 */
	public static List<EditRuleValidation> validateEditRule_uniqueParameterNames(Module editModule) {
		List<EditRuleValidation> invalids = new LinkedList<EditRuleValidation>();
		Unit mainUnit = editModule.getUnit(INamingConventions.MAIN_UNIT);

		if (mainUnit == null) {
			return invalids;
		}

		// Check mainUnit parameters
		for (Parameter param : mainUnit.getParameters()) {
			checkIsUnique(param, invalids);
		}

		// Check all rule parameters
		for (Rule rule : HenshinModuleAnalysis.getAllRules(mainUnit.getModule())) {
			for (Parameter param : rule.getParameters()) {
				checkIsUnique(param, invalids);
			}
		}

		return invalids;
	}

	private static void checkIsUnique(Parameter parameter, List<EditRuleValidation> invalids) {
		Unit definingUnit = parameter.getUnit();
		for (Parameter p : definingUnit.getParameters()) {
			if (p.getName().equals(parameter.getName()) && p != parameter) {
				EditRuleValidation info = new EditRuleValidation(
						"Duplicate paramter name. A parameter name must be unique within its defining unit!", parameter
								.getUnit().getModule(), ValidationType.uniqueParameterNames, parameter.getUnit(),
						parameter);
				invalids.add(info);
			}
		}
	}

	/**
	 * <p>
	 * Validates the "mappedAllCreateNodes" constraint of the Edit-Rule:
	 * </p>
	 * <p>
	 * Created nodes have to be mapped to an OUT-Parameter.
	 * </p>
	 * 
	 * @param editModule
	 * 
	 */
	public static List<EditRuleValidation> validateEditRule_mappedAllCreateNodes(Module editModule) {
		List<EditRuleValidation> invalids = new LinkedList<EditRuleValidation>();

		if (editModule.getUnit(INamingConventions.MAIN_UNIT) == null) {
			return invalids;
		}

		for (Rule rule : HenshinModuleAnalysis.getAllRules(editModule)) {
			for (Node createNode : getRHSMinusLHSNodes(rule)) {
				if (rule.getKernelRule() != null
						&& !HenshinMultiRuleAnalysis.getMultiRuleNodes(rule).contains(createNode)) {
					// follow-up error of kernel rule (will be detected by
					// multiRuleParameterEmbedding)
					continue;
				}

				boolean valid = false;

				if ((createNode.getName() != null) && !createNode.getName().equals("")) {
					for (Parameter parameter : createNode.getGraph().getRule().getParameters()) {
						if (parameter.getName().equals(createNode.getName())) {

							Parameter outermostParameter = getOutermostParameter(parameter);
							if (outermostParameter != null) {
								// Find Main-Unit IN-Parameter:
								if (getParameterDirection(outermostParameter) == ParameterDirection.OUT) {
									valid = true;
									break;
								}
							}

						}
					}
				}

				if (!valid) {
					EditRuleValidation info = new EditRuleValidation(
							"Created nodes have to be mapped to an OUT-Parameter of the mainUnit!", editModule,
							ValidationType.mappedAllCreateNodes, createNode.getGraph().getRule(), createNode);
					invalids.add(info);
				}
			}
		}

		return invalids;
	}

	public static List<EditRuleValidation> validateEditRule_mappedAllValueSettingParameters(Module editModule) {
		List<EditRuleValidation> invalids = new LinkedList<EditRuleValidation>();

		if (editModule.getUnit(INamingConventions.MAIN_UNIT) == null) {
			return invalids;
		}

		for (Rule rule : HenshinModuleAnalysis.getAllRules(editModule)) {
			// Check <<create>> nodes
			for (Node createNode : getRHSMinusLHSNodes(rule)) {
				if (rule.getKernelRule() != null
						&& !HenshinMultiRuleAnalysis.getMultiRuleNodes(rule).contains(createNode)) {
					// follow-up error of kernel rule (will be detected by
					// multiRuleParameterEmbedding)
					continue;
				}

				// Check:
				for (Attribute attribute : createNode.getAttributes()) {
					invalids.addAll(checkValueSettingParameterMapping(createNode, attribute));
				}

			}

			// Check <<preserve>> nodes
			for (NodePair nodePair : HenshinRuleAnalysisUtilEx.getPreservedNodes(rule)) {
				Node rhsNode = nodePair.getRhsNode();
				if (rule.getKernelRule() != null && !HenshinMultiRuleAnalysis.getMultiRuleNodes(rule).contains(rhsNode)) {
					// follow-up error of kernel rule (will be detected by
					// multiRuleParameterEmbedding)
					continue;
				}

				for (Attribute rhsAttribute : rhsNode.getAttributes()) {
					if (isAttributeValueToBeSet(nodePair, rhsAttribute)) {
						invalids.addAll(checkValueSettingParameterMapping(rhsNode, rhsAttribute));
					}
				}
			}
		}

		return invalids;
	}

	private static List<EditRuleValidation> checkValueSettingParameterMapping(Node rhsNode, Attribute rhsAttribute) {
		List<EditRuleValidation> invalids = new LinkedList<EditRuleValidation>();

		boolean valid = true;
		Attribute invalidAttribute = null;

		Set<Parameter> usedParams = ParameterInfo.getUsedParameters(rhsNode.getGraph().getRule(), rhsAttribute);
		if (usedParams.isEmpty()) {
			return invalids;
		}

		assert (usedParams.size() == 1);
		Parameter ruleParameter = usedParams.iterator().next();

		// Maybe this parameter is used as internal variable, then everything is
		// ok
		// If there is an lhs attribute that uses this parameter, we can
		// conclude that the parameter is used as a variable
		for (Node lhsNode : rhsNode.getGraph().getRule().getLhs().getNodes()) {
			// Find attribute that uses this parameter:
			for (Attribute attribute : lhsNode.getAttributes()) {
				// FIXME: Need real parsing of attributes.
				if (attribute.getValue().contains(ruleParameter.getName())) {
					// Parameter is used as internal variable
					return invalids;
				}
			}
		}

		// No internal variable, so the parameter must be mapped to a mainUnit
		// IN-Parameter 
		Parameter outermostParameter = getOutermostParameter(ruleParameter);
		if (outermostParameter == null) {
			valid = false;
			invalidAttribute = rhsAttribute;	
		} 
		else {
			if (getParameterDirection(outermostParameter) != ParameterDirection.IN) {
				valid = false;
				invalidAttribute = rhsAttribute;
			}
		}

		if (!valid) {
			EditRuleValidation info = new EditRuleValidation(
					"Parameters which are used to set the value of an attribute must be mapped to an IN-Parameter of the mainUnit!",
					rhsNode.getGraph().getRule().getModule(), ValidationType.mappedAllValueSettingParameters, rhsNode
							.getGraph().getRule(), rhsNode, invalidAttribute);
			invalids.add(info);
		}

		return invalids;
	}

	/**
	 * <p>
	 * Validates the "correctParameterTyping" constraint of the Edit-Rule:
	 * </p>
	 * <p>
	 * Declared type of a parameter (if any) must be equal to real type or one
	 * of its supertypes.
	 * </p>
	 * 
	 * @param mainUnit
	 *            The Main-Unit of the Edit-Rule.
	 */
	public static List<EditRuleValidation> validateEditRule_correctParameterTyping(Module editModule) {
		List<EditRuleValidation> invalids = new LinkedList<EditRuleValidation>();
		Unit mainUnit = editModule.getUnit(INamingConventions.MAIN_UNIT);

		if (mainUnit == null) {
			return invalids;
		}

		// Check mainUnit parameters
		for (Parameter param : mainUnit.getParameters()) {
			checkCorrectParameterTyping(param, invalids);
		}

		// Check all rule parameters
		for (Rule rule : HenshinModuleAnalysis.getAllRules(mainUnit.getModule())) {
			for (Parameter param : rule.getParameters()) {
				checkCorrectParameterTyping(param, invalids);
			}
		}

		return invalids;
	}

	/**
	 * Declared type of param must be equal to real type or one of its
	 * supertypes
	 * 
	 * @param param
	 * @param invalids
	 */
	private static void checkCorrectParameterTyping(Parameter param, List<EditRuleValidation> invalids) {
		if (param.getType() != null) {
			EClassifier declaredType = param.getType();
			EClassifier realType = ParameterInfo.getRealType(param, false);

			// If the parameter is not mapped, a check does not make sense
			if (realType == null){
				return;
			}
			
			boolean valid = false;
			// Equality check
			if (declaredType == realType) {
				valid = true;
			}
			// Supertype check
			else if (declaredType instanceof EClass && realType instanceof EClass) {
				EClass declaredEClass = (EClass) declaredType;
				EClass realEClass = (EClass) realType;

				if (realEClass.getEAllSuperTypes().contains(declaredEClass)) {
					valid = true;
				}
			}

			if (!valid) {
				EditRuleValidation info = new EditRuleValidation(
						"Declared type of a parameter must be equal to real type or one of its supertypes!",
						Diagnostic.ERROR, param.getUnit().getModule(), ValidationType.correctParameterTyping,
						param.getUnit(), param);
				invalids.add(info);
			}
		}
	}

	/**
	 * <p>
	 * Validates the "mappedAllRuleObjectInParameters" constraint of the
	 * Edit-Rule:
	 * </p>
	 * <p>
	 * All Object-IN-Parameters of Rules have to be mapped to Main-Unit
	 * IN-Parameters.
	 * </p>
	 * 
	 * @param mainUnit
	 *            The Main-Unit of the Edit-Rule.
	 */
	public static List<EditRuleValidation> validateEditRule_mappedAllRuleObjectInParameters(Module editModule) {
		List<EditRuleValidation> invalids = new LinkedList<EditRuleValidation>();

		if (editModule.getUnit(INamingConventions.MAIN_UNIT) == null) {
			return invalids;
		}

		for (Rule rule : HenshinModuleAnalysis.getAllRules(editModule)) {
			for (Parameter parameter : rule.getParameters()) {

				// Find node with the same name as the parameter:
				for (Node node : rule.getLhs().getNodes()) {
					if (rule.getKernelRule() != null
							&& !HenshinMultiRuleAnalysis.getMultiRuleNodes(rule).contains(node)) {
						// follow-up error of kernel rule
						continue;
					}

					if (node.getName() != null && node.getName().equals(parameter.getName())) {
						// => Parameter is an IN-Parameter:
						boolean valid = false;

						// Find Main-Unit IN-Parameter:
						Parameter outermostParameter = getOutermostParameter(parameter);
						if (outermostParameter != null) {
							if (getParameterDirection(outermostParameter) == ParameterDirection.IN) {
								valid = true;
								break;
							}
						}

						// No Main-Unit IN-Parameter found:
						if (!valid) {
							EditRuleValidation info = new EditRuleValidation(
									"All Object-IN-Parameters of Rules have to be mapped to Main-Unit IN-Parameters!",
									editModule, ValidationType.mappedAllRuleObjectInParameters, parameter.getUnit(),
									node, parameter);
							invalids.add(info);
						}
					}
				}
			}
		}

		return invalids;
	}

	/**
	 * <p>
	 * Validates the "Consistent EOpposite" constraint of the Edit-Rule:
	 * </p>
	 * <p>
	 * Every opposite edge should be contained in the rule.
	 * </p>
	 * 
	 * @param editModule
	 *            The Module of the Edit-Rule.
	 */
	public static List<EditRuleValidation> validateEditRule_consistentEOpposite(Module editModule) {
		List<EditRuleValidation> invalids = new LinkedList<EditRuleValidation>();

		for (Rule rule : HenshinModuleAnalysis.getAllRules(editModule)) {

			// Check LHS:
			for (Edge edge : rule.getLhs().getEdges()) {
				EReference edgeType = edge.getType();
				EReference oppositeEdgeType = edgeType.getEOpposite();

				if (oppositeEdgeType != null) {
					boolean oppositeFound = false;

					// Search for opposite edge:
					for (Edge potentialOppositeEdge : edge.getTarget().getOutgoing()) {
						if (potentialOppositeEdge.getTarget() == edge.getSource()
								&& potentialOppositeEdge.getType() == oppositeEdgeType) {

							oppositeFound = true;
							break;
						}
					}

					if (!oppositeFound) {
						if (HenshinRuleAnalysisUtilEx.isDeletionEdge(edge)) {
							// Deletion edges must have opposite due to dangling
							// condition
							EditRuleValidation info = new EditRuleValidation(
									"Every <<delete>> opposite edge must be contained in the rule!", Diagnostic.ERROR,
									editModule, ValidationType.consistentEOpposite, edge.getGraph().getRule(), edge);
							invalids.add(info);
						}
					}
				}
			}

			// Check RHS:
			for (Edge edge : rule.getRhs().getEdges()) {
				EReference edgeType = edge.getType();
				EReference oppositeEdgeType = edgeType.getEOpposite();

				if (oppositeEdgeType != null) {
					boolean oppositeFound = false;

					// Search for opposite edge:
					for (Edge potentialOppositeEdge : edge.getTarget().getOutgoing()) {
						if (potentialOppositeEdge.getTarget() == edge.getSource()
								&& potentialOppositeEdge.getType() == oppositeEdgeType) {

							oppositeFound = true;
							break;
						}
					}

					if (!oppositeFound) {
						if (HenshinRuleAnalysisUtilEx.isCreationEdge(edge)) {
							// Creation edges should have opposite due to
							// unintended side effects
							EditRuleValidation info = new EditRuleValidation(
									"Every <<create>> opposite edge should be contained in the rule!",
									Diagnostic.WARNING, editModule, ValidationType.consistentEOpposite, edge.getGraph()
											.getRule(), edge);
							invalids.add(info);
						}
					}
				}
			}
		}

		return invalids;
	}

	/**
	 * <p>
	 * Validates the "Derived Edges" constraint of the Edit-Rule:
	 * </p>
	 * <p>
	 * Edit-Rules should not contain derived edges.
	 * </p>
	 * <ul>
	 * <li>Derived << delete >> edge => ERROR</li>
	 * <li>Derived << create >> edge => ERROR</li>
	 * <li>Derived << preserve >> edge => WARNING</li>
	 * <li>Derived << forbid >> edge => WARNING</li>
	 * </ul>
	 * 
	 * @param editModule
	 *            The Module of the Edit-Rule.
	 */
	public static List<EditRuleValidation> validateEditRule_derivedEdges(Module editModule) {
		List<EditRuleValidation> invalids = new LinkedList<EditRuleValidation>();

		for (Rule rule : HenshinModuleAnalysis.getAllRules(editModule)) {

			// Derived << delete >> edge => ERROR
			for (Edge edge : getLHSMinusRHSEdges(rule)) {
				EReference edgeType = edge.getType();
				if (edgeType.isDerived()) {
					EditRuleValidation info = new EditRuleValidation(
							"Edit-Rules must not contain derived << delete >> edges!", Diagnostic.ERROR, editModule,
							ValidationType.derivedEdges, edge.getGraph().getRule(), edge);
					invalids.add(info);
				}
			}

			// Derived << create >> edge => ERROR
			for (Edge edge : getRHSMinusLHSEdges(rule)) {
				EReference edgeType = edge.getType();
				if (edgeType.isDerived()) {
					EditRuleValidation info = new EditRuleValidation(
							"Edit-Rules must not contain derived << create >> edges!", Diagnostic.ERROR, editModule,
							ValidationType.derivedEdges, edge.getGraph().getRule(), edge);
					invalids.add(info);
				}
			}

			// Derived << preserve >> edge => WARNING
			for (Edge edge : getLHSIntersectRHSEdges(rule)) {
				EReference edgeType = edge.getType();
				if (edgeType.isDerived()) {
					EditRuleValidation info = new EditRuleValidation(
							"Edit-Rules should not contain derived <<preserve>> edges!", Diagnostic.WARNING,
							editModule, ValidationType.derivedEdges, edge.getGraph().getRule(), edge);
					invalids.add(info);
				}
			}

			// Derived << forbid >> edge => WARNING
			for (Edge edge : getForbidEdges(rule)) {
				EReference edgeType = edge.getType();
				if (edgeType.isDerived()) {
					EditRuleValidation info = new EditRuleValidation(
							"Edit-Rules should not contain derived <<forbid>> edges!", Diagnostic.WARNING, editModule,
							ValidationType.derivedEdges, edge.getGraph().getRule(), edge);
					invalids.add(info);
				}
			}

			// Derived << require >> edge => WARNING
			for (Edge edge : getRequireEdges(rule)) {
				EReference edgeType = edge.getType();
				if (edgeType.isDerived()) {
					EditRuleValidation info = new EditRuleValidation(
							"Edit-Rules should not contain derived <<require>> edges!", Diagnostic.WARNING, editModule,
							ValidationType.derivedEdges, edge.getGraph().getRule(), edge);
					invalids.add(info);
				}
			}
		}

		return invalids;
	}

	/**
	 * <p>
	 * Validates the "atLeastOneAction" constraint of the Edit-Rule:
	 * </p>
	 * 
	 * @param editModule
	 *            The Module of the Edit-Rule.
	 */
	public static List<EditRuleValidation> validateEditRule_atLeastOneAction(Module editModule) {
		List<EditRuleValidation> invalids = new LinkedList<EditRuleValidation>();

		if (editModule.getUnit(INamingConventions.MAIN_UNIT) == null) {
			return invalids;
		}

		boolean valid = false;
		for (Rule rule : HenshinModuleAnalysis.getAllRules(editModule)) {
			if (valid) {
				break;
			}

			// Creation/Deletion of nodes/edges?
			if (!HenshinRuleAnalysisUtilEx.getRHSMinusLHSNodes(rule).isEmpty()) {
				valid = true;
				break;
			}
			if (!HenshinRuleAnalysisUtilEx.getLHSMinusRHSNodes(rule).isEmpty()) {
				valid = true;
				break;
			}
			if (!HenshinRuleAnalysisUtilEx.getRHSMinusLHSEdges(rule).isEmpty()) {
				valid = true;
				break;
			}
			if (!HenshinRuleAnalysisUtilEx.getLHSMinusRHSEdges(rule).isEmpty()) {
				valid = true;
				break;
			}

			// Any attribute value change?
			List<NodePair> preservedNodes = HenshinRuleAnalysisUtilEx.getPreservedNodes(rule);
			for (NodePair nodePair : preservedNodes) {
				if (valid) {
					break;
				}

				Node rhsNode = nodePair.getRhsNode();
				for (Attribute rhsAttribute : rhsNode.getAttributes()) {
					if (isAttributeValueToBeSet(nodePair, rhsAttribute)) {
						valid = true;
						break;
					}
				}
				
				Node lhsNode = nodePair.getLhsNode();
				for(Attribute lhsAttribute : lhsNode.getAttributes()){
					if(isAttributeValueToBeUnset(nodePair, lhsAttribute)){
						valid = true;
						break;
					}
				}
			}
		}

		if (!valid) {
			EditRuleValidation info = new EditRuleValidation("Module does not perform any action!", Diagnostic.ERROR,
					editModule, ValidationType.atLeastOneAction, editModule);
			invalids.add(info);
		}

		return invalids;
	}

	private static boolean isAttributeValueToBeSet(NodePair nodePair, Attribute rhsAttribute) {
		Node lhsNode = nodePair.getLhsNode();

		Attribute lhsAttribute = lhsNode.getAttribute(rhsAttribute.getType());
		if ((lhsAttribute == null) || !lhsAttribute.getValue().equals(rhsAttribute.getValue())) {
			return true;
		}

		return false;
	}
	
	private static boolean isAttributeValueToBeUnset(NodePair nodePair, Attribute lhsAttribute){
		Node rhsNode = nodePair.getRhsNode();

		Attribute rhsAttribute = rhsNode.getAttribute(lhsAttribute.getType());
		if (rhsAttribute == null) {
			return true;
		}

		return false;
	}

	/**
	 * <p>
	 * Validates the "LHS Boundaries" constraint of the Edit-Rule:
	 * </p>
	 * <p>
	 * Only LHS boundary nodes may be embedded into the AC graph.
	 * </p>
	 * 
	 * @param editModule
	 *            The Module of the Edit-Rule.
	 */
	public static List<EditRuleValidation> validateEditRule_lhsBoundaries(Module editModule) {
		List<EditRuleValidation> invalids = new LinkedList<EditRuleValidation>();

		for (Rule rule : HenshinModuleAnalysis.getAllRules(editModule)) {
			for (NestedCondition nc : rule.getLhs().getNestedConditions()) {
				for (Mapping mapping : nc.getMappings()) {
					Node acNode = mapping.getImage();

					// Collect all neighbours
					ArrayList<Node> neighbours = new ArrayList<Node>();
					for (Edge coincidingEdge : acNode.getAllEdges()) {
						Node neighbour = null;
						if (coincidingEdge.getSource() == acNode) {
							neighbour = coincidingEdge.getTarget();
						} else {
							neighbour = coincidingEdge.getSource();
						}

						if (!neighbours.contains(neighbour)) {
							neighbours.add(neighbour);
						}
					}
					
					boolean valid = false;
					
					// The AC node contains a attribute condition:
					if (!acNode.getAttributes().isEmpty()) {
						valid = true;
					}

					// At least one of the neighbours of acNode must be a pure AC node:
					ApplicationCondition ac = new ApplicationCondition(nc);
					for (Node acNeighbour : neighbours) {
						if (ac.getNonBoundaryNodes().contains(acNeighbour)) {
							valid = true;
							break;
						}
					}

					if (!valid) {
						EditRuleValidation info = new EditRuleValidation(
								"Only LHS boundary nodes may be embedded into the AC graph!", editModule,
								ValidationType.lhsBoundaries, mapping.getOrigin().getGraph().getRule(),
								mapping.getImage(), mapping.getOrigin());
						invalids.add(info);
					}
				}
			}

		}

		return invalids;
	}

	/**
	 * <p>
	 * Validates the "AC Composition" constraint of the Edit-Rule:
	 * </p>
	 * <p>
	 * All application conditions (NAC/PAC) must be composed by AND operators.
	 * </p>
	 * 
	 * @param editModule
	 *            The Module of the Edit-Rule.
	 */
	public static List<EditRuleValidation> validateEditRule_acComposition(Module editModule) {
		List<EditRuleValidation> invalids = new LinkedList<EditRuleValidation>();

		for (Rule rule : HenshinModuleAnalysis.getAllRules(editModule)) {
			for (Iterator<EObject> iterator = rule.eAllContents(); iterator.hasNext();) {
				EObject object = iterator.next();
				if (object instanceof BinaryFormula && !(object instanceof And)) {
					EditRuleValidation info = new EditRuleValidation(
							"All application conditions must be composed by AND operators!", editModule,
							ValidationType.acComposition, object);
					invalids.add(info);
				}
			}
		}

		return invalids;
	}

	/**
	 * <p>
	 * Validates the "Multi Rule Node Embedding" constraint of the Edit-Rule:
	 * </p>
	 * <p>
	 * All Kernel-Rule nodes have to be embedded in a Multi-Rule.
	 * </p>
	 * 
	 * @param editModule
	 *            The Module of the Edit-Rule.
	 */
	public static List<EditRuleValidation> validateEditRule_multiRuleNodeEmbedding(Module editModule) {
		List<EditRuleValidation> invalids = new LinkedList<EditRuleValidation>();

		for (Rule rootRule : HenshinMultiRuleAnalysis.getRootRules(editModule)) {
			checkNodeEmbedding(rootRule, invalids);
		}

		return invalids;
	}

	/**
	 * Test if all Kernel-Rules have been embedded in the containing
	 * Multi-Rules.
	 * 
	 * @param kernel
	 *            The start rule.
	 * @param invalids
	 *            List to collect the validation errors.
	 */
	private static void checkNodeEmbedding(Rule kernel, List<EditRuleValidation> invalids) {

		// Check LHS:
		for (Node node : kernel.getLhs().getNodes()) {
			for (Rule multiRule : kernel.getMultiRules()) {
				boolean isEmbedded = false;

				for (Mapping mapping : multiRule.getMultiMappings()) {
					if ((mapping.getOrigin() == node)
							&& (mapping.getImage() != null)
							&& isLHSNode(mapping.getImage())
							&& HenshinRuleAnalysisUtilEx.haveEqualNodeIdentifiers(mapping.getOrigin(),
									mapping.getImage())) {
						isEmbedded = true;
						break;
					}
				}

				if (!isEmbedded) {
					EditRuleValidation info = new EditRuleValidation(
							"All Kernel-Rule nodes have to be properly embedded in a Multi-Rule! There must (i) be a multi-mapping that maps the kernel node into the multi rule, and (ii) the kernel node and the multi node must have the same node identifiers (names).",
							kernel.getModule(), ValidationType.multiRuleNodeEmbedding, kernel, multiRule, node);
					invalids.add(info);
				}
			}
		}

		// Check RHS:
		for (Node node : kernel.getRhs().getNodes()) {
			for (Rule multiRule : kernel.getMultiRules()) {
				boolean isEmbedded = false;

				for (Mapping mapping : multiRule.getMultiMappings()) {
					if ((mapping.getOrigin() == node)
							&& (mapping.getImage() != null)
							&& isRHSNode(mapping.getImage())
							&& HenshinRuleAnalysisUtilEx.haveEqualNodeIdentifiers(mapping.getOrigin(),
									mapping.getImage())) {
						isEmbedded = true;
						break;
					}
				}

				if (!isEmbedded) {
					EditRuleValidation info = new EditRuleValidation(
							"All Kernel-Rule nodes have to be properly embedded in a Multi-Rule! There must (i) be a multi-mapping that maps the kernel node into the multi rule, and (ii) the kernel node and the multi node must have the same node identifiers (names).",
							kernel.getModule(), ValidationType.multiRuleNodeEmbedding, kernel, multiRule, node);
					invalids.add(info);
				}
			}
		}

		// Recursion for deeper Multi-Rules:
		for (Rule multiRule : kernel.getMultiRules()) {
			checkNodeEmbedding(multiRule, invalids);
		}
	}

	/**
	 * <p>
	 * Validates the "Multi Rule Edge Embedding" constraint of the Edit-Rule:
	 * </p>
	 * <p>
	 * All Kernel-Rule edges have to be embedded in a Multi-Rule.
	 * </p>
	 * 
	 * @param editModule
	 *            The Module of the Edit-Rule.
	 */
	public static List<EditRuleValidation> validateEditRule_multiRuleEdgeEmbedding(Module editModule) {
		List<EditRuleValidation> invalids = new LinkedList<EditRuleValidation>();

		for (Rule rootRule : HenshinMultiRuleAnalysis.getRootRules(editModule)) {
			checkEdgeEmbedding(rootRule, invalids);
		}

		return invalids;
	}

	/**
	 * Test if all Kernel-Rules have been embedded in the containing
	 * Multi-Rules.
	 * 
	 * @param kernel
	 *            The start rule.
	 * @param invalids
	 *            List to collect the validation errors.
	 */
	private static void checkEdgeEmbedding(Rule kernel, List<EditRuleValidation> invalids) {

		// Check LHS:
		for (Edge edge : kernel.getLhs().getEdges()) {
			for (Rule multiRule : kernel.getMultiRules()) {
				Node embeddedSource = null;
				Node embeddedTarget = null;

				// Source node:
				for (Mapping mapping : multiRule.getMultiMappings()) {
					if ((mapping.getOrigin() == edge.getSource()) && (mapping.getImage() != null)
							&& isLHSNode(mapping.getImage())) {
						embeddedSource = mapping.getImage();
						break;
					}
				}

				// Target node:
				for (Mapping mapping : multiRule.getMultiMappings()) {
					if ((mapping.getOrigin() == edge.getTarget()) && (mapping.getImage() != null)
							&& isLHSNode(mapping.getImage())) {
						embeddedTarget = mapping.getImage();
						break;
					}
				}

				if ((embeddedSource != null) && (embeddedTarget != null)) {
					boolean isEmbedded = false;

					for (Edge embeddedEdge : embeddedSource.getOutgoing()) {
						if (embeddedEdge.getTarget() == embeddedTarget
								&& equalReferenceType(edge.getType(), embeddedEdge.getType())) {

							isEmbedded = true;
						}
					}

					if (!isEmbedded) {
						EditRuleValidation info = new EditRuleValidation(
								"All Kernel-Rule edges have to be embedded in a Multi-Rule!", kernel.getModule(),
								ValidationType.multiRuleEdgeEmbedding, multiRule, edge);
						invalids.add(info);
					}
				} else {
					EditRuleValidation info = new EditRuleValidation(
							"All Kernel-Rule edges have to be embedded in a Multi-Rule!", kernel.getModule(),
							ValidationType.multiRuleEdgeEmbedding, multiRule, edge);
					invalids.add(info);
				}
			}
		}

		// Check RHS:
		for (Edge edge : kernel.getRhs().getEdges()) {
			for (Rule multiRule : kernel.getMultiRules()) {
				Node embeddedSource = null;
				Node embeddedTarget = null;

				// Source node:
				for (Mapping mapping : multiRule.getMultiMappings()) {
					if ((mapping.getOrigin() == edge.getSource()) && (mapping.getImage() != null)
							&& isRHSNode(mapping.getImage())) {
						embeddedSource = mapping.getImage();
						break;
					}
				}

				// Target node:
				for (Mapping mapping : multiRule.getMultiMappings()) {
					if ((mapping.getOrigin() == edge.getTarget()) && (mapping.getImage() != null)
							&& isRHSNode(mapping.getImage())) {
						embeddedTarget = mapping.getImage();
						break;
					}
				}

				if ((embeddedSource != null) && (embeddedTarget != null)) {
					boolean isEmbedded = false;

					for (Edge embeddedEdge : embeddedSource.getOutgoing()) {
						if (embeddedEdge.getTarget() == embeddedTarget
								&& equalReferenceType(edge.getType(), embeddedEdge.getType())) {

							isEmbedded = true;
						}
					}

					if (!isEmbedded) {
						EditRuleValidation info = new EditRuleValidation(
								"All Kernel-Rule edges have to be embedded in a Multi-Rule!", kernel.getModule(),
								ValidationType.multiRuleEdgeEmbedding, multiRule, edge);
						invalids.add(info);
					}
				} else {
					EditRuleValidation info = new EditRuleValidation(
							"All Kernel-Rule edges have to be embedded in a Multi-Rule!", kernel.getModule(),
							ValidationType.multiRuleEdgeEmbedding, multiRule, edge);
					invalids.add(info);
				}
			}
		}

		// Recursion for deeper Multi-Rules:
		for (Rule multiRule : kernel.getMultiRules()) {
			checkEdgeEmbedding(multiRule, invalids);
		}
	}

	/**
	 * <p>
	 * Validates the "Multi Rule Attribute Embedding" constraint of the
	 * Edit-Rule:
	 * </p>
	 * <p>
	 * All Kernel-Rule attributes have to be embedded in a Multi-Rule.
	 * </p>
	 * 
	 * @param editModule
	 *            The Module of the Edit-Rule.
	 */
	public static List<EditRuleValidation> validateEditRule_multiRuleAttributeEmbedding(Module editModule) {
		List<EditRuleValidation> invalids = new LinkedList<EditRuleValidation>();

		for (Rule rootRule : HenshinMultiRuleAnalysis.getRootRules(editModule)) {
			checkAttributeEmbedding(rootRule, invalids);
		}

		return invalids;
	}

	/**
	 * Test if all Kernel-Rules have been embedded in the containing
	 * Multi-Rules.
	 * 
	 * @param kernel
	 *            The start rule.
	 * @param invalids
	 *            List to collect the validation errors.
	 */
	private static void checkAttributeEmbedding(Rule kernel, List<EditRuleValidation> invalids) {

		// Check LHS:
		for (Node kernelNode : kernel.getLhs().getNodes()) {
			for (Attribute kernelAttribute : kernelNode.getAttributes()) {
				for (Rule multiRule : kernel.getMultiRules()) {
					boolean isEmbedded = false;
					Node multiNode = null;

					for (Mapping mapping : multiRule.getMultiMappings()) {
						if ((mapping.getOrigin() == kernelNode) && (mapping.getImage() != null) && isLHSNode(mapping.getImage())) {
							multiNode = mapping.getImage();
							
							for (Attribute embeddedAttribute : mapping.getImage().getAttributes()) {
								if ((embeddedAttribute.getType() == kernelAttribute.getType())
										&& (embeddedAttribute.getValue().equals(kernelAttribute.getValue()))) {

									isEmbedded = true;
									break;
								}
							}
						}
					}

					if (!isEmbedded) {
						EditRuleValidation info = new EditRuleValidation(
								"All LHS Kernel-Rule attributes have to be embedded in a Multi-Rule!", kernel.getModule(),
								ValidationType.multiRuleAttributeEmbedding, kernel, multiRule, kernelNode, multiNode,
								kernelAttribute);
						invalids.add(info);
					}
				}
			}
		}

		// Check RHS:
		for (Node kernelNode : kernel.getRhs().getNodes()) {
			for (Attribute kernelAttribute : kernelNode.getAttributes()) {
				for (Rule multiRule : kernel.getMultiRules()) {
					boolean isEmbedded = false;
					Node multiNode = null;

					for (Mapping mapping : multiRule.getMultiMappings()) {
						if ((mapping.getOrigin() == kernelNode) && (mapping.getImage() != null) && isRHSNode(mapping.getImage())) {
							multiNode = mapping.getImage();
							
							for (Attribute embeddedAttribute : mapping.getImage().getAttributes()) {
								if ((embeddedAttribute.getType() == kernelAttribute.getType())
										&& (embeddedAttribute.getValue().equals(kernelAttribute.getValue()))) {

									isEmbedded = true;
									break;
								}
							}
						}
					}

					if (!isEmbedded) {						
						EditRuleValidation info = new EditRuleValidation(
								"All RHS Kernel-Rule attributes have to be embedded in a Multi-Rule!", kernel.getModule(),
								ValidationType.multiRuleAttributeEmbedding, kernel, multiRule, kernelNode, multiNode,
								kernelAttribute);
						invalids.add(info);
					}
				}
			}
		}

		// Recursion for deeper Multi-Rules:
		for (Rule multiRule : kernel.getMultiRules()) {
			checkAttributeEmbedding(multiRule, invalids);
		}
	}

	/**
	 * <p>
	 * Validates the "Multi Rule Parameter Embedding" constraint of the
	 * Edit-Rule:
	 * </p>
	 * <p>
	 * All Kernel-Rule parameters have to be embedded in a Multi-Rule.
	 * </p>
	 * 
	 * @param editModule
	 *            The Module of the Edit-Rule.
	 */
	public static List<EditRuleValidation> validateEditRule_multiRuleParameterEmbedding(Module editModule) {
		List<EditRuleValidation> invalids = new LinkedList<EditRuleValidation>();

		for (Rule rootRule : HenshinMultiRuleAnalysis.getRootRules(editModule)) {
			checkParameterEmbedding(rootRule, invalids);
		}

		return invalids;
	}

	/**
	 * Test if all Kernel-Rules have been embedded in the containing
	 * Multi-Rules.
	 * 
	 * @param kernel
	 *            The start rule.
	 * @param invalids
	 *            List to collect the validation errors.
	 */
	private static void checkParameterEmbedding(Rule kernel, List<EditRuleValidation> invalids) {

		for (Parameter parameter : kernel.getParameters()) {
			// check only embedding of those parameters that are really used by
			// the kernel rule
			if (!isUsedByKernelRule(parameter, kernel)) {
				continue;
			}

			for (Rule multiRule : kernel.getMultiRules()) {
				boolean isEmbedded = false;

				for (Parameter embeddedParameter : multiRule.getParameters()) {
					if ((embeddedParameter.getName().equals(parameter.getName()))
							&& (embeddedParameter.getType() == parameter.getType())) {

						isEmbedded = true;
						break;
					}
				}

				if (!isEmbedded) {
					EditRuleValidation info = new EditRuleValidation(
							"All Kernel-Rule parameters have to be embedded in a Multi-Rule!", kernel.getModule(),
							ValidationType.multiRuleParameterEmbedding, multiRule, parameter);
					invalids.add(info);
				}
			}
		}

		// Recursion for deeper Multi-Rules:
		for (Rule multiRule : kernel.getMultiRules()) {
			checkParameterEmbedding(multiRule, invalids);
		}
	}

	/**
	 * Checks if the parameter p is really used by rule r; either as object
	 * parameter, or as value parameter.
	 * 
	 * @param p
	 * @param r
	 * @return
	 */
	private static boolean isUsedByKernelRule(Parameter p, Rule r) {
		// check all LHS nodes
		if (r.getLhs().getNode(p.getName()) != null) {
			return true;
		}

		// check all RHS nodes
		if (r.getRhs().getNode(p.getName()) != null) {
			return true;
		}

		// check all attributes
		for (Node node : r.getLhs().getNodes()) {
			for (Attribute attribute : node.getAttributes()) {
				if (ParameterInfo.getUsedParameters(r, attribute).contains(p)) {
					return true;
				}
			}
		}
		for (Node node : r.getRhs().getNodes()) {
			for (Attribute attribute : node.getAttributes()) {
				if (ParameterInfo.getUsedParameters(r, attribute).contains(p)) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * <p>
	 * Validates the "Unique Multi-Mappings" constraint of the Edit-Rule:
	 * </p>
	 * <p>
	 * The mapping between Multi- and Kernel-Rule nodes should be one-to-one.
	 * </p>
	 * 
	 * @param editModule
	 *            The Module of the Edit-Rule.
	 */
	public static List<EditRuleValidation> validateEditRule_uniqueMultiMappings(Module editModule) {
		List<EditRuleValidation> invalids = new LinkedList<EditRuleValidation>();

		for (Rule rootRule : HenshinMultiRuleAnalysis.getRootRules(editModule)) {
			checkUniqueMultiMappings(rootRule, invalids);
		}

		return invalids;
	}

	/**
	 * Tests if the mapping between Multi- and Kernel-Rule nodes is one-to-one.
	 * 
	 * @param kernel
	 *            The start rule.
	 * @param invalids
	 *            List to collect the validation errors.
	 */
	private static void checkUniqueMultiMappings(Rule kernel, List<EditRuleValidation> invalids) {

		for (Rule multiRule : kernel.getMultiRules()) {
			// two synchronized lists
			List<Node> origins = new ArrayList<Node>();
			List<Mapping> mappings = new ArrayList<Mapping>();

			for (Mapping mapping : multiRule.getMultiMappings()) {
				if (origins.contains(mapping.getOrigin())) {
					EditRuleValidation info = new EditRuleValidation(
							"Duplicated Multi-Mapping. The mapping between Multi- and Kernel-Rule nodes should be one-to-one!",
							kernel.getModule(), ValidationType.uniqueMultiMappings, multiRule, mappings.get(origins
									.indexOf(mapping.getOrigin())), mapping);
					invalids.add(info);
				} else {
					origins.add(mapping.getOrigin());
					mappings.add(mapping);
				}
			}
		}

		// Recursion for deeper Multi-Rules:
		for (Rule multiRule : kernel.getMultiRules()) {
			checkUniqueMultiMappings(multiRule, invalids);
		}
	}
}

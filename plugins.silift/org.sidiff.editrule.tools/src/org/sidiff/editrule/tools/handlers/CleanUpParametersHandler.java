package org.sidiff.editrule.tools.handlers;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isCreationNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.ParameterMapping;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.henshin.model.impl.HenshinFactoryImpl;
import org.sidiff.common.emf.modelstorage.EMFHandlerUtil;
import org.sidiff.common.henshin.INamingConventions;
import org.sidiff.common.utilities.ui.util.WorkbenchUtil;

/**
 * Cleans up unused Henshin rule parameters.
 * 
 * @author Manuel Ohrndorf
 */
public class CleanUpParametersHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Module editRule = EMFHandlerUtil.getSelection(event, Module.class);
		
		if (editRule != null) {
			cleanUpParamters(editRule);
			
			try {
				editRule.eResource().save(Collections.emptyMap());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			WorkbenchUtil.showMessage("Edit-Rule saved:\n\n" + EcoreUtil.getURI(editRule).toPlatformString(true));
		}
		
		return null;
	}
	
	public static void cleanUpParamters(Module editRule) {
		Set<String> names = new HashSet<>();
		
		// Collect parameter names:
		editRule.eAllContents().forEachRemaining(element -> {
			if (element instanceof Node) {
				names.add(((Node) element).getName());
			}
			
			else if (element instanceof Attribute) {
				names.add(((Attribute) element).getValue());
			}
		});
		
		// Remove unknown parameters:
		List<EObject> unknownParamerters = new ArrayList<>();
		
		editRule.eAllContents().forEachRemaining(element -> {
			if (element instanceof Parameter) {
				if (!names.contains(((Parameter) element).getName())) {
					unknownParamerters.add(element);
				}
			}
		});
		
		for (EObject parameter : unknownParamerters) {
			EcoreUtil.remove(parameter);
		}
		
		// Remove deprecated mappings:
		List<EObject> deprecatedMappings = new ArrayList<>();
		
		editRule.eAllContents().forEachRemaining(element -> {
			if (element instanceof ParameterMapping) {
				ParameterMapping mapping = (ParameterMapping) element;
						
				if ((mapping.getSource() == null) || (mapping.getTarget() == null)) {
					EcoreUtil.remove(mapping);
				}
				
				else if ((mapping.getSource().eContainer() == null) || (mapping.getTarget().eContainer() == null)) {
					deprecatedMappings.add(mapping);
				}
			}
		});
		
		for (EObject mappings : deprecatedMappings) {
			EcoreUtil.remove(mappings);
		}
		
		// Create output-parameters:
		editRule.eAllContents().forEachRemaining(element -> {
			if (element instanceof Node) {
				if (isCreationNode((Node) element)) {
					fix_mappedAllCreateNodes(editRule, (Node) element);
				}
			}
		});
	}
	
	/**** /org.sidiff.editrule.consistency.fixing/src/org/sidiff/editrule/consistency/fixing/EditRuleFixer.java ****/
	
	/**
	 * A new rule parameter (if required) and a new mainUnit OUT-parameter with
	 * the same name and the same type is created. If the node is part of a
	 * multi-rule, we create the parameter also for all kernel rules, following
	 * the path to the root kernel rule.<br/>
	 * Please note that if a parameter with this name already exists for some
	 * unit following the path up to the mainUnit, no fix will be triggered.
	 * 
	 * 
	 * @param node
	 */
	public static void fix_mappedAllCreateNodes(Module module, Node node) {
		// mainUnit
		Unit mainUnit = module.getUnit(INamingConventions.MAIN_UNIT);

		// Path to mainUnit
		Rule rule = node.getGraph().getRule();
		List<Unit> pathToMainUnit = getPathToMainUnit(rule);

		// Parameter name
		String parameterName = null;
		if (node.getName() != null && !node.getName().equals("")) {
			parameterName = node.getName();
		} else {
			parameterName = "New_" + node.getType().getName();
		}

		// Fix allowed?
		// (Parameter with that name must not already exist in the mainUnit)
		if (mainUnit.getParameter(parameterName) != null) {
			return;
		}

		// Fix problem....

		// First rule
		Parameter ruleParameter = rule.getParameter(parameterName);
		if (ruleParameter == null) {
			ruleParameter = HenshinFactoryImpl.eINSTANCE.createParameter();
			ruleParameter.setName(parameterName);
			rule.getParameters().add(ruleParameter);
			node.setName(parameterName);
		}

		// Path to mainUnit
		for (int i = 1; i < pathToMainUnit.size() - 1; i++) {
			ruleParameter = pathToMainUnit.get(i).getParameter(parameterName);
			if (ruleParameter == null) {
				ruleParameter = HenshinFactoryImpl.eINSTANCE.createParameter();
				ruleParameter.setName(parameterName);
				pathToMainUnit.get(i).getParameters().add(ruleParameter);
			}
		}

		// Main unit: Create and map unit parameter
		Parameter unitParameter = HenshinFactoryImpl.eINSTANCE.createParameter();
		unitParameter.setName(ruleParameter.getName());
		unitParameter.setType(ruleParameter.getType());
		mainUnit.getParameters().add(unitParameter);
		ParameterMapping mapping = HenshinFactoryImpl.eINSTANCE.createParameterMapping();
		mapping.setSource(ruleParameter);
		mapping.setTarget(unitParameter);
		mainUnit.getParameterMappings().add(mapping);
	}
	
	private static List<Unit> getPathToMainUnit(Rule rule) {
		List<Unit> res = new ArrayList<Unit>();
		res.add(rule);
		Rule current = rule;
		while (current.getKernelRule() != null) {
			res.add(current.getKernelRule());
			current = current.getKernelRule();
		}

		// Finally add mainUnit
		res.add(current.getModule().getUnit(INamingConventions.MAIN_UNIT));

		return res;
	}

}

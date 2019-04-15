package org.sidiff.editrule.tools.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.ParameterMapping;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.*;
import org.sidiff.common.henshin.INamingConventions;

public class EditRuleUtil {

	public static Unit getMainUnit(Module module) {
		return module.getUnit(INamingConventions.MAIN_UNIT);
	}
	
	public static Rule getMainRule(Module module) {
		Unit mainUnit = getMainUnit(module);
		
		if ((mainUnit != null) && (!mainUnit.getSubUnits(false).isEmpty())) {
			Unit mainRule = mainUnit.getSubUnits(false).get(0);
			
			if (mainRule != null) {
				return (Rule) mainRule;
			}
		}
		
		return null;
	}
	
	public static Set<EPackage> getImports(Module editRule) {
		Set<EPackage> imports = new HashSet<>();
		
		editRule.eAllContents().forEachRemaining(element -> {
			if (element instanceof Node) {
				imports.add(((Node) element).getType().getEPackage());
			}
		});
		
		return imports;
	}
	
	public static Set<EClass> getRequiredTypes(Node node) {
		Set<EClass> types = new HashSet<>();
		
		for (Edge ougoing : node.getOutgoing()) {
			types.add(ougoing.getType().getEContainingClass());
		}
		
		for (Edge incoming : node.getIncoming()) {
			types.add(incoming.getType().getEReferenceType());
		}
		
		for (Attribute attribute : node.getAttributes()) {
			types.add(attribute.getType().getEContainingClass());
		}
		
		return types;
	}
	
	public static EClass selectMostSpecificType(Collection<EClass> types) {
		
		if (!types.isEmpty()) {
			EClass mostSpecific = types.iterator().next();
			
			for (EClass type : types) {
				if (type.getEAllSuperTypes().contains(mostSpecific)) {
					mostSpecific = type;
				}
			}
			
			return mostSpecific;
		}
		
		return EcorePackage.eINSTANCE.getEObject();
	}
	
	public static void createInputParameter(Module module, String name) {
		Unit mainUnit = getMainUnit(module);
		Rule mainRule = getMainRule(module);
		
		Parameter mainUnitInputParameter = HenshinFactory.eINSTANCE.createParameter(name);
		Parameter editRuleParameter = HenshinFactory.eINSTANCE.createParameter(name);
		
		if (mainRule != null) {
			if (mainRule.getParameter(name) == null) {
				mainRule.getParameters().add(editRuleParameter);
			} else {
				editRuleParameter = mainRule.getParameter(name);
			}
		}
		
		ParameterMapping mainUnitInputParameterMapping = HenshinFactory.eINSTANCE.createParameterMapping();
		mainUnitInputParameterMapping.setSource(mainUnitInputParameter);
		mainUnitInputParameterMapping.setTarget(editRuleParameter);

		mainUnit.getParameters().add(mainUnitInputParameter);
		mainUnit.getParameterMappings().add(mainUnitInputParameterMapping);
	}
	
	public static void renameIdentifier(GraphElement element, String newIdentifier) {
		String oldName = null;
		
		if (element instanceof Node) {
			Node node = (Node) element;
			oldName = node.getName();
			node.setName(newIdentifier);
			
			Node remoteNode = getRemoteNode(node.getGraph().getRule().getMappings(), node);
			
			if ((remoteNode != null) && (remoteNode.getName().equals(oldName))){
				remoteNode.setName(newIdentifier);
			}
		}
		
		else if (element instanceof Attribute) {
			Attribute attribute = (Attribute) element;
			oldName = attribute.getValue();
			attribute.setValue(newIdentifier);
		}
			
		// Rename parameter:
		if (oldName != null) {
			
			Parameter ruleParameter = element.getGraph().getRule().getParameter(oldName);
			Parameter unitParameter = getMainUnit(element.getGraph().getRule().getModule()).getParameter(oldName);
			
			if (ruleParameter != null) {
				ruleParameter.setName(newIdentifier);
			}
			if (unitParameter != null) {
				unitParameter.setName(newIdentifier);
			}
		}
	}
}

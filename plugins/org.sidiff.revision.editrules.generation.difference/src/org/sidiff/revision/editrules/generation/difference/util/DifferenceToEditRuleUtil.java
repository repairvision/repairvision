package org.sidiff.revision.editrules.generation.difference.util;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;
import org.sidiff.revision.editrules.generation.difference.DifferenceToEditRule;
import org.sidiff.revision.editrules.generation.difference.builder.IEditRuleBuilder;

public class DifferenceToEditRuleUtil {
	
	public static String convertToString(EAttribute type, Object value) {
		if (value == null) {
			return "null";
		} else if (type.getEAttributeType() == EcorePackage.eINSTANCE.getEString()) {
			return "\"" + value + "\"";
		} else {
			return value.toString();
		}
	}
	
	public static boolean isDefaultValue(EAttribute type, Object value) {
		return (type.getDefaultValue() == value)
				|| ((type.getDefaultValue() != null) && type.getDefaultValue().equals(value));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean addAttribute(
			DifferenceToEditRule transformation, 
			EObject object, Object value, EAttribute type) {
		
		IEditRuleBuilder builder = transformation.getBuilder();
		
		// Create attribute in corresponding node:
		if (transformation.getTraceModelAtoLHS().containsKey(object)) {
			Object node = transformation.getTraceModelAtoLHS().get(object);
			Object attribute = builder.getAttribute(node, type);
			
			if (attribute != null) {
				// Overwrites existing attribute!
				builder.setAttributeValue(attribute, value.toString());
				return true;
			} else {
				return (builder.createDeleteAttribute(node, type, value) != null);
			}
			
		} else if (transformation.getTraceModelBtoRHS().containsKey(object)) {
			Object node = transformation.getTraceModelBtoRHS().get(object);
			Object attribute = builder.getAttribute(node, type);
			
			if (type != null) {
				if (attribute != null) {
					// Overwrites existing attribute!
					builder.setAttributeValue(attribute, value.toString());
					return true;
				} else {
					return (builder.createCreateAttribute(node, type, value) != null);
				}
			}
		}
		
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public static void saveEditRule(
			IEditRuleBuilder builder, URI folder, String fileNameWithoutExtension,
			boolean showMessages, boolean openRepresentation, int maxRepresentaionSize) {

		try {
			Resource resource = builder.createResource(folder, fileNameWithoutExtension);
			
			resource.save(Collections.emptyMap());
			URI diagramURI = builder.createRepresentation();
			
			if (openRepresentation) {
				int nodeSize = builder.sizeNodes();
				
				if (nodeSize <= maxRepresentaionSize) {
					builder.openRepresentation(diagramURI);
				} else {
					if (showMessages && WorkbenchUtil.askQuestion("The diagram has " + nodeSize + " nodes. Open it anyway?")) {
						builder.openRepresentation(diagramURI);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			
			if (showMessages) {
				WorkbenchUtil.showError("Edit rule '" + fileNameWithoutExtension + "' coul not be saved:\n\n" + folder.toPlatformString(true));
			}
		}

		if (showMessages) {
			WorkbenchUtil.showMessage("Edit rule '" + fileNameWithoutExtension + "' saved:\n\n" + folder.toPlatformString(true));
		}
	}
}

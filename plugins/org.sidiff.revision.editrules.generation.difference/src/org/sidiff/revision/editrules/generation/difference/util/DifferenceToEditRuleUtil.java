package org.sidiff.revision.editrules.generation.difference.util;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.utilities.ui.util.WorkbenchUtil;
import org.sidiff.revision.editrules.generation.difference.DifferenceToEditRule;
import org.sidiff.revision.editrules.generation.difference.builder.IEditRuleBuilder;

public class DifferenceToEditRuleUtil {

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
			Resource diagramResource = builder.createRepresentation();
			
			if (openRepresentation) {
				int nodeSize = builder.sizeNodes();
				
				if (nodeSize <= maxRepresentaionSize) {
					builder.openRepresentation(diagramResource);
				} else {
					if (showMessages && WorkbenchUtil.askQuestion("The diagram has " + nodeSize + " nodes. Open it anyway?")) {
						builder.openRepresentation(diagramResource);
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

package org.sidiff.editrule.tools.handlers;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.widgets.Display;
import org.sidiff.common.emf.modelstorage.EMFHandlerUtil;
import org.sidiff.common.emf.modelstorage.EMFStorage;
import org.sidiff.common.utilities.ui.util.WorkbenchUtil;
import org.sidiff.common.utilities.ui.util.WorkbenchUtil.NotEmptyValidator;
import org.sidiff.editrule.tools.util.EditRuleNaming;
import org.sidiff.editrule.tools.util.EditRuleUtil;

/**
 * Renames an edit-rule: file, module, rule, diagram
 * 
 * @author Manuel Ohrndorf
 */
public class RenameEditRuleHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Module editRule = EMFHandlerUtil.getSelection(event, Module.class);
		
		if (editRule != null) {
			InputDialog setNameDialog = new InputDialog(Display.getDefault().getActiveShell(), 
					"Set Rule Name", 
					"Enter a new rule name:\n\n(format: words and whitespaces - e.g.: Create new EClass)", 
					EditRuleNaming.removeCamelCase(editRule.getName()), 
					new NotEmptyValidator());
			
			setNameDialog.open();
			
			InputDialog setDescriptionDialog = new InputDialog(Display.getDefault().getActiveShell(), 
					"Set Rule Description", 
					"Enter a new rule description:", editRule.getDescription(), 
					null);
			
			setDescriptionDialog.open();
			
			// Rename:
			if (setNameDialog.getValue() != null) {
				String name = setNameDialog.getValue();
				String description = "";
				
				// Description:
				if (setDescriptionDialog.getValue() != null) {
					description = setDescriptionDialog.getValue();
				}
				
				renameEditRule(editRule, name, description);
				
				WorkbenchUtil.showMessage("Edit-Rule saved:\n\n" + EcoreUtil.getURI(editRule).toPlatformString(true));
			}
		}
		
		return null;
	}

	public static void renameEditRule(Module editRule, String name, String description) {

		// Module and rule:
		editRule.setName(EditRuleNaming.formatModuleName(name));
		editRule.setDescription(description);
		
		EditRuleUtil.getMainRule(editRule).setName(EditRuleNaming.formatRuleName(name));
		
		// Files:
		String newFileName = EditRuleNaming.formatFileName(name);
		
		// Model:
		URI modelURI = editRule.eResource().getURI();
		URI newModelURI = modelURI.trimSegments(1).appendSegment(
				newFileName + "_execute").appendFileExtension("henshin");
		String oldModelName = modelURI.segment(modelURI.segmentCount() - 1);
		
		
		// Diagram:
		URI diagramURI = modelURI.trimFileExtension().appendFileExtension("henshin_diagram");
		URI newDiagramURI = modelURI.trimSegments(1).appendSegment(
				newFileName + "_execute").appendFileExtension("henshin_diagram");
		
		if (EMFStorage.uriToFile(diagramURI).exists()) {
			Resource diagram = editRule.eResource().getResourceSet().getResource(diagramURI, true);
			
			// Set URIs:
			diagram.setURI(newDiagramURI);
			editRule.eResource().setURI(newModelURI);
			
			// Save changes:
			try {
				// Save model:
				editRule.eResource().save(Collections.emptyMap());
				
				// Save diagram:
				Map<String, Object> options = new HashMap<String, Object>();
				options.put(XMIResource.OPTION_URI_HANDLER, new URIHandlerImpl() {
					
					@Override
					public URI deresolve(URI uri) {
						
						if (uri.segment(uri.segmentCount() - 1).equals(oldModelName)) {
							uri = uri.trimSegments(1).appendSegment(
									newFileName + "_execute").appendFileExtension("henshin");
						}
						
						return super.deresolve(uri);
					}
				});
				
				diagram.save(options);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}

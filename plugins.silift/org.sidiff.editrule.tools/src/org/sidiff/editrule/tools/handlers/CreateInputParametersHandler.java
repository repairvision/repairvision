package org.sidiff.editrule.tools.handlers;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRules;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.ParameterMapping;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.sidiff.common.emf.modelstorage.EMFHandlerUtil;
import org.sidiff.common.utilities.ui.util.WorkbenchUtil;
import org.sidiff.editrule.tools.util.EditRuleUtil;

/**
 * Creates an edit-rule input parameter.
 * 
 * @author Manuel Ohrndorf
 */
public class CreateInputParametersHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Module editRule = EMFHandlerUtil.getSelection(event, Module.class);
		
		if (editRule != null) {
			
			// Create dialog:
			ElementListSelectionDialog selectDialog = new ElementListSelectionDialog(
					Display.getDefault().getActiveShell(), new LabelProvider());
			selectDialog.setTitle("Create Input-Parameters");
			selectDialog.setHelpAvailable(false);
			selectDialog.setMultipleSelection(true);
			
			// Collect possible parameters:
			List<GraphElement> graphElements = new ArrayList<>();
			Set<String> identifiers = new HashSet<>();
			Unit mainUnit = EditRuleUtil.getMainUnit(editRule);
			
			for (ParameterMapping inputParameters : mainUnit.getParameterMappings()) {
				if (inputParameters.getTarget() != mainUnit) {
					identifiers.add(inputParameters.getTarget().getName());
				}
			}
			
			getRules(editRule).forEach(rule -> {
				
				// LHS nodes:
				rule.getLhs().getNodes().forEach(lhsNode -> {
					if (!identifiers.contains(getIdentifier(lhsNode))) {
						graphElements.add(lhsNode);
					}
				});
				
				// Attributes:
				rule.eAllContents().forEachRemaining((element -> {
					if (element instanceof Attribute) {
						if (!identifiers.contains(getIdentifier(element))) {
							graphElements.add((GraphElement) element);
							identifiers.add(getIdentifier(element));
						}
					}
				}));
			});
			
			selectDialog.setElements(graphElements.toArray());
			
			// Open dialog:
			selectDialog.open();
			
			// Create Input-Parameter:
			if (selectDialog.getResult() != null) {
				for(Object selection : selectDialog.getResult()) {
					if (selection instanceof GraphElement) {
						createInputParameter(editRule, getIdentifier(selection));
					}
				}
				
				// Save edit-rule:
				try {
					editRule.eResource().save(Collections.emptyMap());
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				WorkbenchUtil.showMessage("Edit-Rule saved:\n\n" + EcoreUtil.getURI(editRule).toPlatformString(true));
			}
		}
		
		return null;
	}
	
	public static void createInputParameter(Module editRule, String name) {
		EditRuleUtil.createInputParameter(editRule, name);
	}
	
	private String getIdentifier(Object element) {
		if (element instanceof GraphElement) {
			String identifier = null;
			
			if (element instanceof Node) {
				identifier = ((Node) element).getName();
			} else if (element instanceof Attribute) {
				identifier = ((Attribute) element).getValue();
			}
			
			return identifier;
		}
		
		return null;
	}
}

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
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.sidiff.common.emf.modelstorage.EMFHandlerUtil;
import org.sidiff.common.utilities.ui.util.WorkbenchUtil;
import org.sidiff.common.utilities.ui.util.WorkbenchUtil.NotEmptyValidator;
import org.sidiff.editrule.tools.util.EditRuleUtil;

/**
 * Renames node names and attribute variables.
 * 
 * @author Manuel Ohrndorf
 */
public class RenameEditRuleIdentifiersHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Module editRule = EMFHandlerUtil.getSelection(event, Module.class);
		
		if (editRule != null) {
			
			// Create dialog:
			ElementListSelectionDialog selectDialog = new ElementListSelectionDialog(
					Display.getDefault().getActiveShell(), new LabelProvider());
			selectDialog.setTitle("Identifier Selection");
			selectDialog.setHelpAvailable(false);
			selectDialog.setMultipleSelection(true);
			
			// Collect preserve nodes:
			List<GraphElement> graphElements = getEditRuleIdentifier(editRule);
			selectDialog.setElements(graphElements.toArray());
			
			// Open dialog:
			selectDialog.open();
			
			// Create Input-Parameter:
			if (selectDialog.getResult() != null) {
				for(Object selection : selectDialog.getResult()) {
					InputDialog setIdentifierDialog = new InputDialog(Display.getDefault().getActiveShell(), 
							"Set Identifier: " + selection, 
							"Enter new identifier:", getIdentifier(selection), 
							new NotEmptyValidator());
					
					setIdentifierDialog.open();
					
					if (setIdentifierDialog.getValue() != null) {
						renameEditRuleIdentifier((GraphElement) selection, setIdentifierDialog.getValue());
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
	
	public static List<GraphElement> getEditRuleIdentifier(Module editRule) {
		List<GraphElement> graphElements = new ArrayList<>();
		Set<String> identifiers = new HashSet<>();
		
		getRules(editRule).forEach(rule -> {
			rule.eAllContents().forEachRemaining(element -> {
				String identifier = getIdentifier(element);

				if ((identifier != null) && (!identifiers.contains(identifier))) {
					graphElements.add((GraphElement) element);
					identifiers.add(identifier);
				}
			});
		});
		
		return graphElements;
	}
	
	public static void renameEditRuleIdentifier(GraphElement graphElement, String identifier) {
		EditRuleUtil.renameIdentifier(graphElement, identifier);
	}
	
	private static String getIdentifier(Object element) {
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

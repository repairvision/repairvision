package org.sidiff.editrule.tools.handlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.emf.modelstorage.EMFHandlerUtil;
import org.sidiff.common.ui.util.UIUtil;

/**
 * Creates a parameter for each attribute variable.
 * 
 * @author Manuel Ohrndorf
 */
public class CreateAttributeParametersHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Module editRule = EMFHandlerUtil.getSelection(event, Module.class);
		
		if (editRule != null) {
			createAttributeParameters(editRule);
			
			// Save edit-rule:
			try {
				editRule.eResource().save(Collections.emptyMap());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			UIUtil.showMessage("Edit-Rule saved:\n\n" + EcoreUtil.getURI(editRule).toPlatformString(true));
		}
		
		return null;
	}
	
	public static void createAttributeParameters(Module editRule) {
		List<Attribute> attributes = new ArrayList<>();
		
		editRule.eAllContents().forEachRemaining(element -> {
			if (element instanceof Attribute) {
				 // Ignore attributes with constants!
				if (!((Attribute) element).getValue().contains("\"")) {
					attributes.add((Attribute) element);
				}
			}
		});
		
		for (Attribute attribute : attributes) {
			Rule rule = attribute.getNode().getGraph().getRule();
			
			if (rule.getParameter(attribute.getValue()) == null) {
				rule.getParameters().add(HenshinFactory.eINSTANCE.createParameter(attribute.getValue()));
			}
		}
	}
}

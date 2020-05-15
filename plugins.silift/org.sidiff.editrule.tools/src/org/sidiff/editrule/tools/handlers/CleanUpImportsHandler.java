package org.sidiff.editrule.tools.handlers;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.Module;
import org.sidiff.common.utilities.emf.EMFHandlerUtil;
import org.sidiff.common.utilities.ui.util.WorkbenchUtil;
import org.sidiff.editrule.tools.util.EditRuleUtil;

public class CleanUpImportsHandler extends AbstractHandler{

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Module editRule = EMFHandlerUtil.getSelection(event, Module.class);
		
		if (editRule != null) {
			cleanUpImports(editRule);
			
			try {
				editRule.eResource().save(Collections.emptyMap());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			WorkbenchUtil.showMessage("Edit-Rule saved:\n\n" + EcoreUtil.getURI(editRule).toPlatformString(true));
		}
		
		return null;
	}
	
	public static void cleanUpImports(Module editRule) {
		editRule.getImports().clear();
		editRule.getImports().addAll(EditRuleUtil.getImports(editRule));
	}
}

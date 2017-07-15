package org.sidiff.repair.history.editrules.generator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.common.util.URI;
import org.sidiff.common.emf.modelstorage.EMFHandlerUtil;
import org.sidiff.repair.historymodel.History;

public class HistoryToEditRuleGenerator extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		History history = EMFHandlerUtil.getSelection(event, History.class);
		
		if (history != null) {
			HistoryEditRuleGenerator generator = new HistoryEditRuleGenerator(history);
			
			// Generate edit-rules:
			generator.analyzeHistory();
			
			// Store edit-rules:
			String projectName = "org.sidiff." + getModelingDomain(history) + ".editrules.cpo";
			generator.storeRulebase(projectName, history.getName());
		}
		
		return null;
	}
	
	protected String getModelingDomain(History history) {
		if (history.getVersions().size() > 0) {
			return URI.createURI(history.getVersions().get(0).getModelURI()).fileExtension();
		} else {
			return "unkowndomain";
		}
	}
}

package org.sidiff.repair.history.editrules.generator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.sidiff.common.emf.modelstorage.EMFHandlerUtil;
import org.sidiff.repair.historymodel.History;

public class HistoryToEditRuleGenerator extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		History history = EMFHandlerUtil.getSelection(event, History.class);
		
		if (history != null) {
			HistoryEditRuleGenerator generator = new HistoryEditRuleGenerator(history);
			generator.analyzeHistory();
			generator.storeRulebas();
		}
		
		return null;
	}
	
}

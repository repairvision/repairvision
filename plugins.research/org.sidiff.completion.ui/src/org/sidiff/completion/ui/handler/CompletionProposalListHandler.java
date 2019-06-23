package org.sidiff.completion.ui.handler;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.completion.ui.list.CompletionProposalList;
import org.sidiff.integration.editor.util.ActiveModelEditorAccess;

public class CompletionProposalListHandler extends AbstractHandler {
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		// Get selection from editor;
		ActiveModelEditorAccess editorAccess = new ActiveModelEditorAccess();
		List<EObject> context = editorAccess.getModelSelection();
		
		// 
		if (!context.isEmpty()) {
			CompletionProposalList proposalList = new CompletionProposalList();
			
			// TEST:
//			proposalList.addProposals(TESTDATA.getProposals());
			
			proposalList.showPopupOnCursor();
			System.out.println(context);
			
			// TEST:
//			proposalList.addProposals(TESTDATA.getProposals());
//			proposalList.setSelection(0);
//			proposalList.addProposals(TESTDATA.getProposals());
//			proposalList.addProposals(TESTDATA.getProposals());
//			proposalList.addProposals(TESTDATA.getProposals());
//			proposalList.addProposals(TESTDATA.getProposals());
//			proposalList.addProposals(TESTDATA.getProposals());
		}
		
		return null;
	}
}

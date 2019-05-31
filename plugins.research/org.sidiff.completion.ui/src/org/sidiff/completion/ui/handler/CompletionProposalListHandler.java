package org.sidiff.completion.ui.handler;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.sidiff.completion.ui.list.CompletionProposalList;
import org.sidiff.completion.ui.list.TESTDATA;

public class CompletionProposalListHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		CompletionProposalList proposalList = new CompletionProposalList();
		
//		proposalList.addProposals(TESTDATA.getProposals());
		
		proposalList.showPopupOnCursor();
		
		proposalList.addProposals(TESTDATA.getProposals());
		proposalList.setSelection(0);
		proposalList.addProposals(TESTDATA.getProposals());
		proposalList.addProposals(TESTDATA.getProposals());
		proposalList.addProposals(TESTDATA.getProposals());
		proposalList.addProposals(TESTDATA.getProposals());
		proposalList.addProposals(TESTDATA.getProposals());
		
		return null;
	}

}

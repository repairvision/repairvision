package org.sidiff.completion.ui.model.proposals.handler;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.completion.ui.model.proposals.recognition.ModelCompletionProposalGenerator;
import org.sidiff.completion.ui.proposals.CompletionProposalList;
import org.sidiff.revision.common.emf.document.DocumentType;
import org.sidiff.revision.editrules.project.registry.RulebaseRegistry;
import org.sidiff.revision.editrules.project.registry.util.RulebaseUtil;
import org.sidiff.revision.ui.editors.integration.access.ActiveModelEditorAccess;

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
			
			// TODO: Cache
			List<Rule> editRules = RulebaseUtil.eLoadEditRules(
					RulebaseRegistry.getRulebases(".*?Completion.*", DocumentType.getDocumentType(context.get(0))), false);
			
			// TODO: Scheduling
			proposalList.showPopupOnCursor();
//			Job generateProposals = new Job("Find Proposals") {
//			
//				@Override
//				protected IStatus run(IProgressMonitor monitor) {
					new ModelCompletionProposalGenerator(editorAccess, editRules, context).generateProposals(proposalList);
//					proposalList.showPopupOnCursor();
//					return Status.OK_STATUS;
//				}
//			};
//			generateProposals.schedule();
			
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

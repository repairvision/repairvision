package org.sidiff.completion.ui.model.proposals;

import org.sidiff.revision.editrules.complement.plan.ComplementationPlanImpl;

public class ModelCompletionParameterBinding extends ComplementationPlanImpl {

	public ModelCompletionParameterBinding(ModelCompletionProposal proposal) {
		super(proposal.getComplement(), proposal.getProposalMatches());
	}

}

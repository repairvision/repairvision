package org.sidiff.completion.ui.model.proposals;

import org.sidiff.revision.editrules.complement.plan.ComplementationPlan;

public class ModelCompletionParameterBinding extends ComplementationPlan {

	public ModelCompletionParameterBinding(ModelCompletionProposal proposal) {
		super(proposal.getComplement(), proposal.getProposalMatches());
	}

}

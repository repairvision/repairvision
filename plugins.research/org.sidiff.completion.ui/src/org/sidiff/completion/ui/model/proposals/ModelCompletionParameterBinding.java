package org.sidiff.completion.ui.model.proposals;

import org.sidiff.repair.complement.repair.RepairPlan;

public class ModelCompletionParameterBinding extends RepairPlan {

	public ModelCompletionParameterBinding(ModelCompletionProposal proposal) {
		super(proposal.getComplement(), proposal.getProposalMatches());
	}

}
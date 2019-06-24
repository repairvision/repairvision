package org.sidiff.completion.ui.model;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.completion.ui.list.CompletionProposalList;
import org.sidiff.completion.ui.list.ICompletionProposal;
import org.sidiff.completion.ui.model.impact.ModelCompletionImpactAnalyzes;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.history.revision.IRevision;
import org.sidiff.history.revision.impl.Revision;
import org.sidiff.integration.editor.util.ActiveModelEditorAccess;
import org.sidiff.repair.complement.peo.finder.ComplementFinderEngine;
import org.sidiff.repair.ui.config.RepairPreferencePage;
import org.sidiff.validation.constraint.impact.ImpactAnalyzes;

public class ModelCompletionProposalGenerator {

	private List<Rule> editRules;
	
	private ActiveModelEditorAccess editorAccess;
	
	private List<EObject> context;
	
	private Resource historicModel;
	
	private Resource currentModel;
	
	public ModelCompletionProposalGenerator(ActiveModelEditorAccess editorAccess, List<Rule> editRules, List<EObject> context) {
		this.editorAccess = editorAccess;
		this.editRules = editRules;
		this.context = context;
	}

	public void generateProposals(CompletionProposalList proposalList) {
//		Job generateProposals = new Job("Find Proposals") {
//			
//			@Override
//			protected IStatus run(IProgressMonitor monitor) {
				populateSettings();
				calculateProposals(proposalList);
//				return Status.OK_STATUS;
//			}
//		};
//		generateProposals.schedule();
	}

	protected Resource getCurrentModel() {
		if (currentModel == null) {
			currentModel = editorAccess.getModelResource();
		}
		return currentModel;
	}

	protected Resource getHistoricModel() {
		if (historicModel == null) {
			// Load last saved model version:
			URI modelURI = editorAccess.getModelResource().getURI();
			return new ResourceSetImpl().getResource(modelURI, true);
		}
		return historicModel;
	}
	
	// org.sidiff.repair.ui.app.impl.EMFResourceRepairApplication<J, F>:
	
	protected void populateSettings() {
		if (getCurrentModel() != null) {
			RepairPreferencePage.populateSettings(getCurrentModel());
		} else if (getHistoricModel() != null) {
			RepairPreferencePage.populateSettings(getHistoricModel());
		}
	}
	
	protected DifferenceSettings getMatchingSettings() {
		return RepairPreferencePage.getMatchingSettings();
	}
	
	protected String getDoumentType() {
		return RepairPreferencePage.getDoumentType();
	}
	
	protected List<Rule> getEditRules() {
		return editRules;
	}
	
	protected ImpactAnalyzes getImpactAnalyzes(IRevision revision) {
		// Positive -> Current impact on context:
		// Negative -> Historic impact on context:
		return new ModelCompletionImpactAnalyzes(revision, context);
	}
	
	// org.sidiff.repair.api.peo.PEORepairCalculationEngine
	
	private IRevision calculateDifference() {
		DifferenceSettings differenceSettings = getMatchingSettings();
		IRevision revision = new Revision(getHistoricModel(), getCurrentModel(), differenceSettings);
		return revision;
	}
	
	private void calculateProposals(CompletionProposalList proposalList) {
		
		// Model difference between historical and current version:
		IRevision revision = calculateDifference();
		
		// Completion change impact:
		ImpactAnalyzes impactAnalyzes = getImpactAnalyzes(revision);
		
		// Henshin graph:
		EGraph graphCurrentModel = new EGraphImpl(getCurrentModel());
		
		// Calculate proposals:
		ComplementFinderEngine complementFinderEngine = new ComplementFinderEngine(revision, null, graphCurrentModel);
		complementFinderEngine.start();
		
		for (Rule editRule : getEditRules()) {
			ModelCompletionProposalCaculation proposalCaculation = new ModelCompletionProposalCaculation(editRule, impactAnalyzes, complementFinderEngine);
			
			if (proposalCaculation.isPotentialProposal()) {
				List<ICompletionProposal> proposalForEditRule = proposalCaculation.findProposals();
				proposalList.addProposals(proposalForEditRule);
			}
		}
	}
}

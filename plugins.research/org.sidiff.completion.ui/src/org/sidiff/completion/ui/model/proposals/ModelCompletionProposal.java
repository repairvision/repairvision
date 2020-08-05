package org.sidiff.completion.ui.model.proposals;

import static org.sidiff.completion.ui.model.proposals.util.ModelCompletionProposalUtil.generateDecompositionSequenceFromHierarchicals;

import java.util.List;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.RuleApplicationImpl;
import org.eclipse.emf.henshin.model.HenshinPackage;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.swt.graphics.Image;
import org.sidiff.completion.ui.model.proposals.util.DecompositionTemplates;
import org.sidiff.completion.ui.proposals.ICompletionPreview;
import org.sidiff.completion.ui.proposals.ICompletionProposal;
import org.sidiff.graphpattern.profile.henshin_extension.RuleExtension;
import org.sidiff.revision.common.emf.ItemProviderUtil;
import org.sidiff.revision.editrules.complement.construction.ComplementRule;

public class ModelCompletionProposal implements ICompletionProposal {

	private static Image ICON = (Image) ItemProviderUtil.getImageByType(HenshinPackage.eINSTANCE.getRule());
	
	private ComplementRule complement;
	
	private List<Match> proposalMatches;
	
	private ModelCompletionParameterBinding parameterBinding; 
	
	public ModelCompletionProposal(ComplementRule complement, List<Match> proposalMatches) {
		this.complement = complement;
		this.proposalMatches = proposalMatches;
	}
	
	public ComplementRule getComplement() {
		return complement;
	}
	
	public List<Match> getProposalMatches() {
		return proposalMatches;
	}
	
	public DecompositionTemplates getDecomposition() {
		return new DecompositionTemplates(this);
	}
	
	public ModelCompletionParameterBinding getParameterBinding() {
		if (parameterBinding == null) {
			this.parameterBinding = new ModelCompletionParameterBinding(this);
		}
		return parameterBinding;
	}
	
	@Override
	public String getText() {
		
		// Calculate name based on decomposition
		if ((complement.getComplementRule() instanceof RuleExtension) && (complement.getRecognizedRule() instanceof RuleExtension)) {
			DecompositionTemplates decomposition = getDecomposition();
			
			String complementDecompositionName = generateDecompositionSequenceFromHierarchicals(
					decomposition.getComplementTemplates());
			
			String recognizedDecompositionName = generateDecompositionSequenceFromHierarchicals(
					decomposition.getHistoricTemplates());
			
			return recognizedDecompositionName + " |-> " + complementDecompositionName;
		}
		
		return complement.getComplementRule().getName();
	}
	
	@Override
	public Image getImage() {
		return ICON;
	}

	@Override
	public String getInformation() {
		return "Partial execution of edit operation '" + complement.getComplementRule().getName() + "' recognized.";
	}

	@Override
	public ICompletionPreview preview() {
		// TODO: Apply/undo on editing domain
//		System.out.println("Preview: " + complement.getComplementRule().getName());
		return null;
	}

	@Override
	public boolean apply() {
		
		// SEE: org.sidiff.revision.repair.api.RepairJob
		
		// TODO: Apply on editing domain
		System.out.println("Apply: " + complement.getComplementRule().getName());

		return applyOnEditingDomain();
	}
	
	private boolean applyOnEditingDomain() {
		Resource resource = proposalMatches.get(proposalMatches.size() - 1).getNodeTargets().get(0).eResource();	// TODO
		
		boolean[] result = new boolean[1];
		TransactionalEditingDomain transactionalEditingDomain = TransactionUtil.getEditingDomain(resource);
		
		if (transactionalEditingDomain != null) {
			transactionalEditingDomain.getCommandStack().execute(new RecordingCommand(transactionalEditingDomain) {

				@Override
				protected void doExecute() {
					result[0] = applyHenshinRule();
				}

				@Override
				public boolean canUndo() {
					return true;
				}

			});
		} else {
			EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(resource.getContents().get(0));
			// TODO: check if TransactionalEditingDomain
			
			if (editingDomain != null) {
				editingDomain.getCommandStack().execute(new AbstractCommand() {
					
					@Override
					public void redo() {
					}
					
					@Override
					public boolean canUndo() {
						return false;
					}
					
					@Override
					public void execute() {
						result[0] = applyHenshinRule();
					}
					
					@Override
					public boolean canExecute() {
						return true;
					}
				});
			} else {
				result[0] = applyHenshinRule();
			}
		}
		
		
		return result[0];
	}
	
	private boolean applyHenshinRule() {
		
		// Apply repair:
		RuleApplication application = new RuleApplicationImpl(new EngineImpl());
//		application.setEGraph(targetGraph);	// TODO
		application.setRule(complement.getComplementRule());
		application.setCompleteMatch(proposalMatches.get(proposalMatches.size() - 1));
		
		return application.execute(null);
	}

}

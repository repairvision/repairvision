package org.sidiff.repair.ui.peo.integrated;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.sidiff.consistency.common.emf.DocumentType;
import org.sidiff.consistency.common.ui.util.WorkbenchUtil;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.history.analysis.tracing.HistoryModelDatabase;
import org.sidiff.history.analysis.validation.FOLValidator;
import org.sidiff.integration.editor.access.IntegrationEditorAccess;
import org.sidiff.integration.editor.extension.IEditorIntegration;
import org.sidiff.repair.api.IRepairFacade;
import org.sidiff.repair.api.IRepairPlan;
import org.sidiff.repair.api.peo.PEORepairJob;
import org.sidiff.repair.api.peo.PEORepairSettings;
import org.sidiff.repair.editrules.library.RulebaseLibrary;
import org.sidiff.repair.ui.app.impl.EMFResourceRepairApplication;
import org.sidiff.repair.ui.util.EditRuleUtil;
import org.sidiff.validation.constraint.api.ValidationFacade;
import org.sidiff.validation.constraint.api.util.RepairValidation;
import org.sidiff.validation.constraint.api.util.Validation;

public class IntegratedRepairApplication extends EMFResourceRepairApplication<PEORepairJob, PEORepairSettings> {

	private Job modelValidation;
	
	private Job repairCalculation;
	
	private IRepairFacade<PEORepairJob, PEORepairSettings> repairFacade;
	
	private DifferenceSettings settings;
	
	private Collection<Rule> editRules;
	
	private Validation inconsistency;
	
	private List<Validation> validations;
	
	private PEORepairJob repairJob;
	
	@Override
	public void initialize(IRepairFacade<PEORepairJob, PEORepairSettings> repairFacade) {
		this.repairFacade = repairFacade;
	}
	
	@Override
	public void validation() {
		
		// Clear old repair job:
		inconsistency = null;
		validations = null;
		
		// TODO: Manage repair stack by the application not the repair job!
		if ((repairJob != null) && getCurrentModelVersion() != repairJob.getModelB()) {
			repairJob = null;
		}
		
		// Model validation:
		modelValidation();
	}
	
	private void modelValidation() {
		
		// Model validation:
		modelValidation = new Job("Model Validation") {
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				
				// Set the current model version:
				Display.getDefault().syncExec(() -> {
					setModelB(getCurrentModelVersion());
				});
				
				// Search inconsistencies:
				validations = ValidationFacade.validate(getModelB());
				
				// Update UI:
				Display.getDefault().syncExec(() -> {
					fireResultChangeListener();
				});
				
				return Status.OK_STATUS;
			}
		};
		
		modelValidation.schedule();
	}
	
	private Resource getCurrentModelVersion() {
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		
		for (IEditorIntegration editorIntegration : IntegrationEditorAccess.getInstance().getIntegrationEditors()) {
			try {
				EditingDomain editingDomain = editorIntegration.getEditingDomain(editor);
				
				if (editingDomain != null) {
					for (Resource resource : editingDomain.getResourceSet().getResources()) {
						if (editorIntegration.supportsModel(resource.getURI())) {
							return resource;
						}
					}
				}
			} catch (Exception e) {
			}
		}
		
		return null;
	}
	
	@Override
	public void calculateRepairs() {
		
		repairCalculation = new Job("Calculate Repairs") {
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				repairCalculation.setName("Analyze Model History");
				PEORepairJob lastRepairJob = repairJob;
				
				// Matching-Settings:
				settings = getMatchingSettings();
				
				// Search last consistent model version:
				setModelA(getHistoricModel());
				
				// Load edit rules:
				// TODO: cache edit rules?
//				if (editRules == null) {
					editRules = EditRuleUtil.eLoadEditRules(
							RulebaseLibrary.getEditRules(DocumentType.getDocumentType(getModelB())), false);
//				}
				
				// Calculate repairs:
				repairCalculation.setName("Calculate Repairs");
				
				PEORepairSettings repairSettings = new PEORepairSettings(editRules, settings);
				repairSettings.setupValidationFilter(
						Collections.singletonList(inconsistency.getContext()),
						Collections.singletonList(inconsistency.getRule()));
				
				repairJob = repairFacade.getRepairs(getModelA(), getModelB(), repairSettings);
				
				// Copy undo history:
				if (lastRepairJob != null) {
					repairJob.copyHistory(lastRepairJob);
				}
				
				// Update UI:
				Display.getDefault().syncExec(() -> {
					
					// Clean up repair-trees:
					for (RepairValidation validation : repairJob.getValidations()) {
						validation.cleanUpRepairTree();
					}
					
					// Show repairs:
					fireResultChangeListener();
				});
				
				return Status.OK_STATUS;
			}
		};
		
		repairCalculation.schedule();
	}
	
	private Resource getHistoricModel() {
		return HistoryModelDatabase.getHistoricConsistentModel(getModelB(), new FOLValidator(), inconsistency, settings);
	}
	
	@Override
	public void recalculateRepairs() {
		
		// Model validation:
		modelValidation();
		
		// Repair calculation:
		if (inconsistency != null) {
			repairCalculation = new Job("Recalculate Repairs") {

				@Override
				protected IStatus run(IProgressMonitor monitor) {
					PEORepairJob lastRepairJob = repairJob;

					// Calculate repairs:
					PEORepairSettings repairSettings = new PEORepairSettings(editRules, settings);
					repairSettings.setupValidationFilter(
							Collections.singletonList(inconsistency.getContext()),
							Collections.singletonList(inconsistency.getRule()));

					repairJob = repairFacade.getRepairs(
							repairJob.getModelA(), repairJob.getModelB(), repairSettings);

					// Copy undo history:
					if (lastRepairJob != null) {
						repairJob.copyHistory(lastRepairJob);
					}

					// Update UI:
					Display.getDefault().syncExec(() -> {

						// Show repairs:
						fireResultChangeListener();
					});

					return Status.OK_STATUS;
				}
			};

			repairCalculation.schedule();
		}
	}
	
	@Override
	public boolean applyRepair(IRepairPlan repair, Match match) {
		TransactionalEditingDomain transactionalEditingDomain = TransactionUtil.getEditingDomain(getModelB());
		
		if (transactionalEditingDomain != null) {
			transactionalEditingDomain.getCommandStack().execute(new RecordingCommand(transactionalEditingDomain) {

				@Override
				protected void doExecute() {
					repairJob.applyRepair(repair, match, false);
				}

				@Override
				public boolean canUndo() {
					return true;
				}

			});
			
			// FIXME: Missing return result! Check if command was executed correctly!
			return true;
		} else {
			EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(getModelB().getContents().get(0));
			
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
						repairJob.applyRepair(repair, match, false);
					}
					
					@Override
					public boolean canExecute() {
						return true;
					}
				});
				
				// FIXME: Missing return result! Check if command was executed correctly!
				return true;
			} else {
				return repairJob.applyRepair(repair, match, false);
			}
		}
	}
	
	@Override
	public boolean undoRepair() {
		
		if (repairJob == null) {
			WorkbenchUtil.showMessage("Please start the repair calculation!");
			return false;
		}
		
		if (repairCalculation.getState() == Job.RUNNING) {
			WorkbenchUtil.showMessage("Please wait for the repair calculation!");
			return false;
		}
		
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(getModelB());
		
		if (editingDomain != null) {
			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

				@Override
				protected void doExecute() {
					repairJob.undoRepair(false);
				}

				@Override
				public boolean canUndo() {
					return true;
				}

			});
			
			// FIXME: Missing return result! Check if command was executed correctly!
			return true;
		} else {
			return repairJob.undoRepair(false);
		}
	}
	
	@Override
	public PEORepairJob getRepairJob() {
		return repairJob;
	}
	
	public Validation getInconsistency() {
		return inconsistency;
	}
	
	public void setInconsistency(Validation inconsistency) {
		this.inconsistency = inconsistency;
	}
	
	public List<Validation> getValidations() {
		return validations;
	}
}

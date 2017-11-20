package org.sidiff.repair.ui.peo.integrated;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.sidiff.common.emf.modelstorage.EMFStorage;
import org.sidiff.consistency.common.emf.DocumentType;
import org.sidiff.consistency.common.ui.util.WorkbenchUtil;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.integration.editor.access.IntegrationEditorAccess;
import org.sidiff.integration.editor.extension.IEditorIntegration;
import org.sidiff.repair.api.IRepairFacade;
import org.sidiff.repair.api.IRepairPlan;
import org.sidiff.repair.api.peo.PEORepairJob;
import org.sidiff.repair.api.peo.PEORepairSettings;
import org.sidiff.repair.editrules.library.RulebaseLibrary;
import org.sidiff.repair.historymodel.History;
import org.sidiff.repair.historymodel.ValidationError;
import org.sidiff.repair.historymodel.Version;
import org.sidiff.repair.ui.app.impl.EMFResourceRepairApplication;
import org.sidiff.repair.ui.peo.integrated.app.FOLValidator;
import org.sidiff.repair.ui.peo.integrated.app.HistoryModelGenerator;
import org.sidiff.repair.ui.peo.integrated.app.SVNConnector;
import org.sidiff.repair.ui.util.EditRuleUtil;
import org.sidiff.validation.constraint.api.ValidationFacade;
import org.sidiff.validation.constraint.api.util.RepairValidation;
import org.sidiff.validation.constraint.api.util.Validation;
import org.sidiff.validation.constraint.interpreter.IConstraint;

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
	public void calculateRepairs() {
		
		// Clear old repair job:
		inconsistency = null;
		validations = null;
		repairJob = null;
		
		
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
	
	public void calculateRepairProposals() {
		
		repairCalculation = new Job("Calculate Repairs") {
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				
				repairCalculation.setName("Analyze Model History");
				
				// Matching-Settings:
				settings = getMatchingSettings();
				
				// Search last consistent model version:
				setModelA(getHistoricModel());
				
				// Load edit rules:
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
				
				// Update UI:
				Display.getDefault().syncExec(() -> {
					
					// Clean up repair-trees:
					for (RepairValidation validation : repairJob.getValidations()) {
						validation.cleanUpRepairTree();
					}
					
					// Show repairs:
					fireResultChangeListener();
					
					if (repairJob.getRepairs().isEmpty()) {
						WorkbenchUtil.showMessage("No repairs found!");
					}
				});
				
				return Status.OK_STATUS;
			}
		};
		
		repairCalculation.schedule();
	}
	
	private Resource getHistoricModel() {
		
		URI historyDatabaseURI = getModelB().getURI().appendFileExtension("history");
		File historyDatabaseFile = EMFStorage.uriToFile(historyDatabaseURI);
		History history = null;
		
		// Update history database:
		if (historyDatabaseFile.exists()) {
			
			// Load history model:
			ResourceSet rss = new ResourceSetImpl();
			Resource historyResource = rss.getResource(historyDatabaseURI, true);
			
			history = (History) historyResource.getContents().get(0);
			
			// FIXME: Append new versions from repository!
			
			// Update current version:
			Version currentModelVersion = HistoryModelGenerator.generateVersion(
					history.getVersions().size(), getModelB(), new FOLValidator());
			
			history.getVersions().remove(history.getVersions().size() - 1);
			history.getVersions().add(currentModelVersion);
			
			// TODO: Make this incremental:
			HistoryModelGenerator.generateIntroducedAndResolved(history, new FOLValidator());
		} 
		
		// Create new history database:
		else {
			
			// Check out revisions:
			SVNConnector vcsConnector = new SVNConnector(getModelB());
			List<File> revisions = vcsConnector.getRevisions();
			
			// Append current version
			Collections.reverse(revisions);
			revisions.add(EMFStorage.uriToFile(getModelB().getURI()));
			
			// Search inconsistency traces:
			history = HistoryModelGenerator.generateHistory(
					getModelB().getURI().toString(), revisions, 
					new FOLValidator(), settings);
			
			try {
				ResourceSet rss = new ResourceSetImpl();
				Resource historyResource = rss.createResource(getModelB().getURI().appendFileExtension("history"));
				historyResource.getContents().add(history);
				
				historyResource.save(Collections.emptyMap());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// Find last consistent version:
		if (history != null) {
			Version versionModelB = history.getVersions().get(history.getVersions().size() - 1);
			ValidationError validationError = getValidationError(inconsistency, versionModelB);
			Version lastConsistentVersion = getPrecessorRevision(validationError.getIntroducedIn());
			
			if (lastConsistentVersion != null) {
				return lastConsistentVersion.getModel();
			}
		}
			
		return null;
	}
	
	public static Version getPrecessorRevision(Version version) {
		History history = (History) version.eContainer();
		int index = history.getVersions().indexOf(version);

		if ((index - 1) >= 0) {
			return history.getVersions().get(index - 1);
		}
		
		return null;
	}
	
	public static ValidationError getValidationError(Validation validation, Version model) {
		
		for(ValidationError nextValidationError : model.getValidationErrors()) {
			if (equalsValidation(validation, nextValidationError)) {
				return nextValidationError;
			}
		}
		
		return null;
	}
	
	public static boolean equalsValidation(Validation validationA, ValidationError validationB) {
		
		if (getValidationID(validationA.getRule()).equalsIgnoreCase(getValidationID(validationB))) {
			EObject invalidElementA = validationA.getContext();
			EObject invalidElementB = validationB.getContext();

			if (EcoreUtil.getURI(invalidElementA).fragment().equals(EcoreUtil.getURI(invalidElementB).fragment())) {
				return true;
			}
		}
			
		return false;
	}
	
	public static String getValidationID(String name) {
		return name.replaceAll("[^\\p{Alpha}]", "");
	}
	
	public static String getValidationID(IConstraint validation) {
		return getValidationID(validation.getName());
	}
	
	public static String getValidationID(ValidationError validation) {
		return getValidationID(validation.getName());
	}
	
	@Override
	public void recalculateRepairs() {
		
		// Model validation:
		modelValidation();
		
		// Repair calculation:
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
				repairJob.copyHistory(lastRepairJob);
				
				// Update UI:
				Display.getDefault().syncExec(() -> {

					// Show repairs:
					fireResultChangeListener();
					
					if (repairJob.getRepairs().isEmpty()) {
						WorkbenchUtil.showMessage("No repairs found!");
					}
				});
				
				return Status.OK_STATUS;
			}
		};
		
		repairCalculation.schedule();
	}
	
	@Override
	public boolean applyRepair(IRepairPlan repair, Match match) {
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(getModelB());
		
		if (editingDomain != null) {
			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

				@Override
				protected void doExecute() {
					repairJob.applyRepair(repair, match, false);
				}

				@Override
				public boolean canUndo() {
					return true;
				}

			});
			
			// FIXME: Missing result!
			return true;
		} else {
			return repairJob.applyRepair(repair, match, false);
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
			
			// FIXME: Missing result!
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

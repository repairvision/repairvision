package org.sidiff.revision.repair.api.peo.configuration;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.utilities.emf.DocumentType;
import org.sidiff.revision.difference.api.settings.DifferenceSettings;
import org.sidiff.revision.repair.api.BasicRepairSettings;
import org.sidiff.revision.repair.complement.peo.configuration.ComplementFinderSettings;
import org.sidiff.validation.constraint.interpreter.IConstraint;
import org.sidiff.validation.constraint.project.registry.ConstraintLibraryRegistry;
import org.sidiff.validation.constraint.project.registry.util.ConstraintLibraryUtil;

public class PEORepairSettings extends BasicRepairSettings {

	/**
	 * Monitor for the repair process.
	 */
	private PEORepairMonitor monitor = new PEORepairMonitor();
	
	/**
	 * All edit-rules which are to be investigated for partial executions.
	 */
	private Collection<Rule> editRules;
	
	/**
	 * The settings for the difference calculation.
	 */
	private DifferenceSettings differenceSettings;
	
	/**
	 * Store generated recognition rules.
	 */
	private boolean saveRecognitionRules = false;
	
	/**
	 * The consistency rules for the model validation.
	 */
	private List<IConstraint> consistencyRules;
	
	/**
	 * The context elements that should be validated.
	 */
	private Iterable<EObject> validationScope; 
	
	/**
	 * Settings of the complement finde.
	 */
	private ComplementFinderSettings complementFinderSettings = new ComplementFinderSettings();

	public PEORepairSettings(Iterable<EObject> validationScope, Collection<Rule> editRules, DifferenceSettings differenceSettings) {
		super();
		this.validationScope = validationScope;
		this.editRules = editRules;
		this.differenceSettings = differenceSettings;
	}
	
	public PEORepairMonitor getMonitor() {
		return monitor;
	}
	
	public void setMonitor(PEORepairMonitor monitor) {
		this.monitor = monitor;
	}
	
	public Collection<Rule> getEditRules() {
		return editRules;
	}

	public void setEditRules(Collection<Rule> editRules) {
		this.editRules = editRules;
	}

	public DifferenceSettings getDifferenceSettings() {
		return differenceSettings;
	}

	public void setDifferenceSettings(DifferenceSettings differenceSettings) {
		this.differenceSettings = differenceSettings;
	}

	public boolean saveRecognitionRules() {
		return saveRecognitionRules;
	}

	public void setSaveRecognitionRules(boolean saveRecognitionRules) {
		this.saveRecognitionRules = saveRecognitionRules;
	}
	
	public List<IConstraint> getConsistencyRules() {
		return consistencyRules;
	}
	
	public void setConsistencyRules(List<IConstraint> consistencyRules) {
		this.consistencyRules = consistencyRules;
	}
	
	/**
	 * @param model
	 *            The model that should be validated.
	 * @return <code>true</code> if the setup could be performed;
	 *         <code>false</code> otherwise.
	 */
	public boolean setupConsistencyRules(Resource model) {
		consistencyRules = ConstraintLibraryUtil.getConsistencyRules(
				ConstraintLibraryRegistry.getLibraries(DocumentType.getDocumentType(model)));
		return (consistencyRules != null);
	}
	
	public Iterable<EObject> getValidationScope() {
		return validationScope;
	}
	
	public void setValidationScope(Iterable<EObject> validationScope) {
		this.validationScope = validationScope;
	}
	
	public ComplementFinderSettings getComplementFinderSettings() {
		return complementFinderSettings;
	}
	
	public void setComplementFinderSettings(ComplementFinderSettings complementFinderSettings) {
		this.complementFinderSettings = complementFinderSettings;
	}
}

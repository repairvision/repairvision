package org.sidiff.revision.repair.api.configuration;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.revision.api.BasicComplementationSettings;
import org.sidiff.revision.common.emf.document.DocumentType;
import org.sidiff.revision.difference.api.settings.DifferenceSettings;
import org.sidiff.revision.editrules.complement.matching.configuration.ComplementFinderSettings;
import org.sidiff.validation.constraint.interpreter.IConstraint;
import org.sidiff.validation.constraint.project.registry.ConstraintLibraryRegistry;
import org.sidiff.validation.constraint.project.registry.util.ConstraintLibraryUtil;

public class RepairSettings extends BasicComplementationSettings {

	/**
	 * Monitor for the repair process.
	 */
	private RepairLogger logger = new RepairLogger();
	
	/**
	 * All edit-rules which are to be investigated for partial executions.
	 */
	private Collection<Rule> editRules;
	
	/**
	 * The settings for the difference calculation.
	 */
	private DifferenceSettings differenceSettings;
	
	/**
	 * The consistency rules for the model validation.
	 */
	private List<IConstraint> consistencyRules;
	
	/**
	 * The context elements that should be validated.
	 */
	private Iterable<EObject> validationScope; 
	
	/**
	 * Settings of the complement finder.
	 */
	private ComplementFinderSettings complementFinderSettings = new ComplementFinderSettings();

	public RepairSettings(Iterable<EObject> validationScope, Collection<Rule> editRules, DifferenceSettings differenceSettings) {
		super();
		this.validationScope = validationScope;
		this.editRules = editRules;
		this.differenceSettings = differenceSettings;
	}
	
	public RepairLogger getLogger() {
		return logger;
	}
	
	public void setLogger(RepairLogger monitor) {
		this.logger = monitor;
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

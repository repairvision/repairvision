package org.sidiff.repair.api.peo;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.common.emf.DocumentType;
import org.sidiff.consistency.common.monitor.LogTable;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.repair.api.BasicRepairSettings;
import org.sidiff.validation.constraint.api.library.ConstraintLibraryRegistry;
import org.sidiff.validation.constraint.api.library.util.ConstraintLibraryUtil;
import org.sidiff.validation.constraint.api.util.ContextValidationFilter;
import org.sidiff.validation.constraint.api.util.IValidationFilter;
import org.sidiff.validation.constraint.interpreter.IConstraint;

public class PEORepairSettings extends BasicRepairSettings {

	/**
	 * Monitor for the repair process.
	 */
	private IProgressMonitor monitor = new NullProgressMonitor();
	
	/**
	 * Observes intermediate results (for debugging).
	 */
	private PEORepairMonitor repairMonitor = new PEORepairMonitor();
	
	/**
	 * Logging of processed changes to runtime.
	 */
	private LogTable runtimeComlexityLog = null;
	
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
	 * Filters validations based on the consistency rule and the context element.
	 */
	private IValidationFilter validationFilter = IValidationFilter.DUMMY; 

	public PEORepairSettings(Collection<Rule> editRules, DifferenceSettings differenceSettings) {
		super();
		this.editRules = editRules;
		this.differenceSettings = differenceSettings;
	}
	
	public IProgressMonitor getMonitor() {
		return monitor;
	}
	
	public void setMonitor(IProgressMonitor monitor) {
		this.monitor = monitor;
	}
	
	public PEORepairMonitor getRepairMonitor() {
		return repairMonitor;
	}
	
	public void setRepairMonitor(PEORepairMonitor repairMonitor) {
		this.repairMonitor = repairMonitor;
	}
	
	public LogTable getRuntimeComlexityLog() {
		return runtimeComlexityLog;
	}
	
	public void setRuntimeComlexityLog(LogTable runtimeComlexityLog) {
		this.runtimeComlexityLog = runtimeComlexityLog;
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
	
	public IValidationFilter getValidationFilter() {
		return validationFilter;
	}
	
	public void setValidationFilter(IValidationFilter validationFilter) {
		this.validationFilter = validationFilter;
	}
	
	/**
	 * @param contextElements
	 *            The context elements that should be validated.
	 * @return <code>true</code> if the setup could be performed;
	 *         <code>false</code> otherwise.
	 */
	public boolean setupValidationFilter(Collection<EObject> contextElements) {
		this.validationFilter = new ContextValidationFilter(contextElements);
		return true;
	}
	
	/**
	 * @param contextElements
	 *            The context elements that should be validated.
	 * @param consistencyRules
	 *            The consistency rules that should be validated.
	 * @return <code>true</code> if the setup could be performed;
	 *         <code>false</code> otherwise.
	 */
	public boolean setupValidationFilter(Collection<EObject> contextElements, List<IConstraint> consistencyRules) {
		setConsistencyRules(consistencyRules);
		return setupValidationFilter(contextElements);
	}
}

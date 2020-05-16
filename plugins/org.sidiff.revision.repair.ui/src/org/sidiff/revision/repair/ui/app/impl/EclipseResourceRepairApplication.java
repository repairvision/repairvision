package org.sidiff.revision.repair.ui.app.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.sidiff.common.utilities.ui.util.WorkbenchUtil;
import org.sidiff.revision.difference.api.settings.DifferenceSettings;
import org.sidiff.revision.editrules.project.registry.RulebaseRegistry;
import org.sidiff.revision.repair.api.IRepairSettings;
import org.sidiff.revision.repair.api.RepairJob;
import org.sidiff.revision.repair.ui.app.IRepairApplication;
import org.sidiff.revision.repair.ui.app.IResultChangedListener;
import org.sidiff.revision.repair.ui.config.RepairPreferencePage;
import org.sidiff.validation.constraint.interpreter.IConstraint;
import org.sidiff.validation.constraint.project.registry.ConstraintLibraryRegistry;

public abstract class EclipseResourceRepairApplication<J extends RepairJob<?>, F extends IRepairSettings> implements IRepairApplication<J, F> {

	protected List<IResultChangedListener<J>> listeners = new ArrayList<>();
	
	protected Resource modelA;
	
	protected IResource modelAFile;
	
	protected Resource modelB;
	
	protected IResource modelBFile;
	
	@Override
	public void addResultChangedListener(IResultChangedListener<J> listener) {
		listeners.add(listener);
	}
	
	@Override
	public void removeResultChangeListener(IResultChangedListener<J> listener) {
		listeners.remove(listener);
	}
	
	protected void fireResultChangeListener() {
		listeners.forEach(l -> l.resultChanged(getRepairJob()));
	}
	
	@Override
	public void clearResultChangeListener() {
		listeners.clear();
	}
	
	public IResource setModelA(IResource element) {
		modelAFile = element;
		populateSettings();
		return element;
	}
	
	public IResource getModelAFile() {
		return modelAFile;
	}
	
	public Resource getModelA() {
		
		if ((modelA == null) && (modelAFile != null)) {
			modelA = new ResourceSetImpl().getResource(WorkbenchUtil.getURI(modelAFile), true);
		}
		return modelA;
	}
	
	public IResource unsetModelA(IResource selection) {
		modelAFile = null;
		modelA = null;
		
		populateSettings();
		
		return selection;
	}

	public IResource setModelB(IResource element) {
		modelBFile = element;
		populateSettings();
		return element;
	}
	
	public IResource getModelBFile() {
		return modelBFile;
	}
	
	public Resource getModelB() {
		
		if ((modelB == null) && (modelBFile != null)) {
			modelB =  new ResourceSetImpl().getResource(WorkbenchUtil.getURI(modelBFile), true);
		}
		return modelB;
	}
	
	public IResource unsetModelB(IResource selection) {
		modelBFile = null;
		modelB = null;
		
		populateSettings();
		
		return selection;
	}

	protected void populateSettings() {
		if (getModelA() != null) {
			RepairPreferencePage.populateSettings(getModelA());
		} else if (getModelB() != null) {
			RepairPreferencePage.populateSettings(getModelB());
		}
	}
	
	protected DifferenceSettings getMatchingSettings() {
		return RepairPreferencePage.getMatchingSettings();
	}
	
	protected String getDoumentType() {
		return RepairPreferencePage.getDoumentType();
	}
	
	protected List<URI> getEditRules() {
		return RulebaseRegistry.getEditRules(getDoumentType(), RepairPreferencePage.getRulebases());
	}
	
	protected List<IConstraint> getConstraints() {
		return ConstraintLibraryRegistry.getConstraints(getDoumentType(), RepairPreferencePage.getConstraintLibraries());
	}
	
	@Override
	public void clear() {
		unsetModelA(modelAFile);
		unsetModelB(modelBFile);
	}
}

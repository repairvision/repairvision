package org.sidiff.repair.ui.app.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.repair.api.IRepairSettings;
import org.sidiff.repair.api.RepairJob;
import org.sidiff.repair.ui.app.IRepairApplication;
import org.sidiff.repair.ui.app.IResultChangedListener;
import org.sidiff.repair.ui.config.RepairPreferencePage;
import org.sidiff.repair.ui.controls.basic.ModelDropWidget;

public abstract class EclipseResourceRepairApplication<J extends RepairJob<?>, F extends IRepairSettings> implements IRepairApplication<J, F> {

	protected List<IResultChangedListener<J>> listeners = new ArrayList<>();
	
	protected ResourceSet differenceRSS = new ResourceSetImpl();
	
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
			modelA = differenceRSS.getResource(ModelDropWidget.getURI(modelAFile), true);
		}
		return modelA;
	}
	
	public IResource unsetModelA(IResource selection) {
		
		differenceRSS.getResources().remove(getModelA());
		
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
			modelB = differenceRSS.getResource(ModelDropWidget.getURI(modelBFile), true);
		}
		return modelB;
	}
	
	public IResource unsetModelB(IResource selection) {
		
		differenceRSS.getResources().remove(getModelB());
		
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
	
	@Override
	public void clear() {
		differenceRSS = new ResourceSetImpl();
		unsetModelA(modelAFile);
		unsetModelB(modelBFile);
	}
}

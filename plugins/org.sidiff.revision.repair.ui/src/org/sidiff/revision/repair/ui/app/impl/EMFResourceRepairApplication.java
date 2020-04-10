package org.sidiff.revision.repair.ui.app.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.revision.difference.derivation.api.settings.DifferenceSettings;
import org.sidiff.revision.repair.api.IRepairSettings;
import org.sidiff.revision.repair.api.RepairJob;
import org.sidiff.revision.repair.ui.app.IRepairApplication;
import org.sidiff.revision.repair.ui.app.IResultChangedListener;
import org.sidiff.revision.repair.ui.config.RepairPreferencePage;

public abstract class EMFResourceRepairApplication<J extends RepairJob<?>, F extends IRepairSettings> implements IRepairApplication<J, F> {

	protected List<IResultChangedListener<J>> listeners = new ArrayList<>();
	
	protected Resource modelA;
	
	protected Resource modelB;
	
	@Override
	public void addResultChangedListener(IResultChangedListener<J> listener) {
		listeners.add(listener);
	}
	
	@Override
	public void removeResultChangeListener(IResultChangedListener<J> listener) {
		listeners.remove(listener);
	}
	
	@Override
	public void clearResultChangeListener() {
		listeners.clear();
	}
	
	protected void fireResultChangeListener() {
		listeners.forEach(l -> l.resultChanged(getRepairJob()));
	}
	
	public Resource getModelA() {
		return modelA;
	}
	
	public Resource unsetModelA(Resource selection) {
		modelA = null;
		populateSettings();
		return selection;
	}

	public Resource setModelA(Resource element) {
		modelA = element;
		populateSettings();
		return element;
	}

	public Resource unsetModelB(Resource selection) {
		modelB = null;
		populateSettings();
		return selection;
	}

	public Resource setModelB(Resource element) {
		modelB = element;
		populateSettings();
		return element;
	}
	
	public Resource getModelB() {
		return modelB;
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
		unsetModelA(modelA);
		unsetModelB(modelB);
	}
}

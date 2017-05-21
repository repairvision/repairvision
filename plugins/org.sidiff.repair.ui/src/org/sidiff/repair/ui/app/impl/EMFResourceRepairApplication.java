package org.sidiff.repair.ui.app.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.henshin.emf.DocumentType;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.matcher.IMatcher;
import org.sidiff.matcher.MatcherUtil;
import org.sidiff.repair.api.IRepairSettings;
import org.sidiff.repair.api.RepairJob;
import org.sidiff.repair.ui.app.IRepairApplication;
import org.sidiff.repair.ui.app.IResultChangedListener;
import org.sidiff.repair.ui.config.RepairPreferencePage;

public abstract class EMFResourceRepairApplication<J extends RepairJob<?>, F extends IRepairSettings> implements IRepairApplication<J, F> {

	protected List<IResultChangedListener<J>> listeners = new ArrayList<>();
	
	protected Resource modelA;
	
	protected Resource modelB;
	
	protected String documentType;
	
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
		showAvailableMatchers();
		return selection;
	}

	public Resource setModelA(Resource element) {
		modelA = element;
		showAvailableMatchers();
		return element;
	}

	public Resource unsetModelB(Resource selection) {
		modelB = null;
		showAvailableMatchers();
		return selection;
	}

	public Resource setModelB(Resource element) {
		modelB = element;
		showAvailableMatchers();
		return element;
	}
	
	public Resource getModelB() {
		return modelB;
	}

	private void showAvailableMatchers() {
		if ((modelA != null) && (modelB != null))  {
			
//			documentType = EMFModelAccess.getCharacteristicDocumentType(modelARes);
			documentType = DocumentType.getDocumentType(modelA.getContents().get(0));
			
			Set<IMatcher> matchers = MatcherUtil.getAvailableMatchers(Arrays.asList(modelA, modelB));
			RepairPreferencePage.setAvailableMatcher(matchers);
		} else {
			RepairPreferencePage.setAvailableMatcher(null);
			documentType = null;
		}
	}
	
	protected DifferenceSettings getMatchingSettings() {

		// Matching-Settings:
		if (documentType != null) {
			DifferenceSettings settings = new DifferenceSettings(Collections.singleton(documentType)) {};
			settings.setMatcher(RepairPreferencePage.getSelectedMatcher());
			return settings;
		}
		
		return null;
	}
	
	@Override
	public void clear() {
		unsetModelA(modelA);
		unsetModelB(modelB);
		documentType = null;
	}
}

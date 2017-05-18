package org.sidiff.repair.ui.app.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.sidiff.common.henshin.emf.DocumentType;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.matcher.IMatcher;
import org.sidiff.matcher.MatcherUtil;
import org.sidiff.repair.api.IRepairSettings;
import org.sidiff.repair.api.RepairJob;
import org.sidiff.repair.ui.app.IRepairApplication;
import org.sidiff.repair.ui.app.IResultChangedListener;
import org.sidiff.repair.ui.config.RepairPreferencePage;
import org.sidiff.repair.ui.controls.basic.ModelDropWidget;

public abstract class EclipseResourceRepairApplication<J extends RepairJob<?>, F extends IRepairSettings> implements IRepairApplication<J, F> {

	protected List<IResultChangedListener<J>> listeners = new ArrayList<>();
	
	protected IResource modelAFile;
	
	protected IResource modelBFile;
	
	protected String documentType;
	
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
	
	public IResource getModelAFile() {
		return modelAFile;
	}
	
	public IResource unsetModelA(IResource selection) {
		modelAFile = null;
		showAvailableMatchers();
		return selection;
	}

	public IResource setModelA(IResource element) {
		modelAFile = element;
		showAvailableMatchers();
		return element;
	}

	public IResource unsetModelB(IResource selection) {
		modelBFile = null;
		showAvailableMatchers();
		return selection;
	}

	public IResource setModelB(IResource element) {
		modelBFile = element;
		showAvailableMatchers();
		return element;
	}
	
	public IResource getModelBFile() {
		return modelBFile;
	}

	private void showAvailableMatchers() {
		if ((modelAFile != null) && (modelBFile != null))  {
			
			// FIXME: We need a parser which only reads the document-type in the header...
			ResourceSet differenceRSS = new ResourceSetImpl();
			Resource modelARes = differenceRSS.getResource(ModelDropWidget.getURI(modelAFile), true);
			Resource modelBRes = differenceRSS.getResource(ModelDropWidget.getURI(modelBFile), true);
			
//			documentType = EMFModelAccess.getCharacteristicDocumentType(modelARes);
			documentType = DocumentType.getDocumentType(modelARes.getContents().get(0));
			
			Set<IMatcher> matchers = MatcherUtil.getAvailableMatchers(Arrays.asList(modelARes, modelBRes));
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
		unsetModelA(modelAFile);
		unsetModelB(modelBFile);
		documentType = null;
	}
}

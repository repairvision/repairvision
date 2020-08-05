package org.sidiff.revision.ui.application.basic;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.sidiff.revision.api.ComplementationJob;
import org.sidiff.revision.api.ComplementationSettings;
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;

public abstract class EclipseResourceComplementationApplication<J extends ComplementationJob<?>, F extends ComplementationSettings> extends BasicComplementationApplication<J, F> {

	protected Resource modelA;
	
	protected IResource modelAFile;
	
	protected Resource modelB;
	
	protected IResource modelBFile;
	
	public IResource setModelA(IResource element) {
		modelAFile = element;
		initializeSettings();
		return element;
	}
	
	public IResource getModelAFile() {
		return modelAFile;
	}
	
	@Override
	public Resource getModelA() {
		
		if ((modelA == null) && (modelAFile != null)) {
			modelA = new ResourceSetImpl().getResource(WorkbenchUtil.getURI(modelAFile), true);
		}
		return modelA;
	}
	
	public IResource unsetModelA(IResource selection) {
		modelAFile = null;
		modelA = null;
		
		initializeSettings();
		
		return selection;
	}

	public IResource setModelB(IResource element) {
		modelBFile = element;
		initializeSettings();
		return element;
	}
	
	public IResource getModelBFile() {
		return modelBFile;
	}
	
	@Override
	public Resource getModelB() {
		
		if ((modelB == null) && (modelBFile != null)) {
			modelB =  new ResourceSetImpl().getResource(WorkbenchUtil.getURI(modelBFile), true);
		}
		return modelB;
	}
	
	public IResource unsetModelB(IResource selection) {
		modelBFile = null;
		modelB = null;
		
		initializeSettings();
		
		return selection;
	}
	
	@Override
	public void clear() {
		unsetModelA(modelAFile);
		unsetModelB(modelBFile);
	}
}

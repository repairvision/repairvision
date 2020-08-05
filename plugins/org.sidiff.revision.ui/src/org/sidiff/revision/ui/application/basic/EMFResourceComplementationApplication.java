package org.sidiff.revision.ui.application.basic;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.revision.api.ComplementationJob;
import org.sidiff.revision.api.ComplementationSettings;

public abstract class EMFResourceComplementationApplication<J extends ComplementationJob<?>, F extends ComplementationSettings> extends BasicComplementationApplication<J, F> {

	protected Resource modelA;
	
	protected Resource modelB;
	
	@Override
	public Resource getModelA() {
		return modelA;
	}
	
	public Resource unsetModelA(Resource selection) {
		modelA = null;
		initializeSettings();
		return selection;
	}

	public Resource setModelA(Resource element) {
		modelA = element;
		initializeSettings();
		return element;
	}

	public Resource unsetModelB(Resource selection) {
		modelB = null;
		initializeSettings();
		return selection;
	}

	public Resource setModelB(Resource element) {
		modelB = element;
		initializeSettings();
		return element;
	}
	
	@Override
	public Resource getModelB() {
		return modelB;
	}

	@Override
	public void clear() {
		unsetModelA(modelA);
		unsetModelB(modelB);
	}
}

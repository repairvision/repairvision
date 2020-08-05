package org.sidiff.revision.ui.application.basic;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.revision.api.ComplementationJob;
import org.sidiff.revision.api.ComplementationSettings;
import org.sidiff.revision.ui.application.ComplementationApplication;
import org.sidiff.revision.ui.application.ResultChangedListener;

public abstract class BasicComplementationApplication <J extends ComplementationJob<?>, F extends ComplementationSettings> implements ComplementationApplication<J, F> {
	
	public List<ResultChangedListener<J>> listeners;
	
	public BasicComplementationApplication() {
		this.listeners = new ArrayList<>();
	}

	@Override
	public void addResultChangedListener(ResultChangedListener<J> listener) {
		listeners.add(listener);
	}
	
	@Override
	public void removeResultChangeListener(ResultChangedListener<J> listener) {
		listeners.remove(listener);
	}
	
	protected void fireResultChangeListener() {
		listeners.forEach(l -> l.resultChanged(getComplementationJob()));
	}
	
	@Override
	public void clearResultChangeListener() {
		listeners.clear();
	}
	
	protected abstract void initializeSettings();
	
	public abstract Resource getModelA();
	
	public abstract Resource getModelB();
}
package org.sidiff.revision.model.impl;

import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.revision.model.ModelAST;
import org.sidiff.revision.model.ModelSet;

public class EModelAST implements ModelAST {

	private ModelSet modelSet;
	
	private Resource model;
	
	public EModelAST(ModelSet modelSet, Resource model) {
		this.modelSet = modelSet;
		this.model = model;
	}

	@Override
	public ModelSet getModelSet() {
		return modelSet;
	}

	@Override
	public Object getRoot() {
		return model;
	}

	@Override
	public Iterator<? extends Object> children(Object element) {
		if (element instanceof EObject) {
			return ((EObject) element).eContents().iterator();
		} else if(element instanceof Resource) {
			return ((Resource) element).getContents().iterator();
		}
		return Collections.emptyIterator();
	}

	@Override
	public Object container(Object element) {
		if (element instanceof EObject) {
			EObject obj = ((EObject) element).eContainer();
			
			if (obj != null) {
				return obj;
			} else if (model.getContents().contains(obj)) {
				return model;
			}
		}
		return null;
	}
}

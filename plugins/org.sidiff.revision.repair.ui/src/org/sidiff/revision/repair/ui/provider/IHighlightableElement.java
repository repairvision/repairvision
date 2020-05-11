package org.sidiff.revision.repair.ui.provider;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;

public interface IHighlightableElement {
	
	Iterator<? extends EObject> getModelElements();
}

package org.sidiff.revision.ui.viewer.provider;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;

public interface IHighlightableElement {
	
	Iterator<? extends EObject> getModelElements();
}

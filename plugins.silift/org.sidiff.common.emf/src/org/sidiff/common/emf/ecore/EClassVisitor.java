package org.sidiff.common.emf.ecore;

import org.eclipse.emf.ecore.EClassifier;


public interface EClassVisitor {

	public void eClassifier(EClassifier eClassifier, String fullyQualifiedPath);
	
	public void finish();
}

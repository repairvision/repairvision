package org.sidiff.revision.editrule.recognition.pattern.graph;

import org.eclipse.emf.ecore.EAttribute;

public interface ActionAttributeConstraint {
	
	EAttribute getType();
	
	boolean check(Object value);
}

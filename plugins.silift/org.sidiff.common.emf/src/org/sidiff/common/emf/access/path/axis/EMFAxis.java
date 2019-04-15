package org.sidiff.common.emf.access.path.axis;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.access.path.impl.EMFPathStepImpl;

public abstract class EMFAxis {
	
	protected String argumentString = null;
	
	// Requires uniform Constructor
	EMFAxis(String argumentString) {
		this.argumentString = argumentString;
	}
	
	/**
	 * Initializes the Axis with the given, partially initialized Step/Path.  
	 * 
	 * @param step The axis containing step.
	 */
	public abstract void initAxis(EMFPathStepImpl step);
	
	/**
	 * Bestimmt den ergebnisstyp der Achse. Dabei kann es sich um den erwarteten 
	 * Ergebnisstyp, aber auch um einen beliebigen Super-Typ davon handeln!
	 * 
	 * @return 
	 */
	public abstract EClass resultType();

	/**
	 * Computes a set of objects regarding the concrete axis and the given context.
	 * This call is performance critical!
	 * 
	 * @param contextObjects
	 * @return Step/Axis result regarding the axis semantics.
	 */
	public abstract Collection<EObject> evaluateAxis(Collection<EObject> contextObjects);
	

}

package org.sidiff.common.emf.access.tree;

import org.eclipse.emf.ecore.EObject;

/**
 * Implements a {@TreeVisitor} without any function.
 * 
 */
public abstract class TreeVisitorAdapter implements TreeVisitor {

	@Override
	public void postExecute(EObject object) {
	}

	/**
	 * Returns always true.
	 */
	@Override
	public boolean preExecute(EObject object) {
		return true;
	}
}

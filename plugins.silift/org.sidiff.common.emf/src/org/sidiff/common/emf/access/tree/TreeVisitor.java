package org.sidiff.common.emf.access.tree;

import org.eclipse.emf.ecore.EObject;

/**
 * Visitor to traverse over the tree structure of models.
 * @author wenzel
 *
 */
public interface TreeVisitor {

	/**
	 * Operation that is called for an object before its subtree is traversed.
	 * 
	 * @param object
	 *            The object visited by the traversal.
	 * @return The operation has to return true, if the subtree should be traversed, or false, if the subtree should not be traversed
	 */
	public boolean preExecute(EObject object);

	/**
	 * Operation that is called for an object after its subtree has been traversed.
	 * 
	 * @param object
	 *            The object visited by the traversal.
	 */
	public void postExecute(EObject object);

//	/**
//	 * Operation that is called for the resource before is traversed.
//	 * 
//	 * @param root
//	 *            The resource to be traversed
//	 * @throws NoValidTreeException
//	 *             if the tree cannot be traversed. E.g. due to missing requirements.
//	 */
//	public void init(Resource root) throws NoValidTreeException;

//	/**
//	 * Operation that is called for the resource after it has been traversed.
//	 * 
//	 * @param root
//	 *            The resource that has been traversed
//	 */
//	public void finish(Resource root);

}

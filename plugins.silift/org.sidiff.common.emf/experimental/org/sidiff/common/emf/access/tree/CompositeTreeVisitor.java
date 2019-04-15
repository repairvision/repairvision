//TODO Review, Asserts, Doku
package org.sidiff.common.emf.access.tree;

import java.util.*;

import org.eclipse.emf.ecore.EObject;

public class CompositeTreeVisitor implements TreeVisitor {

	private List<TreeVisitor> visitors = null;

	public CompositeTreeVisitor() {
		this.visitors = new LinkedList<TreeVisitor>();
	}

	public CompositeTreeVisitor(Collection<? extends TreeVisitor> visitors) {
		assert(visitors!=null) : "Composite of null??";
		
		this.visitors = new LinkedList<TreeVisitor>();
		this.visitors.addAll(visitors);
	}

	public void addVisitor(TreeVisitor visitor) {
		assert(visitor!=null) : "Cannot add null!"; 
	
		this.visitors.add(visitor);
	}

	public boolean preExecute(EObject object) {
		
		// Just forward operation to children.
		boolean result = true;
		for (TreeVisitor vis : visitors) {
			result &= vis.preExecute(object);
		}
		return result;
	}

	public void postExecute(EObject object) {
		// Just forward operation to children.
		for (TreeVisitor vis : visitors) {
			vis.postExecute(object);
		}
	}
	
// TODO: Remove Me
//	public void init(Resource root) throws NoValidTreeException {
//		// Just forward operation to children.
//		for (TreeVisitor vis : visitors) {
//			try {
//				vis.init(root);
//			} catch (NoValidTreeException e) {
//				vis.finish(root);
//				throw e;
//			}
//		}
//	}
//
//	public void finish(Resource root) {
//		// Just forward operation to children.
//		for (TreeVisitor vis : visitors)
//			vis.finish(root);
//	}

}

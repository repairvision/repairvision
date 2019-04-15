package org.sidiff.difference.symmetric.util.debug;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.AttributeValueChange;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.matching.model.Correspondence;

/**
 * Reduces a given symmetric difference to its relevant parts. All identical
 * objects of models A and B which are not part of the context of any low-level
 * change are removed from the models. The respective correspondences are also
 * removed from the difference. <br/>
 * For debugging purposes only!
 * 
 * @author kehrer
 */
public class ModelReducer {

	private SymmetricDifference diff;

	public ModelReducer(SymmetricDifference diff) {
		this.diff = diff;
	}

	public void reduce() {
		List<Correspondence> allCorrespondences = new LinkedList<Correspondence>(diff.getMatching().getCorrespondences());

		for (Correspondence c : allCorrespondences) {
			if (!isInvolvedInChange(c.getMatchedA()) && !hasChildrenInvolvedInChange(c.getMatchedA()) && !isInvolvedInChange(c.getMatchedB())
					&& !hasChildrenInvolvedInChange(c.getMatchedB())) {
				System.out.println(">>> Delete: " + c.getMatchedA() + " <-> " + c.getMatchedB());
				EcoreUtil.delete(c);
				EcoreUtil.delete(c.getMatchedA());
				EcoreUtil.delete(c.getMatchedB());
			}
		}
	}

	private boolean isInvolvedInChange(EObject obj) {
		for (Change change : diff.getChanges()) {
			if (change instanceof AddObject) {
				if (((AddObject) change).getObj() == obj) {
					return true;
				}
			} else if (change instanceof RemoveObject) {
				if (((RemoveObject) change).getObj() == obj) {
					return true;
				}
			} else if (change instanceof AddReference) {
				if (((AddReference) change).getSrc() == obj || ((AddReference) change).getTgt() == obj) {
					return true;
				}
			} else if (change instanceof RemoveReference) {
				if (((RemoveReference) change).getSrc() == obj || ((RemoveReference) change).getTgt() == obj) {
					return true;
				}
			} else if (change instanceof AttributeValueChange) {
				if (((AttributeValueChange) change).getObjA() == obj || ((AttributeValueChange) change).getObjB() == obj) {
					return true;
				}
			} else {
				assert (false) : "Unknown change type: " + change;
			}
		}

		return false;
	}

	private boolean hasChildrenInvolvedInChange(EObject obj) {
		TreeIterator<EObject> it = obj.eAllContents();
		while (it.hasNext()) {
			EObject child = it.next();
			if (isInvolvedInChange(child)) {
				return true;
			}
		}

		return false;
	}
}

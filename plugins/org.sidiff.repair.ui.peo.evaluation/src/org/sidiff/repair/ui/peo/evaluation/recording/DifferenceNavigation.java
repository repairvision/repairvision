package org.sidiff.repair.ui.peo.evaluation.recording;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.editrule.partialmatcher.util.IndexedCrossReferencer;
import org.sidiff.editrule.partialmatcher.util.LiftingGraphDomainMap;
import org.sidiff.editrule.partialmatcher.util.LiftingGraphIndex;

public class DifferenceNavigation {

	protected LiftingGraphIndex changeIndex;
	
	protected LiftingGraphDomainMap changeDomainMap;
	
	protected IndexedCrossReferencer crossReferencer;

	public DifferenceNavigation(
			LiftingGraphIndex changeIndex, 
			LiftingGraphDomainMap changeDomainMap,
			IndexedCrossReferencer crossReferencer) {
		super();
		this.changeIndex = changeIndex;
		this.changeDomainMap = changeDomainMap;
		this.crossReferencer = crossReferencer;
	}

	public LiftingGraphIndex getChangeIndex() {
		return changeIndex;
	}

	public void setChangeIndex(LiftingGraphIndex changeIndex) {
		this.changeIndex = changeIndex;
	}

	public LiftingGraphDomainMap getChangeDomainMap() {
		return changeDomainMap;
	}

	public void setChangeDomainMap(LiftingGraphDomainMap changeDomainMap) {
		this.changeDomainMap = changeDomainMap;
	}

	public IndexedCrossReferencer getCrossReferencer() {
		return crossReferencer;
	}

	public void setCrossReferencer(IndexedCrossReferencer crossReferencer) {
		this.crossReferencer = crossReferencer;
	}

	/**
	 * @param object
	 *            The source object.
	 * @param type
	 *            The type of the source object.
	 * @return An unmodifiable list of target objects.
	 */
	@SuppressWarnings("unchecked")
	public Iterator<? extends EObject> getTargets(EObject object, EReference type, boolean inverse) {
		
		if (inverse) {
			return crossReferencer.getInverse(object, type);
		} else {
			
			// Create reference list:
			List<EObject> targets;
			
			if (type.isMany()) {
				targets = ( List<EObject>) object.eGet(type, true);
			} else {
				EObject value = (EObject) object.eGet(type, true);
				
				if (value != null) {
					targets = Collections.singletonList(value);
				} else {
					targets = Collections.emptyList();
				}
			}
			
			return targets.iterator();
		}
	}
}

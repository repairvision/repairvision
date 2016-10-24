package org.sidiff.consistency.repair.ui.views.rankings;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.sidiff.consistency.repair.api.IRepair;

public class HistoricComplementingRatioRepairRanking extends ViewerSorter  {

	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		
		// Show the element with the greater ratio on top of the viewer:
		if ((e1 instanceof IRepair) && (e2 instanceof IRepair)) {
			double ratio1 = (double) ((IRepair) e1).getHistoricChanges().size() / ((IRepair) e1).getComplementingChanges().size();
			double ratio2 = (double) ((IRepair) e2).getHistoricChanges().size() / ((IRepair) e2).getComplementingChanges().size();
			double diff = (ratio1 - ratio2);
			
			if (diff != 0) {
				if (diff < 0) {
					return 1;
				} else {
					return -1;
				}
			}
		}
		
		return 0;
	}
}

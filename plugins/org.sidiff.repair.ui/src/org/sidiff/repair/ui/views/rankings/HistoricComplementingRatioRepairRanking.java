package org.sidiff.repair.ui.views.rankings;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.sidiff.repair.api.IRepairPlan;

public class HistoricComplementingRatioRepairRanking extends ViewerComparator  {

	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		
		// Show the element with the greater ratio on top of the viewer:
		if ((e1 instanceof IRepairPlan) && (e2 instanceof IRepairPlan)) {
			double ratio1 = (double) ((IRepairPlan) e1).getHistoricChanges().size() / ((IRepairPlan) e1).getComplementingChanges().size();
			double ratio2 = (double) ((IRepairPlan) e2).getHistoricChanges().size() / ((IRepairPlan) e2).getComplementingChanges().size();
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

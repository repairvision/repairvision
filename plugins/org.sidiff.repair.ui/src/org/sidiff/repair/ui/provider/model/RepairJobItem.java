package org.sidiff.repair.ui.provider.model;

import java.util.List;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.graphics.Image;
import org.sidiff.repair.api.IRepairPlan;
import org.sidiff.repair.api.RepairJob;
import org.sidiff.repair.ui.Activator;

public class RepairJobItem implements IItemProvider {
	
	protected static Image ICON_REPAIR_JOB = Activator.getImageDescriptor("icons/repair.png").createImage();
	
	protected static final String TEXT_REPAIR_JOB = "Repairs";
	
	protected TreeViewer viewer;
	
	protected RepairJob<? extends IRepairPlan> repairJob;
	
	protected RepairPlanItem[] repairs;

	public RepairJobItem(TreeViewer viewer, RepairJob<? extends IRepairPlan> repairJob) {
		this.viewer = viewer;
		this.repairJob = repairJob;
	}

	@Override
	public String getText() {
		return TEXT_REPAIR_JOB;
	}

	@Override
	public Image getImage() {
		return ICON_REPAIR_JOB;
	}
	
	@Override
	public boolean hasChildren(Object element) {
		return repairJob.getRepairs().size() > 0;
	}

	@Override
	public Object[] getChildren() {
		
		if (repairs == null) {
			List<? extends IRepairPlan> repairPlans = repairJob.getRepairs();
			this.repairs = new RepairPlanItem[repairPlans.size()];
			
			for (int i = 0; i < repairs.length; i++) {
				repairs[i] = new RepairPlanItem(this, repairPlans.get(i));
			}
		}
		
		return repairs;
	}
	
	@Override
	public Object getParent() {
		return null;
	}
	
	public TreeViewer getTreeViewer() {
		return viewer;
	}
}

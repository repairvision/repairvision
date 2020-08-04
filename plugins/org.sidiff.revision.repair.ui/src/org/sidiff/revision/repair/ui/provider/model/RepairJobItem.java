package org.sidiff.revision.repair.ui.provider.model;

import java.util.List;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.graphics.Image;
import org.sidiff.revision.api.ComplementationJob;
import org.sidiff.revision.api.IComplementationPlan;
import org.sidiff.revision.repair.ui.Activator;

public class RepairJobItem implements IItemProvider {
	
	protected static Image ICON_REPAIR_JOB = Activator.getImageDescriptor("icons/repair.png").createImage();
	
	protected static final String TEXT_REPAIR_JOB = "Repairs";
	
	protected TreeViewer viewer;
	
	protected ComplementationJob<? extends IComplementationPlan> complementationJob;
	
	protected RepairPlanItem[] repairs;

	public RepairJobItem(TreeViewer viewer, ComplementationJob<? extends IComplementationPlan> repairJob) {
		this.viewer = viewer;
		this.complementationJob = repairJob;
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
		return complementationJob.getComplementationPlans().size() > 0;
	}

	@Override
	public Object[] getChildren() {
		
		if (repairs == null) {
			List<? extends IComplementationPlan> complementationPlans = complementationJob.getComplementationPlans();
			this.repairs = new RepairPlanItem[complementationPlans.size()];
			
			for (int i = 0; i < repairs.length; i++) {
				repairs[i] = new RepairPlanItem(this, complementationPlans.get(i));
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

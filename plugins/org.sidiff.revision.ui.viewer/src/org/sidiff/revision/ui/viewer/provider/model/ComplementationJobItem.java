package org.sidiff.revision.ui.viewer.provider.model;

import java.util.List;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.graphics.Image;
import org.sidiff.revision.api.ComplementationJob;
import org.sidiff.revision.api.ComplementationPlan;
import org.sidiff.revision.ui.viewer.Activator;

public class ComplementationJobItem implements IItemProvider {
	
	protected static Image ICON_COMPLEMENTATION_JOB = Activator.getImageDescriptor("icons/complementation.png").createImage();
	
	protected static final String TEXT_COMPLEMENTATION_JOB = "Complementations";
	
	protected TreeViewer viewer;
	
	protected ComplementationJob<? extends ComplementationPlan> complementationJob;
	
	protected ComplementationPlanItem[] complementations;

	public ComplementationJobItem(TreeViewer viewer, ComplementationJob<? extends ComplementationPlan> complementationJob) {
		this.viewer = viewer;
		this.complementationJob = complementationJob;
	}

	@Override
	public String getText() {
		return TEXT_COMPLEMENTATION_JOB;
	}

	@Override
	public Image getImage() {
		return ICON_COMPLEMENTATION_JOB;
	}
	
	@Override
	public boolean hasChildren(Object element) {
		return complementationJob.getComplementationPlans().size() > 0;
	}

	@Override
	public Object[] getChildren() {
		
		if (complementations == null) {
			List<? extends ComplementationPlan> complementationPlans = complementationJob.getComplementationPlans();
			this.complementations = new ComplementationPlanItem[complementationPlans.size()];
			
			for (int i = 0; i < complementations.length; i++) {
				complementations[i] = new ComplementationPlanItem(this, complementationPlans.get(i));
			}
		}
		
		return complementations;
	}
	
	@Override
	public Object getParent() {
		return null;
	}
	
	public TreeViewer getTreeViewer() {
		return viewer;
	}
}

package org.sidiff.repair.ui.provider.model;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.swt.graphics.Image;
import org.sidiff.repair.ui.Activator;

public class ChangeSetComplementing extends ChangeSetItem {

	protected static final String TEXT_CHANGE_ACTIONS_COMPLEMENTING = "Complementing Changes";
	
	protected static final Image ICON_CHANGE_ACTIONS_COMPLEMENTING = Activator.getImageDescriptor("icons/changeset.gif").createImage();

	public ChangeSetComplementing(RepairPlanItem repairPlan) {
		super(repairPlan);
	}
	
	@Override
	public String getText() {
		return TEXT_CHANGE_ACTIONS_COMPLEMENTING;
	}

	@Override
	public Image getIcon() {
		return ICON_CHANGE_ACTIONS_COMPLEMENTING;
	}
	
	@Override
	public boolean hasChildren(Object element) {
		return true;
	}
	
	@Override
	public Object[] getChildren() {
		
		// Initialize changes:
		if (changes == null) {
			initializeChanges(repairPlan.getRepairPlan().getComplementingChanges());
		}
		
		return changes;
	}

	@Override
	public void actionDoubleClick() {
	}

	@Override
	public void actionSelection() {
	}
	
	@Override
	public EObject[] getDomain(Node node) {
		return repairPlan.getRepairPlan().getComplementDomain(node).toArray(new EObject[0]);
	}
}

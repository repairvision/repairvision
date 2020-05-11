package org.sidiff.revision.repair.ui.provider.model;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.swt.graphics.Image;
import org.sidiff.revision.repair.ui.Activator;

public class ChangeSetRecognized extends ChangeSetItem {

	protected static final String TEXT_CHANGE_ACTIONS_HISTORIC = "Recognized Changes";
	
	protected static final Image ICON_CHANGE_ACTIONS_HISTORIC = Activator.getImageDescriptor("icons/changeset.gif").createImage();
	
	public ChangeSetRecognized(RepairPlanItem repairPlan) {
		super(repairPlan);
	}
	
	@Override
	public String getText() {
		return TEXT_CHANGE_ACTIONS_HISTORIC;
	}

	@Override
	public Image getImage() {
		return ICON_CHANGE_ACTIONS_HISTORIC;
	}
	
	@Override
	public boolean hasChildren(Object element) {
		return true;
	}
	
	@Override
	public Object[] getChildren() {
		
		// Initialize changes:
		if (changes == null) {
			initializeChanges(repairPlan.getRepairPlan().getRecognizedChanges());
		}
		
		return changes;
	}
	
	@Override
	public EObject[] getDomain(Node node) {
		List<EObject[]> recognitionDomain = repairPlan.getRepairPlan().getRecognitionDomain(node);
		EObject[] flatDomain = new EObject[recognitionDomain.size()];
		
		for (int i = 0; i < flatDomain.length; i++) {
			EObject[] historyMatch = recognitionDomain.get(i);
			
			if (historyMatch[0] != null) {
				flatDomain[i] = historyMatch[0];
			}
			
			else if (historyMatch[1] != null) {
				flatDomain[i] = historyMatch[1];
			}
		}
		
		return flatDomain;
	}
}

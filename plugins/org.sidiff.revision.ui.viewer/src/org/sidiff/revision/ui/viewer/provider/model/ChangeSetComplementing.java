package org.sidiff.revision.ui.viewer.provider.model;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.swt.graphics.Image;
import org.sidiff.revision.ui.viewer.Activator;

public class ChangeSetComplementing extends ChangeSetItem {

	protected static final String TEXT_CHANGE_ACTIONS_COMPLEMENTING = "Complementing Changes";
	
	protected static final Image ICON_CHANGE_ACTIONS_COMPLEMENTING = Activator.getImageDescriptor("icons/changeset.gif").createImage();

	public ChangeSetComplementing(ComplementationPlanItem complementationPlan) {
		super(complementationPlan);
	}
	
	@Override
	public String getText() {
		return TEXT_CHANGE_ACTIONS_COMPLEMENTING;
	}

	@Override
	public Image getImage() {
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
			initializeChanges(complementationPlan.getComplementationPlan().getComplementingChanges());
		}
		
		return changes;
	}
	
	@Override
	public EObject[] getDomain(Node node) {
		return complementationPlan.getComplementationPlan().getComplementDomain(node).toArray(new EObject[0]);
	}
}

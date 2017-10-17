package org.sidiff.repair.ui.provider.model;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;

public abstract class ChangeSetItem implements IItemProvider {

	protected RepairPlanItem repairPlan;
	
	protected ActionItem[] changes;

	public ChangeSetItem(RepairPlanItem repairPlan) {
		this.repairPlan = repairPlan;
	}
	
	protected void initializeChanges(List<GraphElement> graphChanges) {
		this.changes = new ActionItem[graphChanges.size()];

		for (int i = 0; i < changes.length; i++) {
			GraphElement graphElement = graphChanges.get(i);

			if (graphElement instanceof Node) {
				changes[i] = new ActionNodeItem(this, (Node) graphElement);
			}

			else if (graphElement instanceof Edge) {
				changes[i] = new ActionEdgeItem(this, (Edge) graphElement);
			}

			else if (graphElement instanceof Attribute) {
				changes[i] = new ActionAttributeItem(this, (Attribute) graphElement);
			}
		}
	}
	
	@Override
	public Object getParent() {
		return repairPlan;
	}
	
	public abstract EObject[] getDomain(Node node);
}

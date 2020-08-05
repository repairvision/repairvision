package org.sidiff.revision.ui.viewer.provider.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.revision.ui.viewer.provider.IHighlightableElement;

public abstract class ChangeSetItem implements IItemProvider, IHighlightableElement {

	protected ComplementationPlanItem complementationPlan;
	
	protected ActionItem[] changes;

	public ChangeSetItem(ComplementationPlanItem complementationPlan) {
		this.complementationPlan = complementationPlan;
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
		return complementationPlan;
	}
	
	public abstract EObject[] getDomain(Node node);
	
	@Override
	public Iterator<? extends EObject> getModelElements() {
		Set<EObject> elements = new HashSet<>();
		getChildren(); // initialize changes!
		
		for (int i = 0; i < changes.length; i++) {
			changes[i].getModelElements().forEachRemaining(elements::add);
		}
		
		return elements.iterator();
	}
}

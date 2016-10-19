package org.sidiff.consistency.repair.lifting.ui.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx;
import org.sidiff.consistency.repair.complement.construction.match.ComplementMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleEdgeMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleNodeMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleNodeSingleMatch;
import org.sidiff.consistency.repair.lifting.api.Repair;

public class RepairContentProvider implements IStructuredContentProvider, ITreeContentProvider  {

	protected Map<Rule, List<Repair>> repairs;
	
	public class Container {
		String label;
		Image icon;
		Object parent;
		Object[] content;
	}
	
	public class Change {
		GraphElement graphElement;
		Node[] nodes;
		EObject[] matches;
	}
	
	@Override
	public void dispose() {
	}

	@SuppressWarnings("unchecked")
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		
		if (newInput instanceof Map<?, ?>) {
			repairs = (Map<Rule, List<Repair>>) newInput;
		}
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		
		if (parentElement instanceof Rule) {
			return repairs.get(parentElement).toArray();
		}
		
		else if (parentElement instanceof Repair) {
			Repair repair = (Repair) parentElement;
			
			// Historic changes:
			int historicSize = repair.getHistoricChanges().size();
			
			Container historicChanges = new Container();
			historicChanges.label = "Historic [" + historicSize + "]";
			historicChanges.icon = RepairLabelProvider.IMG_CHECK_MARK;
			
			historicChanges.parent = parentElement;
			historicChanges.content = new Object[historicSize];
			
			for (int i = 0; i < historicSize; i++) {
				GraphElement historic = repair.getHistoricChanges().get(i);
				historicChanges.content[i] = toHistoricChange(repair.getSourceMatch(historic));
			}
			
			// Complementing changes:
			int complementingSize = repair.getComplementingChanges().size();
			
			Container complementingChanges = new Container();
			complementingChanges.label = "Complementing [" + complementingSize + "]";
			complementingChanges.icon = RepairLabelProvider.IMG_QUESTION_MARK;
			
			complementingChanges.parent = parentElement;
			complementingChanges.content = new Object[complementingSize];
			
			for (int i = 0; i < complementingSize; i++) {
				complementingChanges.content[i] = toComplemetingChange(
						repair.getComplementingChanges().get(i),
						repair.getRepairPreMatch());
			}
			
			return new Object[] {historicChanges, complementingChanges};
		}
		
		// e.g. Complementing/Historic container:
		else if (parentElement instanceof Container) {
			// Return e.g. changes as children:
			return ((Container) parentElement).content;
		}
		
		else if (parentElement instanceof Change) {
			Change change = ((Change) parentElement);
			return change.matches;
		}
		
		return new Object[0];
	}
	
	private Change toHistoricChange(EditRuleMatch editRuleMatch) {
		Change change = new Change();
		
		if (editRuleMatch instanceof EditRuleEdgeMatch) {
			Edge edge = ((EditRuleEdgeMatch) editRuleMatch).getEdge();
			change.graphElement = edge;
			
			change.nodes = new Node[2];
			change.nodes[0] = edge.getSource();
			change.nodes[1] = edge.getTarget();
			
			EObject srcMatch = null;
			EObject tgtMatch = null;
			
			if (((EditRuleEdgeMatch) editRuleMatch).getAction().equals(Type.DELETE)) {
				srcMatch = ((EditRuleEdgeMatch) editRuleMatch).getSrcModelAElement();
				tgtMatch = ((EditRuleEdgeMatch) editRuleMatch).getTgtModelAElement();
			} else {
				assert ((EditRuleEdgeMatch) editRuleMatch).getAction().equals(Type.CREATE);
				
				srcMatch = ((EditRuleEdgeMatch) editRuleMatch).getSrcModelBElement();
				tgtMatch = ((EditRuleEdgeMatch) editRuleMatch).getTgtModelBElement();
			}
			
			if ((srcMatch != null) && (tgtMatch != null)) {
				change.matches = new EObject[2];
				change.matches[0] = srcMatch;
				change.matches[1] = tgtMatch;
			} else {
				
				if ((srcMatch != null) || (tgtMatch != null)) {
					change.matches = new EObject[1];
					
					if (srcMatch != null) {
						change.matches[0] = srcMatch;
					} 
					if (tgtMatch != null) {
						change.matches[0] = tgtMatch;
					}
				} else {
					change.matches = new EObject[0];
				}
			}
		}
		
		else if (editRuleMatch instanceof EditRuleNodeSingleMatch) {
			change.graphElement = ((EditRuleNodeMatch) editRuleMatch).getNode();
			
			change.nodes = new Node[1];
			change.nodes[0] = (Node) change.graphElement;
			
			change.matches = new EObject[1];
			
			if (((EditRuleNodeSingleMatch) editRuleMatch).getAction().equals(Type.DELETE)) {
				change.matches[0] = ((EditRuleNodeSingleMatch) editRuleMatch).getModelAElement();
			} else {
				assert ((EditRuleNodeSingleMatch) editRuleMatch).getAction().equals(Type.CREATE);
				
				change.matches[0] = ((EditRuleNodeSingleMatch) editRuleMatch).getModelBElement();
			}
		}
		
		return change;
	}
	
	private Change toComplemetingChange(GraphElement graphElement, ComplementMatch preMatch) {
		
		if (graphElement instanceof Edge) {
			return toComplementingChange((Edge) graphElement, preMatch);
		}
		
		else if (graphElement instanceof Node) {
			return toComplementingChange((Node) graphElement, preMatch);
		}
		
		return null;
	}
	
	private Change toComplementingChange(Edge edge, ComplementMatch preMatch) {
		Change change = new Change();
		change.graphElement = edge;
		
		// Get edge context:
		EObject contextMatchSrc = null;
		EObject contextMatchTgt = null;
		
		Node contextNodeSrc = edge.getSource();
		Node contextNodeTgt = edge.getTarget();

		if (contextNodeSrc.getGraph().isRhs()) {
			contextNodeSrc = HenshinRuleAnalysisUtilEx.getLHS(contextNodeSrc);
		}

		if (contextNodeTgt.getGraph().isRhs()) {
			contextNodeTgt = HenshinRuleAnalysisUtilEx.getLHS(contextNodeTgt);
		}

		// Get match:
		if (contextNodeSrc != null) {
			contextMatchSrc = preMatch.getMatch().getNodeTarget(contextNodeSrc);
		}
		
		if (contextNodeTgt != null) {
			contextMatchTgt = preMatch.getMatch().getNodeTarget(contextNodeTgt);
		}
		
		// Create change: [0] Source, [1] Target
		if ((contextMatchSrc != null) && (contextMatchTgt != null)) {
			change.nodes = new Node[2];
			change.matches = new EObject[2];
			
			change.nodes[0] = contextNodeSrc;
			change.nodes[1] = contextNodeTgt;
			
			change.matches[0] = contextMatchSrc;
			change.matches[1] = contextMatchTgt;
		}
		
		else if (contextMatchSrc != null) {
			change.nodes = new Node[1];
			change.matches = new EObject[1];
			
			change.nodes[0] = contextNodeSrc;
			change.matches[0] = contextMatchSrc;
		}
		
		else if (contextMatchTgt != null) {
			change.nodes = new Node[1];
			change.matches = new EObject[1];
			
			change.nodes[0] = contextNodeTgt;
			change.matches[0] = contextMatchTgt;
		}
		
		return change;
	}
	
	private Change toComplementingChange(Node node, ComplementMatch preMatch) {
		Change change = new Change();
		change.graphElement = node;
			
		List<Node> contextNodes = new ArrayList<>();
		List<EObject> contextMatches = new ArrayList<>(); 

		// Get node match:
		if (node.getGraph().isRhs()) {
			Node lhsNode = HenshinRuleAnalysisUtilEx.getLHS(node);
			EObject match = preMatch.getMatch().getNodeTarget(lhsNode);

			if (match != null) {
				contextNodes.add(lhsNode);
				contextMatches.add(match);
			}
		}

		// Get node context:
		for (Edge outgoing : node.getOutgoing()) {
			Node contextNode = outgoing.getTarget();

			if (contextNode.getGraph().isRhs()) {
				contextNode = HenshinRuleAnalysisUtilEx.getLHS(contextNode);
			}

			if (contextNode != null) {
				EObject contextMatch = preMatch.getMatch().getNodeTarget(contextNode);

				if (contextMatch != null) {
					contextNodes.add(contextNode);
					contextMatches.add(contextMatch);
				}
			}
		}

		for (Edge incoming : node.getIncoming()) {
			Node contextNode = incoming.getSource();

			if (contextNode.getGraph().isRhs()) {
				contextNode = HenshinRuleAnalysisUtilEx.getLHS(contextNode);
			}

			if (contextNode != null) {
				EObject contextMatch = preMatch.getMatch().getNodeTarget(contextNode);

				if ((contextMatch != null) && (!contextMatches.contains(contextMatch))) {
					contextNodes.add(contextNode);
					contextMatches.add(contextMatch);
				}
			}
		}

		change.nodes = contextNodes.toArray(new Node[0]);
		change.matches = contextMatches.toArray(new EObject[0]);
		
		return change;
	}

	@Override
	public Object getParent(Object element) {
		
		if (element instanceof Repair) {
			((Repair) element).getEditRule();
		}
		
		else if (element instanceof Container) {
			return ((Container) element).parent;
		}
		
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		
		// Repair-Rule:
		if (element instanceof Rule ||
				element instanceof Repair ||
				element instanceof Container ||
				element instanceof Change) {
			return true;
		}
		
		return false;
	}

	@Override
	public Object[] getElements(Object inputElement) {
		
		// Repair-Rules:
		if (inputElement instanceof Map<?, ?>) {
			return ((Map<?, ?>) inputElement).keySet().toArray();
		}
		
		return getChildren(inputElement);
	}
}

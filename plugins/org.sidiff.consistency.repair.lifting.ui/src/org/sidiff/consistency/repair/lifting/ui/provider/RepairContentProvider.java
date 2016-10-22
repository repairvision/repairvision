package org.sidiff.consistency.repair.lifting.ui.provider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx;
import org.sidiff.consistency.repair.complement.construction.match.ComplementMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleAttributeMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleEdgeMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleNodeMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleNodeSingleMatch;
import org.sidiff.consistency.repair.lifting.api.Repair;

public class RepairContentProvider implements IStructuredContentProvider, ITreeContentProvider  {

	protected Map<Rule, List<Repair>> repairs;
	
	// TODO: Add specific classes.
	public class Container {
		public String label;
		public Image icon;
		public Object parent;
		public Object[] content;
	}
	
	public class ContextContainer {
		public EObject conext;
		public List<Repair> repairs;
	}
	
	public class Change {
		public GraphElement graphElement;
		public Node[] nodes;
		public EObject[] matches;
	}
	
	public class AttributeChange extends Change {
		Object value;
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
			
			// Rule-Context -> Repairs:
			Map<EObject, List<Repair>> repairsByContext = new LinkedHashMap<>();
			
			for (Repair repair : repairs.get(parentElement)) {
				Parameter context = repair.getRepairPreMatch().getMatch().getRule().getParameter("context");
				Object value = repair.getRepairPreMatch().getMatch().getParameterValue(context);
				
				if (value instanceof EObject) {
					// Add repair to the context value:
					List<Repair> repairs  = repairsByContext.getOrDefault(value, new LinkedList<Repair>());
					repairs.add(repair);
					repairsByContext.put((EObject) value, repairs);
				} else {
					// Uncategorized repair without context:
					List<Repair> repairs  = repairsByContext.getOrDefault(null, new LinkedList<Repair>());
					repairs.add(repair);
					repairsByContext.put(null, repairs);
				}
			}
			
			// Rule content:
			List<Repair> repairsWithoutContext = repairsByContext.getOrDefault(null, Collections.emptyList());
			repairsByContext.remove(null);
			
			Object[] ruleContent = new Object[repairsByContext.size() + repairsWithoutContext.size()]; 
			
			for (int i = 0; i < repairsWithoutContext.size(); i++) {
				Repair repair = repairsWithoutContext.get(i);
				ruleContent[i + repairsByContext.size()] = repair;
			}
			
			// Create context containers:
			int i = 0;
			
			for (Entry<EObject, List<Repair>> contextEntry : repairsByContext.entrySet()) {
				ContextContainer contextContainer = new ContextContainer();
				contextContainer.conext = contextEntry.getKey();
				contextContainer.repairs = contextEntry.getValue();
				
				ruleContent[i] = contextContainer;
				++i;
			}
			
			return ruleContent;
		}
		
		else if (parentElement instanceof ContextContainer) {
			return ((ContextContainer) parentElement).repairs.toArray();
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
			
			if (change instanceof AttributeChange) {
				return new Object[] {((AttributeChange) change).matches[0] , ((AttributeChange) change).value};
			} else {
				return change.matches;
			}
		}
		
		return new Object[0];
	}
	
	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		
		// Repair-Rule:
		if (element instanceof Rule ||
				element instanceof Repair ||
				element instanceof Container ||
				element instanceof ContextContainer ||
				element instanceof AttributeChange) {
			return true;
		}
		
		// Single change:
		if (element instanceof Change) {
			if (((Change) element).matches != null) {
				return (((Change) element).matches.length > 0);
			}
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
		
		else if (editRuleMatch instanceof EditRuleAttributeMatch) {
			AttributeChange attChange = new AttributeChange();
			Attribute attr = ((EditRuleAttributeMatch) editRuleMatch).getAttribute();
			
			attChange.graphElement = attr;
			attChange.value = ((EditRuleAttributeMatch) editRuleMatch).getValue();
			attChange.matches = new EObject[] {((EditRuleAttributeMatch) editRuleMatch).getObject()};
			
			return attChange;
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
		
		else  if (graphElement instanceof Attribute) {
			return toComplementingChange((Attribute) graphElement, preMatch);
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
	
	private Change toComplementingChange(Attribute attribute, ComplementMatch preMatch) {
		AttributeChange change = new AttributeChange();
		change.graphElement = attribute;
		
		
		Parameter parameter = preMatch.getMatch().getRule().getParameter(attribute.getValue());
		change.matches = new EObject[] {preMatch.getMatch().getNodeTarget(
				HenshinRuleAnalysisUtilEx.getLHS(attribute.getNode()))};
		change.value = preMatch.getMatch().getParameterValue(parameter);
		
		return change;
	}
}

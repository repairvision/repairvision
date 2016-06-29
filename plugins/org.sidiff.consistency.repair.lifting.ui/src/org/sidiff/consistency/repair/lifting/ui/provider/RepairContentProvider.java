package org.sidiff.consistency.repair.lifting.ui.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx;
import org.sidiff.consistency.repair.lifting.api.Repair;

public class RepairContentProvider implements IStructuredContentProvider, ITreeContentProvider  {

	protected static EObject NULL = EcoreFactory.eINSTANCE.createEObject();
	
	protected Map<Rule, List<Repair>> repairs;
	
	protected class Container {
		String label;
		Image icon;
		Object parent;
		Object[] content;
	}
	
	protected class Change {
		GraphElement graphElement;
//		Node[] contextNodes;		// TODO: Do we need this?
		EObject[] contextMatch;
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
				GraphElement complement = repair.getTrace(historic);
				
				historicChanges.content[i] = toChange(complement, repair.getPreMatch());
			}
			
			// Complementing changes:
			int complementingSize = repair.getComplementingChanges().size();
			
			Container complementingChanges = new Container();
			complementingChanges.label = "Complementing [" + complementingSize + "]";
			complementingChanges.icon = RepairLabelProvider.IMG_QUESTION_MARK;
			
			complementingChanges.parent = parentElement;
			complementingChanges.content = new Object[complementingSize];
			
			for (int i = 0; i < complementingSize; i++) {
				complementingChanges.content[i] = toChange(
						repair.getComplementingChanges().get(i),
						repair.getPreMatch());
			}
			
			return new Object[] {historicChanges, complementingChanges};
		}
		
		else if (parentElement instanceof Container) {
			return ((Container) parentElement).content;
		}
		
		else if (parentElement instanceof Change) {
			return ((Change) parentElement).contextMatch;
		}
		
		return new Object[0];
	}
	
	private Change toChange(GraphElement graphElement, Map<Node, EObject> preMatch) {
		Change change = new Change();
		change.graphElement = graphElement;
		
		if (graphElement instanceof Edge) {
			
			// Get edge context: [0] Source, [1] Target
			change.contextMatch = new EObject[2];
//			change.contextNodes = new Node[2];
			
			Node srcNode = ((Edge) graphElement).getSource();
			Node tgtNode = ((Edge) graphElement).getTarget();
			
			if (srcNode.getGraph().isRhs()) {
				srcNode = HenshinRuleAnalysisUtilEx.getLHS(srcNode);
			}
			
			if (tgtNode.getGraph().isRhs()) {
				tgtNode = HenshinRuleAnalysisUtilEx.getLHS(tgtNode);
			}
			
			
			if (srcNode != null) {
				EObject srcMatch = preMatch.get(srcNode);
//				change.contextNodes[0] = srcNode;
				
				if (srcMatch != null) {
					change.contextMatch[0] = srcMatch;
				}
			} else {
				change.contextMatch[0] = NULL;
			}

			if (tgtNode != null) {
				EObject tgtMatch = preMatch.get(tgtNode);
//				change.contextNodes[1] = tgtNode;
				
				if (tgtMatch != null) {
					change.contextMatch[1] = tgtMatch;
				}
			} else {
				change.contextMatch[1] = NULL;
			}
		}
		
		else if (graphElement instanceof Node) {
			
//			List<Node> contextNodes = new ArrayList<>(); 
			List<EObject> contextMatches = new ArrayList<>(); 
			
			// Get node match:
			if (graphElement.getGraph().isRhs()) {
				Node lhsNode = HenshinRuleAnalysisUtilEx.getLHS((Node) graphElement);
				EObject match = preMatch.get(lhsNode);
				
				if (match != null) {
//					contextNodes.add(lhsNode);
					contextMatches.add(match);
				}
			}
			
			// Get node context:
			for (Edge outgoing : ((Node) graphElement).getOutgoing()) {
				Node contextNode = outgoing.getTarget();
				
				if (contextNode.getGraph().isRhs()) {
					contextNode = HenshinRuleAnalysisUtilEx.getLHS(contextNode);
				}
				
				if (contextNode != null) {
					EObject contextMatch = preMatch.get(contextNode);
					
					if (contextMatch != null) {
//						contextNodes.add(contextNode);
						contextMatches.add(contextMatch);
					}
				}
			}
			
			for (Edge incoming : ((Node) graphElement).getIncoming()) {
				Node contextNode = incoming.getSource();
				
				if (contextNode.getGraph().isRhs()) {
					contextNode = HenshinRuleAnalysisUtilEx.getLHS(contextNode);
				}
				
				if (contextNode != null) {
					EObject contextMatch = preMatch.get(contextNode);
					
					if ((contextMatch != null) && (!contextMatches.contains(contextMatch))) {
//						contextNodes.add(contextNode);
						contextMatches.add(contextMatch);
					}
				}
			}
			
//			change.contextNodes = contextNodes.toArray(new Node[0]);
			change.contextMatch = contextMatches.toArray(new EObject[0]);
		}
		
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

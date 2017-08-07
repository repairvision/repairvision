package org.sidiff.repair.ui.provider.model;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.repair.api.matching.EOAttributeMatch;
import org.sidiff.repair.api.matching.EOEdgeMatch;
import org.sidiff.repair.api.matching.EOMatch;
import org.sidiff.repair.api.matching.EONodeSingleMatch;

public class CreateHistoricChanges {

	public static Change create(GraphElement graphElement, EOMatch editRuleMatch) {
		Change change = new Change();
		change.graphElement = graphElement;
		
		if (editRuleMatch instanceof EOEdgeMatch) {
			Edge edge = (Edge) graphElement;
			
			change.nodes = new Node[2];
			change.nodes[0] = edge.getSource();
			change.nodes[1] = edge.getTarget();
			
			EObject srcMatch = null;
			EObject tgtMatch = null;
			
			if (((EOEdgeMatch) editRuleMatch).getAction().equals(Type.DELETE)) {
				srcMatch = ((EOEdgeMatch) editRuleMatch).getSrcModelAElement();
				tgtMatch = ((EOEdgeMatch) editRuleMatch).getTgtModelAElement();
			} else {
				assert ((EOEdgeMatch) editRuleMatch).getAction().equals(Type.CREATE);
				
				srcMatch = ((EOEdgeMatch) editRuleMatch).getSrcModelBElement();
				tgtMatch = ((EOEdgeMatch) editRuleMatch).getTgtModelBElement();
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
		
		else if (editRuleMatch instanceof EONodeSingleMatch) {
			change.nodes = new Node[1];
			change.nodes[0] = (Node) change.graphElement;
			
			change.matches = new EObject[1];
			
			if (((EONodeSingleMatch) editRuleMatch).getAction().equals(Type.DELETE)) {
				change.matches[0] = ((EONodeSingleMatch) editRuleMatch).getModelAElement();
			} else {
				assert ((EONodeSingleMatch) editRuleMatch).getAction().equals(Type.CREATE);
				
				change.matches[0] = ((EONodeSingleMatch) editRuleMatch).getModelBElement();
			}
		}
		
		else if (editRuleMatch instanceof EOAttributeMatch) {
			AttributeChange attChange = new AttributeChange();
			
			attChange.value = ((EOAttributeMatch) editRuleMatch).getValue();
			attChange.matches = new EObject[] {((EOAttributeMatch) editRuleMatch).getObject()};
			
			return attChange;
		}
		
		return change;
	}
}

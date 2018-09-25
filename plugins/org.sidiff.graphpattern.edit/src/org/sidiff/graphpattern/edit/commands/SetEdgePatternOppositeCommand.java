package org.sidiff.graphpattern.edit.commands;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphpatternPackage;

public class SetEdgePatternOppositeCommand extends CompoundCommand {
	
	public SetEdgePatternOppositeCommand(EditingDomain domain, EObject owner, Object value) {
		EReference feature = GraphpatternPackage.Literals.EDGE_PATTERN__OPPOSITE;
		EdgePattern edge = (EdgePattern) owner;
		
		if (value instanceof EdgePattern) {
			EdgePattern oppositeEdge = (EdgePattern) value;
			
			// Original opposite set command:
			append(new SetCommand(domain, edge, feature, oppositeEdge));
			
			// Opposite opposite set command:
			append(new SetCommand(domain, oppositeEdge, feature, edge));
		} else {
			// Original opposite set command:
			append(new SetCommand(domain, edge, feature, null));
						
			// Opposite opposite set command:
			if (edge.getOpposite() != null) {
				append(new SetCommand(domain, edge.getOpposite(), feature, null));
			}
		}
	}
}

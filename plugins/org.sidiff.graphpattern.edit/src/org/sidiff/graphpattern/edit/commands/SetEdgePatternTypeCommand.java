package org.sidiff.graphpattern.edit.commands;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphpatternPackage;

public class SetEdgePatternTypeCommand extends CompoundCommand {
	
	public SetEdgePatternTypeCommand(EditingDomain domain, EObject owner, Object value) {
		EReference feature = GraphpatternPackage.Literals.EDGE_PATTERN__TYPE;
		
		EdgePattern edge = (EdgePattern) owner;
		EReference type = (EReference) value;
		
		// Original type set command:
		append(new SetCommand(domain, edge, feature, type));
		
		// Set consistent opposite type:
		if (edge.getOpposite() != null) {
			if ((type != null) && (type.getEOpposite() != null)) {
				// Has opposite type:
				if (edge.getOpposite().getType() != type.getEOpposite()) {
					// Inconsistent opposite type -> set opposite type:
					// i.e.: edge.getOpposite().setType(value.getEOpposite());
					append(new SetCommand(domain, edge.getOpposite(), feature, type.getEOpposite()));
				}
			} else {
				// Has no opposite type:
				if (edge.getOpposite().getType() != type) {
					// i.e.: edge.getOpposite().setType(null);
					append(new SetCommand(domain, edge.getOpposite(), feature, null));
				}
			}
		}
	}
}

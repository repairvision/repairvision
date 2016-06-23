package org.sidiff.consistency.graphpattern.edit.commands;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.sidiff.consistency.graphpattern.EdgePattern;

public class SetEdgePatternCrossReferenceCommand extends CompoundCommand {
	
	public SetEdgePatternCrossReferenceCommand(EditingDomain domain, 
			EObject owner, EStructuralFeature feature, Object value) {
		
		EdgePattern edge = (EdgePattern) owner;
		Boolean isCrossReference = (Boolean) value;
		
		// Original cross-reference set command:
		append(new SetCommand(domain, edge, feature, isCrossReference));
		
		// Opposite cross-reference set command:
		append(new SetCommand(domain, edge.getOpposite(), feature, !isCrossReference));
	}
}

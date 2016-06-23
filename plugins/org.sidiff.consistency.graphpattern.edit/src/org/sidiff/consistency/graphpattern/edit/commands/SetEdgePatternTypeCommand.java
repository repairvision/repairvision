package org.sidiff.consistency.graphpattern.edit.commands;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.GraphpatternPackage;

public class SetEdgePatternTypeCommand extends CompoundCommand {
	
	public SetEdgePatternTypeCommand(EditingDomain domain, 
			EObject owner, EStructuralFeature feature, Object value) {
		
		EdgePattern edge = (EdgePattern) owner;
		EReference type = (EReference) value;
		
		// Original type set command:
		append(new SetCommand(domain, edge, feature, type));
		
		// Set consistent cross-reference flag:
		if (type.getEOpposite() != null) {
			if (edge.isCrossReference()) {
				//i.e. edge.setCrossReference(false);
				append(new SetCommand(domain, edge, 
						GraphpatternPackage.Literals.EDGE_PATTERN__CROSS_REFERENCE, false));
			}
		}
		
		// Set consistent opposite type:
		if (edge.getOpposite() != null) {
			if (type.getEOpposite() != null) {
				// Has opposite type:
				if (edge.getOpposite().getType() != type.getEOpposite()) {
					// Inconsistent opposite type -> set opposite type:
					// i.e.: edge.getOpposite().setType(value.getEOpposite());
					append(new SetCommand(domain, edge.getOpposite(), feature, type.getEOpposite()));
				}
				
				if (edge.getOpposite().isCrossReference()) {
					//i.e. edge.getOpposite().setCrossReference(false);
					append(new SetCommand(domain, edge.getOpposite(), 
							GraphpatternPackage.Literals.EDGE_PATTERN__CROSS_REFERENCE, false));
				}
			} else {
				// Has no opposite type -> non-navigable with cross-reference:
				if (edge.getOpposite().getType() != type) {
					// i.e.: edge.getOpposite().setType(value);
					append(new SetCommand(domain, edge.getOpposite(), feature, type));
				}
				
				if (edge.isCrossReference()) {
					// Cross-reference -> set non-navigable opposite:
					if (edge.getOpposite().isCrossReference()) {
						// i.e.: edge.getOpposite().setCrossReference(false);
						append(new SetCommand(domain, edge.getOpposite(), 
								GraphpatternPackage.Literals.EDGE_PATTERN__CROSS_REFERENCE, false));
					}
				} else {
					// Non-navigable reference -> set opposite as cross-reference:
					if (!edge.getOpposite().isCrossReference()) {
						// i.e.: edge.getOpposite().setCrossReference(true);
						append(new SetCommand(domain, edge.getOpposite(), 
								GraphpatternPackage.Literals.EDGE_PATTERN__CROSS_REFERENCE, true));
					}
				}
			}
		}
	}
}

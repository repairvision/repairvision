package org.sidiff.repair.validation.terms.functions;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.repair.validation.IScopeRecorder;
import org.sidiff.repair.validation.fix.Alternative;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.RepairAction;
import org.sidiff.repair.validation.fix.RepairAction.RepairType;
import org.sidiff.repair.validation.terms.Term;

public class GetContainer extends Function {

	protected Term element;
	
	public GetContainer(Term element) {
		this.name = "getContainer";
		this.element = element;
	}
	
	@Override
	public Object evaluate(IScopeRecorder scope) {
		element.evaluate(scope);
		
		if (element.getValue() != null) {
			value = ((EObject) element.getValue()).eContainer();
			scope.addElement(value);
		}
		
		return value;
	}

	@Override
	public void repair(IRepairDecision parent, RepairType type, IScopeRecorder scope) {
		Alternative alternative = Alternative.nextAlternative(parent);
		
		if (element.getValue() instanceof Collection<?>) {
			System.err.println("List results must be repaired by ForAll or Exists!");
		} else {
			if (element.getValue() != null) {
				RepairAction newRepair = new RepairAction(type, (EObject) value, ((EObject) element.getValue()).eContainmentFeature()); 
				alternative.appendChildDecisions(newRepair);
			}
		}
	}
}

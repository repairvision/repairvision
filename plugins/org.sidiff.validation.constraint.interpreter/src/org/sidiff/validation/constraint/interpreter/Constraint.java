package org.sidiff.validation.constraint.interpreter;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.revision.impact.changetree.IDecisionBranch;
import org.sidiff.revision.impact.changetree.Sequence;
import org.sidiff.revision.impact.changetree.change.ChangeActionFactory;
import org.sidiff.revision.impact.changetree.change.ChangeTree;
import org.sidiff.revision.impact.changetree.change.actions.ChangeAction.RepairType;
import org.sidiff.revision.impact.changetree.scope.IScopeRecorder;
import org.sidiff.revision.impact.changetree.scope.ScopeNode;
import org.sidiff.validation.constraint.interpreter.formulas.Formula;
import org.sidiff.validation.constraint.interpreter.terms.Variable;

public class Constraint extends NamedElement implements IConstraint {

	private EClass contextType;
	
	private Variable context;
	
	private Formula formula;
	
	private String message;
	
	public Constraint(EClass contextType, Variable context, Formula formula) {
		super();
		this.contextType = contextType;
		this.context = context;
		this.formula = formula;
	}
	
	@Override
	public boolean evaluate(EObject contextElement) {
		return evaluate(contextElement, IScopeRecorder.DUMMY);
	}
	
	@Override
	public boolean evaluate(EObject contextElement, IScopeRecorder scope) {
		this.context.assign(contextElement);
		return formula.evaluate(scope, true);
	}
	
	@Override
	public IDecisionBranch required() {
		formula.evaluate(IScopeRecorder.DUMMY, false);
		
		IDecisionBranch rootNode= new Sequence();
		ScopeNode.getScopeNode(rootNode).addElement(getContext());
		
		if (getResult() == true) {
			formula.required(rootNode, true);
		}
		
		return rootNode;
	}

	@Override
	public IDecisionBranch repair() {
		formula.evaluate(IScopeRecorder.DUMMY, false);
		ChangeTree changeTree = new ChangeTree();
		
		if (getResult() != true) {
			
			// Repair which deletes the root element:
			changeTree.appendChildDecisions(ChangeActionFactory.getInstance().create(
					RepairType.DELETE, 
					getContext().eContainmentFeature(),
					getContext().eClass(),
					getContext()));
			
			formula.repair(changeTree, true);
			return changeTree;
		}
		
		return changeTree;
	}
	
	@Override
	public boolean getResult() {
		return formula.getResult();
	}

	@Override
	public EClass getContextType() {
		return contextType;
	}

	@Override
	public void setContextType(EClass contextType) {
		this.contextType = contextType;
	}

	@Override
	public EObject getContext() {
		return (EObject) context.getValue();
	}

	@Override
	public void setContext(EObject contextElement) {
		this.context.assign(contextElement);
	}

	@Override
	public Formula getFormula() {
		return formula;
	}

	@Override
	public void setFormula(Formula formula) {
		this.formula = formula;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
	}
}

package org.sidiff.graphpattern.tools.editrules.csp;

import java.util.List;

import org.sidiff.csp.solver.IDomain;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Stereotype;
import org.sidiff.graphpattern.tools.csp.NodePatternVariable;

public class EditNodePatternVariable extends NodePatternVariable {

	public EditNodePatternVariable(NodePattern subject, IDomain<NodePattern> domain, boolean removable, boolean maximize, boolean induced) {
		super(subject, domain, removable, maximize, induced);
	}
	
	@Override
	protected boolean checkStereotypes(List<Stereotype> subject, List<Stereotype> assignment) {
		Stereotype subjectStereotype = subject.get(0);
		Stereotype assignmentStereotype = assignment.get(0);
		
		return EditRulePatternUtil.checkStereotypeCompatibility(subjectStereotype, assignmentStereotype);
	}
}

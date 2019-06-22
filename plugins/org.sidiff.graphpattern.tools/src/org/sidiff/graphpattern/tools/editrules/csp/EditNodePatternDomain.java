package org.sidiff.graphpattern.tools.editrules.csp;

import java.util.List;

import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Stereotype;
import org.sidiff.graphpattern.tools.csp.NodePatternDomain;

public class EditNodePatternDomain extends NodePatternDomain {

	public EditNodePatternDomain(NodePattern subject, List<NodePattern> candidates, boolean maximumSolution, boolean exactSolution) {
		super(subject, candidates, maximumSolution, exactSolution);
	}
	
	@Override
	protected boolean checkStereotypes(NodePattern subject, NodePattern value) {
		Stereotype subjectStereotype = subject.getStereotypes().get(0);
		Stereotype assignmentStereotype = value.getStereotypes().get(0);
		
		return EditRulePatternUtil.checkStereotypeCompatibility(subjectStereotype, assignmentStereotype);
	}
}

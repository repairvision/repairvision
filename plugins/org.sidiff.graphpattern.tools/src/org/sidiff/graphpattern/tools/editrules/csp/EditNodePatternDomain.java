package org.sidiff.graphpattern.tools.editrules.csp;

import java.util.List;
import java.util.function.Function;

import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Stereotype;
import org.sidiff.graphpattern.tools.csp.NodePatternDomain;

public class EditNodePatternDomain extends NodePatternDomain {

	public EditNodePatternDomain(
			NodePattern subject, List<NodePattern> candidates,
			EdgeMatching incomingMatching, EdgeMatching outgoingMatching, Function<EdgePattern, Boolean> edgeFilter) {
		super(subject, candidates, incomingMatching, outgoingMatching, edgeFilter);
	}
	
	public EditNodePatternDomain(
			NodePattern subject, List<NodePattern> candidates,
			EdgeMatching incomingMatching, EdgeMatching outgoingMatching) {
		this(subject, candidates, incomingMatching, outgoingMatching, null);
	}
	
	@Override
	protected boolean checkStereotypes(NodePattern subject, NodePattern value) {
		Stereotype subjectStereotype = subject.getStereotypes().get(0);
		Stereotype assignmentStereotype = value.getStereotypes().get(0);
		
		return EditRulePatternUtil.checkStereotypeCompatibility(subjectStereotype, assignmentStereotype);
	}
}

package org.sidiff.graphpattern.tools.editrules.csp;

import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.*;

import java.util.List;

import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Stereotype;
import org.sidiff.graphpattern.tools.csp.NodePatternDomain;

public class EditNodePatternDomain extends NodePatternDomain {

	public EditNodePatternDomain(NodePattern subject, List<NodePattern> candidates, boolean maximumSolution, boolean exactSolution) {
		super(subject, candidates, maximumSolution, exactSolution);
	}

	@Override
	protected boolean checkType(NodePattern subject, NodePattern value) {
		
		// Check for equal types and stereotypes:
		Stereotype subjectStereotype = subject.getStereotypes().get(0);
		Stereotype valueStereotype = value.getStereotypes().get(0);
		
		 boolean stereotypeCompatibility = 
				 		(subjectStereotype.equals(preserve) && valueStereotype.equals(create))
				 	||	(subjectStereotype.equals(preserve) && valueStereotype.equals(delete))
				 	||	(subjectStereotype.equals(preserve) && valueStereotype.equals(preserve))
				 	||	(subjectStereotype.equals(delete) && valueStereotype.equals(delete))
				 	||	(subjectStereotype.equals(create) && valueStereotype.equals(create));
		
		return super.checkType(subject, value) && stereotypeCompatibility;
	}
}

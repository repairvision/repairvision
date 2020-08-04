package org.sidiff.revision.editrules.complement.matching.impact;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.revision.editrules.impact.util.GraphMatching;

public class ComplementMatching implements GraphMatching {

	private Match complementMatch;
	
	public ComplementMatching(Match complementMatch) {
		this.complementMatch = complementMatch;
	}

	@Override
	public EObject getMatch(Node node) {
		return complementMatch.getNodeTarget(node);
	}

}

package org.sidiff.revision.editrules.recognition.pattern.domain;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.graphpattern.NodePattern;

public class Restriction {

	private NodePattern source;
	private Collection<EObject> restrictions;
	
	public Restriction(NodePattern source, Collection<EObject> restrictions) {
		super();
		this.source = source;
		this.restrictions = restrictions;
	}

	public NodePattern getSource() {
		return source;
	}

	public void setSource(NodePattern source) {
		this.source = source;
	}

	public Collection<EObject> getRestrictions() {
		return restrictions;
	}

	public void setRestrictions(Collection<EObject> restrictions) {
		this.restrictions = restrictions;
	}
}

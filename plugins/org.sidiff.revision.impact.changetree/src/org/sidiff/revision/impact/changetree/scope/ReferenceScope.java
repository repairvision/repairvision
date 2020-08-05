package org.sidiff.revision.impact.changetree.scope;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EReferenceImpl;

public class ReferenceScope {

	public static EReference ECONTAINER = new EReferenceImpl() {};
	
	private EObject source;
	
	private EObject target;
	
	private EReference type;
	
	public ReferenceScope(EObject source, EObject target, EReference type) {
		super();
		this.source = source;
		this.target = target;
		this.type = type;
	}
	
	public EObject getSource() {
		return source;
	}
	
	public void setSource(EObject source) {
		this.source = source;
	}
	
	public EObject getTarget() {
		return target;
	}
	
	public void setTarget(EObject target) {
		this.target = target;
	}
	
	public EReference getType() {
		return type;
	}
	
	public void setType(EReference type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return super.toString() + " (" + "source: " + source + " target: " + target + " type: " + type + ")";
	}
}

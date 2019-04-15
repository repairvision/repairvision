package org.sidiff.common.emf.access;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * Helper class which encapsulates an instance of an EReference (called link) as a value object.
 * 
 * An instance of an EReference is given by src-EObject, tgt-EObject and the type (i.e. EReference) of the link.
 * In other words: Just like an EObject is instanceOf an EClassifier, a link is instanceOf an EReference.
 * 
 * Please note that there is no global storage for links in an EMF model. That is, links must be treated as value 
 * objects, they do not have an identity. Comparing two links should thus be done using equals(). 
 * In other words, the "== operator" may not deliver the same result as equals()!! 
 * 
 * Use with caution!
 * 
 * @author kehrer
 */
public class Link {

	private EObject src;
	private EObject tgt;
	private EReference type;

	public Link(EObject src, EObject tgt, EReference type) {
		super();
		
		assert (src != null && tgt != null && type != null) : "Either src, tgt or type is null!";
		// FIXME (cpietsch: 02.09.2014) getNodeNeighbors doesn't work with symbolic links
		// (see also org.sidiff.difference.lifting.recognitionengine.matching.BasicEditRuleMatch)
		//assert (EMFModelAccess.getNodeNeighbors(src, type).contains(tgt)) : "src doesn't reference tgt!";
		
		this.src = src;
		this.tgt = tgt;
		this.type = type;
	}

	public EObject getSrc() {
		return src;
	}

	public EObject getTgt() {
		return tgt;
	}

	public EReference getType() {
		return type;
	}

	@Override
	public int hashCode() {
		String str = src.toString() + tgt.toString() + type.toString();		
		return str.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Link) {
			Link other = (Link) obj;
			return src.equals(other.src) && tgt.equals(other.tgt) && type.equals(other.type);
		}

		return false;
	}

	@Override
	public String toString() {
		String res = super.toString();
		res += ": " + src.toString() + " -> " + tgt.toString() + " (" + type.getName() + ")";
		return res;
	}

}

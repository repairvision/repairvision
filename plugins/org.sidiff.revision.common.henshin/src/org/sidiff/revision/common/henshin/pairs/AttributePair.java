package org.sidiff.revision.common.henshin.pairs;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.henshin.model.Attribute;

/**
 * Contains a LHS and its corresponding RHS Henshin attribute.
 */
public class AttributePair {

	/**
	 * The LHS attribute of the attribute pair.
	 */
	private Attribute lhsAttribute;
	
	/**
	 * The RHS attribute of the attribute pair.
	 */
	private Attribute rhsAttribute;

	/**
	 * Constructs a new empty attribute pair.
	 */
	public AttributePair() {
		super();
	}
	
	/**
	 * Constructs a new attribute pair.
	 * 
	 * @param lhsAttribute
	 *            the LHS attribute.
	 * @param rhsAttribute
	 *            the RHS attribute.
	 */
	public AttributePair(Attribute lhsAttribute, Attribute rhsAttribute) {
		super();
		this.lhsAttribute = lhsAttribute;
		this.rhsAttribute = rhsAttribute;
	}
	
	/**
	 * @param attribute
	 *            The attribute to test.
	 * @return <code>true</code> if the attribute is the LHS or RHS attribute of the attribute pair; 
	 *         <code>false</code> otherwise.
	 */
	public boolean contains(Attribute attribute) {
		return ((lhsAttribute != null) && lhsAttribute.equals(attribute)) 
				|| ((rhsAttribute != null) && rhsAttribute.equals(attribute));
	}

	/**
	 * @return the LHS attribute.
	 */
	public Attribute getLhsAttribute() {
		return lhsAttribute;
	}

	/**
	 * @param lhsAttribute
	 *            the new LHS attribute.
	 */
	public void setLhsAttribute(Attribute lhsAttribute) {
		this.lhsAttribute = lhsAttribute;
	}

	/**
	 * @return the LHS attribute.
	 */
	public Attribute getRhsAttribute() {
		return rhsAttribute;
	}

	/**
	 * @param rhsAttribute
	 *            the new RHS attribute.
	 */
	public void setRhsAttribute(Attribute rhsAttribute) {
		this.rhsAttribute = rhsAttribute;
	}
	
	/**
	 * @return the attribute type.
	 */
	public EAttribute getType() {
		
		if (rhsAttribute != null) {
			return rhsAttribute.getType();
		} else if (lhsAttribute != null) {
			return lhsAttribute.getType();
		}

		return null;
	}
	
	/**
	 * @param attributePairs
	 *            A collection of attribute pairs.
	 * @param attributes
	 *            Collection (preferably a set) containing attributes to be removed from the given collection.
	 */
	public static void removeAll(Collection<AttributePair> attributePairs, Collection<Attribute> attributes) {
		
		for (Iterator<AttributePair> iterator = attributePairs.iterator(); iterator.hasNext();) {
			AttributePair attributePair = (AttributePair) iterator.next();
			
			 if ((attributePair.getLhsAttribute() != null) && attributes.contains(attributePair.getLhsAttribute())) {
				 iterator.remove();
			 }
			 
			 else if ((attributePair.getRhsAttribute() != null) && attributes.contains(attributePair.getRhsAttribute())) {
				 iterator.remove();
			 }
		}
	}
}

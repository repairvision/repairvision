package org.sidiff.common.emf.access;


import org.eclipse.emf.ecore.EReference;

/**
 * Defines the semantics of a reference in the meta model.
 * 
 * @see Datamodel-Howto
 * 
 * @author wenzel
 * TODO kann eigentlich komplett raus (denn spezielle rueckwaerts-referenzen muessen wir seit der
 * ermoeglichten rueckwaerst-navigation nicht mehr in die metamodelle einbauen. andere ungenutzte semantiken habe ich schon entfernt, SW)
 */
public enum EdgeSemantic {
	Incoming(0), // Referenzen, die im Metamodel als INCOMING markiert sind
	Outgoing(1); // Referenzen, die im Metamodel nicht als incoming markiert sind (Standardfall)

	private int mode;

	/**
	 * @param mode Tells how the semantic is checked. 0 = semantic is defined by equally named EAnnotation 
	 */
	private EdgeSemantic(int mode) {
		this.mode = mode;
	}

	public boolean checkSemantic(EReference reference) {
		switch (this.mode) {
		case 0:
			return reference.getEAnnotation(this.name().toUpperCase()) != null;
		case 1:
			return !(reference.isContainment() || reference.isContainer()) && reference.getEAnnotation("INCOMING") == null;
		default:
			throw new IllegalArgumentException(this.mode + "?");
		}
	}
}

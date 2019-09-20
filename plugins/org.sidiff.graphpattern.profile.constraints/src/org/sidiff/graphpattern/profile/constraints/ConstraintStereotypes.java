package org.sidiff.graphpattern.profile.constraints;

import org.sidiff.graphpattern.Profile;
import org.sidiff.graphpattern.Stereotype;
import org.sidiff.graphpattern.profile.constraints.ConstraintGraphPatternProfile.STEREOTYPE;
import org.sidiff.graphpattern.profile.extensions.GraphPatternProfileLibrary;

public class ConstraintStereotypes {

	public static Profile instance = GraphPatternProfileLibrary.getEntry("org.sidiff.graphpattern.profile.constraints").getProfile().getProfile();
	
	public static Stereotype constraint = instance.getStereotype(STEREOTYPE.constraint.name());
	
	public static Stereotype not = instance.getStereotype(STEREOTYPE.not.name());
	
	public static Stereotype exists = instance.getStereotype(STEREOTYPE.exists.name());
	
	public static Stereotype forall = instance.getStereotype(STEREOTYPE.forall.name());
}

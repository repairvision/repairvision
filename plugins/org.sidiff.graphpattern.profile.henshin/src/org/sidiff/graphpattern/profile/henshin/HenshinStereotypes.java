package org.sidiff.graphpattern.profile.henshin;

import org.sidiff.graphpattern.Profile;
import org.sidiff.graphpattern.Stereotype;
import org.sidiff.graphpattern.profile.extensions.GraphPatternProfileLibrary;
import org.sidiff.graphpattern.profile.henshin.HenshinGraphPatternProfile.STEREOTYPE;

public class HenshinStereotypes {

	public static Profile profile_model = GraphPatternProfileLibrary.getEntry("org.sidiff.graphpattern.profile.henshin").getProfile().getProfile();
	
	public static Stereotype rule = profile_model.getStereotype(STEREOTYPE.rule.name());
	
	public static Stereotype preserve = profile_model.getStereotype(STEREOTYPE.preserve.name());
	
	public static Stereotype create = profile_model.getStereotype(STEREOTYPE.create.name());
	
	public static Stereotype delete = profile_model.getStereotype(STEREOTYPE.delete.name());
	
	public static Stereotype forbid = profile_model.getStereotype(STEREOTYPE.forbid.name());
	
	public static Stereotype require = profile_model.getStereotype(STEREOTYPE.require.name());
	
	public static Stereotype pre = profile_model.getStereotype(STEREOTYPE.pre.name());
	
	public static Stereotype post = profile_model.getStereotype(STEREOTYPE.post.name());
}

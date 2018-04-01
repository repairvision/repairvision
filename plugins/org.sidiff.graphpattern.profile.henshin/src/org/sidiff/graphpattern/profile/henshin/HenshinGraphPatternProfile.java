package org.sidiff.graphpattern.profile.henshin;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.Profile;
import org.sidiff.graphpattern.Stereotype;
import org.sidiff.graphpattern.profile.IGraphPatternProfile;
import org.sidiff.graphpattern.profile.IGraphPatternVisualization;

public class HenshinGraphPatternProfile implements IGraphPatternProfile {
	
	protected static final String ID = "org.sidiff.graphpattern.profile.henshin.profile";
	
	protected static final Profile PROFILE = createProfile("Henshin", "Henshin Graph Actions");
	
	protected static final Stereotype CREATE = createStereotype("create");
	
	protected static final Stereotype DELETE = createStereotype("delete"); 
	
	protected static final Stereotype PRESERVE = createStereotype("preserve"); 
	
	protected static final Stereotype FORBID = createStereotype("forbid"); 
	
	protected static final Stereotype REQUIRE = createStereotype("require"); 

	@Override
	public Profile getProfile() {
		return PROFILE;
	}

	@Override
	public IGraphPatternVisualization getVisualization() {
		return new HenshinGraphPatternVisualization();
	}
	
	protected static Profile createProfile(String name, String decription) {
		Profile profile = GraphpatternFactory.eINSTANCE.createProfile();
		profile.setName(name);
		profile.setDescription(decription);
		
		profile.setId(ID);
		
		return profile;
	}
	
	protected static Stereotype createStereotype(String name) {
		Stereotype stereotype = GraphpatternFactory.eINSTANCE.createStereotype();
		stereotype.setName(name);
		
		PROFILE.getStereotypes().add(stereotype);
		
		return stereotype;
	}
}

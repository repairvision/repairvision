package org.sidiff.graphpattern.profile.henshin;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.Profile;
import org.sidiff.graphpattern.Stereotype;
import org.sidiff.graphpattern.profile.GraphPatternProfileFactory;
import org.sidiff.graphpattern.profile.IGraphPatternProfile;
import org.sidiff.graphpattern.profile.IGraphPatternVisualization;
import org.sidiff.graphpattern.util.GraphpatternResourceImpl;

public class HenshinGraphPatternProfile implements IGraphPatternProfile {
	
	protected static enum STEREOTYPE {
		rule, create, delete, preserve, forbid, require, pre, post
	};
	
	protected static final String PULGIN = "org.sidiff.graphpattern.profile.henshin";
	
	protected static final String PROFILE_PATH = "model/profile.graphpattern";
	
	protected static final String PROFILE_ID = "org.sidiff.graphpattern.profile.henshin";
	
	protected static final String PROFILE_NAME = "Henshin Action Profile";
	
	protected static final String PROFILE_DESCRIPTION = "e.g. create, delete, forbid";
	
	protected Profile profile;
	
	protected IGraphPatternVisualization visualization;
	
	@Override
	public Profile getProfile() {
		if (profile == null) {
			profile = GraphPatternProfileFactory.loadProfile(PULGIN, PROFILE_PATH);
		}
		return profile;
	}

	@Override
	public IGraphPatternVisualization getVisualization() {
		if (visualization == null) {
			this.visualization = new HenshinGraphPatternVisualization();
		}
		
		return visualization;
	}
	
	/*
	 * Profile Generator:
	 */
	
	public static void main(String[] args) {
		
		// create profile:
		Profile profile = createProfile(PROFILE_ID, PROFILE_NAME, PROFILE_DESCRIPTION);
		
		for (STEREOTYPE stereotype : STEREOTYPE.values()) {
			createStereotype(profile, stereotype.toString());
		}
		
		// save profile:
		try {
			Resource profileResource = new GraphpatternResourceImpl(URI.createFileURI(PROFILE_PATH));
			profileResource.getContents().add(profile);
			profileResource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected static Profile createProfile(String id, String name, String decription) {
		Profile profile = GraphpatternFactory.eINSTANCE.createProfile();
		profile.setName(name);
		profile.setId(id);
		profile.setDescription(decription);
		
		return profile;
	}
	
	protected static Stereotype createStereotype(Profile profile, String name) {
		Stereotype stereotype = GraphpatternFactory.eINSTANCE.createStereotype();
		stereotype.setName(name);
		profile.getStereotypes().add(stereotype);
		
		return stereotype;
	}
}

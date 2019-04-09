package org.sidiff.graphpattern.profile;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.sidiff.graphpattern.Profile;
import org.sidiff.graphpattern.Stereotype;
import org.sidiff.graphpattern.profile.extensions.GraphPatternProfileEntry;
import org.sidiff.graphpattern.profile.extensions.GraphPatternProfileLibrary;
import org.sidiff.graphpattern.util.GraphpatternResourceImpl;

public class GraphPatternProfileFactory implements Factory {

	public static final String PROTOCOL_NAME = "graphpatternprofile";
	
	@Override
	public Resource createResource(URI uri) {
		GraphPatternProfileEntry profileEntry = GraphPatternProfileLibrary.getEntry(uri.segment(0));
		
		if (profileEntry != null) {
			return profileEntry.getProfile().getProfile().eResource();
		}
		
		return null;
	}
	
	public static URI createURI(Profile profile) {
		return URI.createURI(PROTOCOL_NAME + ":/" + profile.getId());
	}
	
	public static Profile loadProfile(String plugin, String pluginPath) {
		try {
			
			// profile resource:
			URI profileURI = URI.createPlatformPluginURI(plugin + "/" + pluginPath, true);
			
			GraphpatternResourceImpl profileResource = new GraphpatternResourceImpl(profileURI) {
				
				// read only!
				public void save(java.util.Map<?,?> options) throws java.io.IOException {
				};
				
				// map stereotypes to its names:
				// map profile to content position:
				private String profilePrefix = "@profile";
				
				@Override
				public String getURIFragment(EObject eObject) {
				
					// use stereotype name as URI fragment:
					if (eObject instanceof Stereotype) {
						return ((Stereotype) eObject).getName();
					}
					
					// use profile content position as URI fragment:
					if (eObject instanceof Profile) {
						return profilePrefix + getContents().indexOf(eObject);
					}
					
					return super.getURIFragment(eObject);
				}
				
				@Override
				public EObject getEObject(String uriFragment) {
					
					// resolve profile by position:
					if (uriFragment.startsWith(profilePrefix)) {
						int index = Integer.valueOf(uriFragment.substring(profilePrefix.length(), uriFragment.length()));
						return getContents().get(index);
					}
					
					// try to resolve stereotype by name:
					if (!getContents().isEmpty()) {
						Profile profile = (Profile) getContents().get(0);
						Stereotype stereotype = profile.getStereotype(uriFragment);
						
						if (stereotype != null) {
							return stereotype;
						}
					}
					
					return super.getEObject(uriFragment);
				}
			};
			
			// load profile:
			profileResource.load(Collections.emptyMap());
			Profile profile = (Profile) profileResource.getContents().get(0);
			
			// set profile URI protocol:
			profileResource.setURI(createURI(profile));
			
			return profile;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}

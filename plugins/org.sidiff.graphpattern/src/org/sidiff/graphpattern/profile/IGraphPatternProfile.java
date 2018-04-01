package org.sidiff.graphpattern.profile;

import org.sidiff.graphpattern.Profile;

public interface IGraphPatternProfile {

	/**
	 * @return The profile which specifies the stereotypes.
	 */
	Profile getProfile();
	
	/**
	 * @return The visualization for this profile.
	 */
	IGraphPatternVisualization getVisualization();
}

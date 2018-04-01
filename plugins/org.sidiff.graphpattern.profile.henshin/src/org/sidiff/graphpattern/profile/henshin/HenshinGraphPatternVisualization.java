package org.sidiff.graphpattern.profile.henshin;

import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Stereotype;
import org.sidiff.graphpattern.profile.IGraphPatternVisualization;

public class HenshinGraphPatternVisualization implements IGraphPatternVisualization {

	@Override
	public int[] getBackgroundColor(NodePattern node) {
		
		if (!node.getStereotypes().isEmpty()) {
			Stereotype stereotype = node.getStereotypes().get(0);
			
			if (HenshinGraphPatternProfile.CREATE == stereotype) {
				return new int[] {221, 255, 221};
			}
			
			else if (HenshinGraphPatternProfile.DELETE == stereotype) {
				return new int[] {255, 221, 221};
			}
			
			if (HenshinGraphPatternProfile.PRESERVE == stereotype) {
				return new int[] {238, 238, 238};
			}
			
			if (HenshinGraphPatternProfile.FORBID == stereotype) {
				return new int[] {221, 221, 255};
			}
			
			if (HenshinGraphPatternProfile.REQUIRE == stereotype) {
				return new int[] {255, 238, 221};
			}
		}
		
		return new int[] {0, 0, 0};
	}
}

package org.sidiff.graphpattern.profile.henshin;

import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Stereotype;
import org.sidiff.graphpattern.profile.IGraphPatternVisualization;
import org.sidiff.graphpattern.profile.henshin.HenshinGraphPatternProfile.STEREOTYPE;

public class HenshinGraphPatternVisualization implements IGraphPatternVisualization {

	@Override
	public int[] getBackgroundColor(NodePattern node) {
		
		if (!node.getStereotypes().isEmpty()) {
			Stereotype stereotype = node.getStereotypes().get(0);
			
			switch (STEREOTYPE.valueOf(stereotype.getName())) {
			case create:
				return new int[] {221, 255, 221};
			
			case delete:
				return new int[] {255, 221, 221};
				
			case preserve:
				return new int[] {238, 238, 238};
				
			case require:
				return new int[] {221, 221, 255};
				
			case forbid:
				return new int[] {255, 238, 221};
			}
		}
		return new int[] {0, 0, 0};
	}
}

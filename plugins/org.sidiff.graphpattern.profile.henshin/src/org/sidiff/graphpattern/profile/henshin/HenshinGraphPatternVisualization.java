package org.sidiff.graphpattern.profile.henshin;

import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Stereotype;
import org.sidiff.graphpattern.profile.IGraphPatternVisualization;
import org.sidiff.graphpattern.profile.henshin.HenshinGraphPatternProfile.STEREOTYPE;

public class HenshinGraphPatternVisualization implements IGraphPatternVisualization {

	protected int[] GREEN_FOREGROUND = {0, 200, 0};
	
	protected int[] GREEN_BACKGROUND = {221, 255, 221};
	
	protected int[] RED_FOREGROUND = {255, 0, 0};
	
	protected int[] RED_BACKGROUND = {255, 221, 221};
	
	protected int[] GRAY_FOREGROUND = {128, 128, 128};
	
	protected int[] GRAY_BACKGROUND = {238, 238, 238};
	
	protected int[] ORANGE_FOREGROUND = {170, 68, 0};
	
	protected int[] ORANGE_BACKGROUND = {255, 238, 221};
	
	protected int[] BLUE_FOREGROUND = {0, 0, 255};
	
	protected int[] BLUE_BACKGROUND = {221, 221, 255};
	
	@Override
	public int[] getNodeBackgroundColor(NodePattern node, Gradient gradient) {
		
		if (!node.getStereotypes().isEmpty()) {
			Stereotype stereotype = node.getStereotypes().get(0);
			
			if (gradient.equals(Gradient.TO) && (node.getStereotypes().size() > 1)) {
				stereotype = node.getStereotypes().get(1);
			}
			
			switch (STEREOTYPE.valueOf(stereotype.getName())) {
			case create:
				return GREEN_BACKGROUND;
			
			case delete:
				return RED_BACKGROUND;
				
			case preserve:
				return GRAY_BACKGROUND;
				
			case require:
				return ORANGE_BACKGROUND;
				
			case forbid:
				return BLUE_BACKGROUND;
			}
		}
		
		return new int[] {255, 255, 255};
	}

	@Override
	public int[] getNodeFrameColor(NodePattern node) {
		
		if (!node.getStereotypes().isEmpty()) {
			Stereotype stereotype = node.getStereotypes().get(0);
			
			switch (STEREOTYPE.valueOf(stereotype.getName())) {
			case create:
				return GREEN_FOREGROUND;
			
			case delete:
				return RED_FOREGROUND;
				
			case preserve:
				return GRAY_FOREGROUND;
				
			case require:
				return ORANGE_FOREGROUND;
				
			case forbid:
				return BLUE_FOREGROUND;
			}
		}
		
		return new int[] {0, 0, 0};
	}

	@Override
	public int[] getNodeLabelColor(NodePattern node) {
		
		if (!node.getStereotypes().isEmpty()) {
			Stereotype stereotype = node.getStereotypes().get(0);
			
			switch (STEREOTYPE.valueOf(stereotype.getName())) {
			case create:
				return GREEN_FOREGROUND;
			
			case delete:
				return RED_FOREGROUND;
				
			case preserve:
				return GRAY_FOREGROUND;
				
			case require:
				return ORANGE_FOREGROUND;
				
			case forbid:
				return BLUE_FOREGROUND;
			}
		}
		
		return new int[] {0, 0, 0};
	}

	@Override
	public int[] getEdgeLineColor(EdgePattern edge) {
		
		if (!edge.getStereotypes().isEmpty()) {
			Stereotype stereotype = edge.getStereotypes().get(0);
			
			switch (STEREOTYPE.valueOf(stereotype.getName())) {
			case create:
				return GREEN_FOREGROUND;
			
			case delete:
				return RED_FOREGROUND;
				
			case preserve:
				return GRAY_FOREGROUND;
				
			case require:
				return ORANGE_FOREGROUND;
				
			case forbid:
				return BLUE_FOREGROUND;
			}
		}
		
		return new int[] {0, 0, 0};
	}

	@Override
	public int[] getEdgeLabelColor(EdgePattern edge) {
		
		if (!edge.getStereotypes().isEmpty()) {
			Stereotype stereotype = edge.getStereotypes().get(0);
			
			switch (STEREOTYPE.valueOf(stereotype.getName())) {
			case create:
				return GREEN_FOREGROUND;
			
			case delete:
				return RED_FOREGROUND;
				
			case preserve:
				return GRAY_FOREGROUND;
				
			case require:
				return ORANGE_FOREGROUND;
				
			case forbid:
				return BLUE_FOREGROUND;
			}
		}
		
		return new int[] {0, 0, 0};
	}
}

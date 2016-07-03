package org.sidiff.consistency.graphpattern.matcher.wgraph.partial;

import org.eclipse.emf.ecore.EReference;
import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.impl.EdgePatternImpl;

/**
 * This implementation of {@link EdgePattern} is not synchronized (opposites /
 * container) with the model. This allows us to create edges during edge list
 * (outgoing / incoming) iterations, without altering those lists.
 * 
 * @author Manuel Ohrndorf
 */
public class PlaceholderEdgePattern extends EdgePatternImpl  {
	
	protected NodePattern source;
	
	public PlaceholderEdgePattern(
			EReference type, NodePattern source, NodePattern target, 
			EdgePattern opposite, boolean isCrossReference) {
		
		this.type = type;
		this.source = source;
		this.target = target;
		this.opposite = opposite;
		this.crossReference = isCrossReference;
	}
	
	@Override
	public EReference getType() {
		return type;
	}
	
	@Override
	public void setType(EReference newType) {
		this.type = newType;
	}

	@Override
	public NodePattern getSource() {
		return source;
	}
	
	@Override
	public void setSource(NodePattern newSource) {
		this.source = newSource;
	}
	
	@Override
	public NodePattern getTarget() {
		return target;
	}
	
	@Override
	public void setTarget(NodePattern newTarget) {
		this.target = newTarget;
	}
	
	@Override
	public EdgePattern getOpposite() {
		return opposite;
	}
	
	@Override
	public void setOpposite(EdgePattern newOpposite) {
		this.opposite = newOpposite;
	}
	
	@Override
	public boolean isCrossReference() {
		return crossReference;
	}
	
	@Override
	public void setCrossReference(boolean newCrossReference) {
		this.crossReference = newCrossReference;
	}
}

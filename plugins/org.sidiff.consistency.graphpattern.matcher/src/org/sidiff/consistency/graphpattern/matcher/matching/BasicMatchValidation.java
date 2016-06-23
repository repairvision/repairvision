package org.sidiff.consistency.graphpattern.matcher.matching;

import java.util.Map;

import org.sidiff.consistency.graphpattern.NodePattern;

public class BasicMatchValidation implements IMatchValidation {

	@Override
	public boolean isMatch(Map<NodePattern, NodeMatching> matching) {
		
//		// Variable -> Value:
//		Map<String, Object> variables = new HashMap<>();
//		
//		for (Entry<NodePattern, NodeMatching> match : matching.entrySet()) {
//			for (AttributePattern attribute : match.getKey().getAttributes()) {
//				
//				// TODO: Check the variables based on the parameters!
//				if (!attribute.getValue().startsWith("\"")) {
//					Object remoteValue = variables.get(attribute.getValue());
//					Object localValue = match.getValue().getMatch().eGet(attribute.getType());
//					
//					if (remoteValue != null) {
//						if (!localValue.equals(remoteValue)) {
//							return false;
//						}
//					} else {
//						variables.put(attribute.getValue(), localValue);
//					}
//				}
//			}
//		}
		
		return true;
	}

	@Override
	public boolean isPotentialMatch(NodeMatching newNodeMatching, Map<NodePattern, NodeMatching> matching) {
		return true;
	}
}

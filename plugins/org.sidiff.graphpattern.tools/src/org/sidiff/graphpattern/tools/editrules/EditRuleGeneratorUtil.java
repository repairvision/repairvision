package org.sidiff.graphpattern.tools.editrules;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.sidiff.csp.solver.impl.domain.DomainImpl;
import org.sidiff.graphpattern.NodePattern;

public class EditRuleGeneratorUtil {
	
	public static boolean isTypeEqual(List<NodePattern> nodesA, List<NodePattern> nodesB) {
		if (nodesA.size() == nodesB.size()) {
			Set<NodePattern> remainingB = new HashSet<>(nodesB);
			
			for (NodePattern nodePatternA : nodesA) {
				NodePattern match = null;
				
				for (NodePattern nodePatternB : remainingB) {
					if (nodePatternA.getType().equals(nodePatternB.getType())) {
						match = nodePatternB;
						break;
					}
				}
				
				if (match != null) {
					remainingB.remove(match);
				} else {
					return false;
				}
			}
			
			return true;
		} else {
			return false;
		}
	}
	
	public static DomainImpl<NodePattern> getDomain(NodePattern node, List<NodePattern> values) {
		DomainImpl<NodePattern> domain = new DomainImpl<NodePattern>();
		
		for (NodePattern value : values) {
			if (node.getType().equals(value.getType())) {
				domain.add(value);
			}
		}
		
		return domain;
	}
}

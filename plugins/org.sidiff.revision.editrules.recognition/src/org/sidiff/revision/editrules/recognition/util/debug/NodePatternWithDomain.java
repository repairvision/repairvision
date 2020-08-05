package org.sidiff.revision.editrules.recognition.util.debug;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.revision.common.emf.ItemProviderUtil;
import org.sidiff.revision.common.utilities.java.JUtil;
import org.sidiff.revision.editrules.recognition.pattern.domain.Domain;
import org.sidiff.revision.editrules.recognition.pattern.domain.Domain.SelectionType;

public class NodePatternWithDomain {
	
	private NodePattern node;
	
	private List<EObject> domainSnapshot;
	
	private SelectionType[] filter;

	public NodePatternWithDomain(NodePattern node, SelectionType[] filter) {
		this.node = node;
		this.domainSnapshot = Domain.get(node).getDomain().entrySet().stream()
				.filter(e -> !JUtil.contains(filter, e.getValue()))
				.map(Map.Entry::getKey).collect(Collectors.toList());
		this.filter = filter;
	}

	public NodePattern getNode() {
		return node;
	}

	public void setNode(NodePattern node) {
		this.node = node;
	}
	
	@Override
	public String toString() {
		StringBuffer print = new StringBuffer();
		
		print.append("Node" + DebugUtil.jHashCode(node) + ": " + node.getName());
		print.append(", Type: " + node.getType().getName());
		
		print.append(", Outgoings: ");
		
		for (EdgePattern outgoing : node.getOutgoings()) {
			if (outgoing != node.getOutgoings().get(0)) {
				print.append(", ");
			}
			print.append(ItemProviderUtil.getTextByObject(outgoing));
		}
		
		print.append(":\n");
		
		Map<EObject, SelectionType> domain = Domain.get(node).getDomain();
		int index = 0;
		
		for (Entry<EObject, SelectionType> coloredValue : domain.entrySet()) {
			EObject value = coloredValue.getKey();
			SelectionType color = coloredValue.getValue();
			
			if (!JUtil.contains(filter, color)) {
				print.append("  [" + index + "]" + "[" + domainSnapshot.indexOf(value) + "]" + "[" + color + "]"
						+ value.getClass().getSimpleName() + DebugUtil.jHashCode(value) + ": "
						+ ItemProviderUtil.getTextByObject(value) + "\n");
			}
			
			++index;
		}
		
		return print.toString();
	}
}

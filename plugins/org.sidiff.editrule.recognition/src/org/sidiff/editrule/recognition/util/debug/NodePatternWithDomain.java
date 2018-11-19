package org.sidiff.editrule.recognition.util.debug;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.provider.ItemProviderUtil;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.NodePattern;

public class NodePatternWithDomain {
	
	private NodePattern node;
	
	private List<EObject> domain;

	public NodePatternWithDomain(NodePattern node, List<EObject> domain) {
		this.node = node;
		this.domain = domain;
	}

	public NodePattern getNode() {
		return node;
	}

	public void setNode(NodePattern node) {
		this.node = node;
	}

	public List<EObject> getDomain() {
		return domain;
	}

	public void setDomain(List<EObject> domain) {
		this.domain = domain;
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
		
		for (int i = 0; i < domain.size(); i++) {
			EObject value = domain.get(i);
			print.append("  [" + i + "] " 
					+ value.getClass().getSimpleName() + DebugUtil.jHashCode(value) + ": "
					+ ItemProviderUtil.getTextByObject(value) + "\n");
		}
		
		return print.toString();
	}
}

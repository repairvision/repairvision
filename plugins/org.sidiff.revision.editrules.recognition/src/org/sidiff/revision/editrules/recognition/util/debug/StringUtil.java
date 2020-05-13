package org.sidiff.revision.editrules.recognition.util.debug;

import java.util.List;

import org.sidiff.graphpattern.NodePattern;
import org.sidiff.revision.editrules.recognition.pattern.domain.Domain;

public class StringUtil {
	
	public static String printSelections(List<NodePattern> nodes) {
		StringBuffer print = new StringBuffer();
		
		for (NodePattern node : nodes) {
			print.append("Node@" + Integer.toHexString(node.hashCode()) + ": " + node.getName());
			print.append(", Type: " + node.getType().getName() + ":\n");
			print.append(printSelection(node, "  "));
			print.append("\n");
		}
		
		return print.toString();
	}
	
	public static String printSelection(NodePattern node) {
		return printSelection(node, "");
	}

	public static String printSelection(NodePattern node, String indent) {
		StringBuffer selectionPrint = new StringBuffer();
		Domain.get(node).iterator()
		.forEachRemaining(selection -> {selectionPrint.append(indent 
				+ "[" + Domain.get(node).get(selection) + "] " 
				+ removeBundleNames(selection) + "\n");});
		return selectionPrint.toString();
	}
	
	public static String removeBundleNames(Object obj) {
		String name = obj.toString();
		name = name.replaceFirst("org\\.sidiff\\.consistency\\.graphpattern\\.impl\\.", "");
		name = name.replaceFirst("org\\.eclipse\\.uml2\\.uml\\.internal\\.impl\\.", "");
		name = name.replaceFirst("org\\.sidiff\\.revision\\.difference\\.impl\\.", "");
		return name;
	}
}

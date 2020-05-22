package org.sidiff.revision.editrules.recognition.util.debug;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.revision.editrules.recognition.pattern.RecognitionPattern;
import org.sidiff.revision.editrules.recognition.pattern.domain.Domain;
import org.sidiff.revision.editrules.recognition.pattern.domain.Domain.SelectionType;
import org.sidiff.revision.editrules.recognition.pattern.graph.ActionEdge;
import org.sidiff.revision.editrules.recognition.pattern.graph.ActionNode;

public class DebugUtil {

	public static Edit2RecognitionPatterns getSelectedDomains(Object obj, String... fieldNamesToRecognitionPattern) {
		return getDomains(obj, new SelectionType[] {SelectionType.RESTRICTED}, fieldNamesToRecognitionPattern);
	}

	public static Edit2RecognitionPatterns getDomains(Object obj, String... fieldNamesToRecognitionPattern) {
		return getDomains(obj, new SelectionType[0], fieldNamesToRecognitionPattern);
	}

	public static Edit2RecognitionPatterns getDomains(Object obj, SelectionType[] filter, String... fieldNamesToRecognitionPattern) {
		RecognitionPattern pattern = (RecognitionPattern) jGet(obj, fieldNamesToRecognitionPattern);
		Edit2RecognitionPatterns matching = new Edit2RecognitionPatterns();
		
		for (Entry<Node, ActionNode> topology : pattern.getNodeTrace().entrySet()) {
			Node node = topology.getKey();
			ActionNode action = topology.getValue();
			
			List<NodePattern> recognitionPattern = new ArrayList<>();
			
			if (action.getAction().equals(Type.CREATE)) {
				recognitionPattern.add(action.getChange().getChangeNodePattern());
				recognitionPattern.add(action.getNodePatternB());
			} else if (action.getAction().equals(Type.DELETE)) {
				recognitionPattern.add(action.getChange().getChangeNodePattern());
				recognitionPattern.add(action.getNodePatternA());
			} else if (action.getAction().equals(Type.PRESERVE)) {
				recognitionPattern.add(action.getNodePatternA());
				recognitionPattern.add(action.getNodePatternB());
				recognitionPattern.add(action.getCorrespondence());
			}
			
			matching.getPatterns().add(new Edit2RecognitionPattern(node, getDomains(recognitionPattern, filter)));
		}
		
		for (Entry<Edge, ActionEdge> topology : pattern.getEdgeTrace().entrySet()) {
			Edge edge = topology.getKey();
			ActionEdge action = topology.getValue();
			
			List<NodePattern> recognitionPattern = new ArrayList<>();
			
			if (action.getAction().equals(Type.CREATE)) {
				recognitionPattern.add(action.getChange().getChangeNodePattern());
				recognitionPattern.add(action.getSource().getNodePatternB());
				recognitionPattern.add(action.getTarget().getNodePatternB());
			} else if (action.getAction().equals(Type.DELETE)) {
				recognitionPattern.add(action.getChange().getChangeNodePattern());
				recognitionPattern.add(action.getSource().getNodePatternA());
				recognitionPattern.add(action.getTarget().getNodePatternA());
			} else if (action.getAction().equals(Type.PRESERVE)) {
				recognitionPattern.add(action.getSource().getNodePatternA());
				recognitionPattern.add(action.getTarget().getNodePatternA());
				recognitionPattern.add(action.getTarget().getCorrespondence());
				recognitionPattern.add(action.getSource().getNodePatternB());
				recognitionPattern.add(action.getTarget().getNodePatternB());
				recognitionPattern.add(action.getTarget().getCorrespondence());
			}
			
			matching.getPatterns().add(new Edit2RecognitionPattern(edge, getDomains(recognitionPattern, filter)));
		}
		
		return matching;
	}

	public static Object jGet(Object obj, String[] fieldNames) {
		try {
			Field field = obj.getClass().getDeclaredField(fieldNames[0]);
			field.setAccessible(true);
			Object nextObj = field.get(obj);
			
			if (fieldNames.length > 1) {
				return jGet(nextObj, Arrays.copyOfRange(fieldNames, 1, fieldNames.length));
			} else {
				return nextObj; 
			}
		} catch (Exception e) {
		}
		
		return null;
	}

	public static String jHashCode(Object obj) {
		return "@" + Integer.toHexString(obj.hashCode());
	}

	public static List<NodePatternWithDomain> getDomains(List<NodePattern> nodes, SelectionType[] filter) {
		List<NodePatternWithDomain> domains = new ArrayList<>();
		
		for (NodePattern node : nodes) {
			if (node != null) {
				domains.add(new NodePatternWithDomain(node, filter));
			}
		}
		
		return domains;
	}

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

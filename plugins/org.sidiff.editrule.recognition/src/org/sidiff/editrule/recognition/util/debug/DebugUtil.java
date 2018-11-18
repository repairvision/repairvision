package org.sidiff.editrule.recognition.util.debug;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.emf.provider.ItemProviderUtil;
import org.sidiff.consistency.common.monitor.LogTime;
import org.sidiff.editrule.recognition.IMatching;
import org.sidiff.editrule.recognition.pattern.RecognitionPattern;
import org.sidiff.editrule.recognition.pattern.domain.Domain;
import org.sidiff.editrule.recognition.pattern.graph.ActionEdge;
import org.sidiff.editrule.recognition.pattern.graph.ActionNode;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.NodePattern;

public class DebugUtil {

	public static boolean ACTIVE = true;
	
	public static boolean EVALUATION = true;
	
	public static boolean MATCHING = false;

	public static void print(String text) {
		if (ACTIVE) {
			System.out.println(text);
		}
	}

	// public static void print() {
	// if (true) {
	//
	// }
	// }
	
	public class NodePatternWithDomain {
		
		private NodePattern node;
		
		private List<EObject> domain;
		
		public NodePatternWithDomain(NodePattern node, List<EObject> domain) {
			this.node = node;
			this.domain = domain;
		}
		
		@Override
		public String toString() {
			StringBuffer print = new StringBuffer();
			
			print.append("Node" + jHashCode(node) + ": " + node.getName());
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
						+ value.getClass().getSimpleName() + jHashCode(value) + ": "
						+ ItemProviderUtil.getTextByObject(value) + "\n");
			}
			
			return print.toString();
		}
	}
	
	public class Edit2RecognitionPattern {
		
		private GraphElement editElement;
		
		private List<NodePatternWithDomain> recognitionPattern;
		
		public Edit2RecognitionPattern(GraphElement edit, List<NodePatternWithDomain> recognition) {
			this.editElement = edit;
			this.recognitionPattern = recognition;
		}

		@Override
		public String toString() {
			StringBuilder string = new StringBuilder();
			
			string.append("--------------------------------------------------------------------------------\n");
			string.append("<<" + editElement.getAction() + ">> " + editElement.toString() + " " + jHashCode(editElement) + "\n");
			string.append("--------------------------------------------------------------------------------\n");
			
			for (NodePatternWithDomain nodes : recognitionPattern) {
				string.append(nodes);
				string.append("\n");
			}
			
			string.append("--------------------------------------------------------------------------------\n");
			return string.toString();
		}
	}
	
	public class Edit2RecognitionPatterns {
		
		private List<Edit2RecognitionPattern> patterns = new ArrayList<>();
		
		public List<Edit2RecognitionPattern> getPatterns() {
			return patterns;
		}
		
		@Override
		public String toString() {
			StringBuilder string = new StringBuilder();
			
			for (Edit2RecognitionPattern edit2RecognitionPattern : patterns) {
				string.append(edit2RecognitionPattern);
			}
			
			return string.toString();
		}
	}
	
	public static Edit2RecognitionPatterns getDomains(Object obj, String... fieldNamesToRecognitionPattern) {
		RecognitionPattern pattern = (RecognitionPattern) jGet(obj, fieldNamesToRecognitionPattern);
		Edit2RecognitionPatterns matching = new DebugUtil().new Edit2RecognitionPatterns();
		
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
				recognitionPattern.add(action.getNodePatternA());
				recognitionPattern.add(action.getCorrespondence());
			}
			
			matching.getPatterns().add(new DebugUtil().new Edit2RecognitionPattern(node, getDomains(recognitionPattern)));
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
			
			matching.getPatterns().add(new DebugUtil().new Edit2RecognitionPattern(edge, getDomains(recognitionPattern)));
		}
		
		return matching;
	}
	
	private static Object jGet(Object obj, String[] fieldNames) {
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
	
	private static String jHashCode(Object obj) {
		return "@" + Integer.toHexString(obj.hashCode());
	}
	
	public static List<NodePatternWithDomain> getDomains(List<NodePattern> nodes) {
		List<NodePatternWithDomain> domains = new ArrayList<>();
		
		for (NodePattern node : nodes) {
			if (node != null) {
				domains.add(new DebugUtil().new NodePatternWithDomain(node, getDomain(node)));
			}
		}
		
		return domains;
	}
	
	public static List<EObject> getDomain(NodePattern node) {
		List<EObject> domain = new ArrayList<>();
		Domain.get(node).iterator().forEachRemaining(domain::add);
		return domain;
	}

	public static void printEditRule(Rule editRule) {
		if (EVALUATION) {
			print("Re.Vision[Edit Rule Matching]: " + editRule.getName());
		}
	}

	public static void printRecognitionTime(LogTime matchingTime) {
		if (EVALUATION) {
			print("Re.Vision[Recognition Time]: " + matchingTime + "ms");
		}
	}
	
	public static void printMatchingTime(LogTime matchingTime) {
		if (EVALUATION) {
			print("Re.Vision[Matching Time]: " + matchingTime + "ms");
		}
	}
	
	public static void printFalsePositives(int falsePositives) {
		if (EVALUATION) {
			print("Re.Vision[False Positives]: " + falsePositives);
		}
	}
	
	public static void printFoundMatchings(int matchings) {
		if (EVALUATION) {
			print("Re.Vision[Matchings Found]: " + matchings);
		}
	}

	public static void printMatching(RecognitionPattern recognitionPattern, IMatching matching) {
		if (MATCHING) {
			System.out.println("Matching:");

			for (NodePattern changePattern : recognitionPattern.getChangeNodePatterns()) {
				System.out.println("  " + recognitionPattern.getChangePattern(changePattern) + ": "
						+ matching.getFirstMatch(changePattern));
			}
		}
	}

	public static void printEvaluationStepContextB(ActionNode node, EObject matchB) {
		if (MATCHING) {
			System.out.println("    B:" + node);
			System.out.println("        Match: " + matchB);
		}
	}

	public static void printEvaluationStepContextA(ActionNode actionNode, EObject matchA) {
		if (MATCHING) {
			System.out.println("    A:" + actionNode);
			System.out.println("        Match: " + matchA);

		}
	}

	public static void printEvaluationStep(ActionNode actionNode) {
		if (MATCHING) {
			System.out.println("Evaluation Step: " + actionNode);
		}
	}
}

package org.sidiff.editrule.recognition.util.debug;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.common.monitor.LogTime;
import org.sidiff.editrule.recognition.IMatching;
import org.sidiff.editrule.recognition.pattern.RecognitionPattern;
import org.sidiff.editrule.recognition.pattern.domain.Domain;
import org.sidiff.editrule.recognition.pattern.graph.ActionNode;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.common.emf.provider.ItemProviderUtil;

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
	
	public final class VariableWithDomain {
		
		private NodePattern node;
		
		private List<EObject> domain;
		
		public VariableWithDomain(NodePattern node, List<EObject> domain) {
			this.node = node;
			this.domain = domain;
		}
		
		@Override
		public String toString() {
			StringBuffer print = new StringBuffer();
			
			print.append("Node: " + node.getName());
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
				print.append("  [" + i + "] " + ItemProviderUtil.getTextByObject(domain.get(i)) + "\n");
			}
			
			return print.toString();
		}
	}
	
	public static List<VariableWithDomain> getDomains(List<NodePattern> nodes) {
		List<VariableWithDomain> domains = new ArrayList<>();
		
		for (NodePattern node : nodes) {
			domains.add(new DebugUtil().new VariableWithDomain(node, getDomain(node)));
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

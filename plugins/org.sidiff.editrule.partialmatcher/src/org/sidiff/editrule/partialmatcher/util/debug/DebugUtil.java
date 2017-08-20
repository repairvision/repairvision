package org.sidiff.editrule.partialmatcher.util.debug;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.common.monitor.LogTime;
import org.sidiff.editrule.partialmatcher.pattern.RecognitionPattern;
import org.sidiff.editrule.partialmatcher.pattern.graph.ActionNode;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.matcher.IMatching;

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

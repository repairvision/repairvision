package org.sidiff.editrule.partialmatcher.util;

import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.editrule.partialmatcher.pattern.RecognitionPattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.matcher.IMatching;

public class DebugUtil {
	
	public static boolean ACTIVE = true;
	
	public static void print(String text) {
		if (ACTIVE) {
			System.out.println(text);
		}
	}
	
	public static void printEditRule(Rule editRule) {
		print("EVALUATION[Edit Rule Matching]: " + editRule.getName());
	}
	
	public static void printMatchingTime(long matchingTime) {
		print("EVALUATION[Matching Time]: " + (System.currentTimeMillis() - matchingTime) + "ms");
	}
	
	public static void printMatching(RecognitionPattern recognitionPattern, IMatching matching) {
		System.out.println("Matching:");
		
		for (NodePattern changePattern : recognitionPattern.getChangeNodePatterns()) {
			System.out.println("  " + recognitionPattern.getChangePattern(changePattern) + ": " + matching.getFirstMatch(changePattern));
		}
	}
}

package org.sidiff.revision.impact.changetree.test;

import org.sidiff.revision.impact.changetree.Alternative;
import org.sidiff.revision.impact.changetree.IDecisionNode;
import org.sidiff.revision.impact.changetree.Sequence;

public class TestDecisionTreeTraversal {

	public static void main(String[] args) {
		
		// Build decision tree:
		IDecisionNode root = buildDecisionTree06();
		System.out.println(root);
		
		// List all possible decisions:
		root.combinations().forEachRemaining(decision -> {
			System.out.println("--------------------------------------------------");
			decision.forEach(System.out::println);
			System.out.println("--------------------------------------------------");
		});
	}

	@SuppressWarnings("unused")
	private static IDecisionNode buildDecisionTree01() {
		return new StringDecisionLeaf("A");
	}
	
	@SuppressWarnings("unused")
	private static IDecisionNode buildDecisionTree02() {
		Alternative alternative = new Alternative();
		alternative.appendChildDecisions(
				new StringDecisionLeaf("A"),
				new StringDecisionLeaf("B"),
				new StringDecisionLeaf("C"));
		
		return alternative;
	}
	
	@SuppressWarnings("unused")
	private static IDecisionNode buildDecisionTree03() {
		Sequence sequence = new Sequence();
		sequence.appendChildDecisions(
				new StringDecisionLeaf("A"),
				new StringDecisionLeaf("B"),
				new StringDecisionLeaf("C"));
		
		return sequence;
	}
	
	@SuppressWarnings("unused")
	private static IDecisionNode buildDecisionTree04() {
		Alternative alternativeX = new Alternative();
		alternativeX.appendChildDecisions(
				new StringDecisionLeaf("A"),
				new StringDecisionLeaf("B"),
				new StringDecisionLeaf("C"));
		
		Alternative alternativeY = new Alternative();
		alternativeY.appendChildDecisions(
				new StringDecisionLeaf("D"),
				new StringDecisionLeaf("E"),
				new StringDecisionLeaf("F"));
		
		Sequence sequence = new Sequence();
		sequence.appendChildDecisions(
				alternativeX,
				alternativeY);
				
		return sequence;
	}
	
	@SuppressWarnings("unused")
	private static IDecisionNode buildDecisionTree05() {
		Alternative alternativeX = new Alternative();
		alternativeX.appendChildDecisions(
				new StringDecisionLeaf("A"),
				new StringDecisionLeaf("B"),
				new StringDecisionLeaf("C"));
		
		Alternative alternativeY = new Alternative();
		alternativeY.appendChildDecisions(
				new StringDecisionLeaf("D"),
				new StringDecisionLeaf("E"),
				new StringDecisionLeaf("F"));
		
		Sequence sequenceZ = new Sequence();
		sequenceZ.appendChildDecisions(
				alternativeX,
				alternativeY);
		
		// ----
		
		Alternative alternativeO = new Alternative();
		alternativeO.appendChildDecisions(
				new StringDecisionLeaf("H"),
				new StringDecisionLeaf("I"),
				new StringDecisionLeaf("J"));
		
		Alternative alternativeP = new Alternative();
		alternativeP.appendChildDecisions(
				new StringDecisionLeaf("K"),
				new StringDecisionLeaf("L"),
				new StringDecisionLeaf("M"));
		
		Sequence sequenceQ = new Sequence();
		sequenceQ.appendChildDecisions(
				alternativeO,
				alternativeP);
		
		// ----
		
		Alternative alternative = new Alternative();
		alternative.appendChildDecisions(
				sequenceZ,
				sequenceQ);
				
		return alternative;
	}
	
	private static IDecisionNode buildDecisionTree06() {
		Alternative alternativeX = new Alternative();
		alternativeX.appendChildDecisions(
				new StringDecisionLeaf("A"),
				new StringDecisionLeaf("B"),
				new StringDecisionLeaf("C"));
		
		Alternative alternativeY = new Alternative();
		alternativeY.appendChildDecisions(
				new StringDecisionLeaf("D"),
				new StringDecisionLeaf("E"),
				new StringDecisionLeaf("F"));
		
		Sequence sequenceZ = new Sequence();
		sequenceZ.appendChildDecisions(
				alternativeX,
				alternativeY);
		
		// ----
		
		Alternative alternativeO = new Alternative();
		alternativeO.appendChildDecisions(
				new StringDecisionLeaf("H"),
				new StringDecisionLeaf("I"),
				new StringDecisionLeaf("J"));
		
		Alternative alternativeP = new Alternative();
		alternativeP.appendChildDecisions(
				new StringDecisionLeaf("K"),
				new StringDecisionLeaf("L"),
				new StringDecisionLeaf("M"));
		
		Sequence sequenceQ = new Sequence();
		sequenceQ.appendChildDecisions(
				alternativeO,
				alternativeP);
		
		// ----
		
		Sequence sequence = new Sequence();
		sequence.appendChildDecisions(
				sequenceZ,
				sequenceQ);
				
		return sequence;
	}
}

package org.sidiff.editrule.recognition;

import java.util.Collection;
import java.util.Iterator;

import org.sidiff.editrule.recognition.pattern.graph.ActionEdge;
import org.sidiff.editrule.recognition.pattern.graph.ActionNode;
import org.sidiff.editrule.recognition.pattern.graph.ChangePattern;
import org.sidiff.graphpattern.matcher.IMatching;

public interface IRecognitionEngineMatcher {

	IRecognitionEngine getEngine();
	
	String getEditRuleName();
	
	Collection<ActionNode> getEditRuleNodes();
	
	Collection<ActionEdge> getEditRuleEdges();
	
	Collection<ChangePattern> getAllChanges();
	
	Iterator<IMatching> recognizeEditRule();
}

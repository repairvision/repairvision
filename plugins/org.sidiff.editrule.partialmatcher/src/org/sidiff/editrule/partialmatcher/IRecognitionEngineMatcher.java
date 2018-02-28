package org.sidiff.editrule.partialmatcher;

import java.util.Collection;
import java.util.Iterator;

import org.sidiff.editrule.partialmatcher.pattern.graph.ActionEdge;
import org.sidiff.editrule.partialmatcher.pattern.graph.ActionNode;
import org.sidiff.editrule.partialmatcher.pattern.graph.ChangePattern;
import org.sidiff.graphpattern.matcher.IMatching;

public interface IRecognitionEngineMatcher {

	String getEditRuleName();
	
	Collection<ActionNode> getEditRuleNodes();
	
	Collection<ActionEdge> getEditRuleEdges();
	
	Collection<ChangePattern> getAllChanges();
	
	Iterator<IMatching> recognizeEditRule();
	
	IRecognitionEngineMonitor getMonitor();
}

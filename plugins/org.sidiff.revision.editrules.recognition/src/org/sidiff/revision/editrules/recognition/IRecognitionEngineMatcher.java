package org.sidiff.revision.editrules.recognition;

import java.util.Collection;
import java.util.List;

import org.sidiff.revision.editrules.recognition.match.RecognitionMatching;
import org.sidiff.revision.editrules.recognition.pattern.graph.ActionEdge;
import org.sidiff.revision.editrules.recognition.pattern.graph.ActionNode;
import org.sidiff.revision.editrules.recognition.pattern.graph.ChangePattern;

public interface IRecognitionEngineMatcher {

	IRecognitionEngine getEngine();
	
	String getEditRuleName();
	
	Collection<ActionNode> getEditRuleNodes();
	
	Collection<ActionEdge> getEditRuleEdges();
	
	Collection<ChangePattern> getAllChanges();
	
	List<RecognitionMatching> recognizeEditRule();
}

package org.sidiff.revision.editrule.recognition;

import java.util.Collection;
import java.util.List;

import org.sidiff.revision.editrule.recognition.match.RecognitionMatching;
import org.sidiff.revision.editrule.recognition.pattern.graph.ActionEdge;
import org.sidiff.revision.editrule.recognition.pattern.graph.ActionNode;
import org.sidiff.revision.editrule.recognition.pattern.graph.ChangePattern;

public interface IRecognitionEngineMatcher {

	IRecognitionEngine getEngine();
	
	String getEditRuleName();
	
	Collection<ActionNode> getEditRuleNodes();
	
	Collection<ActionEdge> getEditRuleEdges();
	
	Collection<ChangePattern> getAllChanges();
	
	List<RecognitionMatching> recognizeEditRule();
}

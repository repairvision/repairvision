package org.sidiff.editrule.partialmatcher;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.common.monitor.LogTable;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.editrule.partialmatcher.pattern.RecognitionPattern;
import org.sidiff.editrule.partialmatcher.scope.RepairScope;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.matcher.IMatching;

public interface IRecognitionEngine {

	interface IChangeTag {
		String getName();
	}
	
	void initialize(SymmetricDifference difference);
	
	void start();

	void finish();

	RecognitionPattern createRecognitionPattern(Rule editRule);

	RecognitionPattern createRecognitionPattern(Rule editRule, GraphPattern graphPattern);
	
	List<NodePattern> getAllChanges();
	
	List<IChangeTag> getAvailableChangeTags();
	
	List<NodePattern> getTaggedChanges(IChangeTag tag);
	
	String getEditRuleName();
	
	List<NodePattern> getEditRuleNodes();
	
	List<EdgePattern> getEditRuleEdges();
	
	List<EdgePattern> getCurrentMatchingPath();
	
	Node getEditRuleTrace(NodePattern node);
	
	Edge getEditRuleTrace(EdgePattern node);
	
	Iterator<IMatching> recognizePartialEditRule(
			RecognitionPattern recognitionPattern, RepairScope scope, LogTable runtimeLog);

	Iterator<IMatching> recognizePartialEditRule(RecognitionPattern recognitionPattern);
}
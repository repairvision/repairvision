package org.sidiff.editrule.partialmatcher.engine;

import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.sidiff.editrule.partialmatcher.PartialEditRuleRecognizer;
import org.sidiff.editrule.partialmatcher.pattern.RecognitionPattern;
import org.sidiff.graphpattern.GraphPattern;

public class CreateRecognitionPatternCommand extends RecordingCommand {

	private PartialEditRuleRecognizer editRuleRecognizer;
	
	private RecognitionPattern recognitionPattern;
	
	private Rule editRule;
	
	private GraphPattern graphPattern;

	public CreateRecognitionPatternCommand(
			TransactionalEditingDomain domain,
			PartialEditRuleRecognizer editRuleRecognizer, 
			Rule editRule, GraphPattern graphPattern) {
		
		super(domain);
		this.editRuleRecognizer = editRuleRecognizer;
		this.editRule = editRule;
		this.graphPattern = graphPattern;
	}
	
	public RecognitionPattern getRecognitionPattern() {
		return recognitionPattern;
	}
	
	@Override
	protected void doExecute() {
		
		// Clear old pattern:
		graphPattern.setPattern(null);
		graphPattern.getNodes().clear();
		graphPattern.setDependencyGraph(null);
		
		recognitionPattern = editRuleRecognizer.createRecognitionPattern(editRule, graphPattern);
	}

	@Override
	public boolean canUndo() {
		return false;
	}
}

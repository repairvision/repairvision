package org.sidiff.editrule.recognition.engine;

import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.sidiff.editrule.recognition.IRecognitionEngine;
import org.sidiff.editrule.recognition.pattern.RecognitionPattern;
import org.sidiff.graphpattern.GraphPattern;

public class CreateRecognitionPatternCommand extends RecordingCommand {

	private IRecognitionEngine editRuleRecognizer;
	
	private RecognitionPattern recognitionPattern;
	
	private Rule editRule;
	
	private GraphPattern graphPattern;

	public CreateRecognitionPatternCommand(
			TransactionalEditingDomain domain,
			IRecognitionEngine editRuleRecognizer, 
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

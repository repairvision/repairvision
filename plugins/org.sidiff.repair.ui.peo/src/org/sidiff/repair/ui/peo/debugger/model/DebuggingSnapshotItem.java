package org.sidiff.repair.ui.peo.debugger.model;

public class DebuggingSnapshotItem {

	// Variables //
	
	private VariablesPickedItem pickedVariables;
	
	private VariablesRemainingItem remainingVariables;
	
	private VariablesRestrictedItem restrictedVariables;
	
	private VariablesRemovedItem removedVariables;
	
	// Edit Rule Graph Pattern //
	
	private EditRuleGraphItem editRule;
	
	// Matching //
	
	private PathItem currentEditRuleGraphMatching;
	
	private EditRuleGraphMatchingItem editRuleGraphMatching;
	
	public DebuggingSnapshotItem(IRecognitionEngine recognitionEngine) {
		this.pickedVariables = new VariablesPickedItem(recognitionEngine.getPickedVariables());
		this.remainingVariables = new VariablesRemainingItem(recognitionEngine.getRemainingVariables());
		this.restrictedVariables = new VariablesRestrictedItem(recognitionEngine.getRestrictedVariables());
		this.removedVariables = new VariablesRemovedItem(recognitionEngine.getRemovedVariables());
		
		this.editRule = new EditRuleGraphItem(recognitionEngine.getEditRuleNodes(), recognitionEngine.getEditRuleEdges());
		this.currentEditRuleGraphMatching = new PathItem(recognitionEngine.getCurrentMatchingPath());
		
		if (recognitionEngine.isRecordingMatching()) {
			this.editRuleGraphMatching = new EditRuleGraphMatchingItem(recognitionEngine.getMatchingPaths());
		}
	}
}

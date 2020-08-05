package org.sidiff.revision.repair.ui.debugger.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Image;
import org.sidiff.revision.editrules.recognition.impl.RecognitionEngine;
import org.sidiff.revision.editrules.recognition.impl.RecognitionEngineRecorder;
import org.sidiff.revision.editrules.recognition.impl.RecognitionEngineRecorder.IChangeTag;
import org.sidiff.revision.repair.ui.Activator;
import org.sidiff.revision.repair.ui.debugger.ITreeItem;

public class DebuggingSnapshotItem implements ITreeItem {
	
	private static Image icon = Activator.getImageDescriptor("icons/debug_exc.gif").createImage();
	
	// Parent Session //
	private DebuggingSession session;
	
	// Variables //
	private List<ChangesItem> variableSets = new ArrayList<>();
	
	// Edit Rule Graph Pattern //
	private EditRuleGraphItem editRule;
	
	// Matching //
	
	private EditRuleGraphMatchingItem editRuleGraphMatching;
	
	public DebuggingSnapshotItem(DebuggingSession session, RecognitionEngineRecorder monitor) {
		this.session = session;
		
		// Monitor recognition engine:
		for (IChangeTag variableTag : monitor.getAvailableChangeTags()) {
			variableSets.add(new ChangesItem(this, variableTag, monitor.getTaggedChanges(variableTag)));
		}

		this.editRuleGraphMatching = new EditRuleGraphMatchingItem(
				this, monitor.getMatchingPathRecording());
		
		RecognitionEngine recognitionEngine = monitor.getRecognitionEngineMatcher();
		
		this.editRule = new EditRuleGraphItem(this, recognitionEngine.getEditRuleName(),
				recognitionEngine.getEditRuleNodes(), recognitionEngine.getEditRuleEdges());
	}

	@Override
	public Image getIcon() {
		return icon;
	}

	@Override
	public String getText() {
		return "Snapshot";
	}

	@Override
	public ITreeItem getParent() {
		return session;
	}
	
	@Override
	public boolean hasChildren() {
		return true;
	}

	@Override
	public ITreeItem[] getChildren() {
		ITreeItem[] children = new ITreeItem[variableSets.size() + 2];
		
		for (int i = 0; i < variableSets.size(); i++) {
			children[i] = variableSets.get(i);
		}
		
		children[variableSets.size()] = editRule;
		children[variableSets.size() + 1] = editRuleGraphMatching;
		
		return children;
	}
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		
		for (ChangesItem variablesItem : variableSets) {
			string.append(variablesItem.toString() + "\n");
		}
		
		return string.toString();
	}
}

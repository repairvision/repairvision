package org.sidiff.revision.editrules.recognition.util.debug;

import java.util.List;

import org.eclipse.emf.henshin.model.GraphElement;

public class Edit2RecognitionPattern {
	
	private GraphElement editElement;
	
	private List<NodePatternWithDomain> recognitionPattern;
	
	public Edit2RecognitionPattern(GraphElement edit, List<NodePatternWithDomain> recognition) {
		this.editElement = edit;
		this.recognitionPattern = recognition;
	}

	public GraphElement getEditElement() {
		return editElement;
	}

	public void setEditElement(GraphElement editElement) {
		this.editElement = editElement;
	}

	public List<NodePatternWithDomain> getRecognitionPattern() {
		return recognitionPattern;
	}

	public void setRecognitionPattern(List<NodePatternWithDomain> recognitionPattern) {
		this.recognitionPattern = recognitionPattern;
	}
	
	public String toString(int index) {
		StringBuilder string = new StringBuilder();
		String indexString = (index >= 0) ? "[" + index + "] " : "";
		
		string.append("--------------------------------------------------------------------------------\n");
		string.append(indexString + "<<" + editElement.getAction() + ">> " + editElement.toString() + " " + DebugUtil.jHashCode(editElement) + "\n");
		string.append("--------------------------------------------------------------------------------\n");
		
		for (NodePatternWithDomain nodeWithDomain : recognitionPattern) {
			string.append(nodeWithDomain);
			string.append("\n");
		}
		
		string.append("--------------------------------------------------------------------------------\n");
		return string.toString();
	}

	@Override
	public String toString() {
		return toString(-1);
	}
}

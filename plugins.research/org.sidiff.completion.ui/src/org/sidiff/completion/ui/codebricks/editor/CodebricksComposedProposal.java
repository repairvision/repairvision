package org.sidiff.completion.ui.codebricks.editor;

import java.util.Collections;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.sidiff.completion.ui.codebricks.ComposedBrick;
import org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick;

public class CodebricksComposedProposal extends CodebricksProposal {
	
	protected Composite placeholderContainer;

	public CodebricksComposedProposal(CodebricksEditor editor, Composite placeholderContainer, StyledText textField, TemplatePlaceholderBrick placeholder, ComposedBrick choice) {
		super(editor, textField, placeholder, Collections.singletonList(choice));
		this.placeholderContainer = placeholderContainer;
	}

	@Override
	public boolean apply() {
		placeholder.getChoice().clear();
		placeholder.getChoice().addAll(choice);
		
		// Clear container:
		Control[] children = placeholderContainer.getChildren();
		
		for (int i = 0; i < children.length; i++) {
			children[i].dispose();
		}
		
		// Add composed bricks:
		assert this.choice.size() == 1;
		ComposedBrick choice = (ComposedBrick) this.choice.get(0);
		editor.buildContent(placeholderContainer, choice.getBricks());
		
		// Update other placeholders:
		editor.autoSelectPlaceholders(editor.getTemplate());
		
		return true;
	}
}

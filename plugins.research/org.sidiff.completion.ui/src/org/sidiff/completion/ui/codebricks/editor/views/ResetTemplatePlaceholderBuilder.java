package org.sidiff.completion.ui.codebricks.editor.views;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.sidiff.completion.ui.codebricks.ResetTemplatePlaceholderBrick;
import org.sidiff.completion.ui.codebricks.editor.CodebricksEditor;

public class ResetTemplatePlaceholderBuilder {

	public static StyledText build(
			CodebricksEditor editor, Composite placeholderContainer, ResetTemplatePlaceholderBrick resetBrick,
			Color foreground, Color background) {
		
		if (resetBrick.getPlaceholder() != null) {
			return PlaceholderBuilder.build(
					editor, placeholderContainer, resetBrick.getPlaceholder(), resetBrick.getText(),
					TemplatePlaceholderBuilder::getProposals, 
					foreground, background);
		} else {
			return EditableTextBrickBuilder.build(
					editor, placeholderContainer, resetBrick.getText(), resetBrick.getText(),
					false, foreground, background);
		}
	}
}

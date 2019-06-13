package org.sidiff.completion.ui.codebricks.editor;

import java.util.List;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Image;
import org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick;
import org.sidiff.completion.ui.codebricks.ViewableBrick;
import org.sidiff.completion.ui.list.ICompletionPreview;
import org.sidiff.completion.ui.list.ICompletionProposal;

public class CodebricksProposal implements ICompletionProposal {
	
	protected StyledText textField;
	
	protected TemplatePlaceholderBrick placeholder;
	
	protected List<ViewableBrick> choice;
	
	public CodebricksProposal(StyledText textField, TemplatePlaceholderBrick placeholder, List<ViewableBrick> choice) {
		this.textField = textField;
		this.placeholder = placeholder;
		this.choice = choice;
	}

	@Override
	public ICompletionPreview preview() {
		return new ICompletionPreview() {
			
			private String oldText = textField.getText();
			
			@Override
			public boolean show() {
				textField.setText(getText());
				return true;
			}
			
			@Override
			public boolean hide() {
				textField.setText(oldText);
				return true;
			}
		};
	}
	
	@Override
	public String getText() {
		return choice.get(0).getText();
	}
	
	@Override
	public String getInformation() {
		return null;
	}
	
	@Override
	public Image getImage() {
		return null;
	}
	
	@Override
	public boolean apply() {
		placeholder.getChoice().clear();
		placeholder.getChoice().addAll(choice);
		textField.setText(getText());
		return true;
	}
}

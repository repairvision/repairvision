package org.sidiff.completion.ui.codebricks.editor.proposals;

import java.util.List;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick;
import org.sidiff.completion.ui.codebricks.ViewableBrick;
import org.sidiff.completion.ui.proposals.ICompletionPreview;
import org.sidiff.completion.ui.proposals.ICompletionProposal;

public class TemplateCodebricksProposal implements ICompletionProposal {
	
	protected StyledText textField;
	
	protected TemplatePlaceholderBrick placeholder;
	
	protected List<ViewableBrick> choice;
	
	public TemplateCodebricksProposal(StyledText textField, TemplatePlaceholderBrick placeholder, List<ViewableBrick> choice) {
		this.textField = textField;  				// TODO: The editor should listen to model changes!
		this.placeholder = placeholder;
		this.choice = choice;
	}

	@Override
	public ICompletionPreview preview() {
		return new ICompletionPreview() {
			
			private String oldText = textField.getText();
			
			@Override
			public boolean show() {
//				apply();							// TODO: Needs recording/undo of all subsequent changes!	
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
		return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
	}
	
	@Override
	public boolean apply() {
		
		// Set selected text for placeholder:
		placeholder.getChoice().clear();
		placeholder.getChoice().addAll(choice);
		
		return true;
	}
}

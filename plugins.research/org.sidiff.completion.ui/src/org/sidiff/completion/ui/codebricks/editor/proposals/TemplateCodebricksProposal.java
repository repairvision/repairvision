package org.sidiff.completion.ui.codebricks.editor.proposals;

import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.sidiff.completion.ui.codebricks.CollapsibleBrick;
import org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick;
import org.sidiff.completion.ui.codebricks.ViewableBrick;
import org.sidiff.completion.ui.codebricks.editor.CodebricksEditor;
import org.sidiff.completion.ui.proposals.ICompletionPreview;
import org.sidiff.completion.ui.proposals.ICompletionProposal;

public class TemplateCodebricksProposal implements ICompletionProposal {
	
	protected TemplatePlaceholderBrick placeholder;
	
	protected List<ViewableBrick> choice;
	
	public TemplateCodebricksProposal(TemplatePlaceholderBrick placeholder, List<ViewableBrick> choice) {
		this.placeholder = placeholder;
		this.choice = choice;
	}
	
	public static boolean canCombineProposals(ViewableBrick choiceA, ViewableBrick choiceB) {
		String textA = getText(choiceA);
		String textB = getText(choiceB);
		return (textA != null) && textA.equals(textB);
	}
	
	public static boolean canCombineProposals(List<ViewableBrick> choices) {
		for (int i = 0; i < choices.size() - 1; i++) {
			if (!canCombineProposals(choices.get(i), choices.get(i + 1))) {
				return false;
			}
		}
		return true;
	}
	
	public static String getText(ViewableBrick brick) {
		if (brick instanceof CollapsibleBrick) {
			return ((CollapsibleBrick) brick).getCollapsedText();
		} else {
			return brick.getText();
		}
	}
	
	@Override
	public String getText() {
		return getText(choice.get(0)) + " - (" + choice.size() + ")";
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
	public ICompletionPreview preview() {
		return new ICompletionPreview() {
			
			private RecordingCommand command;
			
			@Override
			public boolean show() {
				
				command = CodebricksEditor.executeCommand(placeholder, () -> {
					apply();
				});
				
				return true;
			}
			
			@Override
			public boolean hide() {
				CodebricksEditor.undoCommand(placeholder, command);
				return true;
			}
		};
	}
	
	@Override
	public boolean apply() {
		
		// Set selected text for placeholder:
		CodebricksEditor.executeCommand(placeholder, () -> {
			placeholder.getChoice().clear();
			placeholder.getChoice().addAll(choice);
		}); 
		
		return true;
	}
}

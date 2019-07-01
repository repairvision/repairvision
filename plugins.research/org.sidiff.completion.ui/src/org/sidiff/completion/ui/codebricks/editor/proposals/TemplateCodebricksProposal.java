package org.sidiff.completion.ui.codebricks.editor.proposals;

import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
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

	@Override
	public ICompletionPreview preview() {
		return new ICompletionPreview() {
			
			private RecordingCommand command;
			
			@Override
			public boolean show() {
				
				command = CodebricksEditor.executeCommand(placeholder, () -> {
					System.out.println("APPLY BEGIN ##############################################################");
					apply();
					System.out.println("APPLY END ##############################################################");
				});
				
				return true;
			}
			
			@Override
			public boolean hide() {
				System.out.println("UNDO BEGIN ##############################################################");
				CodebricksEditor.undoCommand(placeholder, command);
				System.out.println("UNDO END ##############################################################");
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
		CodebricksEditor.executeCommand(placeholder, () -> {
			placeholder.getChoice().clear();
			placeholder.getChoice().addAll(choice);
		}); 
		
		return true;
	}
}

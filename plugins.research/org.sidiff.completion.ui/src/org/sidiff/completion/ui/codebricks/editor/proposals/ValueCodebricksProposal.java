package org.sidiff.completion.ui.codebricks.editor.proposals;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.sidiff.completion.ui.codebricks.ValuePlaceholderBrick;
import org.sidiff.completion.ui.codebricks.editor.CodebricksEditor;
import org.sidiff.completion.ui.proposals.ICompletionPreview;
import org.sidiff.completion.ui.proposals.ICompletionProposal;
import org.sidiff.revision.common.emf.ItemProviderUtil;

public class ValueCodebricksProposal implements ICompletionProposal  {

	protected ValuePlaceholderBrick placeholder;
	
	protected Object object;
	
	public ValueCodebricksProposal(ValuePlaceholderBrick placeholder, Object object) {
		this.placeholder = placeholder;
		this.object = object;
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
	public String getText() {
		return ItemProviderUtil.getTextByObject(object);
	}
	
	@Override
	public String getInformation() {
		StringBuilder info = new StringBuilder();
		info.append(placeholder.getLiteralValue());
		info.append(" : ");
		info.append(placeholder.getType().getName());
		info.append("<br>");
		
		if (!placeholder.getDomain().isValid(placeholder, placeholder.getLiteralValue(), placeholder.getType())) {
			info.append("Value is invalid!");
		}
		
		return info.toString();
	}
	
	@Override
	public Image getImage() {
		Object image = ItemProviderUtil.getImageByObject(object);
		
		if (image instanceof Image) {
			return (Image) image;
		}
		
		return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
	}
	
	@Override
	public boolean apply() {
		
		// Set selected text for placeholder:
		CodebricksEditor.executeCommand(placeholder, () -> {
			placeholder.setInstanceValue(object);
		}); 
		
		return true;
	}
}

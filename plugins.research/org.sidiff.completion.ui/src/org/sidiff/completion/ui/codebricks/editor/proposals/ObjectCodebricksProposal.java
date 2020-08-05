package org.sidiff.completion.ui.codebricks.editor.proposals;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.sidiff.completion.ui.codebricks.ObjectPlaceholderBrick;
import org.sidiff.completion.ui.codebricks.editor.CodebricksEditor;
import org.sidiff.completion.ui.proposals.CompletionProposalList;
import org.sidiff.completion.ui.proposals.ICompletionPreview;
import org.sidiff.completion.ui.proposals.ICompletionProposal;
import org.sidiff.revision.common.emf.ItemProviderUtil;

public class ObjectCodebricksProposal implements ICompletionProposal {

	protected ObjectPlaceholderBrick placeholder;
	
	protected EObject object;
	
	public ObjectCodebricksProposal(ObjectPlaceholderBrick placeholder, EObject object) {
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
		info.append(ItemProviderUtil.getTextByObject(object));
		
		// Print path to parent:
		EObject elementOnTreePath = object.eContainer();
		
		while (elementOnTreePath != null) {
			info.insert(0, ItemProviderUtil.getTextByObject(elementOnTreePath) + " / ");
			elementOnTreePath = elementOnTreePath.eContainer();
		}
		
		return CompletionProposalList.escapeHTML(info.toString());
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
			placeholder.setElement(object);
		}); 
		
		return true;
	}
}

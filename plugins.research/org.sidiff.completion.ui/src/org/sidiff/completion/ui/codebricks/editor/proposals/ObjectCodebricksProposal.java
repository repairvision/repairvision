package org.sidiff.completion.ui.codebricks.editor.proposals;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.sidiff.completion.ui.codebricks.ObjectPlaceholderBrick;
import org.sidiff.completion.ui.list.CompletionProposalList;
import org.sidiff.completion.ui.list.ICompletionPreview;
import org.sidiff.completion.ui.list.ICompletionProposal;
import org.sidiff.graphpattern.edit.util.ItemProviderUtil;

public class ObjectCodebricksProposal implements ICompletionProposal {

	protected StyledText textField;
	
	protected ObjectPlaceholderBrick placeholder;
	
	protected EObject object;
	
	public ObjectCodebricksProposal(StyledText textField, ObjectPlaceholderBrick placeholder, EObject object) {
		this.textField = textField;  				// TODO: The editor should listen to model changes!
		this.placeholder = placeholder;
		this.object = object;
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
		placeholder.setElement(object);
		
		return true;
	}
}

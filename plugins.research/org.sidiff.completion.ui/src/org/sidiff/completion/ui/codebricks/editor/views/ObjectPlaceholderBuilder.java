package org.sidiff.completion.ui.codebricks.editor.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.sidiff.completion.ui.codebricks.Codebricks;
import org.sidiff.completion.ui.codebricks.ObjectPlaceholderBrick;
import org.sidiff.completion.ui.codebricks.editor.CodebricksEditor;
import org.sidiff.completion.ui.codebricks.editor.proposals.ObjectCodebricksProposal;
import org.sidiff.completion.ui.codebricks.util.CodebricksUtil;
import org.sidiff.completion.ui.proposals.ICompletionProposal;
import org.sidiff.revision.common.emf.ItemProviderUtil;

public class ObjectPlaceholderBuilder {

	public static Composite build(
			CodebricksEditor editor, Composite parentContainer, ObjectPlaceholderBrick placeholderBrick,
			boolean boldFont, Color foreground, Color background) {
		
		// Create view:
		Composite placeholderWithIcon = BrickRowBuilder.build(parentContainer, background);
		
		// Icon:
		CLabel icon = new CLabel(placeholderWithIcon, SWT.NONE);
		icon.setBackground(parentContainer.getDisplay().getSystemColor(SWT.COLOR_TRANSPARENT));
		icon.setMargins(0, 0, 5, 0);
		
		// Text:
		StyledText placeholderControl =  PlaceholderBuilder.build(
				editor, placeholderWithIcon, placeholderBrick,
				ObjectPlaceholderBuilder::getProposals,
				boldFont, foreground, background, true);
		
		// Listen to model changes:
		Codebricks codebricks = placeholderBrick.getCodebrick().getCodebricks();
		
		Adapter modelListener = CodebricksUtil.onObjectPlaceholderSelected(codebricks, (selectedPlaceholder) -> {
			
			// FIXME: This listener should be already removed after disposing the control!
			if (placeholderControl.isDisposed()) {
				return;
			}
			
			if (selectedPlaceholder == placeholderBrick) {
				editor.update(() -> {
					
					// Is parameter currently visibly in template?
					if ((placeholderControl != null) && (!placeholderControl.isDisposed())) {
						
						// Icon:
						if (placeholderBrick.getElement() != null) {
							icon.setImage((Image) ItemProviderUtil.getImageByObject(placeholderBrick.getElement()));
							icon.setVisible(true);
						} else {
							icon.setVisible(false);
						}
						
						// Text:
						placeholderControl.setText(ItemProviderUtil.getTextByObject(placeholderBrick.getElement()));
						
						// Domain:
						placeholderBrick.getDomain().assignObject(placeholderBrick, placeholderBrick.getElement());
					}
				});
			} else {
				
				// Auto-select object placeholder:
				autoSelect(placeholderBrick);
			}
		});
		
		// Remove model change listener from model when disposing the control:
		placeholderWithIcon.addDisposeListener(new DisposeListener() {
			
			@Override
			public void widgetDisposed(DisposeEvent e) {
				CodebricksEditor.executeCommand(placeholderBrick, () -> {
					
					if (modelListener.getTarget() != null) {
						modelListener.getTarget().eAdapters().remove(modelListener);
					}
					
					// Unset the old selection!
					placeholderBrick.setElement(null);
				});
			}
		});
		
		autoSelect(placeholderBrick);
		return placeholderWithIcon;
	}

	private static void autoSelect(ObjectPlaceholderBrick placeholderBrick) {
		List<EObject> currentDomain = placeholderBrick.getDomain().getDomain(placeholderBrick);

		if (currentDomain.size() == 1) {
			
			// Set or update element:
			if (currentDomain.get(0) != placeholderBrick.getElement()) {
				placeholderBrick.setElement(currentDomain.get(0));
			}
		} else if (currentDomain.size() == 0) {
			if (placeholderBrick.getElement() != null) {
				placeholderBrick.setElement(null);
			}
		}
	}
	
	public static List<ICompletionProposal> getProposals(ObjectPlaceholderBrick placeholderBrick) {
		List<ICompletionProposal> proposals = new ArrayList<>();

		if (placeholderBrick.getDomain() != null) {
			for (EObject element : placeholderBrick.getDomain().getDomain(placeholderBrick)) {
				ObjectCodebricksProposal codebricksProposal = new ObjectCodebricksProposal(placeholderBrick, element);
				proposals.add(codebricksProposal);
			}
		}
		
		return proposals;
	}
}

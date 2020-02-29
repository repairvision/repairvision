package org.sidiff.completion.ui.codebricks.editor.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.swt.custom.ExtendedModifyEvent;
import org.eclipse.swt.custom.ExtendedModifyListener;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.sidiff.completion.ui.codebricks.Codebricks;
import org.sidiff.completion.ui.codebricks.ValuePlaceholderBrick;
import org.sidiff.completion.ui.codebricks.editor.CodebricksEditor;
import org.sidiff.completion.ui.codebricks.editor.proposals.ValueCodebricksProposal;
import org.sidiff.completion.ui.codebricks.util.CodebricksUtil;
import org.sidiff.completion.ui.proposals.ICompletionProposal;

public class ValuePlaceholderBuilder {

	public static StyledText build(
			CodebricksEditor editor, Composite templateExpression, ValuePlaceholderBrick placeholderBrick, 
			boolean boldFont, Color foreground, Color background) {
		
		// Create view:
		StyledText placeholderControl = PlaceholderBuilder.build(
				editor, templateExpression, placeholderBrick,
				ValuePlaceholderBuilder::getProposals,
				boldFont, foreground, background, true);
		
		// Listen to text input:
		String placeholderValue = placeholderControl.getText();
		placeholderControl.addExtendedModifyListener(new ExtendedModifyListener() {
			
			private int oldTime = -1;
			
			@Override
			public void modifyText(ExtendedModifyEvent event) {
				
				if (event.time != oldTime) {
					this.oldTime = event.time;
					
					// Replace placeholder with text input:
					if (!placeholderControl.getText().isEmpty()) {
						String newValue = placeholderControl.getText();
						String oldValue = newValue.substring(0, event.start) + newValue.substring(event.start + event.length, placeholderControl.getText().length());
						
						if (!oldValue.equals(newValue)) {
							if (oldValue.equals(placeholderValue)) {
								String addedText = newValue.substring(event.start, event.start + event.length);
								placeholderControl.setText(addedText);
								placeholderControl.setCaretOffset(addedText.length()); // text cursor behind added text
								
								editor.update();
							}
						}
					}
					
					// Set input as literal value (before converting it to an instance value):
					if (!placeholderControl.getText().equals(placeholderBrick.getLiteralValue())) {
						CodebricksEditor.executeCommand(placeholderBrick, () -> {
							
							// FIXME: Escape sequence for placeholder...
							if (placeholderControl.getText().equals(placeholderBrick.getPlaceholder())) {
								placeholderBrick.setByLiteralValue(null);
							} else {
								placeholderBrick.setByLiteralValue(placeholderControl.getText());
							}
						});
					}
				}
			}
		});
		
		// Auto-select value placeholder:
		Codebricks codebricks = placeholderBrick.getCodebrick().getCodebricks();
		
		Adapter modelListener = CodebricksUtil.onValuePlaceholderSelected(codebricks, (selectedPlaceholder) -> {
			
			// FIXME: This listener should be already removed after disposing the control!
			if (placeholderControl.isDisposed()) {
				return;
			}
			
			if (selectedPlaceholder != placeholderBrick) {
				String selectedLiteral = selectedPlaceholder.getLiteralValue();
				String currentLiteral = placeholderBrick.getLiteralValue();
				
				if (selectedPlaceholder.getName().equals(placeholderBrick.getName())) {
					if ((selectedLiteral == null) || !selectedLiteral.equals(currentLiteral)) {
						editor.update(() -> {
							autoSelect(placeholderBrick, placeholderControl);
						}); 
					}
				}
			}
		});
		
		// Remove model change listener from model when disposing the control:
		placeholderControl.addDisposeListener(new DisposeListener() {
			
			@Override
			public void widgetDisposed(DisposeEvent e) {
				CodebricksEditor.executeCommand(placeholderBrick, () -> {
					
					if (modelListener.getTarget() != null) {
						modelListener.getTarget().eAdapters().remove(modelListener);
					}
					
					// Unset the old selection!
					placeholderBrick.setInstanceValue(null);
					placeholderBrick.setLiteralValue(null);
				});
			}
		});
		
		autoSelect(placeholderBrick, placeholderControl);
		return placeholderControl;
	}

	private static void autoSelect(ValuePlaceholderBrick placeholderBrick, StyledText placeholderControl) {
		// Check domain:
		List<Object> currentDomain = placeholderBrick.getDomain().getDomain(placeholderBrick);
		
		if (currentDomain.size() == 1) {
			
			// Set or update element:
			if (!currentDomain.get(0).equals(placeholderBrick.getInstanceValue())) {
				placeholderBrick.setByInstanceValue(currentDomain.get(0));
				placeholderControl.setText(placeholderBrick.getLiteralValue());
			}
		} else if (currentDomain.size() == 0) {
			if (placeholderBrick.getInstanceValue() != null) {
				placeholderBrick.setByInstanceValue(null);
				placeholderControl.setText("");
			}
		}
	}
	
	public static List<ICompletionProposal> getProposals(ValuePlaceholderBrick placeholderBrick) {
		List<ICompletionProposal> proposals = new ArrayList<>();
		
		if (placeholderBrick.getDomain() != null) {
			for (Object value : placeholderBrick.getDomain().getDomain(placeholderBrick)) {
				ValueCodebricksProposal codebricksProposal = new ValueCodebricksProposal(placeholderBrick, value);
				proposals.add(codebricksProposal);
			}
		}
		
		return proposals;
	}
}

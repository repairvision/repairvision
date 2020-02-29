package org.sidiff.completion.ui.codebricks.editor.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BidiSegmentEvent;
import org.eclipse.swt.custom.BidiSegmentListener;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.sidiff.completion.ui.codebricks.editor.CodebricksEditor;
import org.sidiff.completion.ui.codebricks.editor.views.util.FontUtil;

public class EditableTextBrickBuilder {
	
	public static StyledText build(
			CodebricksEditor editor, Composite parent, String text, String placeholder, 
			boolean boldFont, Color foreground, Color background) {
		
		if (text == null) {
			text = "null";
		}
		
		StyledText textBrick = new StyledText(parent, SWT.SINGLE);
		textBrick.setText(text);
		textBrick.setForeground(foreground);
		textBrick.setBackground(background);

		if (boldFont) {
			textBrick.setFont(FontUtil.getFontBold(textBrick));
		}
		
		// Update size of shell and text field according to the text input:
		// NOTE: The text sometimes flickers (on Windows) when using the modified listener instead.
		textBrick.addBidiSegmentListener(new BidiSegmentListener() {
			
			private int oldTime = -1;
			
			@Override
			public void lineGetSegments(BidiSegmentEvent event) {
				
				// Handle event just once:
				if (event.time != oldTime) {
					oldTime = event.time;
					
					// Do shell layout:
					editor.update();
					
					// Make sure text field is updated:
					textBrick.pack(true);
				}
			}
		});
		
		// Show placeholder if no text is set:
		textBrick.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				
				if (textBrick.getText().isEmpty()) {
					textBrick.setText(placeholder);
					
					// Do shell layout:
					editor.update();
					
					// Make sure text field is updated:
					textBrick.pack(true);
				}
			}
		});
		
		return textBrick;		
	}
}

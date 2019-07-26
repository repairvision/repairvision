package org.sidiff.completion.ui.codebricks.editor.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.sidiff.completion.ui.codebricks.editor.views.util.FontUtil;

public class TextBrickBuilder {

	public static Label build(Composite parent, String text, String placeholder, boolean boldFont, Color foreground, Color background) {
		
		if (text == null) {
			text = "null";
		}
		
		Label textBrick = new Label(parent, SWT.NONE);
		textBrick.setText(text);
		textBrick.setBackground(background);
		textBrick.setForeground(foreground);

		if (boldFont) {
			textBrick.setFont(FontUtil.getFontBold(textBrick));
		}
		
		return textBrick;
	}
}

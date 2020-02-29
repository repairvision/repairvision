package org.sidiff.completion.ui.codebricks.editor.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;

public class BrickRowBuilder {

	public static Composite build(Composite parent, Color background) {
		return build(parent, 0, 0, background, SWT.NONE);
	}
	
	public static Composite build(Composite parent, int marginLeft, int marginRight,  Color background, int style) {
		Composite brickRow = new Composite(parent, style);
		brickRow.setBackground(background);
		
		RowLayout layout = new RowLayout(SWT.HORIZONTAL);
		{
			layout.spacing = 0;
			layout.marginTop = 0;
			layout.marginRight = marginRight;
			layout.marginLeft = marginLeft;
			layout.marginBottom = 0;
		}
		brickRow.setLayout(layout);
		
		return brickRow;
	}
}

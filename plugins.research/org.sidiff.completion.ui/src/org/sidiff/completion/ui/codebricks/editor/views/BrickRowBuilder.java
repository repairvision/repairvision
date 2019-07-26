package org.sidiff.completion.ui.codebricks.editor.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;

public class BrickRowBuilder {

	public static Composite build(Composite parent, Color background) {
		Composite brickRow = new Composite(parent, SWT.NONE);
		brickRow.setBackground(background);
		
		RowLayout layout = new RowLayout(SWT.HORIZONTAL);
		{
			layout.spacing = 0;
			layout.marginTop = 0;
			layout.marginRight = 0;
			layout.marginLeft = 0;
			layout.marginBottom = 0;
		}
		brickRow.setLayout(layout);
		
		return brickRow;
	}
}

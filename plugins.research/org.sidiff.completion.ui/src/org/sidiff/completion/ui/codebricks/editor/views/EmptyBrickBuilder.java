package org.sidiff.completion.ui.codebricks.editor.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class EmptyBrickBuilder {
	
	public static Label build(Composite parent) {
		return new Label(parent, SWT.NONE);
	}
}

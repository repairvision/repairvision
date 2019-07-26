package org.sidiff.completion.ui.codebricks.editor.views.util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Control;

public class FontUtil {

	public static Font getFontBold(Control control) {
		FontData fontData = control.getFont().getFontData()[0];
		return new Font(control.getDisplay(), new FontData(fontData.getName(), fontData.getHeight(), SWT.BOLD));
	}
}

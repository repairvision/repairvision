package org.sidiff.integration.editor.highlighting.internal.gmf;

import org.eclipse.gmf.runtime.notation.View;

public interface DecorationHook {

	public void onViewWillBeDecorated(View view);

}

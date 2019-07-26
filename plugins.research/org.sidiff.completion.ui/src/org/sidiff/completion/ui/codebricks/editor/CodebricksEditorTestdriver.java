package org.sidiff.completion.ui.codebricks.editor;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.sidiff.completion.ui.Activator;
import org.sidiff.completion.ui.codebricks.Codebricks;

public class CodebricksEditorTestdriver implements IApplication {

	/**
	 * Eclipse: Test driver.
	 */
	@Override
	public Object start(IApplicationContext context) throws Exception {
		
		try {
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource resource = resourceSet.getResource(URI.createPlatformPluginURI(Activator.PLUGIN_ID + "/model/TESTDATA.xmi", true), true);
			Codebricks codebricks = (Codebricks) resource.getContents().get(0);
			
			Display display = PlatformUI.createDisplay();
			
			CodebricksEditor editor = new CodebricksEditor(display);
			editor.setContent(codebricks);
			editor.setContent(codebricks);
			editor.showPopupOnCursor();

			while (!editor.getShell().isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void stop() {
	}
}

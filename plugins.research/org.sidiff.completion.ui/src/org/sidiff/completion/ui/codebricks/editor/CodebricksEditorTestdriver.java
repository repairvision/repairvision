package org.sidiff.completion.ui.codebricks.editor;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
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

	/**
	 * Java: Test driver.
	 */
	public static void main(String args[]) {
		
		try {
			Display display = Display.getDefault();
			CodebricksEditor editor = new CodebricksEditor(display) {
				
				protected Image loadIcon(String localPath) {
					return new Image(Display.getDefault(), new File("").getAbsolutePath() + "/../org.sidiff.completion.ui" + localPath);
				}
				
				@Override
				protected int getColumns() {
					return 2;
				}
				
				@Override
				protected void buildContent(Composite editorContent) {
					Composite brickRow_1 = buildBrickRow(editorContent);
					
					buildEditableTextBrick(brickRow_1, "Hallo", "[+]", true, new Color(Display.getDefault(), new RGB(255, 0, 0)));
					buildEditableTextBrick(brickRow_1, "Welt", "[?]");
					
					buildTextBrick(brickRow_1, "Hallo", "[+]", true,  new Color(Display.getDefault(), new RGB(255, 0, 0)));
					buildTextBrick(brickRow_1, "Welt", "[?]");
					
					buildEditableTextBrick(editorContent, "Hallo", "[+]", true, new Color(Display.getDefault(), new RGB(255, 0, 0)));
					buildEmptyBrick(editorContent);
					buildEditableTextBrick(editorContent, "Welt", "[?]");
				}
			};
			
			editor.showPopupOnCursor();
			
			while (!editor.getShell().isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

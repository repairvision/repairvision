package org.sidiff.completion.ui.codebricks;

import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.SegmentEvent;
import org.eclipse.swt.events.SegmentListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class CodebricksEditor {

	private Shell editorShell;
	
	private ScrolledComposite scrolledEditor;
	
	private Composite editorContent;
	
	private Label moveControlSeparator;
	
	private Composite toolbarContainer;
	
	private ToolBar toolBar;
	
	private int maxWidth = 600;
	
	private Color COLOR_WHITE;
	
	private Color COLOR_BLACK;
	
    /**
     * Mouse down event which starts the moving of the UI.
     */
    private Boolean moveMouseDown = false;
    
    /**
     * Start X Position for moving the UI.
     */
    private int moveXPosition = 0;
    
    /**
     * Start Y Position for moving the UI.
     */
    private int moveYPosition = 0;
    
	public CodebricksEditor(Display display) {
		display.syncExec(new Runnable() {

			@Override
			public void run() {
				createPopup(display);
			}
		});
	}
  
	public void showPopupOnCursor() {
		PointerInfo mousePositionInfo = MouseInfo.getPointerInfo();
		int mousePositionX = mousePositionInfo.getLocation().x;
		int mousePositionY = mousePositionInfo.getLocation().y;
		Point mousePosition = new Point(mousePositionX, mousePositionY);
		
		showPopup(mousePosition);
	}

	/**
	 * @param position The position on which the UI will be opened.
	 */
	public void showPopup(Point position) {
		
		/*
		 * Layout shell
		 */
		{
			GridLayout layout = new GridLayout(1, false);
			{
				layout.verticalSpacing = 0;
				layout.marginWidth = 0;
				layout.marginHeight = 0;
				layout.horizontalSpacing = 0;
			}
			editorShell.setBackground(COLOR_WHITE);
			editorShell.setLayout(layout);
			editorShell.setLocation(position);
		}
		
		/*
		 * Layout editor:
		 */
		
		// Editor scroll pane:
		{
			scrolledEditor.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
			scrolledEditor.setBackground(COLOR_WHITE);
			scrolledEditor.setShowFocusedControl(true);
			scrolledEditor.setExpandHorizontal(true);
			scrolledEditor.setExpandVertical(true);
		}
		
		// Editor content:
		{
			editorContent.setBackground(COLOR_WHITE);
			GridLayout layout = new GridLayout();	
			{
				layout.makeColumnsEqualWidth = false;
				layout.horizontalSpacing = 0;
				layout.marginHeight = 0;
				layout.marginWidth = 0;
				layout.verticalSpacing = 0;
				layout.numColumns = 2; // TODO
			}
			editorContent.setLayout(layout);
		}
		
		/*
		 * Create toolbar:
		 */
		
		// Toolbar container:
		{
			toolbarContainer.setBackground(COLOR_WHITE);
			GridLayout layout = new GridLayout(1, false);
			{
				layout.marginBottom = 5;
				layout.marginRight = 5;
				layout.marginWidth = 0;
				layout.marginHeight = 0;
				layout.horizontalSpacing = 0;
			}
			toolbarContainer.setLayout(layout);
			toolbarContainer.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		}
		
		// Toolbar:
		{
			toolBar.setBackground(COLOR_WHITE);
		}
		
		/*
		 * Open the editor:
		 */
		
		// Calculate editor size:
		Point editorShellSize = editorShell.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		
		if (editorShellSize.x < maxWidth) {
			editorShell.setSize(editorShellSize);
		} else {
			editorShell.setSize(maxWidth, editorShellSize.y);
		}
		
		// Layout and open editor:
		editorShell.pack(true);
		editorShell.layout(true);
		editorShell.open();
	}
	
	private void createPopup(Display display) {
		
		/*
		 *  Globals:
		 */
		COLOR_WHITE = display.getSystemColor(SWT.COLOR_WHITE);
		COLOR_BLACK = display.getSystemColor(SWT.COLOR_BLACK);
		
		/*
		 * Create shell
		 */
		editorShell = new Shell(display, SWT.ON_TOP | SWT.RESIZE);
		
		/*
		 * Create editor:
		 */
		scrolledEditor = new ScrolledComposite(editorShell, SWT.H_SCROLL | SWT.V_SCROLL);
		editorContent = new Composite(scrolledEditor, SWT.NONE);

		/*
		 * TODO: Create editor content:
		 */
		Composite brickRow_1 = buildBrickRow(editorContent);
		
		buildEditableTextBrick(brickRow_1, "Hallo", "[+]", true, new Color(display, new RGB(255, 0, 0)));
		buildEditableTextBrick(brickRow_1, "Welt", "[?]");
		
		buildTextBrick(brickRow_1, "Hallo", "[+]", true,  new Color(display, new RGB(255, 0, 0)));
		buildTextBrick(brickRow_1, " Welt", "[?]");
		
		buildEditableTextBrick(editorContent, "Hallo", "[+]", true, new Color(display, new RGB(255, 0, 0)));
		new Label(editorContent, SWT.NONE);
		buildEditableTextBrick(editorContent, "Welt", "[?]");
		
		/*
		 *  Show a vertical separator as control for dragging the shell:
		 */
		moveControlSeparator = new Label(editorShell, SWT.SEPARATOR | SWT.HORIZONTAL);
		{
			moveControlSeparator.setBackground(COLOR_WHITE);
			
			// Space for dragging:
			GridData layout = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
			{
				layout.heightHint = 10;
				layout.minimumHeight = 10;
			}
			moveControlSeparator.setLayoutData(layout);
			
			// Cursor for dragging:
			moveControlSeparator.setCursor(new Cursor(display, SWT.CURSOR_SIZEALL));
			
			// Start moving the shell:
			moveControlSeparator.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseUp(MouseEvent e) {
					moveMouseDown = false;
				}
				
				@Override
				public void mouseDown(MouseEvent e) {
					moveMouseDown = true;
					moveXPosition = e.x;
					moveYPosition = e.y;
				}
				
				@Override
				public void mouseDoubleClick(MouseEvent e) {}
			});
			
			// Calculate the moving of the shell:
			moveControlSeparator.addMouseMoveListener(new MouseMoveListener() {
				
				@Override
				public void mouseMove(MouseEvent e) {
					if(moveMouseDown){
						int moveToX = editorShell.getLocation().x + (e.x - moveXPosition);
						int moveToY = editorShell.getLocation().y + (e.y - moveYPosition);
						editorShell.setLocation(moveToX, moveToY);
					}
				}
			});
		}
		
		scrolledEditor.setContent(editorContent);
		scrolledEditor.setMinSize(editorContent.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		/*
		 * Create toolbar:
		 */
		toolbarContainer = new Composite(editorShell, SWT.NONE);
		toolBar = new ToolBar(toolbarContainer, SWT.FLAT | SWT.RIGHT);
		{
			createToolbarActions(toolBar);
		}
	}
	
	private void createToolbarActions(ToolBar toolBar) {
		
		/*
		 * Close action:
		 */
		ToolItem actionClose = new ToolItem(toolBar, SWT.NONE);
		actionClose.setImage(new Image(Display.getDefault(), new File("").getAbsolutePath() + "/../org.sidiff.completion.ui/icons/close.png" )); // TODO
		
		actionClose.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				editorShell.close();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
	}
	
	private Composite buildBrickRow(Composite parent) {
		Composite brickRow = new Composite(parent, SWT.NONE);
		brickRow.setBackground(COLOR_WHITE);
		
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

	private Label buildTextBrick(Composite parent, String text, String placeholder) {
		return buildTextBrick(parent, text, placeholder, false, null);
	}
	
	private Label buildTextBrick(Composite parent, String text, String placeholder, boolean boldFont, Color color) {
		Label textBrick = new Label(parent, SWT.NONE);
		textBrick.setText(text);
		textBrick.setBackground(COLOR_WHITE);
		
		if (color != null) {
			textBrick.setForeground(color);
		} else {
			textBrick.setForeground(COLOR_BLACK);
		}

		if (boldFont) {
			textBrick.setFont(getFontBold(textBrick));
		}
		
		return textBrick;
	}
	
	private Text buildEditableTextBrick(Composite parent, String text, String placeholder) {
		return buildEditableTextBrick(parent, text, placeholder, false, null);
	}
	
	private Text buildEditableTextBrick(Composite parent, String text, String placeholder, boolean boldFont, Color color) {
		Text textBrick = new Text(parent, SWT.NONE);
		textBrick.setText(text);
		textBrick.setBackground(COLOR_WHITE);
		
		if (color != null) {
			textBrick.setForeground(color);
		} else {
			textBrick.setForeground(COLOR_BLACK);
		}

		if (boldFont) {
			textBrick.setFont(getFontBold(textBrick));
		}

		textBrick.addSegmentListener(new SegmentListener() {

			@Override
			public void getSegments(SegmentEvent event) {
				
				// Resize editor to fit content:
				Point newSize = editorShell.computeSize(SWT.DEFAULT, SWT.DEFAULT);

				// ... up to limit:
				if (newSize.x < maxWidth) {
					editorShell.setSize(newSize);
				}

				// Make sure text field is updated:
				textBrick.pack(true);

				// Update scroll area:
				editorContent.pack(true);
				scrolledEditor.setMinSize(editorContent.computeSize(SWT.DEFAULT, SWT.DEFAULT));

				// Show placeholder if no text is set:
				if (textBrick.getText().isEmpty()) {
					textBrick.setText(placeholder);
				}
			}
		});
		
		return textBrick;
	}
	
	private Font getFontBold(Control control) {
		FontData fontData = control.getFont().getFontData()[0];
		return new Font(editorShell.getDisplay(), new FontData(fontData.getName(), fontData.getHeight(), SWT.BOLD));
	}
	
	public Shell getShell() {
		return editorShell;
	}
	
	/**
	 * Entry point for WindowBuilder.
	 * 
	 * @wbp.parser.entryPoint
	 */
	@SuppressWarnings("unused")
	private void createShell(Display display) {
		createPopup(display);
		showPopupOnCursor();
	}

	/**
	 * Test driver.
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			CodebricksEditor editor = new CodebricksEditor(display);
			
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

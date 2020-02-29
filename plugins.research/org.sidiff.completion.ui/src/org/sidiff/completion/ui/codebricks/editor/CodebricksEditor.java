package org.sidiff.completion.ui.codebricks.editor;

import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.PlatformUI;
import org.sidiff.completion.ui.Activator;
import org.sidiff.completion.ui.codebricks.Brick;
import org.sidiff.completion.ui.codebricks.Codebrick;
import org.sidiff.completion.ui.codebricks.Codebricks;
import org.sidiff.completion.ui.codebricks.CodebricksFactory;
import org.sidiff.completion.ui.codebricks.POJOCodebrickView;
import org.sidiff.completion.ui.codebricks.editor.views.ContentBuilder;
import org.sidiff.completion.ui.codebricks.util.CodebricksUtil;
import org.sidiff.completion.ui.proposals.ICompletionProposal;

public class CodebricksEditor {

	private Shell editorShell;
	
	private ScrolledComposite scrolledEditor;
	
	private Composite editorContent;
	
	private Label moveControlSeparator;
	
	private Composite toolbarContainer;
	
	private ToolBar toolBar;
	
	private ToolItem actionApply;
	
	private ToolItem actionClose;
	
	private int maximumWidth = 900;
	
	private Color COLOR_WHITE;
	
	private Color COLOR_BLACK;
	
	private Color COLOR_HIDE;
	
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
    
    /**
     * Content:
     */
    private Codebricks codebricks;
    
    private TransactionalEditingDomain editingDomain;
    
    private List<Adapter> codebricksAdapters = new ArrayList<>();
    
    public CodebricksEditor() {
    	this(PlatformUI.getWorkbench().getDisplay());
	}
    
	public CodebricksEditor(Display display) {
		display.syncExec(new Runnable() {

			@Override
			public void run() {
				createPopup(display);
			}
		});
	}
	
	public void setContent(Codebricks input) {
		
		// Clean up old content:
		removeContentListener();
		
		// Set new content:
		this.codebricks = input;
		initializeEditingDomain();
		
		// Create editor content:
		if (input != null) {
			CodebricksEditor.executeCommand(input, () -> {
				ContentBuilder.build(this, editorContent, getTemplate(), COLOR_BLACK, COLOR_WHITE, COLOR_HIDE);
			});
		}
		
		// Wait for placeholders to be selected:
		codebricksAdapters.add(CodebricksUtil.onAlternativeChosen(codebricks, this::onAlternativeChosen));
	}
	
	private void removeContentListener() {
		
		// Remove model listener:
		if (codebricks != null) {
			for (Adapter codebricksAdapter : codebricksAdapters) {
				if (codebricksAdapter.getTarget() != null) {
					codebricksAdapter.getTarget().eAdapters().remove(codebricksAdapter);
				}
			}
			codebricksAdapters.clear();
		}
	}
	
	public Codebricks getContent() {
		
		// Use empty input:
		if (codebricks == null) {
			codebricks = CodebricksFactory.eINSTANCE.createCodebricks();
		}
		
		return codebricks;
	}
	
	protected void initializeEditingDomain() {
		editingDomain = getEditingDomain(codebricks);
		
		if (editingDomain == null) {
			
			// Create the editing domain with a special command stack.
			if (codebricks.eResource() == null) {
				Resource resource = new ResourceSetImpl().createResource(URI.createURI(""));
				resource.getContents().add(codebricks);
			}
			
			editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(codebricks.eResource().getResourceSet());
		}
	}
	
	public static TransactionalEditingDomain getEditingDomain(EObject element) {
		TransactionalEditingDomain transactionalEditingDomain = TransactionUtil.getEditingDomain(element);
		
		if (transactionalEditingDomain == null) {
			EditingDomain editingDomain =  AdapterFactoryEditingDomain.getEditingDomainFor(element);
			
			if (editingDomain instanceof TransactionalEditingDomain) {
				return (TransactionalEditingDomain) editingDomain;
			}
		}
		
		return transactionalEditingDomain;
	}
	
	public static RecordingCommand executeCommand(EObject element, Runnable command) {
		TransactionalEditingDomain editingDomain = getEditingDomain(element);
		RecordingCommand recordingCommand = new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				Display.getDefault().syncExec(command);
			}
		};
		editingDomain.getCommandStack().execute(recordingCommand);
		return recordingCommand;
	}
	
	public static void undoCommand(EObject element, RecordingCommand command) {
		TransactionalEditingDomain editingDomain = getEditingDomain(element);
		
		if (editingDomain.getCommandStack().getUndoCommand() == command) {
			editingDomain.getCommandStack().undo();
		}
	}
	
	public List<Brick> getTemplate() {
		if (getContent().getTemplate() != null) {
			return getContent().getTemplate().getBricks();
		}
		return Collections.emptyList();
	}
	
	public int getMaximumWidth() {
		return maximumWidth;
	}
	
	public void setMaximumWidth(int maximumWidth) {
		this.maximumWidth = maximumWidth;
	}
  
	public void showPopupOnCursor() {
		PointerInfo mousePositionInfo = MouseInfo.getPointerInfo();
		int mousePositionX = mousePositionInfo.getLocation().x;
		int mousePositionY = mousePositionInfo.getLocation().y;
		Point mousePosition = new Point(mousePositionX, mousePositionY);
		
		showPopup(mousePosition);
		
		// Make sure size depends on the content:
		update();
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
				layout.marginRight = 0;
				layout.marginLeft = 0;
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
				layout.marginLeft = 10;
				layout.marginRight = 10;
				layout.marginTop = 5;
				layout.marginBottom = 5;
				layout.verticalSpacing = 0;
				layout.numColumns = getColumns();
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
				layout.marginWidth = 0;
				layout.marginHeight = 0;
				layout.marginBottom = 5;
				layout.marginLeft = 5;
				layout.marginRight = 5;
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
		
		if (editorShellSize.x < maximumWidth) {
			editorShell.setSize(editorShellSize);
		} else {
			editorShell.setSize(maximumWidth, editorShellSize.y);
		}
		
		// Layout and open editor:
		editorShell.pack(true);
		editorShell.layout(true);
		editorShell.open();
		
		// Make sure size depends on the content:
		update();
	}
	
	private void createPopup(Display display) {
		
		/*
		 *  Globals:
		 */
		COLOR_WHITE = display.getSystemColor(SWT.COLOR_WHITE);
		COLOR_BLACK = display.getSystemColor(SWT.COLOR_BLACK);
		COLOR_HIDE = new Color(display, 160, 160, 160);
		
		/*
		 * Create shell
		 */
		editorShell = new Shell(display, SWT.ON_TOP | SWT.RESIZE);
		{
			editorShell.addDisposeListener(new DisposeListener() {
				
				@Override
				public void widgetDisposed(DisposeEvent e) {
					removeContentListener();
				}
			});
		}
		
		/*
		 * Create editor:
		 */
		scrolledEditor = new ScrolledComposite(editorShell, SWT.H_SCROLL | SWT.V_SCROLL);

		/*
		 * Create editor content:
		 */
		editorContent = new Composite(scrolledEditor, SWT.NONE);
		
		if (!getTemplate().isEmpty()) {
			CodebricksEditor.executeCommand(getContent(), () -> {
				ContentBuilder.build(this, editorContent, getTemplate(), COLOR_BLACK, COLOR_WHITE, COLOR_HIDE);
			});
		}
		
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
	
	protected void createToolbarActions(ToolBar toolBar) {
		
		/*
		 * Apply action:
		 */
		actionApply = new ToolItem(toolBar, SWT.NONE);
		actionApply.setImage(loadIcon("/icons/apply.png" ));
		
		actionApply.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				onApplyAlternative();
				editorShell.close();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
		actionApply.setEnabled(false);
		
		/*
		 * Close action:
		 */
		actionClose = new ToolItem(toolBar, SWT.NONE);
		actionClose.setImage(loadIcon("/icons/close.png" ));
		
		actionClose.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				editorShell.close();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
	}
	
	protected Image loadIcon(String localPath) {
		return Activator.getIcon(localPath);
	}
	
	protected int getColumns() {
		if (getContent().getTemplate() != null) {
			return getContent().getTemplate().caluclateColumns();
		} else {
			return 0;
		}
	}
	
	protected void onAlternativeChosen(Codebrick choice) {
		actionApply.setEnabled(true);
	}
	
	protected Codebrick getChosenAlternative() {
		if (codebricks.isChosen()) {
			List<Codebrick> choise = codebricks.getChoice();
			
			if (choise.size() == 1) {
				return choise.get(0);
			}
		}
		return null;
	}
	
	protected void onApplyAlternative() {
		Codebrick applied = getChosenAlternative();

		if (applied instanceof POJOCodebrickView) {
			Object model = ((POJOCodebrickView) applied).getModel();

			if (model instanceof ICompletionProposal) {
				((ICompletionProposal) model).apply();
			}
		}
	}
	
	public void update() {
		update(true, true, null);
	}
	
	public void update(Runnable update) {
		update(true, false, update);
	}
	
	public void update(boolean changed, boolean resize, Runnable update) {
		editorShell.setRedraw(false);
		
		if (resize) {
			
			// Resize editor to fit content:
			Point newSize = editorShell.computeSize(SWT.DEFAULT, SWT.DEFAULT);
			
			// ... up to limit:
			if (newSize.x > maximumWidth) {
				newSize.x = maximumWidth;
			}
			
			// Do not shrink the editor:
			// NOTE: Results in some disturbing flickering on preview (apply) / hide preview (undo).
			if (newSize.x > editorShell.getSize().x) {
				editorShell.setSize(newSize);
			}
		}
		
		// Perform UI update:
		if (update != null) {
			update.run();
		}

		// Update scroll area:
		editorContent.pack(changed);
		
		if (resize) {
			scrolledEditor.setMinSize(editorContent.computeSize(SWT.DEFAULT, SWT.DEFAULT));
			editorContent.layout(changed);
		}
		
		editorShell.setRedraw(true);
		
		// FOR UI UPDATE DEBUGING
//		System.out.println(dumpController(editorContent));
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

	@SuppressWarnings("unused")
	private String dumpController(Composite composite) {
		StringBuilder dump = new StringBuilder();
		dumpController(composite, dump);
		return dump.toString();
	}
	
	private void dumpController(Composite composite, StringBuilder dump) {
		for (Control child : composite.getChildren()) {
			if (child instanceof StyledText) {
				dump.append("{");
				dump.append(((StyledText) child).getText());
				dump.append("}");
			}
			
			else if (child instanceof Composite) {
				dumpController((Composite) child, dump);
			} 

			else if (child instanceof Label) {
				dump.append("{");
				dump.append(((Label) child).getText());
				dump.append("}");
			}
		}
	}
	
	@SuppressWarnings("unused")
	private String dumpControllerPlain(Composite composite) {
		StringBuilder dump = new StringBuilder();
		dumpControllerPlain(composite, dump);
		return dump.toString();
	}
	
	private void dumpControllerPlain(Composite composite, StringBuilder dump) {
		for (Control child : composite.getChildren()) {
			if (child instanceof StyledText) {
				dump.append(((StyledText) child).getText());
			}
			
			else if (child instanceof Composite) {
				dumpControllerPlain((Composite) child, dump);
			} 

			else if (child instanceof Label) {
				dump.append(((Label) child).getText());
			}
		}
	}
}

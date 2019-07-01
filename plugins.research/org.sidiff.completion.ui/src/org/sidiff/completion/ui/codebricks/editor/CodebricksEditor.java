package org.sidiff.completion.ui.codebricks.editor;

import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EventObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.swt.custom.BidiSegmentEvent;
import org.eclipse.swt.custom.BidiSegmentListener;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.PlatformUI;
import org.sidiff.completion.ui.Activator;
import org.sidiff.completion.ui.codebricks.BlankBrick;
import org.sidiff.completion.ui.codebricks.Brick;
import org.sidiff.completion.ui.codebricks.Codebrick;
import org.sidiff.completion.ui.codebricks.Codebricks;
import org.sidiff.completion.ui.codebricks.CodebricksFactory;
import org.sidiff.completion.ui.codebricks.ComposedBrick;
import org.sidiff.completion.ui.codebricks.IndentBrick;
import org.sidiff.completion.ui.codebricks.LineBreakBrick;
import org.sidiff.completion.ui.codebricks.ObjectPlaceholderBrick;
import org.sidiff.completion.ui.codebricks.POJOCodebrickView;
import org.sidiff.completion.ui.codebricks.PlaceholderBrick;
import org.sidiff.completion.ui.codebricks.StyledBrick;
import org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick;
import org.sidiff.completion.ui.codebricks.TextBrick;
import org.sidiff.completion.ui.codebricks.ValuePlaceholderBrick;
import org.sidiff.completion.ui.codebricks.ViewableBrick;
import org.sidiff.completion.ui.codebricks.editor.proposals.ObjectCodebricksProposal;
import org.sidiff.completion.ui.codebricks.editor.proposals.TemplateCodebricksProposal;
import org.sidiff.completion.ui.codebricks.util.CodebricksUtil;
import org.sidiff.completion.ui.proposals.CompletionProposalList;
import org.sidiff.completion.ui.proposals.ICompletionProposal;
import org.sidiff.graphpattern.edit.util.ItemProviderUtil;
import org.sidiff.consistency.common.monitor.LogUtil;

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
    
    private Map<Brick, Control> modelToViewMap = new HashMap<>();
    
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
		buildContent(editorContent, getTemplate());
		
		// Wait for placeholders to be selected:
		codebricksAdapters.add(CodebricksUtil.onAlternativeChosen(codebricks, this::onAlternativeChosen));
		codebricksAdapters.add(CodebricksUtil.onTemplatePlaceholderSelected(codebricks, this::onTemplatePlaceholderSelected));
		codebricksAdapters.add(CodebricksUtil.onObjectPlaceholderSelected(codebricks, this::onObjectPlaceholderSelected));
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

		// Notify this editor as commands are executed:
		editingDomain.getCommandStack().addCommandStackListener(new CommandStackListener() {
			public void commandStackChanged(final EventObject event) {
				editorShell.getDisplay().asyncExec(new Runnable() {
					public void run() {
						onCommandExecuted(event);
					}
				});
			}
		});
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
		fitToContent();
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
		fitToContent();
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
		buildContent(editorContent, getTemplate());
		
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
	
	protected Composite buildBrickRow(Composite parent) {
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
	
	protected Label buildEmptyBrick(Composite parent) {
		return new Label(editorContent, SWT.NONE);
	}

	protected Label buildTextBrick(Composite parent, String text, String placeholder) {
		return buildTextBrick(parent, text, placeholder, false, null);
	}
	
	protected Label buildTextBrick(Composite parent, String text, String placeholder, boolean boldFont, Color color) {
		
		if (text == null) {
			text = "null";
		}
		
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
	
	protected StyledText buildEditableTextBrick(Composite parent, String text, String placeholder) {
		return buildEditableTextBrick(parent, text, placeholder, false, null);
	}
	
	protected StyledText buildEditableTextBrick(Composite parent, String text, String placeholder, boolean boldFont, Color color) {
		
		if (text == null) {
			text = "null";
		}
		
		StyledText textBrick = new StyledText(parent, SWT.SINGLE);
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
		
		// Update size of shell and text field according to the text input:
		// NOTE: The text sometimes flickers (on Windows) when using the modified listener instead.
		textBrick.addBidiSegmentListener(new BidiSegmentListener() {
			
			private int oldTime = -1;
			
			@Override
			public void lineGetSegments(BidiSegmentEvent event) {
				
				// Handle event just once:
				if (event.time != oldTime) {
					oldTime = event.time;
					
					// Do shell layout:
					fitToContent();
					
					// Make sure text field is updated:
					textBrick.pack(true);
				}
			}
		});
		
		// Show placeholder if no text is set:
		textBrick.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				
				if (textBrick.getText().isEmpty()) {
					textBrick.setText(placeholder);
					
					// Do shell layout:
					fitToContent();
					
					// Make sure text field is updated:
					textBrick.pack(true);
				}
			}
		});
		
		return textBrick;		
	}
	
	private Font getFontBold(Control control) {
		FontData fontData = control.getFont().getFontData()[0];
		return new Font(editorShell.getDisplay(), new FontData(fontData.getName(), fontData.getHeight(), SWT.BOLD));
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
	
	protected void clearContent() {
		Control[] content = editorContent.getChildren();
		
		for (int i = 0; i < content.length; i++) {
			content[i].dispose();
		}
		
		modelToViewMap.clear();
	}
	
	protected void buildContent(Composite editorContent, List<? extends Brick> bricks) {
		buildContent(editorContent, bricks, true);
	}
	
	protected void buildContent(Composite editorContent, List<? extends Brick> bricks, boolean mapModelToView) {
		
		// Is content empty?
		if (editorContent.getChildren().length > 0) {
			clearContent();
		}
		
		// Is input empty?
		if (getContent().getTemplate() == null) {
			return;
		}

		// Create content views:
		Composite templateExpression = null;
		
		for (Brick templateBrick : bricks) {
			Control viewControl = null;
			
			// Handle line break:
			if (templateBrick instanceof LineBreakBrick) {
				templateExpression = null;
			}
			
			// Create indent:
			if (templateBrick instanceof IndentBrick) {
				IndentBrick indentBrick = (IndentBrick) templateBrick;
				
				for (int i = 0; i < indentBrick.getBricks(); i++) {
					viewControl = buildEmptyBrick(editorContent);
				}
			}
			
			else if (templateBrick instanceof ComposedBrick) {
				
				// Put template expression in last column(s):
				if (templateExpression == null) {
					templateExpression = buildBrickRow(editorContent);
				}
				
				Composite composedBrick = buildBrickRow(templateExpression);
				viewControl = composedBrick;
				buildContent(composedBrick, ((ComposedBrick) templateBrick).getBricks());
			}
			
			// Create template expression:
			else if (templateBrick instanceof ViewableBrick) {
				
				// Put template expression in last column(s):
				if (templateExpression == null) {
					templateExpression = buildBrickRow(editorContent);
				}
				
				// Viewable brick:
				ViewableBrick viewableBrick = (ViewableBrick) templateBrick;
				boolean highlight = (viewableBrick instanceof StyledBrick) && ((StyledBrick) viewableBrick).isHighlight();
				
				/*
				 * Placeholder:
				 */
				
				// Create template placeholder:
				if (templateBrick instanceof TemplatePlaceholderBrick) {
					viewControl = buildBrickRow(templateExpression);
					buildPlaceholder((Composite) viewControl, (PlaceholderBrick) templateBrick);
				
				// Create value placeholder (parameter):
				} else if (templateBrick instanceof ValuePlaceholderBrick) {
					viewControl = buildPlaceholder(templateExpression, (PlaceholderBrick) templateBrick);
					
				// Create object placeholder (parameter):
				} else if (templateBrick instanceof ObjectPlaceholderBrick) {
					viewControl = buildPlaceholder(templateExpression, (PlaceholderBrick) templateBrick);
				}

				/*
				 * Basic bricks:
				 */
				
				// Create text:
				if (viewableBrick instanceof TextBrick) {
					if (highlight) {
						viewControl = buildTextBrick(templateExpression, viewableBrick.getText(), viewableBrick.getText(), true, COLOR_BLACK);
					} else {
						viewControl = buildTextBrick(templateExpression, viewableBrick.getText(), viewableBrick.getText());
					}
					
				// Create blank:
				} else if (viewableBrick instanceof BlankBrick) {
					viewControl = buildTextBrick(templateExpression, viewableBrick.getText(), viewableBrick.getText());
				}
			}
			
			// Store model to view mapping:
			if (mapModelToView && (viewControl != null)) {
				modelToViewMap.put(templateBrick, viewControl);
			}
		}
		
		// Do layout:
		fitToContent();
	}
	
	private StyledText buildPlaceholder(Composite parentContainer, PlaceholderBrick placeholderBrick) {
		StyledText placeholderControl = null;
		
		if (placeholderBrick.isHighlight()) {
			placeholderControl =  buildEditableTextBrick(parentContainer, placeholderBrick.getText(), placeholderBrick.getText(), true, COLOR_BLACK);
		} else {
			placeholderControl =  buildEditableTextBrick(parentContainer, placeholderBrick.getText(), placeholderBrick.getText());
		}
		
		installProposalList(placeholderControl, placeholderBrick);
		
		return placeholderControl;
	}

	private void installProposalList(StyledText placeholderControl, PlaceholderBrick placeholderBrick) {
		
		// Store model in view:
		placeholderControl.setData(placeholderBrick);

		// Show proposal list:
		placeholderControl.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				PlaceholderBrick placeholderBrick = (PlaceholderBrick) e.widget.getData();
				
				if(((e.stateMask & SWT.CTRL) == SWT.CTRL) && (e.keyCode == SWT.SPACE)) {
					List<ICompletionProposal> codebrickProposals = Collections.emptyList();

					if (placeholderBrick instanceof TemplatePlaceholderBrick) {
						codebrickProposals = getProposals((TemplatePlaceholderBrick) placeholderBrick);
					} else if (placeholderBrick instanceof ObjectPlaceholderBrick) {
						codebrickProposals = getProposals((ObjectPlaceholderBrick) placeholderBrick);
					} else if (placeholderBrick instanceof ValuePlaceholderBrick) {
						codebrickProposals = getProposals((ValuePlaceholderBrick) placeholderBrick);
					}

					// Show proposals below editor:
					if (!codebrickProposals.isEmpty()) {
						CompletionProposalList proposals =  new CompletionProposalList(placeholderControl.getDisplay());
						proposals.addProposals(codebrickProposals);
						
						int proposalsXPosition = editorShell.getLocation().x;
						int proposalsYPosition = editorShell.getLocation().y + editorShell.getSize().y + 5;
						proposals.showPopup(new Point(proposalsXPosition, proposalsYPosition));
					}
				}
			}
		});
	}
	
	private List<ICompletionProposal> getProposals(TemplatePlaceholderBrick placeholderBrick) {
		List<ICompletionProposal> proposals = new ArrayList<>();
		
		List<ViewableBrick> remainingChoices = placeholderBrick.getRemainingChoices();
		Set<ViewableBrick> unlistedChoices = new HashSet<>(remainingChoices); 
		
		for (ViewableBrick choice : remainingChoices) {

			// Show equal choices in one proposal:
			if (unlistedChoices.contains(choice)) {
				List<ViewableBrick> equalChoices = new ArrayList<>();

				for (ViewableBrick unlistedChoice : unlistedChoices) {
					if (canCombineProposals(unlistedChoice, choice)) {
						equalChoices.add(unlistedChoice);
					}
				}

				unlistedChoices.removeAll(equalChoices);
				proposals.add(new TemplateCodebricksProposal(placeholderBrick, equalChoices));
			}
		}
		
		return proposals;
	}
	
	protected boolean canCombineProposals(ViewableBrick choiceA, ViewableBrick choiceB) {
		return choiceA.getText().equals(choiceB.getText());
	}
	
	protected boolean canCombineProposals(List<ViewableBrick> choices) {
		for (int i = 0; i < choices.size() - 1; i++) {
			if (!canCombineProposals(choices.get(i), choices.get(i + 1))) {
				return false;
			}
		}
		return true;
	}
	
	private List<ICompletionProposal> getProposals(ObjectPlaceholderBrick placeholderBrick) {
		List<ICompletionProposal> proposals = new ArrayList<>();

		if (placeholderBrick.getDomain() != null) {
			for (EObject element : placeholderBrick.getDomain().getDomain(placeholderBrick)) {
				ObjectCodebricksProposal codebricksProposal = new ObjectCodebricksProposal(placeholderBrick, element);
				proposals.add(codebricksProposal);
			}
		}
		
		return proposals;
	}
	
	private List<ICompletionProposal> getProposals(ValuePlaceholderBrick placeholderBrick) {
		List<ICompletionProposal> proposals = new ArrayList<>();
		// TODO:
		return proposals;
	}
	
	protected void onCommandExecuted(EventObject event) {
		fitToContent();
	}
	
	protected void onObjectPlaceholderSelected(ObjectPlaceholderBrick placeholderBrick) {
		editorShell.setRedraw(false);
		
		StyledText textBrick = (StyledText) modelToViewMap.get(placeholderBrick);
		
		// Is parameter currently visibly in template?
		if ((textBrick != null) && (!textBrick.isDisposed())) {
			textBrick.setText(ItemProviderUtil.getTextByObject(placeholderBrick.getElement()));
			
			placeholderBrick.getDomain().assignObject(placeholderBrick, placeholderBrick.getElement());
			autoSelectObjectPlaceholders(codebricks.getTemplate().getBricks());
		}
		
		editorShell.setRedraw(true);
	}
	
	protected void autoSelectObjectPlaceholders(List<? extends Brick> bricks) {
		try {
			for (Brick brick : bricks) {
				if (brick instanceof PlaceholderBrick) {
					if (brick instanceof TemplatePlaceholderBrick) {
						autoSelectObjectPlaceholders(((TemplatePlaceholderBrick) brick).getChoice());
					} else if (brick instanceof ObjectPlaceholderBrick) {
						ObjectPlaceholderBrick placeholderBrick = (ObjectPlaceholderBrick) brick;
						
						List<EObject> currentDomain = placeholderBrick.getDomain().getDomain(placeholderBrick);

						if (currentDomain.size() == 1) {
							
							// Set or update element:
							if (currentDomain.get(0) != placeholderBrick.getElement()) {
								placeholderBrick.setElement(currentDomain.get(0));
							}
						} else if (currentDomain.size() == 0) {
							if (placeholderBrick.getElement() != null) {
								placeholderBrick.setElement(null);
							}
						}
					}
				} else if (brick instanceof ComposedBrick) {
					autoSelectObjectPlaceholders(((ComposedBrick) brick).getBricks());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void onTemplatePlaceholderSelected(TemplatePlaceholderBrick placeholderBrick) {
		editorShell.setRedraw(false);
		
		if (!placeholderBrick.getChoice().isEmpty()) {
			ViewableBrick showChoice = placeholderBrick.getChoice().get(0);
			Composite placeholderContainer = (Composite) modelToViewMap.get(placeholderBrick);
			
			// Clear container:
			Control[] children = placeholderContainer.getChildren();
			
			for (int i = 0; i < children.length; i++) {
				children[i].dispose();
			}
			
			// Add composed bricks:
			buildContent(placeholderContainer, Collections.singletonList(showChoice), false);
			
			// If this choice is not yet determined disable controls:
			if (placeholderBrick.getChoice().size() > 1) {
				children = placeholderContainer.getChildren();
				
				for (int i = 0; i < children.length; i++) {
					children[i].setEnabled(false);
				}
			}
		} else {
			Composite placeholderContainer = (Composite) modelToViewMap.get(placeholderBrick);
			
			// Clear container:
			Control[] children = placeholderContainer.getChildren();
			
			for (int i = 0; i < children.length; i++) {
				children[i].dispose();
			}
			
			buildPlaceholder(placeholderContainer, placeholderBrick);
			
			// Hide placeholder if no choices are available:
			List<ViewableBrick> choices = placeholderBrick.getRemainingChoices();
			
			if (choices.isEmpty()) {
				hideComposedPlaceholder(placeholderContainer);
			}
		}
		
		autoSelectTemplatePlaceholders(placeholderBrick, codebricks.getTemplate().getBricks());
		autoSelectObjectPlaceholders(codebricks.getTemplate().getBricks());
		
		editorShell.setRedraw(true);
	}
	
	protected void autoSelectTemplatePlaceholders(TemplatePlaceholderBrick selectedPlaceholder, List<? extends Brick> bricks) {
		try {

			// Set choices:
			if ((selectedPlaceholder.getChoice() != null) || (!selectedPlaceholder.getChoice().isEmpty())) {
				for (Brick brick : bricks) {
					if (brick != selectedPlaceholder) {
						if (brick instanceof TemplatePlaceholderBrick) {
							TemplatePlaceholderBrick placeholderBrick = (TemplatePlaceholderBrick) brick;
							List<ViewableBrick> choices = getRemainingChoices(placeholderBrick, selectedPlaceholder);

							if (!choices.equals(placeholderBrick.getChoice())) {
								if (!choices.isEmpty() && canCombineProposals(choices)) {
									if (!placeholderBrick.getChoice().isEmpty()) {
										placeholderBrick.getChoice().clear();
									}
									placeholderBrick.getChoice().addAll(choices);
								} else {
									placeholderBrick.getChoice().retainAll(choices);
								}
							}
							
							if (choices.isEmpty()) {
								hideComposedPlaceholder((Composite) modelToViewMap.get(placeholderBrick));
							}
						} else if (brick instanceof ComposedBrick) {
							autoSelectTemplatePlaceholders(selectedPlaceholder, ((ComposedBrick) brick).getBricks());
						}
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private List<ViewableBrick> getRemainingChoices(
			TemplatePlaceholderBrick placeholderBrick,
			TemplatePlaceholderBrick selectedPlaceholder) {

		// Filter brick choices by current selection of other placeholders:
		EList<ViewableBrick> remaining = new BasicEList<>();

		List<ViewableBrick> superSet = placeholderBrick.getChoice().isEmpty() ? placeholderBrick.getChoices()
				: placeholderBrick.getChoice();

		for (ViewableBrick choice : superSet) {
			if (containsCodebricks(choice.getCodebrick(), selectedPlaceholder.getChoice())) {
				remaining.add(choice);
			}
		}

		return remaining;
	}
	
	private boolean containsCodebricks(Codebrick matchCodebrick, EList<ViewableBrick> inCodebricks) {
		for (ViewableBrick inCodebrick : inCodebricks) {
			if (matchCodebrick == inCodebrick.getCodebrick()) {
				return true;
			}
		}
		return false;
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
	
	private void hideComposedPlaceholder(Composite containerView) {
		for (int i = 0; i < containerView.getChildren().length; i++) {
			Control child = containerView.getChildren()[i];
			hidePlaceholder(child);
			
			if (child instanceof Composite) {
				hideComposedPlaceholder((Composite) child);
			}
		}
	}
	
	private void hidePlaceholder(Control control) {
		control.setForeground(new Color(Display.getDefault(), 160, 160, 160));
		control.setEnabled(false);
	}
	
	protected void fitToContent() {
		editorShell.setRedraw(false);
			
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

		// Update scroll area:
		editorContent.pack(true);
		scrolledEditor.setMinSize(editorContent.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		editorContent.layout(true);
		
		editorShell.setRedraw(true);
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
	private String dumpControllerTree(Composite composite) {
		StringBuilder dump = new StringBuilder();
		dumpControllerTree(composite, dump, 0);
		return dump.toString();
	}
	
	private void dumpControllerTree(Composite composite, StringBuilder dump, int indent) {
		dump.append(LogUtil.repeat(" ", indent));
		dump.append(composite.toString());
		dumpModelByView(dump, composite);
		dump.append("\n");
		
		indent += 2;
		
		for (Control child : composite.getChildren()) {

			if (child instanceof StyledText) {
				dump.append(LogUtil.repeat(" ", indent));
				dump.append("StyledText {");
				dump.append(((StyledText) child).getText());
				dumpModelByView(dump, child);
				dump.append("\n");
			}

			else if (child instanceof Composite) {
				dumpControllerTree((Composite) child, dump, indent);
			}

			else if (child instanceof Label) {
				dump.append(LogUtil.repeat(" ", indent));
				dump.append(child);
				dumpModelByView(dump, child);
				dump.append("\n");
			}
		}
	}
	
	private void dumpModelByView(StringBuilder dump, Control control) {
		String modelDump = modelToViewMap.entrySet().stream().filter(e -> e.getValue() == control).findFirst().map(e -> e.getKey().eClass().getName()).orElse(null);
		
		if (modelDump != null) {
			dump.append(" ~> ");
			dump.append(modelDump);
		}
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

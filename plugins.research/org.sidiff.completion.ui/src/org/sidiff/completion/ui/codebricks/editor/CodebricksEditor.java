package org.sidiff.completion.ui.codebricks.editor;

import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
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
import org.sidiff.completion.ui.codebricks.ComposedTemplatePlaceholderBrick;
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
import org.sidiff.completion.ui.codebricks.util.CodebricksUtil;
import org.sidiff.completion.ui.list.CompletionProposalList;
import org.sidiff.completion.ui.list.ICompletionProposal;

public class CodebricksEditor {

	private Shell editorShell;
	
	private ScrolledComposite scrolledEditor;
	
	private Composite editorContent;
	
	private Label moveControlSeparator;
	
	private Composite toolbarContainer;
	
	private ToolBar toolBar;
	
	private ToolItem actionApply;
	
	private ToolItem actionClose;
	
	private int maximumWidth = 600;
	
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
    
    private Adapter choiceFinishedListener;
    
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
		this.codebricks = input;
		
		// Create editor content:
		buildContent(editorContent, getTemplate());
		
		// Wait for placeholders to be selected:
		choiceFinishedListener = CodebricksUtil.onAlternativeChosen(codebricks, this::onAlternativeChosen);
	}
	
	public Codebricks getContent() {
		
		// Use empty input:
		if (codebricks == null) {
			codebricks = CodebricksFactory.eINSTANCE.createCodebricks();
		}
		
		return codebricks;
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
					
					// Remove model listener:
					if ((codebricks != null) && (choiceFinishedListener != null)) {
						if (choiceFinishedListener.getTarget() != null) {
							choiceFinishedListener.getTarget().eAdapters().remove(choiceFinishedListener);
						}
					}
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
					
					// Make sure text field is updated:
					textBrick.pack(true);
					
					// Do shell layout:
					fitToContent();
				}
			}
		});
		
		// Show placeholder if no text is set:
		textBrick.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				
				if (textBrick.getText().isEmpty()) {
					textBrick.setText(placeholder);
					
					// Make sure text field is updated:
					textBrick.pack(true);
					
					// Do shell layout:
					fitToContent();
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
				Composite parentContainer = null;
				StyledText placeholderControl = null;
				PlaceholderBrick placeholder = null;
				
				// Create template placeholder:
				if (templateBrick instanceof TemplatePlaceholderBrick) {
					placeholder = (TemplatePlaceholderBrick) viewableBrick;
					parentContainer = templateExpression;
					
					if (((TemplatePlaceholderBrick) placeholder).isComposed()) {
						parentContainer = buildBrickRow(templateExpression);
					}
					
					if (highlight) {
						viewControl = placeholderControl = buildEditableTextBrick(parentContainer, viewableBrick.getText(), viewableBrick.getText(), true, COLOR_BLACK);
					} else {
						viewControl = placeholderControl = buildEditableTextBrick(parentContainer, viewableBrick.getText(), viewableBrick.getText());
					}
				// Create value placeholder (parameter):
				} else if (templateBrick instanceof ValuePlaceholderBrick) {
					placeholder = (ValuePlaceholderBrick) viewableBrick;
					parentContainer = templateExpression;
					
					if (highlight) {
						viewControl = placeholderControl = buildEditableTextBrick(templateExpression, viewableBrick.getText(), viewableBrick.getText(), true, COLOR_BLACK);
					} else {
						viewControl = placeholderControl = buildEditableTextBrick(templateExpression, viewableBrick.getText(), viewableBrick.getText());
					}
					
				// Create object placeholder (parameter):
				} else if (templateBrick instanceof ObjectPlaceholderBrick) {
					placeholder = (ObjectPlaceholderBrick) viewableBrick;
					parentContainer = templateExpression;
					
					if (highlight) {
						viewControl = placeholderControl = buildEditableTextBrick(templateExpression, viewableBrick.getText(), viewableBrick.getText(), true, COLOR_BLACK);
					} else {
						viewControl = placeholderControl = buildEditableTextBrick(templateExpression, viewableBrick.getText(), viewableBrick.getText());
					}
				}

				// Show proposal list:
				if ((parentContainer != null) && (placeholderControl != null) && (placeholder != null)) {
					installProposalList(parentContainer, placeholderControl, placeholder);
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
			if (viewControl != null) {
				modelToViewMap.put(templateBrick, viewControl);
			}
		}
		
		// Set focus to first editable text field:
		if (templateExpression != null) {
			for (Control expressionControl : templateExpression.getChildren()) {
				if (expressionControl instanceof StyledText) {
					expressionControl.setFocus();
					break;
				}
			}
		}
		
		// Do layout:
		fitToContent();
	}

	private void installProposalList(Composite parentContainer, StyledText placeholderControl, PlaceholderBrick placeholderBrick) {
		
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
						codebrickProposals = getProposals(parentContainer, placeholderControl, (TemplatePlaceholderBrick) placeholderBrick);
					} else if (placeholderBrick instanceof ObjectPlaceholderBrick) {
						codebrickProposals = getProposals(parentContainer, placeholderControl, (ObjectPlaceholderBrick) placeholderBrick);
					} else if (placeholderBrick instanceof ValuePlaceholderBrick) {
						codebrickProposals = getProposals(parentContainer, placeholderControl, (ValuePlaceholderBrick) placeholderBrick);
					}

					// Show proposals below editor:
					if (!codebrickProposals.isEmpty()) {
						CompletionProposalList proposals =  new CompletionProposalList(parentContainer.getDisplay());
						proposals.addProposals(codebrickProposals);
						
						int proposalsXPosition = editorShell.getLocation().x;
						int proposalsYPosition = editorShell.getLocation().y + editorShell.getSize().y + 5;
						proposals.showPopup(new Point(proposalsXPosition, proposalsYPosition));
					}
				}
			}
		});

		// Update on preview/apply proposal:
		placeholderControl.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {

				// Make sure text field is updated:
				placeholderControl.pack(true);

				// Do shell layout:
				fitToContent();
			}
		});
	}
	
	private List<ICompletionProposal> getProposals(Composite parentContainer, StyledText placeholderControl, TemplatePlaceholderBrick placeholderBrick) {
		List<ICompletionProposal> proposals = new ArrayList<>();
		
		List<ViewableBrick> remainingChoices = placeholderBrick.getRemainingChoices();
		Set<ViewableBrick> unlistedChoices = new HashSet<>(remainingChoices); 
		
		for (ViewableBrick choice : remainingChoices) {
			if (choice instanceof ComposedBrick) {
				proposals.add(new CodebricksComposedProposal(CodebricksEditor.this, parentContainer, placeholderControl, placeholderBrick, (ComposedBrick) choice));
			} else {
				// Show equal choices in one proposal:
				if (unlistedChoices.contains(choice)) {
					List<ViewableBrick> equalChoices = new ArrayList<>();
					
					for (ViewableBrick unlistedChoice : unlistedChoices) {
						if (unlistedChoice.getText().equals(choice.getText())) {
							equalChoices.add(unlistedChoice);
						}
					}
					
					unlistedChoices.removeAll(equalChoices);
					proposals.add(new TemplateCodebricksProposal(this, placeholderControl, placeholderBrick, equalChoices));
				}
			}
		}
		
		return proposals;
	}
	
	private List<ICompletionProposal> getProposals(Composite parentContainer, StyledText placeholderControl, ObjectPlaceholderBrick placeholderBrick) {
		List<ICompletionProposal> proposals = new ArrayList<>();

		// TODO:
		if (placeholderBrick.getDomain() != null) {
			for (EObject element : placeholderBrick.getDomain().getDomain(placeholderBrick)) {
				ObjectCodebricksProposal codebricksProposal = new ObjectCodebricksProposal(this, placeholderControl, placeholderBrick, element);
				proposals.add(codebricksProposal);
			}
		}
		
		return proposals;
	}
	
	private List<ICompletionProposal> getProposals(Composite parentContainer, StyledText placeholderControl, ValuePlaceholderBrick placeholderBrick) {
		List<ICompletionProposal> proposals = new ArrayList<>();
		// TODO:
		return proposals;
	}
	
	// TODO: Implement template changed listener.
	protected void autoSelectPlaceholders(List<? extends Brick> bricks) {
		try {
			for (Brick brick : bricks) {
				if (brick instanceof PlaceholderBrick) {
					if (brick instanceof TemplatePlaceholderBrick) {
						TemplatePlaceholderBrick placeholderBrick = (TemplatePlaceholderBrick) brick;
						
						if (tryAutoSelectPlaceholder(placeholderBrick)) { // For optimization
							StyledText textBrick = (StyledText) modelToViewMap.get(placeholderBrick);
							List<ICompletionProposal> proposals = getProposals(textBrick.getParent(), textBrick, placeholderBrick);
							
							if (proposals.isEmpty()) {
								if (placeholderBrick instanceof ComposedTemplatePlaceholderBrick) {
									// Hide container of composed placeholder:
									ComposedBrick containerModel = ((ComposedTemplatePlaceholderBrick) placeholderBrick).getContainerBrick();
									Composite containerView = (Composite) modelToViewMap.get(containerModel);
									hideComposedPlaceholder(containerView);
								} else {
									// Hide placeholder:
									hidePlaceholder(textBrick);
								}
							} else if (proposals.size() == 1) {
								proposals.get(0).apply();
							}
						}
					}
				} else if (brick instanceof ComposedBrick) {
					autoSelectPlaceholders(((ComposedBrick) brick).getBricks());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
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
	
	private boolean tryAutoSelectPlaceholder(TemplatePlaceholderBrick placeholder) {
		
		/*
		 *  For optimization:
		 */
		
		if (!placeholder.getChoice().isEmpty()) {
			return false; // already selected!
		}
		
		List<ViewableBrick> choices = placeholder.getRemainingChoices();
		
		if ((choices.size() == 0) || (choices.size() == 1)) {
			return true;
		} else {
			for (ViewableBrick choice : choices) {
				if (choice instanceof ComposedBrick) {
					return false; // multiple composed bricks!
				}
				if (!choice.getText().equals(choices.get(0).getText())) {
					return false; // not all choices are equal!
				}
			}
		}
		
		return true;
	}
	
	protected void fitToContent() {
		
		// Resize editor to fit content:
		Point newSize = editorShell.computeSize(SWT.DEFAULT, SWT.DEFAULT);

		// ... up to limit:
		if (newSize.x < maximumWidth) {
			editorShell.setSize(newSize);
		}

		// Update scroll area:
		editorContent.pack(true);
		scrolledEditor.setMinSize(editorContent.computeSize(SWT.DEFAULT, SWT.DEFAULT));
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
}

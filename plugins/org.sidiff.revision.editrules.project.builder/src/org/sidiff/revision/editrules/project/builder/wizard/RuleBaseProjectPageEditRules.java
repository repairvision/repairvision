package org.sidiff.revision.editrules.project.builder.wizard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.sidiff.revision.common.emf.ItemProviderUtil;
import org.sidiff.revision.common.utilities.java.StringUtil;
import org.sidiff.revision.editrules.project.builder.Activator;
import org.sidiff.validation.constraint.interpreter.IConstraint;
import org.sidiff.validation.constraint.project.development.registry.WorkspaceConstraintLibraryRegistry;
import org.sidiff.validation.constraint.project.development.registry.WorkspaceConstraintLibraryRegistry.WorkspaceContext;
import org.sidiff.validation.constraint.project.registry.ConstraintLibraryRegistry;
import org.sidiff.validation.constraint.project.registry.IConstraintLibrary;

/**
 * RulebaseExtension Project Page: Creates a new rulebase containing edit rules for a specific document type. 
 * 
 * @author Manuel Ohrndorf
 */
public class RuleBaseProjectPageEditRules extends WizardPage {

	// Created with WindowBuilder //
	
	private static final String SEARCH_INFO_TEXT = "search for keyword or pattern (*) ...";
	
	private Text nameText;
	
	private Text descriptionText;
	
	// Document Types:
	
	private String[] availableDocumentTypes;
	
	private Set<String> selectedDocumentTypes;
	
	private CheckboxTableViewer documentTypesTable;
	
	private Text documentTypeSearch;
	
	// Consistency Rules:
	
	private IConstraint[] availableConstraints;
	
	private Set<IConstraint> selectedConstraints;
	
	private CheckboxTableViewer constraintsTable;
	
	private Button selectAllConstraints;
	
	private Button clearSelectedConstraints;
	
	private Text constraintSearch;
	
	// Consistency Patterns:
	
	private Button exampleFolderOption;
	
	private Button initializePatternsOptions;
	
	// TODO: Defines the context in which models are loaded/reloaded from the active
	// development workspace. The classloader is closed and the models are removed
	// from the EMF registry after closing the wizard (dispose()). Another (better)
	// possibility would be to create and bound the context to a thread for the
	// rulebase building.
	private WorkspaceContext workspaceContext = new WorkspaceContext();

	public RuleBaseProjectPageEditRules(String name, String[] availableDocumentTypes) {
		super("RuleBaseProjectPageEditRules");
		this.setTitle("Modeling Language and Consistency Rules");
		this.setDescription("Creates a new constraint library for a specific document type.");
		this.setImageDescriptor(Activator.imageDescriptorFromPlugin(Activator.getPluginId(), "configuration.png"));
		
		this.availableDocumentTypes = availableDocumentTypes;
		this.selectedDocumentTypes = new LinkedHashSet<>();
		this.availableConstraints = new IConstraint[0]; // based on selected document type
		this.selectedConstraints = new LinkedHashSet<>();
	}
	
	protected IConstraint[] getAvailableConstraints() {
		List<IConstraint> availableConstraints = new ArrayList<>();
		
		// Runtime registered constraints:
		for (String documentType : getSelectedDocumentTypes()) {
			for (IConstraintLibrary library : ConstraintLibraryRegistry.getLibraries(documentType)) {
				availableConstraints.addAll(library.getConstraints());
			}
		}

		// Workspace registered constraints:
		availableConstraints.addAll(WorkspaceConstraintLibraryRegistry.getConstraints(
				new HashSet<>(getSelectedDocumentTypes()), workspaceContext));
		
		Collections.sort(availableConstraints, new Comparator<IConstraint>() {
			public int compare(IConstraint c1, IConstraint c2) {
				return c1.getName().compareTo(c2.getName());
			}
		});
		
		return availableConstraints.toArray(new IConstraint[0]);
	}
	
	protected void setMessages() {
		if (!canFinish()) {
			setMessage("The document type and name must be set");
		} else {
			setMessage(null);
		}
	}
	
	public boolean canFinish() {
		return !getName().isEmpty() && !getSelectedDocumentTypes().isEmpty();
	}
	
	public String getName() {
		if (nameText.getText() != null) {
			return nameText.getText();
		}
		return "";
	}
	
	public String getDescriptionText() {
		if (descriptionText.getText() != null) {
			return descriptionText.getText();
		}
		return "";
	}
	
	public List<String> getSelectedDocumentTypes() {
		return new ArrayList<>(selectedDocumentTypes);
	}
	
	public List<IConstraint> getSelectedConstraints() {
		List<IConstraint> sortedSelectedConstraints = new ArrayList<>(selectedConstraints);
		sortedSelectedConstraints.sort(new Comparator<IConstraint>() {

			@Override
			public int compare(IConstraint c1, IConstraint c2) {
				return c1.getName().compareTo(c2.getName());
			}
		});
		return new ArrayList<>(sortedSelectedConstraints);
	}

	public boolean isCreateExampleFolderOption() {
		return exampleFolderOption.getSelection();
	}
	
	public boolean isInitializePatternsOption() {
		return initializePatternsOptions.getSelection();
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = createScrolledContainer(parent);
		createNameControl(container);
		createDescriptionControl(container);
		
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		createDocumentTypeControl(container);
		createConstraintControl(container);
		createExampleFolderOption(container);
		
		// FINALLY, calculate the content to be scrolled!
		container.setSize(container.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		setMessages();
	}

	private Composite createScrolledContainer(Composite parent) {
		ScrolledComposite scrolledContainer = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
		{
			scrolledContainer.setExpandHorizontal(true);
			setControl(scrolledContainer);
		}
		
		Composite container = new Composite(scrolledContainer, SWT.NONE);
		{
			GridLayout gl_container = new GridLayout();
			gl_container.numColumns = 2;
			container.setLayout(gl_container);
			
			scrolledContainer.setContent(container);
		}
		return container;
	}

	private void createNameControl(Composite container) {
		Label nameLabel = new Label(container, SWT.NONE);
		{
			nameLabel.setText("Name:");
			
			nameText = new Text(container, SWT.BORDER);
			nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			createNameControlListeners();
		}
	}
	
	private void createNameControlListeners() {
		nameText.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				setMessages();
			}
		});
	}

	private void createDescriptionControl(Composite container) {
		Label descriptionLabel = new Label(container, SWT.NONE);
		{
			descriptionLabel.setText("Description:");
			
			descriptionText = new Text(container, SWT.BORDER);
			descriptionText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		}
	}

	private void createDocumentTypeControl(Composite container) {
		
		Group documentTypesGroup = new Group(container, SWT.NONE);
		{
			documentTypesGroup.setText("Document Types");
			{
				documentTypesGroup.setLayout(new GridLayout(1, false));
				documentTypesGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
			}

			Composite documentTypesContainer = new Composite(documentTypesGroup, SWT.NONE);
			{
				documentTypesContainer.setLayout(new GridLayout(1, false));
				documentTypesContainer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
			}
			
			createDocumentTypeSearch(documentTypesContainer);
			createDocumentTypesTable(documentTypesContainer);
			
			createDocumentTypeTableListeners();
			createDocumentTypeSearchListeners();
			
		}
	}

	private void createDocumentTypeSearch(Composite documentTypesContainer) {
		documentTypeSearch = new Text(documentTypesContainer, SWT.BORDER);
		{
			documentTypeSearch.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			documentTypeSearch.setText(SEARCH_INFO_TEXT);
		}
	}

	private void createDocumentTypeSearchListeners() {
		documentTypeSearch.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if (documentTypeSearch.getText().equals("")) {
					documentTypeSearch.setText(SEARCH_INFO_TEXT);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if (documentTypeSearch.getText().equals(SEARCH_INFO_TEXT)) {
					documentTypeSearch.setText("");
				}
			}
		});
		documentTypeSearch.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (documentTypeSearch.getText().equals(SEARCH_INFO_TEXT)) {
					searchInDocumentTypeTable(null);
				} else {
					searchInDocumentTypeTable(documentTypeSearch.getText());
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
	}

	private void createDocumentTypesTable(Composite documentTypesContainer) {
		
		ScrolledComposite scrolledTable = new ScrolledComposite(documentTypesContainer, SWT.H_SCROLL | SWT.V_SCROLL);
		{
			scrolledTable.setExpandVertical(true);
			scrolledTable.setExpandHorizontal(true);
			
			GridData scrolledTableLayout = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 2);
			scrolledTableLayout.heightHint = 100;
			scrolledTable.setLayoutData(scrolledTableLayout);
		}
		
		Composite tableContainer = new Composite(scrolledTable, SWT.NONE);
		{
			GridLayout tableContainerLayout = new GridLayout(1, false);
			tableContainerLayout.verticalSpacing = 0;
			tableContainerLayout.marginHeight = 0;
			tableContainerLayout.marginWidth = 0;
			tableContainerLayout.horizontalSpacing = 0;
			tableContainer.setLayout(tableContainerLayout);
		}
		scrolledTable.setContent(tableContainer);
		
		documentTypesTable = CheckboxTableViewer.newCheckList(tableContainer, SWT.BORDER | SWT.MULTI);
		{
			documentTypesTable.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
			documentTypesTable.setLabelProvider(new ColumnLabelProvider() {
				
				Image icon = (Image) ItemProviderUtil.getImageByType(EcorePackage.eINSTANCE.getEPackage());
				
				@Override
				public Image getImage(Object element) {
					return icon;
				}
			});
			documentTypesTable.setContentProvider(new ArrayContentProvider());
			documentTypesTable.setInput(availableDocumentTypes);
		}
		
		// FINALLY, calculate the content to be scrolled!
		tableContainer.setSize(tableContainer.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}

	private void createDocumentTypeTableListeners() {
		
		documentTypesTable.addCheckStateListener(new ICheckStateListener() {
			
			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				if (event.getChecked()) {
					String documentType = (String) event.getElement();
					selectedDocumentTypes.add(documentType);
					
					// For convenience, set name and description...
					if (nameText.getText().isEmpty() && descriptionText.getText().isEmpty()) {
						String name = documentType.substring(documentType.lastIndexOf("/") + 1, documentType.length());
						
						if (!name.isEmpty()) {
							nameText.setText(StringUtil.toUpperFirst(name));
							descriptionText.setText("Document Type: " + documentType);
						}
					}
					
				} else {
					selectedDocumentTypes.remove(event.getElement());
					
					// synchronize constraints:
					for (Iterator<IConstraint> iterator = selectedConstraints.iterator(); iterator.hasNext();) {
						IConstraint constraint = iterator.next();
						
						if (!selectedDocumentTypes.contains(constraint.getContextType().getEPackage().getNsURI())) {
							iterator.remove();
						}
					}
				}
				
				setMessages();
			}
			
		});
	}
	
	private void searchInDocumentTypeTable(String text) {
		if ((text != null) && !text.isEmpty()) {
			String searchKey = text.trim().toLowerCase();
			searchKey = searchKey.replaceAll("\\*", ".*?"); // allow * as search pattern
			
			List<String> searchedDocumentTypes = new ArrayList<>();

			for (String documentType : availableDocumentTypes) {
				if (documentType.toLowerCase().matches(".*?" + searchKey + ".*")) {
					searchedDocumentTypes.add(documentType);
				}
			}

			documentTypesTable.setInput(searchedDocumentTypes.toArray());
		} else {
			documentTypesTable.setInput(availableDocumentTypes);
		}

		documentTypesTable.setCheckedElements(selectedDocumentTypes.toArray());
	}

	private void createConstraintControl(Composite container) {
		
		Group documentTypesGroup = new Group(container, SWT.NONE);
		{
			documentTypesGroup.setText("Consistency Rules");
			{
				documentTypesGroup.setLayout(new GridLayout(1, false));
				documentTypesGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
			}

			Composite constraintContainer = new Composite(documentTypesGroup, SWT.NONE);
			{
				constraintContainer.setLayout(new GridLayout(1, false));
				constraintContainer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
			}
			
			createConstraintSearch(constraintContainer);
			createConstraintsTable(constraintContainer);
			createConstraintSelectionTools(constraintContainer);
			
			createConstraintSearchListeners();
			createConstraintsTableListener();
			createConstraintSelectionToolsListener();
		}
	}

	private void createConstraintSearch(Composite constraintContainer) {
		
		constraintSearch = new Text(constraintContainer, SWT.BORDER);
		{
			constraintSearch.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			constraintSearch.setText(SEARCH_INFO_TEXT);
		}
	}

	private void createConstraintSearchListeners() {
		constraintSearch.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if (constraintSearch.getText().equals("")) {
					constraintSearch.setText(SEARCH_INFO_TEXT);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if (constraintSearch.getText().equals(SEARCH_INFO_TEXT)) {
					constraintSearch.setText("");
				}
			}
		});
		constraintSearch.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (constraintSearch.getText().equals(SEARCH_INFO_TEXT)) {
					searchInConstraintTable(null);
				} else {
					searchInConstraintTable(constraintSearch.getText());
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
	}

	private void createConstraintsTable(Composite constraintContainer) {
		
		ScrolledComposite scrolledTable = new ScrolledComposite(constraintContainer, SWT.H_SCROLL | SWT.V_SCROLL);
		{
			scrolledTable.setExpandVertical(true);
			scrolledTable.setExpandHorizontal(true);
			
			GridData scrolledTableLayout = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 2);
			scrolledTableLayout.heightHint = 100;
			scrolledTable.setLayoutData(scrolledTableLayout);
		}
		
		Composite tableContainer = new Composite(scrolledTable, SWT.NONE);
		{
			GridLayout tableContainerLayout = new GridLayout(1, false);
			tableContainerLayout.verticalSpacing = 0;
			tableContainerLayout.marginWidth = 0;
			tableContainerLayout.marginHeight = 0;
			tableContainerLayout.horizontalSpacing = 0;
			tableContainer.setLayout(tableContainerLayout);
		}
		scrolledTable.setContent(tableContainer);
		
		constraintsTable = CheckboxTableViewer.newCheckList(tableContainer, SWT.BORDER | SWT.MULTI);
		{
			constraintsTable.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
			constraintsTable.setLabelProvider(new ColumnLabelProvider() {
				
				@Override
				public Image getImage(Object element) {
					
					if (element instanceof IConstraint) {
						return (Image) ItemProviderUtil.getImageByType(((IConstraint) element).getContextType());
					}
					
					return super.getImage(element);
				}
				
				@Override
				public String getText(Object element) {
					
					if (element instanceof IConstraint) {
						return ((IConstraint) element).getName();
					}
					
					return super.getText(element);
				}
			});
			constraintsTable.setContentProvider(new ArrayContentProvider());
			constraintsTable.setInput(availableConstraints);
		}
		
		// FINALLY, calculate the content to be scrolled!
		tableContainer.setSize(tableContainer.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}
	
	private void createConstraintSelectionTools(Composite constraintContainer) {
		Composite constraintSelectionTools = new Composite(constraintContainer, SWT.NONE);
		{
			constraintSelectionTools.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
			constraintSelectionTools.setLayout(new FillLayout(SWT.HORIZONTAL));
			
			selectAllConstraints = new Button(constraintSelectionTools, SWT.NONE);
			selectAllConstraints.setText("Select All");
			
			clearSelectedConstraints = new Button(constraintSelectionTools, SWT.NONE);
			clearSelectedConstraints.setText("Clear Selection");
		}
	}

	private void createConstraintSelectionToolsListener() {
		
		selectAllConstraints.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				constraintsTable.setAllChecked(true); // no notification ->
				selectedConstraints.addAll(Arrays.asList(availableConstraints));
			}
		});
		
		clearSelectedConstraints.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				constraintsTable.setAllChecked(false); // no notification ->
				selectedConstraints.removeAll(Arrays.asList(availableConstraints));
			}
		});
	}

	private void createConstraintsTableListener() {
		constraintsTable.addCheckStateListener(new ICheckStateListener() {
			
			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				if (event.getChecked()) {
					selectedConstraints.add((IConstraint) event.getElement());
				} else {
					selectedConstraints.remove(event.getElement());
				}
				
			}
		});
		
		// Listen to selected document types: 
		documentTypesTable.addCheckStateListener(new ICheckStateListener() {
			
			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				RuleBaseProjectPageEditRules.this.availableConstraints = getAvailableConstraints();
				constraintsTable.setInput(RuleBaseProjectPageEditRules.this.availableConstraints);
				
				// Select all:
				constraintsTable.setAllChecked(true);
				selectedConstraints.addAll(Arrays.asList(availableConstraints));
			}
		});
	}
	
	private void searchInConstraintTable(String text) {
		if ((text != null) && !text.isEmpty()) {
			String searchKey = text.trim().toLowerCase();
			searchKey = searchKey.replaceAll("\\*", ".*?");  // allow * as search pattern
			
			List<IConstraint> searchedConstraints = new ArrayList<>();
			
			for (IConstraint constraint : availableConstraints) {
				if (constraint.getName().toLowerCase().matches(".*?" + searchKey + ".*")) {
					searchedConstraints.add(constraint);
				}
			}
			
			constraintsTable.setInput(searchedConstraints.toArray());
		} else {
			constraintsTable.setInput(availableConstraints);
		}
		constraintsTable.setCheckedElements(selectedConstraints.toArray());
	}

	private void createExampleFolderOption(Composite container) {
		Group patternsGroup = new Group(container, SWT.NONE);
		{
			patternsGroup.setText("Consistency Patterns");
			patternsGroup.setLayout(new GridLayout(1, false));
			patternsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
			
			initializePatternsOptions = new Button(patternsGroup, SWT.CHECK);
			initializePatternsOptions.setSelection(true);
			initializePatternsOptions.setText("Initialize Consistency Patterns for Selected Consistency Rules");
			
			exampleFolderOption = new Button(patternsGroup, SWT.CHECK);
			exampleFolderOption.setSelection(true);
			exampleFolderOption.setText("Create Folder for Model Examples");
		}
	}
	
	@Override
	public void dispose() {
		workspaceContext.close();
		super.dispose();
	}
}

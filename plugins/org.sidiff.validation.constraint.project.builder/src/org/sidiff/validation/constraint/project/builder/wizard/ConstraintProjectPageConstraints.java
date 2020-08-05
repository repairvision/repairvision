package org.sidiff.validation.constraint.project.builder.wizard;

import java.util.ArrayList;
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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.sidiff.revision.common.emf.ItemProviderUtil;
import org.sidiff.revision.common.utilities.java.StringUtil;
import org.sidiff.validation.constraint.project.builder.Activator;

/**
 * Constraint Library Project Page: Creates a new constraint library for a specific document type. 
 * 
 * @author Manuel Ohrndorf
 */
public class ConstraintProjectPageConstraints extends WizardPage {

	// Created with WindowBuilder //
	
	private static final String SEARCH_INFO_TEXT = "search for keyword or pattern (*) ...";
	
	private Text nameText;
	
	private Text descriptionText;
	
	// Document Types:
	
	private String[] availableDocumentTypes;
	
	private Set<String> selectedDocumentTypes;
	
	private CheckboxTableViewer documentTypesTable;
	
	private Text documentTypeSearch;

	public ConstraintProjectPageConstraints(String name, String[] availableDocumentTypes) {
		super("ConstraintProjectPageConstraints");
		this.setTitle("Modeling Language and Consistency Rules");
		this.setDescription("Creates a new constraint library for a specific document type.");
		this.setImageDescriptor(Activator.imageDescriptorFromPlugin(Activator.getPluginId(), "configuration.png"));
		
		this.availableDocumentTypes = availableDocumentTypes;
		this.selectedDocumentTypes = new LinkedHashSet<>();
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

	@Override
	public void createControl(Composite parent) {
		Composite container = createScrolledContainer(parent);
		createNameControl(container);
		createDescriptionControl(container);
		
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		createDocumentTypeControl(container);
		
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

}

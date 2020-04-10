package org.sidiff.revision.editrules.project.builder.wizard;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.sidiff.consistency.common.emf.ItemProviderUtil;
import org.sidiff.revision.editrules.project.builder.Activator;

/**
 * Rulebase Project Page: Creates a new rulebase containing edit rules for a specific document type. 
 * 
 * @author Manuel Ohrndorf
 */
public class RuleBaseProjectPageEditRules extends WizardPage {

	// Created with WindowBuilder //
	
	private Text nameText;
	
	private Text descriptionText;
	
	private CheckboxTableViewer documentTypes;
	
	private String[] availableDocumentTypes;
	private Text tableSearch;

	public RuleBaseProjectPageEditRules(String[] availableDocumentTypes) {
		super("RuleBaseProjectPageEditRules");
		setTitle("Edit Rules Plug-in Project Settings");
		setDescription("Create a new rulebase containing edit rules for a specific document type.");
		setImageDescriptor(Activator.imageDescriptorFromPlugin(Activator.getPluginId(), "configuration.png"));
		
		this.availableDocumentTypes = availableDocumentTypes;
	}
	
	public String getName() {
		if (nameText.getText() != null) {
			return nameText.getText();
		}
		return "";
	}
	
	public String getDescription() {
		if (descriptionText.getText() != null) {
			return descriptionText.getText();
		}
		return "";
	}
	
	public Set<EPackage> getDocumentTypes() {
		Set<EPackage> documentTypes = new LinkedHashSet<>();
		
		for (Object selectedDocumentType : this.documentTypes.getCheckedElements()) {
			EPackage documentType = EPackage.Registry.INSTANCE.getEPackage((String) selectedDocumentType);
			
			if (documentType != null) {
				documentTypes.add(documentType);
			}
		}
	
		return documentTypes;
	}

	@Override
	public void createControl(Composite parent) {
		
		ScrolledComposite scrolledContainer = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
		{
			scrolledContainer.setExpandHorizontal(true);
			
			setControl(scrolledContainer);
		}
		
		Composite container = new Composite(scrolledContainer, SWT.NONE);
		{
			GridLayout layout = new GridLayout();
			layout.numColumns = 2;
			container.setLayout(layout);
			
			scrolledContainer.setContent(container);
		}
		
		Label nameLabel = new Label(container, SWT.NONE);
		{
			nameLabel.setText("Name:");
			
			nameText = new Text(container, SWT.BORDER);
			nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		}
		
		Label descriptionLabel = new Label(container, SWT.NONE);
		{
			descriptionLabel.setText("Description:");
			
			descriptionText = new Text(container, SWT.BORDER);
			descriptionText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		}
		
		Label documentTypesLabel = new Label(container, SWT.NONE);
		{
			documentTypesLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			documentTypesLabel.setText("Document Types:");
			
			tableSearch = new Text(container, SWT.BORDER);
			{
				String infoText = "search...";
				
				tableSearch.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
				tableSearch.setText(infoText);
				tableSearch.addFocusListener(new FocusListener() {
					
					@Override
					public void focusLost(FocusEvent e) {
						if (tableSearch.getText().equals("")) {
							tableSearch.setText(infoText);
						}
					}
					
					@Override
					public void focusGained(FocusEvent e) {
						if (tableSearch.getText().equals(infoText)) {
							tableSearch.setText("");
						}
					}
				});
				tableSearch.addKeyListener(new KeyListener() {
					
					@Override
					public void keyReleased(KeyEvent e) {
						if (tableSearch.getText().isEmpty() || tableSearch.getText().equals(infoText)) {
							documentTypes.setInput(availableDocumentTypes);
						} else {
							searchInTable();
						}
					}

					@Override
					public void keyPressed(KeyEvent e) {
					}
				});
			}
			
			ScrolledComposite scrolledTable = new ScrolledComposite(container, SWT.H_SCROLL | SWT.V_SCROLL);
			scrolledTable.setExpandHorizontal(true);
			scrolledTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 2));
			
			Composite tableContainer = new Composite(scrolledTable, SWT.NONE);
			scrolledTable.setContent(tableContainer);
			tableContainer.setLayout(new GridLayout(1, false));
			
			documentTypes = CheckboxTableViewer.newCheckList(tableContainer, SWT.BORDER | SWT.MULTI);
			{
				GridData layout = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
				layout.heightHint = 150;
				documentTypes.getTable().setLayoutData(layout);
				
				documentTypes.setLabelProvider(new ColumnLabelProvider() {
					
					Image icon = (Image) ItemProviderUtil.getImageByType(EcorePackage.eINSTANCE.getEPackage());
					
					@Override
					public Image getImage(Object element) {
						return icon;
					}
				});
				documentTypes.setContentProvider(new ArrayContentProvider());
				documentTypes.add(availableDocumentTypes);
			}
			
			tableContainer.setSize(tableContainer.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		}
		
		// FINALLY, calculate the content to be scrolled!
		container.setSize(container.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}
	
	private void searchInTable() {
		String searchKey = tableSearch.getText().strip().toLowerCase();
		List<String> searchedDocumentTypes = new ArrayList<>();
		
		for (String documentType : availableDocumentTypes) {
			if (documentType.toLowerCase().contains(searchKey)) {
				
				searchedDocumentTypes.add(documentType);
			}
		}
		
		documentTypes.setInput(searchedDocumentTypes.toArray());
	}
}

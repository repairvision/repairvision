package org.sidiff.common.ui.widgets;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.sidiff.common.ui.widgets.IWidgetValidation.ValidationMessage.ValidationType;

/**
 * 
 * @author cpietsch
 *
 */
public abstract class SelectResourceWidget<R extends IResource>  implements IWidget, IWidgetSelection, IWidgetValidation {
	
	/**
	 * 
	 */
	protected R resource;
	
	/**
	 * 
	 */
	protected IContainer iContainer;
	
	/**
	 * 
	 */
	protected String resourceType;
	
	/**
	 * 
	 */
	protected ValidationMessage validationMessage;
	
	// ---------- UI Elements ----------
	
	/**
	 * The {@link Composite} containing all widgets
	 */
	protected Composite container;
	
	/**
	 * The {@link Group} containing a subset of all widgets
	 */
	protected Group modelChooseGroup;
	
	
	/**
	 * 
	 */
	protected Text resourcePathText;
	
	/**
	 * The {@link Button} for choosing a file not contained in {@link #fileCombo}
	 */
	protected Button resourceChooseButton;
	
	// ---------- Constructor ----------
	
	public SelectResourceWidget(String resourceType) {
		this.resourceType = resourceType;
	}

	// ---------- IWidget ----------
	
	@Override
	public Composite createControl(Composite parent) {
		container = new Composite(parent, SWT.NONE);
		
		GridLayout gl_container = new GridLayout(1, false);
		gl_container.marginWidth = 0;
		gl_container.marginHeight = 0;
		container.setLayout(gl_container);
	
		modelChooseGroup = new Group(container, SWT.NONE);
		
		GridLayout gl_group = new GridLayout(2, false);
		gl_group.marginWidth = 10;
		gl_group.marginHeight = 10;
		modelChooseGroup.setLayout(gl_group);
		
		modelChooseGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
	
		modelChooseGroup.setText(this.resourceType);
		 
		resourcePathText = new Text(modelChooseGroup, SWT.BORDER);
		resourcePathText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		resourcePathText.addModifyListener(new ModifyListener() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void modifyText(ModifyEvent e) {
				Path path = new Path(resourcePathText.getText());
				IResource res = ResourcesPlugin.getWorkspace().getRoot().findMember(path);
				if(res != null) {
					resource = (R) res;
				}
			}
		});
		
		resourceChooseButton = new Button(modelChooseGroup, SWT.PUSH);
		resourceChooseButton.setText("Choose Model");
		resourceChooseButton.addSelectionListener(new SelectionAdapter() {
			@SuppressWarnings("unchecked")
			public void widgetSelected(SelectionEvent event) {
				ContainerSelectionDialog containerSelectionDialog = new ContainerSelectionDialog(container.getShell(), iContainer, false, "select a " + resourceType);; 
				int i = containerSelectionDialog.open();
				if(i == ContainerSelectionDialog.OK){
					Object[] result = containerSelectionDialog.getResult();
					if(result.length == 1){
						Path path = (Path) result[0];
						resource = (R) ResourcesPlugin.getWorkspace().getRoot().findMember(path);
						resourcePathText.setText(path.toOSString());
						selectionHook();
					}
				}
			}
		});

		return container;
	}
	
	public abstract void selectionHook();
	
	@Override
	public Composite getWidget() {
		return container;
	}
	
	@Override
	public void setLayoutData(Object layoutData) {
		container.setLayoutData(layoutData);
	}
	
	// ---------- IWidgetSelection ----------
	
	@Override
	public void addSelectionListener(SelectionListener listener) {
		if(resourceChooseButton == null){
			throw new RuntimeException("Create controls first!");
		}
		resourceChooseButton.addSelectionListener(listener);
	}

	@Override
	public void removeSelectionListener(SelectionListener listener) {
		if(resourceChooseButton != null){
			resourceChooseButton.removeSelectionListener(listener);
		}
	}
	
	// ---------- IWidgetValidation ----------
	
	@Override
	public boolean validate() {
		return resource != null;
	}

	@Override
	public ValidationMessage getValidationMessage() {
		if (validate()) {
			validationMessage = new ValidationMessage(ValidationType.OK, "");
		} else{
			validationMessage = new ValidationMessage(ValidationType.ERROR, "Please select a resource");
		}
		return validationMessage;
	}
	
	
	// ---------- Getter- and Setter-Methods ---------- 
	
	public R getResorce() {
		return resource;
	}

}

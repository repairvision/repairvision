package org.sidiff.common.ui.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.sidiff.common.ui.widgets.IWidgetValidation.ValidationMessage.ValidationType;

/**
 * 
 * @author cpietsch
 *
 */
public abstract class UriValidationWidget implements IWidget, IWidgetSelection, IWidgetValidation {
	
	/**
	 * 
	 */
	protected String label_group;
	
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
	protected Group uri_group;
	
	
	/**
	 * 
	 */
	protected Label uri_label;
	
	/**
	 * 
	 */
	protected Text uri_text;
	

	
	// ---------- Constructor ----------
	
	public UriValidationWidget(String label_group) {
		this.label_group = label_group;
	}

	// ---------- IWidget ----------
	
	@Override
	public Composite createControl(Composite parent) {
		container = new Composite(parent, SWT.NONE);
		
		GridLayout gl_container = new GridLayout(1, false);
		gl_container.marginWidth = 0;
		gl_container.marginHeight = 0;
		container.setLayout(gl_container);
		
		uri_group = new Group(container, SWT.NONE);
		
		GridLayout gl_group = new GridLayout(3, false);
		gl_group.marginWidth = 10;
		gl_group.marginHeight = 10;
		uri_group.setLayout(gl_group);
		
		uri_group.setLayoutData(new GridData(GridData.FILL_BOTH));
		uri_group.setText(label_group);
		
		GridData gd_uri_group_input = new GridData(GridData.FILL_HORIZONTAL);
		gd_uri_group_input.horizontalSpan = 2;
		
		uri_label = new Label(uri_group, SWT.NONE);
		uri_label.setText("URL:");
		
		uri_text = new Text(uri_group, SWT.BORDER);
		uri_text.setLayoutData(gd_uri_group_input);
		uri_text.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				modifyTextHook();
				uri_text.notifyListeners(SWT.Selection, new Event());
			}
		});
		
		return container;
	}
	
	@Override
	public Composite getWidget() {
		return container;
	}
	
	@Override
	public void setLayoutData(Object layoutData) {
		container.setLayoutData(layoutData);
	}
	
	// ---------- IWidgetSelection -----------
	
	@Override
	public void addSelectionListener(SelectionListener listener) {
		if (uri_text == null) {
			throw new RuntimeException("Create controls first!");
		}
		uri_text.addSelectionListener(listener);
	}

	@Override
	public void removeSelectionListener(SelectionListener listener) {
		if (uri_text != null) {
			uri_text.removeSelectionListener(listener);
		}
	}
	
	// ---------- IWidgetValidation ----------
	
	@Override
	public boolean validate() {
		
		return !uri_text.getText().isEmpty() && isValidURI(uri_text.getText());
	}

	@Override
	public ValidationMessage getValidationMessage() {
		if (validate()) {
			validationMessage = new ValidationMessage(ValidationType.OK, "");
		} else{
			validationMessage = new ValidationMessage(ValidationType.ERROR, "Please select an URL for " + label_group);
		}
		return validationMessage;
	}
	
	//FIXME the URI_PATTERN depends on the supported protocols
	private final String URI_PATTERN = "(http)(s?)://([a-zA-z0-9])+(([_\\-\\./])([a-zA-z0-9])+)*";
	
	private boolean isValidURI(String s) {
		return s.matches(URI_PATTERN);
	}
	// ---------- Hooks ----------

	protected abstract void modifyTextHook();
}

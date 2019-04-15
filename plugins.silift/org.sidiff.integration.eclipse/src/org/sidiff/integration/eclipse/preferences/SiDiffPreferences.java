package org.sidiff.integration.eclipse.preferences;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.osgi.framework.Bundle;
import org.sidiff.integration.eclipse.Activator;
import org.sidiff.integration.eclipse.BundleHandler;

/**
 * This class represents a preference page that is contributed to the
 * Preferences dialog. By subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows us to create a page
 * that is small and knows how to save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They are stored in the
 * preference store that belongs to the main plug-in class. That way,
 * preferences can be accessed directly via the preference store.
 */

public class SiDiffPreferences extends PreferencePage implements IWorkbenchPreferencePage {

	public SiDiffPreferences() {

	}

	private ArrayList<Bundle> siDiffBundles;
	private HashMap<String, Bundle> sidiffBundlesMap;
	
	private BooleanFieldEditor extendedDependencyCheckFieldEditor;

	@Override
	protected Control createContents(Composite parent) {

		sidiffBundlesMap = new HashMap<String, Bundle>();

		Composite container = new Composite(parent, SWT.NONE);
		GridLayout grid = new GridLayout(1, false);

		container.setLayout(grid);

		final Table table = new Table(container, SWT.CHECK | SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true));

		String[] titles = { " ", "ID", "Name", "Status" };
		for (int i = 0; i < titles.length; i++) {
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setText(titles[i]);

		}

		siDiffBundles = BundleHandler.getInstance().getSiDiffBundles();
		for (Bundle bundle : siDiffBundles) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(1, Long.toString(bundle.getBundleId()));
			item.setText(2, bundle.getSymbolicName());
			item.setText(3, BundleHandler.getInstance().getState(bundle));

			sidiffBundlesMap.put(bundle.getSymbolicName(), bundle);

		}
		for (int i = 0; i < titles.length; i++) {
			table.getColumn(i).pack();
		}

		Composite buttons = new Composite(parent, SWT.NONE);

		GridLayout buttonsGrid = new GridLayout(5, false);
		buttons.setLayout(buttonsGrid);


		GridData buttonsGridData = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);

		Button selectAll = new Button(buttons, SWT.NONE);
		selectAll.setText("select all");
		selectAll.setLayoutData(buttonsGridData);
		Button deselectAll = new Button(buttons, SWT.PUSH);
		deselectAll.setText("select none");
		deselectAll.setLayoutData(buttonsGridData);

		selectAll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setSelect(true, table);
			}
		});

		deselectAll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setSelect(false, table);
			}
		});

		Button startAll = new Button(buttons, SWT.PUSH);
		startAll.setText("start all");
		startAll.setLayoutData(buttonsGridData);

		startAll.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {

				BundleHandler.getInstance().startBundles();
			}
		});

		Button startSelected = new Button(buttons, SWT.PUSH);
		startSelected.setText("start selected");
		startSelected.setLayoutData(buttonsGridData);
		startSelected.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				BundleHandler.getInstance().startBundles(getSelectedBundles(table));

			}
		});

		Button stopAll = new Button(buttons, SWT.PUSH);
		stopAll.setText("stop all");
		stopAll.setLayoutData(buttonsGridData);
		stopAll.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {

				BundleHandler.getInstance().stopBundles();
			}
		});

		Button stopSelected = new Button(buttons, SWT.PUSH);
		stopSelected.setText("stop selected");
		stopSelected.setLayoutData(buttonsGridData);
		stopSelected.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				BundleHandler.getInstance().stopBundles(getSelectedBundles(table));

			}
		});

		Button refreshAll = new Button(buttons, SWT.PUSH);
		refreshAll.setText("restart all");
		refreshAll.setLayoutData(buttonsGridData);
		refreshAll.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {

				BundleHandler.getInstance().refreshBundles();
			}
		});

		Button refreshSelected = new Button(buttons, SWT.PUSH);
		refreshSelected.setText("restart selected");
		refreshSelected.setLayoutData(buttonsGridData);
		refreshSelected.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				BundleHandler.getInstance().refreshBundles(getSelectedBundles(table));

			}
		});
		
		Composite globalSettingsComposite = new Composite(parent, SWT.NONE);
		
		GridLayout booleanGrid = new GridLayout(5, false);
		globalSettingsComposite.setLayout(booleanGrid);
		
		extendedDependencyCheckFieldEditor = new BooleanFieldEditor(
				"TEST",
				"Enable extended complete and correct dependency analysis. [WARNING: may take hours]", 
				globalSettingsComposite);
		extendedDependencyCheckFieldEditor.setPreferenceStore(Activator.getStore());
		extendedDependencyCheckFieldEditor.load();

		container.pack();
		return container;
	}

	private void setSelect(boolean select, Table table) {
		TableItem[] items = table.getItems();
		for (TableItem tableItem : items) {
			tableItem.setChecked(select);
		}
	}

	private ArrayList<Bundle> getSelectedBundles(Table table) {
		ArrayList<Bundle> result = new ArrayList<Bundle>();

		for (TableItem tableItem : table.getItems()) {
			if (tableItem.getChecked()) {
				result.add(sidiffBundlesMap.get(tableItem.getText(2)));
			}
		}
		System.out.println("Result contains " + result.size() + " Elements!!");
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getStore());
	}
	
	@Override
	public boolean performOk(){
		extendedDependencyCheckFieldEditor.store();
		return super.performOk();
	}
	
	@Override
	public void performApply(){
		extendedDependencyCheckFieldEditor.store();
		super.performApply();
	}
}
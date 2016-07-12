package org.sidiff.consistency.repair.lifting.ui.views;

import java.util.Set;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.sidiff.configuration.IConfigurable;
import org.sidiff.consistency.common.ui.NameUtil;
import org.sidiff.matcher.IMatcher;

public class RepairPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	public static final String ID = "org.sidiff.consistency.repair.lifting.ui.mainpage";
	
	protected static final String SETUP_MATCHERS_MESSAGE = "Please first add the models!";
	
	protected static final String EMPTY_MATCHERS_MESSAGE = "No matchers available for the given model type.";
	
	// TODO: IPreferenceStore store = Activator.getDefault().getPreferenceStore();
	protected static Set<IMatcher> matchers;
	
	private static IMatcher matcher;
	
	//// UI ////
	
	private ComboViewer viewer_matching;
	
	private Composite config_container;
	
	/**
	 * Create the preference page.
	 */
	public RepairPreferencePage() {
	}
	
	/**
	 * Initialize the preference page.
	 */
	public void init(IWorkbench workbench) {
	}

	/**
	 * Create contents of the preference page.
	 * 
	 * @param parent
	 */
	@Override
	public Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		container.setLayout(new GridLayout(1, false));
		
		Group grpMatching = new Group(container, SWT.NONE);
		grpMatching.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		grpMatching.setText("Matching");
		grpMatching.setLayout(new GridLayout(1, false));
		
		// Matching-Engine selection:
		viewer_matching = new ComboViewer(grpMatching, SWT.NONE);
		{
			Combo combo_matching = viewer_matching.getCombo();
			combo_matching.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			// Provider:
			viewer_matching.setSorter(new ViewerSorter());
			viewer_matching.setContentProvider(ArrayContentProvider.getInstance());
			viewer_matching.setLabelProvider(new LabelProvider() {
				
				@Override
				public String getText(Object element) {
					
					if (element instanceof IMatcher) {
						return ((IMatcher) element).getName();
					}
					
					return super.getText(element);
				}
			});
			
			// Input:
			if (viewer_matching.getInput() != matchers) {
				viewer_matching.setInput(matchers);
			}
			
			if (matchers == null) {
				viewer_matching.add(SETUP_MATCHERS_MESSAGE);
				viewer_matching.setSelection(new StructuredSelection(SETUP_MATCHERS_MESSAGE));
			}
			
			if ((matchers != null) && (matchers.isEmpty())) {
				viewer_matching.add(EMPTY_MATCHERS_MESSAGE);
				viewer_matching.setSelection(new StructuredSelection(EMPTY_MATCHERS_MESSAGE));
			}
			
			// Selection:
			matcher = getInitialMatcher();
			
			if (matcher != null) {
				viewer_matching.setSelection(new StructuredSelection(matcher));
			}
			
			// Matcher configuration:
			appendMatcherSettings(grpMatching);
			
			// Update selected matcher:
			viewer_matching.addSelectionChangedListener(new ISelectionChangedListener() {

				@Override
				public void selectionChanged(SelectionChangedEvent event) {
					matcher = getSelection();

					// Matcher configuration:
					appendMatcherSettings(grpMatching);
				}

				private IMatcher getSelection() {
					return (IMatcher) ((StructuredSelection) viewer_matching.getSelection()).getFirstElement();
				}
			});
		}
		
		// TODO: Add Difference-Builder to settings!
//		Group grpDifference = new Group(container, SWT.NONE);
//		grpDifference.setLayout(new GridLayout(1, false));
//		grpDifference.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
//		grpDifference.setText("Difference");

		return container;
	}
	
	private void appendMatcherSettings(Composite parent) {
		
		if (config_container != null) {
			config_container.dispose();
		}

		config_container = new Composite(parent, SWT.NONE);
		{
			GridLayout grid = new GridLayout(1, false);
			grid.marginWidth = 0;
			grid.marginHeight = 0;
			config_container.setLayout(grid);
		}
		
		if (matcher instanceof IConfigurable) {
			final IConfigurable configurableMatcher = (IConfigurable) matcher;
			
			for (String option : configurableMatcher.getConfigurationOptions().keySet()) {

				final String key = option;

				// Use a checkbox for boolean values:
				if (configurableMatcher.getConfigurationOptions().get(option) instanceof Boolean) {
					final Button button = new Button(config_container, SWT.CHECK);
					button.setText(NameUtil.beautifyName(option));
					button.setSelection((Boolean) configurableMatcher.getConfigurationOptions().get(option));
					
					// Update selection:
					button.addSelectionListener(new SelectionAdapter() {

						@Override
						public void widgetSelected(SelectionEvent e) {
							if (button.getSelection()) {
								configurableMatcher.setConfigurationOption(key, true);
							} else {
								configurableMatcher.setConfigurationOption(key, false);
							}
						}
					});
				}
			}
		}

		parent.getParent().layout();
	}
	
	private static IMatcher getInitialMatcher() {
		IMatcher selectedMatcher = null;
		
		if ((matcher != null) && (matchers != null) && (matchers.contains(matcher))) {
			selectedMatcher = matcher;
		} else {
			if ((matchers != null) && (!matchers.isEmpty())) {
				
				if (matcher != null) {
					selectedMatcher = getMatcherByName(matcher.getName());
				}
				
				if (selectedMatcher == null) {
					selectedMatcher = getMatcherByNameFragment("Generic");
				}
				
				if (selectedMatcher == null) {
					selectedMatcher = matchers.iterator().next();
				}
			}
		}
		
		return selectedMatcher;
	}
	
	private static IMatcher getMatcherByName(String name) {
		for (IMatcher matcher : matchers) {
			if (matcher.getName().equalsIgnoreCase(name)) {
				return matcher;
			}
		}
		return null;
	}
	
	private static IMatcher getMatcherByNameFragment(String name) {
		for (IMatcher matcher : matchers) {
			if (matcher.getName().contains(name)) {
				return matcher;
			}
		}
		return null;
	}
	
	public static void setAvailableMatcher(Set<IMatcher> matchers) {
		RepairPreferencePage.matchers = matchers;
		matcher = getInitialMatcher();
	}
	
	public static IMatcher getSelectedMatcher() {
		return matcher;
	}
}

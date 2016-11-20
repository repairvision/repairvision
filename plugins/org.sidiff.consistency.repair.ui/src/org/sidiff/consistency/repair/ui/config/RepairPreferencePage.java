package org.sidiff.consistency.repair.ui.config;

import java.util.Set;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerComparator;
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
import org.sidiff.consistency.repair.ui.presentation.extension.RepairPresentationEntry;
import org.sidiff.consistency.repair.ui.presentation.extension.RepairPresentationLibrary;
import org.sidiff.matcher.IMatcher;

public class RepairPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	public static final String ID = "org.sidiff.consistency.repair.ui.config.mainpage";
	
	protected static final String SETUP_MATCHERS_MESSAGE = "Please add some models!";
	
	protected static final String EMPTY_MATCHERS_MESSAGE = "No matchers available for the given model type.";
	
	// TODO: IPreferenceStore store = Activator.getDefault().getPreferenceStore();
	protected static Set<IMatcher> availableMatchers;
	
	private static IMatcher matchingEngine;
	
	private static RepairDectectionEngineProvider repairEngine = new RepairDectectionEngineProvider();
	
	//// UI ////
	
	private ComboViewer viewer_matching;
	
	private Composite config_container;
	
	private ComboViewer viewer_repair;
	
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
		
		/* 
		 * Matching-Engine selection:
		 */
		Group grpMatching = new Group(container, SWT.NONE);
		{
			grpMatching.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
			grpMatching.setText("Matching");
			grpMatching.setLayout(new GridLayout(1, false));
			
			viewer_matching = new ComboViewer(grpMatching, SWT.NONE);
			Combo combo_matching = viewer_matching.getCombo();
			combo_matching.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			// Provider:
			viewer_matching.setComparator(new ViewerComparator());
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
			if (viewer_matching.getInput() != availableMatchers) {
				viewer_matching.setInput(availableMatchers);
			}
			
			if (availableMatchers == null) {
				viewer_matching.add(SETUP_MATCHERS_MESSAGE);
				viewer_matching.setSelection(new StructuredSelection(SETUP_MATCHERS_MESSAGE));
			}
			
			if ((availableMatchers != null) && (availableMatchers.isEmpty())) {
				viewer_matching.add(EMPTY_MATCHERS_MESSAGE);
				viewer_matching.setSelection(new StructuredSelection(EMPTY_MATCHERS_MESSAGE));
			}
			
			// Selection:
			matchingEngine = getInitialMatcher();
			
			if (matchingEngine != null) {
				viewer_matching.setSelection(new StructuredSelection(matchingEngine));
			}
			
			// Matcher configuration:
			appendMatcherSettings(grpMatching);
			
			// Update selected matcher:
			viewer_matching.addSelectionChangedListener(new ISelectionChangedListener() {

				@Override
				public void selectionChanged(SelectionChangedEvent event) {
					matchingEngine = getSelection();

					// Matcher configuration:
					appendMatcherSettings(grpMatching);
				}

				private IMatcher getSelection() {
					return (IMatcher) ((StructuredSelection) viewer_matching.getSelection()).getFirstElement();
				}
			});
		}
		
		/*
		 *  Repair detection:
		 */
		Group grpRepairDetection = new Group(container, SWT.NONE);
		{
			grpRepairDetection.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
			grpRepairDetection.setText("Repair Detection");
			grpRepairDetection.setLayout(new GridLayout(1, false));
			
			viewer_repair = new ComboViewer(grpRepairDetection, SWT.NONE);
			Combo combo = viewer_repair.getCombo();
			combo.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
			combo.setBounds(0, 0, 91, 23);
			
			// Provider:
			viewer_repair.setComparator(new ViewerComparator());
			viewer_repair.setContentProvider(ArrayContentProvider.getInstance());
			viewer_repair.setLabelProvider(new LabelProvider() {
				
				@Override
				public String getText(Object element) {
					
					if (element instanceof RepairPresentationEntry) {
						return ((RepairPresentationEntry) element).getName();
					}
					
					return super.getText(element);
				}
			});
			
			// Set input:
			viewer_repair.setInput(RepairPresentationLibrary.getEntries().toArray());
			
			// Set selection:
			viewer_repair.setSelection(repairEngine.getSelection());
			viewer_repair.addSelectionChangedListener(event -> {
				repairEngine.setSelection(event.getSelection());
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
		
		if (matchingEngine instanceof IConfigurable) {
			final IConfigurable configurableMatcher = (IConfigurable) matchingEngine;
			
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
		
		if ((matchingEngine != null) && (availableMatchers != null) && (availableMatchers.contains(matchingEngine))) {
			selectedMatcher = matchingEngine;
		} else {
			if ((availableMatchers != null) && (!availableMatchers.isEmpty())) {
				
				if (matchingEngine != null) {
					selectedMatcher = getMatcherByName(matchingEngine.getName());
				}
				
				if (selectedMatcher == null) {
					selectedMatcher = getMatcherByNameFragment("Generic");
				}
				
				if (selectedMatcher == null) {
					selectedMatcher = availableMatchers.iterator().next();
				}
			}
		}
		
		return selectedMatcher;
	}
	
	private static IMatcher getMatcherByName(String name) {
		for (IMatcher matcher : availableMatchers) {
			if (matcher.getName().equalsIgnoreCase(name)) {
				return matcher;
			}
		}
		return null;
	}
	
	private static IMatcher getMatcherByNameFragment(String name) {
		for (IMatcher matcher : availableMatchers) {
			if (matcher.getName().contains(name)) {
				return matcher;
			}
		}
		return null;
	}
	
	public static void setAvailableMatcher(Set<IMatcher> matchers) {
		RepairPreferencePage.availableMatchers = matchers;
		matchingEngine = getInitialMatcher();
	}
	
	public static IMatcher getSelectedMatcher() {
		return matchingEngine;
	}
	
	public static RepairDectectionEngineProvider getRepairDectectionProvider() {
		return repairEngine;
	}
}

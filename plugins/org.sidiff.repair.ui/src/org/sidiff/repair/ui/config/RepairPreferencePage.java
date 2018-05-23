package org.sidiff.repair.ui.config;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
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
import org.sidiff.consistency.common.emf.DocumentType;
import org.sidiff.consistency.common.settings.SettingsUtil;
import org.sidiff.consistency.common.ui.util.NameUtil;
import org.sidiff.difference.technical.ITechnicalDifferenceBuilder;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.difference.technical.api.util.TechnicalDifferenceUtils;
import org.sidiff.difference.technical.util.TechnicalDifferenceBuilderUtil;
import org.sidiff.matcher.IMatcher;
import org.sidiff.matcher.MatcherUtil;
import org.sidiff.repair.ui.presentation.extension.RepairPresentationEntry;
import org.sidiff.repair.ui.presentation.extension.RepairPresentationLibrary;

// TODO: IPreferenceStore store = Activator.getDefault().getPreferenceStore();
public class RepairPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	public static final String ID = "org.sidiff.repair.ui.config.mainpage";
	
	protected static final String SETUP_MATCHERS_MESSAGE = "Please add some models!";
	
	protected static final String EMPTY_MATCHERS_MESSAGE = "No matchers available for the given model type.";
	
	protected static final String SETUP_DIFFERENCE_BUILDER_MESSAGE = "Please add some models!";
	
	protected static final String EMPTY_DIFFERENCE_BUILDER_MESSAGE = "No technical difference builder available for the given model type.";
	
	//// Settings ////
	
	protected static String documentType;
	
	protected static List<IMatcher> availableMatchers;
	
	protected static IMatcher matchingEngine;
	
	protected static List<ITechnicalDifferenceBuilder> availableDifferenceBuilder;
	
	protected static ITechnicalDifferenceBuilder differenceBuilder;
	
	protected static RepairDectectionEngineProvider repairEngine = new RepairDectectionEngineProvider();
	
	//// UI ////
	
	private ComboViewer viewer_matching;
	
	private ComboViewer viewer_difference;
	
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
		 * Difference-Builder to settings:
		 */
		Group grpTechnicalDifference = new Group(container, SWT.NONE);
		{
			grpTechnicalDifference.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
			grpTechnicalDifference.setText("Technical Difference");
			grpTechnicalDifference.setLayout(new GridLayout(1, false));
			
			viewer_difference = new ComboViewer(grpTechnicalDifference, SWT.NONE);
			Combo combo_matching = viewer_difference.getCombo();
			combo_matching.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			// Provider:
			viewer_difference.setComparator(new ViewerComparator());
			viewer_difference.setContentProvider(ArrayContentProvider.getInstance());
			viewer_difference.setLabelProvider(new LabelProvider() {
				
				@Override
				public String getText(Object element) {
					
					if (element instanceof ITechnicalDifferenceBuilder) {
						return ((ITechnicalDifferenceBuilder) element).getName();
					}
					
					return super.getText(element);
				}
			});
			
			// Input:
			if (viewer_difference.getInput() != availableDifferenceBuilder) {
				viewer_difference.setInput(availableDifferenceBuilder);
			}
			
			if (availableDifferenceBuilder == null) {
				viewer_difference.add(SETUP_DIFFERENCE_BUILDER_MESSAGE);
				viewer_difference.setSelection(new StructuredSelection(SETUP_DIFFERENCE_BUILDER_MESSAGE));
			}
			
			if ((availableDifferenceBuilder != null) && (availableDifferenceBuilder.isEmpty())) {
				viewer_difference.add(EMPTY_DIFFERENCE_BUILDER_MESSAGE);
				viewer_difference.setSelection(new StructuredSelection(EMPTY_DIFFERENCE_BUILDER_MESSAGE));
			}
			
			// Selection:
			differenceBuilder = getInitialDifferenceBuilder();
			
			if (differenceBuilder != null) {
				viewer_difference.setSelection(new StructuredSelection(differenceBuilder));
				viewer_difference.refresh(true);
			}
			
			// Update selected matcher:
			viewer_difference.addSelectionChangedListener(new ISelectionChangedListener() {

				@Override
				public void selectionChanged(SelectionChangedEvent event) {
					differenceBuilder = getSelection();
				}

				private ITechnicalDifferenceBuilder getSelection() {
					return (ITechnicalDifferenceBuilder) ((StructuredSelection) viewer_difference.getSelection()).getFirstElement();
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
	
	private static ITechnicalDifferenceBuilder getInitialDifferenceBuilder() {
		ITechnicalDifferenceBuilder selectedBuilder = null;
		
		if ((differenceBuilder != null) && (availableDifferenceBuilder != null) && (availableDifferenceBuilder.contains(differenceBuilder))) {
			selectedBuilder = differenceBuilder;
		} else {
			if ((availableDifferenceBuilder != null) && (!availableDifferenceBuilder.isEmpty())) {
				ITechnicalDifferenceBuilder defaultBuilder = TechnicalDifferenceUtils.getDefaultTechnicalDifferenceBuilder(getDoumentTypes());
				
				// [WORKAROUND]: Do not reload technical difference builder...
				for (ITechnicalDifferenceBuilder builder : availableDifferenceBuilder) {
					if (defaultBuilder.getKey().equals(builder.getKey())) {
						selectedBuilder = builder;
						break;
					}
				}
			}
		}
		
		return selectedBuilder;
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
	
	public static void setAvailableMatcher(List<IMatcher> matchers) {
		RepairPreferencePage.availableMatchers = matchers;
		matchingEngine = getInitialMatcher();
	}
	
	public static ITechnicalDifferenceBuilder getSelectedTechnicalDifferenceBuilder() {
		return differenceBuilder;
	}
	
	public static void setAvailableTechnicalDifferenceBuilder(List<ITechnicalDifferenceBuilder> builders) {
		RepairPreferencePage.availableDifferenceBuilder = builders;
		differenceBuilder = getInitialDifferenceBuilder();
	}
	
	public static IMatcher getSelectedMatcher() {
		return matchingEngine;
	}
	
	public static RepairDectectionEngineProvider getRepairDectectionProvider() {
		return repairEngine;
	}
	
	public static void populateSettings(Resource model) {
		
		if ((model != null) && !model.getContents().isEmpty())  {
			
			// Document type:
			String newDocumentType = DocumentType.getDocumentType(model.getContents().get(0));
			
			if (!newDocumentType.equals(documentType)) {
				documentType = newDocumentType;
				
				// Matcher:
				setAvailableMatcher(MatcherUtil.getAvailableMatchers(getDoumentTypes()));
				
				// Technical Difference Builder:
				setAvailableTechnicalDifferenceBuilder(
						TechnicalDifferenceBuilderUtil.getAvailableTechnicalDifferenceBuilders(getDoumentTypes()));
			}
		} else {
			setAvailableMatcher(null);
			differenceBuilder = null;

			setAvailableTechnicalDifferenceBuilder(null);
			documentType = null;
		}
	}
	
	public static DifferenceSettings getMatchingSettings() {

		// Matching-Settings:
		if (documentType != null) {
			DifferenceSettings settings = SettingsUtil.getDefaultDifferenceSettings();
			settings.setMatcher(getSelectedMatcher());
			settings.setTechBuilder(getSelectedTechnicalDifferenceBuilder());
			return settings;
		}
		
		return null;
	}

	public static String getDoumentType() {
		return documentType;
	}
	
	public static Set<String> getDoumentTypes() {
		return Collections.singleton(documentType);
	}
}

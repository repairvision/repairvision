package org.sidiff.revision.repair.ui.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.sidiff.common.utilities.emf.DocumentType;
import org.sidiff.common.utilities.ui.util.NameUtil;
import org.sidiff.configuration.IConfigurable;
import org.sidiff.history.revision.util.SettingsUtil;
import org.sidiff.matcher.IMatcher;
import org.sidiff.matcher.MatcherUtil;
import org.sidiff.revision.difference.derivation.ITechnicalDifferenceBuilder;
import org.sidiff.revision.difference.derivation.api.settings.DifferenceSettings;
import org.sidiff.revision.difference.derivation.api.util.TechnicalDifferenceUtils;
import org.sidiff.revision.difference.derivation.util.TechnicalDifferenceBuilderUtil;
import org.sidiff.revision.editrules.project.development.registry.WorkspaceRulebaseExtension;
import org.sidiff.revision.editrules.project.development.registry.WorkspaceRulebaseRegistry;
import org.sidiff.revision.editrules.project.registry.RulebaseExtension;
import org.sidiff.revision.editrules.project.registry.RulebaseRegistry;
import org.sidiff.revision.repair.ui.presentation.extension.RepairPresentationEntry;
import org.sidiff.revision.repair.ui.presentation.extension.RepairPresentationLibrary;
import org.sidiff.validation.constraint.project.registry.ConstraintLibraryExtension;
import org.sidiff.validation.constraint.project.registry.ConstraintLibraryRegistry;

// TODO: IPreferenceStore store = Activator.getDefault().getPreferenceStore();
public class RepairPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	public static final String ID = "org.sidiff.revision.repair.ui.config.mainpage";
	
	protected static final String SETUP_MATCHERS_MESSAGE = "Please select some models!";
	
	protected static final String EMPTY_MATCHERS_MESSAGE = "No matchers available for the given model type.";
	
	protected static final String SETUP_DIFFERENCE_BUILDER_MESSAGE = "Please select some models!";
	
	protected static final String EMPTY_DIFFERENCE_BUILDER_MESSAGE = "No technical difference builder available for the given model type.";
	
	//// Settings ////
	
	protected static String documentType;
	
	protected static List<IMatcher> availableMatchers;
	
	protected static IMatcher matchingEngine;
	
	protected static List<ITechnicalDifferenceBuilder> availableDifferenceBuilder;
	
	protected static ITechnicalDifferenceBuilder differenceBuilder;
	
	protected static UserInterfaceProvider userInterfaceProvider = new UserInterfaceProvider();
	
	protected static List<RulebaseExtension> availableRulebases;
	
	protected static List<RulebaseExtension> rulebases;
	
	protected static List<ConstraintLibraryExtension> availableConstraintLibraries;
	
	protected static List<ConstraintLibraryExtension> constraintLibraries;
	
	//// UI ////
	
	private ComboViewer viewer_matching;
	
	private ComboViewer viewer_difference;
	
	private Composite config_container; // shows settings based on selected matcher
	
	private ComboViewer viewer_repair;
	
	private CheckboxTableViewer editRulesViewer;
	
	private CheckboxTableViewer constraintViewer;
	
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
		
		createMatchingConfiguration(container);
		createTechnicalDifferenceBuilderConfiguration(container);
		createRepairConfiguration(container);

		return container;
	}

	private void createMatchingConfiguration(Composite container) {
		
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

	private void createTechnicalDifferenceBuilderConfiguration(Composite container) {
		
		Group grpTechnicalDifference = new Group(container, SWT.NONE);
		{
			grpTechnicalDifference.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
			grpTechnicalDifference.setText("Technical RevisionDifference");
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
	}

	private void createRepairConfiguration(Composite container) {
		
		Group grpRepair = new Group(container, SWT.NONE);
		{
			grpRepair.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
			grpRepair.setText("Repair");
			grpRepair.setLayout(new GridLayout(2, false));
			
			createUserInterfaceSelection(grpRepair);
			createEditRulesTable(grpRepair);
			createConstraintTable(grpRepair);
		}
	}

	private void createUserInterfaceSelection(Group grpRepair) {
		
		Label lblInterface = new Label(grpRepair, SWT.NONE);
		{
			lblInterface.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			lblInterface.setText("User Interface: ");

			viewer_repair = new ComboViewer(grpRepair, SWT.NONE);
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
			viewer_repair.setSelection(userInterfaceProvider.getSelection());

			viewer_repair.addSelectionChangedListener(event -> {
				userInterfaceProvider.setSelection(event.getSelection());
			});
		}
	}

	private void createEditRulesTable(Group grpRepair) {
		
		Label lblEditRules = new Label(grpRepair, SWT.NONE);
		{
			lblEditRules.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
			lblEditRules.setText("Edit Rules:");

			editRulesViewer = CheckboxTableViewer.newCheckList(grpRepair, SWT.BORDER | SWT.FULL_SELECTION);
			Table editRulesTable = editRulesViewer.getTable();
			editRulesTable.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 2, 1));
			
			// Provider:
			editRulesViewer.setComparator(new ViewerComparator());
			editRulesViewer.setContentProvider(ArrayContentProvider.getInstance());
			editRulesViewer.setLabelProvider(new LabelProvider() {

				@Override
				public String getText(Object element) {

					if (element instanceof RulebaseExtension) {
						RulebaseExtension rulebase = (RulebaseExtension) element;
						return rulebase.getName() + " (" + rulebase.getDocumentType() + ")";
					}

					return super.getText(element);
				}
			});
			
			// Set input:
			initializeRulebases();
			editRulesViewer.setInput(availableRulebases.toArray());

			// Set selection:
			editRulesViewer.setAllChecked(false);
			editRulesViewer.setCheckedElements(rulebases.toArray());

			editRulesViewer.addSelectionChangedListener(event -> {
				rulebases.clear();
				
				for (Object checked : editRulesViewer.getCheckedElements()) {
					if (checked instanceof RulebaseExtension) {
						rulebases.add((RulebaseExtension) checked);
					}
				}
			});
		}
	}

	private void createConstraintTable(Group grpRepair) {
		
		Label lblConstraint = new Label(grpRepair, SWT.NONE);
		{
			lblConstraint.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
			lblConstraint.setText("Constraints:");

			constraintViewer = CheckboxTableViewer.newCheckList(grpRepair, SWT.BORDER | SWT.FULL_SELECTION);
			Table validationTable = constraintViewer.getTable();
			validationTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
			
			// Provider:
			constraintViewer.setComparator(new ViewerComparator());
			constraintViewer.setContentProvider(ArrayContentProvider.getInstance());
			constraintViewer.setLabelProvider(new LabelProvider() {

				@Override
				public String getText(Object element) {

					if (element instanceof ConstraintLibraryExtension) {
						ConstraintLibraryExtension library = (ConstraintLibraryExtension) element;
						return library.getName() + " (" + library.getDocumentTypes().stream().collect(Collectors.joining (", ")) + ")";
					}

					return super.getText(element);
				}
			});
			
			// Set input:
			initializeConstraintLibraries();
			constraintViewer.setInput(constraintLibraries.toArray());

			// Set selection:
			constraintViewer.setAllChecked(false);
			constraintViewer.setCheckedElements(constraintLibraries.toArray());

			constraintViewer.addSelectionChangedListener(event -> {
				constraintLibraries.clear();
				
				for (Object checked : constraintViewer.getCheckedElements()) {
					if (checked instanceof ConstraintLibraryExtension) {
						constraintLibraries.add((ConstraintLibraryExtension) checked);
					}
				}
			});
		}
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
	
	public static UserInterfaceProvider getUserInterfaceProvider() {
		return userInterfaceProvider;
	}
	
	public static List<RulebaseExtension> getRulebases() {
		
		if (rulebases == null) {
			initializeRulebases();
		}
		
		return rulebases;
	}
	
	private static List<RulebaseExtension> initializeRulebases() {
		
		// Load runtime:
		if (availableRulebases == null) {
			availableRulebases = new ArrayList<>(RulebaseRegistry.getRulebases());
			rulebases = new ArrayList<>(availableRulebases);
		}
		
		// Update form workspace:
		for (WorkspaceRulebaseExtension rulebase : WorkspaceRulebaseRegistry.getRulebases(" [Workspace]")) {
			if (!availableRulebases.contains(rulebase)) {
				availableRulebases.add(rulebase);
			}
		}
		
		return availableRulebases;
	}
	
	public static List<ConstraintLibraryExtension> getConstraintLibraries() {
		
		if (constraintLibraries == null) {
			initializeConstraintLibraries();
		}
		
		return constraintLibraries;
	}
	
	private static void initializeConstraintLibraries() {
		if (availableConstraintLibraries == null) {
			availableConstraintLibraries = new ArrayList<>(ConstraintLibraryRegistry.getConstraintLibraries());
			constraintLibraries = new ArrayList<>(availableConstraintLibraries);
		}
	}
	
	public static void populateSettings(Resource model) {
		
		if ((model != null) && !model.getContents().isEmpty())  {
			
			// Document type:
			String newDocumentType = DocumentType.getDocumentType(model.getContents().get(0));
			
			if (!newDocumentType.equals(documentType)) {
				documentType = newDocumentType;
				
				// Matcher:
				setAvailableMatcher(MatcherUtil.getAvailableMatchers(getDoumentTypes()));
				
				// Technical RevisionDifference Builder:
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

package org.sidiff.revision.ui.configuration.page;

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
import org.sidiff.history.revision.util.SettingsUtil;
import org.sidiff.revision.common.emf.document.DocumentType;
import org.sidiff.revision.common.utilities.string.NameUtil;
import org.sidiff.revision.difference.api.registry.DifferenceBuilderRegistry;
import org.sidiff.revision.difference.api.registry.MatcherRegistry;
import org.sidiff.revision.difference.api.settings.DifferenceSettings;
import org.sidiff.revision.difference.builder.IDifferenceBuilderProvider;
import org.sidiff.revision.difference.matcher.IConfigurableMatcherProvider;
import org.sidiff.revision.difference.matcher.IMatcherProvider;
import org.sidiff.revision.editrules.project.development.registry.WorkspaceRulebaseExtension;
import org.sidiff.revision.editrules.project.development.registry.WorkspaceRulebaseRegistry;
import org.sidiff.revision.editrules.project.registry.RulebaseExtension;
import org.sidiff.revision.editrules.project.registry.RulebaseRegistry;
import org.sidiff.revision.ui.presentation.extension.ComplementationPresentationEntry;
import org.sidiff.revision.ui.presentation.extension.ComplementationPresentationLibrary;
import org.sidiff.validation.constraint.project.registry.ConstraintLibraryExtension;
import org.sidiff.validation.constraint.project.registry.ConstraintLibraryRegistry;

// TODO: IPreferenceStore store = Activator.getDefault().getPreferenceStore();
public class ComplementationPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	public static final String ID = "org.sidiff.revision.ui.configuration.mainpage";
	
	protected static final String SETUP_MATCHERS_MESSAGE = "Please select some models!";
	
	protected static final String EMPTY_MATCHERS_MESSAGE = "No matchers available for the given model type.";
	
	protected static final String SETUP_DIFFERENCE_BUILDER_MESSAGE = "Please select some models!";
	
	protected static final String EMPTY_DIFFERENCE_BUILDER_MESSAGE = "No technical difference builder available for the given model type.";
	
	//// Settings ////
	
	protected static String documentType;
	
	protected static List<IMatcherProvider> availableMatchers;
	
	protected static IMatcherProvider matchingEngine;
	
	protected static List<IDifferenceBuilderProvider> availableDifferenceBuilder;
	
	protected static IDifferenceBuilderProvider differenceBuilderProvider;
	
	protected static UserInterfaceProvider userInterfaceProvider = new UserInterfaceProvider();
	
	protected static List<RulebaseExtension> availableRulebases;
	
	protected static List<RulebaseExtension> rulebases;
	
	protected static List<ConstraintLibraryExtension> availableConstraintLibraries;
	
	protected static List<ConstraintLibraryExtension> constraintLibraries;
	
	//// UI ////
	
	private ComboViewer viewer_matching;
	
	private ComboViewer viewer_difference;
	
	private Composite config_container; // shows settings based on selected matcher
	
	private ComboViewer viewer_complementations;
	
	private CheckboxTableViewer editRulesViewer;
	
	private CheckboxTableViewer constraintViewer;
	
	/**
	 * Create the preference page.
	 */
	public ComplementationPreferencePage() {
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
		createConfiguration(container);

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
					
					if (element instanceof IMatcherProvider) {
						return ((IMatcherProvider) element).getName();
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

				private IMatcherProvider getSelection() {
					return (IMatcherProvider) ((StructuredSelection) viewer_matching.getSelection()).getFirstElement();
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
		
		if (matchingEngine instanceof IConfigurableMatcherProvider) {
			final IConfigurableMatcherProvider configurableMatcherProvider = (IConfigurableMatcherProvider) matchingEngine;
			
			for (String option : configurableMatcherProvider.getConfiguration().keySet()) {

				final String key = option;

				// Use a checkbox for boolean values:
				if (configurableMatcherProvider.getConfiguration().get(option) instanceof Boolean) {
					final Button button = new Button(config_container, SWT.CHECK);
					button.setText(NameUtil.beautifyName(option));
					button.setSelection((Boolean) configurableMatcherProvider.getConfiguration().get(option));
					
					// Update selection:
					button.addSelectionListener(new SelectionAdapter() {

						@Override
						public void widgetSelected(SelectionEvent e) {
							if (button.getSelection()) {
								configurableMatcherProvider.setConfiguration(key, true);
							} else {
								configurableMatcherProvider.setConfiguration(key, false);
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
					
					if (element instanceof IDifferenceBuilderProvider) {
						return ((IDifferenceBuilderProvider) element).getName();
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
			differenceBuilderProvider = getInitialDifferenceBuilder();
			
			if (differenceBuilderProvider != null) {
				viewer_difference.setSelection(new StructuredSelection(differenceBuilderProvider));
				viewer_difference.refresh(true);
			}
			
			// Update selected matcher:
			viewer_difference.addSelectionChangedListener(new ISelectionChangedListener() {

				@Override
				public void selectionChanged(SelectionChangedEvent event) {
					differenceBuilderProvider = getSelection();
				}

				private IDifferenceBuilderProvider getSelection() {
					return (IDifferenceBuilderProvider) ((StructuredSelection) viewer_difference.getSelection()).getFirstElement();
				}
			});
		}
	}

	private void createConfiguration(Composite container) {
		
		Group grpComplementation = new Group(container, SWT.NONE);
		{
			grpComplementation.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
			grpComplementation.setText("Complementation");
			grpComplementation.setLayout(new GridLayout(2, false));
			
			createUserInterfaceSelection(grpComplementation);
			createEditRulesTable(grpComplementation);
			createConstraintTable(grpComplementation);
		}
	}

	private void createUserInterfaceSelection(Group grpComplementation) {
		
		Label lblInterface = new Label(grpComplementation, SWT.NONE);
		{
			lblInterface.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			lblInterface.setText("User Interface: ");

			viewer_complementations = new ComboViewer(grpComplementation, SWT.NONE);
			Combo combo = viewer_complementations.getCombo();
			combo.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
			combo.setBounds(0, 0, 91, 23);

			// Provider:
			viewer_complementations.setComparator(new ViewerComparator());
			viewer_complementations.setContentProvider(ArrayContentProvider.getInstance());
			viewer_complementations.setLabelProvider(new LabelProvider() {

				@Override
				public String getText(Object element) {

					if (element instanceof ComplementationPresentationEntry) {
						return ((ComplementationPresentationEntry) element).getName();
					}

					return super.getText(element);
				}
			});

			// Set input:
			viewer_complementations.setInput(ComplementationPresentationLibrary.getEntries().toArray());

			// Set selection:
			viewer_complementations.setSelection(userInterfaceProvider.getSelection());

			viewer_complementations.addSelectionChangedListener(event -> {
				userInterfaceProvider.setSelection(event.getSelection());
			});
		}
	}

	private void createEditRulesTable(Group grpComplementation) {
		
		Label lblEditRules = new Label(grpComplementation, SWT.NONE);
		{
			lblEditRules.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
			lblEditRules.setText("Edit Rules:");

			editRulesViewer = CheckboxTableViewer.newCheckList(grpComplementation, SWT.BORDER | SWT.FULL_SELECTION);
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

	private void createConstraintTable(Group grpComplementation) {
		
		Label lblConstraint = new Label(grpComplementation, SWT.NONE);
		{
			lblConstraint.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
			lblConstraint.setText("Constraints:");

			constraintViewer = CheckboxTableViewer.newCheckList(grpComplementation, SWT.BORDER | SWT.FULL_SELECTION);
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

	private static IMatcherProvider getInitialMatcher() {
		IMatcherProvider selectedMatcher = null;
		
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
	
	private static IDifferenceBuilderProvider getInitialDifferenceBuilder() {
		IDifferenceBuilderProvider selectedBuilder = null;
		
		if ((differenceBuilderProvider != null) && (availableDifferenceBuilder != null) && (availableDifferenceBuilder.contains(differenceBuilderProvider))) {
			selectedBuilder = differenceBuilderProvider;
		} else {
			if ((availableDifferenceBuilder != null) && (!availableDifferenceBuilder.isEmpty())) {
				IDifferenceBuilderProvider defaultBuilder = DifferenceBuilderRegistry.getGenericTechnicalDifferenceBuilder();
				
				// [WORKAROUND]: Do not reload technical difference builder...
				for (IDifferenceBuilderProvider builder : availableDifferenceBuilder) {
					if (defaultBuilder.getKey().equals(builder.getKey())) {
						selectedBuilder = builder;
						break;
					}
				}
			}
		}
		
		return selectedBuilder;
	}
	
	private static IMatcherProvider getMatcherByName(String name) {
		for (IMatcherProvider matcherProvider : availableMatchers) {
			if (matcherProvider.getName().equalsIgnoreCase(name)) {
				return matcherProvider;
			}
		}
		return null;
	}
	
	private static IMatcherProvider getMatcherByNameFragment(String name) {
		for (IMatcherProvider matcherProvider : availableMatchers) {
			if (matcherProvider.getName().contains(name)) {
				return matcherProvider;
			}
		}
		return null;
	}
	
	public static void setAvailableMatcher(List<IMatcherProvider> matcherProviders) {
		ComplementationPreferencePage.availableMatchers = matcherProviders;
		matchingEngine = getInitialMatcher();
	}
	
	public static IDifferenceBuilderProvider getSelectedTechnicalDifferenceBuilder() {
		return differenceBuilderProvider;
	}
	
	public static void setAvailableTechnicalDifferenceBuilder(List<IDifferenceBuilderProvider> builders) {
		ComplementationPreferencePage.availableDifferenceBuilder = builders;
		differenceBuilderProvider = getInitialDifferenceBuilder();
	}
	
	public static IMatcherProvider getSelectedMatcher() {
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
				setAvailableMatcher(MatcherRegistry.getAvailableMatchers(getDoumentTypes()));
				
				// Technical RevisionDifference Builder:
				setAvailableTechnicalDifferenceBuilder(
						DifferenceBuilderRegistry.getAvailableTechnicalDifferenceBuilders(getDoumentTypes()));
			}
		} else {
			setAvailableMatcher(null);
			differenceBuilderProvider = null;

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

package org.sidiff.consistency.graphpattern.matcher.ui.views;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;
import org.sidiff.consistency.graphpattern.EObjectList;
import org.sidiff.consistency.graphpattern.matcher.ui.Activator;
import org.sidiff.consistency.graphpattern.matcher.ui.util.InfoConsole;

public class MatchViewer extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.sidiff.consistency.graphpattern.matcher.ui.views.MatchViewer";

	/**
	 * The EMF-Model viewer showing the graph pattern.
	 */
	private TreeViewer viewer_matching;

	/**
	 * Some application logic of the viewer.
	 */
	private MatchViewerApp viewerApp;

	/**
	 * Step into tree branches.
	 */
	private DrillDownAdapter drillDownAdapter;
	
	private Action generateMatches;

	private Action printInfoAction;
	
	private Action visualizeSelectMatch;

	public MatchViewer() {
	}

	public void createPartControl(Composite parent) {

		// EMF Adapter (Item-Provider) Registry:
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		// Display model resources:
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());

		// If the model is not in the registry then display it as in EMF-Reflective-Editor:
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		parent.setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite = new Composite(parent, SWT.NONE);
		{
			GridLayout gl_composite = new GridLayout(1, false);
			gl_composite.verticalSpacing = 0;
			gl_composite.marginWidth = 0;
			gl_composite.marginHeight = 0;
			composite.setLayout(gl_composite);
		}

		SashForm sashForm = new SashForm(composite, SWT.VERTICAL);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		// Create the tree viewer:
		viewer_matching = new TreeViewer(sashForm, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		{
			viewer_matching.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
			viewer_matching.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
			
			viewer_matching.addSelectionChangedListener(new ISelectionChangedListener() {
				
				@Override
				public void selectionChanged(SelectionChangedEvent event) {
					Object selection = ((IStructuredSelection) event.getSelection()).getFirstElement();
					
					if (selection instanceof EObjectList) {
						viewerApp.setMatch((EObjectList) selection);
					}
				}
			});
		}

		// Create the Drill Down Adapter:
		drillDownAdapter = new DrillDownAdapter(viewer_matching);

		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer_matching.getControl(), 
				"org.sidiff.consistency.graphpattern.matcher.ui.viewer");
		
		// Register workbench selection provider:
		getSite().setSelectionProvider(viewer_matching);

		// Application logic:
		viewerApp = new MatchViewerApp(viewer_matching);
		
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				MatchViewer.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer_matching.getControl());
		viewer_matching.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer_matching);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(new Separator());
		manager.add(printInfoAction);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(new Separator());
		manager.add(printInfoAction);
		manager.add(visualizeSelectMatch);
		manager.add(new Separator());

		drillDownAdapter.addNavigationActions(manager);

		// Other plug-ins can contribute there actions here:
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(generateMatches);
		manager.add(new Separator());
		manager.add(printInfoAction);
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
	}

	private void makeActions() {
		
		// Generate the matchings:
		generateMatches = new Action() {
			public void run() {
//				Job job = new Job("Generate the matchings") {
//
//					@Override
//					protected IStatus run(IProgressMonitor monitor) {
						viewerApp.generateMatches();
//						return Status.OK_STATUS;
//					}
//				};
//
//				// Start the Job
//				job.schedule(); 
			}
		};
		generateMatches.setText("Generate Matches");
		generateMatches.setToolTipText("Generate Matches");
		generateMatches.setImageDescriptor(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, 
				"icons/generate_matches.gif"));

		// Print element on console:
		printInfoAction = new Action() {
			public void run() {
				ISelection selection = viewer_matching.getSelection();
				Object selectedElement = ((IStructuredSelection)selection).getFirstElement();
				InfoConsole.printInfo(selectedElement);
			}
		};
		printInfoAction.setText("Print Element");
		printInfoAction.setToolTipText("Print Element");
		printInfoAction.setImageDescriptor(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, 
				"icons/print_info.gif"));
		
		// Visualize match -> Diagram / Matching Engine Viewer
		visualizeSelectMatch = new Action() {
			public void run() {
				ISelection selection = viewer_matching.getSelection();
				Object selectedElement = ((IStructuredSelection)selection).getFirstElement();
				
				// TODO
//				viewerApp.visualizeMatch(selectedElement);
			}
		};
		visualizeSelectMatch.setText("Visualize Match");
		visualizeSelectMatch.setToolTipText("Visualize Match");
		visualizeSelectMatch.setImageDescriptor(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, 
				"icons/select_match.gif"));
	}

	private void hookDoubleClickAction() {

		// Expand / Collapse on double click:
		viewer_matching.addDoubleClickListener(event -> {
			ISelection selection = event.getSelection();

			if (selection instanceof IStructuredSelection) {
				Object item = ((IStructuredSelection) selection).getFirstElement();

				if (item == null) {
					return;
				}
				if (viewer_matching.getExpandedState(item)) {
					viewer_matching.collapseToLevel(item, 1);
				}
				else {
					viewer_matching.expandToLevel(item, 1);
				}
			}
		});
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer_matching.getControl().setFocus();
	}
}


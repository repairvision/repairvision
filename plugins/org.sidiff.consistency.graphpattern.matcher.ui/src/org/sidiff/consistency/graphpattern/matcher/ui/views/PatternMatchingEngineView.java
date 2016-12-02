package org.sidiff.consistency.graphpattern.matcher.ui.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;
import org.sidiff.consistency.graphpattern.matcher.ui.Activator;
import org.sidiff.consistency.graphpattern.matcher.ui.util.SiriusUtil;
import org.sidiff.graphpattern.matcher.extensions.MatchingEngineFactoryEntry;
import org.sidiff.graphpattern.matcher.extensions.MatchingEngineFactoryLibrary;

public class PatternMatchingEngineView extends ViewPart implements ISelectionListener {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.sidiff.consistency.graphpattern.matcher.ui.views.PatternMatchingEngineView";
	
	/**
	 * The EMF-Model viewer showing the graph pattern.
	 */
	private TreeViewer viewer_pattern;

	/**
	 * The list viewer showing the target models.
	 */
	private TableViewer viewer_models;
	
	/**
	 * List of selectable engines.
	 */
	private ComboViewer viewer_engines;

	/**
	 * Some application logic of the viewer.
	 */
	private PatternMatchingEngineViewApp viewerApp;

	/**
	 * Step into tree branches.
	 */
	private DrillDownAdapter drillDownAdapter;

	private Action resumeBreakpoints;

	private Action actionStartDebugger;
	
	private Action actionStartEngine;

	private Action printInfoAction;
	
	private class NameSorter extends ViewerComparator {
	}

	public PatternMatchingEngineView() {
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
		GridLayout gl_composite = new GridLayout(1, false);
		gl_composite.verticalSpacing = 0;
		gl_composite.marginWidth = 0;
		gl_composite.marginHeight = 0;
		composite.setLayout(gl_composite);

		SashForm sashForm = new SashForm(composite, SWT.VERTICAL);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		// Create the tree viewer:
		viewer_pattern = new TreeViewer(sashForm, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		{
			viewer_pattern.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
			viewer_pattern.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
			viewer_pattern.setComparator(new NameSorter());
		}

		// Create the Drill Down Adapter:
		drillDownAdapter = new DrillDownAdapter(viewer_pattern);

		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer_pattern.getControl(), 
				"org.sidiff.consistency.graphpattern.matcher.ui.viewer");
		getSite().setSelectionProvider(viewer_pattern);

		int dndOperations = DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { 
				LocalTransfer.getInstance(), 
				LocalSelectionTransfer.getTransfer(), 
				FileTransfer.getInstance() };

		// List of target models:
		// TODO: Replace this with the ModelDropWidget!
		viewer_models = new TableViewer(sashForm, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		{
			viewer_models.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
			viewer_models.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
			viewer_models.setComparator(new NameSorter());
			viewer_models.add(PatternMatchingEngineViewApp.MSG_MODEL_DROP_INFO);
		}

		viewer_models.addDropSupport(dndOperations, transfers, new ViewerDropAdapter(viewer_models) {

			@Override
			public boolean validateDrop(Object target, int operation, TransferData transferType) {
				return true;
			}

			@SuppressWarnings("unchecked")
			@Override
			public boolean performDrop(Object data) {

				if (data instanceof StructuredSelection) {
					StructuredSelection selection = (StructuredSelection) data;

					selection.iterator().forEachRemaining(element -> {
						if (element instanceof IResource) {
							viewerApp.addModel((IResource) element);
						}
					});
					return true;
				}
				return false;
			}
		});
		
		viewer_models.addDragSupport(DND.DROP_MOVE, transfers, new ViewerDragAdapter(viewer_models) {
			
			@Override
			public void dragFinished(DragSourceEvent event) {
				super.dragFinished(event);
				Object selection = ((StructuredSelection) viewer_models.getSelection()).getFirstElement();
				
				if (selection instanceof Resource) {
					viewerApp.removeModel((Resource) selection);
				}
			}
		});

		// Configure size of the sash form:
		sashForm.setWeights(new int[] {10, 1});

		// Engine selection:
		viewer_engines = new ComboViewer(composite, SWT.NONE);
		{
			Combo combo = viewer_engines.getCombo();
			combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			// Provider:
			viewer_engines.setContentProvider(ArrayContentProvider.getInstance());
			viewer_engines.setLabelProvider(new LabelProvider() {
				@Override
				public String getText(Object element) {
					if (element instanceof MatchingEngineFactoryEntry) {
						return ((MatchingEngineFactoryEntry) element).getName();
					}
					return super.getText(element);
				}
			});
			
			// Input:
			viewer_engines.setInput(MatchingEngineFactoryLibrary.getEntries().toArray());
		}

		// Application logic:
		viewerApp = new PatternMatchingEngineViewApp(viewer_pattern, viewer_models, viewer_engines);
		
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
		setupWorkbenchListener();
	}

	private void setupWorkbenchListener() {

		// Listen to the workbench:
		getSite().getWorkbenchWindow().getSelectionService().addSelectionListener(this);

		// Remove input on editor close:
		// Workbench Editor/View activate/close... listener:
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService().addPartListener(new IPartListener() {

			@Override
			public void partActivated(IWorkbenchPart part) {
				viewerApp.setInputFromEditor(part);
			}

			@Override
			public void partBroughtToTop(IWorkbenchPart part) {}

			@Override
			public void partClosed(IWorkbenchPart part) {
				if (part == viewerApp.getActivePart()) {
					viewerApp.clearInput();
				}
			}

			@Override
			public void partDeactivated(IWorkbenchPart part) {}

			@Override
			public void partOpened(IWorkbenchPart part) {}
		});
		
		// Try active editor as input:
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		viewerApp.setInputFromEditor(editor);
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {

		if (selection instanceof StructuredSelection) {
			List<Object> newSelections = SiriusUtil.getSemanticElements(selection);

			if ((newSelections.size() != viewer_pattern.getStructuredSelection().size())) {
				viewer_pattern.setSelection(new StructuredSelection(newSelections));
			} else {
				List<Object> selectionDiff = new ArrayList<>(newSelections);
				selectionDiff.removeAll(viewer_pattern.getStructuredSelection().toList());

				if (!selectionDiff.isEmpty()) {
					viewer_pattern.setSelection(new StructuredSelection(newSelections));
				}
			}
		}
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				PatternMatchingEngineView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer_pattern.getControl());
		viewer_pattern.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer_pattern);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(resumeBreakpoints);
		manager.add(actionStartDebugger);
		manager.add(new Separator());
		manager.add(printInfoAction);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(resumeBreakpoints);
		manager.add(actionStartDebugger);
		manager.add(new Separator());
		manager.add(printInfoAction);
		manager.add(new Separator());

		drillDownAdapter.addNavigationActions(manager);

		// Other plug-ins can contribute there actions here:
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(actionStartEngine);
		manager.add(new Separator());
		manager.add(actionStartDebugger);
		manager.add(resumeBreakpoints);
		manager.add(new Separator());
		manager.add(printInfoAction);
		manager.add(new Separator());
		
		drillDownAdapter.addNavigationActions(manager);
	}

	private void makeActions() {
		
		// Starts the pattern matching engine:
		actionStartEngine = new Action() {
			public void run() {
				viewerApp.startPatternMatchingEngine();
			}
		};
		actionStartEngine.setText("Start Pattern Matching Engine");
		actionStartEngine.setToolTipText("Start Pattern Matching Engine");
		actionStartEngine.setImageDescriptor(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, 
				"icons/run.gif"));
		
		// Starts the pattern matching debugger:
		actionStartDebugger = new Action() {
			public void run() {
				viewerApp.startPatternMatchingDebugger();
			}
		};
		actionStartDebugger.setText("Start Pattern Matching Debugger");
		actionStartDebugger.setToolTipText("Start Pattern Matching Debugger");
		actionStartDebugger.setImageDescriptor(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, 
				"icons/debug.gif"));
		
		// Resume the pattern matching engine:
		resumeBreakpoints = new Action() {
			public void run() {
				viewerApp.resumeAllBreakpoints();
			}
		};
		resumeBreakpoints.setText("Resume Pattern Matching Engine");
		resumeBreakpoints.setToolTipText("Resume Pattern Matching Engine");
		resumeBreakpoints.setImageDescriptor(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, 
				"icons/stepover.gif"));

		// Print element on console:
		printInfoAction = new Action() {
			public void run() {
				viewerApp.printSelection(viewer_pattern.getSelection());
			}
		};
		printInfoAction.setText("Print Element");
		printInfoAction.setToolTipText("Print Element");
		printInfoAction.setImageDescriptor(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, 
				"icons/print_info.gif"));
	}

	private void hookDoubleClickAction() {

		// Expand / Collapse on double click:
		viewer_pattern.addDoubleClickListener(event -> {
			ISelection selection = event.getSelection();

			if (selection instanceof IStructuredSelection) {
				Object item = ((IStructuredSelection) selection).getFirstElement();

				if (item == null) {
					return;
				}
				if (viewer_pattern.getExpandedState(item)) {
					viewer_pattern.collapseToLevel(item, 1);
				}
				else {
					viewer_pattern.expandToLevel(item, 1);
				}
			}
		});
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer_pattern.getControl().setFocus();
	}
}

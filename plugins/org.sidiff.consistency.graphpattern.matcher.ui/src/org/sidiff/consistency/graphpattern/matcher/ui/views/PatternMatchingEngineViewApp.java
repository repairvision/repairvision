package org.sidiff.consistency.graphpattern.matcher.ui.views;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;
import org.sidiff.consistency.common.ui.InfoConsole;
import org.sidiff.consistency.common.ui.WorkbenchUtil;
import org.sidiff.consistency.graphpattern.GraphPattern;
import org.sidiff.consistency.graphpattern.matcher.ui.session.EngineManager;
import org.sidiff.consistency.graphpattern.matcher.ui.util.SiriusUtil;
import org.sidiff.graphpattern.matcher.IPatternMatchingEngineFactory;
import org.sidiff.graphpattern.matcher.debug.PatternMatchingDebugger.Breakpoint;
import org.sidiff.graphpattern.matcher.debug.PatternMatchingDebugger.BreakpointListener;
import org.sidiff.graphpattern.matcher.debug.PatternMatchingDebugger.Termination;
import org.sidiff.graphpattern.matcher.extensions.MatchingEngineFactoryEntry;

public class PatternMatchingEngineViewApp implements BreakpointListener {

	/**
	 * Model DnD-List message.
	 */
	protected static final String MSG_MODEL_DROP_INFO = "Please drop the target model(s) here!";
	
	/**
	 * Empty selection console message.
	 */
	public static final String MSG_EMPTY_SELECTION = "Please select an element!";
	
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
	 * The last active workbench part.
	 */
	private IWorkbenchPart activePart;
	
	public PatternMatchingEngineViewApp(
			TreeViewer viewer_pattern, TableViewer viewer_models, ComboViewer viewer_engines) {
		this.viewer_pattern = viewer_pattern;
		this.viewer_models = viewer_models;
		this.viewer_engines = viewer_engines;
	}
	
	public void setInputFromEditor(IWorkbenchPart part) {

		if (activePart != part) {
			GraphPattern newGraphpattern = SiriusUtil.getGraphPattern(part);
			
			if (newGraphpattern != null) {
				EngineManager.getInstance().setGraphpattern(newGraphpattern);
				activePart = part;
				
				if (!viewer_pattern.getTree().isDisposed()) {
					viewer_pattern.setInput(newGraphpattern);
				}
			}
		}
	}
	
	public void clearInput() {
		EngineManager.getInstance().setGraphpattern(null);
		activePart = null;	
		
		if (!viewer_pattern.getTree().isDisposed()) {
			viewer_pattern.setInput(null);
			clearModels();
		}
	}
	
	public void addModel(IResource modelResource) {
		viewer_models.remove(MSG_MODEL_DROP_INFO);
		viewer_models.add(EngineManager.getInstance().loadModel(modelResource));
	}
	
	public void removeModel(Resource modelResource) {
		viewer_models.remove(modelResource);
		EngineManager.getInstance().removeModel(modelResource);
		
		if (viewer_models.getTable().getItemCount() == 0) {
			clearModels();
		}
	}
	
	private void clearModels() {
		if (!viewer_models.getTable().isDisposed()) {
			EngineManager.getInstance().clearModels();
			
			viewer_models.setInput(null);
			viewer_models.add(MSG_MODEL_DROP_INFO);
		}
	}

	private IPatternMatchingEngineFactory<?> getSelectedPatternMatchingEngine() {
		MatchingEngineFactoryEntry selectedEngine = (MatchingEngineFactoryEntry) 
				((StructuredSelection) viewer_engines.getSelection()).getFirstElement();
		
		if (selectedEngine != null) {
			if (!EngineManager.getInstance().getModels().isEmpty()) {
				return selectedEngine.getInstance();
			} else {
				WorkbenchUtil.showMessage("Please add a target model!");
				return null;
			}
		} else {
			WorkbenchUtil.showMessage("Please select a pattern matching engine!");
			return null;
		}
	}
	
	public void startPatternMatchingEngine() {
		Job job = new Job("Search matchings") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				
				// Calculate the matching:
				Display.getDefault().syncExec(() -> {
					// Start the matching engine:
					EngineManager.getInstance().startEngine(getSelectedPatternMatchingEngine());
					
					// Generate the matches:
					generateMatcher();
				});
				
				// UI update:
				Display.getDefault().syncExec(() -> {
					viewer_pattern.refresh();
					viewer_pattern.expandAll();
					SiriusUtil.refreshActiveEditor();
				});	
				
				return Status.OK_STATUS;
			}
		};
		
		// Start the Job
		job.schedule(); 
	}
	
	private void generateMatcher() {
		
		// Show the matching view:
		Display.getDefault().syncExec(() -> {
			WorkbenchUtil.showView(MatchViewer.ID);
		});
		
		// Start calculation:
		IViewPart matchViewer = WorkbenchUtil.getView(MatchViewer.ID);
		
		if (matchViewer instanceof MatchViewer) {
			((MatchViewer) matchViewer).generateMatches();
		}
		
	}

	public void startPatternMatchingDebugger() {
		EngineManager.getInstance().startDebugger(getSelectedPatternMatchingEngine(), this);
	}

	public void resumeAllBreakpoints() {
		EngineManager.getInstance().resumeAllBreakpoints();
	}
	
	@Override
	public void signalWait(Breakpoint breakpoint) {
		
		if (breakpoint instanceof Termination) {
			WorkbenchUtil.showMessage("Engine terminated!");
		} else {
			// UI update:
			viewer_pattern.getTree().getDisplay().asyncExec(new Runnable() {

				@Override
				public void run() {
					viewer_pattern.refresh();
					viewer_pattern.expandAll();
					SiriusUtil.refreshActiveEditor();
					
					InfoConsole.printInfo(breakpoint, MSG_EMPTY_SELECTION);
				}
		    });			
		}
	}
	
	public void printSelection(ISelection selection) {
		
		if (selection instanceof IStructuredSelection) {
			Object selectedElement = ((IStructuredSelection)selection).getFirstElement();
			InfoConsole.printInfo(selectedElement, MSG_EMPTY_SELECTION);
		}
	}

	public IWorkbenchPart getActivePart() {
		return activePart;
	}
}

package org.sidiff.repair.history.editrules.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.sidiff.historymodel.History;
import org.sidiff.repair.history.editrules.generator.EditRuleGenerator.RulebaseLimitExceededException;
import org.sidiff.repair.history.editrules.util.CreateProjectDialog;
import org.sidiff.repair.history.editrules.util.IterableHistory;
import org.sidiff.revision.common.emf.EMFHandlerUtil;
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;

public class EditRuleGeneratorHandler extends AbstractHandler implements IHandler {

	protected static final String EDIT_RULE_FOLDER = "editrules";
	
	protected static final int RULEBASE_LIMIT = 2000; // Unlimited = -1
	
	protected class IterableWork<T> implements Iterable<T> {
		
		public int getWork() {
			return IProgressMonitor.UNKNOWN;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Iterator<T> iterator() {
			return (Iterator<T>) Collections.emptyList();
		}
	}
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// Read history:
		List<IterableHistory> historys = getHistory(event);
		
//		historys.forEach(history -> System.out.println(history.iterator().next()[0]));

		// Prepare workspace:
		String projectName = "org.sidiff." + getModelingDomain(historys) + ".editrules.cpo";
		IProject project = CreateProjectDialog.createProject(projectName);

		// Start generation task:
		if (project != null) {
			Job job = new Job("Analyze Model History for Edit Rules") {

				@Override
				protected IStatus run(IProgressMonitor monitor) {

					// Prepare workspace:
					try {
						IFolder editRuleFolder = project.getFolder(EDIT_RULE_FOLDER);

						if (!editRuleFolder.exists()) {
							editRuleFolder.create(false, true, new NullProgressMonitor());
						}
					} catch (CoreException e) {
						e.printStackTrace();
					}

					// Generate edit-rules:
					monitor.beginTask("Analyze Model History for Edit Rules", getHistoryWork(historys));
					EditRuleGenerator generator = new EditRuleGenerator(projectName, EDIT_RULE_FOLDER);
					generator.setRulebaseLimit(RULEBASE_LIMIT);

					for (IterableHistory history : historys) {
						try {
							generator.analyzeHistory(history, monitor);
						} catch (RulebaseLimitExceededException e) {
							WorkbenchUtil.showMessage("The edit rule limit (" 
									+ RULEBASE_LIMIT + ") was exceeded: " + projectName);
							return Status.CANCEL_STATUS;
						}
					}

					// Report to user:
					if (monitor.isCanceled()) {
						WorkbenchUtil.showMessage("Edit rule generation incomplete: " + projectName);
						return Status.CANCEL_STATUS;
					} else {
						WorkbenchUtil.showMessage("Edit rule generation finished: " + projectName);
						return Status.OK_STATUS;
					}
				}
			};
			job.schedule();
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	protected List<IterableHistory> getHistory(ExecutionEvent event) {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		if (selection instanceof IStructuredSelection) {
			List<Object> structuredSelection = ((IStructuredSelection) selection).toList();
			List<IterableHistory> histories = new ArrayList<>();
			
			for (int i = 0; i < structuredSelection.size(); i++) {
				if (structuredSelection.get(i) instanceof IResource) {
					IResource resource = (IResource) structuredSelection.get(i);
					
					try {
						resource.accept(new IResourceVisitor() {
							
							@Override
							public boolean visit(IResource resource) throws CoreException {
								
								// Is history?
								if ((resource.getFileExtension() != null) && 
										resource.getFileExtension().equals("history")) {
									History history = EMFHandlerUtil.loadResource(
											resource, History.class, new ResourceSetImpl());
									
									List<URI> models = new ArrayList<>();
									history.getVersions().forEach(version -> {
										models.add(URI.createURI(version.getModelURI()));
									});
									
									histories.add(new IterableHistory(models));
								}
								
								return true;
							}
						});
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
			}
			return histories;
		}
		
		return Collections.emptyList();
	}
	
	protected String getModelingDomain(List<IterableHistory> history) {
		
		if (!history.isEmpty()) {
			if (history.get(0).iterator().hasNext()) {
				return history.get(0).iterator().next()[0].getURI().fileExtension();
			}
		}
		
		return "unkowndomain";
	}
	
	protected int getHistoryWork(List<IterableHistory> historys) {
		return historys.stream().collect(Collectors.summingInt(IterableHistory::getWork));
	}
}

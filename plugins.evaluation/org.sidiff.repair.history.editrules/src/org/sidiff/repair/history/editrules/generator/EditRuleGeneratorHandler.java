package org.sidiff.repair.history.editrules.generator;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.sidiff.common.emf.modelstorage.EMFHandlerUtil;
import org.sidiff.common.ui.util.UIUtil;
import org.sidiff.consistency.common.ui.dialogs.CreateProjectDialog;
import org.sidiff.repair.historymodel.History;
import org.sidiff.repair.historymodel.Version;

public class EditRuleGeneratorHandler extends AbstractHandler implements IHandler {

	protected static final String EDIT_RULE_FOLDER = "editrules";
	
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
		IterableWork<Resource> history = getHistory(event);

		// Prepare workspace:
		String projectName = "org.sidiff." + getModelingDomain(history) + ".editrules.cpo";
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
					monitor.beginTask("Analyze Model History for Edit Rules", history.getWork());

					EditRuleGenerator generator = new EditRuleGenerator(history, projectName, EDIT_RULE_FOLDER);
					generator.analyzeHistory(monitor);

					// Report to user:
					if (monitor.isCanceled()) {
						UIUtil.showMessage("Edit rule generation incomplete: " + projectName);
						return Status.CANCEL_STATUS;
					} else {
						UIUtil.showMessage("Edit rule generation finished: " + projectName);
						return Status.OK_STATUS;
					}
				}
			};
			job.schedule();
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	protected IterableWork<Resource> getHistory(ExecutionEvent event) {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		if (selection instanceof IStructuredSelection) {
			List<Object> structuredSelection = ((IStructuredSelection) selection).toList();
			
			for (int i = 0; i < structuredSelection.size(); i++) {
				if (structuredSelection.get(i) instanceof IResource) {
					IResource resource = (IResource) structuredSelection.get(i);
					
					// Is history?
					if (resource.getFileExtension().equals("history")) {
						ResourceSet rss = new ResourceSetImpl();
						History history = EMFHandlerUtil.getSelection(event, History.class, rss, i);
						
						return new IterableWork<Resource>() {
							
							@Override
							public int getWork() {
								return history.getVersions().size();
							}
							
							@Override
							public Iterator<Resource> iterator() {
								return history.getVersions().stream().map(Version::getModel).iterator();
							}
						};
					}
				}
			}
		}
		
		return new IterableWork<Resource>();
	}
	
	protected String getModelingDomain(Iterable<Resource> history) {
		if (history.iterator().hasNext()) {
			return history.iterator().next().getURI().fileExtension();
		} else {
			return "unkowndomain";
		}
	}
}

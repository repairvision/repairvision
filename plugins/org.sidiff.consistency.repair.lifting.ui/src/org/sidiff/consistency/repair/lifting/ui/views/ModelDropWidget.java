package org.sidiff.consistency.repair.lifting.ui.views;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.widgets.Composite;

public abstract class ModelDropWidget {

	protected TableViewer viewer_models;
	
	protected String dropMessage = "Please drop the model(s) here!";
	
	public ModelDropWidget(Composite parent, String dropMessage) {
		this.dropMessage = dropMessage;
		
		// Initialize:
		viewer_models = new TableViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL);
		{
			viewer_models.setContentProvider(new ArrayContentProvider());
			viewer_models.setLabelProvider(new StorageLabelProvider());
			viewer_models.add(dropMessage);
		}
		
		// Drag and Drop support:
		int dndOperations = DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { 
				LocalTransfer.getInstance(), 
				LocalSelectionTransfer.getTransfer(), 
				FileTransfer.getInstance() };

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
							addFile((IResource) element);
						} else {
							// Try to get resources by reflection API:
							try {
								Set<IResource> resources = new HashSet<>();
								
								for (Method method : element.getClass().getMethods()) {
									if (method.getParameterCount() == 0) {
										Class<?> returnType = method.getReturnType();
										
										if (IResource.class.isAssignableFrom(returnType)) {
											resources.add((IResource) method.invoke(element));
										}
										
										else if (IResource[].class.isAssignableFrom(returnType)) {
											for (IResource resource : ((IResource[]) method.invoke(element))) {
												resources.add(resource);
											}
										}
									}
								}
								
								addFiles(resources);
							}catch (Exception e) {
							}
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
				
				if (selection instanceof IResource) {
					removeFile((IResource) selection);
				} else {
					// Normally we shouldn't get here...
					viewer_models.remove(selection);
				}
			}
		});
	}
	
	private void addFiles(Set<IResource> resources) {
		
		// FIXME [WORKAROUND]: Papyrus container -> Support multiple files!
		for (IResource resource : resources) {
			if ((resource.getFileExtension() != null) && resource.getFileExtension().equalsIgnoreCase("uml")) {
				addFile((IResource) resource);
				return;
			}
		}
		
		for (IResource resource : resources) {
			addFile((IResource) resource);
		}
	}
	
	private void addFile(IResource resource) {
		if (resource.getType() == IResource.FILE) {
			IResource added = addModel(resource);
			
			if (added != null) {
				viewer_models.add(added);
				viewer_models.remove(dropMessage);
			}
		}
	}
	
	private void removeFile(IResource resource) {
		IResource removed = removeModel(resource);
		
		if (removed != null) {
			viewer_models.remove(resource);
		}
		
		if (viewer_models.getTable().getItemCount() == 0) {
			viewer_models.add(dropMessage);
		}
	}
	
	public void clear() {
		viewer_models.setInput(null);
		viewer_models.add(dropMessage);
	}

	protected abstract IResource addModel(IResource element);

	protected abstract IResource removeModel(IResource selection);
	
	public static URI getURI(IResource workbenchResource) {

		String projectName = workbenchResource.getProject().getName();
		String filePath = workbenchResource.getProjectRelativePath().toOSString();
		String platformPath = projectName + "/" + filePath;

		return URI.createPlatformResourceURI(platformPath, true);
	}
}

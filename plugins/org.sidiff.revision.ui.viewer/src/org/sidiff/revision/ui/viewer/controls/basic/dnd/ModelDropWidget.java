package org.sidiff.revision.ui.viewer.controls.basic.dnd;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IResource;
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

	protected TableViewer modelviewer;
	
	protected String dropMessage = "Please drop the model(s) here!";
	
	public ModelDropWidget(Composite parent, String dropMessage) {
		this.dropMessage = dropMessage;
		
		// Initialize:
		modelviewer = new TableViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL);
		{
			modelviewer.setContentProvider(new ArrayContentProvider());
			modelviewer.setLabelProvider(new StorageLabelProvider());
			modelviewer.add(dropMessage);
		}
		
		// Drag and Drop support:
		int dndOperations = DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { 
				LocalTransfer.getInstance(), 
				LocalSelectionTransfer.getTransfer(), 
				FileTransfer.getInstance() };

		modelviewer.addDropSupport(dndOperations, transfers, new ViewerDropAdapter(modelviewer) {

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
								e.printStackTrace();
							}
						}
					});
					return true;
				}
				return false;
			}
		});
		
		modelviewer.addDragSupport(DND.DROP_MOVE, transfers, new ViewerDragAdapter(modelviewer) {
			
			@Override
			public void dragFinished(DragSourceEvent event) {
				super.dragFinished(event);
				Object selection = ((StructuredSelection) modelviewer.getSelection()).getFirstElement();
				
				if (selection instanceof IResource) {
					removeFile((IResource) selection);
				} else {
					// Normally we shouldn't get here...
					modelviewer.remove(selection);
				}
			}
		});
		
		// Additional initializations:
		initialize();
	}
	
	protected void initialize() {
		// additional initializations...
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
			
			// FIXME [WORKAROUND]: Papyrus container -> Support multiple files!
			if (resource.getFileExtension().equals("di") || resource.getFileExtension().equals("notation")) {
				return;
			}
			
			IResource added = addModel(resource);
			
			if (added != null) {
				modelviewer.add(added);
				modelviewer.remove(dropMessage);
			}
		}
	}
	
	private void removeFile(IResource resource) {
		IResource removed = removeModel(resource);
		
		if (removed != null) {
			modelviewer.remove(resource);
		}
		
		if (modelviewer.getTable().getItemCount() == 0) {
			modelviewer.add(dropMessage);
		}
	}
	
	public void clear() {
		modelviewer.setInput(null);
		modelviewer.add(dropMessage);
	}
	
	protected abstract IResource addModel(IResource element);

	protected abstract IResource removeModel(IResource selection);
}

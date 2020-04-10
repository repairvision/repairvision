package org.sidiff.common.utilities.ui.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.action.ValidateAction;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.sidiff.common.utilities.emf.ItemProviderUtil;

public class WorkbenchUtil {

	public static IViewPart showView(String id) {
		IViewPart[] view = new IViewPart[1];
		
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				try {
					view[0] = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(id);
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		});
		
		return view[0];
	}

	public static IViewPart getView(String id) {
		IViewPart[] view = new IViewPart[1];
		
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				IViewReference viewReferences[] = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage().getViewReferences();
				
				for (IViewReference viewReference : viewReferences) {
					if (id.equals(viewReference.getId())) {
						view[0] = viewReference.getView(false);
						break;
					}
				}
			}
		});

		return view[0];
	}

	public static String askForValue(String message, String initialValue, IInputValidator validation) {
		String[] result = new String[1];
		
		Display.getDefault().syncExec(new Runnable() {
		    @Override
		    public void run() {
				InputDialog dlg = new InputDialog(
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart().getTitle(),
						message, initialValue, validation);
				
				if (dlg.open() == Window.OK) {
					result[0] = dlg.getValue();
				}
		    }
		});
		
		return result[0];
	}
	
	public static void showMessage(String message) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				MessageDialog.openInformation(
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), 
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart().getTitle(),
						message);
			}
		});
	}
	
	public static void showError(String message) {
		Display.getDefault().asyncExec(new Runnable() {
		    @Override
		    public void run() {
				MessageDialog.openError(
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), 
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart().getTitle(),
						message);
		    }
		});
	}
	
	public static void showErrorWithException(String message, Object context, Exception e) {
		Display.getDefault().asyncExec(new Runnable() {
		    @Override
		    public void run() {
		    	ErrorDialog.openError(
		    			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), 
		    			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart().getTitle(),
		    			message,
		    			createMultiStatus(e, context.getClass().getName()));
		    }
		});
	}
	
	private static MultiStatus createMultiStatus(Throwable t, String pluginID) {
		List<Status> childStatuses = new ArrayList<>();

		for (StackTraceElement stackTrace : t.getStackTrace()) {
			Status status = new Status(IStatus.ERROR, pluginID, stackTrace.toString());
			childStatuses.add(status);
		}

		MultiStatus ms = new MultiStatus(
				pluginID, 
				IStatus.ERROR, childStatuses.toArray(new Status[] {}),
				t.toString(), t);
		return ms;
	}
	
	public static boolean showQuestion(String question) {
		Boolean[] result = new Boolean[1];
		
		Display.getDefault().syncExec(new Runnable() {
		    @Override
		    public void run() {
		    	MessageBox messageBox = new MessageBox(
		    			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
		    			SWT.ICON_QUESTION | SWT.YES | SWT.NO);
		    	
		    	messageBox.setText(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
		    			.getActivePage().getActivePart().getTitle());
		        messageBox.setMessage(question);
		        
		        if (messageBox.open() == SWT.YES) {
		        	result[0] = true;
		        } else {
		        	result[0] = false;
		        }
		    }
		});
		
		return result[0];
	}
	
	public static <I> List<I> showSelections(String message, List<I> items, ILabelProvider labelProvider) {
		if (!items.isEmpty()) {
			return showSelections(message, items, items.subList(0, 1), labelProvider);
		} else {
			return showSelections(message, items, Collections.emptyList(), labelProvider);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <I> List<I> showSelections(String message, List<I> items, List<I> initialSelection, ILabelProvider labelProvider) {
		List<I> result = new ArrayList<>();

		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				ListSelectionDialog dlg = new ListSelectionDialog(
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), 
						items.toArray(),
						new ArrayContentProvider(), labelProvider, message);
				dlg.setTitle(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
						.getActivePage().getActivePart().getTitle());
				dlg.setInitialSelections(initialSelection.toArray());
				dlg.open();
				
				if (dlg.getResult() != null) {
					result.addAll((Collection<? extends I>) Arrays.asList(dlg.getResult()));
				}
			}
		});

		return result;
	}
	
	public static AdapterFactoryLabelProvider getEMFLabelProvider() {

		// EMF Adapter (Item-Provider) Registry:
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		// Display model resources:
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());

		// If the model is not in the registry then display it as in EMF-Reflective-Editor:
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		AdapterFactoryLabelProvider emfLabelProvider = new AdapterFactoryLabelProvider(adapterFactory);
		
		return emfLabelProvider;
	}
	
	public static boolean validateEMFResource(IResource resource, EObject eObject) {
		
		// Remove old markers:
		try {
			resource.deleteMarkers(EValidator.MARKER, true, IResource.FILE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Diagnostician which shows the EMF labels:
		Diagnostician diagnostician = new Diagnostician() {
			@Override
			public String getObjectLabel(EObject eObject) {
				return ItemProviderUtil.getTextByObject(eObject);
			}
		};

		Diagnostic diagnostic = diagnostician.validate(eObject);
		
		// Create workbench markers:
		try {
			ValidateAction.EclipseResourcesUtil markerHelper = new ValidateAction.EclipseResourcesUtil();
			markerHelper.createMarkers(diagnostic);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return diagnostic.getSeverity() != Diagnostic.ERROR;
	}

	public static URI getURI(IResource workbenchResource) {
	
		String projectName = workbenchResource.getProject().getName();
		String filePath = workbenchResource.getProjectRelativePath().toOSString();
		String platformPath = projectName + "/" + filePath;
	
		return URI.createPlatformResourceURI(platformPath, true);
	}
	
	public static void updateProject(IProject project) {
		try {
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateProject(IResource workbenchResource) {
		updateProject(workbenchResource.getProject());
	}
	
	public static void updateProject(String projectName) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(projectName);
		updateProject(project);
	}
	
	public static void updateProject(ExecutionEvent event) {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		if (!selection.isEmpty()) {
			if (selection instanceof IStructuredSelection) {
				Object firstElement = ((IStructuredSelection) selection).getFirstElement();
				
				if (firstElement instanceof IResource) {
					updateProject((IResource) firstElement); 
				}
			}
		}
	}

}

package org.sidiff.revision.common.ui.workbench;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
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
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;
import org.sidiff.revision.common.emf.ItemProviderUtil;

public class WorkbenchUtil {
	
	/**
	 * This class validates a String.
	 */
	public static class NotEmptyValidator implements IInputValidator {

	  public String isValid(String newText) {
	    int len = newText.length();

	    // Determine if input is empty
	    if (len < 1) return "Empty inputs are not allowed!";

	    // Input must be OK
	    return null;
	  }
	}

	/**
	 * Open a file with the associated editor.
	 *
	 * @param path
	 *            The path on the file system.
	 * @throws FileNotFoundException
	 */
	public static void openEditor(String path) throws FileNotFoundException {
		File osFile = new File(path);

		if (osFile.exists() && osFile.isFile()) {
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IPath location = Path.fromOSString(osFile.getAbsolutePath());
			IFile file = workspace.getRoot().getFileForLocation(location);

			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

			if (file != null) {
				// Open from workspace:
				IEditorDescriptor desc = PlatformUI.getWorkbench().
						getEditorRegistry().getDefaultEditor(file.getName());

				try {
					page.openEditor(new FileEditorInput(file), desc.getId());
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			} else {
				// Open from file system:
				IFileStore fileStore = EFS.getLocalFileSystem().getStore(osFile.toURI());

				try {
					IDE.openEditorOnFileStore(page, fileStore);
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		} else {
			throw new FileNotFoundException();
		}
	}
	
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
	
	public static boolean askQuestion(String question) {
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
			
			// (Do not show root diagnostic: markerHelper.createMarkers(diagnostic))
			for (Diagnostic diagnosticChild : diagnostic.getChildren()) {
				markerHelper.createMarkers(diagnosticChild);
			}
			
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
	
	public static void refreshProject(IProject project) {
		try {
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void refreshProject(IResource workbenchResource) {
		refreshProject(workbenchResource.getProject());
	}
	
	public static void refreshProject(String projectName) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(projectName);
		refreshProject(project);
	}
	
	public static void refreshProject(ExecutionEvent event) {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		if (!selection.isEmpty()) {
			if (selection instanceof IStructuredSelection) {
				Object firstElement = ((IStructuredSelection) selection).getFirstElement();
				
				if (firstElement instanceof IResource) {
					refreshProject((IResource) firstElement); 
				}
			}
		}
	}

	public static String createFolder(IProject project, String newFolder, IProgressMonitor monitor) throws CoreException {
		IFolder folder = project.getFolder(newFolder);
	
		if(!folder.exists()) {
			folder.create(true, true, monitor);
		}
	
		return newFolder;
	}

}

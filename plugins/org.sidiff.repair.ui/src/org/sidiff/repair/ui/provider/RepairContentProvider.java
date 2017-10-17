package org.sidiff.repair.ui.provider;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.sidiff.repair.api.RepairJob;
import org.sidiff.repair.ui.provider.model.IItemProvider;
import org.sidiff.repair.ui.provider.model.RepairJobItem;

public class RepairContentProvider implements IStructuredContentProvider, ITreeContentProvider  {

	protected AdapterFactoryContentProvider emfContentProvider;
	
	protected TreeViewer viewer;
	
	public RepairContentProvider() {
		
		// EMF Adapter (Item-Provider) Registry:
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		// Display model resources:
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());

		// If the model is not in the registry then display it as in EMF-Reflective-Editor:
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		
		emfContentProvider = new AdapterFactoryContentProvider(adapterFactory);
	}
	
	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.viewer = (TreeViewer) viewer;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		
		if (parentElement instanceof IItemProvider) {
			return ((IItemProvider) parentElement).getChildren();
		}
		
		return emfContentProvider.getChildren(parentElement);
	}
	
	@Override
	public Object getParent(Object element) {
		
		if (element instanceof IItemProvider) {
			return ((IItemProvider) element).getParent();
		}
		
		return emfContentProvider.getParent(element);
	}

	@Override
	public boolean hasChildren(Object element) {
		
		if (element instanceof IItemProvider) {
			return ((IItemProvider) element).hasChildren(element);
		}
		
		return emfContentProvider.hasChildren(element);
	}

	@Override
	public Object[] getElements(Object inputElement) {
		
		// Repair-Rules:
		if (inputElement instanceof RepairJob) {
			RepairJob<?> repairJob = (RepairJob<?>) inputElement;
			RepairJobItem repairJobItem = new RepairJobItem(viewer, repairJob);
			return repairJobItem.getChildren();
		}
		
		return getChildren(inputElement);
	}
}

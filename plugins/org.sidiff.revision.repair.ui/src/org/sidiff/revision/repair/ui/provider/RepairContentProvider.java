package org.sidiff.revision.repair.ui.provider;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.sidiff.revision.api.ComplementationJob;
import org.sidiff.revision.repair.ui.provider.model.IItemProvider;
import org.sidiff.revision.repair.ui.provider.model.ParameterValueObjectItem;
import org.sidiff.revision.repair.ui.provider.model.RepairJobItem;

public class RepairContentProvider implements IStructuredContentProvider, ITreeContentProvider  {

	protected AdapterFactoryContentProvider emfContentProvider;
	
	protected TreeViewer viewer;
	
	protected RepairJobItem input;
	
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
		
		// Initialize repair model:
		if (newInput instanceof ComplementationJob) {
			ComplementationJob<?> repairJob = (ComplementationJob<?>) newInput;
			this.input = new RepairJobItem(this.viewer, repairJob);
		}
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		
		if (parentElement instanceof IItemProvider) {
			return ((IItemProvider) parentElement).getChildren();
		}
		
		else if (parentElement instanceof ParameterValueObjectItem) {
			return emfContentProvider.getChildren(((ParameterValueObjectItem) parentElement).getValue());
		}
		
		return emfContentProvider.getChildren(parentElement);
	}
	
	@Override
	public Object getParent(Object element) {
		
		if (element instanceof IItemProvider) {
			return ((IItemProvider) element).getParent();
		}
		
		else if (element instanceof ParameterValueObjectItem) {
			return emfContentProvider.getParent(((ParameterValueObjectItem) element).getValue());
		}
		
		return emfContentProvider.getParent(element);
	}

	@Override
	public boolean hasChildren(Object element) {
		
		if (element instanceof IItemProvider) {
			return ((IItemProvider) element).hasChildren(element);
		}
		
		else if (element instanceof ParameterValueObjectItem) {
			return emfContentProvider.hasChildren(((ParameterValueObjectItem) element).getValue());
		}
		
		return emfContentProvider.hasChildren(element);
	}

	@Override
	public Object[] getElements(Object inputElement) {
		
		// Repairs:
		if (inputElement instanceof ComplementationJob) {
			return input.getChildren();
		}
		
		return getChildren(inputElement);
	}
}

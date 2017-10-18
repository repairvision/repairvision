package org.sidiff.repair.ui.provider;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.sidiff.repair.ui.provider.model.IItemProvider;
import org.sidiff.repair.ui.provider.model.ParameterValueItem;

public class RepairLabelProvider extends LabelProvider {
	
	protected AdapterFactoryLabelProvider emfLabelProvider;
	
	public RepairLabelProvider() {
		
		// EMF Adapter (Item-Provider) Registry:
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		// Display model resources:
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());

		// If the model is not in the registry then display it as in EMF-Reflective-Editor:
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		
		emfLabelProvider = new AdapterFactoryLabelProvider(adapterFactory);
	}
	
	@Override
	public Image getImage(Object element) {
		
		if (element instanceof IItemProvider) {
			return ((IItemProvider) element).getImage();
		}
		
		else if (element instanceof ParameterValueItem) {
			return emfLabelProvider.getImage(((ParameterValueItem) element).getValue());
		}
		
		return emfLabelProvider.getImage(element);
	}
	
	@Override
	public String getText(Object element) {
		
		if (element instanceof IItemProvider) {
			return ((IItemProvider) element).getText();
		}
		
		else if (element instanceof ParameterValueItem) {
			return emfLabelProvider.getText(((ParameterValueItem) element).getValue());
		}
		
		return emfLabelProvider.getText(element);
	}
}

package org.sidiff.revision.ui.viewer.provider;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.sidiff.revision.ui.viewer.provider.model.IItemProvider;
import org.sidiff.revision.ui.viewer.provider.model.ParameterValueObjectItem;

public class ComplementationLabelProvider extends LabelProvider {
	
	protected AdapterFactoryLabelProvider emfLabelProvider;
	
	public ComplementationLabelProvider() {
		
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
		
		else if (element instanceof ParameterValueObjectItem) {
			return emfLabelProvider.getImage(((ParameterValueObjectItem) element).getValue());
		}
		
		return emfLabelProvider.getImage(element);
	}
	
	@Override
	public String getText(Object element) {
		
		if (element instanceof IItemProvider) {
			return ((IItemProvider) element).getText();
		}
		
		else if (element instanceof ParameterValueObjectItem) {
			return emfLabelProvider.getText(((ParameterValueObjectItem) element).getValue());
		}
		
		return emfLabelProvider.getText(element);
	}
}

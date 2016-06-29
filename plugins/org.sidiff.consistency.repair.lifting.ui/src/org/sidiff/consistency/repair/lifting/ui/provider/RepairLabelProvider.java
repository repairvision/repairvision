package org.sidiff.consistency.repair.lifting.ui.provider;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.sidiff.consistency.repair.lifting.api.Repair;
import org.sidiff.consistency.repair.lifting.ui.Activator;
import org.sidiff.consistency.repair.lifting.ui.provider.RepairContentProvider.Change;
import org.sidiff.consistency.repair.lifting.ui.provider.RepairContentProvider.Container;

public class RepairLabelProvider extends LabelProvider {

	public static Image IMG_CHECK_MARK = Activator.getImageDescriptor("icons/check_mark.png").createImage();
	
	public static Image IMG_QUESTION_MARK = Activator.getImageDescriptor("icons/question_mark.png").createImage();
	
	public static Image IMG_REPAIR_RULE = Activator.getImageDescriptor("icons/repair_rule.png").createImage();
	
	public static Image IMG_MODULE = Activator.getImageDescriptor("icons/module.gif").createImage();
	
	public static Image IMG_ADD = Activator.getImageDescriptor("icons/add_reference.png").createImage();
	
	public static Image IMG_REMOVE = Activator.getImageDescriptor("icons/remove_reference.png").createImage();
	
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
		
		if (element instanceof Rule) {
			return IMG_MODULE;
		}
		
		if (element instanceof Repair) {
			return IMG_REPAIR_RULE;
		}
		
		else if (element instanceof Container) {
			return ((Container) element).icon;
		}
		
		else if (element instanceof Change) {
			Change change = (Change) element;
			
			if (change.graphElement.getGraph().isLhs()) {
				return IMG_REMOVE;
			}
			
			else if (change.graphElement.getGraph().isRhs()) {
				return IMG_ADD;
			}
		}
	
//		else if (element == RepairContentProvider.NULL) {
//		}
		
		return emfLabelProvider.getImage(element);
	}
	
	@Override
	public String getText(Object element) {
		
		if (element instanceof Rule) {
			return ((Rule) element).toString().replaceFirst("Rule ", "");
		}
		
		else if (element instanceof Repair) {
			Repair repair = (Repair) element;
			
			return "Repair "
					+ "[" + repair.getHistoricChanges().size() + "/" + 
					+ repair.getComplementingChanges().size() + "]";
		}
		
		else if (element instanceof Container) {
			return ((Container) element).label;
		}
		
		else if (element instanceof Change) {
			return ((Change) element).graphElement.toString();
		}
		
		else if (element == RepairContentProvider.NULL) {
			return "N/A";
		}
		
		return emfLabelProvider.getText(element);
	}
}

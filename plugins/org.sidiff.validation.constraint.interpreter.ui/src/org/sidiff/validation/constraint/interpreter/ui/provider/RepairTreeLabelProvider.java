package org.sidiff.validation.constraint.interpreter.ui.provider;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.sidiff.revision.impact.changetree.Alternative;
import org.sidiff.revision.impact.changetree.IDecisionNode;
import org.sidiff.revision.impact.changetree.Sequence;
import org.sidiff.revision.impact.changetree.change.actions.ChangeAction;
import org.sidiff.validation.constraint.api.util.Validation;
import org.sidiff.validation.constraint.interpreter.ui.Activator;

public class RepairTreeLabelProvider extends LabelProvider {

	public static Image IMG_VALIDATION_PASSED = Activator.getIcon("validation_passed.png");
	
	public static Image IMG_VALIDATION_FAILED = Activator.getIcon("validation_failed.png");
	
	public static Image IMG_REPAIR = Activator.getIcon("repair.png");
	
	public static Image IMG_ALTERNATIVE = Activator.getIcon("alternative.png");
	
	public static Image IMG_SEQUENCE = Activator.getIcon("sequence.png");
	
	protected AdapterFactoryLabelProvider emfLabelProvider;
	
	public RepairTreeLabelProvider() {
		
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
	public String getText(Object element) {
		
		if (element instanceof Validation) {
			Validation validation = (Validation) element;
			String reslut = validation.getResult() ? "[Passed]" : "[Failed]";
			
			return "Validation" + reslut + ": " + validation.getRule().getMessage();
		}
		
		else if (element instanceof IDecisionNode) {
			
			if (element instanceof ChangeAction) {
				return "Repair(" + ((ChangeAction) element).getRepairLabel() + ")";
			}
			
			else if (element instanceof Alternative) {
				return "Repair Alternatives";
			}
			
			else if (element instanceof Sequence) {
				return "Repair Sequence";
			}
		}
		
		return emfLabelProvider.getText(element);
	}
	
	@Override
	public Image getImage(Object element) {
		
		if (element instanceof Validation) {
			Validation validation = (Validation) element;
			
			return validation.getResult() ? IMG_VALIDATION_PASSED : IMG_VALIDATION_FAILED;
		}
		
		else if (element instanceof IDecisionNode) {
			
			if (element instanceof ChangeAction) {
				return IMG_REPAIR;
			}
			
			else if (element instanceof Alternative) {
				return IMG_ALTERNATIVE;
			}
			
			else if (element instanceof Sequence) {
				return IMG_SEQUENCE;
			}
		}

		return emfLabelProvider.getImage(element);
	}
}

package org.sidiff.consistency.repair.lifting.ui.decoration;

import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;

public class RepairDecoratorProvider extends AbstractProvider implements IDecoratorProvider {

	public static final String REPAIR_DECORATOR_KEY = "repair_decorator";
	
	@Override
	public boolean provides(IOperation operation) {
		if(operation instanceof CreateDecoratorsOperation){
			return true;
		}
		return false;
	}

	@Override
	public void createDecorators(IDecoratorTarget decoratorTarget) {
		decoratorTarget.installDecorator(REPAIR_DECORATOR_KEY, new RepairSelectionDecorator(decoratorTarget));
	}
}

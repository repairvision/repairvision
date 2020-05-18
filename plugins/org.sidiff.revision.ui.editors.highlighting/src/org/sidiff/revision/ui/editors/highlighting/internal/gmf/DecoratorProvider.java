package org.sidiff.revision.ui.editors.highlighting.internal.gmf;

import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;

public class DecoratorProvider extends AbstractProvider implements IDecoratorProvider {

	public static final String DECORATOR_KEY = "sidiff_decorator";
	
	@Override
	public boolean provides(IOperation operation) {
		if(operation instanceof CreateDecoratorsOperation){
			return true;
		}
		return false;
	}

	@Override
	public void createDecorators(IDecoratorTarget decoratorTarget) {
		decoratorTarget.installDecorator(DECORATOR_KEY, new SelectionDecorator(decoratorTarget));
	}
}

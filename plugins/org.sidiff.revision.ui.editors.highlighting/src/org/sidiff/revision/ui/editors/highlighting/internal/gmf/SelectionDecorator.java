package org.sidiff.revision.ui.editors.highlighting.internal.gmf;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

public class SelectionDecorator extends AbstractDecorator {

	private static final String HOOK_ID = "org.sidiff.integration.editor.highlighting";

	private SelectionControllerDiagram controller = SelectionControllerDiagram.getInstance();

	private Map<PolylineConnection, Style> decoratedLines = new HashMap<>();

	private static class Style {

		public Color color = null;

		public int lineWidth = 0;

		public Style(Color c, int lw) {
			color = c;
			lineWidth = lw;
		}
	}

	private NotificationListener notificationListener = new NotificationListener() {

		@Override
		public void notifyChanged(Notification notification) {
			refresh();
		}
	};

	public SelectionDecorator(IDecoratorTarget decoratorTarget) {
		super(decoratorTarget);
	}

	@Override
	public void activate() {
		IGraphicalEditPart gep = (IGraphicalEditPart) getDecoratorTarget().getAdapter(IGraphicalEditPart.class);

		if (gep != null) {
			DiagramEventBroker.getInstance(gep.getEditingDomain()).addNotificationListener(gep.getNotationView(),
					NotationPackage.eINSTANCE.getDescriptionStyle_Description(), notificationListener);
			controller.registerDecorator(this, getDecoratorTarget());
		}
	}

	@Override
	public void deactivate() {
		removeDecoration();

		IGraphicalEditPart gep = (IGraphicalEditPart) getDecoratorTarget().getAdapter(IGraphicalEditPart.class);

		if (gep != null) {
			DiagramEventBroker.getInstance(gep.getEditingDomain()).removeNotificationListener(gep.getNotationView(),
					NotationPackage.eINSTANCE.getDescriptionStyle_Description(), notificationListener);
			controller.unregisterDecorator(this, getDecoratorTarget());
		}
	}

	@Override
	protected void removeDecoration() {
		super.removeDecoration();

		for (PolylineConnection connection : decoratedLines.keySet()) {
			connection.setForegroundColor(decoratedLines.get(connection).color);
			connection.setLineWidth(decoratedLines.get(connection).lineWidth);
		}
	}

	@Override
	public void refresh() {
		decorate();
	}

	public View decorate() {
		removeDecoration();

		View view = (View) getDecoratorTarget().getAdapter(View.class);
		if(controller.getPrefferedDecoratorTarget(view.getElement()) != getDecoratorTarget()
				|| !selectionContains(view.getElement())) {
			return null;
		}

		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] config = registry.getConfigurationElementsFor(HOOK_ID);

		try {
			for (IConfigurationElement configElement : config) {
				final Object object = configElement.createExecutableExtension("hook");
				
				if (object instanceof DecorationHook) {
					DecorationHook hook = (DecorationHook) object;
					hook.onViewWillBeDecorated(view);
				}
			}
		} catch (CoreException ex) {
			ex.printStackTrace();
		}

		IGraphicalEditPart editPart = (IGraphicalEditPart) getDecoratorTarget().getAdapter(EditPart.class);

		if (view instanceof Node) {
			IFigure figure = editPart.getFigure();

			IFigure decoration = new SelectionDecorationFigure();
			decoration.setSize(figure.getSize());

			setDecoration(getDecoratorTarget().addShapeDecoration(
					decoration, IDecoratorTarget.Direction.CENTER,0, false));
		} else if (view instanceof Edge) {
			PolylineConnection connection = (PolylineConnection) editPart.getFigure();
			decoratedLines.put(connection,
					new Style(connection.getForegroundColor(), connection.getLineWidth()));
			connection.setForegroundColor(ColorConstants.red);
			connection.setLineWidth(2);
		}
		return view;
	}

	public void focus() {
		IGraphicalEditPart editPart = (IGraphicalEditPart) getDecoratorTarget().getAdapter(EditPart.class);
		
		int x = editPart.getFigure().getBounds().x;
		int y = editPart.getFigure().getBounds().y;
		
		FigureCanvas canvas = (FigureCanvas) editPart.getViewer().getControl();
		canvas.scrollSmoothTo(x, y);
	}
	
	public void reveal() {
		IGraphicalEditPart editPart = (IGraphicalEditPart) getDecoratorTarget().getAdapter(EditPart.class);
		editPart.getViewer().reveal(editPart);
	}
	
	private boolean selectionContains(EObject viewDataElement){
		
		if(viewDataElement != null){
			for(EObject selected : controller.getSelected()){
				if ((selected.eResource() != null) && (viewDataElement.eResource() != null)) {
					String fragmentA = EcoreUtil.getURI(selected).fragment();
					String fragmentB = EcoreUtil.getURI(viewDataElement).fragment();

					if (fragmentA.equals(fragmentB)){
						return true;
					}					
				}
			}
		}

		return false;
	}
}

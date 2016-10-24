package org.sidiff.consistency.repair.ui.decoration;

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
import org.sidiff.integration.editor.access.IntegrationEditorAccess;

public class RepairSelectionDecorator extends AbstractDecorator {

	private static final String HOOK_ID = "org.sidiff.consistency.repair.lifting.ui";

	private RepairSelectionController controller = RepairSelectionController.getInstance();

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

	public RepairSelectionDecorator(IDecoratorTarget decoratorTarget) {
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

		IGraphicalEditPart editPart = (IGraphicalEditPart) getDecoratorTarget().getAdapter(EditPart.class);

		View view = (View) getDecoratorTarget().getAdapter(View.class);

		if (controller.getPrefferedDecoratorTarget(view.getElement()) == getDecoratorTarget()) {
			if (selectionContains(view.getElement())) {
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
					System.out.println(ex.getMessage());
				}

				int x = editPart.getFigure().getBounds().x;
				int y = editPart.getFigure().getBounds().y;

				FigureCanvas canvas = (FigureCanvas) editPart.getViewer().getControl();
				canvas.scrollSmoothTo(x, y);

				editPart.getViewer().reveal(editPart);

				if (view instanceof Node) {
					IFigure figure = editPart.getFigure();

					IFigure decoration = new RepairSelectionDecorationFigure();
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
		}
		return null;
	}

	private boolean selectionContains(EObject element) {
		element = IntegrationEditorAccess.getInstance().getHighlightableElement(element);
		boolean contained = false;

		if (element != null) {
			for (EObject selected : controller.getSelected()) {
				String fragmentA = EcoreUtil.getURI(selected).fragment();
				String fragmentB = EcoreUtil.getURI(element).fragment();
				contained |= fragmentA.equals(fragmentB);
			}
		}
		return contained;
	}
}

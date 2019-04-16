package org.sidiff.graphpattern.design.layout;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.graph.Node;
import org.eclipse.elk.core.service.LayoutConnectorsService;
import org.eclipse.elk.core.service.LayoutMapping;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.sirius.diagram.elk.ElkDiagramLayoutConnector;
import org.eclipse.sirius.diagram.ui.tools.api.layout.LayoutExtender;
import org.eclipse.sirius.diagram.ui.tools.api.layout.provider.DefaultLayoutProvider;
import org.eclipse.sirius.diagram.ui.tools.api.layout.provider.ExtendableLayoutProvider;

import com.google.inject.Injector;


public class ELKLayoutNodeProvider extends DefaultLayoutProvider implements ExtendableLayoutProvider {
    private final LayoutExtender extender = new LayoutExtender(this);

    @Override
    public Command layoutEditParts(@SuppressWarnings("rawtypes") final List selectedObjects, final IAdaptable layoutHint) {
        DiagramEditPart diagramEditPart = layoutHint.getAdapter(DiagramEditPart.class);
        Injector injector = LayoutConnectorsService.getInstance().getInjector(null, selectedObjects);
        ElkDiagramLayoutConnector connector = injector.getInstance(ElkDiagramLayoutConnector.class);

        connector.setLayoutConfiguration(layoutConfiguration);

        LayoutMapping layoutMapping = connector.buildLayoutGraph(diagramEditPart, selectedObjects);
        connector.layout(layoutMapping);
        connector.transferLayout(layoutMapping);
        return connector.getApplyCommand(layoutMapping);
    }

    @Override
    public boolean handleConnectableListItems() {
        return true;
    }

    @Override
    public Rectangle provideNodeMetrics(Node node) {
        return null;
    }

    @Override
    public LayoutExtender getExtender() {
        return extender;
    }
}

package org.sidiff.graphpattern.design.provider;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.description.DiagramElementMapping;
import org.eclipse.sirius.diagram.ui.internal.edit.parts.DEdgeBeginNameEditPart;
import org.eclipse.sirius.diagram.ui.internal.edit.parts.DEdgeEndNameEditPart;
import org.eclipse.sirius.diagram.ui.tools.api.graphical.edit.styles.IStyleConfigurationProvider;
import org.eclipse.sirius.diagram.ui.tools.api.graphical.edit.styles.SimpleStyleConfiguration;
import org.eclipse.sirius.diagram.ui.tools.api.graphical.edit.styles.StyleConfiguration;
import org.eclipse.sirius.viewpoint.Style;
import org.eclipse.swt.graphics.Image;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.revision.common.emf.ItemProviderUtil;

/**
 * Provides the corresponding end/start icons of opposite edges.
 * 
 * @author Manuel Ohrndorf
 */
@SuppressWarnings("restriction")
public class LabelIconProvider implements IStyleConfigurationProvider {

	private static Set<String> mappingIDs = new HashSet<>();
	{
		mappingIDs.add("graphpattern.edgepattern.navigable");
		mappingIDs.add("graphpattern.edgepattern.nonnavigable");
		mappingIDs.add("graphpattern.edgepattern.nonnavigable.crossreference");
	}
	
	private static SimpleStyleConfiguration oppositeEdgeIconStyle = new SimpleStyleConfiguration() {
		
		@Override
		public Image getLabelIcon(DDiagramElement vpElement, IGraphicalEditPart editPart) {
			
			if (vpElement.getTarget() instanceof EdgePattern) {
				EdgePattern edge = (EdgePattern) vpElement.getTarget();
				
				if (editPart instanceof DEdgeBeginNameEditPart) {
					return ExtendedImageRegistry.INSTANCE.getImage(
							ItemProviderUtil.getImageByObject(edge.getOpposite()));
				}
				
				else if (editPart instanceof DEdgeEndNameEditPart) {
					return ExtendedImageRegistry.INSTANCE.getImage(
							ItemProviderUtil.getImageByObject(edge));
				}
			}
			
			return super.getLabelIcon(vpElement, editPart);
		}
	};
	
	@Override
	public StyleConfiguration createStyleConfiguration(DiagramElementMapping mapping, Style style) {
		return oppositeEdgeIconStyle;
	}

	@Override
	public boolean provides(DiagramElementMapping mapping, Style style) {
		
		if (mappingIDs.contains(mapping.getName())) {
			return true;
		}

		return false;
	}

}

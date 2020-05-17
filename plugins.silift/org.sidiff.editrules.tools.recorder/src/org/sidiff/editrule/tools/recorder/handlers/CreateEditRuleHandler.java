package org.sidiff.editrule.tools.recorder.handlers;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.Module;
import org.sidiff.common.utilities.emf.EMFHandlerUtil;
import org.sidiff.common.utilities.ui.util.WorkbenchUtil;
import org.sidiff.editrule.tools.recorder.DifferenceToEditRule;
import org.sidiff.editrule.tools.recorder.TransformationSetup;
import org.sidiff.editrule.tools.recorder.util.EditRuleUtil;
import org.sidiff.editrule.tools.recorder.util.HenshinDiagramUtil;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.difference.Difference;

/**
 * Transforms a symmetric difference into an edit-rule.
 * 
 * @author Manuel Ohrndorf
 */
public class CreateEditRuleHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Difference difference = EMFHandlerUtil.getSelection(event, Difference.class);
		
		if (difference != null) {
			String eoName = difference.eResource().getURI().segments()[difference.eResource().getURI().segmentCount() - 2];
			Module module = createEditRule(eoName, difference.getCorrespondences(), difference.getChanges());

			if (module != null) {
				module.getImports().addAll(EditRuleUtil.getImports(module));
				
				URI eoURI = EcoreUtil.getURI(difference).trimSegments(1)
						.appendSegment(module.getName() + "_execute")
						.appendFileExtension("henshin");
				Resource eoRes = difference.eResource().getResourceSet().createResource(eoURI);
				eoRes.getContents().add(module);

				try {
					eoRes.save(Collections.emptyMap());
					Resource diagramResource = HenshinDiagramUtil.createDiagram(module);
					
					if (HenshinDiagramUtil.maxNodeCount(module, 100)) {
						HenshinDiagramUtil.openDiagram(diagramResource);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

				WorkbenchUtil.showMessage("Edit-Rule saved:\n\n" + eoURI.toPlatformString(true));
				return null;
			} else {
				WorkbenchUtil.showError("Could not transform this difference to an edit-rule.");
				return null;
			}
		} else {
			WorkbenchUtil.showError("The selected resource does not contain a model difference.");
			return null;
		}
	}
	
	public static Module createEditRule(String eoName, 
			Collection<Correspondence> correspondences, Collection<Change> changes) {
		
		TransformationSetup trafoSetup = new TransformationSetup();
		trafoSetup.setChanges(changes);
		trafoSetup.setCorrespondences(correspondences);
		trafoSetup.setEditRuleName(eoName);
		
		DifferenceToEditRule editRuleRecorder = new DifferenceToEditRule(trafoSetup);
		return editRuleRecorder.getEditRule();
	}
}

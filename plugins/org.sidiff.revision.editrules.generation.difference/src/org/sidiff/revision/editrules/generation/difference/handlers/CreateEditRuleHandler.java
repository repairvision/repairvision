package org.sidiff.revision.editrules.generation.difference.handlers;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.utilities.emf.EMFHandlerUtil;
import org.sidiff.common.utilities.ui.util.WorkbenchUtil;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.editrules.generation.difference.DifferenceToEditRule;
import org.sidiff.revision.editrules.generation.difference.builder.HenshinBuilder;
import org.sidiff.revision.editrules.generation.difference.configuration.SymmetricModelDifference;
import org.sidiff.revision.editrules.generation.difference.configuration.TransformationConfiguration;
import org.sidiff.revision.editrules.generation.difference.util.DifferenceToEditRuleUtil;

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
			
			TransformationConfiguration transformationConfiguration = new TransformationConfiguration(
					eoName, new SymmetricModelDifference(difference));
			
			HenshinBuilder trafoLanguage = new HenshinBuilder();
			
			DifferenceToEditRule<Rule, Node, Edge, Attribute> editRuleRecorder = new DifferenceToEditRule<Rule, Node, Edge, Attribute>(
					trafoLanguage, transformationConfiguration);
			Rule rule = editRuleRecorder.transform();
			
			if (rule != null) {
				URI folder = EcoreUtil.getURI(difference).trimSegments(1);
				DifferenceToEditRuleUtil.saveEditRule(trafoLanguage, folder, rule.getName(), true, true, 150);
				
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
	
}

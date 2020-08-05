package org.sidiff.revision.editrules.generation.difference.handlers;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.sidiff.revision.common.emf.EMFHandlerUtil;
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.editrules.generation.difference.DifferenceToEditRule;
import org.sidiff.revision.editrules.generation.difference.builder.GraphPatternBuilder;
import org.sidiff.revision.editrules.generation.difference.builder.HenshinBuilder;
import org.sidiff.revision.editrules.generation.difference.builder.IEditRuleBuilder;
import org.sidiff.revision.editrules.generation.difference.configuration.SymmetricModelDifference;
import org.sidiff.revision.editrules.generation.difference.configuration.TransformationConfiguration;
import org.sidiff.revision.editrules.generation.difference.util.DifferenceToEditRuleUtil;

/**
 * Transforms a symmetric difference into an edit-rule.
 * 
 * @author Manuel Ohrndorf
 */
public class CreateEditRuleHandler extends AbstractHandler implements IHandler {

	@SuppressWarnings("rawtypes")
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Difference difference = EMFHandlerUtil.getSelection(event, Difference.class);
		
		if (difference != null) {
			String eoName = difference.eResource().getURI().segments()[difference.eResource().getURI().segmentCount() - 2];
			
			List<IEditRuleBuilder> builders = new ArrayList<>();
			builders.add(new HenshinBuilder());
			builders.add(new GraphPatternBuilder());
			
			builders = askForEditRuleBuilder(builders);
			
			for (IEditRuleBuilder editRuleBuilder : builders) {
				transform(editRuleBuilder, difference, eoName);
			}
			
			return null;
		} else {
			WorkbenchUtil.showError("The selected resource does not contain a model difference.");
			return null;
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Object transform(IEditRuleBuilder editRuleBuilder, Difference difference, String eoName) {
		TransformationConfiguration transformationConfiguration = new TransformationConfiguration(
				eoName, new SymmetricModelDifference(difference));
		
		DifferenceToEditRule editRuleRecorder = new DifferenceToEditRule(editRuleBuilder, transformationConfiguration);
		Object rule = editRuleRecorder.transform();
		
		if (rule != null) {
			URI folder = EcoreUtil.getURI(difference).trimSegments(1);
			DifferenceToEditRuleUtil.saveEditRule(editRuleBuilder, folder, eoName, true, true, 150);
			
			return null;
		} else {
			WorkbenchUtil.showError("Could not transform this difference to an edit-rule.");
			return null;
		}
	}
	
	@SuppressWarnings("rawtypes")
	private List<IEditRuleBuilder> askForEditRuleBuilder(List<IEditRuleBuilder> builders) {
		return WorkbenchUtil.showSelections(
				"Select Edit Rule Language", 
				builders, 
				new ColumnLabelProvider() {
					
					@Override
					public String getText(Object element) {
						return ((IEditRuleBuilder) element).getBuilderName();
					}
				});
	}
	
}

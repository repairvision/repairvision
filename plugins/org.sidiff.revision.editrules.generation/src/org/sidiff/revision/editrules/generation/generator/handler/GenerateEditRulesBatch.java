package org.sidiff.revision.editrules.generation.generator.handler;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.LabelProvider;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.revision.common.emf.EMFHandlerUtil;
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;
import org.sidiff.revision.editrules.generation.constructors.CreationEditRuleConstructor;
import org.sidiff.revision.editrules.generation.constructors.DeletionEditRuleConstructor;
import org.sidiff.revision.editrules.generation.constructors.IEditRuleConstructor;
import org.sidiff.revision.editrules.generation.constructors.RelocationEditRuleConstructor;
import org.sidiff.revision.editrules.generation.constructors.TransformationEditRuleConstructor;
import org.sidiff.revision.editrules.generation.generator.api.EditRuleGenerator;

public class GenerateEditRulesBatch extends AbstractHandler {
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		// Select generators:
		@SuppressWarnings("unchecked")
		Class<IEditRuleConstructor>[] generators = new Class[] {
				CreationEditRuleConstructor.class,
				DeletionEditRuleConstructor.class,
				TransformationEditRuleConstructor.class,
				RelocationEditRuleConstructor.class};
		
		List<Class<IEditRuleConstructor>> selection = WorkbenchUtil.showSelections("Select Edit Rule Generators:", 
				Arrays.asList(generators), Arrays.asList(generators) , new LabelProvider() {
			
			@Override
			public String getText(Object element) {
				
				if (element == CreationEditRuleConstructor.class) {
					return "Creation Edit Rules";
				}
				
				if (element == DeletionEditRuleConstructor.class) {
					return "Deletion Edit Rules";
				}
				
				if (element == TransformationEditRuleConstructor.class) {
					return "Transformation Edit Rules";
				}
				
				if (element == RelocationEditRuleConstructor.class) {
					return "Relocation Edit Rules";
				}
				
				return super.getText(element);
			}
		});
		
		// Cancel -> Selection empty
		if (selection.isEmpty()) {
			return null;
		}
		
		// Load patterns:
		Bundle patternBundle = EMFHandlerUtil.getSelection(event, Bundle.class);
		
		if (patternBundle != null) {
			URI originalURI = patternBundle.eResource().getURI();
			URI editRulesURI = URI.createURI(originalURI.trimFileExtension() + "_editrules").appendFileExtension("graphpattern");
			EditRuleGenerator generator;
			
			if (EditRuleGenerator.hasRelocationEdge(patternBundle)) {
				generator = new EditRuleGenerator(false);
			} else {
				generator = new EditRuleGenerator(WorkbenchUtil.askQuestion("Initialize Relocation Edges?"));
			}
			
			generator.generateEditRules(selection, patternBundle, editRulesURI);
		}
		
		return null;
	}

}

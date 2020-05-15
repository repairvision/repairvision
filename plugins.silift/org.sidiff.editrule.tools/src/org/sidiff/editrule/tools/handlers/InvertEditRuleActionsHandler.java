package org.sidiff.editrule.tools.handlers;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.Mapping;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.ParameterMapping;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx;
import org.sidiff.common.utilities.emf.EMFHandlerUtil;
import org.sidiff.common.utilities.ui.util.WorkbenchUtil;

public class InvertEditRuleActionsHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		// Invert all rules:
		Module editRule = EMFHandlerUtil.getSelection(event, Module.class);
		invertEditRule(editRule);
		
		// Save edit-rule:
		try {
			URI currentURI = editRule.eResource().getURI();
			editRule.eResource().setURI(URI.createURI(
					currentURI.trimFileExtension() + "_inverted")
					.appendFileExtension(currentURI.fileExtension()));
			editRule.eResource().save(Collections.emptyMap());
			
			WorkbenchUtil.showMessage("Edit-Rule saved:\n\n" + EcoreUtil.getURI(editRule).toPlatformString(true));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void invertEditRule(Module editRule) {
		
		// Invert all rules:
		editRule.eAllContents().forEachRemaining(element ->  {
			if (element instanceof Rule) {
				invertRule((Rule) element);
			}
		});
		
		// Switch input/output parameters:
		editRule.eAllContents().forEachRemaining(element ->  {
			if ((element instanceof Unit) && !(element instanceof Rule)) {
				invertParameterMapping((Unit) element);
			}
		});
	}

	private static void invertParameterMapping(Unit unit) {
		// NOTE: Post rule conversion!
		
		for (ParameterMapping mapping : unit.getParameterMappings()) {

			// Fix Input-Parameter:
			if (mapping.getSource().getUnit() == unit) {
				Unit target = mapping.getTarget().getUnit();
				
				if (target instanceof Rule) {
					for (Node rhsNode : ((Rule) target).getRhs().getNodes()) {
						if (rhsNode.getName().equals(mapping.getTarget().getName())) {
							if (HenshinRuleAnalysisUtilEx.isCreationNode(rhsNode)) {
								// Convert input to output parameter:
								Parameter newTarget = mapping.getSource();
								Parameter newSource = mapping.getTarget();
								mapping.setSource(newSource);
								mapping.setTarget(newTarget);
							}
						}
					}
				}
			}
			
			// Fix Output-Parameter:
			else if (mapping.getTarget().getUnit() == unit) {
				Unit source = mapping.getSource().getUnit();
				
				if (source instanceof Rule) {
					for (Node lhsNode : ((Rule) source).getLhs().getNodes()) {
						if (lhsNode.getName().equals(mapping.getTarget().getName())) {
							if (HenshinRuleAnalysisUtilEx.isDeletionNode(lhsNode)) {
								// Convert output to input parameter:
								Parameter newTarget = mapping.getSource();
								Parameter newSource = mapping.getTarget();
								mapping.setSource(newSource);
								mapping.setTarget(newTarget);
							}
						}
					}
				}
			}
		}
	}

	private static void invertRule(Rule rule) {
		
		// Switch graph sides:
		Graph newRHS = rule.getLhs();
		Graph newLHS = rule.getRhs();
		
		rule.setLhs(newLHS);
		rule.setRhs(newRHS);
		
		// Switch mappings:
		rule.getMappings().forEach(mapping -> {
			
			// Rule mappings:
			Node newRHSNode = mapping.getOrigin();
			Node newLHSNode = mapping.getImage();
			
			mapping.setOrigin(newLHSNode);
			mapping.setImage(newRHSNode);
			
			// Multi-mappings:
			for (Mapping multiMapping : rule.getMultiMappings()) {
				if (multiMapping.getOrigin() == mapping.getOrigin()) {
					multiMapping.setOrigin(newLHSNode);
				}
				
				else if (multiMapping.getOrigin() == mapping.getImage()) {
					multiMapping.setImage(newRHSNode);
				}
			}
		});
	}
}

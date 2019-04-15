package org.sidiff.editrule.tools.handlers;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRemoteNode;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isDeletionNode;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isPreservedNode;
import static org.sidiff.editrule.tools.util.EditRuleUtil.getRequiredTypes;
import static org.sidiff.editrule.tools.util.EditRuleUtil.selectMostSpecificType;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.common.emf.modelstorage.EMFHandlerUtil;
import org.sidiff.common.ui.util.UIUtil;

/**
 * Makes each << preserve >> and << delete >> node as abstract as possible.
 * 
 * @author Manuel Ohrndorf
 */
public class MakeRuleAbstractHandler extends AbstractHandler implements IHandler  {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Module editRule = EMFHandlerUtil.getSelection(event, Module.class);
		
		if (editRule != null) {
			makeRuleAbstract(editRule);
			
			try {
				editRule.eResource().save(Collections.emptyMap());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			UIUtil.showMessage("Edit-Rule saved:\n\n" + EcoreUtil.getURI(editRule).toPlatformString(true));
		}
		
		return null;
	}
	
	public static void makeRuleAbstract(Module editRule) {
		editRule.eAllContents().forEachRemaining(element -> {
			if (element instanceof Node) {
				Node node = (Node) element;
				
				if (isDeletionNode(node)) {
					node.setType(selectMostSpecificType(getRequiredTypes(node)));
				}
				
				else if (isPreservedNode(node)) {
					Node remoteNode = getRemoteNode(node.getGraph().getRule().getMappings(), node);
					Set<EClass> requieredTypes = getRequiredTypes(node);
					requieredTypes.addAll(getRequiredTypes(remoteNode));
					
					EClass mostAnstractType = selectMostSpecificType(requieredTypes);
					
					node.setType(mostAnstractType);
					remoteNode.setType(mostAnstractType);
				}
			}
		});
	}
}

package org.sidiff.editrule.tools.handlers;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRHS;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isLHSNode;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isNodeWithChangingAttributes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isNodeWithCreationEdges;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isNodeWithDeletionEdges;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.common.emf.modelstorage.EMFHandlerUtil;
import org.sidiff.common.ui.util.UIUtil;

/**
 * Removes all non context (preserve) nodes from an edit rule.
 * 
 * @author Manuel Ohrndorf
 */
public class ReduceToContext extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Module editRule = EMFHandlerUtil.getSelection(event, Module.class);
		
		if (editRule != null) {
			reduceToContext(editRule);
			
			try {
				editRule.eResource().save(Collections.emptyMap());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			UIUtil.showMessage("Edit-Rule saved:\n\n" + EcoreUtil.getURI(editRule).toPlatformString(true));
		}
		
		return null;
	}
	
	public static void reduceToContext(Module editRule) {
		List<Node> nonContextNodes = new ArrayList<>();
		
		editRule.eAllContents().forEachRemaining(element -> {
			if (element instanceof Node) {
				Node lhsNode = (Node) element;
				
				if (isLHSNode(lhsNode)) {
					Node rhsNode = getRHS(lhsNode);
					
					// Is preserve node?
					if (rhsNode != null) {
						if (!isNodeWithCreationEdges(rhsNode)
								&& !isNodeWithDeletionEdges(lhsNode)
								&& !isNodeWithChangingAttributes(lhsNode)
								&& !isNodeWithChangingAttributes(rhsNode)) {
							
							nonContextNodes.add(lhsNode);
							nonContextNodes.add(rhsNode);
						}
					}
				}
			}
		});
		
		// TODO:
		// Teil-Graphen berechnen (Closures)
		// Verbindungen zwischen den Teil-Graphen berechnen
		// Nutzer Pfade auswählen lassen, die behalten werden sollen
		
		// Delete << preserve >> nodes:
		for (Node nonContextNode : nonContextNodes) {
			deleteNodeWithEdges(nonContextNode);
		}
	}
	
	/**
	 * @param node
	 *            The node which will be deleted from its graph.
	 */
	public static void deleteNodeWithEdges(Node node) {
		for (Edge outgoing : new ArrayList<Edge>(node.getOutgoing())) {
			deleteEdge(outgoing);
		}
		for (Edge incoming : new ArrayList<Edge>(node.getIncoming())) {
			deleteEdge(incoming);
		}
		deleteNode(node);
	}
	
	/**
	 * @param node
	 *            The node which will be deleted from its graph.
	 */
	public static void deleteNode(Node node) {
		
		// TODO: Clean-up parameters:
		
		// Clean-up mappings:
		node.getGraph().getRule().getMappings().stream()
				.filter(m -> ((m.getOrigin() == node) || (m.getImage() == node))).findFirst()
				.ifPresent(m -> EcoreUtil.remove(m));

		// Remove node from graph:
		EcoreUtil.remove(node);
	}

	/**
	 * @param edge
	 *            The edge which will be deleted from its graph.
	 */
	public static void deleteEdge(Edge edge) {
		EcoreUtil.remove(edge);
		edge.getSource().getOutgoing().remove(edge);
		edge.getTarget().getIncoming().remove(edge);
	}

}

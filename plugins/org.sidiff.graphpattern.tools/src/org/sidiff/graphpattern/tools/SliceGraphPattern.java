package org.sidiff.graphpattern.tools;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.sirius.viewpoint.DRepresentationElement;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphElement;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;

public class SliceGraphPattern extends AbstractHandler  {
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final Object selected = getSelection(event);

		if ((selected != null) && (selected instanceof GraphElement)) {

			// initialize the slice:
			List<NodePattern> fragment = new ArrayList<>();
			NodePattern initialNode = null;

			if (selected instanceof NodePattern) {
				initialNode = (NodePattern) selected;
			} else if (selected instanceof EdgePattern) {
				EdgePattern edge = (EdgePattern) selected;
				fragment.add(edge.getSource());
				initialNode = edge.getTarget();
			}  else if (selected instanceof AttributePattern) {
				initialNode = ((AttributePattern) selected).getNode();
			}

			// calculate the slice:
			slice(fragment, initialNode);

			// extract the slice:
			Pattern fullPattern = ((GraphElement) selected).getGraph().getPattern();
			Bundle bundle = fullPattern.getBundle();
			TransactionalEditingDomain editingDomain = (TransactionalEditingDomain) TransactionalEditingDomainImpl.getEditingDomainFor(bundle);

			RecordingCommand command = new RecordingCommand(editingDomain) {

				@Override
				protected void doExecute() {

					// create new graph pattern:
					Pattern pattern = GraphpatternFactory.eINSTANCE.createPattern();
					int position = bundle.getPatterns().indexOf(fullPattern) + 1;
					bundle.getPatterns().add(position, pattern);

					GraphPattern slicedGraph = GraphpatternFactory.eINSTANCE.createGraphPattern(); 
					pattern.getGraphs().add(slicedGraph);

					// move the sliced nodes:
					Set<NodePattern> fragmentSet = new HashSet<>(fragment);
					
					for (NodePattern node : fragment) {
						
						// is node completely contained in the fragment?
						if (isComplete(fragmentSet, node)) {
							slicedGraph.getNodes().add(node);
						} else {
							
							// replace node (in fragment) with copy:
							NodePattern node_copy = EcoreUtil.copy(node);
							node_copy.getOutgoings().clear();
 							
							// move node to fragment:
							slicedGraph.getNodes().add(node_copy);
							
							fragmentSet.remove(node);
							fragmentSet.add(node_copy);
							
							// move edges to fragment:
							for (EdgePattern outgoing : new ArrayList<>(node.getOutgoings())) {
								if (fragmentSet.contains(outgoing.getTarget())) {
									node_copy.getOutgoings().add(outgoing);
								}
							}
							
							for (NodePattern fragmentNode : fragmentSet) {
								for (EdgePattern outgoing : fragmentNode.getOutgoings()) {
									if (outgoing.getTarget() == node) {
										outgoing.setTarget(node_copy);
									}
								}
							}
						}
					}
				}
			};

			editingDomain.getCommandStack().execute(command);
		}
		
		return null;
	}
	
	protected static boolean isComplete(Set<NodePattern> fragment, NodePattern node) {
		for (EdgePattern edge : node.getIncomings()) {
			if (!fragment.contains(edge.getSource())) {
				return false;
			}
		}
		for (EdgePattern edge : node.getOutgoings()) {
			if (!fragment.contains(edge.getTarget())) {
				return false;
			}
		}
		return true;
	}

	protected Object getSelection(ExecutionEvent event) {
		ISelection selection = HandlerUtil.getCurrentSelection(event);

		if (!selection.isEmpty() && (selection instanceof IStructuredSelection)) {
			List<EObject> elements = getSemanticElements(((IStructuredSelection) selection).toList());
			
			if (elements.size() > 0) {
				
				// selection dialog:
				if (elements.size() > 1) {
					ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
							ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
					adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
					adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		
					ElementListSelectionDialog dialog = new ElementListSelectionDialog(
							Display.getCurrent().getActiveShell(), 
							new AdapterFactoryLabelProvider(adapterFactory));
					
					// open dialog:
					dialog.setElements(elements.toArray());
					dialog.setTitle("Select a Start Element:");
					
					if (dialog.open() == ElementListSelectionDialog.OK) {
						if (dialog.getResult().length > 0) {
							return dialog.getResult()[0];
						}
					}
				} else {
					return elements.get(0);
				}
			}
		}
		
		return null;
	}
	
	protected List<EObject> getSemanticElements(List<?> selection) {
		List<EObject> elements = new ArrayList<>();
		
		for (Object selected : selection) {
			
			// Sirius diagram element:
			if (selected instanceof IAdaptable) {
				View view = ((IAdaptable) selected).getAdapter(View.class);
				
				if (view != null) {
					if (view.getElement() instanceof DRepresentationElement) {
						elements.addAll(((DRepresentationElement) view.getElement()).getSemanticElements());
					}
				}
			}
			
			if (selected instanceof EObject) {
				elements.add((EObject) selected);
			} 
		}

		return elements;
	}
	
	protected static void slice(List<NodePattern> fragment, NodePattern next) {
		for (EdgePattern outgoing : next.getOutgoings()) {
			if ((outgoing.getTarget() != null) && !fragment.contains(outgoing.getTarget())) {
				fragment.add(outgoing.getTarget());
				slice(fragment, outgoing.getTarget());
			}
		}
	}
}

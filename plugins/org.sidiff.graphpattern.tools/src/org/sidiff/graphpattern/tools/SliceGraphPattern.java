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
			Set<EdgePattern> trace = new HashSet<>();

			if (selected instanceof NodePattern) {
				fragment.add((NodePattern) selected);
			} else if (selected instanceof EdgePattern) {
				EdgePattern edge = (EdgePattern) selected;

				fragment.add(edge.getTarget());
				trace.add(edge);

				if (edge.getOpposite() != null) {
					trace.add(edge.getOpposite());
				}
			}  else if (selected instanceof AttributePattern) {
				fragment.add(((AttributePattern) selected).getNode());
			}

			// calculate the slice:
			slice(fragment, trace);

			// extract the slice:
			Pattern fullPattern = ((GraphElement) selected).getGraph().getPattern();
			Bundle bundle = fullPattern.getBundle();
			TransactionalEditingDomain editingDomain = (TransactionalEditingDomain) TransactionalEditingDomainImpl.getEditingDomainFor(bundle);

			RecordingCommand command = new RecordingCommand(editingDomain) {

				@Override
				protected void doExecute() {

					// complete the slice: 
					if (selected instanceof EdgePattern) {
						EdgePattern edge = (EdgePattern) selected;

						NodePattern source = EcoreUtil.copy(edge.getSource());
						source.getOutgoings().clear();
						source.getOutgoings().add(edge);

						fragment.add(0, source);
					}

					// create new graph pattern:
					Pattern pattern = GraphpatternFactory.eINSTANCE.createPattern();
					int position = bundle.getPatterns().indexOf(fullPattern) + 1;
					bundle.getPatterns().add(position, pattern);

					GraphPattern slicedGraph = GraphpatternFactory.eINSTANCE.createGraphPattern(); 
					pattern.getGraphs().add(slicedGraph);

					// move the sliced nodes:
					slicedGraph.getNodes().addAll(fragment);
				}

			};

			editingDomain.getCommandStack().execute(command);
		}
		
		return null;
	}

	protected Object getSelection(ExecutionEvent event) {
		ISelection selection = HandlerUtil.getCurrentSelection(event);

		if (!selection.isEmpty() && (selection instanceof IStructuredSelection)) {
			List<EObject> elements = getSemanticElements(((IStructuredSelection) selection).toList());
			
			if (elements.size() > 0) {
				
				// selection dialog:
				if (!elements.isEmpty()) {
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
	
	protected static void slice(List<NodePattern> fragment, Set<EdgePattern> trace) {
		List<NodePattern> next = new ArrayList<>();
		
		for (NodePattern node : fragment) {
			for (EdgePattern outgoing : node.getOutgoings()) {
				if (!trace.contains(outgoing) && (outgoing.getTarget() != null)) {
					next.add(outgoing.getTarget());
					trace.add(outgoing);
				}
			}
			for (EdgePattern incoming : node.getIncomings()) {
				if (!trace.contains(incoming) && (incoming.getSource() != null)) {
					next.add(incoming.getSource());
					trace.add(incoming);
				}
			}
		}
		
		if (!next.isEmpty()) {
			slice(fragment, trace);
		}
		
		fragment.addAll(next);
	}
}

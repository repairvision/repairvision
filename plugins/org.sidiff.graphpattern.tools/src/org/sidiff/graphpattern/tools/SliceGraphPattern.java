package org.sidiff.graphpattern.tools;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
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
		ISelection selection = HandlerUtil.getCurrentSelection(event);

		if (selection instanceof IStructuredSelection) {
			Object selected = ((IStructuredSelection) selection).getFirstElement();
			
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
				Bundle bundle = ((GraphElement) selected).getGraph().getPattern().getBundle();
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
						bundle.getPatterns().add(pattern);
						
						GraphPattern slicedGraph = GraphpatternFactory.eINSTANCE.createGraphPattern(); 
						pattern.getGraphs().add(slicedGraph);
						
						// move the sliced nodes:
						slicedGraph.getNodes().addAll(fragment);
					}
					
				};
				
				editingDomain.getCommandStack().execute(command);
			}
		}
		
		return null;
	}

	protected static void slice(List<NodePattern> fragment, Set<EdgePattern> trace) {
		List<NodePattern> next = new ArrayList<>();
		
		for (NodePattern node : fragment) {
			for (EdgePattern outgoing : node.getOutgoings()) {
				if (!trace.contains(outgoing)) {
					next.add(outgoing.getTarget());
					trace.add(outgoing);
				}
			}
			for (EdgePattern incoming : node.getIncomings()) {
				if (!trace.contains(incoming)) {
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

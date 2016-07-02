package org.sidiff.consistency.graphpattern.matcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.sidiff.consistency.graphpattern.DataStore;
import org.sidiff.consistency.graphpattern.Evaluation;
import org.sidiff.consistency.graphpattern.GraphPattern;
import org.sidiff.consistency.graphpattern.GraphpatternFactory;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.matching.BasicMatchValidation;
import org.sidiff.consistency.graphpattern.matcher.matching.IMatchValidation;
import org.sidiff.consistency.graphpattern.matcher.matching.selection.AtomicPattern;
import org.sidiff.consistency.graphpattern.matcher.matching.selection.IAtomicPatternFactory;
import org.sidiff.consistency.graphpattern.matcher.matching.selection.PathSelector;

public abstract class AbstractPatternMatchingEngine implements IPatternMatchingEngine {

	protected GraphPattern graphpattern;
	
	protected ResourceSet targetModels;
	
	protected List<NodePattern> variableNodes;

	public AbstractPatternMatchingEngine(GraphPattern graphPattern, ResourceSet targetModels) {
		this.graphpattern = graphPattern;
		this.targetModels = targetModels;
	}
	
	@Override
	public void initialize(Map<NodePattern, Collection<EObject>> variableNodeDomains) {
		
		// Initialization as command -> support for graph patterns from editors:
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(graphpattern);
		
		if (editingDomain == null) {
			internal_initialize(variableNodeDomains);
		} else {
			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

				@Override
				protected void doExecute() {
					internal_initialize(variableNodeDomains);
				}

				@Override
				public boolean canUndo() {
					return false;
				}

			});		
		}
	}
	
	@Override
	public GraphPattern getGraphPattern() {
		return graphpattern;
	}

	@Override
	public void setGraphPattern(GraphPattern graphPattern) {
		this.graphpattern = graphPattern;
	}
	
	@Override
	public List<NodePattern> getVariableNodes() {
		return variableNodes;
	}

	private void internal_initialize(Map<NodePattern, Collection<EObject>> anchors) {
		
		// Initialize the evaluation data of each node:
		getAllNodePatterns().forEachRemaining(node -> {
			initializeEvaluation(node);
		});
		
		// Initialize variable nodes:
		anchors.entrySet().forEach(entry -> {
			Evaluation nodeEvaluation = entry.getKey().getEvaluation();
			entry.getValue().forEach(match -> nodeEvaluation.getStore().addMatch(match));
		});
		
		// Initial nodes:
		this.variableNodes = new ArrayList<>(anchors.keySet());
	}
	
	@Override
	public void start() {
		long startTime = System.currentTimeMillis(); 
				
		// Start visiting at the variable nodes:
		variableNodes.forEach(node -> {
			node.getEvaluation().accept(createVisitor());
		});
		
		System.out.println("Working-Graph Construction Time: " + (System.currentTimeMillis() - startTime) / 1000.0 + "s");
	}
	
	@Override
	public void finish() {
	}
	
	protected void initializeEvaluation(NodePattern nodePattern) {
		Evaluation evaluation = GraphpatternFactory.eINSTANCE.createEvaluation();
		DataStore dataStore = createDataStore();
		
		evaluation.setStore(dataStore);
		nodePattern.setEvaluation(evaluation);
		
		dataStore.initialize();
		evaluation.initialize();
	}

	protected Iterator<NodePattern> getAllNodePatterns() {
		return graphpattern.getNodes().iterator();
	}
	
	@Override
	public IAtomicPatternFactory createAtomicPatternFactory() {
		return new IAtomicPatternFactory() {
			
			@Override
			public AtomicPattern getAtomicPattern(PathSelector path, NodePattern node) {
				return null;
			}
		};
	}
	
	@Override
	public IMatchValidation createMatchValidation() {
		return new BasicMatchValidation();
	}

	public ResourceSet getResourceSet() {
		return targetModels;
	}
	
	public void setResourceSet(ResourceSet resourceSet) {
		this.targetModels = resourceSet;
	}

	@Override
	public String toString() {
		StringBuffer print = new StringBuffer();
		
		for (NodePattern node : graphpattern.getNodes()) {
			print.append(node + ":\n");
			
			node.getEvaluation().getStore().getMatchIterator().forEachRemaining(match -> {
				print.append("  " + match + "\n");
			});
		}
		
		return print.toString();
	}
}

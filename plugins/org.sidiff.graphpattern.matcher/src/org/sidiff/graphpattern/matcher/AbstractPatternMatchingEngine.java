package org.sidiff.graphpattern.matcher;

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
import org.sidiff.consistency.graphpattern.GraphpatternFactory;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.graphpattern.matching.IMatchGenerator;
import org.sidiff.graphpattern.matching.IMatching;
import org.sidiff.graphpattern.wgraph.construction.IWorkingGraphConstructor;

/**
 * Basic implementation of a pattern matching engine ({@link IPatternMatchingEngine}).
 * 
 * @author Manuel Ohrndorf
 */
public abstract class AbstractPatternMatchingEngine<R extends IMatching> implements IPatternMatchingEngine<R> {

	protected ResourceSet targetModels;

	protected List<NodePattern> graphPattern;

	protected List<NodePattern> variableNodes;

	protected Map<NodePattern, Collection<EObject>> variableNodeDomains;

	/**
	 * @param targetModels
	 *            The resource set that contains the model(s) which will be
	 *            searched for matches of the corresponding graph pattern.
	 */
	public AbstractPatternMatchingEngine(ResourceSet targetModels) {
		this.targetModels = targetModels;
	}

	@Override
	public void initialize(List<NodePattern> graphPattern, List<NodePattern> variableNodes,
			Map<NodePattern, Collection<EObject>> variableNodeDomains) {

		this.graphPattern = graphPattern;
		this.variableNodes = variableNodes;
		this.variableNodeDomains = variableNodeDomains;

		// Initialization as command -> support for graph patterns from editors:
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(graphPattern.get(0));

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

	private void internal_initialize(Map<NodePattern, Collection<EObject>> variableNodes) {

		// Initialize the evaluation data of each node:
		for (NodePattern node : graphPattern) {
			initializeEvaluation(node);
		}

		// Initialize variable nodes:
		variableNodes.entrySet().forEach(entry -> {
			Evaluation nodeEvaluation = entry.getKey().getEvaluation();
			entry.getValue().forEach(match -> nodeEvaluation.getStore().addMatch(match));
		});
	}

	@Override
	public void start() {

		// Working-graph construction:
		long startTime = System.currentTimeMillis();

		IWorkingGraphConstructor wgraph = getWorkingGraphConstructor();
		wgraph.initialize(graphPattern, variableNodes, variableNodeDomains);
		wgraph.start();

		System.out.println("Working-Graph Construction Time: " + (System.currentTimeMillis() - startTime) / 1000.0 + "s");

		// Generate matches:
		IMatchGenerator<R> matchGenerator = getMatchGenerator();
		matchGenerator.initialize(graphPattern, variableNodes);
		matchGenerator.start();
	}
	
	@Override
	public Iterator<R> getResults() {
		return getMatchGenerator().getResults();
	}

	@Override
	public void finish() {
		
		// Clean up:
		getWorkingGraphConstructor().finish();
		getMatchGenerator().finish();
	}

	protected void initializeEvaluation(NodePattern nodePattern) {
		Evaluation evaluation = GraphpatternFactory.eINSTANCE.createEvaluation();
		DataStore dataStore = createDataStore();

		evaluation.setStore(dataStore);
		nodePattern.setEvaluation(evaluation);

		dataStore.initialize();
		evaluation.initialize();
	}

	@Override
	public List<NodePattern> getGraphPattern() {
		return graphPattern;
	}

	@Override
	public List<NodePattern> getVariableNodes() {
		return variableNodes;
	}

	/**
	 * @return The resource set that contains the model(s) which will be
	 *         searched for matches of the corresponding graph pattern.
	 */
	public ResourceSet getResourceSet() {
		return targetModels;
	}

	@Override
	public String toString() {
		StringBuffer print = new StringBuffer();

		for (NodePattern node : graphPattern) {
			print.append(node + ":\n");

			node.getEvaluation().getStore().getMatchIterator().forEachRemaining(match -> {
				print.append("  " + match + "\n");
			});
		}

		return print.toString();
	}
}

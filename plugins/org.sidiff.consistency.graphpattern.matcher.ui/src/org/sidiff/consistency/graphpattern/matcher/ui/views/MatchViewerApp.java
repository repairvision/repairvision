package org.sidiff.consistency.graphpattern.matcher.ui.views;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.sidiff.consistency.graphpattern.DataStore;
import org.sidiff.consistency.graphpattern.EObjectList;
import org.sidiff.consistency.graphpattern.GraphMatch;
import org.sidiff.consistency.graphpattern.GraphPattern;
import org.sidiff.consistency.graphpattern.GraphpatternFactory;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.IPatternMatchingEngine;
import org.sidiff.consistency.graphpattern.matcher.data.CollectingMatchesDS;
import org.sidiff.consistency.graphpattern.matcher.matching.IMatchValidation;
import org.sidiff.consistency.graphpattern.matcher.matching.MatchGenerator;
import org.sidiff.consistency.graphpattern.matcher.matching.NodeMatching;
import org.sidiff.consistency.graphpattern.matcher.matching.selection.IAtomicPatternFactory;
import org.sidiff.consistency.graphpattern.matcher.tools.MatchingHelper;
import org.sidiff.consistency.graphpattern.matcher.ui.session.EngineManager;
import org.sidiff.consistency.graphpattern.matcher.ui.util.InfoConsole;
import org.sidiff.consistency.graphpattern.matcher.ui.util.SiriusUtil;
import org.sidiff.consistency.repair.lifting.util.RecognitionRuleUtil;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.SemanticChangeSet;
import org.sidiff.difference.symmetric.SymmetricFactory;

public class MatchViewerApp {

	/**
	 * Empty selection console message.
	 */
	public static final String MSG_EMPTY_SELECTION = "Please select a match!";

	/**
	 * The tree viewer showing the matchings.
	 */
	private TreeViewer viewer_matching;

	/**
	 * All actually generated graph matchings.
	 */
	private EList<GraphMatch> matchings;

	public MatchViewerApp(TreeViewer viewer_matching) {
		this.viewer_matching = viewer_matching;
		this.matchings = new BasicEList<GraphMatch>();

		viewer_matching.setInput(matchings);
	}

	// TODO BEGIN
	
	private List<NodePattern> test_getVariableNodes(List<NodePattern> graph) {
		List<NodePattern> seedingNodes = new ArrayList<NodePattern>();
		
		for (NodePattern node : graph) {
			if (RecognitionRuleUtil.isChangeNode(node)) {
				seedingNodes.add(node);
			}
		}
		
		return seedingNodes;
	}
	
	MatchGenerator matchGenerator;

	public void generateMatches() {
		matchings.clear();

		IPatternMatchingEngine engine = EngineManager.getInstance().getMatchingEngine();

		IAtomicPatternFactory atomicPatternFactory = engine.getAtomicPatternFactory();
		IMatchValidation matchValidation = engine.getMatchValidation();
		
		// TODO
		List<NodePattern> variableNodes = test_getVariableNodes(engine.getGraphPattern());
		Set<NodePattern> graphPattern = MatchingHelper.getClosure(variableNodes.get(0));
		
		matchGenerator = new MatchGenerator(graphPattern, variableNodes, atomicPatternFactory, matchValidation);

		int matchingCount = 0;

		List<SemanticChangeSet> repairChangeSets = new ArrayList<>();
		List<EObjectList> matchings = new ArrayList<>();

		while(true) {
			
			long timeStart = System.currentTimeMillis(); 
			
			boolean matchFound = matchGenerator.findNextMatch();
			
			long timeEnd = System.currentTimeMillis(); 
			InfoConsole.printInfos(Collections.emptyList(), "Time: " + ((timeEnd - timeStart) / 1000.0) + "s");
					
			if (matchFound) {
				Map<NodePattern, NodeMatching> matching = matchGenerator.getVariableMatching();
				repairChangeSets.add(createRepairChangeSet(matching));
				
				matchings.add(matchGenerator.getGraphPatternMatching());
				
				++matchingCount;
			} else {
				break;
			}
		}

		// Remove duplicates:
//		repairChangeSets = filterDuplicates(repairChangeSets);

		// Print infos:
		for (SemanticChangeSet repairChangeSet : repairChangeSets) {
			InfoConsole.printInfos(repairChangeSet.getChanges());
		}

		InfoConsole.printInfo(matchingCount + " matches found!");

		// Show matches to the UI:
		EObjectList matchingList = GraphpatternFactory.eINSTANCE.createEObjectList();
		matchingList.getContent().addAll(repairChangeSets);
		matchingList.getContent().addAll(matchings);
		
		this.viewer_matching.setInput(matchingList);
		this.viewer_matching.refresh();
	}

	public List<SemanticChangeSet> filterDuplicates(List<SemanticChangeSet> repairChangeSets) {
		List<SemanticChangeSet> min_repairChangeSets = new ArrayList<>();

		for (SemanticChangeSet repairChangeSet : repairChangeSets) {
			boolean containsEqual = false;

			for (SemanticChangeSet min_repairChangeSet : min_repairChangeSets) {
				boolean isEqual = true;

				// Compare changes:
				for (Change change : repairChangeSet.getChanges()) {
					for (Change min_change : min_repairChangeSet.getChanges()) {
						if (change != min_change) {
							isEqual = false;
							break;
						}
					}

					if (!isEqual) {
						break;
					}
				}

				if (isEqual) {
					containsEqual = true;
					break;
				}
			}

			if (!containsEqual) {
				min_repairChangeSets.add(repairChangeSet);
			}

		}

		return min_repairChangeSets;
	}

	public SemanticChangeSet createRepairChangeSet(Map<NodePattern, NodeMatching> matching)  {
		SemanticChangeSet repairChangeSet = SymmetricFactory.eINSTANCE.createSemanticChangeSet();

		for (Entry<NodePattern, NodeMatching> match : matching.entrySet()) {
			if (match.getValue().getMatch() != null) {
				repairChangeSet.getChanges().add((Change) match.getValue().getMatch());
			}
		}

		return repairChangeSet;
	}

	// TODO: END

	public void setMatch(EObjectList match) {
		List<NodePattern> graphpattern = matchGenerator.getNodes();

		for (NodePattern node : graphpattern) {
			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(node);
			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

				@Override
				protected void doExecute() {
					EObject matchEntry = match.getContent().get(graphpattern.indexOf(node));
					DataStore ds = new CollectingMatchesDS();
					node.getEvaluation().setStore(ds);

					if (matchEntry instanceof EObjectList) {
						for (EObject match : ((EObjectList) matchEntry).getContent()) {
							ds.addMatch(match);
						}
					}
					
					else if (matchEntry != MatchGenerator.EMPTY_MATCH) {
						ds.addMatch(match);
					}
				}

				@Override
				public boolean canUndo() {
					return false;
				}

			});
		}
		SiriusUtil.refreshActiveEditor();
	}

	public void printSelection(ISelection selection) {

		if (selection instanceof IStructuredSelection) {
			Object selectedElement = ((IStructuredSelection)selection).getFirstElement();
			InfoConsole.printInfo(selectedElement, MSG_EMPTY_SELECTION);
		}
	}
}

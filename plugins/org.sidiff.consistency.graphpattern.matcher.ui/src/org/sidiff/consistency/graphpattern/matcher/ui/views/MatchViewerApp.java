package org.sidiff.consistency.graphpattern.matcher.ui.views;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.sidiff.consistency.graphpattern.DataStore;
import org.sidiff.consistency.graphpattern.EObjectList;
import org.sidiff.consistency.graphpattern.GraphpatternFactory;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.IPatternMatchingEngine;
import org.sidiff.consistency.graphpattern.matcher.data.CollectingMatchesDS;
import org.sidiff.consistency.graphpattern.matcher.matching.IMatchGenerator;
import org.sidiff.consistency.graphpattern.matcher.matching.IMatching;
import org.sidiff.consistency.graphpattern.matcher.matching.INodeMatching;
import org.sidiff.consistency.graphpattern.matcher.matching.util.MatchingUtil;
import org.sidiff.consistency.graphpattern.matcher.ui.session.EngineManager;
import org.sidiff.consistency.graphpattern.matcher.ui.util.InfoConsole;
import org.sidiff.consistency.graphpattern.matcher.ui.util.SiriusUtil;

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
	 * All variable assignments.
	 */
	private List<EObjectList> variableAssignments;
	
	/**
	 * All graph pattern matchings
	 */
	private List<EObjectList> allMatchings;

	public MatchViewerApp(TreeViewer viewer_matching) {
		this.viewer_matching = viewer_matching;
	}

	public void generateMatches() {
		variableAssignments = new ArrayList<>();
		allMatchings = new ArrayList<>();
		
		IPatternMatchingEngine<? extends IMatching> engine = EngineManager.getInstance().getMatchingEngine();
		IMatchGenerator<? extends IMatching> matchGenerator = engine.getMatchGenerator();
		
		int matchingCount = 0;
		long timeStart = System.currentTimeMillis(); 
		
		for (Iterator<? extends IMatching> iterator = matchGenerator.getResults(); iterator.hasNext();) {
			IMatching match = iterator.next();
			
			InfoConsole.printInfos(Collections.emptyList(), "Match Generation Time: " 
					+ ((System.currentTimeMillis() - timeStart) / 1000.0) + "s");
			
			addVariableMatch(matchGenerator.getVariableMatching());
			allMatchings.add(MatchingUtil.createMatching(matchGenerator, match));
			
			++matchingCount;
		}

		// Print infos:
		for (EObjectList variableMatch : variableAssignments) {
			InfoConsole.printInfos(variableMatch.getContent());
		}

		InfoConsole.printInfo(matchingCount + " matches found!");

		// Show matches to the UI:
		EObjectList matchingList = GraphpatternFactory.eINSTANCE.createEObjectList();
		matchingList.getContent().addAll(variableAssignments);
		matchingList.getContent().addAll(allMatchings);
		
		this.viewer_matching.setInput(matchingList);
		this.viewer_matching.refresh();
		
		// Clean up matching engine:
		if (EngineManager.getInstance().getDebuggableEngine() != null) {
			EngineManager.getInstance().getDebuggableEngine().stop();
		} else {
			EngineManager.getInstance().getMatchingEngine().finish();
		}
	}
	
	private void addVariableMatch(Map<NodePattern, ? extends INodeMatching> matching) {
		EObjectList assignment = GraphpatternFactory.eINSTANCE.createEObjectList();
		
		for (INodeMatching match : matching.values()) {
			if (match.getMatch() != null) {
				assignment.getContent().add(match.getMatch());
			}
		}
		
		variableAssignments.add(assignment);
	}

	public void setMatch(EObjectList match) {
		IPatternMatchingEngine<? extends IMatching> engine = EngineManager.getInstance().getMatchingEngine();
		IMatchGenerator<? extends IMatching> matchGenerator = engine.getMatchGenerator();
		List<NodePattern> graphpattern = matchGenerator.getGraphPattern();

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
					
					else if (matchEntry != MatchingUtil.EMPTY_MATCH) {
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

package org.sidiff.revision.editrules.recognition.pattern;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.editrules.recognition.pattern.domain.Domain;
import org.sidiff.revision.editrules.recognition.pattern.graph.ChangePattern;
import org.sidiff.revision.editrules.recognition.revision.RevisionGraph;

public class RecognitionPatternInitializer {

	public static void initializeRecognitionPattern(RecognitionPattern recognitionPattern,  RevisionGraph revisionGraph) {
		
		// Initialization as command -> support for graph patterns from editors:
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(recognitionPattern.getGraphPattern());

		if (editingDomain == null) {
			internal_initializeRecognitionPattern(recognitionPattern, revisionGraph);
		} else {
			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

				@Override
				protected void doExecute() {
					internal_initializeRecognitionPattern(recognitionPattern, revisionGraph);
				}

				@Override
				public boolean canUndo() {
					return false;
				}

			});
		}
	}
	
	private static void internal_initializeRecognitionPattern(RecognitionPattern recognitionPattern, RevisionGraph revisionGraph) {
		initializeDomains(recognitionPattern, revisionGraph);
		initializeChangePatterns(recognitionPattern, revisionGraph);
	}
	
	private static void initializeDomains(RecognitionPattern recognitionPattern, RevisionGraph matchingHelper) {
		for (NodePattern node : recognitionPattern.getGraphNodePatterns()) {
			initializeEvaluation(node, matchingHelper);
		}
		for (NodePattern change : recognitionPattern.getChangeNodePatterns()) {
			initializeEvaluation(change, matchingHelper);
		}
	}
	
	private static void initializeEvaluation(NodePattern nodePattern, RevisionGraph matchingHelper) {
		Domain domain = new Domain();
		nodePattern.setMatching(domain);
		domain.initialize(matchingHelper);
	}
	
	private static void initializeChangePatterns(RecognitionPattern recognitionPattern, RevisionGraph revisionGraph) {
		
		for (NodePattern changeNodePattern : recognitionPattern.getChangeNodePatterns()) {
			ChangePattern changePattern = recognitionPattern.getChangePattern(changeNodePattern);
			
			for (EObject change : revisionGraph.getRevision().getDifference().getChangeDomain(
					changePattern.getChangeType(), changePattern.getMetaModelType())) {
				
				if (change instanceof Change) {
					changePattern.addChange((Change) change);
				}
			}
		}
	}
}

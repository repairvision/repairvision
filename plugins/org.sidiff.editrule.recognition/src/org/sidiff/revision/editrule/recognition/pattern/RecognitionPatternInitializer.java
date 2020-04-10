package org.sidiff.revision.editrule.recognition.pattern;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.revision.editrule.recognition.pattern.domain.Domain;
import org.sidiff.revision.editrule.recognition.pattern.graph.ChangePattern;
import org.sidiff.revision.editrule.recognition.revision.RevisionGraph;

public class RecognitionPatternInitializer {

	public static void initializeRecognitionPattern(RecognitionPattern recognitionPattern,  RevisionGraph matchingHelper) {
		
		// Initialization as command -> support for graph patterns from editors:
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(recognitionPattern.getGraphPattern());

		if (editingDomain == null) {
			internal_initializeRecognitionPattern(recognitionPattern, matchingHelper);
		} else {
			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

				@Override
				protected void doExecute() {
					internal_initializeRecognitionPattern(recognitionPattern, matchingHelper);
				}

				@Override
				public boolean canUndo() {
					return false;
				}

			});
		}
	}
	
	private static void internal_initializeRecognitionPattern(RecognitionPattern recognitionPattern, RevisionGraph matchingHelper) {
		initializeDomains(recognitionPattern, matchingHelper);
		initializeChangePatterns(recognitionPattern, matchingHelper);
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
	
	private static void initializeChangePatterns(RecognitionPattern recognitionPattern, RevisionGraph matchingHelper) {
		
		for (NodePattern changeNodePattern : recognitionPattern.getChangeNodePatterns()) {
			ChangePattern changePattern = recognitionPattern.getChangePattern(changeNodePattern);
			
			for (EObject change : matchingHelper.getRevision().getDifference().getChangeDomain(
					changePattern.getChangeType(), changePattern.getMetaModelType())) {
				
				if (change instanceof Change) {
					changePattern.addChange((Change) change);
				}
			}
		}
	}
}

package org.sidiff.editrule.recognition.pattern;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.sidiff.editrule.recognition.pattern.domain.Domain;
import org.sidiff.editrule.recognition.pattern.graph.ChangePattern;
import org.sidiff.editrule.recognition.util.LiftingGraphDomainMap;
import org.sidiff.editrule.recognition.util.MatchingHelper;
import org.sidiff.graphpattern.NodePattern;

public class RecognitionPatternInitializer {

	public static void initializeRecognitionPattern(RecognitionPattern recognitionPattern, 
			LiftingGraphDomainMap changeDomainMap, MatchingHelper matchingHelper) {
		
		// Initialization as command -> support for graph patterns from editors:
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(recognitionPattern.getGraphPattern());

		if (editingDomain == null) {
			internal_initializeRecognitionPattern(recognitionPattern, changeDomainMap, matchingHelper);
		} else {
			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

				@Override
				protected void doExecute() {
					internal_initializeRecognitionPattern(recognitionPattern, changeDomainMap, matchingHelper);
				}

				@Override
				public boolean canUndo() {
					return false;
				}

			});
		}
	}
	
	private static void internal_initializeRecognitionPattern(RecognitionPattern recognitionPattern, 
			LiftingGraphDomainMap changeDomainMap, MatchingHelper matchingHelper) {
		initializeDomains(recognitionPattern, matchingHelper);
		initializeChangePatterns(recognitionPattern, changeDomainMap);
	}
	
	private static void initializeDomains(RecognitionPattern recognitionPattern, MatchingHelper matchingHelper) {
		for (NodePattern node : recognitionPattern.getGraphNodePatterns()) {
			initializeEvaluation(node, matchingHelper);
		}
		for (NodePattern change : recognitionPattern.getChangeNodePatterns()) {
			initializeEvaluation(change, matchingHelper);
		}
	}
	
	private static void initializeEvaluation(NodePattern nodePattern, MatchingHelper matchingHelper) {
		Domain domain = new Domain();
		nodePattern.setMatching(domain);
		domain.initialize(matchingHelper);
	}
	
	private static void initializeChangePatterns(
			RecognitionPattern recognitionPattern, LiftingGraphDomainMap changeDomainMap) {
		
		for (NodePattern changeNodePattern : recognitionPattern.getChangeNodePatterns()) {
			ChangePattern changePattern = recognitionPattern.getChangePattern(changeNodePattern);
			
			for (EObject change : changeDomainMap.getChangeDomain(
					changePattern.getChangeType(), changePattern.getMetaModelType())) {
				Domain.get(changeNodePattern).add(change);
			}
		}
	}
}

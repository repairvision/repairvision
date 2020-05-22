package org.sidiff.revision.editrules.recognition.configuration;

import java.util.logging.Level;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.revision.common.logging.ReVisionLogger;
import org.sidiff.revision.common.logging.util.LogTime;
import org.sidiff.revision.common.logging.util.LogUtil;
import org.sidiff.revision.editrules.recognition.pattern.graph.ActionNode;

public class RecognitionLogger extends ReVisionLogger {

	public static final Level STEPWISE = Level.FINEST;
	
	public boolean isStepwise() {
		return logger.isLoggable(STEPWISE);
	}
	
	public void logMatchingTime(LogTime matchingTimer) {
		if (logger.isLoggable(Level.FINER)) {
			logger.log(Level.FINER, "[Matching Time] " + LogUtil.getTime(matchingTimer));
		}
	}

	public void logChangeCount(int domainSize) {
		if (logger.isLoggable(Level.FINER)) {
			logger.log(Level.FINER, "[Change Count (Sum)]: " + domainSize);
		}
	}
	
	public void logChangeActionCount(int size) {
		if (logger.isLoggable(Level.FINER)) {
			logger.log(Level.FINER, "[Change Action Count]: " + size);
		}
	}

	public void logEditRule(Rule editRule) {
		if (logger.isLoggable(Level.FINER)) {
			logger.log(Level.FINER, "[Edit Rule Matching]: " + editRule.getName());
		}
	}

	public void logRecognitionTime(LogTime matchingTime) {
		if (logger.isLoggable(Level.FINER)) {
			logger.log(Level.FINER, "[Recognition Time]: " + LogUtil.getTime(matchingTime));
		}
	}

	public void logFalsePositives(int falsePositives) {
		if (logger.isLoggable(Level.FINER)) {
			logger.log(Level.FINER, "[False Positives]: " + falsePositives);
		}
	}

	public void logFoundMatchings(int matchings) {
		if (logger.isLoggable(Level.FINER)) {
			logger.log(Level.FINER, "[Matchings Found]: " + matchings);
		}
	}

	public void logEvaluationStepContextB(ActionNode node, EObject matchB) {
		if (logger.isLoggable(STEPWISE)) {
			logger.log(STEPWISE, "    B:" + node);
			logger.log(STEPWISE, "        Match: " + matchB);
		}
	}

	public void logEvaluationStepContextA(ActionNode actionNode, EObject matchA) {
		if (logger.isLoggable(STEPWISE)) {
			logger.log(STEPWISE, "    A:" + actionNode);
			logger.log(STEPWISE, "        Match: " + matchA);
		}
	}

	public void logEvaluationStep(ActionNode actionNode) {
		if (logger.isLoggable(STEPWISE)) {
			logger.log(STEPWISE, "Evaluation Step: " + actionNode);
		}
	}

	public void logDomainInitialization(String domainInitialization) {
		if (logger.isLoggable(STEPWISE)) {
			logger.log(STEPWISE, "Initial Domains: \n\n" + domainInitialization);
		}
	}
}

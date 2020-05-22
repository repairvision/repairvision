package org.sidiff.revision.editrules.recognition.configuration;

import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.history.revision.IRevision;
import org.sidiff.revision.editrules.recognition.impact.ImpactScope;
import org.sidiff.validation.constraint.impact.ImpactAnalyzes;

public class RecognitionSettings {

	private RecognitionLogger logger = new RecognitionLogger();

	private int minimumSolutionSize = 1;
	
	private IRevision revision;
	
	private Rule editRule;
	
	private ImpactAnalyzes impact;
	
	private ImpactScope scopeModelA;
	
	private ImpactScope scopeModelB;
	
	private ImpactScope overwriteScope;

	/**
	 * @return The recognition engine logging monitor.
	 */
	public RecognitionLogger getLogger() {
		return logger;
	}

	/**
	 * @param logger
	 *            The recognition engine logging monitor.
	 */
	public void setLogger(RecognitionLogger logger) {
		this.logger = logger;
	}

	/**
	 * @return The minimum size of the solutions to be found.
	 */
	public int getMinimumSolutionSize() {
		return minimumSolutionSize;
	}

	/**
	 * @param minimumSolutionSize
	 *            The minimum size of the solutions to be found or 1.
	 */
	public void setMinimumSolutionSize(int minimumSolutionSize) {
		this.minimumSolutionSize = minimumSolutionSize;
	}

	public IRevision getRevision() {
		return revision;
	}

	public void setRevision(IRevision revision) {
		this.revision = revision;
	}

	public Rule getEditRule() {
		return editRule;
	}

	public void setEditRule(Rule editRule) {
		this.editRule = editRule;
	}

	public ImpactAnalyzes getImpact() {
		return impact;
	}

	public void setImpact(ImpactAnalyzes impact) {
		this.impact = impact;
	}

	public ImpactScope getScopeModelB() {
		return scopeModelB;
	}

	public void setScopeModelB(ImpactScope resolvingScope) {
		this.scopeModelB = resolvingScope;
	}

	public ImpactScope getOverwriteScope() {
		return overwriteScope;
	}

	public void setOverwriteScope(ImpactScope overwriteScope) {
		this.overwriteScope = overwriteScope;
	}

	public ImpactScope getScopeModelA() {
		return scopeModelA;
	}

	public void setScopeModelA(ImpactScope introducingScope) {
		this.scopeModelA = introducingScope;
	}
	
}

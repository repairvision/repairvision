package org.sidiff.revision.editrules.recognition.configuration;

import java.util.List;

import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.utilities.henshin.HenshinChangesUtil;
import org.sidiff.history.revision.IRevision;
import org.sidiff.revision.editrules.recognition.impact.ImpactScope;
import org.sidiff.validation.constraint.impact.ImpactAnalyzes;

public class RecognitionSettings {

	private RecognitionLogger logger = new RecognitionLogger();

	private int minimumSolutionSize = 1;
	
	private IRevision revision;
	
	private Rule editRule;
	
	private ImpactAnalyzes impactAnalyzes;
	
	// Indexed scopes:
	
	protected ImpactScope scopeModelA;
	
	protected ImpactScope scopeModelB;
	
	protected ImpactScope overwriteScope;

	public boolean hasPotentialImpact() {
		return !scopeModelA.isEmpty() && !scopeModelB.isEmpty();
	}

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

	public ImpactAnalyzes getImpactAnalyzes() {
		return impactAnalyzes;
	}

	public void setImpactAnalyzes(ImpactAnalyzes impact) {
		this.impactAnalyzes = impact;
		
		if (editRule == null) {
			throw new RuntimeException("Edit rule needs to be set prior to the impact analyzes!");
		}
		
		// TODO: Implement RuleInfo:
		List<GraphElement> changes = HenshinChangesUtil.getPotentialChanges(editRule);
		List<Attribute> settingAttributes = HenshinChangesUtil.getSettingAttributes(editRule);
	
		// Filter edit-rules by impact (sub-rule -> negative, complement-rule -> positive):
		this.scopeModelA = new ImpactScope(changes, impact.getCurrentImpactAnalysis());
		this.scopeModelB = new ImpactScope(changes, impact.getHistoricalImpactAnalysis());
		this.overwriteScope = new ImpactScope(settingAttributes, impact.getCurrentImpactAnalysis());
	}

	public ImpactScope getScopeModelB() {
		return scopeModelB;
	}

	public ImpactScope getOverwriteScope() {
		return overwriteScope;
	}

	public ImpactScope getScopeModelA() {
		return scopeModelA;
	}
	
}

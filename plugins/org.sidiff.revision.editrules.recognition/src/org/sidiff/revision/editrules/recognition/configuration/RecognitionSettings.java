package org.sidiff.revision.editrules.recognition.configuration;

import java.util.List;

import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.history.revision.IRevision;
import org.sidiff.revision.common.henshin.HenshinChangesUtil;
import org.sidiff.revision.editrules.impact.graph.GraphActionImpactScope;
import org.sidiff.revision.impact.analysis.ImpactAnalyzes;

public class RecognitionSettings {

	private RecognitionLogger logger = new RecognitionLogger();

	private int minimumSolutionSize = 1;
	
	private IRevision revision;
	
	private Rule editRule;
	
	private ImpactAnalyzes historicalImpactAnalyzes;
	
	private ImpactAnalyzes currentImpactAnalyzes;
	
	// Indexed scopes:
	
	protected GraphActionImpactScope historicalScope;
	
	protected GraphActionImpactScope currentScope;
	
	protected GraphActionImpactScope attributeScope;

	public boolean hasPotentialImpact() {
		return !historicalScope.isEmpty() && !currentScope.isEmpty();
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

	public ImpactAnalyzes getHistoricalImpactAnalyzes() {
		return historicalImpactAnalyzes;
	}
	
	public ImpactAnalyzes getCurrentImpactAnalyzes() {
		return currentImpactAnalyzes;
	}

	public void setImpactAnalyzes(ImpactAnalyzes historicalImpactAnalyzes, ImpactAnalyzes currentImpactAnalyzes) {
		this.historicalImpactAnalyzes = historicalImpactAnalyzes;
		this.currentImpactAnalyzes = currentImpactAnalyzes;
		
		if (editRule == null) {
			throw new RuntimeException("Edit rule needs to be set prior to the impact analyzes!");
		}
		
		// TODO: Implement RuleInfo:
		List<GraphElement> changes = HenshinChangesUtil.getPotentialChanges(editRule);
		List<Attribute> settingAttributes = HenshinChangesUtil.getSettingAttributes(editRule);
	
		// Filter edit-rules by impact (sub-rule -> negative, complement-rule -> positive):
		this.historicalScope = new GraphActionImpactScope(changes, historicalImpactAnalyzes.getPotentialImpactScope());
		this.currentScope = new GraphActionImpactScope(changes, currentImpactAnalyzes.getPotentialImpactScope());
		this.attributeScope = new GraphActionImpactScope(settingAttributes, currentImpactAnalyzes.getPotentialImpactScope());
	}
	
	public GraphActionImpactScope getHistoricalScope() {
		return historicalScope;
	}

	public GraphActionImpactScope getCurrentScope() {
		return currentScope;
	}

	public GraphActionImpactScope getAttributeScope() {
		return attributeScope;
	}
	
}

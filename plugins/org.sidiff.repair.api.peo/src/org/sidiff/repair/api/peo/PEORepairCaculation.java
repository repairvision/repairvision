package org.sidiff.repair.api.peo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.common.henshin.ChangePatternUtil;
import org.sidiff.consistency.common.monitor.LogTime;
import org.sidiff.editrule.recognition.impact.NegativeImpactScope;
import org.sidiff.editrule.recognition.impact.PositiveImpactScope;
import org.sidiff.history.revision.IRevision;
import org.sidiff.repair.api.IRepairPlan;
import org.sidiff.repair.api.peo.configuration.PEORepairSettings;
import org.sidiff.repair.complement.construction.ComplementRule;
import org.sidiff.repair.complement.peo.finder.ComplementFinder;
import org.sidiff.repair.complement.peo.finder.ComplementFinderEngine;
import org.sidiff.repair.complement.peo.impact.GraphActionImpactUtil;
import org.sidiff.repair.complement.repair.RepairPlan;
import org.sidiff.validation.constraint.impact.ImpactAnalyzes;

public class PEORepairCaculation {
	
	protected Rule editRule;
	
	protected ImpactAnalyzes impact;
	
	protected PositiveImpactScope positiveImpactScope;
	
	protected NegativeImpactScope negativeImpactScope;
	
	protected ComplementFinderEngine complementFinderEngine;
	
	protected ComplementFinder complementFinder;
	
	protected int repairCount = 0;
	
	public PEORepairCaculation(PEORepairSettings settings, Rule editRule, IRevision revision,
			ImpactAnalyzes impact, ComplementFinderEngine complementFinderEngine) {
		
		this.editRule = editRule;
		this.impact = impact;
		this.complementFinderEngine = complementFinderEngine;
		
		// TODO: Implement RuleInfo:
		List<GraphElement> changes = ChangePatternUtil.getPotentialChanges(editRule);
		List<Attribute> settingAttributes = ChangePatternUtil.getSettingAttributes(editRule);
		
		// Filter edit-rules by impact (sub-rule -> negative, complement-rule -> positive):
		this.positiveImpactScope = new PositiveImpactScope(changes, impact.getPositiveImpactAnalysis());
		this.negativeImpactScope = new NegativeImpactScope(changes, impact.getNegativeImpactAnalysis(), revision);
		
		PositiveImpactScope overwriteImpactScope = new PositiveImpactScope(settingAttributes, impact.getPositiveImpactAnalysis());
		
		// Create complement finder:
		if (isPotentialRepair()) {
			complementFinder = complementFinderEngine.createComplementFinder(
					editRule, positiveImpactScope, overwriteImpactScope,
					settings.getComplementFinderSettings());
		}
	}
	
	public boolean isPotentialRepair() {
		return !positiveImpactScope.isEmpty() && !negativeImpactScope.isEmpty();
	}
	
	public ComplementFinder getComplementFinder() {
		return complementFinder;
	}
	
	public List<IRepairPlan> findRepairs(LogTime complementMatchingTimer) {
		repairCount = 0;
		
		if (isPotentialRepair()) {
			List<IRepairPlan> repairs = new ArrayList<>();
			
			for(ComplementRule complement : complementFinder.findComplementRules()) {
				complementMatchingTimer.start();

				// Filter complements by abstract repairs:
				if (complement.getComplementingChanges().size() > 0) {
					
					if (GraphActionImpactUtil.potential(
							impact.getPositivePotentialImpactAnalysis(), 
							complement.getComplementingChanges()) 
					 && GraphActionImpactUtil.potential(
							 impact.getNegativePotentialImpactAnalysis(), 
							 complement.getRecognizedChanges())) {

						// Filter complement with pre-match by inconsistency impact:
						if (GraphActionImpactUtil.real(
								impact.getNegativeImpactAnalysis(),
								complement.getRecognizedChanges(),
								complement.getRecognitionMatch())) {
							
							List<Match> complementMatches = complementFinderEngine.findComplementMatches(complement, Collections.emptyList());
							List<Match> repairMatches = new ArrayList<>(complementMatches.size());
							
							for (Match complementMatch : complementMatches) {
								if (GraphActionImpactUtil.real(
										impact.getPositiveImpactAnalysis(), 
										complement.getComplementingChanges(), 
										complementMatch)) {
									
									repairMatches.add(complementMatch);
								}
							}
							
							if (!repairMatches.isEmpty()) {
								repairs.add(new RepairPlan(complement, repairMatches));
								repairCount += repairMatches.size();
							}
						}
					}
				}
				
				complementMatchingTimer.stop();
			}
			
			return repairs;
		} else {
			return Collections.emptyList();
		}
	}
	
	public int getRepairCount() {
		return repairCount;
	}
}

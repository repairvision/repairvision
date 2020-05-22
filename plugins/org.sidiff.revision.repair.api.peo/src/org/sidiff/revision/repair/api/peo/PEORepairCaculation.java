package org.sidiff.revision.repair.api.peo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.utilities.henshin.HenshinChangesUtil;
import org.sidiff.history.revision.IRevision;
import org.sidiff.history.revision.util.SymmetricDifferenceUtil;
import org.sidiff.revision.common.logging.util.LogTime;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.editrules.recognition.impact.ImpactScope;
import org.sidiff.revision.repair.api.IRepairPlan;
import org.sidiff.revision.repair.api.peo.configuration.PEORepairSettings;
import org.sidiff.revision.repair.complement.construction.ComplementRule;
import org.sidiff.revision.repair.complement.peo.finder.ComplementFinder;
import org.sidiff.revision.repair.complement.peo.finder.ComplementFinderEngine;
import org.sidiff.revision.repair.complement.peo.impact.GraphActionImpactUtil;
import org.sidiff.revision.repair.complement.repair.RepairPlan;
import org.sidiff.validation.constraint.impact.ImpactAnalyzes;

public class PEORepairCaculation {
	
	protected Rule editRule;
	
	protected ImpactAnalyzes impact;
	
	protected ImpactScope positiveImpactScope;
	
	protected ImpactScope negativeImpactScope;
	
	protected ComplementFinderEngine complementFinderEngine;
	
	protected ComplementFinder complementFinder;
	
	protected int repairCount = 0;
	
	public PEORepairCaculation(PEORepairSettings settings, Rule editRule, IRevision revision,
			ImpactAnalyzes impact, ComplementFinderEngine complementFinderEngine) {
		
		this.editRule = editRule;
		this.impact = impact;
		this.complementFinderEngine = complementFinderEngine;
		
		// Validate difference:
		if (settings.isValidateDifference()) {
			for (Change change : revision.getDifference().getSymmetricDifference().getChanges()) {
				if (!SymmetricDifferenceUtil.isResolvableChange(change)) {
					settings.getLogger().logChangeValidation(change, "Unresolvable change: " + change);
				}
			}
		}
		
		// TODO: Implement RuleInfo:
		List<GraphElement> changes = HenshinChangesUtil.getPotentialChanges(editRule);
		List<Attribute> settingAttributes = HenshinChangesUtil.getSettingAttributes(editRule);
		
		// Filter edit-rules by impact (sub-rule -> negative, complement-rule -> positive):
		this.positiveImpactScope = new ImpactScope(changes, impact.getCurrentImpactAnalysis());
		this.negativeImpactScope = new ImpactScope(changes, impact.getHistoricalImpactAnalysis());
		
		ImpactScope overwriteImpactScope = new ImpactScope(settingAttributes, impact.getCurrentImpactAnalysis());
		
		// Create complement finder:
		if (isPotentialRepair()) {
			complementFinder = complementFinderEngine.createComplementFinder(
					editRule, impact, positiveImpactScope, overwriteImpactScope, 
					negativeImpactScope, settings.getComplementFinderSettings());
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
							impact.getCurrentPotentialImpactAnalysis(), 
							complement.getComplementingBoundaryChanges()) 
					 && GraphActionImpactUtil.potential(
							 impact.getHistoricalPotentialImpactAnalysis(), 
							 complement.getRecognizedChanges())) {

						// Filter complement with pre-match by inconsistency impact:
						if (GraphActionImpactUtil.real(
								impact.getHistoricalImpactAnalysis(),
								complement.getRecognizedChanges(),
								complement.getRecognitionMatch())) {
							
							List<Match> repairMatches = complementFinderEngine.findComplementMatches(complement);
							
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

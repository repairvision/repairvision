package org.sidiff.completion.ui.model.proposals.recognition.impact;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.history.revision.IRevision;
import org.sidiff.validation.constraint.impact.ImpactAnalysis;
import org.sidiff.validation.constraint.impact.ImpactAnalyzes;
import org.sidiff.validation.constraint.impact.PotentialImpactAnalysis;

public class ModelCompletionImpactAnalyzes implements ImpactAnalyzes {

	/**
	 * Positive -> Current impact on context:
	 */
	private CurrentImpactAnalysis currentImpactAnalysis;
	
	/**
	 * Negative -> Historic impact on context:
	 */
	private HistoricalImpactAnalysis historicalImpactAnalysis;
	
	public ModelCompletionImpactAnalyzes(IRevision difference, List<EObject> context) {
		Set<EObject> contextSet = new LinkedHashSet<>(context);
		List<Change> contextChanges = new ArrayList<>();
		
		for (EObject contextElement : context) {
			contextChanges.addAll(difference.getDifference().getLocalChanges(contextElement));
		}
		
		this.currentImpactAnalysis = new CurrentImpactAnalysis(contextSet); // TODO: Should we expand the context, e.g., following all non-many references...?
		this.historicalImpactAnalysis = new HistoricalImpactAnalysis(contextSet, contextChanges);
	}

	@Override
	public PotentialImpactAnalysis getHistoricalPotentialImpactAnalysis() {
		return historicalImpactAnalysis;
	}

	@Override
	public ImpactAnalysis getHistoricalImpactAnalysis() {
		return historicalImpactAnalysis;
	}

	@Override
	public ImpactAnalysis getCurrentImpactAnalysis() {
		return currentImpactAnalysis;
	}

	@Override
	public PotentialImpactAnalysis getCurrentPotentialImpactAnalysis() {
		return currentImpactAnalysis;
	}
}

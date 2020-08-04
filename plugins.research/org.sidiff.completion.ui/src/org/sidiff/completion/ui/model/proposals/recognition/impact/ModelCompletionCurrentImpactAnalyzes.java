package org.sidiff.completion.ui.model.proposals.recognition.impact;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.history.revision.IRevision;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.impact.analysis.ImpactAnalysis;
import org.sidiff.revision.impact.analysis.ImpactAnalyzes;
import org.sidiff.revision.impact.analysis.ImpactScope;
import org.sidiff.revision.impact.analysis.PotentialImpactAnalysis;
import org.sidiff.revision.impact.analysis.PotentialImpactScope;

public class ModelCompletionCurrentImpactAnalyzes implements ImpactAnalyzes {

	private ModelCompletionCurrentImpactAnalysis modelCompletionCurrentImpactAnalysis;
	
	private ModelCompletionImpactScope modelCompletionImpactScope;

	public ModelCompletionCurrentImpactAnalyzes(IRevision difference, List<EObject> context) {
		Set<EObject> contextSet = new LinkedHashSet<>(context);
		List<Change> contextChanges = new ArrayList<>();
		
		for (EObject contextElement : context) {
			contextChanges.addAll(difference.getDifference().getLocalChanges(contextElement));
		}
		
		this.modelCompletionCurrentImpactAnalysis = new ModelCompletionCurrentImpactAnalysis(contextSet); // TODO: Should we expand the context, e.g., following all non-many references...?
		this.modelCompletionImpactScope = new ModelCompletionImpactScope(contextSet, modelCompletionCurrentImpactAnalysis);
	}

	@Override
	public ImpactScope getImpactScope() {
		return modelCompletionImpactScope;
	}

	@Override
	public ImpactAnalysis getImpactAnalysis() {
		return modelCompletionCurrentImpactAnalysis;
	}

	@Override
	public PotentialImpactScope getPotentialImpactScope() {
		return modelCompletionImpactScope;
	}

	@Override
	public PotentialImpactAnalysis getPotentialImpactAnalysis() {
		return modelCompletionCurrentImpactAnalysis;
	}
}

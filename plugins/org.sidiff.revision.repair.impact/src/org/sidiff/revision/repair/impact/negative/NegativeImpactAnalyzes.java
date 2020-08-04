package org.sidiff.revision.repair.impact.negative;

import java.util.List;

import org.sidiff.revision.impact.analysis.ImpactAnalyzes;
import org.sidiff.revision.impact.analysis.ImpactScope;
import org.sidiff.revision.impact.analysis.PotentialImpactScope;
import org.sidiff.revision.repair.impact.RepairActionImpactScope;
import org.sidiff.validation.constraint.api.util.Validation;

public class NegativeImpactAnalyzes implements ImpactAnalyzes {

	private PotentialImpactScope negativePotentialImpactScope;
	
	private NegativePotentialImpactAnalysis negativePotentialImpactAnalysis;
	
	private RepairActionImpactScope repairActionImpactScope;
	
	private NegativeImpactAnalysis negativeImpactAnalysis;
	
	public NegativeImpactAnalyzes(RepairActionImpactScope repairActionImpactScope) {
		this.negativePotentialImpactScope = new NegativePotentialImpactScope(repairActionImpactScope);
		this.repairActionImpactScope = repairActionImpactScope;
		this.negativePotentialImpactAnalysis = new NegativePotentialImpactAnalysis(repairActionImpactScope);
		this.negativeImpactAnalysis = new NegativeImpactAnalysis(repairActionImpactScope);
	}
	
	@Override
	public PotentialImpactScope getPotentialImpactScope() {
		return negativePotentialImpactScope;
	}
	
	@Override
	public NegativePotentialImpactAnalysis getPotentialImpactAnalysis() {
		return negativePotentialImpactAnalysis;
	}
	
	@Override
	public ImpactScope getImpactScope() {
		return repairActionImpactScope;
	}

	@Override
	public NegativeImpactAnalysis getImpactAnalysis() {
		return negativeImpactAnalysis;
	}
	
	public List<? extends Validation> getValidations() {
		return repairActionImpactScope.getValidations();
	}
	
	@Override
	public String toString() {
		StringBuilder toString = new StringBuilder(super.toString());
		toString.append(" -> ");
		toString.append(repairActionImpactScope.toString());
		return toString.toString();
	}

}

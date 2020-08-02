package org.sidiff.validation.constraint.impact.repair;

import java.util.List;

import org.sidiff.validation.constraint.api.util.Validation;
import org.sidiff.validation.constraint.impact.ImpactAnalyzes;
import org.sidiff.validation.constraint.impact.ImpactScope;
import org.sidiff.validation.constraint.impact.PotentialImpactScope;

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

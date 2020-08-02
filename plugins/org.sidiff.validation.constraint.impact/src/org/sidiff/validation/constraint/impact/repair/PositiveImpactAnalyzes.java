package org.sidiff.validation.constraint.impact.repair;

import java.util.List;

import org.sidiff.validation.constraint.api.util.Validation;
import org.sidiff.validation.constraint.impact.ImpactAnalyzes;
import org.sidiff.validation.constraint.impact.ImpactScope;
import org.sidiff.validation.constraint.impact.PotentialImpactScope;

public class PositiveImpactAnalyzes implements ImpactAnalyzes {

	private PotentialImpactScope positivePotentialImpactScope;
	
	private PositivePotentialImpactAnalysis positivePotentialImpactAnalysis;
	
	private RepairActionImpactScope repairActionImpactScope;

	private PositiveImpactAnalysis positiveImpactAnalysis;
	
	public PositiveImpactAnalyzes(RepairActionImpactScope repairActionImpactScope) {
		this.positivePotentialImpactScope = new PositivePotentialImpactScope(repairActionImpactScope);
		this.positivePotentialImpactAnalysis = new PositivePotentialImpactAnalysis(repairActionImpactScope);
		this.repairActionImpactScope = repairActionImpactScope;
		this.positiveImpactAnalysis = new PositiveImpactAnalysis(repairActionImpactScope);
	}
	
	@Override
	public PotentialImpactScope getPotentialImpactScope() {
		return positivePotentialImpactScope;
	}

	@Override
	public PositivePotentialImpactAnalysis getPotentialImpactAnalysis() {
		return positivePotentialImpactAnalysis;
	}
	
	@Override
	public ImpactScope getImpactScope() {
		return repairActionImpactScope;
	}

	@Override
	public PositiveImpactAnalysis getImpactAnalysis() {
		return positiveImpactAnalysis;
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

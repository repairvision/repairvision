package org.sidiff.validation.constraint.impact.repair;

import java.util.List;

import org.sidiff.validation.constraint.api.util.Validation;
import org.sidiff.validation.constraint.impact.ImpactAnalyzes;

public class RepairImpactAnalyzes implements ImpactAnalyzes {
	
	private RepairActionIndex repairActionIndex;

	private NegativePotentialImpactAnalysis negativePotentialImpactAnalysis;
	
	private NegativeImpactAnalysis negativeImpactAnalysis;
	
	private PositivePotentialImpactAnalysis positivePotentialImpactAnalysis;
	
	private PositiveImpactAnalysis positiveImpactAnalysis;
	
	public RepairImpactAnalyzes(RepairActionIndex repairActionIndex) {
		this.repairActionIndex = repairActionIndex;
		this.negativePotentialImpactAnalysis = new NegativePotentialImpactAnalysis(repairActionIndex);
		this.negativeImpactAnalysis = new NegativeImpactAnalysis(repairActionIndex);
		this.positiveImpactAnalysis = new PositiveImpactAnalysis(repairActionIndex);
		this.positivePotentialImpactAnalysis = new PositivePotentialImpactAnalysis(repairActionIndex);
	}
	
	@Override
	public NegativePotentialImpactAnalysis getHistoricalPotentialImpactAnalysis() {
		return negativePotentialImpactAnalysis;
	}
	
	@Override
	public NegativeImpactAnalysis getHistoricalImpactAnalysis() {
		return negativeImpactAnalysis;
	}
	
	@Override
	public PositiveImpactAnalysis getCurrentImpactAnalysis() {
		return positiveImpactAnalysis;
	}
	
	@Override
	public PositivePotentialImpactAnalysis getCurrentPotentialImpactAnalysis() {
		return positivePotentialImpactAnalysis;
	}

	public List<? extends Validation> getValidations() {
		return repairActionIndex.getValidations();
	}
	
	@Override
	public String toString() {
		StringBuilder toString = new StringBuilder(super.toString());
		toString.append(" -> ");
		toString.append(repairActionIndex.toString());
		return toString.toString();
	}
}

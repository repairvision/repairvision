package org.sidiff.validation.constraint.impact;

import java.util.List;

import org.sidiff.validation.constraint.api.util.Validation;
import org.sidiff.validation.constraint.impact.index.RepairActionIndex;

public class ImpactAnalyzes {
	
	private RepairActionIndex repairActionIndex;

	private NegativePotentialImpactAnalysis negativePotentialImpactAnalysis;
	
	private NegativeImpactAnalysis negativeImpactAnalysis;
	
	private PositivePotentialImpactAnalysis positivePotentialImpactAnalysis;
	
	private PositiveImpactAnalysis positiveImpactAnalysis;
	
	public ImpactAnalyzes(RepairActionIndex repairActionIndex) {
		this.repairActionIndex = repairActionIndex;
		this.negativePotentialImpactAnalysis = new NegativePotentialImpactAnalysis(repairActionIndex);
		this.negativeImpactAnalysis = new NegativeImpactAnalysis(repairActionIndex);
		this.positiveImpactAnalysis = new PositiveImpactAnalysis(repairActionIndex);
		this.positivePotentialImpactAnalysis = new PositivePotentialImpactAnalysis(repairActionIndex);
	}
	
	public NegativePotentialImpactAnalysis getNegativePotentialImpactAnalysis() {
		return negativePotentialImpactAnalysis;
	}
	
	public NegativeImpactAnalysis getNegativeImpactAnalysis() {
		return negativeImpactAnalysis;
	}
	
	public PositiveImpactAnalysis getPositiveImpactAnalysis() {
		return positiveImpactAnalysis;
	}
	
	public PositivePotentialImpactAnalysis getPositivePotentialImpactAnalysis() {
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

package org.sidiff.validation.constraint.impact;

public interface ImpactAnalyzes {

	PotentialImpactAnalysis getHistoricalPotentialImpactAnalysis();

	ImpactAnalysis getHistoricalImpactAnalysis();

	ImpactAnalysis getCurrentImpactAnalysis();

	PotentialImpactAnalysis getCurrentPotentialImpactAnalysis();

}
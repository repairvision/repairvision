package org.sidiff.repair.api.cpo;

import java.util.List;

import org.eclipse.emf.henshin.interpreter.EGraph;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.repair.api.IRepairPlan;
import org.sidiff.repair.api.RepairJob;

public class CPORepairJob extends RepairJob<IRepairPlan> {

	public CPORepairJob(List<IRepairPlan> repairs, SymmetricDifference difference, EGraph graphModelB) {
		super(repairs, difference, graphModelB);
	}

}

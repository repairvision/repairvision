package org.sidiff.repair.ui.provider.model;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.repair.api.IRepairPlan;

public class ContextContainer {
	public EObject conext;
	public List<IRepairPlan> repairs;
}

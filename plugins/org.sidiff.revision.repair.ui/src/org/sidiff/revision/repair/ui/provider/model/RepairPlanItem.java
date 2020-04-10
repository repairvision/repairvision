package org.sidiff.revision.repair.ui.provider.model;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.swt.graphics.Image;
import org.sidiff.common.utilities.ui.util.NameUtil;
import org.sidiff.revision.repair.api.IRepairPlan;
import org.sidiff.revision.repair.ui.Activator;
import org.sidiff.revision.repair.ui.provider.IHighlightableElement;

public class RepairPlanItem implements IItemProvider, IHighlightableElement {

	protected static final Image ICON_REPAIR_PLAN = Activator.getImageDescriptor("icons/repair_rule.png").createImage();
	
	protected RepairJobItem repairJob;
	
	protected IRepairPlan repairPlan;
	
	protected ParametersItem parameters;
	
	protected ChangeSetRecognized historic;
	
	protected ChangeSetComplementing complementing;
	
	protected IItemProvider[] children;
	
	public RepairPlanItem(RepairJobItem repairJob, IRepairPlan repairPlan) {
		this.repairJob = repairJob;
		this.repairPlan = repairPlan;
		this.parameters = new ParametersItem(this);
		this.historic = new ChangeSetRecognized(this);
		this.complementing = new ChangeSetComplementing(this);
	}
	
	@Override
	public String getText() {
		return "Repair "
				+ "[" + repairPlan.getRecognizedChanges().size() + "/" + 
				+ repairPlan.getComplementingChanges().size() + "] "
				+ NameUtil.beautifyName(repairPlan.getRecognizedEditRule().getName());
	}

	@Override
	public Image getImage() {
		return ICON_REPAIR_PLAN;
	}
	
	@Override
	public boolean hasChildren(Object element) {
		return true;
	}

	@Override
	public Object[] getChildren() {
		
		if (children == null) {
			this.children = new IItemProvider[] {parameters, historic, complementing};
		}
		
		return children;
	}
	
	@Override
	public Object getParent() {
		return repairJob;
	}
	
	public IRepairPlan getRepairPlan() {
		return repairPlan;
	}

	@Override
	public Iterator<? extends EObject> getModelElements() {
		return getRepairPlan().getComplementMatches().stream().map(Match::getNodeTargets).flatMap(List::stream).iterator();
	}
}

package org.sidiff.revision.repair.ui.provider.model;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.swt.graphics.Image;
import org.sidiff.common.utilities.ui.util.NameUtil;
import org.sidiff.revision.api.IComplementationPlan;
import org.sidiff.revision.repair.ui.Activator;
import org.sidiff.revision.repair.ui.provider.IHighlightableElement;

public class RepairPlanItem implements IItemProvider, IHighlightableElement {

	protected static final Image ICON_REPAIR_PLAN = Activator.getImageDescriptor("icons/repair_rule.png").createImage();
	
	protected RepairJobItem repairJob;
	
	protected IComplementationPlan complementationPlan;
	
	protected ParametersItem parameters;
	
	protected ChangeSetRecognized historic;
	
	protected ChangeSetComplementing complementing;
	
	protected IItemProvider[] children;
	
	public RepairPlanItem(RepairJobItem repairJob, IComplementationPlan complementationPlan) {
		this.repairJob = repairJob;
		this.complementationPlan = complementationPlan;
		this.parameters = new ParametersItem(this);
		this.historic = new ChangeSetRecognized(this);
		this.complementing = new ChangeSetComplementing(this);
	}
	
	@Override
	public String getText() {
		return "Repair "
				+ "[" + complementationPlan.getRecognizedChanges().size() + "/" + 
				+ complementationPlan.getComplementingChanges().size() + "] "
				+ NameUtil.beautifyName(complementationPlan.getRecognizedEditRule().getName());
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
	
	public IComplementationPlan getRepairPlan() {
		return complementationPlan;
	}

	@Override
	public Iterator<? extends EObject> getModelElements() {
		return getRepairPlan().getComplementMatches().stream().map(Match::getNodeTargets).flatMap(List::stream).iterator();
	}
}

package org.sidiff.revision.ui.viewer.provider.model;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.swt.graphics.Image;
import org.sidiff.revision.api.ComplementationPlan;
import org.sidiff.revision.common.utilities.string.NameUtil;
import org.sidiff.revision.ui.viewer.Activator;
import org.sidiff.revision.ui.viewer.provider.IHighlightableElement;

public class ComplementationPlanItem implements IItemProvider, IHighlightableElement {

	protected static final Image ICON_COMPLEMENTATION_PLAN = Activator.getImageDescriptor("icons/complementation_rule.png").createImage();
	
	protected ComplementationJobItem complementationJob;
	
	protected ComplementationPlan complementationPlan;
	
	protected ParametersItem parameters;
	
	protected ChangeSetRecognized historic;
	
	protected ChangeSetComplementing complementing;
	
	protected IItemProvider[] children;
	
	public ComplementationPlanItem(ComplementationJobItem complementationJob, ComplementationPlan complementationPlan) {
		this.complementationJob = complementationJob;
		this.complementationPlan = complementationPlan;
		this.parameters = new ParametersItem(this);
		this.historic = new ChangeSetRecognized(this);
		this.complementing = new ChangeSetComplementing(this);
	}
	
	@Override
	public String getText() {
		return "Complementation "
				+ "[" + complementationPlan.getRecognizedChanges().size() + "/" + 
				+ complementationPlan.getComplementingChanges().size() + "] "
				+ NameUtil.beautifyName(complementationPlan.getRecognizedEditRule().getName());
	}

	@Override
	public Image getImage() {
		return ICON_COMPLEMENTATION_PLAN;
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
		return complementationJob;
	}
	
	public ComplementationPlan getComplementationPlan() {
		return complementationPlan;
	}

	@Override
	public Iterator<? extends EObject> getModelElements() {
		return getComplementationPlan().getComplementMatches().stream().map(Match::getNodeTargets).flatMap(List::stream).iterator();
	}
}

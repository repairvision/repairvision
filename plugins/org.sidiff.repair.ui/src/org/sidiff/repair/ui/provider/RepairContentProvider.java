package org.sidiff.repair.ui.provider;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.sidiff.repair.api.IRepairPlan;
import org.sidiff.repair.api.RepairJob;
import org.sidiff.repair.api.matching.EOMatch;
import org.sidiff.repair.ui.provider.model.AttributeChange;
import org.sidiff.repair.ui.provider.model.Change;
import org.sidiff.repair.ui.provider.model.Container;
import org.sidiff.repair.ui.provider.model.ContextContainer;
import org.sidiff.repair.ui.provider.model.CreateComplementingChanges;
import org.sidiff.repair.ui.provider.model.CreateHistoricChanges;

public class RepairContentProvider implements IStructuredContentProvider, ITreeContentProvider  {

	protected RepairJob<? extends IRepairPlan> repairJob;
	
	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		
		if (newInput instanceof RepairJob<?>) {
			repairJob = (RepairJob<?>) newInput;
		}
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		
		if (parentElement instanceof Rule) {
			
			// Rule-Context -> Repairs:
			Map<EObject, List<IRepairPlan>> repairsByContext = new LinkedHashMap<>();
			
			for (IRepairPlan repair : repairJob.getRepairs().get(parentElement)) {
				Parameter context = repair.getRepairPreMatch().getMatch().getRule().getParameter("context");
				Object value = repair.getRepairPreMatch().getMatch().getParameterValue(context);
				
				if (value instanceof EObject) {
					// Add repair to the context value:
					List<IRepairPlan> repairs  = repairsByContext.getOrDefault(value, new LinkedList<IRepairPlan>());
					repairs.add(repair);
					repairsByContext.put((EObject) value, repairs);
				} else {
					// Uncategorized repair without context:
					List<IRepairPlan> repairs  = repairsByContext.getOrDefault(null, new LinkedList<IRepairPlan>());
					repairs.add(repair);
					repairsByContext.put(null, repairs);
				}
			}
			
			// Rule content:
			List<IRepairPlan> repairsWithoutContext = repairsByContext.getOrDefault(null, Collections.emptyList());
			repairsByContext.remove(null);
			
			Object[] ruleContent = new Object[repairsByContext.size() + repairsWithoutContext.size()]; 
			
			for (int i = 0; i < repairsWithoutContext.size(); i++) {
				IRepairPlan repair = repairsWithoutContext.get(i);
				ruleContent[i + repairsByContext.size()] = repair;
			}
			
			// Create context containers:
			int i = 0;
			
			for (Entry<EObject, List<IRepairPlan>> contextEntry : repairsByContext.entrySet()) {
				ContextContainer contextContainer = new ContextContainer();
				contextContainer.conext = contextEntry.getKey();
				contextContainer.repairs = contextEntry.getValue();
				
				ruleContent[i] = contextContainer;
				++i;
			}
			
			return ruleContent;
		}
		
		else if (parentElement instanceof ContextContainer) {
			return ((ContextContainer) parentElement).repairs.toArray();
		}
		
		else if (parentElement instanceof IRepairPlan) {
			IRepairPlan repair = (IRepairPlan) parentElement;
			
			// Historic changes:
			int historicSize = repair.getHistoricChanges().size();
			
			Container historicChanges = new Container();
			historicChanges.label = "Historic [" + historicSize + "]";
			historicChanges.icon = RepairLabelProvider.IMG_CHECK_MARK;
			
			historicChanges.parent = parentElement;
			historicChanges.content = new Object[historicSize];
			
			for (int i = 0; i < historicSize; i++) {
				GraphElement historicGraphElement = repair.getHistoricChanges().get(i);
				EOMatch sourceMatch = repair.getSourceMatch(historicGraphElement);
				historicChanges.content[i] = CreateHistoricChanges.create(historicGraphElement, sourceMatch);
			}
			
			// Complementing changes:
			int complementingSize = repair.getComplementingChanges().size();
			
			Container complementingChanges = new Container();
			complementingChanges.label = "Complementing [" + complementingSize + "]";
			complementingChanges.icon = RepairLabelProvider.IMG_QUESTION_MARK;
			
			complementingChanges.parent = parentElement;
			complementingChanges.content = new Object[complementingSize];
			
			for (int i = 0; i < complementingSize; i++) {
				complementingChanges.content[i] = CreateComplementingChanges.create(
						repair.getComplementingChanges().get(i),
						repair.getRepairPreMatch());
			}
			
			return new Object[] {historicChanges, complementingChanges};
		}
		
		// e.g. Complementing/Historic container:
		else if (parentElement instanceof Container) {
			// Return e.g. changes as children:
			return ((Container) parentElement).content;
		}
		
		else if (parentElement instanceof Change) {
			Change change = ((Change) parentElement);
			
			if (change instanceof AttributeChange) {
				AttributeChange avc = (AttributeChange) change;
				
				if (avc.value != null) {
					return new Object[] {avc.matches[0], avc.value};
				} else {
					if (avc.matches[0] != null) {
						return new Object[] {avc.matches[0], avc.graphElement};
					} else {
						return new Object[] {avc.graphElement};
					}
				}
			} else {
				return change.matches;
			}
		}
		
		return new Object[0];
	}
	
	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		
		// Repair-Rule:
		if (element instanceof Rule ||
				element instanceof IRepairPlan ||
				element instanceof Container ||
				element instanceof ContextContainer ||
				element instanceof AttributeChange) {
			return true;
		}
		
		// Single change:
		if (element instanceof Change) {
			if (((Change) element).matches != null) {
				return (((Change) element).matches.length > 0);
			}
		}
		
		return false;
	}

	@Override
	public Object[] getElements(Object inputElement) {
		
		// Repair-Rules:
		if (inputElement instanceof RepairJob<?>) {
			return ((RepairJob<?>) inputElement).getRepairs().keySet().toArray();
		}
		
		return getChildren(inputElement);
	}
}

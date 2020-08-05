package org.sidiff.revision.ui.viewer.provider.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil;
import org.sidiff.revision.ui.viewer.Activator;
import org.sidiff.revision.ui.viewer.provider.IHighlightableElement;

public class ParameterValueInputItem implements IItemProvider, IParameterInput, IHighlightableElement {

	protected static Image IMG_VALUE_INPUT = Activator.getImageDescriptor("icons/question_mark.png").createImage();
	
	protected ParameterItem parameter;

	public ParameterValueInputItem(ParameterItem parameter) {
		this.parameter = parameter;
	}

	@Override
	public String getText() {
		if (parameter.getComplementationPlan().isSetParameter(parameter.getParameter())) {
			return parameter.getComplementationPlan().getParameterValue(parameter.getParameter()).toString();
		} else {
			return "Set Input Value";
		}
	}

	@Override
	public Image getImage() {
		return IMG_VALUE_INPUT;
	}

	@Override
	public boolean hasChildren(Object element) {
		return false;
	}

	@Override
	public Object[] getChildren() {
		return new Object[0];
	}

	@Override
	public Object getParent() {
		return parameter;
	}

	@Override
	public void setParameterValue() {
		InputDialog setValueDialog = new InputDialog(Display.getDefault().getActiveShell(), 
				"New Input Value", "Enter a value:", "", null);
		
		setValueDialog.open();
		
		if (setValueDialog.getValue() != null) {
			parameter.getComplementationPlan().setParameterValue(parameter.getParameter(), setValueDialog.getValue());
		}
	}

	@Override
	public Iterator<? extends EObject> getModelElements() {
		Parameter parameter = this.parameter.getParameter();
		Rule rule = ((Rule) parameter.getUnit());
		
		// search parameter targets:
		List<Node> attributeTargets = new ArrayList<>();
		
		for (Node node : rule.getRhs().getNodes()) {
			for (Attribute attribute : node.getAttributes()) {
				if (attribute.getValue().equals(parameter.getName())) {
					attributeTargets.add(node);
				}
			}
		}
		
		Set<EObject> elements = new HashSet<>();
		
		for (Node attributeTarget : attributeTargets) {
			List<EObject> domain = this.parameter.getComplementationPlan().getComplementDomain(attributeTarget);
			
			// check container for new created nodes which have no match:
			while (domain.isEmpty() && (attributeTarget != null)) {
				Node lastAttributeTaget = attributeTarget;
				attributeTarget = null;
				
				for (Edge incoming : lastAttributeTaget.getIncoming()) {
					if (incoming.getType().isContainment()) {
						attributeTarget = incoming.getSource();
						break;
					}
				}
				
				if (attributeTarget != null) {
					domain = this.parameter.getComplementationPlan().getComplementDomain(HenshinRuleAnalysisUtil.tryLHS(attributeTarget));
				}
			}
			
			elements.addAll(domain);
		}
		
		return elements.iterator();
	}
}

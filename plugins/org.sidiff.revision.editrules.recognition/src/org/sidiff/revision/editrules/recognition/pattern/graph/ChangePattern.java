package org.sidiff.revision.editrules.recognition.pattern.graph;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.revision.difference.AddObject;
import org.sidiff.revision.difference.AddReference;
import org.sidiff.revision.difference.AttributeValueChange;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.RemoveObject;
import org.sidiff.revision.difference.RemoveReference;
import org.sidiff.revision.editrules.recognition.pattern.domain.Domain;

public abstract class ChangePattern implements IVariable {

	/**
	 * The parent action graph.
	 */
	protected ActionGraph actionGraph;
	
	/**
	 * The type of the change ({@link AddObject}, {@link RemoveObject},
	 * {@link AddReference}, {@link RemoveReference},
	 * {@link AttributeValueChange})
	 */
	protected EClass changeType;

	/**
	 * The (meta) type of the changed objects ({@link EClass},
	 * {@link EReference}, {@link EAttribute}).
	 */
	protected EObject metaModelType;

	/**
	 * Pattern which represents the changes.
	 */
	protected NodePattern changeNodePattern;
	
	public boolean addChange(Change change) {
		
		if (change.eClass() == changeType) {
			Domain.get(changeNodePattern).add(change);
			return true;
		}
		
		return false;
	}
	
	public ActionGraph getActionGraph() {
		return actionGraph;
	}
	
	public EClass getChangeType() {
		return changeType;
	}

	public EObject getMetaModelType() {
		return metaModelType;
	}

	public NodePattern getChangeNodePattern() {
		return changeNodePattern;
	}
	
	@Override
	public Iterator<? extends EObject> getDomain() {
		return Domain.get(changeNodePattern).iterator();
	}
}

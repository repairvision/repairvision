/**
 */
package org.sidiff.graphpattern.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.graphpattern.Association;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphElement;
import org.sidiff.graphpattern.GraphpatternPackage;
import org.sidiff.graphpattern.Matching;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Stereotype;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.impl.NodePatternImpl#getOutgoings <em>Outgoings</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.impl.NodePatternImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.impl.NodePatternImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.impl.NodePatternImpl#getMatching <em>Matching</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.impl.NodePatternImpl#getIncomings <em>Incomings</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.impl.NodePatternImpl#getAssociations <em>Associations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NodePatternImpl extends GraphElementImpl implements NodePattern {
	
	/**
	 * All incident edges per adjacent node.
	 * 
	 * @generated NOT
	 */
	protected Map<NodePattern, EList<EdgePattern>> incidents;
	
	/**
	 * All adjacent nodes.
	 * 
	 * @generated NOT
	 */
	protected EList<NodePattern> adjacent; 
	
	/**
	 * The cached value of the '{@link #getOutgoings() <em>Outgoings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoings()
	 * @generated
	 * @ordered
	 */
	protected EList<EdgePattern> outgoings;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EClass type;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributePattern> attributes;

	/**
	 * The cached value of the '{@link #getMatching() <em>Matching</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatching()
	 * @generated
	 * @ordered
	 */
	protected Matching matching;

	/**
	 * The cached value of the '{@link #getIncomings() <em>Incomings</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomings()
	 * @generated
	 * @ordered
	 */
	protected EList<EdgePattern> incomings;

	/**
	 * The cached value of the '{@link #getAssociations() <em>Associations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociations()
	 * @generated
	 * @ordered
	 */
	protected EList<Association> associations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodePatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphpatternPackage.Literals.NODE_PATTERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EdgePattern> getOutgoings() {
		if (outgoings == null) {
			outgoings = new EObjectContainmentWithInverseEList<EdgePattern>(EdgePattern.class, this, GraphpatternPackage.NODE_PATTERN__OUTGOINGS, GraphpatternPackage.EDGE_PATTERN__SOURCE);
		}
		return outgoings;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EdgePattern getOutgoing(EReference type) {
		for (EdgePattern edge : getOutgoings()) {
			if (type == edge.getType()) {
				return edge;
			}
		}
		return null;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EdgePattern getOutgoing(EReference type, NodePattern target, Stereotype stereotype) {
		for (EdgePattern edge : getOutgoings()) {
			if ((type == edge.getType()) && (edge.getTarget() == target)) {
				if (edge.getStereotypes().contains(stereotype)) {
					return edge;
				}
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EdgePattern getOutgoing(EReference type, NodePattern target) {
		for (EdgePattern edge : getOutgoings()) {
			if ((type == edge.getType()) && (edge.getTarget() == target)) {
				return edge;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<EdgePattern> getOutgoings(EReference type) {
		EList<EdgePattern> edges = new BasicEList<>();

		for (EdgePattern edge : getOutgoings()) {
			if (type == edge.getType()) {
				edges.add(edge);
			}
		}

		return edges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EdgePattern getIncoming(EReference type) {
		for (EdgePattern edge : getIncomings()) {
			if (type == edge.getType()) {
				return edge;
			}
		}
		return null;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<EdgePattern> getIncomings(EReference type) {
		EList<EdgePattern> edges = new BasicEList<>();

		for (EdgePattern edge : getIncomings()) {
			if (type == edge.getType()) {
				edges.add(edge);
			}
		}

		return edges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<EdgePattern> getIncident() {
		EList<EdgePattern> edges = new BasicEList<>(getOutgoings().size() + getIncomings().size());
		edges.addAll(getOutgoings());
		edges.addAll(getIncomings());
		return edges;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<EdgePattern> getIncident(NodePattern adjacent) {
		
		if (incidents == null) {
			incidents = new LinkedHashMap<>();
			
			for (EdgePattern outgoing : getOutgoings()) {
				NodePattern target = outgoing.getTarget();
				
				EList<EdgePattern> incident = incidents.getOrDefault(target, new BasicEList<>());
				incident.add(outgoing);
				
				if (!incidents.containsKey(target)) {
					incidents.put(target, incident);
				}
			}
			
			for (EdgePattern incoming : getIncomings()) {
				NodePattern source = incoming.getSource();
				
				EList<EdgePattern> incident = incidents.getOrDefault(source, new BasicEList<>());
				incident.add(incoming);
				
				if (!incidents.containsKey(source)) {
					incidents.put(source, incident);
				}
			}
		}
		
		return incidents.get(adjacent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<EdgePattern> removeIncident() {
		EList<EdgePattern> edges = getIncident();
		edges.forEach(e -> {
			removeEdge(e);
		});
		return edges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<EdgePattern> removeIncident(NodePattern node) {
		EList<EdgePattern> edges = getIncident(node);
		edges.forEach(e -> {
			removeEdge(e);
		});
		return edges;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void removeEdge(EdgePattern edge) {
		if (edge.getSource() != null) {
			edge.getSource().getOutgoings().remove(edge);
		}
		if (edge.getTarget() != null) {
			edge.getTarget().getIncomings().remove(edge);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<NodePattern> getAdjacent() {
		
		if (adjacent == null) {
			
			// Make sure "incidents" is initialized...
			getIncident(null);
			
			// Convert adjacent nodes to EList:
			adjacent = new BasicEList<NodePattern>(incidents.size());
			
			incidents.entrySet().forEach(entry -> {
				adjacent.add(entry.getKey());
			});
		}
		
		return adjacent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (EClass)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphpatternPackage.NODE_PATTERN__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(EClass newType) {
		EClass oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphpatternPackage.NODE_PATTERN__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AttributePattern> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentWithInverseEList<AttributePattern>(AttributePattern.class, this, GraphpatternPackage.NODE_PATTERN__ATTRIBUTES, GraphpatternPackage.ATTRIBUTE_PATTERN__NODE);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Matching getMatching() {
		return matching;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMatching(Matching newMatching, NotificationChain msgs) {
		Matching oldMatching = matching;
		matching = newMatching;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphpatternPackage.NODE_PATTERN__MATCHING, oldMatching, newMatching);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMatching(Matching newMatching) {
		if (newMatching != matching) {
			NotificationChain msgs = null;
			if (matching != null)
				msgs = ((InternalEObject)matching).eInverseRemove(this, GraphpatternPackage.MATCHING__NODE, Matching.class, msgs);
			if (newMatching != null)
				msgs = ((InternalEObject)newMatching).eInverseAdd(this, GraphpatternPackage.MATCHING__NODE, Matching.class, msgs);
			msgs = basicSetMatching(newMatching, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphpatternPackage.NODE_PATTERN__MATCHING, newMatching, newMatching));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EdgePattern> getIncomings() {
		if (incomings == null) {
			incomings = new EObjectWithInverseResolvingEList<EdgePattern>(EdgePattern.class, this, GraphpatternPackage.NODE_PATTERN__INCOMINGS, GraphpatternPackage.EDGE_PATTERN__TARGET);
		}
		return incomings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Association> getAssociations() {
		if (associations == null) {
			associations = new EObjectContainmentWithInverseEList<Association>(Association.class, this, GraphpatternPackage.NODE_PATTERN__ASSOCIATIONS, GraphpatternPackage.ASSOCIATION__SOURCE);
		}
		return associations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AttributePattern getAttribute(EAttribute type) {
		
		for (AttributePattern attribute : getAttributes()) {
			if (type == attribute.getType()) {
				return attribute;
			}
		}

		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphpatternPackage.NODE_PATTERN__OUTGOINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoings()).basicAdd(otherEnd, msgs);
			case GraphpatternPackage.NODE_PATTERN__ATTRIBUTES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAttributes()).basicAdd(otherEnd, msgs);
			case GraphpatternPackage.NODE_PATTERN__MATCHING:
				if (matching != null)
					msgs = ((InternalEObject)matching).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphpatternPackage.NODE_PATTERN__MATCHING, null, msgs);
				return basicSetMatching((Matching)otherEnd, msgs);
			case GraphpatternPackage.NODE_PATTERN__INCOMINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomings()).basicAdd(otherEnd, msgs);
			case GraphpatternPackage.NODE_PATTERN__ASSOCIATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssociations()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphpatternPackage.NODE_PATTERN__OUTGOINGS:
				return ((InternalEList<?>)getOutgoings()).basicRemove(otherEnd, msgs);
			case GraphpatternPackage.NODE_PATTERN__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case GraphpatternPackage.NODE_PATTERN__MATCHING:
				return basicSetMatching(null, msgs);
			case GraphpatternPackage.NODE_PATTERN__INCOMINGS:
				return ((InternalEList<?>)getIncomings()).basicRemove(otherEnd, msgs);
			case GraphpatternPackage.NODE_PATTERN__ASSOCIATIONS:
				return ((InternalEList<?>)getAssociations()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphpatternPackage.NODE_PATTERN__OUTGOINGS:
				return getOutgoings();
			case GraphpatternPackage.NODE_PATTERN__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case GraphpatternPackage.NODE_PATTERN__ATTRIBUTES:
				return getAttributes();
			case GraphpatternPackage.NODE_PATTERN__MATCHING:
				return getMatching();
			case GraphpatternPackage.NODE_PATTERN__INCOMINGS:
				return getIncomings();
			case GraphpatternPackage.NODE_PATTERN__ASSOCIATIONS:
				return getAssociations();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GraphpatternPackage.NODE_PATTERN__OUTGOINGS:
				getOutgoings().clear();
				getOutgoings().addAll((Collection<? extends EdgePattern>)newValue);
				return;
			case GraphpatternPackage.NODE_PATTERN__TYPE:
				setType((EClass)newValue);
				return;
			case GraphpatternPackage.NODE_PATTERN__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends AttributePattern>)newValue);
				return;
			case GraphpatternPackage.NODE_PATTERN__MATCHING:
				setMatching((Matching)newValue);
				return;
			case GraphpatternPackage.NODE_PATTERN__INCOMINGS:
				getIncomings().clear();
				getIncomings().addAll((Collection<? extends EdgePattern>)newValue);
				return;
			case GraphpatternPackage.NODE_PATTERN__ASSOCIATIONS:
				getAssociations().clear();
				getAssociations().addAll((Collection<? extends Association>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GraphpatternPackage.NODE_PATTERN__OUTGOINGS:
				getOutgoings().clear();
				return;
			case GraphpatternPackage.NODE_PATTERN__TYPE:
				setType((EClass)null);
				return;
			case GraphpatternPackage.NODE_PATTERN__ATTRIBUTES:
				getAttributes().clear();
				return;
			case GraphpatternPackage.NODE_PATTERN__MATCHING:
				setMatching((Matching)null);
				return;
			case GraphpatternPackage.NODE_PATTERN__INCOMINGS:
				getIncomings().clear();
				return;
			case GraphpatternPackage.NODE_PATTERN__ASSOCIATIONS:
				getAssociations().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GraphpatternPackage.NODE_PATTERN__OUTGOINGS:
				return outgoings != null && !outgoings.isEmpty();
			case GraphpatternPackage.NODE_PATTERN__TYPE:
				return type != null;
			case GraphpatternPackage.NODE_PATTERN__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case GraphpatternPackage.NODE_PATTERN__MATCHING:
				return matching != null;
			case GraphpatternPackage.NODE_PATTERN__INCOMINGS:
				return incomings != null && !incomings.isEmpty();
			case GraphpatternPackage.NODE_PATTERN__ASSOCIATIONS:
				return associations != null && !associations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case GraphpatternPackage.NODE_PATTERN___GET_ATTRIBUTE__EATTRIBUTE:
				return getAttribute((EAttribute)arguments.get(0));
			case GraphpatternPackage.NODE_PATTERN___GET_OUTGOINGS__EREFERENCE:
				return getOutgoings((EReference)arguments.get(0));
			case GraphpatternPackage.NODE_PATTERN___GET_OUTGOING__EREFERENCE:
				return getOutgoing((EReference)arguments.get(0));
			case GraphpatternPackage.NODE_PATTERN___GET_OUTGOING__EREFERENCE_NODEPATTERN:
				return getOutgoing((EReference)arguments.get(0), (NodePattern)arguments.get(1));
			case GraphpatternPackage.NODE_PATTERN___GET_OUTGOING__EREFERENCE_NODEPATTERN_STEREOTYPE:
				return getOutgoing((EReference)arguments.get(0), (NodePattern)arguments.get(1), (Stereotype)arguments.get(2));
			case GraphpatternPackage.NODE_PATTERN___GET_INCOMING__EREFERENCE:
				return getIncoming((EReference)arguments.get(0));
			case GraphpatternPackage.NODE_PATTERN___GET_INCOMINGS__EREFERENCE:
				return getIncomings((EReference)arguments.get(0));
			case GraphpatternPackage.NODE_PATTERN___GET_INCIDENT:
				return getIncident();
			case GraphpatternPackage.NODE_PATTERN___GET_INCIDENT__NODEPATTERN:
				return getIncident((NodePattern)arguments.get(0));
			case GraphpatternPackage.NODE_PATTERN___REMOVE_INCIDENT:
				return removeIncident();
			case GraphpatternPackage.NODE_PATTERN___REMOVE_INCIDENT__NODEPATTERN:
				return removeIncident((NodePattern)arguments.get(0));
			case GraphpatternPackage.NODE_PATTERN___GET_ADJACENT:
				return getAdjacent();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		
		String type = getType() != null ? getType().getName() : "?";
		
		result.append(" (type: ");
		result.append(type);
		result.append(')');
		
		return result.toString();
	}

	@Override
	public Iterable<GraphElement> getConnected() {
		List<GraphElement> connected = new ArrayList<>(
				getOutgoings().size() + getIncomings().size() + getAttributes().size());

		connected.addAll(getIncomings());
		connected.addAll(getOutgoings());
		connected.addAll(getAttributes());

		return connected;
	}

} //NodePatternImpl

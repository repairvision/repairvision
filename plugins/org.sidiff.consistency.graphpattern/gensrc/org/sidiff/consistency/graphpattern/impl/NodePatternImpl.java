/**
 */
package org.sidiff.consistency.graphpattern.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.consistency.graphpattern.AttributePattern;
import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.Evaluation;
import org.sidiff.consistency.graphpattern.GraphPattern;
import org.sidiff.consistency.graphpattern.GraphpatternPackage;
import org.sidiff.consistency.graphpattern.NodePattern;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.consistency.graphpattern.impl.NodePatternImpl#getOutgoings <em>Outgoings</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.impl.NodePatternImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.impl.NodePatternImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.impl.NodePatternImpl#getEvaluation <em>Evaluation</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.impl.NodePatternImpl#getGraph <em>Graph</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.impl.NodePatternImpl#getIncomings <em>Incomings</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NodePatternImpl extends GraphPredicateImpl implements NodePattern {
	
	// TODO -> Model
	public EdgePattern getOutgoing(EReference type) {
		for (EdgePattern edge : getOutgoings()) {
			if (type == edge.getType()) {
				return edge;
			}
		}
		return null;
	}
	
	// TODO -> Model
	public EdgePattern getIncoming(EReference type) {
		for (EdgePattern edge : getIncomings()) {
			if (type == edge.getType()) {
				return edge;
			}
		}
		return null;
	}
	
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
	 * The cached value of the '{@link #getEvaluation() <em>Evaluation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvaluation()
	 * @generated
	 * @ordered
	 */
	protected Evaluation evaluation;

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
	public EList<EdgePattern> getOutgoings() {
		if (outgoings == null) {
			outgoings = new EObjectContainmentWithInverseEList<EdgePattern>(EdgePattern.class, this, GraphpatternPackage.NODE_PATTERN__OUTGOINGS, GraphpatternPackage.EDGE_PATTERN__SOURCE);
		}
		return outgoings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	public Evaluation getEvaluation() {
		return evaluation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEvaluation(Evaluation newEvaluation, NotificationChain msgs) {
		Evaluation oldEvaluation = evaluation;
		evaluation = newEvaluation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphpatternPackage.NODE_PATTERN__EVALUATION, oldEvaluation, newEvaluation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEvaluation(Evaluation newEvaluation) {
		if (newEvaluation != evaluation) {
			NotificationChain msgs = null;
			if (evaluation != null)
				msgs = ((InternalEObject)evaluation).eInverseRemove(this, GraphpatternPackage.EVALUATION__NODE, Evaluation.class, msgs);
			if (newEvaluation != null)
				msgs = ((InternalEObject)newEvaluation).eInverseAdd(this, GraphpatternPackage.EVALUATION__NODE, Evaluation.class, msgs);
			msgs = basicSetEvaluation(newEvaluation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphpatternPackage.NODE_PATTERN__EVALUATION, newEvaluation, newEvaluation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphPattern getGraph() {
		if (eContainerFeatureID() != GraphpatternPackage.NODE_PATTERN__GRAPH) return null;
		return (GraphPattern)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGraph(GraphPattern newGraph, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newGraph, GraphpatternPackage.NODE_PATTERN__GRAPH, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraph(GraphPattern newGraph) {
		if (newGraph != eInternalContainer() || (eContainerFeatureID() != GraphpatternPackage.NODE_PATTERN__GRAPH && newGraph != null)) {
			if (EcoreUtil.isAncestor(this, newGraph))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newGraph != null)
				msgs = ((InternalEObject)newGraph).eInverseAdd(this, GraphpatternPackage.GRAPH_PATTERN__NODES, GraphPattern.class, msgs);
			msgs = basicSetGraph(newGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphpatternPackage.NODE_PATTERN__GRAPH, newGraph, newGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EdgePattern> getIncomings() {
		if (incomings == null) {
			incomings = new EObjectWithInverseResolvingEList<EdgePattern>(EdgePattern.class, this, GraphpatternPackage.NODE_PATTERN__INCOMINGS, GraphpatternPackage.EDGE_PATTERN__TARGET);
		}
		return incomings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<EdgePattern> getEdges(EReference type) {
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
			case GraphpatternPackage.NODE_PATTERN__EVALUATION:
				if (evaluation != null)
					msgs = ((InternalEObject)evaluation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphpatternPackage.NODE_PATTERN__EVALUATION, null, msgs);
				return basicSetEvaluation((Evaluation)otherEnd, msgs);
			case GraphpatternPackage.NODE_PATTERN__GRAPH:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetGraph((GraphPattern)otherEnd, msgs);
			case GraphpatternPackage.NODE_PATTERN__INCOMINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomings()).basicAdd(otherEnd, msgs);
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
			case GraphpatternPackage.NODE_PATTERN__EVALUATION:
				return basicSetEvaluation(null, msgs);
			case GraphpatternPackage.NODE_PATTERN__GRAPH:
				return basicSetGraph(null, msgs);
			case GraphpatternPackage.NODE_PATTERN__INCOMINGS:
				return ((InternalEList<?>)getIncomings()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case GraphpatternPackage.NODE_PATTERN__GRAPH:
				return eInternalContainer().eInverseRemove(this, GraphpatternPackage.GRAPH_PATTERN__NODES, GraphPattern.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
			case GraphpatternPackage.NODE_PATTERN__EVALUATION:
				return getEvaluation();
			case GraphpatternPackage.NODE_PATTERN__GRAPH:
				return getGraph();
			case GraphpatternPackage.NODE_PATTERN__INCOMINGS:
				return getIncomings();
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
			case GraphpatternPackage.NODE_PATTERN__EVALUATION:
				setEvaluation((Evaluation)newValue);
				return;
			case GraphpatternPackage.NODE_PATTERN__GRAPH:
				setGraph((GraphPattern)newValue);
				return;
			case GraphpatternPackage.NODE_PATTERN__INCOMINGS:
				getIncomings().clear();
				getIncomings().addAll((Collection<? extends EdgePattern>)newValue);
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
			case GraphpatternPackage.NODE_PATTERN__EVALUATION:
				setEvaluation((Evaluation)null);
				return;
			case GraphpatternPackage.NODE_PATTERN__GRAPH:
				setGraph((GraphPattern)null);
				return;
			case GraphpatternPackage.NODE_PATTERN__INCOMINGS:
				getIncomings().clear();
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
			case GraphpatternPackage.NODE_PATTERN__EVALUATION:
				return evaluation != null;
			case GraphpatternPackage.NODE_PATTERN__GRAPH:
				return getGraph() != null;
			case GraphpatternPackage.NODE_PATTERN__INCOMINGS:
				return incomings != null && !incomings.isEmpty();
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
			case GraphpatternPackage.NODE_PATTERN___GET_EDGES__EREFERENCE:
				return getEdges((EReference)arguments.get(0));
			case GraphpatternPackage.NODE_PATTERN___GET_ATTRIBUTE__EATTRIBUTE:
				return getAttribute((EAttribute)arguments.get(0));
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

} //NodePatternImpl

/**
 */
package org.sidiff.graphpattern.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.graphpattern.Assignment;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternPackage;
import org.sidiff.graphpattern.Parameter;
import org.sidiff.graphpattern.Pattern;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.impl.PatternImpl#getGraphs <em>Graphs</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.impl.PatternImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.impl.PatternImpl#getAssignments <em>Assignments</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.impl.PatternImpl#getBundle <em>Bundle</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.impl.PatternImpl#getPatterns <em>Patterns</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PatternImpl extends PatternElementImpl implements Pattern {
	/**
	 * The cached value of the '{@link #getGraphs() <em>Graphs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraphs()
	 * @generated
	 * @ordered
	 */
	protected EList<GraphPattern> graphs;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameters;

	/**
	 * The cached value of the '{@link #getAssignments() <em>Assignments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignments()
	 * @generated
	 * @ordered
	 */
	protected EList<Assignment> assignments;

	/**
	 * The cached value of the '{@link #getPatterns() <em>Patterns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPatterns()
	 * @generated
	 * @ordered
	 */
	protected EList<Pattern> patterns;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphpatternPackage.Literals.PATTERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GraphPattern> getGraphs() {
		if (graphs == null) {
			graphs = new EObjectContainmentWithInverseEList<GraphPattern>(GraphPattern.class, this, GraphpatternPackage.PATTERN__GRAPHS, GraphpatternPackage.GRAPH_PATTERN__PATTERN);
		}
		return graphs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Parameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentWithInverseEList<Parameter>(Parameter.class, this, GraphpatternPackage.PATTERN__PARAMETERS, GraphpatternPackage.PARAMETER__PATTERN);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Assignment> getAssignments() {
		if (assignments == null) {
			assignments = new EObjectContainmentWithInverseEList<Assignment>(Assignment.class, this, GraphpatternPackage.PATTERN__ASSIGNMENTS, GraphpatternPackage.ASSIGNMENT__PATTERN);
		}
		return assignments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Bundle getBundle() {
		Bundle bundle = basicGetBundle();
		return bundle != null && bundle.eIsProxy() ? (Bundle)eResolveProxy((InternalEObject)bundle) : bundle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Bundle basicGetBundle() {
		EObject pattern = this; // bundle is a pattern
		
		while ((pattern != null) && !(pattern instanceof Bundle)) {
			pattern = pattern.eContainer();
		}
		
		if (pattern instanceof Bundle) {
			return (Bundle) pattern;
		}
		
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Pattern> getPatterns() {
		if (patterns == null) {
			patterns = new EObjectContainmentEList<Pattern>(Pattern.class, this, GraphpatternPackage.PATTERN__PATTERNS);
		}
		return patterns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Pattern getPattern(String name) {
		for (Pattern pattern : getPatterns()) {
			if (pattern.getName().equals(name)) {
				return pattern;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<GraphPattern> getAllGraphPatterns() {
		EList<GraphPattern> graphPatterns = new BasicEList<>();
		collectAllGraphPatterns(graphPatterns);
		return graphPatterns;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public GraphPattern getGraph(String name) {
		for (GraphPattern graph : getGraphs()) {
			if (graph.getName().equals(name)) {
				return graph;
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
	public Parameter getParameter(String name) {
		for (Parameter parameter : getParameters()) {
			if (parameter.getName().equals(name)) {
				return parameter;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void collectAllGraphPatterns(EList<GraphPattern> graphPatterns) {
		graphPatterns.addAll(getGraphs());
		
		for (Pattern subPattern : getPatterns()) {
			((PatternImpl) subPattern).collectAllGraphPatterns(graphPatterns);
		}
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
			case GraphpatternPackage.PATTERN__GRAPHS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGraphs()).basicAdd(otherEnd, msgs);
			case GraphpatternPackage.PATTERN__PARAMETERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getParameters()).basicAdd(otherEnd, msgs);
			case GraphpatternPackage.PATTERN__ASSIGNMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssignments()).basicAdd(otherEnd, msgs);
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
			case GraphpatternPackage.PATTERN__GRAPHS:
				return ((InternalEList<?>)getGraphs()).basicRemove(otherEnd, msgs);
			case GraphpatternPackage.PATTERN__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case GraphpatternPackage.PATTERN__ASSIGNMENTS:
				return ((InternalEList<?>)getAssignments()).basicRemove(otherEnd, msgs);
			case GraphpatternPackage.PATTERN__PATTERNS:
				return ((InternalEList<?>)getPatterns()).basicRemove(otherEnd, msgs);
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
			case GraphpatternPackage.PATTERN__GRAPHS:
				return getGraphs();
			case GraphpatternPackage.PATTERN__PARAMETERS:
				return getParameters();
			case GraphpatternPackage.PATTERN__ASSIGNMENTS:
				return getAssignments();
			case GraphpatternPackage.PATTERN__BUNDLE:
				if (resolve) return getBundle();
				return basicGetBundle();
			case GraphpatternPackage.PATTERN__PATTERNS:
				return getPatterns();
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
			case GraphpatternPackage.PATTERN__GRAPHS:
				getGraphs().clear();
				getGraphs().addAll((Collection<? extends GraphPattern>)newValue);
				return;
			case GraphpatternPackage.PATTERN__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case GraphpatternPackage.PATTERN__ASSIGNMENTS:
				getAssignments().clear();
				getAssignments().addAll((Collection<? extends Assignment>)newValue);
				return;
			case GraphpatternPackage.PATTERN__PATTERNS:
				getPatterns().clear();
				getPatterns().addAll((Collection<? extends Pattern>)newValue);
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
			case GraphpatternPackage.PATTERN__GRAPHS:
				getGraphs().clear();
				return;
			case GraphpatternPackage.PATTERN__PARAMETERS:
				getParameters().clear();
				return;
			case GraphpatternPackage.PATTERN__ASSIGNMENTS:
				getAssignments().clear();
				return;
			case GraphpatternPackage.PATTERN__PATTERNS:
				getPatterns().clear();
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
			case GraphpatternPackage.PATTERN__GRAPHS:
				return graphs != null && !graphs.isEmpty();
			case GraphpatternPackage.PATTERN__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case GraphpatternPackage.PATTERN__ASSIGNMENTS:
				return assignments != null && !assignments.isEmpty();
			case GraphpatternPackage.PATTERN__BUNDLE:
				return basicGetBundle() != null;
			case GraphpatternPackage.PATTERN__PATTERNS:
				return patterns != null && !patterns.isEmpty();
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
			case GraphpatternPackage.PATTERN___GET_PATTERN__STRING:
				return getPattern((String)arguments.get(0));
			case GraphpatternPackage.PATTERN___GET_PARAMETER__STRING:
				return getParameter((String)arguments.get(0));
			case GraphpatternPackage.PATTERN___GET_GRAPH__STRING:
				return getGraph((String)arguments.get(0));
			case GraphpatternPackage.PATTERN___GET_ALL_GRAPH_PATTERNS:
				return getAllGraphPatterns();
		}
		return super.eInvoke(operationID, arguments);
	}

} //PatternImpl

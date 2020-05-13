/**
 */
package org.sidiff.historymodel.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.historymodel.History;
import org.sidiff.historymodel.HistoryModelPackage;
import org.sidiff.historymodel.Problem;
import org.sidiff.historymodel.Version;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>History</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.historymodel.impl.HistoryImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sidiff.historymodel.impl.HistoryImpl#getVersions <em>Versions</em>}</li>
 *   <li>{@link org.sidiff.historymodel.impl.HistoryImpl#getAllProblems <em>All Problems</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HistoryImpl extends MinimalEObjectImpl.Container implements History {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVersions() <em>Versions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersions()
	 * @generated
	 * @ordered
	 */
	protected EList<Version> versions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HistoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HistoryModelPackage.Literals.HISTORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HistoryModelPackage.HISTORY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Version> getVersions() {
		if (versions == null) {
			versions = new EObjectContainmentWithInverseEList<Version>(Version.class, this, HistoryModelPackage.HISTORY__VERSIONS, HistoryModelPackage.VERSION__HISTORY);
		}
		return versions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Problem> getAllProblems() {
		EList<Problem> Problems = new BasicEList<Problem>();
		for(Version version : this.getVersions()){
			Problems.addAll(version.getProblems());
		}
		return Problems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Version> getPredecessorVersions(Version version) {
		int index = versions.indexOf(version);
		EList<Version> precessors = new EObjectResolvingEList<Version>(Version.class, this, HistoryModelPackage.HISTORY___GET_SUCCESSOR_VERSIONS__VERSION);
		while(index > 0){
			precessors.add(versions.get(--index));
		}
		
		return precessors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Version> getSuccessorVersions(Version version) {
		int index = versions.indexOf(version);
		EList<Version> successors = new EObjectResolvingEList<Version>(Version.class, this, HistoryModelPackage.HISTORY___GET_SUCCESSOR_VERSIONS__VERSION);
		while(index < versions.size()-1){
			successors.add(versions.get(++index));
		}
		return successors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Problem> getProblems(boolean introduced, boolean resolved) {
		EList<Problem> Problems = new BasicEList<Problem>();
		for(Version version : getVersions()){
			for(Problem error : version.getProblems()){
				boolean toAdd = true;
				if(introduced){
					toAdd = error.isIntroduced();
				}
				if(toAdd && resolved){
					toAdd = error.isResolved();
				}
				
				if(toAdd){
					Problems.add(error);
				}
			}
		}
		return Problems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Problem> getUniqueProblems() {
		EList<Problem> uniqueProblems = new BasicEList<Problem>();
		for(Problem problem : getAllProblems()){
			if(problem.getPredecessor() == null){
				uniqueProblems.add(problem);
			}
		}
		return uniqueProblems;
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
			case HistoryModelPackage.HISTORY__VERSIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getVersions()).basicAdd(otherEnd, msgs);
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
			case HistoryModelPackage.HISTORY__VERSIONS:
				return ((InternalEList<?>)getVersions()).basicRemove(otherEnd, msgs);
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
			case HistoryModelPackage.HISTORY__NAME:
				return getName();
			case HistoryModelPackage.HISTORY__VERSIONS:
				return getVersions();
			case HistoryModelPackage.HISTORY__ALL_PROBLEMS:
				return getAllProblems();
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
			case HistoryModelPackage.HISTORY__NAME:
				setName((String)newValue);
				return;
			case HistoryModelPackage.HISTORY__VERSIONS:
				getVersions().clear();
				getVersions().addAll((Collection<? extends Version>)newValue);
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
			case HistoryModelPackage.HISTORY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case HistoryModelPackage.HISTORY__VERSIONS:
				getVersions().clear();
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
			case HistoryModelPackage.HISTORY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case HistoryModelPackage.HISTORY__VERSIONS:
				return versions != null && !versions.isEmpty();
			case HistoryModelPackage.HISTORY__ALL_PROBLEMS:
				return !getAllProblems().isEmpty();
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
			case HistoryModelPackage.HISTORY___GET_PREDECESSOR_VERSIONS__VERSION:
				return getPredecessorVersions((Version)arguments.get(0));
			case HistoryModelPackage.HISTORY___GET_SUCCESSOR_VERSIONS__VERSION:
				return getSuccessorVersions((Version)arguments.get(0));
			case HistoryModelPackage.HISTORY___GET_PROBLEMS__BOOLEAN_BOOLEAN:
				return getProblems((Boolean)arguments.get(0), (Boolean)arguments.get(1));
			case HistoryModelPackage.HISTORY___GET_UNIQUE_PROBLEMS:
				return getUniqueProblems();
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
		result.append(" (name: ");
		result.append(name);
		result.append("\n");
		result.append("Unique Validation Error Names:\n");
		Map<String, Integer> uniqueValidationMessages = getUniqueValdiationMessages();
		for(String key : uniqueValidationMessages.keySet()){
			result.append("\t-" + key + " (" + uniqueValidationMessages.get(key) + ")\n");
		}
		result.append(')');
		return result.toString();
	}

	/**
	 * @generated NOT
	 * @return
	 */
	private Map<String, Integer> getUniqueValdiationMessages(){
		Map<String, Integer> messages = new HashMap<String, Integer>();
		for(Version version : getVersions()){
			for(Problem error : version.getProblems()){
				if(error.getIntroducedIn() != null && error.isResolved()){
					if(messages.get(error.getName()) == null){
						messages.put(error.getName(), 0);
					}
					messages.put(error.getName(), messages.get(error.getName()) +1);
				}
			}
		}
		return messages;
	}
} //HistoryImpl

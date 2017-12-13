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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.historymodel.History;
import org.sidiff.historymodel.HistoryModelPackage;
import org.sidiff.historymodel.ValidationError;
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
 *   <li>{@link org.sidiff.historymodel.impl.HistoryImpl#getAllValidationErrors <em>All Validation Errors</em>}</li>
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
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	public EList<Version> getVersions() {
		if (versions == null) {
			versions = new EObjectContainmentEList<Version>(Version.class, this, HistoryModelPackage.HISTORY__VERSIONS);
		}
		return versions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<ValidationError> getAllValidationErrors() {
		EList<ValidationError> validationErrors = new BasicEList<ValidationError>();
		for(Version version : this.getVersions()){
			validationErrors.addAll(version.getValidationErrors());
		}
		return validationErrors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Version> getPrecessorRevisions(Version version) {
		int index = versions.indexOf(version);
		EList<Version> precessors = new EObjectResolvingEList<Version>(Version.class, this, HistoryModelPackage.HISTORY___GET_SUCCESSOR_REVISIONS__VERSION);
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
	public EList<Version> getSuccessorRevisions(Version version) {
		int index = versions.indexOf(version);
		EList<Version> successors = new EObjectResolvingEList<Version>(Version.class, this, HistoryModelPackage.HISTORY___GET_SUCCESSOR_REVISIONS__VERSION);
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
	public EList<ValidationError> getValidationErrors(boolean introduced, boolean resolved) {
		EList<ValidationError> validationErrors = new BasicEList<ValidationError>();
		for(Version version : getVersions()){
			for(ValidationError error : version.getValidationErrors()){
				boolean toAdd = true;
				if(introduced){
					toAdd = error.isIntroduced();
				}
				if(toAdd && resolved){
					toAdd = error.isResolved();
				}
				
				if(toAdd){
					validationErrors.add(error);
				}
			}
		}
		return validationErrors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<ValidationError> getUniqueValidationErrors() {
		EList<ValidationError> uniqueValidationErrors = new BasicEList<ValidationError>();
		for(ValidationError validationError : getAllValidationErrors()){
			if(validationError.getPrec() == null){
				uniqueValidationErrors.add(validationError);
			}
		}
		return uniqueValidationErrors;
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
			case HistoryModelPackage.HISTORY__ALL_VALIDATION_ERRORS:
				return getAllValidationErrors();
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
			case HistoryModelPackage.HISTORY__ALL_VALIDATION_ERRORS:
				return !getAllValidationErrors().isEmpty();
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
			case HistoryModelPackage.HISTORY___GET_PRECESSOR_REVISIONS__VERSION:
				return getPrecessorRevisions((Version)arguments.get(0));
			case HistoryModelPackage.HISTORY___GET_SUCCESSOR_REVISIONS__VERSION:
				return getSuccessorRevisions((Version)arguments.get(0));
			case HistoryModelPackage.HISTORY___GET_VALIDATION_ERRORS__BOOLEAN_BOOLEAN:
				return getValidationErrors((Boolean)arguments.get(0), (Boolean)arguments.get(1));
			case HistoryModelPackage.HISTORY___GET_UNIQUE_VALIDATION_ERRORS:
				return getUniqueValidationErrors();
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
			for(ValidationError error : version.getValidationErrors()){
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

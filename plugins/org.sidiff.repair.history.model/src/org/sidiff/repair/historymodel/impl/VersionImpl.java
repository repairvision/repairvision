/**
 */
package org.sidiff.repair.historymodel.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.repair.historymodel.HistoryModelPackage;
import org.sidiff.repair.historymodel.ModelStatus;
import org.sidiff.repair.historymodel.ValidationError;
import org.sidiff.repair.historymodel.Version;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Version</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.repair.historymodel.impl.VersionImpl#getValidationErrors <em>Validation Errors</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.impl.VersionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.impl.VersionImpl#getModelURI <em>Model URI</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.impl.VersionImpl#getModel <em>Model</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.impl.VersionImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.impl.VersionImpl#getRepositoryVersion <em>Repository Version</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VersionImpl extends MinimalEObjectImpl.Container implements Version {
	/**
	 * The cached value of the '{@link #getValidationErrors() <em>Validation Errors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidationErrors()
	 * @generated
	 * @ordered
	 */
	protected EList<ValidationError> validationErrors;

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
	 * The default value of the '{@link #getModelURI() <em>Model URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelURI()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModelURI() <em>Model URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelURI()
	 * @generated
	 * @ordered
	 */
	protected String modelURI = MODEL_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getModel() <em>Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected static final Resource MODEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModel() <em>Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected Resource model = MODEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final ModelStatus STATUS_EDEFAULT = ModelStatus.UNKNOWN;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected ModelStatus status = STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getRepositoryVersion() <em>Repository Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String REPOSITORY_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRepositoryVersion() <em>Repository Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryVersion()
	 * @generated
	 * @ordered
	 */
	protected String repositoryVersion = REPOSITORY_VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VersionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HistoryModelPackage.Literals.VERSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ValidationError> getValidationErrors() {
		if (validationErrors == null) {
			validationErrors = new EObjectContainmentEList<ValidationError>(ValidationError.class, this, HistoryModelPackage.VERSION__VALIDATION_ERRORS);
		}
		return validationErrors;
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
			eNotify(new ENotificationImpl(this, Notification.SET, HistoryModelPackage.VERSION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getModelURI() {
		return modelURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelURI(String newModelURI) {
		String oldModelURI = modelURI;
		modelURI = newModelURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HistoryModelPackage.VERSION__MODEL_URI, oldModelURI, modelURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Resource getModel() {
		if(model == null){
			model = eResource().getResourceSet().getResource(URI.createURI(modelURI), true);
		}
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setModel(Resource newModel) {
		Resource oldModel = model;
		model = newModel;
		setModelURI(newModel.getURI().toString());
		
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HistoryModelPackage.VERSION__MODEL, oldModel, model));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelStatus getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(ModelStatus newStatus) {
		ModelStatus oldStatus = status;
		status = newStatus == null ? STATUS_EDEFAULT : newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HistoryModelPackage.VERSION__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepositoryVersion() {
		return repositoryVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepositoryVersion(String newRepositoryVersion) {
		String oldRepositoryVersion = repositoryVersion;
		repositoryVersion = newRepositoryVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HistoryModelPackage.VERSION__REPOSITORY_VERSION, oldRepositoryVersion, repositoryVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EObject getElement(String id) {
		for (Iterator<EObject> iterator = getModel().getAllContents(); iterator.hasNext();) {
			EObject eObject = iterator.next();
			if (id.equals(EMFUtil.getXmiId(eObject))){
				return eObject;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HistoryModelPackage.VERSION__VALIDATION_ERRORS:
				return ((InternalEList<?>)getValidationErrors()).basicRemove(otherEnd, msgs);
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
			case HistoryModelPackage.VERSION__VALIDATION_ERRORS:
				return getValidationErrors();
			case HistoryModelPackage.VERSION__NAME:
				return getName();
			case HistoryModelPackage.VERSION__MODEL_URI:
				return getModelURI();
			case HistoryModelPackage.VERSION__MODEL:
				return getModel();
			case HistoryModelPackage.VERSION__STATUS:
				return getStatus();
			case HistoryModelPackage.VERSION__REPOSITORY_VERSION:
				return getRepositoryVersion();
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
			case HistoryModelPackage.VERSION__VALIDATION_ERRORS:
				getValidationErrors().clear();
				getValidationErrors().addAll((Collection<? extends ValidationError>)newValue);
				return;
			case HistoryModelPackage.VERSION__NAME:
				setName((String)newValue);
				return;
			case HistoryModelPackage.VERSION__MODEL_URI:
				setModelURI((String)newValue);
				return;
			case HistoryModelPackage.VERSION__MODEL:
				setModel((Resource)newValue);
				return;
			case HistoryModelPackage.VERSION__STATUS:
				setStatus((ModelStatus)newValue);
				return;
			case HistoryModelPackage.VERSION__REPOSITORY_VERSION:
				setRepositoryVersion((String)newValue);
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
			case HistoryModelPackage.VERSION__VALIDATION_ERRORS:
				getValidationErrors().clear();
				return;
			case HistoryModelPackage.VERSION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case HistoryModelPackage.VERSION__MODEL_URI:
				setModelURI(MODEL_URI_EDEFAULT);
				return;
			case HistoryModelPackage.VERSION__MODEL:
				setModel(MODEL_EDEFAULT);
				return;
			case HistoryModelPackage.VERSION__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case HistoryModelPackage.VERSION__REPOSITORY_VERSION:
				setRepositoryVersion(REPOSITORY_VERSION_EDEFAULT);
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
			case HistoryModelPackage.VERSION__VALIDATION_ERRORS:
				return validationErrors != null && !validationErrors.isEmpty();
			case HistoryModelPackage.VERSION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case HistoryModelPackage.VERSION__MODEL_URI:
				return MODEL_URI_EDEFAULT == null ? modelURI != null : !MODEL_URI_EDEFAULT.equals(modelURI);
			case HistoryModelPackage.VERSION__MODEL:
				return MODEL_EDEFAULT == null ? model != null : !MODEL_EDEFAULT.equals(model);
			case HistoryModelPackage.VERSION__STATUS:
				return status != STATUS_EDEFAULT;
			case HistoryModelPackage.VERSION__REPOSITORY_VERSION:
				return REPOSITORY_VERSION_EDEFAULT == null ? repositoryVersion != null : !REPOSITORY_VERSION_EDEFAULT.equals(repositoryVersion);
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
			case HistoryModelPackage.VERSION___GET_ELEMENT__STRING:
				return getElement((String)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", modelURI: ");
		result.append(modelURI);
		result.append(", model: ");
		result.append(model);
		result.append(", status: ");
		result.append(status);
		result.append(", repositoryVersion: ");
		result.append(repositoryVersion);
		result.append(')');
		return result.toString();
	}

} //VersionImpl

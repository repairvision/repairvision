/**
 */
package org.sidiff.historymodel.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

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
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.historymodel.History;
import org.sidiff.historymodel.HistoryModelPackage;
import org.sidiff.historymodel.ModelStatus;
import org.sidiff.historymodel.Problem;
import org.sidiff.historymodel.Version;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Version</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.historymodel.impl.VersionImpl#getProblems <em>Problems</em>}</li>
 *   <li>{@link org.sidiff.historymodel.impl.VersionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sidiff.historymodel.impl.VersionImpl#getModelURI <em>Model URI</em>}</li>
 *   <li>{@link org.sidiff.historymodel.impl.VersionImpl#getModel <em>Model</em>}</li>
 *   <li>{@link org.sidiff.historymodel.impl.VersionImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.sidiff.historymodel.impl.VersionImpl#getRepositoryVersion <em>Repository Version</em>}</li>
 *   <li>{@link org.sidiff.historymodel.impl.VersionImpl#getHistory <em>History</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VersionImpl extends MinimalEObjectImpl.Container implements Version {
	/**
	 * The cached value of the '{@link #getProblems() <em>Problems</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProblems()
	 * @generated
	 * @ordered
	 */
	protected EList<Problem> problems;

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
	@Override
	public EList<Problem> getProblems() {
		if (problems == null) {
			problems = new EObjectContainmentWithInverseEList<Problem>(Problem.class, this, HistoryModelPackage.VERSION__PROBLEMS, HistoryModelPackage.PROBLEM__VERSION);
		}
		return problems;
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
			eNotify(new ENotificationImpl(this, Notification.SET, HistoryModelPackage.VERSION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getModelURI() {
		return modelURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
		if(model == null) {
			String modelURI = this.modelURI;
			
			// assert that model URI is relative to history model:
			if (URI.createURI(modelURI).scheme() == null) {
				modelURI = eResource().getURI().trimSegments(1).toString() + modelURI;
			}
			
			model = new ResourceSetImpl().getResource(URI.createURI(modelURI), true);
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
	@Override
	public ModelStatus getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public String getRepositoryVersion() {
		return repositoryVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRepositoryVersion(String newRepositoryVersion) {
		String oldRepositoryVersion = repositoryVersion;
		repositoryVersion = newRepositoryVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HistoryModelPackage.VERSION__REPOSITORY_VERSION, oldRepositoryVersion, repositoryVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public History getHistory() {
		if (eContainerFeatureID() != HistoryModelPackage.VERSION__HISTORY) return null;
		return (History)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHistory(History newHistory, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newHistory, HistoryModelPackage.VERSION__HISTORY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHistory(History newHistory) {
		if (newHistory != eInternalContainer() || (eContainerFeatureID() != HistoryModelPackage.VERSION__HISTORY && newHistory != null)) {
			if (EcoreUtil.isAncestor(this, newHistory))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newHistory != null)
				msgs = ((InternalEObject)newHistory).eInverseAdd(this, HistoryModelPackage.HISTORY__VERSIONS, History.class, msgs);
			msgs = basicSetHistory(newHistory, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HistoryModelPackage.VERSION__HISTORY, newHistory, newHistory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EObject getElement(String id) {
		return getModel().getEObject(id);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Version getPredecessor() {
		int index = getHistory().getVersions().indexOf(this);

		if ((index - 1) >= 0) {
			return getHistory().getVersions().get(index - 1);
		}
		
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Version getSuccessor() {
		int index = getHistory().getVersions().indexOf(this);

		if ((index + 1) < getHistory().getVersions().size()) {
			return getHistory().getVersions().get(index + 1);
		}
		
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getIndex() {
		return getHistory().getVersions().indexOf(this);
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
			case HistoryModelPackage.VERSION__PROBLEMS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProblems()).basicAdd(otherEnd, msgs);
			case HistoryModelPackage.VERSION__HISTORY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetHistory((History)otherEnd, msgs);
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
			case HistoryModelPackage.VERSION__PROBLEMS:
				return ((InternalEList<?>)getProblems()).basicRemove(otherEnd, msgs);
			case HistoryModelPackage.VERSION__HISTORY:
				return basicSetHistory(null, msgs);
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
			case HistoryModelPackage.VERSION__HISTORY:
				return eInternalContainer().eInverseRemove(this, HistoryModelPackage.HISTORY__VERSIONS, History.class, msgs);
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
			case HistoryModelPackage.VERSION__PROBLEMS:
				return getProblems();
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
			case HistoryModelPackage.VERSION__HISTORY:
				return getHistory();
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
			case HistoryModelPackage.VERSION__PROBLEMS:
				getProblems().clear();
				getProblems().addAll((Collection<? extends Problem>)newValue);
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
			case HistoryModelPackage.VERSION__HISTORY:
				setHistory((History)newValue);
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
			case HistoryModelPackage.VERSION__PROBLEMS:
				getProblems().clear();
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
			case HistoryModelPackage.VERSION__HISTORY:
				setHistory((History)null);
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
			case HistoryModelPackage.VERSION__PROBLEMS:
				return problems != null && !problems.isEmpty();
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
			case HistoryModelPackage.VERSION__HISTORY:
				return getHistory() != null;
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
			case HistoryModelPackage.VERSION___GET_PREDECESSOR:
				return getPredecessor();
			case HistoryModelPackage.VERSION___GET_SUCCESSOR:
				return getSuccessor();
			case HistoryModelPackage.VERSION___GET_INDEX:
				return getIndex();
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

		StringBuilder result = new StringBuilder(super.toString());
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
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EObject eResolveProxyByVersion(InternalEObject proxy) {
		return EcoreUtil.resolve(proxy, getModel().getResourceSet());
	}

} //VersionImpl

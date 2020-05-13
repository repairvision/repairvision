/**
 */
package org.sidiff.historymodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.historymodel.Annotation;
import org.sidiff.historymodel.ChangeSet;
import org.sidiff.historymodel.HistoryModelPackage;
import org.sidiff.historymodel.ModificationClassification;
import org.sidiff.historymodel.Problem;
import org.sidiff.historymodel.ProblemSeverity;
import org.sidiff.historymodel.Version;
import org.sidiff.historymodel.util.EObjectResolvingEListByVersion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Problem</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.historymodel.impl.ProblemImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.sidiff.historymodel.impl.ProblemImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sidiff.historymodel.impl.ProblemImpl#getIntroducedIn <em>Introduced In</em>}</li>
 *   <li>{@link org.sidiff.historymodel.impl.ProblemImpl#isIntroduced <em>Introduced</em>}</li>
 *   <li>{@link org.sidiff.historymodel.impl.ProblemImpl#getResolvedIn <em>Resolved In</em>}</li>
 *   <li>{@link org.sidiff.historymodel.impl.ProblemImpl#isResolved <em>Resolved</em>}</li>
 *   <li>{@link org.sidiff.historymodel.impl.ProblemImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.sidiff.historymodel.impl.ProblemImpl#getSeverity <em>Severity</em>}</li>
 *   <li>{@link org.sidiff.historymodel.impl.ProblemImpl#getPredecessor <em>Predecessor</em>}</li>
 *   <li>{@link org.sidiff.historymodel.impl.ProblemImpl#getSuccessor <em>Successor</em>}</li>
 *   <li>{@link org.sidiff.historymodel.impl.ProblemImpl#getInvalidElements <em>Invalid Elements</em>}</li>
 *   <li>{@link org.sidiff.historymodel.impl.ProblemImpl#getContextElement <em>Context Element</em>}</li>
 *   <li>{@link org.sidiff.historymodel.impl.ProblemImpl#getModifications <em>Modifications</em>}</li>
 *   <li>{@link org.sidiff.historymodel.impl.ProblemImpl#getModificationClassification <em>Modification Classification</em>}</li>
 *   <li>{@link org.sidiff.historymodel.impl.ProblemImpl#getAnnotations <em>Annotations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProblemImpl extends MinimalEObjectImpl.Container implements Problem {
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
	 * The cached value of the '{@link #getIntroducedIn() <em>Introduced In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntroducedIn()
	 * @generated
	 * @ordered
	 */
	protected Version introducedIn;

	/**
	 * The default value of the '{@link #isIntroduced() <em>Introduced</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIntroduced()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INTRODUCED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #getResolvedIn() <em>Resolved In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolvedIn()
	 * @generated
	 * @ordered
	 */
	protected Version resolvedIn;

	/**
	 * The default value of the '{@link #isResolved() <em>Resolved</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResolved()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RESOLVED_EDEFAULT = false;

	/**
	 * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected String message = MESSAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected static final ProblemSeverity SEVERITY_EDEFAULT = ProblemSeverity.UNKNOWN;

	/**
	 * The cached value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected ProblemSeverity severity = SEVERITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPredecessor() <em>Predecessor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredecessor()
	 * @generated
	 * @ordered
	 */
	protected Problem predecessor;

	/**
	 * The cached value of the '{@link #getSuccessor() <em>Successor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuccessor()
	 * @generated
	 * @ordered
	 */
	protected Problem successor;

	/**
	 * The cached value of the '{@link #getInvalidElements() <em>Invalid Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvalidElements()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> invalidElements;

	/**
	 * The cached value of the '{@link #getContextElement() <em>Context Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextElement()
	 * @generated
	 * @ordered
	 */
	protected EObject contextElement;

	/**
	 * The cached value of the '{@link #getModifications() <em>Modifications</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifications()
	 * @generated
	 * @ordered
	 */
	protected EList<ChangeSet> modifications;

	/**
	 * The cached value of the '{@link #getModificationClassification() <em>Modification Classification</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModificationClassification()
	 * @generated
	 * @ordered
	 */
	protected EList<ModificationClassification> modificationClassification;

	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<Annotation> annotations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProblemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HistoryModelPackage.Literals.PROBLEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Version getVersion() {
		if (eContainerFeatureID() != HistoryModelPackage.PROBLEM__VERSION) return null;
		return (Version)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVersion(Version newVersion, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newVersion, HistoryModelPackage.PROBLEM__VERSION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersion(Version newVersion) {
		if (newVersion != eInternalContainer() || (eContainerFeatureID() != HistoryModelPackage.PROBLEM__VERSION && newVersion != null)) {
			if (EcoreUtil.isAncestor(this, newVersion))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newVersion != null)
				msgs = ((InternalEObject)newVersion).eInverseAdd(this, HistoryModelPackage.VERSION__PROBLEMS, Version.class, msgs);
			msgs = basicSetVersion(newVersion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HistoryModelPackage.PROBLEM__VERSION, newVersion, newVersion));
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
			eNotify(new ENotificationImpl(this, Notification.SET, HistoryModelPackage.PROBLEM__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Version getIntroducedIn() {
		if (introducedIn != null && introducedIn.eIsProxy()) {
			InternalEObject oldIntroducedIn = (InternalEObject)introducedIn;
			introducedIn = (Version)eResolveProxy(oldIntroducedIn);
			if (introducedIn != oldIntroducedIn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HistoryModelPackage.PROBLEM__INTRODUCED_IN, oldIntroducedIn, introducedIn));
			}
		}
		return introducedIn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Version basicGetIntroducedIn() {
		return introducedIn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setIntroducedIn(Version newIntroducedIn) {
		Version oldIntroducedIn = introducedIn;
		introducedIn = newIntroducedIn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HistoryModelPackage.PROBLEM__INTRODUCED_IN, oldIntroducedIn, introducedIn));
		
		// propagate value:
		if (getPredecessor()!= null) {
			if (getPredecessor().getIntroducedIn() != newIntroducedIn) {
				getPredecessor().setIntroducedIn(newIntroducedIn);
			}
		}
		
		if (getSuccessor() != null) {
			if (getSuccessor().getIntroducedIn() != newIntroducedIn) {
				getSuccessor().setIntroducedIn(newIntroducedIn);
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isIntroduced() {
		return (getIntroducedIn() != null) && (getIntroducedIn().getPredecessor() != null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Version getResolvedIn() {
		if (resolvedIn != null && resolvedIn.eIsProxy()) {
			InternalEObject oldResolvedIn = (InternalEObject)resolvedIn;
			resolvedIn = (Version)eResolveProxy(oldResolvedIn);
			if (resolvedIn != oldResolvedIn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HistoryModelPackage.PROBLEM__RESOLVED_IN, oldResolvedIn, resolvedIn));
			}
		}
		return resolvedIn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Version basicGetResolvedIn() {
		return resolvedIn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResolvedIn(Version newResolvedIn) {
		Version oldResolvedIn = resolvedIn;
		resolvedIn = newResolvedIn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HistoryModelPackage.PROBLEM__RESOLVED_IN, oldResolvedIn, resolvedIn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isResolved() {
		return getResolvedIn() != null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMessage(String newMessage) {
		String oldMessage = message;
		message = newMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HistoryModelPackage.PROBLEM__MESSAGE, oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProblemSeverity getSeverity() {
		return severity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSeverity(ProblemSeverity newSeverity) {
		ProblemSeverity oldSeverity = severity;
		severity = newSeverity == null ? SEVERITY_EDEFAULT : newSeverity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HistoryModelPackage.PROBLEM__SEVERITY, oldSeverity, severity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Problem getPredecessor() {
		if (predecessor != null && predecessor.eIsProxy()) {
			InternalEObject oldPredecessor = (InternalEObject)predecessor;
			predecessor = (Problem)eResolveProxy(oldPredecessor);
			if (predecessor != oldPredecessor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HistoryModelPackage.PROBLEM__PREDECESSOR, oldPredecessor, predecessor));
			}
		}
		return predecessor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Problem basicGetPredecessor() {
		return predecessor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPredecessor(Problem newPredecessor, NotificationChain msgs) {
		Problem oldPredecessor = predecessor;
		predecessor = newPredecessor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HistoryModelPackage.PROBLEM__PREDECESSOR, oldPredecessor, newPredecessor);
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
	public void setPredecessor(Problem newPredecessor) {
		if (newPredecessor != predecessor) {
			NotificationChain msgs = null;
			if (predecessor != null)
				msgs = ((InternalEObject)predecessor).eInverseRemove(this, HistoryModelPackage.PROBLEM__SUCCESSOR, Problem.class, msgs);
			if (newPredecessor != null)
				msgs = ((InternalEObject)newPredecessor).eInverseAdd(this, HistoryModelPackage.PROBLEM__SUCCESSOR, Problem.class, msgs);
			msgs = basicSetPredecessor(newPredecessor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HistoryModelPackage.PROBLEM__PREDECESSOR, newPredecessor, newPredecessor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Problem getSuccessor() {
		if (successor != null && successor.eIsProxy()) {
			InternalEObject oldSuccessor = (InternalEObject)successor;
			successor = (Problem)eResolveProxy(oldSuccessor);
			if (successor != oldSuccessor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HistoryModelPackage.PROBLEM__SUCCESSOR, oldSuccessor, successor));
			}
		}
		return successor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Problem basicGetSuccessor() {
		return successor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuccessor(Problem newSuccessor, NotificationChain msgs) {
		Problem oldSuccessor = successor;
		successor = newSuccessor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HistoryModelPackage.PROBLEM__SUCCESSOR, oldSuccessor, newSuccessor);
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
	public void setSuccessor(Problem newSuccessor) {
		if (newSuccessor != successor) {
			NotificationChain msgs = null;
			if (successor != null)
				msgs = ((InternalEObject)successor).eInverseRemove(this, HistoryModelPackage.PROBLEM__PREDECESSOR, Problem.class, msgs);
			if (newSuccessor != null)
				msgs = ((InternalEObject)newSuccessor).eInverseAdd(this, HistoryModelPackage.PROBLEM__PREDECESSOR, Problem.class, msgs);
			msgs = basicSetSuccessor(newSuccessor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HistoryModelPackage.PROBLEM__SUCCESSOR, newSuccessor, newSuccessor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<EObject> getInvalidElements() {
		if (invalidElements == null) {
			invalidElements = new EObjectResolvingEListByVersion<EObject>(EObject.class, this, HistoryModelPackage.PROBLEM__INVALID_ELEMENTS, getVersion());
		}
		return invalidElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EObject getContextElement() {
		if (contextElement != null && contextElement.eIsProxy()) {
			InternalEObject oldContextElement = (InternalEObject)contextElement;
			contextElement = getVersion().eResolveProxyByVersion(oldContextElement);
			if (contextElement != oldContextElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HistoryModelPackage.PROBLEM__CONTEXT_ELEMENT, oldContextElement, contextElement));
			}
		}
		return contextElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetContextElement() {
		return contextElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContextElement(EObject newContextElement) {
		EObject oldContextElement = contextElement;
		contextElement = newContextElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HistoryModelPackage.PROBLEM__CONTEXT_ELEMENT, oldContextElement, contextElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ChangeSet> getModifications() {
		if (modifications == null) {
			modifications = new EObjectContainmentEList<ChangeSet>(ChangeSet.class, this, HistoryModelPackage.PROBLEM__MODIFICATIONS);
		}
		return modifications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ModificationClassification> getModificationClassification() {
		if (modificationClassification == null) {
			modificationClassification = new EDataTypeUniqueEList<ModificationClassification>(ModificationClassification.class, this, HistoryModelPackage.PROBLEM__MODIFICATION_CLASSIFICATION);
		}
		return modificationClassification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Annotation> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectContainmentEList<Annotation>(Annotation.class, this, HistoryModelPackage.PROBLEM__ANNOTATIONS);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HistoryModelPackage.PROBLEM__VERSION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetVersion((Version)otherEnd, msgs);
			case HistoryModelPackage.PROBLEM__PREDECESSOR:
				if (predecessor != null)
					msgs = ((InternalEObject)predecessor).eInverseRemove(this, HistoryModelPackage.PROBLEM__SUCCESSOR, Problem.class, msgs);
				return basicSetPredecessor((Problem)otherEnd, msgs);
			case HistoryModelPackage.PROBLEM__SUCCESSOR:
				if (successor != null)
					msgs = ((InternalEObject)successor).eInverseRemove(this, HistoryModelPackage.PROBLEM__PREDECESSOR, Problem.class, msgs);
				return basicSetSuccessor((Problem)otherEnd, msgs);
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
			case HistoryModelPackage.PROBLEM__VERSION:
				return basicSetVersion(null, msgs);
			case HistoryModelPackage.PROBLEM__PREDECESSOR:
				return basicSetPredecessor(null, msgs);
			case HistoryModelPackage.PROBLEM__SUCCESSOR:
				return basicSetSuccessor(null, msgs);
			case HistoryModelPackage.PROBLEM__MODIFICATIONS:
				return ((InternalEList<?>)getModifications()).basicRemove(otherEnd, msgs);
			case HistoryModelPackage.PROBLEM__ANNOTATIONS:
				return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
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
			case HistoryModelPackage.PROBLEM__VERSION:
				return eInternalContainer().eInverseRemove(this, HistoryModelPackage.VERSION__PROBLEMS, Version.class, msgs);
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
			case HistoryModelPackage.PROBLEM__VERSION:
				return getVersion();
			case HistoryModelPackage.PROBLEM__NAME:
				return getName();
			case HistoryModelPackage.PROBLEM__INTRODUCED_IN:
				if (resolve) return getIntroducedIn();
				return basicGetIntroducedIn();
			case HistoryModelPackage.PROBLEM__INTRODUCED:
				return isIntroduced();
			case HistoryModelPackage.PROBLEM__RESOLVED_IN:
				if (resolve) return getResolvedIn();
				return basicGetResolvedIn();
			case HistoryModelPackage.PROBLEM__RESOLVED:
				return isResolved();
			case HistoryModelPackage.PROBLEM__MESSAGE:
				return getMessage();
			case HistoryModelPackage.PROBLEM__SEVERITY:
				return getSeverity();
			case HistoryModelPackage.PROBLEM__PREDECESSOR:
				if (resolve) return getPredecessor();
				return basicGetPredecessor();
			case HistoryModelPackage.PROBLEM__SUCCESSOR:
				if (resolve) return getSuccessor();
				return basicGetSuccessor();
			case HistoryModelPackage.PROBLEM__INVALID_ELEMENTS:
				return getInvalidElements();
			case HistoryModelPackage.PROBLEM__CONTEXT_ELEMENT:
				if (resolve) return getContextElement();
				return basicGetContextElement();
			case HistoryModelPackage.PROBLEM__MODIFICATIONS:
				return getModifications();
			case HistoryModelPackage.PROBLEM__MODIFICATION_CLASSIFICATION:
				return getModificationClassification();
			case HistoryModelPackage.PROBLEM__ANNOTATIONS:
				return getAnnotations();
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
			case HistoryModelPackage.PROBLEM__VERSION:
				setVersion((Version)newValue);
				return;
			case HistoryModelPackage.PROBLEM__NAME:
				setName((String)newValue);
				return;
			case HistoryModelPackage.PROBLEM__INTRODUCED_IN:
				setIntroducedIn((Version)newValue);
				return;
			case HistoryModelPackage.PROBLEM__RESOLVED_IN:
				setResolvedIn((Version)newValue);
				return;
			case HistoryModelPackage.PROBLEM__MESSAGE:
				setMessage((String)newValue);
				return;
			case HistoryModelPackage.PROBLEM__SEVERITY:
				setSeverity((ProblemSeverity)newValue);
				return;
			case HistoryModelPackage.PROBLEM__PREDECESSOR:
				setPredecessor((Problem)newValue);
				return;
			case HistoryModelPackage.PROBLEM__SUCCESSOR:
				setSuccessor((Problem)newValue);
				return;
			case HistoryModelPackage.PROBLEM__CONTEXT_ELEMENT:
				setContextElement((EObject)newValue);
				return;
			case HistoryModelPackage.PROBLEM__MODIFICATIONS:
				getModifications().clear();
				getModifications().addAll((Collection<? extends ChangeSet>)newValue);
				return;
			case HistoryModelPackage.PROBLEM__MODIFICATION_CLASSIFICATION:
				getModificationClassification().clear();
				getModificationClassification().addAll((Collection<? extends ModificationClassification>)newValue);
				return;
			case HistoryModelPackage.PROBLEM__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends Annotation>)newValue);
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
			case HistoryModelPackage.PROBLEM__VERSION:
				setVersion((Version)null);
				return;
			case HistoryModelPackage.PROBLEM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case HistoryModelPackage.PROBLEM__INTRODUCED_IN:
				setIntroducedIn((Version)null);
				return;
			case HistoryModelPackage.PROBLEM__RESOLVED_IN:
				setResolvedIn((Version)null);
				return;
			case HistoryModelPackage.PROBLEM__MESSAGE:
				setMessage(MESSAGE_EDEFAULT);
				return;
			case HistoryModelPackage.PROBLEM__SEVERITY:
				setSeverity(SEVERITY_EDEFAULT);
				return;
			case HistoryModelPackage.PROBLEM__PREDECESSOR:
				setPredecessor((Problem)null);
				return;
			case HistoryModelPackage.PROBLEM__SUCCESSOR:
				setSuccessor((Problem)null);
				return;
			case HistoryModelPackage.PROBLEM__CONTEXT_ELEMENT:
				setContextElement((EObject)null);
				return;
			case HistoryModelPackage.PROBLEM__MODIFICATIONS:
				getModifications().clear();
				return;
			case HistoryModelPackage.PROBLEM__MODIFICATION_CLASSIFICATION:
				getModificationClassification().clear();
				return;
			case HistoryModelPackage.PROBLEM__ANNOTATIONS:
				getAnnotations().clear();
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
			case HistoryModelPackage.PROBLEM__VERSION:
				return getVersion() != null;
			case HistoryModelPackage.PROBLEM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case HistoryModelPackage.PROBLEM__INTRODUCED_IN:
				return introducedIn != null;
			case HistoryModelPackage.PROBLEM__INTRODUCED:
				return isIntroduced() != INTRODUCED_EDEFAULT;
			case HistoryModelPackage.PROBLEM__RESOLVED_IN:
				return resolvedIn != null;
			case HistoryModelPackage.PROBLEM__RESOLVED:
				return isResolved() != RESOLVED_EDEFAULT;
			case HistoryModelPackage.PROBLEM__MESSAGE:
				return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
			case HistoryModelPackage.PROBLEM__SEVERITY:
				return severity != SEVERITY_EDEFAULT;
			case HistoryModelPackage.PROBLEM__PREDECESSOR:
				return predecessor != null;
			case HistoryModelPackage.PROBLEM__SUCCESSOR:
				return successor != null;
			case HistoryModelPackage.PROBLEM__INVALID_ELEMENTS:
				return invalidElements != null && !invalidElements.isEmpty();
			case HistoryModelPackage.PROBLEM__CONTEXT_ELEMENT:
				return contextElement != null;
			case HistoryModelPackage.PROBLEM__MODIFICATIONS:
				return modifications != null && !modifications.isEmpty();
			case HistoryModelPackage.PROBLEM__MODIFICATION_CLASSIFICATION:
				return modificationClassification != null && !modificationClassification.isEmpty();
			case HistoryModelPackage.PROBLEM__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
		}
		return super.eIsSet(featureID);
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
		result.append(", message: ");
		result.append(message);
		result.append(", severity: ");
		result.append(severity);
		result.append(", modificationClassification: ");
		result.append(modificationClassification);
		result.append(')');
		return result.toString();
	}

} //ProblemImpl

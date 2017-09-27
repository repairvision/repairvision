/**
 */
package org.sidiff.repair.historymodel.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.repair.historymodel.HistoryModelPackage;
import org.sidiff.repair.historymodel.ValidationError;
import org.sidiff.repair.historymodel.ValidationSeverity;
import org.sidiff.repair.historymodel.Version;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Validation Error</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.repair.historymodel.impl.ValidationErrorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.impl.ValidationErrorImpl#getIntroducedIn <em>Introduced In</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.impl.ValidationErrorImpl#getResolvedIn <em>Resolved In</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.impl.ValidationErrorImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.impl.ValidationErrorImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.impl.ValidationErrorImpl#getSeverity <em>Severity</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.impl.ValidationErrorImpl#isIntroduced <em>Introduced</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.impl.ValidationErrorImpl#isResolved <em>Resolved</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.impl.ValidationErrorImpl#getPrec <em>Prec</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.impl.ValidationErrorImpl#getSucc <em>Succ</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.impl.ValidationErrorImpl#getInvalidElement <em>Invalid Element</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.impl.ValidationErrorImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.impl.ValidationErrorImpl#getIntroducedByChanges <em>Introduced By Changes</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.impl.ValidationErrorImpl#getResolvedByChanges <em>Resolved By Changes</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.impl.ValidationErrorImpl#isResolvedByUndo <em>Resolved By Undo</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.impl.ValidationErrorImpl#getPositivSideEffects <em>Positiv Side Effects</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.impl.ValidationErrorImpl#getNegativSideEffects <em>Negativ Side Effects</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ValidationErrorImpl extends MinimalEObjectImpl.Container implements ValidationError {
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
	 * The cached value of the '{@link #getResolvedIn() <em>Resolved In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolvedIn()
	 * @generated
	 * @ordered
	 */
	protected Version resolvedIn;

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
	 * The default value of the '{@link #getSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected String source = SOURCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected static final ValidationSeverity SEVERITY_EDEFAULT = ValidationSeverity.UNKNOWN;

	/**
	 * The cached value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected ValidationSeverity severity = SEVERITY_EDEFAULT;

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
	 * The default value of the '{@link #isResolved() <em>Resolved</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResolved()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RESOLVED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #getPrec() <em>Prec</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrec()
	 * @generated
	 * @ordered
	 */
	protected ValidationError prec;

	/**
	 * The cached value of the '{@link #getSucc() <em>Succ</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSucc()
	 * @generated
	 * @ordered
	 */
	protected ValidationError succ;

	/**
	 * The cached value of the '{@link #getInvalidElement() <em>Invalid Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvalidElement()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> invalidElement;

	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected EObject context;

	/**
	 * The cached value of the '{@link #getIntroducedByChanges() <em>Introduced By Changes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntroducedByChanges()
	 * @generated
	 * @ordered
	 */
	protected EList<Change> introducedByChanges;

	/**
	 * The cached value of the '{@link #getResolvedByChanges() <em>Resolved By Changes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolvedByChanges()
	 * @generated
	 * @ordered
	 */
	protected EList<Change> resolvedByChanges;

	/**
	 * The default value of the '{@link #isResolvedByUndo() <em>Resolved By Undo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResolvedByUndo()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RESOLVED_BY_UNDO_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isResolvedByUndo() <em>Resolved By Undo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResolvedByUndo()
	 * @generated
	 * @ordered
	 */
	protected boolean resolvedByUndo = RESOLVED_BY_UNDO_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPositivSideEffects() <em>Positiv Side Effects</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPositivSideEffects()
	 * @generated
	 * @ordered
	 */
	protected EList<ValidationError> positivSideEffects;

	/**
	 * The cached value of the '{@link #getNegativSideEffects() <em>Negativ Side Effects</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNegativSideEffects()
	 * @generated
	 * @ordered
	 */
	protected EList<ValidationError> negativSideEffects;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValidationErrorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HistoryModelPackage.Literals.VALIDATION_ERROR;
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
			eNotify(new ENotificationImpl(this, Notification.SET, HistoryModelPackage.VALIDATION_ERROR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Version getIntroducedIn() {
		if (introducedIn != null && introducedIn.eIsProxy()) {
			InternalEObject oldIntroducedIn = (InternalEObject)introducedIn;
			introducedIn = (Version)eResolveProxy(oldIntroducedIn);
			if (introducedIn != oldIntroducedIn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HistoryModelPackage.VALIDATION_ERROR__INTRODUCED_IN, oldIntroducedIn, introducedIn));
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
	 * @generated
	 */
	public void setIntroducedIn(Version newIntroducedIn) {
		Version oldIntroducedIn = introducedIn;
		introducedIn = newIntroducedIn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HistoryModelPackage.VALIDATION_ERROR__INTRODUCED_IN, oldIntroducedIn, introducedIn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Version getResolvedIn() {
		if (resolvedIn != null && resolvedIn.eIsProxy()) {
			InternalEObject oldResolvedIn = (InternalEObject)resolvedIn;
			resolvedIn = (Version)eResolveProxy(oldResolvedIn);
			if (resolvedIn != oldResolvedIn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HistoryModelPackage.VALIDATION_ERROR__RESOLVED_IN, oldResolvedIn, resolvedIn));
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
	public void setResolvedIn(Version newResolvedIn) {
		Version oldResolvedIn = resolvedIn;
		resolvedIn = newResolvedIn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HistoryModelPackage.VALIDATION_ERROR__RESOLVED_IN, oldResolvedIn, resolvedIn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessage(String newMessage) {
		String oldMessage = message;
		message = newMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HistoryModelPackage.VALIDATION_ERROR__MESSAGE, oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(String newSource) {
		String oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HistoryModelPackage.VALIDATION_ERROR__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidationSeverity getSeverity() {
		return severity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeverity(ValidationSeverity newSeverity) {
		ValidationSeverity oldSeverity = severity;
		severity = newSeverity == null ? SEVERITY_EDEFAULT : newSeverity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HistoryModelPackage.VALIDATION_ERROR__SEVERITY, oldSeverity, severity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isIntroduced() {
		return getIntroducedIn() != null;
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
	public ValidationError getPrec() {
		if (prec != null && prec.eIsProxy()) {
			InternalEObject oldPrec = (InternalEObject)prec;
			prec = (ValidationError)eResolveProxy(oldPrec);
			if (prec != oldPrec) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HistoryModelPackage.VALIDATION_ERROR__PREC, oldPrec, prec));
			}
		}
		return prec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidationError basicGetPrec() {
		return prec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPrec(ValidationError newPrec, NotificationChain msgs) {
		ValidationError oldPrec = prec;
		prec = newPrec;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HistoryModelPackage.VALIDATION_ERROR__PREC, oldPrec, newPrec);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrec(ValidationError newPrec) {
		if (newPrec != prec) {
			NotificationChain msgs = null;
			if (prec != null)
				msgs = ((InternalEObject)prec).eInverseRemove(this, HistoryModelPackage.VALIDATION_ERROR__SUCC, ValidationError.class, msgs);
			if (newPrec != null)
				msgs = ((InternalEObject)newPrec).eInverseAdd(this, HistoryModelPackage.VALIDATION_ERROR__SUCC, ValidationError.class, msgs);
			msgs = basicSetPrec(newPrec, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HistoryModelPackage.VALIDATION_ERROR__PREC, newPrec, newPrec));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidationError getSucc() {
		if (succ != null && succ.eIsProxy()) {
			InternalEObject oldSucc = (InternalEObject)succ;
			succ = (ValidationError)eResolveProxy(oldSucc);
			if (succ != oldSucc) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HistoryModelPackage.VALIDATION_ERROR__SUCC, oldSucc, succ));
			}
		}
		return succ;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidationError basicGetSucc() {
		return succ;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSucc(ValidationError newSucc, NotificationChain msgs) {
		ValidationError oldSucc = succ;
		succ = newSucc;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HistoryModelPackage.VALIDATION_ERROR__SUCC, oldSucc, newSucc);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSucc(ValidationError newSucc) {
		if (newSucc != succ) {
			NotificationChain msgs = null;
			if (succ != null)
				msgs = ((InternalEObject)succ).eInverseRemove(this, HistoryModelPackage.VALIDATION_ERROR__PREC, ValidationError.class, msgs);
			if (newSucc != null)
				msgs = ((InternalEObject)newSucc).eInverseAdd(this, HistoryModelPackage.VALIDATION_ERROR__PREC, ValidationError.class, msgs);
			msgs = basicSetSucc(newSucc, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HistoryModelPackage.VALIDATION_ERROR__SUCC, newSucc, newSucc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getInvalidElement() {
		if (invalidElement == null) {
			invalidElement = new EObjectResolvingEList<EObject>(EObject.class, this, HistoryModelPackage.VALIDATION_ERROR__INVALID_ELEMENT);
		}
		return invalidElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getContext() {
		if (context != null && context.eIsProxy()) {
			InternalEObject oldContext = (InternalEObject)context;
			context = eResolveProxy(oldContext);
			if (context != oldContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HistoryModelPackage.VALIDATION_ERROR__CONTEXT, oldContext, context));
			}
		}
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(EObject newContext) {
		EObject oldContext = context;
		context = newContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HistoryModelPackage.VALIDATION_ERROR__CONTEXT, oldContext, context));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Change> getIntroducedByChanges() {
		if (introducedByChanges == null) {
			introducedByChanges = new EObjectResolvingEList<Change>(Change.class, this, HistoryModelPackage.VALIDATION_ERROR__INTRODUCED_BY_CHANGES);
		}
		return introducedByChanges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Change> getResolvedByChanges() {
		if (resolvedByChanges == null) {
			resolvedByChanges = new EObjectResolvingEList<Change>(Change.class, this, HistoryModelPackage.VALIDATION_ERROR__RESOLVED_BY_CHANGES);
		}
		return resolvedByChanges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isResolvedByUndo() {
		return resolvedByUndo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolvedByUndo(boolean newResolvedByUndo) {
		boolean oldResolvedByUndo = resolvedByUndo;
		resolvedByUndo = newResolvedByUndo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HistoryModelPackage.VALIDATION_ERROR__RESOLVED_BY_UNDO, oldResolvedByUndo, resolvedByUndo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ValidationError> getPositivSideEffects() {
		if (positivSideEffects == null) {
			positivSideEffects = new EObjectResolvingEList<ValidationError>(ValidationError.class, this, HistoryModelPackage.VALIDATION_ERROR__POSITIV_SIDE_EFFECTS);
		}
		return positivSideEffects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ValidationError> getNegativSideEffects() {
		if (negativSideEffects == null) {
			negativSideEffects = new EObjectResolvingEList<ValidationError>(ValidationError.class, this, HistoryModelPackage.VALIDATION_ERROR__NEGATIV_SIDE_EFFECTS);
		}
		return negativSideEffects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HistoryModelPackage.VALIDATION_ERROR__PREC:
				if (prec != null)
					msgs = ((InternalEObject)prec).eInverseRemove(this, HistoryModelPackage.VALIDATION_ERROR__SUCC, ValidationError.class, msgs);
				return basicSetPrec((ValidationError)otherEnd, msgs);
			case HistoryModelPackage.VALIDATION_ERROR__SUCC:
				if (succ != null)
					msgs = ((InternalEObject)succ).eInverseRemove(this, HistoryModelPackage.VALIDATION_ERROR__PREC, ValidationError.class, msgs);
				return basicSetSucc((ValidationError)otherEnd, msgs);
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
			case HistoryModelPackage.VALIDATION_ERROR__PREC:
				return basicSetPrec(null, msgs);
			case HistoryModelPackage.VALIDATION_ERROR__SUCC:
				return basicSetSucc(null, msgs);
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
			case HistoryModelPackage.VALIDATION_ERROR__NAME:
				return getName();
			case HistoryModelPackage.VALIDATION_ERROR__INTRODUCED_IN:
				if (resolve) return getIntroducedIn();
				return basicGetIntroducedIn();
			case HistoryModelPackage.VALIDATION_ERROR__RESOLVED_IN:
				if (resolve) return getResolvedIn();
				return basicGetResolvedIn();
			case HistoryModelPackage.VALIDATION_ERROR__MESSAGE:
				return getMessage();
			case HistoryModelPackage.VALIDATION_ERROR__SOURCE:
				return getSource();
			case HistoryModelPackage.VALIDATION_ERROR__SEVERITY:
				return getSeverity();
			case HistoryModelPackage.VALIDATION_ERROR__INTRODUCED:
				return isIntroduced();
			case HistoryModelPackage.VALIDATION_ERROR__RESOLVED:
				return isResolved();
			case HistoryModelPackage.VALIDATION_ERROR__PREC:
				if (resolve) return getPrec();
				return basicGetPrec();
			case HistoryModelPackage.VALIDATION_ERROR__SUCC:
				if (resolve) return getSucc();
				return basicGetSucc();
			case HistoryModelPackage.VALIDATION_ERROR__INVALID_ELEMENT:
				return getInvalidElement();
			case HistoryModelPackage.VALIDATION_ERROR__CONTEXT:
				if (resolve) return getContext();
				return basicGetContext();
			case HistoryModelPackage.VALIDATION_ERROR__INTRODUCED_BY_CHANGES:
				return getIntroducedByChanges();
			case HistoryModelPackage.VALIDATION_ERROR__RESOLVED_BY_CHANGES:
				return getResolvedByChanges();
			case HistoryModelPackage.VALIDATION_ERROR__RESOLVED_BY_UNDO:
				return isResolvedByUndo();
			case HistoryModelPackage.VALIDATION_ERROR__POSITIV_SIDE_EFFECTS:
				return getPositivSideEffects();
			case HistoryModelPackage.VALIDATION_ERROR__NEGATIV_SIDE_EFFECTS:
				return getNegativSideEffects();
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
			case HistoryModelPackage.VALIDATION_ERROR__NAME:
				setName((String)newValue);
				return;
			case HistoryModelPackage.VALIDATION_ERROR__INTRODUCED_IN:
				setIntroducedIn((Version)newValue);
				return;
			case HistoryModelPackage.VALIDATION_ERROR__RESOLVED_IN:
				setResolvedIn((Version)newValue);
				return;
			case HistoryModelPackage.VALIDATION_ERROR__MESSAGE:
				setMessage((String)newValue);
				return;
			case HistoryModelPackage.VALIDATION_ERROR__SOURCE:
				setSource((String)newValue);
				return;
			case HistoryModelPackage.VALIDATION_ERROR__SEVERITY:
				setSeverity((ValidationSeverity)newValue);
				return;
			case HistoryModelPackage.VALIDATION_ERROR__PREC:
				setPrec((ValidationError)newValue);
				return;
			case HistoryModelPackage.VALIDATION_ERROR__SUCC:
				setSucc((ValidationError)newValue);
				return;
			case HistoryModelPackage.VALIDATION_ERROR__CONTEXT:
				setContext((EObject)newValue);
				return;
			case HistoryModelPackage.VALIDATION_ERROR__INTRODUCED_BY_CHANGES:
				getIntroducedByChanges().clear();
				getIntroducedByChanges().addAll((Collection<? extends Change>)newValue);
				return;
			case HistoryModelPackage.VALIDATION_ERROR__RESOLVED_BY_CHANGES:
				getResolvedByChanges().clear();
				getResolvedByChanges().addAll((Collection<? extends Change>)newValue);
				return;
			case HistoryModelPackage.VALIDATION_ERROR__RESOLVED_BY_UNDO:
				setResolvedByUndo((Boolean)newValue);
				return;
			case HistoryModelPackage.VALIDATION_ERROR__POSITIV_SIDE_EFFECTS:
				getPositivSideEffects().clear();
				getPositivSideEffects().addAll((Collection<? extends ValidationError>)newValue);
				return;
			case HistoryModelPackage.VALIDATION_ERROR__NEGATIV_SIDE_EFFECTS:
				getNegativSideEffects().clear();
				getNegativSideEffects().addAll((Collection<? extends ValidationError>)newValue);
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
			case HistoryModelPackage.VALIDATION_ERROR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case HistoryModelPackage.VALIDATION_ERROR__INTRODUCED_IN:
				setIntroducedIn((Version)null);
				return;
			case HistoryModelPackage.VALIDATION_ERROR__RESOLVED_IN:
				setResolvedIn((Version)null);
				return;
			case HistoryModelPackage.VALIDATION_ERROR__MESSAGE:
				setMessage(MESSAGE_EDEFAULT);
				return;
			case HistoryModelPackage.VALIDATION_ERROR__SOURCE:
				setSource(SOURCE_EDEFAULT);
				return;
			case HistoryModelPackage.VALIDATION_ERROR__SEVERITY:
				setSeverity(SEVERITY_EDEFAULT);
				return;
			case HistoryModelPackage.VALIDATION_ERROR__PREC:
				setPrec((ValidationError)null);
				return;
			case HistoryModelPackage.VALIDATION_ERROR__SUCC:
				setSucc((ValidationError)null);
				return;
			case HistoryModelPackage.VALIDATION_ERROR__CONTEXT:
				setContext((EObject)null);
				return;
			case HistoryModelPackage.VALIDATION_ERROR__INTRODUCED_BY_CHANGES:
				getIntroducedByChanges().clear();
				return;
			case HistoryModelPackage.VALIDATION_ERROR__RESOLVED_BY_CHANGES:
				getResolvedByChanges().clear();
				return;
			case HistoryModelPackage.VALIDATION_ERROR__RESOLVED_BY_UNDO:
				setResolvedByUndo(RESOLVED_BY_UNDO_EDEFAULT);
				return;
			case HistoryModelPackage.VALIDATION_ERROR__POSITIV_SIDE_EFFECTS:
				getPositivSideEffects().clear();
				return;
			case HistoryModelPackage.VALIDATION_ERROR__NEGATIV_SIDE_EFFECTS:
				getNegativSideEffects().clear();
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
			case HistoryModelPackage.VALIDATION_ERROR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case HistoryModelPackage.VALIDATION_ERROR__INTRODUCED_IN:
				return introducedIn != null;
			case HistoryModelPackage.VALIDATION_ERROR__RESOLVED_IN:
				return resolvedIn != null;
			case HistoryModelPackage.VALIDATION_ERROR__MESSAGE:
				return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
			case HistoryModelPackage.VALIDATION_ERROR__SOURCE:
				return SOURCE_EDEFAULT == null ? source != null : !SOURCE_EDEFAULT.equals(source);
			case HistoryModelPackage.VALIDATION_ERROR__SEVERITY:
				return severity != SEVERITY_EDEFAULT;
			case HistoryModelPackage.VALIDATION_ERROR__INTRODUCED:
				return isIntroduced() != INTRODUCED_EDEFAULT;
			case HistoryModelPackage.VALIDATION_ERROR__RESOLVED:
				return isResolved() != RESOLVED_EDEFAULT;
			case HistoryModelPackage.VALIDATION_ERROR__PREC:
				return prec != null;
			case HistoryModelPackage.VALIDATION_ERROR__SUCC:
				return succ != null;
			case HistoryModelPackage.VALIDATION_ERROR__INVALID_ELEMENT:
				return invalidElement != null && !invalidElement.isEmpty();
			case HistoryModelPackage.VALIDATION_ERROR__CONTEXT:
				return context != null;
			case HistoryModelPackage.VALIDATION_ERROR__INTRODUCED_BY_CHANGES:
				return introducedByChanges != null && !introducedByChanges.isEmpty();
			case HistoryModelPackage.VALIDATION_ERROR__RESOLVED_BY_CHANGES:
				return resolvedByChanges != null && !resolvedByChanges.isEmpty();
			case HistoryModelPackage.VALIDATION_ERROR__RESOLVED_BY_UNDO:
				return resolvedByUndo != RESOLVED_BY_UNDO_EDEFAULT;
			case HistoryModelPackage.VALIDATION_ERROR__POSITIV_SIDE_EFFECTS:
				return positivSideEffects != null && !positivSideEffects.isEmpty();
			case HistoryModelPackage.VALIDATION_ERROR__NEGATIV_SIDE_EFFECTS:
				return negativSideEffects != null && !negativSideEffects.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @generated NOT
	 */
//	@Override
//	public boolean equals(Object obj) {
//		if(obj instanceof ValidationError){
//			ValidationError validationError = (ValidationError) obj;
//			// replace all object runtime representation in the message
//			boolean equalName = name.equals(validationError.getName());
//			
//			
//			Set<String> invalidElementAIDs = new HashSet<String>();
//			for(EObject invalidElementA : invalidElement){
//				String id = EMFUtil.getXmiId(invalidElementA);
//				if(id!=null)
//					invalidElementAIDs.add(id);
//			}
//			
//			Set<String> invalidElementBIDs = new HashSet<String>();
//			for(EObject invalidElementB : validationError.getInvalidElement()){
//				String id = EMFUtil.getXmiId(invalidElementB);
//				if(id!=null)
//					invalidElementBIDs.add(id);
//			}
//			return equalName && invalidElementAIDs.equals(invalidElementBIDs);
//		}
//		return super.equals(obj);
//	}

	/** (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 * @generated NOT
	 */
//	@Override
//	public int hashCode() {
//		if(name == null)
//			return super.hashCode();
//		Set<String> invalidElementAIDs = new HashSet<String>();
//		for(EObject invalidElementA : getInvalidElement()){
//			invalidElementAIDs.add(EMFUtil.getXmiId(invalidElementA));
//		}
//		//FIXME
//		return (name+invalidElementAIDs).hashCode();
//	}

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
		result.append(", message: ");
		result.append(message);
		result.append(", source: ");
		result.append(source);
		result.append(", severity: ");
		result.append(severity);
		result.append(", resolvedByUndo: ");
		result.append(resolvedByUndo);
		result.append(')');
		return result.toString();
	}

} //ValidationErrorImpl

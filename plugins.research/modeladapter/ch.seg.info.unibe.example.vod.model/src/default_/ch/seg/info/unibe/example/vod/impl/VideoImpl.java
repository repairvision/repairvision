/**
 */
package default_.ch.seg.info.unibe.example.vod.impl;

import default_.ch.seg.info.unibe.example.vod.Server;
import default_.ch.seg.info.unibe.example.vod.Video;
import default_.ch.seg.info.unibe.example.vod.VodPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Video</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link default_.ch.seg.info.unibe.example.vod.impl.VideoImpl#getMain <em>Main</em>}</li>
 *   <li>{@link default_.ch.seg.info.unibe.example.vod.impl.VideoImpl#getMirror <em>Mirror</em>}</li>
 *   <li>{@link default_.ch.seg.info.unibe.example.vod.impl.VideoImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VideoImpl extends MinimalEObjectImpl.Container implements Video {
	/**
	 * The cached value of the '{@link #getMain() <em>Main</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMain()
	 * @generated
	 * @ordered
	 */
	protected Server main;

	/**
	 * The cached value of the '{@link #getMirror() <em>Mirror</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMirror()
	 * @generated
	 * @ordered
	 */
	protected Server mirror;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VideoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VodPackage.Literals.VIDEO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Server getMain() {
		if (main != null && main.eIsProxy()) {
			InternalEObject oldMain = (InternalEObject)main;
			main = (Server)eResolveProxy(oldMain);
			if (main != oldMain) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VodPackage.VIDEO__MAIN, oldMain, main));
			}
		}
		return main;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Server basicGetMain() {
		return main;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMain(Server newMain) {
		Server oldMain = main;
		main = newMain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VodPackage.VIDEO__MAIN, oldMain, main));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Server getMirror() {
		if (mirror != null && mirror.eIsProxy()) {
			InternalEObject oldMirror = (InternalEObject)mirror;
			mirror = (Server)eResolveProxy(oldMirror);
			if (mirror != oldMirror) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VodPackage.VIDEO__MIRROR, oldMirror, mirror));
			}
		}
		return mirror;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Server basicGetMirror() {
		return mirror;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMirror(Server newMirror) {
		Server oldMirror = mirror;
		mirror = newMirror;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VodPackage.VIDEO__MIRROR, oldMirror, mirror));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VodPackage.VIDEO__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VodPackage.VIDEO__MAIN:
				if (resolve) return getMain();
				return basicGetMain();
			case VodPackage.VIDEO__MIRROR:
				if (resolve) return getMirror();
				return basicGetMirror();
			case VodPackage.VIDEO__NAME:
				return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case VodPackage.VIDEO__MAIN:
				setMain((Server)newValue);
				return;
			case VodPackage.VIDEO__MIRROR:
				setMirror((Server)newValue);
				return;
			case VodPackage.VIDEO__NAME:
				setName((String)newValue);
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
			case VodPackage.VIDEO__MAIN:
				setMain((Server)null);
				return;
			case VodPackage.VIDEO__MIRROR:
				setMirror((Server)null);
				return;
			case VodPackage.VIDEO__NAME:
				setName(NAME_EDEFAULT);
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
			case VodPackage.VIDEO__MAIN:
				return main != null;
			case VodPackage.VIDEO__MIRROR:
				return mirror != null;
			case VodPackage.VIDEO__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(')');
		return result.toString();
	}

} //VideoImpl

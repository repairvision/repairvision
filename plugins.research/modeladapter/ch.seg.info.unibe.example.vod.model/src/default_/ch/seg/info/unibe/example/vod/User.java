/**
 */
package default_.ch.seg.info.unibe.example.vod;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link default_.ch.seg.info.unibe.example.vod.User#getOpen <em>Open</em>}</li>
 *   <li>{@link default_.ch.seg.info.unibe.example.vod.User#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see default_.ch.seg.info.unibe.example.vod.VodPackage#getUser()
 * @model
 * @generated
 */
public interface User extends EObject {
	/**
	 * Returns the value of the '<em><b>Open</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Open</em>' reference.
	 * @see #setOpen(Video)
	 * @see default_.ch.seg.info.unibe.example.vod.VodPackage#getUser_Open()
	 * @model
	 * @generated
	 */
	Video getOpen();

	/**
	 * Sets the value of the '{@link default_.ch.seg.info.unibe.example.vod.User#getOpen <em>Open</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Open</em>' reference.
	 * @see #getOpen()
	 * @generated
	 */
	void setOpen(Video value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see default_.ch.seg.info.unibe.example.vod.VodPackage#getUser_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link default_.ch.seg.info.unibe.example.vod.User#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // User

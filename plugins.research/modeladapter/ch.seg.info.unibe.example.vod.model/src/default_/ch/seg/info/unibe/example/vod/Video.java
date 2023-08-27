/**
 */
package default_.ch.seg.info.unibe.example.vod;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Video</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link default_.ch.seg.info.unibe.example.vod.Video#getMain <em>Main</em>}</li>
 *   <li>{@link default_.ch.seg.info.unibe.example.vod.Video#getMirror <em>Mirror</em>}</li>
 *   <li>{@link default_.ch.seg.info.unibe.example.vod.Video#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see default_.ch.seg.info.unibe.example.vod.VodPackage#getVideo()
 * @model
 * @generated
 */
public interface Video extends EObject {
	/**
	 * Returns the value of the '<em><b>Main</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main</em>' reference.
	 * @see #setMain(Server)
	 * @see default_.ch.seg.info.unibe.example.vod.VodPackage#getVideo_Main()
	 * @model
	 * @generated
	 */
	Server getMain();

	/**
	 * Sets the value of the '{@link default_.ch.seg.info.unibe.example.vod.Video#getMain <em>Main</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main</em>' reference.
	 * @see #getMain()
	 * @generated
	 */
	void setMain(Server value);

	/**
	 * Returns the value of the '<em><b>Mirror</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mirror</em>' reference.
	 * @see #setMirror(Server)
	 * @see default_.ch.seg.info.unibe.example.vod.VodPackage#getVideo_Mirror()
	 * @model
	 * @generated
	 */
	Server getMirror();

	/**
	 * Sets the value of the '{@link default_.ch.seg.info.unibe.example.vod.Video#getMirror <em>Mirror</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mirror</em>' reference.
	 * @see #getMirror()
	 * @generated
	 */
	void setMirror(Server value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see default_.ch.seg.info.unibe.example.vod.VodPackage#getVideo_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link default_.ch.seg.info.unibe.example.vod.Video#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Video

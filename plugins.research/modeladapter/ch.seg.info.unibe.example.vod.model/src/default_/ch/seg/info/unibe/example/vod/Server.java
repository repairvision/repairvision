/**
 */
package default_.ch.seg.info.unibe.example.vod;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Server</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link default_.ch.seg.info.unibe.example.vod.Server#getVideos <em>Videos</em>}</li>
 *   <li>{@link default_.ch.seg.info.unibe.example.vod.Server#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see default_.ch.seg.info.unibe.example.vod.VodPackage#getServer()
 * @model
 * @generated
 */
public interface Server extends EObject {
	/**
	 * Returns the value of the '<em><b>Videos</b></em>' reference list.
	 * The list contents are of type {@link default_.ch.seg.info.unibe.example.vod.Video}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Videos</em>' reference list.
	 * @see default_.ch.seg.info.unibe.example.vod.VodPackage#getServer_Videos()
	 * @model
	 * @generated
	 */
	EList<Video> getVideos();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see default_.ch.seg.info.unibe.example.vod.VodPackage#getServer_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link default_.ch.seg.info.unibe.example.vod.Server#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Server

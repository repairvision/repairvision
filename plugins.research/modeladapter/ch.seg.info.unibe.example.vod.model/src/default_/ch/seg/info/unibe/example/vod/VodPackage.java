/**
 */
package default_.ch.seg.info.unibe.example.vod;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see default_.ch.seg.info.unibe.example.vod.VodFactory
 * @model kind="package"
 * @generated
 */
public interface VodPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "vod";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "ch.seg.info.unibe.example.vod/default.ch.seg.info.unibe.example.vod";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "vod";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VodPackage eINSTANCE = default_.ch.seg.info.unibe.example.vod.impl.VodPackageImpl.init();

	/**
	 * The meta object id for the '{@link default_.ch.seg.info.unibe.example.vod.impl.ServerImpl <em>Server</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see default_.ch.seg.info.unibe.example.vod.impl.ServerImpl
	 * @see default_.ch.seg.info.unibe.example.vod.impl.VodPackageImpl#getServer()
	 * @generated
	 */
	int SERVER = 0;

	/**
	 * The feature id for the '<em><b>Videos</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__VIDEOS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__NAME = 1;

	/**
	 * The number of structural features of the '<em>Server</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Server</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link default_.ch.seg.info.unibe.example.vod.impl.UserImpl <em>User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see default_.ch.seg.info.unibe.example.vod.impl.UserImpl
	 * @see default_.ch.seg.info.unibe.example.vod.impl.VodPackageImpl#getUser()
	 * @generated
	 */
	int USER = 1;

	/**
	 * The feature id for the '<em><b>Open</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__OPEN = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__NAME = 1;

	/**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link default_.ch.seg.info.unibe.example.vod.impl.VideoImpl <em>Video</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see default_.ch.seg.info.unibe.example.vod.impl.VideoImpl
	 * @see default_.ch.seg.info.unibe.example.vod.impl.VodPackageImpl#getVideo()
	 * @generated
	 */
	int VIDEO = 2;

	/**
	 * The feature id for the '<em><b>Main</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO__MAIN = 0;

	/**
	 * The feature id for the '<em><b>Mirror</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO__MIRROR = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO__NAME = 2;

	/**
	 * The number of structural features of the '<em>Video</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Video</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link default_.ch.seg.info.unibe.example.vod.Server <em>Server</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Server</em>'.
	 * @see default_.ch.seg.info.unibe.example.vod.Server
	 * @generated
	 */
	EClass getServer();

	/**
	 * Returns the meta object for the reference list '{@link default_.ch.seg.info.unibe.example.vod.Server#getVideos <em>Videos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Videos</em>'.
	 * @see default_.ch.seg.info.unibe.example.vod.Server#getVideos()
	 * @see #getServer()
	 * @generated
	 */
	EReference getServer_Videos();

	/**
	 * Returns the meta object for the attribute '{@link default_.ch.seg.info.unibe.example.vod.Server#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see default_.ch.seg.info.unibe.example.vod.Server#getName()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_Name();

	/**
	 * Returns the meta object for class '{@link default_.ch.seg.info.unibe.example.vod.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User</em>'.
	 * @see default_.ch.seg.info.unibe.example.vod.User
	 * @generated
	 */
	EClass getUser();

	/**
	 * Returns the meta object for the reference '{@link default_.ch.seg.info.unibe.example.vod.User#getOpen <em>Open</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Open</em>'.
	 * @see default_.ch.seg.info.unibe.example.vod.User#getOpen()
	 * @see #getUser()
	 * @generated
	 */
	EReference getUser_Open();

	/**
	 * Returns the meta object for the attribute '{@link default_.ch.seg.info.unibe.example.vod.User#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see default_.ch.seg.info.unibe.example.vod.User#getName()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Name();

	/**
	 * Returns the meta object for class '{@link default_.ch.seg.info.unibe.example.vod.Video <em>Video</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Video</em>'.
	 * @see default_.ch.seg.info.unibe.example.vod.Video
	 * @generated
	 */
	EClass getVideo();

	/**
	 * Returns the meta object for the reference '{@link default_.ch.seg.info.unibe.example.vod.Video#getMain <em>Main</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Main</em>'.
	 * @see default_.ch.seg.info.unibe.example.vod.Video#getMain()
	 * @see #getVideo()
	 * @generated
	 */
	EReference getVideo_Main();

	/**
	 * Returns the meta object for the reference '{@link default_.ch.seg.info.unibe.example.vod.Video#getMirror <em>Mirror</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mirror</em>'.
	 * @see default_.ch.seg.info.unibe.example.vod.Video#getMirror()
	 * @see #getVideo()
	 * @generated
	 */
	EReference getVideo_Mirror();

	/**
	 * Returns the meta object for the attribute '{@link default_.ch.seg.info.unibe.example.vod.Video#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see default_.ch.seg.info.unibe.example.vod.Video#getName()
	 * @see #getVideo()
	 * @generated
	 */
	EAttribute getVideo_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	VodFactory getVodFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link default_.ch.seg.info.unibe.example.vod.impl.ServerImpl <em>Server</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see default_.ch.seg.info.unibe.example.vod.impl.ServerImpl
		 * @see default_.ch.seg.info.unibe.example.vod.impl.VodPackageImpl#getServer()
		 * @generated
		 */
		EClass SERVER = eINSTANCE.getServer();

		/**
		 * The meta object literal for the '<em><b>Videos</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVER__VIDEOS = eINSTANCE.getServer_Videos();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__NAME = eINSTANCE.getServer_Name();

		/**
		 * The meta object literal for the '{@link default_.ch.seg.info.unibe.example.vod.impl.UserImpl <em>User</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see default_.ch.seg.info.unibe.example.vod.impl.UserImpl
		 * @see default_.ch.seg.info.unibe.example.vod.impl.VodPackageImpl#getUser()
		 * @generated
		 */
		EClass USER = eINSTANCE.getUser();

		/**
		 * The meta object literal for the '<em><b>Open</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER__OPEN = eINSTANCE.getUser_Open();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__NAME = eINSTANCE.getUser_Name();

		/**
		 * The meta object literal for the '{@link default_.ch.seg.info.unibe.example.vod.impl.VideoImpl <em>Video</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see default_.ch.seg.info.unibe.example.vod.impl.VideoImpl
		 * @see default_.ch.seg.info.unibe.example.vod.impl.VodPackageImpl#getVideo()
		 * @generated
		 */
		EClass VIDEO = eINSTANCE.getVideo();

		/**
		 * The meta object literal for the '<em><b>Main</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIDEO__MAIN = eINSTANCE.getVideo_Main();

		/**
		 * The meta object literal for the '<em><b>Mirror</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIDEO__MIRROR = eINSTANCE.getVideo_Mirror();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIDEO__NAME = eINSTANCE.getVideo_Name();

	}

} //VodPackage

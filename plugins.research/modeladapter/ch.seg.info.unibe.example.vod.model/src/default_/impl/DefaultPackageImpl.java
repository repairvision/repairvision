/**
 */
package default_.impl;

import default_.DefaultFactory;
import default_.DefaultPackage;

import default_.ch.seg.info.unibe.example.vod.VodPackage;

import default_.ch.seg.info.unibe.example.vod.impl.VodPackageImpl;

import default_.root;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DefaultPackageImpl extends EPackageImpl implements DefaultPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rootEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see default_.DefaultPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DefaultPackageImpl() {
		super(eNS_URI, DefaultFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link DefaultPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DefaultPackage init() {
		if (isInited) return (DefaultPackage)EPackage.Registry.INSTANCE.getEPackage(DefaultPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredDefaultPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		DefaultPackageImpl theDefaultPackage = registeredDefaultPackage instanceof DefaultPackageImpl ? (DefaultPackageImpl)registeredDefaultPackage : new DefaultPackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(VodPackage.eNS_URI);
		VodPackageImpl theVodPackage = (VodPackageImpl)(registeredPackage instanceof VodPackageImpl ? registeredPackage : VodPackage.eINSTANCE);

		// Create package meta-data objects
		theDefaultPackage.createPackageContents();
		theVodPackage.createPackageContents();

		// Initialize created meta-data
		theDefaultPackage.initializePackageContents();
		theVodPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDefaultPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DefaultPackage.eNS_URI, theDefaultPackage);
		return theDefaultPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getroot() {
		return rootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getroot_ContainedElements() {
		return (EReference)rootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultFactory getDefaultFactory() {
		return (DefaultFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		rootEClass = createEClass(ROOT);
		createEReference(rootEClass, ROOT__CONTAINED_ELEMENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		VodPackage theVodPackage = (VodPackage)EPackage.Registry.INSTANCE.getEPackage(VodPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theVodPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(rootEClass, root.class, "root", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getroot_ContainedElements(), ecorePackage.getEObject(), null, "containedElements", null, 0, -1, root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //DefaultPackageImpl

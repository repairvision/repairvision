/**
 */
package org.sidiff.graphpattern.profile.henshin_extension.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.sidiff.graphpattern.profile.henshin_extension.AttributeExtension;
import org.sidiff.graphpattern.profile.henshin_extension.EdgeExtension;
import org.sidiff.graphpattern.profile.henshin_extension.HenshinExtensionFactory;
import org.sidiff.graphpattern.profile.henshin_extension.HenshinExtensionPackage;
import org.sidiff.graphpattern.profile.henshin_extension.NodeExtension;
import org.sidiff.graphpattern.profile.henshin_extension.RuleExtension;
import org.sidiff.graphpattern.profile.henshin_extension.SubGraph;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HenshinExtensionFactoryImpl extends EFactoryImpl implements HenshinExtensionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static HenshinExtensionFactory init() {
		try {
			HenshinExtensionFactory theHenshinExtensionFactory = (HenshinExtensionFactory)EPackage.Registry.INSTANCE.getEFactory(HenshinExtensionPackage.eNS_URI);
			if (theHenshinExtensionFactory != null) {
				return theHenshinExtensionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new HenshinExtensionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HenshinExtensionFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case HenshinExtensionPackage.RULE_EXTENSION: return createRuleExtension();
			case HenshinExtensionPackage.SUB_GRAPH: return createSubGraph();
			case HenshinExtensionPackage.NODE_EXTENSION: return createNodeExtension();
			case HenshinExtensionPackage.EDGE_EXTENSION: return createEdgeExtension();
			case HenshinExtensionPackage.ATTRIBUTE_EXTENSION: return createAttributeExtension();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RuleExtension createRuleExtension() {
		RuleExtensionImpl ruleExtension = new RuleExtensionImpl();
		return ruleExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SubGraph createSubGraph() {
		SubGraphImpl subGraph = new SubGraphImpl();
		return subGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NodeExtension createNodeExtension() {
		NodeExtensionImpl nodeExtension = new NodeExtensionImpl();
		return nodeExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EdgeExtension createEdgeExtension() {
		EdgeExtensionImpl edgeExtension = new EdgeExtensionImpl();
		return edgeExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AttributeExtension createAttributeExtension() {
		AttributeExtensionImpl attributeExtension = new AttributeExtensionImpl();
		return attributeExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HenshinExtensionPackage getHenshinExtensionPackage() {
		return (HenshinExtensionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static HenshinExtensionPackage getPackage() {
		return HenshinExtensionPackage.eINSTANCE;
	}

} //HenshinExtensionFactoryImpl

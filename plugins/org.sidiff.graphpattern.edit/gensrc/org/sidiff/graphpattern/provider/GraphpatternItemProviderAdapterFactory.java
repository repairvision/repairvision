/**
 */
package org.sidiff.graphpattern.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.sidiff.graphpattern.util.GraphpatternAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphpatternItemProviderAdapterFactory extends GraphpatternAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphpatternItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
		supportedTypes.add(IItemColorProvider.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sidiff.graphpattern.GraphPattern} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphPatternItemProvider graphPatternItemProvider;

	/**
	 * This creates an adapter for a {@link org.sidiff.graphpattern.GraphPattern}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGraphPatternAdapter() {
		if (graphPatternItemProvider == null) {
			graphPatternItemProvider = new GraphPatternItemProvider(this);
		}

		return graphPatternItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sidiff.graphpattern.NodePattern} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodePatternItemProvider nodePatternItemProvider;

	/**
	 * This creates an adapter for a {@link org.sidiff.graphpattern.NodePattern}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNodePatternAdapter() {
		if (nodePatternItemProvider == null) {
			nodePatternItemProvider = new NodePatternItemProvider(this);
		}

		return nodePatternItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sidiff.graphpattern.EdgePattern} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EdgePatternItemProvider edgePatternItemProvider;

	/**
	 * This creates an adapter for a {@link org.sidiff.graphpattern.EdgePattern}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEdgePatternAdapter() {
		if (edgePatternItemProvider == null) {
			edgePatternItemProvider = new EdgePatternItemProvider(this);
		}

		return edgePatternItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sidiff.graphpattern.AttributePattern} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributePatternItemProvider attributePatternItemProvider;

	/**
	 * This creates an adapter for a {@link org.sidiff.graphpattern.AttributePattern}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAttributePatternAdapter() {
		if (attributePatternItemProvider == null) {
			attributePatternItemProvider = new AttributePatternItemProvider(this);
		}

		return attributePatternItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sidiff.graphpattern.Bundle} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BundleItemProvider bundleItemProvider;

	/**
	 * This creates an adapter for a {@link org.sidiff.graphpattern.Bundle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBundleAdapter() {
		if (bundleItemProvider == null) {
			bundleItemProvider = new BundleItemProvider(this);
		}

		return bundleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sidiff.graphpattern.EObjectList} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EObjectListItemProvider eObjectListItemProvider;

	/**
	 * This creates an adapter for a {@link org.sidiff.graphpattern.EObjectList}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEObjectListAdapter() {
		if (eObjectListItemProvider == null) {
			eObjectListItemProvider = new EObjectListItemProvider(this);
		}

		return eObjectListItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sidiff.graphpattern.DependencyGraph} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DependencyGraphItemProvider dependencyGraphItemProvider;

	/**
	 * This creates an adapter for a {@link org.sidiff.graphpattern.DependencyGraph}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDependencyGraphAdapter() {
		if (dependencyGraphItemProvider == null) {
			dependencyGraphItemProvider = new DependencyGraphItemProvider(this);
		}

		return dependencyGraphItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sidiff.graphpattern.DependencyNode} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DependencyNodeItemProvider dependencyNodeItemProvider;

	/**
	 * This creates an adapter for a {@link org.sidiff.graphpattern.DependencyNode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDependencyNodeAdapter() {
		if (dependencyNodeItemProvider == null) {
			dependencyNodeItemProvider = new DependencyNodeItemProvider(this);
		}

		return dependencyNodeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sidiff.graphpattern.DependencyEdge} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DependencyEdgeItemProvider dependencyEdgeItemProvider;

	/**
	 * This creates an adapter for a {@link org.sidiff.graphpattern.DependencyEdge}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDependencyEdgeAdapter() {
		if (dependencyEdgeItemProvider == null) {
			dependencyEdgeItemProvider = new DependencyEdgeItemProvider(this);
		}

		return dependencyEdgeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sidiff.graphpattern.Association} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssociationItemProvider associationItemProvider;

	/**
	 * This creates an adapter for a {@link org.sidiff.graphpattern.Association}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAssociationAdapter() {
		if (associationItemProvider == null) {
			associationItemProvider = new AssociationItemProvider(this);
		}

		return associationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sidiff.graphpattern.Stereotype} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StereotypeItemProvider stereotypeItemProvider;

	/**
	 * This creates an adapter for a {@link org.sidiff.graphpattern.Stereotype}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStereotypeAdapter() {
		if (stereotypeItemProvider == null) {
			stereotypeItemProvider = new StereotypeItemProvider(this);
		}

		return stereotypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sidiff.graphpattern.Assignment} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssignmentItemProvider assignmentItemProvider;

	/**
	 * This creates an adapter for a {@link org.sidiff.graphpattern.Assignment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAssignmentAdapter() {
		if (assignmentItemProvider == null) {
			assignmentItemProvider = new AssignmentItemProvider(this);
		}

		return assignmentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sidiff.graphpattern.ObjectBinding} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectBindingItemProvider objectBindingItemProvider;

	/**
	 * This creates an adapter for a {@link org.sidiff.graphpattern.ObjectBinding}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createObjectBindingAdapter() {
		if (objectBindingItemProvider == null) {
			objectBindingItemProvider = new ObjectBindingItemProvider(this);
		}

		return objectBindingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sidiff.graphpattern.ValueBinding} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValueBindingItemProvider valueBindingItemProvider;

	/**
	 * This creates an adapter for a {@link org.sidiff.graphpattern.ValueBinding}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createValueBindingAdapter() {
		if (valueBindingItemProvider == null) {
			valueBindingItemProvider = new ValueBindingItemProvider(this);
		}

		return valueBindingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sidiff.graphpattern.SubGraph} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubGraphItemProvider subGraphItemProvider;

	/**
	 * This creates an adapter for a {@link org.sidiff.graphpattern.SubGraph}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSubGraphAdapter() {
		if (subGraphItemProvider == null) {
			subGraphItemProvider = new SubGraphItemProvider(this);
		}

		return subGraphItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sidiff.graphpattern.Profile} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProfileItemProvider profileItemProvider;

	/**
	 * This creates an adapter for a {@link org.sidiff.graphpattern.Profile}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createProfileAdapter() {
		if (profileItemProvider == null) {
			profileItemProvider = new ProfileItemProvider(this);
		}

		return profileItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sidiff.graphpattern.Pattern} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternItemProvider patternItemProvider;

	/**
	 * This creates an adapter for a {@link org.sidiff.graphpattern.Pattern}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPatternAdapter() {
		if (patternItemProvider == null) {
			patternItemProvider = new PatternItemProvider(this);
		}

		return patternItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sidiff.graphpattern.Parameter} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterItemProvider parameterItemProvider;

	/**
	 * This creates an adapter for a {@link org.sidiff.graphpattern.Parameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createParameterAdapter() {
		if (parameterItemProvider == null) {
			parameterItemProvider = new ParameterItemProvider(this);
		}

		return parameterItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (graphPatternItemProvider != null) graphPatternItemProvider.dispose();
		if (nodePatternItemProvider != null) nodePatternItemProvider.dispose();
		if (edgePatternItemProvider != null) edgePatternItemProvider.dispose();
		if (attributePatternItemProvider != null) attributePatternItemProvider.dispose();
		if (bundleItemProvider != null) bundleItemProvider.dispose();
		if (patternItemProvider != null) patternItemProvider.dispose();
		if (parameterItemProvider != null) parameterItemProvider.dispose();
		if (eObjectListItemProvider != null) eObjectListItemProvider.dispose();
		if (dependencyGraphItemProvider != null) dependencyGraphItemProvider.dispose();
		if (dependencyNodeItemProvider != null) dependencyNodeItemProvider.dispose();
		if (dependencyEdgeItemProvider != null) dependencyEdgeItemProvider.dispose();
		if (associationItemProvider != null) associationItemProvider.dispose();
		if (stereotypeItemProvider != null) stereotypeItemProvider.dispose();
		if (assignmentItemProvider != null) assignmentItemProvider.dispose();
		if (objectBindingItemProvider != null) objectBindingItemProvider.dispose();
		if (valueBindingItemProvider != null) valueBindingItemProvider.dispose();
		if (subGraphItemProvider != null) subGraphItemProvider.dispose();
		if (profileItemProvider != null) profileItemProvider.dispose();
	}

}

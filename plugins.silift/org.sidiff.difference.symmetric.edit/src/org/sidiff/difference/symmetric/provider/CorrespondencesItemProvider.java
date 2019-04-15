package org.sidiff.difference.symmetric.provider;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.matching.model.Correspondence;
import org.sidiff.matching.model.MatchingModelFactory;
import org.sidiff.matching.model.MatchingModelPackage;

public class CorrespondencesItemProvider extends TransientSymmetricDifferenceItemProvider{

	/**
	 * this class is not created in the usual way,
	 * the constructor have to add them to the eAdapters list
	 * @param adapterFactory
	 * @param symmetricDifference
	 * @generated NOT
	 */
	public CorrespondencesItemProvider(AdapterFactory adapterFactory,
			SymmetricDifference symmetricDifference) {
		super(adapterFactory, symmetricDifference);
	}
	
	
	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * @generated NOT
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object){
		if (childrenFeatures == null){
			super.getChildrenFeatures(object);
			childrenFeatures.add(MatchingModelPackage.Literals.MATCHING__CORRESPONDENCES);
		}
		return childrenFeatures;
	}

	
	/**
	 * This returns unusedchangeset.gif.
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		Correspondence c = difference.getMatching().getCorrespondences().get(0);

		EcoreItemProviderAdapterFactory factory = new
				EcoreItemProviderAdapterFactory();
		if(factory.isFactoryForType(IItemLabelProvider.class)){
			IItemLabelProvider labelProvider = (IItemLabelProvider)
					factory.adapt(c, IItemLabelProvider.class);
			if(labelProvider != null){
				return labelProvider.getImage(object);
			}
		}

		return null;		
	}
	
	
	/**
	 * This returns the label text for the adapted class.
	 * @generated NOT
	 */
	@Override
	public String getText(Object object){
		return "Correspondences (" + difference.getMatching().getCorrespondences().size() + ")";
	}
	
	
	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * @generated NOT
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object){
		super.collectNewChildDescriptors(newChildDescriptors, object);
		newChildDescriptors.add (createChildParameter(MatchingModelPackage.Literals.MATCHING__CORRESPONDENCES,
			MatchingModelFactory.eINSTANCE.createCorrespondence()));
	}
	
	
	/**
	 * returns the appropriate transient item provider
	 * @generated NOT
	 */
	@Override
	public Object getParent(Object object){
		Object difference = super.getParent(object);
		SymmetricDifferenceItemProvider symmetricDifferenceItemProvider 
		= (SymmetricDifferenceItemProvider) adapterFactory.adapt (
				difference, IEditingDomainItemProvider.class);
		
		return symmetricDifferenceItemProvider != null ?
				symmetricDifferenceItemProvider.getCorrespondences() : null;

	}

	
	/**
	 * 
	 * @generated NOT
	 */
	@Override
	public ResourceLocator getResourceLocator(){
		return  SymmetricEditPlugin.INSTANCE;
	}
}

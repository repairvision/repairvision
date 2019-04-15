package org.sidiff.difference.symmetric.provider;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.sidiff.difference.symmetric.SymmetricDifference;

/**
 * This is the item provider adapter for a transient object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated NOT
 */
public class TransientSymmetricDifferenceItemProvider extends ItemProviderAdapter
implements 
IEditingDomainItemProvider,
IStructuredItemContentProvider,
ITreeItemContentProvider,
IItemLabelProvider,
IItemPropertySource
{

	protected SymmetricDifference difference;
	
	/**
	 * providers (e.g. UnusedChangeSetsItemProvider), which extend this class are not created in the usual way, 
	 * the constructor have to add them to the eAdapters list
	 * @generated NOT
	 */
	public TransientSymmetricDifferenceItemProvider(
			AdapterFactory adapterFactory, SymmetricDifference symmetricDifference) {
		super(adapterFactory);
		symmetricDifference.eAdapters().add(this);
		difference = symmetricDifference;
	}

	
	/**
	 * returns the model object from which the children
	 * will be retrieved
	 * @generated NOT
	 */
	@Override
	public Collection<?> getChildren(Object object){
		return super.getChildren(target);
	}
	
	
	/**
	 * @generated NOT
	 */
	@Override
	public Object getParent(Object object){
		return target;
	}
	
	
	/**
	 * @generated NOT
	 */
	 public Command createCommand(Object object, EditingDomain domain, Class<? extends Command> commandClass, CommandParameter commandParameter){
		return UnexecutableCommand.INSTANCE;
	}
	
}

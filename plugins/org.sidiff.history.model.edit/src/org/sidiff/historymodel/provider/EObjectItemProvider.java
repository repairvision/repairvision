package org.sidiff.historymodel.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.sidiff.revision.common.emf.EMFStorage;

public class EObjectItemProvider extends ItemProviderAdapter {

	public EObjectItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.provider.EObjectItemProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object object) {
		if(object instanceof EObject){
			return deriveQualifiedName((EObject)object);
		}
		return super.getText(object);
	}

	private String getLabelSignature(EObject element) {
		
		EStructuralFeature nameFeature = element.eClass().getEStructuralFeature("name");
		 String nameValue = "";
		if (nameFeature != null) {
			 nameValue = (String) element.eGet(nameFeature);
		}
		
		return nameValue +  EMFStorage.getXmiId(element);
	}
	
	private String deriveQualifiedName(EObject element){
		String elementName = getLabelSignature(element);

		while (element.eContainer() != null){
			element = element.eContainer();
			String containerName = getLabelSignature(element);
			elementName = containerName + "." + elementName;
		}

		return elementName;
	}
}

package org.sidiff.generic.matcher.uuid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLParserPoolImpl;
import org.sidiff.revision.common.emf.XMIIDResourceImpl;

public class UUIDResource extends XMIIDResourceImpl {
	
	/**
	 * Initialize (unloaded) resource.
	 * 
	 * @param uri
	 */
	public UUIDResource(URI uri) {
		super(uri);
		
		Map<Object, Object> saveOptions = getDefaultSaveOptions();
		saveOptions.put(XMLResource.OPTION_CONFIGURATION_CACHE, Boolean.TRUE);
		saveOptions.put(XMLResource.OPTION_USE_CACHED_LOOKUP_TABLE, new ArrayList<>());
		
		Map<Object, Object> loadOptions = getDefaultLoadOptions();
		loadOptions.put(XMLResource.OPTION_DEFER_ATTACHMENT, Boolean.TRUE);
		loadOptions.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE);
		loadOptions.put(XMLResource.OPTION_USE_DEPRECATED_METHODS, Boolean.TRUE);
		loadOptions.put(XMLResource.OPTION_USE_PARSER_POOL, new XMLParserPoolImpl());
		loadOptions.put(XMLResource.OPTION_USE_XML_NAME_TO_FEATURE_MAP, new HashMap<>());

		// 15.5.2. Caching Intrinsic IDs
		setIntrinsicIDToEObjectMap(new HashMap<>());
	}
	
	/**
	 * Initialize and loads the resource into a resource set.
	 * 
	 * @param uri
	 * @param resourceSet
	 */
	public UUIDResource(URI uri, ResourceSet resourceSet) {
		this(uri);
		
		try {
			resourceSet.getResources().add(this);
			load(resourceSet.getLoadOptions());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected boolean useIDs() {
		return true;
	}
	
	@Override
	protected boolean useUUIDs() {
		return true;
	}
	
	@Override
	protected boolean assignIDsWhileLoading() {
		return true;
	}
	
	@Override
	public String getID(EObject eObject) {
		String uuid = null;
		
		if (!isDynamic(eObject)) {
			uuid = super.getID(eObject);
			
			// Generate new UUID:
			if (uuid == null) {
				uuid = EcoreUtil.generateUUID();
				getEObjectToIDMap().put(eObject, uuid);
				getIDToEObjectMap().put(uuid, eObject);
			}
		}
		
		return uuid;
	}
	
	/**
	 * Check if the element is created dynamically, i.e. the containment
	 * reference is transient, volatile or derived.
	 * 
	 * @param element
	 *            The element to test.
	 * @return <code>true</code> if the element is created dynamically;
	 *         <code>false</code> otherwise
	 */
	public static boolean isDynamic(EObject element) {
		EReference containment = element.eContainmentFeature();
		
		if ((containment != null) 
				&& (containment.isTransient() 
						|| containment.isVolatile() 
						|| containment.isDerived()
						// FIXME: How to handle the eGenericSuperTypes reference? Is dynamic until a type argument will be added!
						|| containment.equals(EcorePackage.eINSTANCE.getEClass_EGenericSuperTypes()))) {
			return true;
		}
		
		return false;
	}
}

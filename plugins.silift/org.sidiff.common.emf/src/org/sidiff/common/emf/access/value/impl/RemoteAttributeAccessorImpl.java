package org.sidiff.common.emf.access.value.impl;

import org.eclipse.emf.ecore.*;
import org.sidiff.common.emf.EMFAdapter;
import org.sidiff.common.emf.access.EMFMetaAccess;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.common.emf.access.path.EMFPath;
import org.sidiff.common.emf.access.value.RemoteAttribute;
import org.sidiff.common.emf.access.value.RemoteAttributeAccessor;
import org.sidiff.common.emf.annotation.AnnotateableElement;

/**
 * Implementation of a EMF-RemoteEAttributeAccessor Engine.
 * 
 * Syntax:
 * {EMFPath}@{EAttributeName}
 * 
 * The Syntax of the EMFPath depends on the used EMFPath-Engine. 
 * 
 * Examples:
 * 
 *  "IncommingReference.myref#myobjects[justthebest]/Parent#*@Attributename"
 *  "IncommingReference.myref#myobjects[justthebest]@Attributename"
 *  
 *  @see org.sidiff.common.emf.access.path.axis
 *  @see org.sidiff.common.emf.access.value.RemoteAttributeAccessor
 *  
 * @author Maik Schmidt
 *
 */
public class RemoteAttributeAccessorImpl implements RemoteAttributeAccessor {

	private final static String PATH_EATTRIBUTE_SEPERATOR ="@";
	private final static String PATH_ANNOTATION_SEPERATOR ="$";

	@SuppressWarnings("unchecked")
	@Override
	public <T> T computeRemoteAttributeValue(EObject context, RemoteAttribute remoteAttribute) {
		assert(remoteAttribute instanceof RemoteAttributeImpl) : "Illegal argument:"+remoteAttribute;
		
		RemoteAttributeImpl descriptor = (RemoteAttributeImpl)remoteAttribute;
	
		EObject result = EMFModelAccess.evaluatePath(context, descriptor.path, false);
		if(result!=null){
			if(descriptor.remoteAttribute!=null){
				return (T)result.eGet(descriptor.remoteAttribute);
			} else {
				AnnotateableElement ao = EMFAdapter.INSTANCE.adapt(result, AnnotateableElement.class);
				return (T)ao.getAnnotation(descriptor.annotationName, Object.class);
			}
		} 
		return null;
	}

	@Override
	public EAttribute getEAttribute(RemoteAttribute remoteAttribute) {
		assert(remoteAttribute instanceof RemoteAttributeImpl) : "Illegal argument:"+remoteAttribute;
		
		return ((RemoteAttributeImpl)remoteAttribute).remoteAttribute;
	}

	@Override
	public RemoteAttribute translateRemoteAttribute(EClass eClass, String attributePath) {
		
		RemoteAttribute result = null;
		
		if(attributePath.indexOf(PATH_EATTRIBUTE_SEPERATOR)!=-1){
			// EAttribute 
			EMFPath emfPath = null;
			EAttribute attribute = null;
			
			String pathAttribute[] = attributePath.split(PATH_EATTRIBUTE_SEPERATOR);
			if(pathAttribute.length==2){
				emfPath = EMFMetaAccess.translatePath(eClass, pathAttribute[0]);
				EStructuralFeature feature = EMFMetaAccess.inferResultType(emfPath).getEStructuralFeature(pathAttribute[1]);
				if(feature!=null&&feature instanceof EAttribute){
					attribute = (EAttribute)feature;
				} else {
					throw new IllegalArgumentException("Syntax Error in Remote Expression:"+pathAttribute[1]);
				}
			} else {
				throw new IllegalArgumentException("Syntax Error in remote eAttribute expression:"+attributePath);
			}
			result = new RemoteAttributeImpl(emfPath,attribute);
			
		} else if (attributePath.indexOf(PATH_ANNOTATION_SEPERATOR)!=-1){
			// Annotation
			EMFPath emfPath = null;
			String attribute = null;
			
			String pathAttribute[] = attributePath.split("\\"+PATH_ANNOTATION_SEPERATOR);
			if(pathAttribute.length==2){
				emfPath = EMFMetaAccess.translatePath(eClass, pathAttribute[0]);
				attribute = pathAttribute[1];
			} else {
				throw new IllegalArgumentException("Syntax Error in Remote Expression:"+pathAttribute[1]);
			}
			result = new RemoteAttributeImpl(emfPath,attribute);
			
		} else {
			throw new IllegalArgumentException("Syntax Error in remote eAttribute expression:"+attributePath);
		}
		return result;
	}

}

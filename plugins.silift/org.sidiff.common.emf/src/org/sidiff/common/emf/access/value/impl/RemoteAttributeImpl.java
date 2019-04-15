package org.sidiff.common.emf.access.value.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.sidiff.common.emf.access.path.EMFPath;
import org.sidiff.common.emf.access.value.RemoteAttribute;

public class RemoteAttributeImpl implements RemoteAttribute {

	EAttribute remoteAttribute= null;
	EMFPath path = null;
	String annotationName = null;
	
	public RemoteAttributeImpl(EMFPath path,EAttribute attribute) {
		assert(path!=null&&attribute!=null) : "Remote Attribute needs path and attribute! null?";
		
		this.path = path;
		this.remoteAttribute = attribute;
	}
	
	public RemoteAttributeImpl(EMFPath path,String annotationName) {
		assert(path!=null&&annotationName!=null) : "Remote Attribute needs path and attribute! null?";
		
		this.path = path;
		this.annotationName = annotationName;
	}
}

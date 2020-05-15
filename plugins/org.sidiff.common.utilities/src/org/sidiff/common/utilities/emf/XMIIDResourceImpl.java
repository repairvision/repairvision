package org.sidiff.common.utilities.emf;


import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

public class XMIIDResourceImpl extends XMIResourceImpl{

	public XMIIDResourceImpl(URI uri){
		super(uri);
	}
	
	
	@Override
	protected boolean useUUIDs() {
		return true;
	}
}
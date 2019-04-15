//TODO kann rausfliegen, wird derzeit aber in SEV (PG2009) benutzt
package org.sidiff.common.emf.datatypes;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;

@Deprecated
public interface DataTypeRegistryAccessor {
	
	public int getConceptualDataType(Class<?> clazz);
	
	public int getConceptualDataType(EAttribute attribute);
	
	public int getConceptualDataType(EDataType dataType);
	
	public boolean isNumericType(EAttribute attribute);
	
	public boolean isLetterType(EAttribute attribute);
		
}

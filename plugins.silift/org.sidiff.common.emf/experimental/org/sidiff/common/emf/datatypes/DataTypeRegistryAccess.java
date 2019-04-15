//TODO kann rausfliegen, wird derzeit aber in SEV (PG2009) benutzt
package org.sidiff.common.emf.datatypes;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;

@Deprecated
public class DataTypeRegistryAccess {

	private static final DataTypeRegistryAccessor registryAccessor = new DataTypeRegistryAccessorImpl();

	public static int getConceptualDataType(Class<?> clazz) {
		return registryAccessor.getConceptualDataType(clazz);
	}

	public static int getConceptualDataType(EAttribute attribute) {
		return registryAccessor.getConceptualDataType(attribute);
	}

	public static int getConceptualDataType(EDataType dataType) {
		return registryAccessor.getConceptualDataType(dataType);
	}

	public static boolean isNumericType(EAttribute attribute) {
		return registryAccessor.isNumericType(attribute);
	}

	/**
	 * Checks if the attribute is of a letter type (String or Character). <br/>
	 * The function returns <code>true</code> if the attribute is of conceptual type 
	 * {@link ConceptualDataTypes#STRING} or {@link ConceptualDataTypes#STRING}.
	 * 
	 * @param attribute
	 *            the attribute whose type should be checked
	 * @return <code>true</code> for letter types.
	 */
	public static boolean isLetterType(EAttribute attribute) {
		return registryAccessor.isLetterType(attribute);
	}
}

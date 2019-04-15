//TODO kann rausfliegen, wird derzeit aber in SEV (PG2009) benutzt
package org.sidiff.common.emf.datatypes;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;

@Deprecated
public class DataTypeRegistryAccessorImpl implements DataTypeRegistryAccessor {

	private final Map<EDataType, Integer> ecoreMap = new HashMap<EDataType, Integer>();

	private final Map<Class<?>, Integer> javaMap = new HashMap<Class<?>, Integer>();

	public DataTypeRegistryAccessorImpl() {
		for (int i = 0; i < DataTypeRegistry.TYPE_MAPPING.length; i++) {
			ecoreMap.put((EDataType) DataTypeRegistry.TYPE_MAPPING[i][2], (Integer) DataTypeRegistry.TYPE_MAPPING[i][0]);
			javaMap.put((Class<?>) DataTypeRegistry.TYPE_MAPPING[i][1], (Integer) DataTypeRegistry.TYPE_MAPPING[i][0]);
		}
	}

	@Override
	public int getConceptualDataType(Class<?> clazz) {
		return javaMap.get(clazz);
	}

	@Override
	public int getConceptualDataType(EAttribute attribute) {
		return getConceptualDataType(attribute.getEAttributeType());
	}

	@Override
	public int getConceptualDataType(EDataType dataType) {
		return ecoreMap.get(dataType);
	}

	@Override
	public boolean isNumericType(EAttribute attribute) {
		return getConceptualDataType(attribute) < 100;
	}

	@Override
	public boolean isLetterType(EAttribute attribute) {
		return getConceptualDataType(attribute) == ConceptualDataTypes.STRING 
			|| getConceptualDataType(attribute) == ConceptualDataTypes.CHARACTER;
	}

}

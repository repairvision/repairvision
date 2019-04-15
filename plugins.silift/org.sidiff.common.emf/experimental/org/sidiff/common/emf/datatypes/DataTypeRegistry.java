//TODO kann rausfliegen, wird derzeit aber in SEV (PG2009) benutzt
package org.sidiff.common.emf.datatypes;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import org.eclipse.emf.ecore.EcorePackage;

@Deprecated
public abstract class DataTypeRegistry {
	
	public static final Object[][] TYPE_MAPPING = new Object[][] {
		{ConceptualDataTypes.STRING, String.class, EcorePackage.eINSTANCE.getEString()},
		{ConceptualDataTypes.BIG_DECIMAL, BigDecimal.class, EcorePackage.eINSTANCE.getEBigDecimal()},
		{ConceptualDataTypes.BIG_INTEGER, BigInteger.class, EcorePackage.eINSTANCE.getEBigInteger()},
		{ConceptualDataTypes.BOOLEAN, Boolean.class, EcorePackage.eINSTANCE.getEBoolean()},
		{ConceptualDataTypes.BOOLEAN, Boolean.class, EcorePackage.eINSTANCE.getEBooleanObject()},
		{ConceptualDataTypes.BYTE, Byte.class, EcorePackage.eINSTANCE.getEByte()},
		{ConceptualDataTypes.BYTE_ARRAY, Byte[].class, EcorePackage.eINSTANCE.getEByteArray()},
		{ConceptualDataTypes.BYTE, Byte.class, EcorePackage.eINSTANCE.getEByteObject()},
		{ConceptualDataTypes.CHARACTER, Character.class, EcorePackage.eINSTANCE.getEChar()},
		{ConceptualDataTypes.CHARACTER, Character.class, EcorePackage.eINSTANCE.getECharacterObject()},
		{ConceptualDataTypes.DATE, Date.class, EcorePackage.eINSTANCE.getEDate()},
		{ConceptualDataTypes.DOUBLE, Double.class, EcorePackage.eINSTANCE.getEDouble()},
		{ConceptualDataTypes.DOUBLE, Double.class, EcorePackage.eINSTANCE.getEDoubleObject()},
		{ConceptualDataTypes.FLOAT, Float.class, EcorePackage.eINSTANCE.getEFloat()},
		{ConceptualDataTypes.FLOAT, Float.class, EcorePackage.eINSTANCE.getEFloatObject()},
		{ConceptualDataTypes.INTEGER, Integer.class, EcorePackage.eINSTANCE.getEInt()},
		{ConceptualDataTypes.INTEGER, Integer.class, EcorePackage.eINSTANCE.getEIntegerObject()},
		{ConceptualDataTypes.LONG, Long.class, EcorePackage.eINSTANCE.getELong()},
		{ConceptualDataTypes.LONG, Long.class, EcorePackage.eINSTANCE.getELongObject()},
		{ConceptualDataTypes.SHORT, Short.class, EcorePackage.eINSTANCE.getEShort()},
		{ConceptualDataTypes.SHORT, Short.class, EcorePackage.eINSTANCE.getEShortObject()}
		};
	
}

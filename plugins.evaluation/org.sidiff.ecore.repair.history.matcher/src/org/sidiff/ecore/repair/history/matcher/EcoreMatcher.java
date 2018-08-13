package org.sidiff.ecore.repair.history.matcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.collections.ValueMap;
import org.sidiff.matcher.LocalSignatureMatcher;

public class EcoreMatcher extends LocalSignatureMatcher {
	
	private ValueMap<String, EObject> correspondenceMap = null;
	
	@Override
	public boolean isResourceSetCapable() {
		return true;
	}
	
	@Override
	public String getKey() {
		return getClass().getName();
	}

	@Override
	protected void matchSignatures() {
		correspondenceMap = new ValueMap<String, EObject>();
		ValueMap<String, EObject> unmatchedAMap = new ValueMap<String, EObject>();
		ValueMap<String, EObject> unmatchedBMap = new ValueMap<String, EObject>();

		Iterator<Resource> iterator = getModels().iterator();
		Resource resourceA = iterator.next();
		Resource resourceB = iterator.next();
		
		for (Resource coevoluationA : resourceA.getResourceSet().getResources()) {
			unmatchedAMap.insert(getSignatures().get(coevoluationA));
		}
		
		for (Resource coevoluationB : resourceB.getResourceSet().getResources()) {
			unmatchedBMap.insert(getSignatures().get(coevoluationB));
		}

		// match full qualified names first
		matchSignatures(correspondenceMap, unmatchedAMap, unmatchedBMap);

		// no we unroll the qualified names of the unmatched EClasses
		Map<String, Collection<EClass>> unmatchedEClassesAMap = unrollQuallifiedNameOfEClasses(unmatchedAMap);
		Map<String, Collection<EClass>> unmatchedEClassesBMap = unrollQuallifiedNameOfEClasses(unmatchedBMap);

		List<String> sortedKeysA = new ArrayList<String>(unmatchedEClassesAMap.keySet());
		Collections.sort(sortedKeysA, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.length() - o1.length();
			}
		});

		List<String> sortedKeysB = new ArrayList<String>(unmatchedEClassesBMap.keySet());
		Collections.sort(sortedKeysB, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.length() - o1.length();
			}
		});

		for (String keyA : sortedKeysA) {
			for (String keyB : sortedKeysB) {
				if (keyA.equals(keyB)) {
					for (EClass eClass : unmatchedEClassesAMap.get(keyA)) {
						correspondenceMap.put(eClass, keyA);
						for (EStructuralFeature eStructuralFeature : eClass.getEStructuralFeatures()) {
							String key_eStructuralFeature = keyA + "$" + getLabelSignature(eStructuralFeature);
							correspondenceMap.put(eStructuralFeature, key_eStructuralFeature);
						}
					}
					for (EClass eClass : unmatchedEClassesBMap.get(keyB)) {
						correspondenceMap.put(eClass, keyB);
						for (EStructuralFeature eStructuralFeature : eClass.getEStructuralFeatures()) {
							String key_eStructuralFeature = keyB + "$" + getLabelSignature(eStructuralFeature);
							correspondenceMap.put(eStructuralFeature, key_eStructuralFeature);
						}
					}
					cleanMap(unmatchedEClassesAMap);
					cleanMap(unmatchedEClassesBMap);
				}
			}
		}

		for (String id : correspondenceMap.getFilledValues(2)) {
			if (correspondenceMap.getObjects(id).size() >= 2) {
				getCorrespondencesService().addCorrespondence(
						correspondenceMap.getObjects(id).toArray(new EObject[correspondenceMap.getObjects(id).size()]));
			} else {
				System.out.println(correspondenceMap.getObjects(id));
			}
		}

	}

	private boolean matchSignatures(ValueMap<String, EObject> correspondenceMap,
			ValueMap<String, EObject> unmatchedAMap, ValueMap<String, EObject> unmatchedBMap) {

		int i = correspondenceMap.getValues().size();

		correspondenceMap.insert(unmatchedAMap);
		correspondenceMap.insert(unmatchedBMap);

		for (String id : unmatchedAMap.getValues()) {
			if (correspondenceMap.getObjects(id).size() < 2) {
				correspondenceMap.remove(id);
			}
		}

		for (String id : unmatchedBMap.getValues()) {
			if (correspondenceMap.getObjects(id).size() < 2) {
				correspondenceMap.remove(id);
			}

		}

		for (String id : correspondenceMap.getValues()) {
			unmatchedAMap.remove(id);
			unmatchedBMap.remove(id);
		}

		return i < correspondenceMap.getValues().size();
	}

	@Override
	public String getName() {
		return "Ecore Matcher";
	}

	@Override
	public String getDescription() {
		return "Ecore Matcher";
	}

	@Override
	protected String getElementSignature(EObject element) {
		return deriveQualifiedName(element);
	}

	@Override
	protected boolean considerCandidatesOnly() {
		return true;
	}

	private String getLabelSignature(EObject element) {
		EStructuralFeature nameFeature = element.eClass().getEStructuralFeature("name");
		
		StringBuilder signature = new StringBuilder();

		if (nameFeature != null) {
			Object nameValue = element.eGet(nameFeature);

			if (nameValue != null && nameValue instanceof String && !((String) nameValue).isEmpty()) {
				
				// elementName
				signature.append(nameValue);

				// operationName(TypeA,TypeB,...)
				if (element instanceof EOperation) {
					List<EParameter> parameters = ((EOperation) element).getEParameters();
					signature.append("(");

					for (EParameter parameter : parameters) {
						signature.append(parameter.getEType().getName());

						if (parameter != parameters.get(parameters.size() - 1)) {
							signature.append(",");
						}
					}

					signature.append(")");
				}

				// elementName[Type]
				signature.append("[");
				signature.append(element.eClass().getName());
				signature.append("]");
			}
			
			return signature.toString();
		}
		
		// No name found:
		
		if (element instanceof EAnnotation) {
			signature.append("[");
			signature.append(element.eClass().getName());
			signature.append("]");
			signature.append(((EAnnotation) element).getSource());
			signature.append("{");
			
			EMap<String, String>  details = ((EAnnotation) element).getDetails();
			
			for (Entry<String, String> detail : details) {
				signature.append(detail.getKey());
				signature.append("->");
				signature.append(detail.getValue());
				
				if (detail != details.get(details.size() - 1)) {
					signature.append(",");
				}
			}
			
			signature.append("}");
			
			return signature.toString();
		} else if (element instanceof EStringToStringMapEntryImpl) {
			EStringToStringMapEntryImpl entry = (EStringToStringMapEntryImpl) element;
			
			signature.append("[");
			signature.append(entry.eClass().getName());
			signature.append("]");
			
			signature.append("{");
			signature.append(entry.getKey());
			signature.append("->");
			signature.append(entry.getValue());
			signature.append("}");
			
			return signature.toString();
		} else if (element instanceof EGenericType) {
			EGenericType genericElement = (EGenericType) element;
			
			signature.append("[");
			signature.append(genericElement.eClass().getName());
			signature.append("]");
			
			if (genericElement.getEClassifier() != null) {
				signature.append("EClassifier[");
				signature.append(getLabelSignature(genericElement.getEClassifier()));
				signature.append("]");
			}
			
			if (genericElement.getELowerBound() != null) {
				signature.append("ELowerBound[");
				signature.append(getLabelSignature(genericElement.getELowerBound()));
				signature.append("]");
			}
			
			if (genericElement.getERawType() != null) {
				signature.append("ERawType[");
				signature.append(getLabelSignature(genericElement.getERawType()));
				signature.append("]");
			} 
			
			if (genericElement.getETypeParameter() != null) {
				signature.append("ETypeParameter[");
				signature.append(getLabelSignature(genericElement.getETypeParameter()));
				signature.append("]");
			}
			
			if (!genericElement.getETypeArguments().isEmpty()) {
				signature.append("ETypeArguments[");
				List<EGenericType> types = genericElement.getETypeArguments();
				
				for (EGenericType type : types) {
					signature.append(getLabelSignature(type));
					
					if (type != types.get(types.size() - 1)) {
						signature.append(",");
					}
				}
				
				signature.append("]");
			}
			
			if (genericElement.getEUpperBound() != null) {
				signature.append("EUpperBound[");
				signature.append(getLabelSignature(genericElement.getEUpperBound()));
				signature.append("]");
			}
			
			return signature.toString();
		} else {
			// To-string signature: Remove Object ID if present:
			signature.append(element.toString().replaceFirst("@.*?\\s", ""));
			return signature.toString();
		}
	}

	private String deriveQualifiedName(EObject element) {
		StringBuilder elementName = new StringBuilder(getLabelSignature(element));

		while (elementName != null && element.eContainer() != null) {
			element = element.eContainer();
			String containerName = getLabelSignature(element);

			if (containerName != null) {
				elementName.append("$" + containerName);
			}
		}

		elementName.append("$" + element.eResource().getURI().lastSegment());
		return elementName.toString();
	}

	private Map<String, Collection<EClass>> unrollQuallifiedNameOfEClasses(ValueMap<String, EObject> valueMap) {
		Map<String, Collection<EClass>> map = new HashMap<String, Collection<EClass>>();
		
		for (EObject eObject : valueMap.getValuedObjects()) {
			if (eObject instanceof EClass) {
				EClass eClass = (EClass) eObject;
				String idEClass = valueMap.getValue(eClass);
				
				while (!idEClass.isEmpty()) {
					if (!map.containsKey(idEClass)) {
						map.put(idEClass, new HashSet<EClass>());
					}
					map.get(idEClass).add(eClass);
					if (idEClass.indexOf("$") > 0) {
						idEClass = idEClass.substring(idEClass.indexOf("$") + 1);
					} else {
						idEClass = "";
					}
				}
			}
		}
		return map;
	}

	private void cleanMap(Map<String, Collection<EClass>> map) {
		for (String key : map.keySet()) {
			for (Iterator<EClass> iterator = map.get(key).iterator(); iterator.hasNext();) {
				EClass eClass = iterator.next();
				if (correspondenceMap.containsObject(eClass)) {
					iterator.remove();
				}
			}
		}
	}
}

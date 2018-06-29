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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.collections.ValueMap;
import org.sidiff.matcher.LocalSignatureMatcher;

public class EcoreMatcher extends LocalSignatureMatcher{
	private ValueMap<String, EObject> correspondenceMap = null;
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
		unmatchedAMap.insert(getSignatures().get(resourceA));
		Resource resourceB = iterator.next();
		unmatchedBMap.insert(getSignatures().get(resourceB));
		
		//match full qualified names first
		matchSignatures(correspondenceMap, unmatchedAMap, unmatchedBMap);
		
		// no we unroll the qualified names of the unmatched EClasses
		Map<String, Collection<EClass>> unmatchedEClassesAMap = unrollQuallifiedNameOfEClasses(unmatchedAMap);
		Map<String, Collection<EClass>> unmatchedEClassesBMap = unrollQuallifiedNameOfEClasses(unmatchedBMap);
	
		List<String> sortedKeysA = new ArrayList<String>(unmatchedEClassesAMap.keySet());
		Collections.sort(sortedKeysA, new Comparator<String>() {

		
			@Override
			public int compare(String o1, String o2) {
				return o2.length()-o1.length();
			}
		});
		
		List<String> sortedKeysB = new ArrayList<String>(unmatchedEClassesBMap.keySet());
		Collections.sort(sortedKeysB, new Comparator<String>() {

		
			@Override
			public int compare(String o1, String o2) {
				return o2.length()-o1.length();
			}
		});
		
		for(String keyA : sortedKeysA){
			for(String keyB : sortedKeysB){
				if(keyA.equals(keyB)){
					for(EClass eClass : unmatchedEClassesAMap.get(keyA)){	
						correspondenceMap.put(eClass, keyA);
						for(EStructuralFeature eStructuralFeature : eClass.getEStructuralFeatures()){
							String key_eStructuralFeature = keyA + "$" +getLabelSignature(eStructuralFeature);
							correspondenceMap.put(eStructuralFeature, key_eStructuralFeature);
						}
					}
					for(EClass eClass : unmatchedEClassesBMap.get(keyB)){	
						correspondenceMap.put(eClass, keyB);
						for(EStructuralFeature eStructuralFeature : eClass.getEStructuralFeatures()){
							String key_eStructuralFeature = keyB + "$" +getLabelSignature(eStructuralFeature);
							correspondenceMap.put(eStructuralFeature, key_eStructuralFeature);
						}
					}
					cleanMap(unmatchedEClassesAMap);
					cleanMap(unmatchedEClassesBMap);
				}
			}
		}
		
		
		
		for(String id : correspondenceMap.getFilledValues(2)){
			if(correspondenceMap.getObjects(id).size()>=2){
				getCorrespondencesService().addCorrespondence(correspondenceMap.getObjects(id).toArray
						(new EObject[correspondenceMap.getObjects(id).size()]));
			}
			else{
				System.out.println(correspondenceMap.getObjects(id));
			}
		}
		
		
	}
	
	private boolean matchSignatures(ValueMap<String, EObject> correspondenceMap, ValueMap<String, EObject> unmatchedAMap, ValueMap<String, EObject> unmatchedBMap){
		
		
		int i = correspondenceMap.getValues().size();
		
		correspondenceMap.insert(unmatchedAMap);
		correspondenceMap.insert(unmatchedBMap);
		
		
		for(String id : unmatchedAMap.getValues()){
			if(correspondenceMap.getObjects(id).size()<2){
				correspondenceMap.remove(id);
			}
		}
		
		for(String id : unmatchedBMap.getValues()){
			if(correspondenceMap.getObjects(id).size()<2){
				correspondenceMap.remove(id);
			}
			
		}
		
		for(String id : correspondenceMap.getValues()){
			unmatchedAMap.remove(id);
			unmatchedBMap.remove(id);
		}
		
		return i<correspondenceMap.getValues().size();
	}

	@Override
	public String getName() {
		return "Ecore Matcher";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getElementSignature(EObject element) {

		return deriveQualifiedName(element);
		
	}

	@Override
	protected boolean considerCandidatesOnly() {
		// TODO Auto-generated method stub
		return true;
	}



	private String getLabelSignature(EObject element) {
		
		EStructuralFeature nameFeature = element.eClass().getEStructuralFeature("name");
		
		if (nameFeature != null) {
			Object nameValue = element.eGet(nameFeature);
			
			if (nameValue != null && nameValue instanceof String && !((String)nameValue).isEmpty()) {
				return (String) nameValue + "[" + element.eClass().getName() + "]";
			}
		}
		
		// No name found:

		// Remove Object ID if present:
		return element.toString().replaceFirst("@.*?\\s", "");

	}
	
	private String deriveQualifiedName(EObject element){
		String elementName = getLabelSignature(element);

		while (elementName != null && element.eContainer() != null){
			element = element.eContainer();
			String containerName = getLabelSignature(element);
			
			if (containerName != null) {
				elementName = containerName + "$" + elementName;
			} else {
				elementName = null;
			}
		}

		return elementName;
	}
	
	private Map<String, Collection<EClass>> unrollQuallifiedNameOfEClasses(ValueMap<String, EObject> valueMap) {
		Map<String, Collection<EClass>> map = new HashMap<String, Collection<EClass>>();
		for(EObject eObject : valueMap.getValuedObjects()){
			if(eObject instanceof EClass){
				EClass eClass = (EClass)eObject;
				String idEClass = valueMap.getValue(eClass);
				while(!idEClass.isEmpty()){
					if(!map.containsKey(idEClass)){
						map.put(idEClass, new HashSet<EClass>());
					}
					map.get(idEClass).add(eClass);
					if(idEClass.indexOf("$")>0){
						idEClass = idEClass.substring(idEClass.indexOf("$")+1);
					}else{
						idEClass="";
					}
				};
			}
		}
		return map;
	}
	
	private void cleanMap(Map<String,Collection<EClass>> map){
		for(String key : map.keySet()){
			for (Iterator<EClass> iterator = map.get(key).iterator(); iterator.hasNext();) {
				EClass eClass = iterator.next();
				if(correspondenceMap.containsObject(eClass)){
					iterator.remove();
				}
			}
		}
	}
}

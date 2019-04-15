package org.sidiff.difference.symmetric.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.AttributeValueChange;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.difference.symmetric.SymmetricDifference;

public class ChangeIndex {

	public Map<EClass, Integer> addObject = new HashMap<EClass, Integer>();
	public Map<EClass, Integer> removeObject = new HashMap<EClass, Integer>();
	public Map<String, Integer> addReference = new HashMap<String, Integer>();
	public Map<String, Integer> removeReference = new HashMap<String, Integer>();
	public Map<String, Integer> attrValueChange = new HashMap<String, Integer>();

	public ChangeIndex(SymmetricDifference difference) {
		for (Change change : difference.getChanges()) {

			// AddObject
			if (change instanceof AddObject) {
				EClass type = ((AddObject) change).getObj().eClass();
				if (addObject.containsKey(type)) {
					addObject.put(type, addObject.get(type) + 1);
				} else {
					addObject.put(type, 1);
				}
				continue;
			}

			// RemoveObject
			if (change instanceof RemoveObject) {
				EClass type = ((RemoveObject) change).getObj().eClass();
				if (removeObject.containsKey(type)) {
					removeObject.put(type, removeObject.get(type) + 1);
				} else {
					removeObject.put(type, 1);
				}
				continue;
			}

			// AddReference
			if (change instanceof AddReference) {
				String type = ((AddReference) change).getType().getName();
				if (addReference.containsKey(type)) {
					addReference.put(type, addReference.get(type) + 1);
				} else {
					addReference.put(type, 1);
				}
				continue;
			}
			
			// RemoveReference
			if (change instanceof RemoveReference) {
				String type = ((RemoveReference) change).getType().getName();
				if (removeReference.containsKey(type)) {
					removeReference.put(type, removeReference.get(type) + 1);
				} else {
					removeReference.put(type, 1);
				}
				continue;
			}
			
			// AttrValueChange
			if (change instanceof AttributeValueChange) {
				String type = ((AttributeValueChange) change).getType().getName();
				if (attrValueChange.containsKey(type)) {
					attrValueChange.put(type, attrValueChange.get(type) + 1);
				} else {
					attrValueChange.put(type, 1);
				}
				continue;
			}
		}
	}
}

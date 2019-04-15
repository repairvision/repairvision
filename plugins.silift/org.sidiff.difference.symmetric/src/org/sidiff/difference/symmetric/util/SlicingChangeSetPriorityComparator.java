package org.sidiff.difference.symmetric.util;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.AttributeValueChange;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.SemanticChangeSet;

public class SlicingChangeSetPriorityComparator extends ChangeSetPriorityComparator {
	
	private Set<EObject> slicingCriteria;

	public SlicingChangeSetPriorityComparator(Set<EObject> slicingCriteria) {
		super();
		this.slicingCriteria = slicingCriteria;
	}

	@Override
	public int compare(SemanticChangeSet cs1, SemanticChangeSet cs2) {
		int i = 0;
		if(cs1.getName().equals(cs2.getName())){
			for(Change change : cs1.getChanges()){
				if(change instanceof AddObject){
					AddObject addObject = (AddObject) change;
					i += slicingCriteria.contains(addObject.getObj()) ? 1 : 0;
				}else if(change instanceof AddReference){
					AddReference addReference = (AddReference) change;
					i += slicingCriteria.contains(addReference.getSrc()) ? 1 : 0;
					i += slicingCriteria.contains(addReference.getTgt()) ? 1 : 0;
				}else if(change instanceof AttributeValueChange){
					AttributeValueChange attrValChange = (AttributeValueChange) change;
					i += slicingCriteria.contains(attrValChange.getObjB()) ? 1 : 0;
				}
			}
			
			int j = 0;
			for(Change change : cs2.getChanges()){
				if(change instanceof AddObject){
					AddObject addObject = (AddObject) change;
					j += slicingCriteria.contains(addObject.getObj()) ? 1 : 0;
				}else if(change instanceof AddReference){
					AddReference addReference = (AddReference) change;
					j += slicingCriteria.contains(addReference.getSrc()) ? 1 : 0;
					j += slicingCriteria.contains(addReference.getTgt()) ? 1 : 0;
				}else if(change instanceof AttributeValueChange){
					AttributeValueChange attrValChange = (AttributeValueChange) change;
					j += slicingCriteria.contains(attrValChange.getObjB()) ? 1 : 0;
				}
			}
			
			return j-i;
		}
		return super.compare(cs1, cs2);
	}
	
	public Set<EObject> getSlicingCriteria(){
		return slicingCriteria;
	}

}

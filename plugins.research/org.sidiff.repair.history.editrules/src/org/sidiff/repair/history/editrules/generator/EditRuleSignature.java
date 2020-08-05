package org.sidiff.repair.history.editrules.generator;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.revision.difference.AddObject;
import org.sidiff.revision.difference.AddReference;
import org.sidiff.revision.difference.AttributeValueChange;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.difference.RemoveObject;
import org.sidiff.revision.difference.RemoveReference;
import org.sidiff.revision.impact.changetree.scope.AttributeScope;

public class EditRuleSignature {
	
	private static final String SEPARATOR = "#";
	
	private List<String> signatures = new ArrayList<>();
	
	private String signature;

	public EditRuleSignature(EditRule editRule) {
		
		for (Change change : editRule.getDifferenceSlice().getChanges()) {
			signatures.add(getChangeSignature(editRule, change));
		}
		
		for (Correspondence correspondence : editRule.getDifferenceSlice().getCorrespondences()) {
			signatures.add(getCorrespondenceSignature(editRule, correspondence));
		}
		
		Collections.sort(signatures);
	}
	
	private static String getChangeSignature(EditRule editRule, Change change) {
		StringBuffer changeSignature = new StringBuffer();
			
		if (change instanceof RemoveObject) {
			changeSignature.append(SEPARATOR);
			changeSignature.append(change.eClass().getName());
			changeSignature.append(SEPARATOR);
			changeSignature.append(getClassSignature(((RemoveObject) change).getObj()));
			changeSignature.append(SEPARATOR);
			changeSignature.append(
					getAttributesSignature(((RemoveObject) change).getObj(), editRule.getFragmentA().getEqualityTests()));
			changeSignature.append(SEPARATOR);
		}

		else if (change instanceof RemoveReference) {
			changeSignature.append(SEPARATOR);
			changeSignature.append(change.eClass().getName());
			changeSignature.append(SEPARATOR);
			changeSignature.append(getClassSignature(((RemoveReference) change).getSrc()));
			changeSignature.append(SEPARATOR);
			changeSignature.append(getClassSignature(((RemoveReference) change).getTgt()));
			changeSignature.append(SEPARATOR);
			changeSignature.append(getClassSignature(((RemoveReference) change).getType()));
			changeSignature.append(SEPARATOR);
		}

		else if (change instanceof AddObject) {
			changeSignature.append(SEPARATOR);
			changeSignature.append(change.eClass().getName());
			changeSignature.append(SEPARATOR);
			changeSignature.append(getClassSignature(((AddObject) change).getObj()));
			changeSignature.append(SEPARATOR);
			changeSignature.append(
					getAttributesSignature(((AddObject) change).getObj(), editRule.getFragmentB().getEqualityTests()));
			changeSignature.append(SEPARATOR);
		}

		else if (change instanceof AddReference) {
			changeSignature.append(SEPARATOR);
			changeSignature.append(change.eClass().getName());
			changeSignature.append(SEPARATOR);
			changeSignature.append(getClassSignature(((AddReference) change).getSrc()));
			changeSignature.append(SEPARATOR);
			changeSignature.append(getClassSignature(((AddReference) change).getTgt()));
			changeSignature.append(SEPARATOR);
			changeSignature.append(getClassSignature(((AddReference) change).getType()));
			changeSignature.append(SEPARATOR);
		}

		else if (change instanceof AttributeValueChange) {
			changeSignature.append(SEPARATOR);
			changeSignature.append(change.eClass().getName());
			changeSignature.append(SEPARATOR);
			changeSignature.append(getClassSignature(((AttributeValueChange) change).getObjA()));
			changeSignature.append(SEPARATOR);
			changeSignature.append(getClassSignature(((AttributeValueChange) change).getObjB()));
			changeSignature.append(SEPARATOR);
			changeSignature.append(getClassSignature(((AttributeValueChange) change).getType()));
			changeSignature.append(SEPARATOR);
		}
		
		return changeSignature.toString();
	}
	
	private static String getCorrespondenceSignature(EditRule editRule, Correspondence correspondence) {
		StringBuffer correspondenceSignature = new StringBuffer();
		
		correspondenceSignature.append(SEPARATOR);
		correspondenceSignature.append(correspondence.eClass().getName());
		correspondenceSignature.append(SEPARATOR);
		correspondenceSignature.append(getClassSignature(correspondence.getMatchedA()));
		correspondenceSignature.append(SEPARATOR);
		correspondenceSignature.append(
				getAttributesSignature(correspondence.getMatchedA(), editRule.getFragmentA().getEqualityTests()));
		correspondenceSignature.append(SEPARATOR);
		correspondenceSignature.append(getClassSignature(correspondence.getMatchedB()));
		correspondenceSignature.append(SEPARATOR);
		correspondenceSignature.append(
				getAttributesSignature(correspondence.getMatchedB(), editRule.getFragmentB().getEqualityTests()));
		correspondenceSignature.append(SEPARATOR);
		
		return correspondenceSignature.toString();
	}
	
	private static String getAttributesSignature(EObject obj, List<AttributeScope> attributes) {
//		StringBuffer attributeSignature = new StringBuffer();
		List<String> attributeSignatures = new ArrayList<>();
		
		for (AttributeScope attribute : attributes) {
			if (attribute.getObject() == obj) {
				attributeSignatures.add(getAttributeSignature(attribute));
			}
		}

		Collections.sort(attributeSignatures);
		StringBuffer attributeSignature = new StringBuffer();
		attributeSignatures.forEach(attributeSignature::append);
		return attributeSignature.toString();
	}
	
	private static String getAttributeSignature(AttributeScope attribute) {
		StringBuffer attributeSignature = new StringBuffer();
		
		attributeSignature.append(SEPARATOR);
		attributeSignature.append(getClassSignature(attribute.getObject()));
		attributeSignature.append(SEPARATOR);
		attributeSignature.append(attribute.getType().getName());
		attributeSignature.append(SEPARATOR);
		attributeSignature.append(attribute.getValue().toString());
		attributeSignature.append(SEPARATOR);
		
		return attributeSignature.toString();
	}
	
	private static String getClassSignature(EObject obj) {
		return obj.eClass().getInstanceClassName();
	}
	
	public List<String> getSignatures() {
		return Collections.unmodifiableList(signatures);
	}
	
	public String getSignature() {
		
		if (signature == null) {
			StringBuffer signatureBuffer = new StringBuffer();
			signatures.forEach(signatureBuffer::append);
			signature = signatureBuffer.toString();
		}
		return signature;
	}
	
	public String hashValue() {
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(getSignature().getBytes("UTF-8"));
			return new BigInteger(1 ,md.digest()).toString(16);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return null; 
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof EditRuleSignature) {
			return ((EditRuleSignature) obj).getSignature().equals(getSignature());
		}
		return false;
	}
}

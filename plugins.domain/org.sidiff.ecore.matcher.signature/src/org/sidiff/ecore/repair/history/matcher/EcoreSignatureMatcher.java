package org.sidiff.ecore.repair.history.matcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.revision.common.emf.document.Scope;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.matcher.IMatcher;
import org.sidiff.revision.difference.matcher.util.MatcherUtil;

public class EcoreSignatureMatcher implements IMatcher {
	
	private Set<Resource> resourceSetA = new HashSet<>();
	
	private Set<Resource> resourceSetB = new HashSet<>();
	
	private boolean allowsAmbiguousSignature = false;
	
	public boolean isAllowsAmbiguousSignature() {
		return allowsAmbiguousSignature;
	}
	
	public void setAllowsAmbiguousSignature(boolean allowsAmbiguousSignature) {
		this.allowsAmbiguousSignature = allowsAmbiguousSignature;
	}
	
	@Override
	public void startMatching(Difference difference, Resource modelA, Resource modelB, Scope scope) {
		List<Resource> resourceSetA = MatcherUtil.getResourceScope(modelA, scope);
		List<Resource> resourceSetB = MatcherUtil.getResourceScope(modelB, scope);

		Map<String, List<EObject>> signatures = new HashMap<>();
		List<EObject> unmatched;
		List<EObject> ambiguous;
		
		// Phase 1: Full qualified
		resourceSetA.forEach(model -> calculateSignatures(model.getAllContents(), signatures, this::qualifiedLevelSignature));
		resourceSetB.forEach(model -> calculateSignatures(model.getAllContents(), signatures, this::qualifiedLevelSignature));

		// Phase 2: Package level:
		unmatched = extractUnmatched(signatures);
//		signatures = new HashMap<>();
		calculateSignatures(unmatched.iterator(), signatures, this::packageLevelSignature);
		
		// Phase 3: Class level:
		if (!unmatched.isEmpty()) {
			unmatched = extractUnmatched(signatures);
//			signatures = new HashMap<>();
			calculateSignatures(unmatched.iterator(), signatures, this::classLevelSignature);
		}
		
		// Handle ambiguous signature matchings:
		ambiguous = extractAmbiguous(signatures);
//		signatures = new HashMap<>();
		calculateSignatures(ambiguous.iterator(), signatures, this::classIndexLevelSignature);
		
		handleAmbiguousSignature(signatures);
		
		// Convert signature match to correspondences:
		createCorrespondences(difference, signatures);
	}

	protected void calculateSignatures(
			Iterator<EObject> unmatched, 
			Map<String, List<EObject>> signatures, 
			Function<EObject, String> signatureMapper) {
		
		unmatched.forEachRemaining(modelElement -> {
			String signature = signatureMapper.apply(modelElement);

			if (signatures.containsKey(signature)) {
				signatures.get(signature).add(modelElement);
			} else {
				List<EObject> matched = new ArrayList<>(2);
				matched.add(modelElement);
				signatures.put(signature, matched);
			}
		});
	}
	
	protected List<EObject> extractAmbiguous(Map<String, List<EObject>> signatures) {
		List<EObject> unmatched = new ArrayList<>();
		List<String> unmatchedSignatures = new ArrayList<>();
		
		for (Entry<String, List<EObject>> entry : signatures.entrySet()) {
			if (entry.getValue().size() > 2) {
				unmatched.addAll(entry.getValue());
				unmatchedSignatures.add(entry.getKey());
			}
		}
		
		unmatchedSignatures.forEach(signatures::remove);
		
		return unmatched;
	}
	
	protected List<EObject> extractUnmatched(Map<String, List<EObject>> signatures) {
		List<EObject> unmatched = new ArrayList<>();
		List<String> unmatchedSignatures = new ArrayList<>();
		
		for (Entry<String, List<EObject>> entry : signatures.entrySet()) {
			if (entry.getValue().size() == 1) {
				unmatched.addAll(entry.getValue());
				unmatchedSignatures.add(entry.getKey());
			}
		}
		
		unmatchedSignatures.forEach(signatures::remove);
		
		return unmatched;
	}
	
	protected String qualifiedLevelSignature(EObject element) {
		StringBuilder elementName = new StringBuilder(getLabelSignature(element));

		while (elementName != null && element.eContainer() != null) {
			element = element.eContainer();
			String containerName = getLabelSignature(element);

			if (containerName != null) {
				elementName.insert(0, "$" + containerName);
			}
		}

		elementName.insert(0, element.eResource().getURI().lastSegment() + "[EResource]");
		return elementName.toString();
	}
	
	protected String packageLevelSignature(EObject element) {
		StringBuilder elementName = new StringBuilder(getLabelSignature(element));

		while (elementName != null && element.eContainer() != null) {
			element = element.eContainer();
			
			if (element instanceof EPackage) {
				break;
			} else {
				String containerName = getLabelSignature(element);
				
				if (containerName != null) {
					elementName.insert(0, "$" + containerName);
				}
			}
		}

		elementName.insert(0, element.eResource().getURI().lastSegment() + "[EResource]");
		return elementName.toString();
	}
	
	protected String classLevelSignature(EObject element) {
		StringBuilder elementName = new StringBuilder(getLabelSignature(element));

		while (elementName != null && element.eContainer() != null) {
			element = element.eContainer();
			
			if (element instanceof EClass) {
				break;
			} else {
				String containerName = getLabelSignature(element);
				
				if (containerName != null) {
					elementName.insert(0, "$" + containerName);
				}
			}
		}

		elementName.insert(0, element.eResource().getURI().lastSegment() + "[EResource]");
		return elementName.toString();
	}
	
	protected String classIndexLevelSignature(EObject element) {
		StringBuilder elementName = new StringBuilder(getLabelSignature(element));
		
		if (element instanceof EStructuralFeature) {
			EClass containerClass = ((EStructuralFeature) element).getEContainingClass();
			
			if (containerClass != null) {
				int index = containerClass.getEStructuralFeatures().indexOf(element);
				elementName.insert(0, "#");
				elementName.insert(0, index);
				elementName.insert(0, "#");
			}
		}
		
		EObject container = element;
		
		if (elementName != null ) {
		
			while (container.eContainer() != null) {
				container = container.eContainer();
				
				if (container instanceof EClass) {
					break;
				} else {
					String containerName = getLabelSignature(container);
					
					if (containerName != null) {
						elementName.insert(0, "$" + containerName);
					}
				}
				
				if (container instanceof EStructuralFeature) {
					EClass containerClass = ((EStructuralFeature) container).getEContainingClass();
					
					if (containerClass != null) {
						int index = containerClass.getEStructuralFeatures().indexOf(container);
						elementName.insert(0, "#");
						elementName.insert(0, index);
						elementName.insert(0, "#");
					}
				}
			}
		}

		elementName.insert(0, container.eResource().getURI().lastSegment() + "[EResource]");
		return elementName.toString();
	}
	
	protected String getLabelSignature(EObject element) {
		StringBuilder signature = new StringBuilder();

		if (element.eIsProxy()) {
			signature.append(EcoreUtil.getURI(element));
			return signature.toString();
		}
		
		EStructuralFeature nameFeature = element.eClass().getEStructuralFeature("name");

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
			signature.append(((EAnnotation) element).getSource());
			signature.append("->");
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
			
			signature.append("[");
			signature.append(element.eClass().getName());
			signature.append("]");
			
			return signature.toString();
		} else if (element instanceof EStringToStringMapEntryImpl) {
			EStringToStringMapEntryImpl entry = (EStringToStringMapEntryImpl) element;
			
			signature.append("{");
			signature.append(entry.getKey());
			signature.append("->");
			signature.append(entry.getValue());
			signature.append("}");
			
			signature.append("[");
			signature.append(entry.eClass().getName());
			signature.append("]");
			
			return signature.toString();
		} else if (element instanceof EGenericType) {
			EGenericType genericElement = (EGenericType) element;
			
			if (genericElement.getEClassifier() != null) {
				signature.append("eClassifier->{");
				signature.append(getLabelSignature(genericElement.getEClassifier()));
				signature.append("}");
			}
			
			if (genericElement.getELowerBound() != null) {
				signature.append("eLowerBound->{");
				signature.append(getLabelSignature(genericElement.getELowerBound()));
				signature.append("}");
			}
			
			if (genericElement.getERawType() != null) {
				signature.append("eRawType->{");
				signature.append(getLabelSignature(genericElement.getERawType()));
				signature.append("}");
			} 
			
			if (genericElement.getETypeParameter() != null) {
				signature.append("eTypeParameter->{");
				signature.append(getLabelSignature(genericElement.getETypeParameter()));
				signature.append("}");
			}
			
			if (!genericElement.getETypeArguments().isEmpty()) {
				signature.append("eTypeArguments->{");
				List<EGenericType> types = genericElement.getETypeArguments();
				
				for (EGenericType type : types) {
					signature.append(getLabelSignature(type));
					
					if (type != types.get(types.size() - 1)) {
						signature.append(",");
					}
				}
				
				signature.append("}");
			}
			
			if (genericElement.getEUpperBound() != null) {
				signature.append("eUpperBound->{");
				signature.append(getLabelSignature(genericElement.getEUpperBound()));
				signature.append("}");
			}
			
			signature.append("[");
			signature.append(genericElement.eClass().getName());
			signature.append("]");
			
			return signature.toString();
		} else {
			// To-string signature: Remove Object ID if present:
			signature.append(element.toString().replaceFirst("@.*?\\s", ""));
			
			signature.append("[");
			signature.append(element.eClass().getName());
			signature.append("]");
			
			return signature.toString();
		}
	}
	
	protected List<EObject> getMatches(List<? extends EObject> elements, Map<String, List<EObject>> signatures) {
		List<EObject> matches = new ArrayList<>();
		
		for (EObject element : elements) {
			EObject match = getMatch(element, signatures);
			
			if (match != null) {
				matches.add(match);
			}
		}
		
		return matches;
	}
	
	protected EObject getMatch(EObject element, Map<String, List<EObject>> signatures) {
		String signature = qualifiedLevelSignature(element);
		EObject match = lookupMatch(element, signatures, signature);
		
		if (match == null) {
			signature = packageLevelSignature(element);
			lookupMatch(element, signatures, signature);
		}
		
		if (match == null) {
			signature = classLevelSignature(element);
			lookupMatch(element, signatures, signature);
		}
		
		return match;
	}

	protected EObject lookupMatch(EObject element, Map<String, List<EObject>> signatures, String signature) {
		if (signatures.containsKey(signature)) {
			List<EObject> matching = signatures.get(signature);
			
			if ((matching.size() == 2) || isAllowsAmbiguousSignature()){
				for (EObject match : matching) {
					if (match != element) {
						return match;
					}
				}
			}
		}
		return null;
	}
	
	protected void handleAmbiguousSignature(Map<String, List<EObject>> signatures) {
		for (Entry<String, List<EObject>> match : signatures.entrySet()) {
			List<EObject> matched = match.getValue();
			
			if (matched.size() > 2) {
				
				// Search inheritance match for structural features:
				matchInheritanceMovedStructuralFeatures(matched, signatures);

				// Search local match for structural features:
				matchLocallyMovedStructuralFeatures(matched, signatures);
				
				// Handle Ambiguous Signature:
				if (isAllowsAmbiguousSignature()) {
					// cut match:
					matched.subList(2, matched.size()).clear();
				} else {
					// remove match:
					matched.clear();
				}
			}
		}
	}

	protected void matchInheritanceMovedStructuralFeatures(List<EObject> matched, Map<String, List<EObject>> signatures) {
		
		if (matched.get(0) instanceof EStructuralFeature) {
			List<EObject[]> pairs = new ArrayList<>();

			for (EObject matchElementA : matched) {
				if (resourceSetA.contains(matchElementA.eResource())) {
					for (EObject matchElementB : matched) {
						if (resourceSetB.contains(matchElementB.eResource())) {
							if (matchElementA != matchElementB) {
								EStructuralFeature featureA = (EStructuralFeature) matchElementA;
								EStructuralFeature featureB = (EStructuralFeature) matchElementB;

								EObject classBinA = getMatch(featureB.getEContainingClass(), signatures);

								if (classBinA != null) {
									List<EClass> superTypesA = featureA.getEContainingClass().getEAllSuperTypes();
									List<EObject> superTypesBinA = getMatches(featureB.getEContainingClass().getEAllSuperTypes(), signatures);

									if (hasIntersection(superTypesA, superTypesBinA)
											|| superTypesA.contains(classBinA)
											|| superTypesBinA.contains(featureA.getEContainingClass())) {
										pairs.add(new EObject[] {matchElementA, matchElementB});
									}
								}
							}
						}
					}
				}
			}

			if (!pairs.isEmpty()) {
				if ((pairs.size() == 1) || isAllowsAmbiguousSignature()) {
					matched.clear();
					matched.add(pairs.get(0)[0]);
					matched.add(pairs.get(0)[1]);
				}
			}
		}
	}

	protected void matchLocallyMovedStructuralFeatures(List<EObject> matched, Map<String, List<EObject>> signatures) {
		
		if (matched.get(0) instanceof EStructuralFeature) {
			List<EObject[]> pairs = new ArrayList<>();

			for (EObject matchElementA : matched) {
				if (resourceSetA.contains(matchElementA.eResource())) {
					for (EObject matchElementB : matched) {
						if (resourceSetB.contains(matchElementB.eResource())) {
							if (matchElementA != matchElementB) {
								EClass classA = ((EStructuralFeature) matchElementA).getEContainingClass();
								EClass classB = ((EStructuralFeature) matchElementB).getEContainingClass();

								if (classA.getEAllReferences().stream().anyMatch(r -> getMatch(r.getEReferenceType(), signatures) == classB) 
										|| classB.getEAllReferences().stream().anyMatch(r -> getMatch(r.getEReferenceType(), signatures) == classA)) {
									pairs.add(new EObject[] {matchElementA, matchElementB});
								}
							}
						}
					}
				}
			}

			if (!pairs.isEmpty()) {
				if ((pairs.size() == 1) || isAllowsAmbiguousSignature()) {
					matched.clear();
					matched.add(pairs.get(0)[0]);
					matched.add(pairs.get(0)[1]);
				}
			}
		}
	}

	protected boolean hasIntersection(List<?> list1, List<?> list2) {
		for (Object t : list1) {
			if (list2.contains(t)) {
				return true;
			}
		}
		return false;
    }

	protected void createCorrespondences(Difference difference, Map<String, List<EObject>> signatures) {
		for (Entry<String, List<EObject>> match : signatures.entrySet()) {
			List<EObject> matched = match.getValue();
			
			if (matched.size() == 2) {
				Resource resource0 = matched.get(0).eResource();
				Resource resource1 = matched.get(1).eResource();
				
				if (resourceSetA.contains(resource0) && resourceSetB.contains(resource1)) {
					difference.addCorrespondence(matched.get(0), matched.get(1));
				} else if (resourceSetA.contains(resource1) && resourceSetB.contains(resource0)) {
					difference.addCorrespondence(matched.get(1), matched.get(0));
				}
			}
		}
	}
}

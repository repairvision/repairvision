package org.sidiff.repair.ui.peo.evaluation.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.graphpattern.EObjectList;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.repair.api.IRepair;
import org.sidiff.repair.api.peo.PEORepairJob;
import org.sidiff.repair.evaluation.oracle.DeveloperIntentionOracle;
import org.sidiff.repair.historymodel.History;
import org.sidiff.repair.historymodel.ValidationError;
import org.sidiff.repair.historymodel.Version;
import org.sidiff.repair.validation.IConstraint;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.Repair;
import org.sidiff.repair.validation.util.Validation;
import org.sidiff.validation.constraint.library.IConstraintLibrary;
import org.sidiff.validation.constraint.library.util.ConstraintLibraryUtil;

public class EvaluationUtil {
	
	public static int countOfNodeChanges(List<GraphElement> changes) {
		int count = 0;
		
		for (GraphElement graphElement : changes) {
			if (graphElement instanceof Node) {
				++count;
			}
		}
		
		return count;
	}
	
	public static int countOfNodeCreateChanges(List<GraphElement> changes) {
		int count = 0;
		
		for (GraphElement graphElement : changes) {
			if (graphElement instanceof Node) {
				if (graphElement.getGraph().isRhs()) {
					++count;
				}
			}
		}
		
		return count;
	}
	
	public static int countOfNodeDeleteChanges(List<GraphElement> changes) {
		int count = 0;
		
		for (GraphElement graphElement : changes) {
			if (graphElement instanceof Node) {
				if (graphElement.getGraph().isLhs()) {
					++count;
				}
			}
		}
		
		return count;
	}
	
	public static int countOfEdgeChanges(List<GraphElement> changes) {
		int count = 0;
		
		for (GraphElement graphElement : changes) {
			if (graphElement instanceof Edge) {
				++count;
			}
		}
		
		return count;
	}
	
	public static int countOfEdgeCreateChanges(List<GraphElement> changes) {
		int count = 0;
		
		for (GraphElement graphElement : changes) {
			if (graphElement instanceof Edge) {
				if (graphElement.getGraph().isRhs()) {
					++count;
				}
			}
		}
		
		return count;
	}
	
	public static int countOfEdgeDeleteChanges(List<GraphElement> changes) {
		int count = 0;
		
		for (GraphElement graphElement : changes) {
			if (graphElement instanceof Edge) {
				if (graphElement.getGraph().isLhs()) {
					++count;
				}
			}
		}
		
		return count;
	}
	
	public static Validation getRepairTree(Collection<Validation> repairTrees, ValidationError inconsistencies) {
		for (Validation repairTree : repairTrees) {
			if (repairTree.getRule().getName().equalsIgnoreCase(getValidationID(inconsistencies))) {
				return repairTree;
			}
		}
		return null;
	}
	
	public static Rule getComplement(PEORepairJob repairJob, IRepair repair) {
		
		for (Rule complement : repairJob.getRepairs().keySet()) {
			for (IRepair repairOfcomplement : repairJob.getRepairs().get(complement)) {
				if (repairOfcomplement == repair) {
					return complement;
				}
			}
		}
		
		return null;
	}
	
	public static List<IRepair> historicallyObservable(PEORepairJob repairJob) {
		List<IRepair> observable = new ArrayList<>();
		
		for (Rule complementRule : repairJob.getRepairs().keySet()) {
			for (IRepair repair : repairJob.getRepairs().get(complementRule)) {
				
				// The preMatch turning the complement rule into a repair operation.
				Match preMatch = repair.getRepairPreMatch().getMatch();
				
				// The evolutionStep in which inconsistency has been resolved historically
				SymmetricDifference evolutionStep = (SymmetricDifference) repairJob
						.getDifference().getContents().get(0);
				
				// Mode
				boolean strict = false;
				
				DeveloperIntentionOracle oracle = new DeveloperIntentionOracle();
				
				if (oracle.isHistoricallyObservable(preMatch, evolutionStep, strict)) {
					observable.add(repair);
				}
			}
		}
		
		return observable;
	}
	
	public static void getPathCountOfRepairTree(IRepairDecision node, Integer paths, Integer repairs) {
		if (node instanceof Repair) {
			++repairs;
		}
		
		if (node.getChildDecisions().isEmpty()) {
			++paths;
		} else {
			for (IRepairDecision child : node.getChildDecisions()) {
				getPathCountOfRepairTree(child, paths, repairs);
			}
		}
	}
	
	public static EObjectList toEObjectList(List<? extends EObject> list, String label) {
		EObjectList eObjectList = GraphpatternFactory.eINSTANCE.createEObjectList();
		eObjectList.setLabel(label);
		eObjectList.getContent().addAll(list);
		return eObjectList;
	}
	
	public static List<ValidationError> getValidations(History history) {
		List<ValidationError> validations = new ArrayList<>();
		
		for (Version version : history.getVersions()) {
			for (ValidationError validation : version.getValidationErrors()) {
				if ((validation.getIntroducedIn() != null) && (validation.getResolvedIn() != null)) {
					
					// Is new validation error?
					if (!contains(validations, validation)) {
						validations.add(validation);
					}
				}
			}
		}
		
		return validations;
	}
	
	public static Set<ValidationError> getSupportedValidations(
			List<ValidationError> inconsistenciesAll, Map<String, List<IConstraintLibrary>> libraries) {
		
		Set<ValidationError> inconsistenciesSupported = new HashSet<>();
		
		for (List<IConstraintLibrary> libraryByDocType: libraries.values()) {
			for (IConstraint constraint : ConstraintLibraryUtil.getConsistencyRules(libraryByDocType)) {
				for (ValidationError validation : inconsistenciesAll) {
					if (getValidationID(validation).equalsIgnoreCase(constraint.getName())) {
						inconsistenciesSupported.add(validation);
					}
				}
			}
		}
		
		return inconsistenciesSupported;
	}
	
	public static boolean contains(List<ValidationError> validations, ValidationError validation) {
		for (ValidationError containedValidation : validations) {
			if (equals(containedValidation, validation)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean equals(ValidationError validationA, ValidationError validationB) {
		
		if (validationA.getIntroducedIn() == validationB.getIntroducedIn()) {
			if (validationA.getResolvedIn() == validationB.getResolvedIn()) {
				if (getValidationID(validationA).equals(getValidationID(validationB))) {
					EObject invalidElementA = validationA.getInvalidElement().get(0);
					EObject invalidElementB = validationB.getInvalidElement().get(0);
					
					// FIXME: Mapping from file: to platform:
//					if (invalidElementA.eIsProxy()) {
//						EcoreUtil.resolve(invalidElementA, validationA.eResource().getResourceSet());
//					}
//					if (invalidElementB.eIsProxy()) {
//						EcoreUtil.resolve(invalidElementB, validationB.eResource().getResourceSet());
//					}
					
//					if (EMFUtil.getXmiId(invalidElementA).equals(EMFUtil.getXmiId(invalidElementB))) {
					if (EcoreUtil.getURI(invalidElementA).fragment().equals(EcoreUtil.getURI(invalidElementB).fragment())) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static String getValidationID(ValidationError validation) {
		return validation.getName().replaceAll("[^\\p{Alpha}]", "");
	}
	
	public static Version getPrecessorRevision(Version version) {
		History history = (History) version.eContainer();
		int index = history.getVersions().indexOf(version);

		if ((index - 1) >= 0) {
			return history.getVersions().get(index - 1);
		}
		
		return null;
	}

//	public static Version getSuccessorRevision(Version version) {
//		History history = (History) version.eContainer();
//		int index = history.getVersions().indexOf(version);
//
//		if ((index + 1) < history.getVersions().size()) {
//			return history.getVersions().get(index + 1);
//		}
//		
//		return null;
//	}
}

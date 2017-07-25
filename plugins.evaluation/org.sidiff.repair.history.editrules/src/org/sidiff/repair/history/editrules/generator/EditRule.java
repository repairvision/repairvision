package org.sidiff.repair.history.editrules.generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.editrule.recorder.transformations.DifferenceToEditRule;
import org.sidiff.matching.model.Correspondence;
import org.sidiff.matching.model.MatchingModelFactory;
import org.sidiff.repair.history.editrules.learning.DifferenceSlice;
import org.sidiff.repair.history.editrules.learning.LearnEditRule;
import org.sidiff.repair.history.editrules.learning.MultiScopeReferenceFilter;
import org.sidiff.repair.history.editrules.learning.ScopeAttributeFilter;
import org.sidiff.repair.history.editrules.learning.ScopeReferenceFilter;
import org.sidiff.validation.constraint.interpreter.scope.AttributeScope;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;

public class EditRule {

	protected String name;
	
	protected Module editRule;
	
	protected SymmetricDifference difference;
	
	protected DifferenceSlice differenceSlice;
	
	protected IScopeRecorder fragmentA;
	
	protected IScopeRecorder fragmentB;
	
	protected EditRuleSignature signature;
	
	public EditRule(String name, SymmetricDifference difference,
			IScopeRecorder fragmentA, IScopeRecorder fragmentB) {
		
		this.name = name;
		this.difference = difference;
		this.fragmentA = fragmentA;
		this.fragmentB = fragmentB;
		
		this.signature = new EditRuleSignature(this);
	}
	
	public String getName() {
		return name;
	}
	
	public SymmetricDifference getDifference() {
		return difference;
	}
	
	public IScopeRecorder getFragmentA() {
		return fragmentA;
	}
	
	public IScopeRecorder getFragmentB() {
		return fragmentB;
	}
	
	public DifferenceSlice getDifferenceSlice() {
		
		if (differenceSlice == null) {
			LearnEditRule learnEditRule = new LearnEditRule(difference);
			differenceSlice = learnEditRule.learnByConsistentChange(
					fragmentA.getScope(), 
					new ScopeReferenceFilter(fragmentA), new ScopeAttributeFilter(fragmentA),
					fragmentB.getScope(),
					new ScopeReferenceFilter(fragmentB), new ScopeAttributeFilter(fragmentB));
		}
		
		return differenceSlice;
	}
	
	public Module getEditRule() {
		
		if (editRule == null) {
			
			// TODO: Correct context during slicing!?
			//       - Remember implicitly/explicitly added changed during slicing
			correctContext(getDifferenceSlice());
			
			// Convert difference to edit rule:
			TransformationSetup trafoSetup = new TransformationSetup();
			trafoSetup.setChanges(differenceSlice.getChanges());
			trafoSetup.setCorrespondences(differenceSlice.getCorrespondences());
			trafoSetup.setContextReferenceFilter(new MultiScopeReferenceFilter(fragmentA, fragmentB));
			trafoSetup.setEditRuleName(getName());
			
			DifferenceToEditRule editRuleRecorder = new DifferenceToEditRule(trafoSetup) {
				protected void createInitializationAttributes(EObject object, Node node) {}
			};
			
			for (AttributeScope lhsAttribute : fragmentA.getEqualityTests()) {
				editRuleRecorder.addAttribute(
						lhsAttribute.getObject(), 
						lhsAttribute.getValue(), 
						lhsAttribute.getType());
			}
			
			for (AttributeScope rhsAttribute : fragmentB.getEqualityTests()) {
				editRuleRecorder.addAttribute(
						rhsAttribute.getObject(), 
						rhsAttribute.getValue(), 
						rhsAttribute.getType());
			}
			
			editRule = editRuleRecorder.getEditRule();
		}
		
		return editRule;
	}
	
	private static void correctContext(DifferenceSlice differenceSlice) {
		
		// Search for missing context nodes:
		List<Change> convertToContext = new ArrayList<>(5);
		
		for (Change change : differenceSlice.getChanges()) {
			if (convertToContext(change, differenceSlice.getChanges(), differenceSlice.getCorrespondences())) {
				convertToContext.add(change);
			}
		}
		
		// Create pseudo correspondence
		differenceSlice.getChanges().removeAll(convertToContext);
		
		for (Change change : convertToContext) {
			Correspondence correspondence = MatchingModelFactory.eINSTANCE.createCorrespondence();
			correspondence.setMatchedA(getChangedObject(change));
			correspondence.setMatchedB(getChangedObject(change));
			differenceSlice.getCorrespondences().add(correspondence);
		}
	}
	
	private static boolean convertToContext(Change change, 
			Collection<Change> changes, Collection<Correspondence> preserved) {
		
		if ((change instanceof AddObject) || (change instanceof RemoveObject)) {
			if (!isContainedChange(change, changes, preserved)) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isContainedChange(Change change, 
			Collection<Change> changes, Collection<Correspondence> preserved) {

		EObject container = getChangedObject(change).eContainer();

		for (Change otherChange : changes) {
			if (getChangedObject(otherChange) == container) {
				return true;
			}
		}

		for (Correspondence correspondence : preserved) {
			if ((correspondence.getMatchedA() == container) || (correspondence.getMatchedB() == container)) {
				return true;
			}
		}
		return false;
	}
	
	private static EObject getChangedObject(Change change) {
		if (change instanceof AddObject) {
			return ((AddObject) change).getObj();
		} else if (change instanceof RemoveObject) {
			return ((RemoveObject) change).getObj();
		}
		return null;
	}
	
	public int getChangeCount() {
		// TODO: Count atomic depending changes!
		return getDifferenceSlice().getChanges().size();
	}
	
	public EditRuleSignature getSignature() {
		return signature;
	}
	
	public boolean isEqualEditRule(EditRule otherEditRule) {
		return otherEditRule.getSignature().equals(getSignature());
	}
	
	public void saveEditRule(URI uri) {
		LearnEditRule.saveEditRule(getEditRule(), uri, true, false);
	}
}

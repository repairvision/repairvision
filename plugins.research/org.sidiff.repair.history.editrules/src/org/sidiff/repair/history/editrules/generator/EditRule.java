package org.sidiff.repair.history.editrules.generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.repair.history.editrules.learn.scope.DifferenceSlice;
import org.sidiff.repair.history.editrules.learn.scope.LearnEditRule;
import org.sidiff.repair.history.editrules.learn.scope.MultiScopeReferenceFilter;
import org.sidiff.repair.history.editrules.learn.scope.ScopeAttributeFilter;
import org.sidiff.repair.history.editrules.learn.scope.ScopeReferenceFilter;
import org.sidiff.revision.difference.AddObject;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.DifferenceFactory;
import org.sidiff.revision.difference.RemoveObject;
import org.sidiff.revision.editrules.generation.difference.DifferenceToEditRule;
import org.sidiff.revision.editrules.generation.difference.builder.HenshinBuilder;
import org.sidiff.revision.editrules.generation.difference.configuration.SymmetricModelDifference;
import org.sidiff.revision.editrules.generation.difference.configuration.TransformationConfiguration;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.IAddAttributeFilter;
import org.sidiff.revision.editrules.generation.difference.util.DifferenceToEditRuleUtil;
import org.sidiff.revision.impact.changetree.scope.AttributeScope;
import org.sidiff.revision.impact.changetree.scope.IScopeRecorder;

public class EditRule implements IEditRule {

	protected String name;
	
	protected String description;
	
	protected Rule editRule;
	
	protected Difference difference;
	
	protected DifferenceSlice differenceSlice;
	
	protected IScopeRecorder fragmentA;
	
	protected IScopeRecorder fragmentB;
	
	protected EditRuleSignature signature;
	
	protected HenshinBuilder language = new HenshinBuilder();
	
	public EditRule(String name, Difference difference,
			IScopeRecorder fragmentA, IScopeRecorder fragmentB) {
		
		this.name = name;
		this.difference = difference;
		this.fragmentA = fragmentA;
		this.fragmentB = fragmentB;
		
		// FIXME: EXPERIMENTAL
//		if (!containsCreateChanges()) {
//			fragmentA.getEqualityTests().clear();
//			fragmentB.getEqualityTests().clear();
//		}
		
		this.signature = new EditRuleSignature(this);
	}
	
//	private boolean containsCreateChanges() {
//		for (Change change : getDifferenceSlice().getChanges()) {
//			if (change instanceof AddObject) {
//				return true;
//			}
//			
//			else if (change instanceof AddReference) {
//				return true;
//			}
//		}
//		return false;
//	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Difference getDifference() {
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
	
	public Rule getEditRule() {
		
		if (editRule == null) {
			
			// TODO: Correct context during slicing!?
			//       - Remember implicitly/explicitly added changed during slicing
			correctContext(getDifferenceSlice());
			
			// Convert difference to edit rule:
			SymmetricModelDifference symmetricModelDifference = new SymmetricModelDifference(
					difference, differenceSlice.getCorrespondences(), differenceSlice.getChanges());
			TransformationConfiguration trafoConfig = new TransformationConfiguration(
					getName(), symmetricModelDifference);
			
			trafoConfig.getFilters().setReferenceFilter(new MultiScopeReferenceFilter(fragmentA, fragmentB));
			trafoConfig.getFilters().setAddAttributeFilter(IAddAttributeFilter.FILTER_ALL);
			
			DifferenceToEditRule<Rule, Node, Edge, Attribute> editRuleRecorder 
				= new DifferenceToEditRule<Rule, Node, Edge, Attribute>(language, trafoConfig);
			
			for (AttributeScope lhsAttribute : fragmentA.getEqualityTests()) {
				DifferenceToEditRuleUtil.addAttribute(
						editRuleRecorder,
						lhsAttribute.getObject(), 
						lhsAttribute.getValue(), 
						lhsAttribute.getType());
			}

			for (AttributeScope rhsAttribute : fragmentB.getEqualityTests()) {
				DifferenceToEditRuleUtil.addAttribute(
						editRuleRecorder,
						rhsAttribute.getObject(), 
						rhsAttribute.getValue(), 
						rhsAttribute.getType());
			}

			editRule = editRuleRecorder.transform();
			editRule.setDescription(description);
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
			Correspondence correspondence = DifferenceFactory.eINSTANCE.createCorrespondence();
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
	
	public boolean isEqualEditRule(IEditRule otherEditRule) {
		return otherEditRule.getSignature().equals(getSignature());
	}
	
	public void saveEditRule(URI folder, String nameWithoutFileExtension, boolean openDiagram) {
		DifferenceToEditRuleUtil.saveEditRule(
				language, folder, nameWithoutFileExtension,
				openDiagram, false, 150);
	}
}

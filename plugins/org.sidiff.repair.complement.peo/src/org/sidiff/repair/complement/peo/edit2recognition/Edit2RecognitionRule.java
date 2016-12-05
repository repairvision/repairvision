package org.sidiff.repair.complement.peo.edit2recognition;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.sidiff.common.henshin.exceptions.NoMainUnitFoundException;
import org.sidiff.difference.lifting.edit2recognition.Edit2RecognitionTransformation;
import org.sidiff.difference.lifting.edit2recognition.exceptions.EditToRecognitionException;
import org.sidiff.difference.lifting.edit2recognition.traces.TransformationPatterns;
import org.sidiff.difference.symmetric.SymmetricPackage;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.henshin.HenshinConverter;
import org.sidiff.matching.model.MatchingModelPackage;

/**
 * Converts a Henshin edit-rule to a Graph-Pattern recognition-rule.
 * 
 * @author Manuel Ohrndorf
 */
public class Edit2RecognitionRule {

	/**
	 * Cross-Referenced edge types.
	 */
	public static final Set<EReference> crossReferencedTypes = new HashSet<>();

	static {
		crossReferencedTypes.add(MatchingModelPackage.eINSTANCE.getCorrespondence_MatchedA());
		crossReferencedTypes.add(MatchingModelPackage.eINSTANCE.getCorrespondence_MatchedB());
		
		crossReferencedTypes.add(SymmetricPackage.eINSTANCE.getAddObject_Obj());
		
		crossReferencedTypes.add(SymmetricPackage.eINSTANCE.getAddReference_Src());
		crossReferencedTypes.add(SymmetricPackage.eINSTANCE.getAddReference_Tgt());
		crossReferencedTypes.add(SymmetricPackage.eINSTANCE.getAddReference_Type());
		
		crossReferencedTypes.add(SymmetricPackage.eINSTANCE.getAttributeValueChange_ObjA());
		crossReferencedTypes.add(SymmetricPackage.eINSTANCE.getAttributeValueChange_ObjB());
		crossReferencedTypes.add(SymmetricPackage.eINSTANCE.getAttributeValueChange_Type());
		
		crossReferencedTypes.add(SymmetricPackage.eINSTANCE.getRemoveObject_Obj());
		
		crossReferencedTypes.add(SymmetricPackage.eINSTANCE.getRemoveReference_Src());
		crossReferencedTypes.add(SymmetricPackage.eINSTANCE.getRemoveReference_Tgt());
		crossReferencedTypes.add(SymmetricPackage.eINSTANCE.getRemoveReference_Type());
	}
	
	private Rule editRule;
	
	private GraphPattern recognitionRule;
	
	private Map<Unit, TransformationPatterns> edit2RecognitionTrace;
	
	private Map<Node, NodePattern> henshinToGraphPatternTrace;
	
	public Edit2RecognitionRule(Rule editRule) {
		this.editRule = editRule;
		
		try {
			
			// Transform edit- to recognition-rule:
			Edit2RecognitionTransformation edit2Recognition = 
					new Edit2RecognitionTransformation(editRule.getModule());
			Rule recognitionUnit = (Rule) edit2Recognition.getRecognitionMainUnit();
			edit2RecognitionTrace = edit2Recognition.getPatterns();

			// Convert to graph pattern:
			HenshinConverter henshinConverter = new HenshinConverter(recognitionUnit, crossReferencedTypes);
			recognitionRule = henshinConverter.getGraphPattern();
			henshinToGraphPatternTrace = henshinConverter.getTrace();
			
			// Calculate change dependencies:
			ChangeDependencies dependencyCalculator = new ChangeDependencies(
					editRule, recognitionRule, henshinToGraphPatternTrace, edit2RecognitionTrace.get(editRule));
			dependencyCalculator.calculateDependencyGraph();
			
		} catch (NoMainUnitFoundException | EditToRecognitionException e) {
			e.printStackTrace();
		}
	}
	
	public void saveRecognitionRule(URI uri) {
		ResourceSet rss = new ResourceSetImpl();
		Resource graphPatternResource = rss.createResource(uri);
		graphPatternResource.getContents().add(recognitionRule);

		try {
			graphPatternResource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Rule getEditRule() {
		return editRule;
	}

	public GraphPattern getRecognitionRule() {
		return recognitionRule;
	}

	public Map<Unit, TransformationPatterns> getEdit2RecognitionTrace() {
		return edit2RecognitionTrace;
	}

	public Map<Node, NodePattern> getHenshinToGraphPatternTrace() {
		return henshinToGraphPatternTrace;
	}
}

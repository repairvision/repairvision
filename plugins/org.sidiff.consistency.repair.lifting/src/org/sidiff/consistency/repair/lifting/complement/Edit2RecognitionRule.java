package org.sidiff.consistency.repair.lifting.complement;

import java.util.Map;

import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.sidiff.common.henshin.exceptions.NoMainUnitFoundException;
import org.sidiff.consistency.graphpattern.GraphPattern;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.henshin.HenshinConverter;
import org.sidiff.difference.lifting.edit2recognition.Edit2RecognitionTransformation;
import org.sidiff.difference.lifting.edit2recognition.exceptions.EditToRecognitionException;
import org.sidiff.difference.lifting.edit2recognition.traces.TransformationPatterns;

public class Edit2RecognitionRule {

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
			HenshinConverter henshinConverter = new HenshinConverter(recognitionUnit);
			recognitionRule = henshinConverter.getGraphPattern();
			henshinToGraphPatternTrace = henshinConverter.getTrace();
		} catch (NoMainUnitFoundException | EditToRecognitionException e) {
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

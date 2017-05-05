package org.sidiff.editrule.partialmatcher.engine;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.sidiff.common.henshin.HenshinUnitAnalysis;
import org.sidiff.common.henshin.exceptions.NoMainUnitFoundException;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.editrule.partialmatcher.PartialEditRuleRecognizer;
import org.sidiff.editrule.partialmatcher.pattern.RecognitionPattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.matcher.IMatching;
import org.sidiff.graphpattern.matcher.IPatternMatchingEngine;
import org.sidiff.graphpattern.matcher.IPatternMatchingEngineFactory;

public class PatternMatchingEngineFactory implements IPatternMatchingEngineFactory<IMatching> {

	@Override
	public IPatternMatchingEngine<IMatching> createPatternMatchingEngine(
			GraphPattern graphpattern, ResourceSet targetModels) {
		
		if ((graphpattern != null) && (targetModels != null)) {
			
			// Partial edit rule recognizer:
			PartialEditRuleRecognizer editRuleRecognizer = new PartialEditRuleRecognizer();
			editRuleRecognizer.initialize(getSymmetricDifference(targetModels));
			RecognitionPattern recognitionPattern = null;
			
			// Initialization as command -> support for graph patterns from editors:
			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(graphpattern);
			
			if (editingDomain == null) {
				recognitionPattern = editRuleRecognizer
						.createRecognitionPattern(getEditRule(targetModels), graphpattern);
			} else {
				CreateRecognitionPatternCommand createRecognitionPatternCommand = 
						new CreateRecognitionPatternCommand(editingDomain, 
								editRuleRecognizer, getEditRule(targetModels), graphpattern);
				
				editingDomain.getCommandStack().execute(createRecognitionPatternCommand);
				recognitionPattern = createRecognitionPatternCommand.getRecognitionPattern();
			}
			
			// Wrap in pattern matching engine:
			if (recognitionPattern != null) {
				return new PatternMatchingEngine(editRuleRecognizer, recognitionPattern);
			} else {
				return null;
			}
		}
		
		return null;
	}
	
	private static Rule getEditRule(ResourceSet rss) {
		Rule rule = null;
		
		for (Resource res : rss.getResources()) {
			if (res.getContents() != null) {
				EObject root = res.getContents().get(0);
				
				if (root instanceof Module) {
					try {
						Unit executeMainUnit = HenshinUnitAnalysis.findExecuteMainUnit((Module) root);
						
						if (!executeMainUnit.getSubUnits(false).isEmpty()) {
							if (executeMainUnit.getSubUnits(false).get(0) instanceof Rule) {
								Rule editRule = (Rule) executeMainUnit.getSubUnits(false).get(0);
								return editRule;
							}
						}
					} catch (NoMainUnitFoundException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		return rule;
	}

	private static SymmetricDifference getSymmetricDifference(ResourceSet rss) {
		SymmetricDifference difference = null;
		
		for (Resource res : rss.getResources()) {
			if ((res.getContents() != null) && (res.getContents().get(0) instanceof SymmetricDifference)) {
				difference = (SymmetricDifference) res.getContents().get(0);
				break;
			}
		}
		
		return difference;
	}
}

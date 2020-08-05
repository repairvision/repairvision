package org.sidiff.revision.editrules.complement.plan;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.ParameterKind;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.revision.api.ComplementationPlan;
import org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.editrules.complement.construction.ComplementRule;
import org.sidiff.revision.editrules.complement.util.ParameterBinding;
import org.sidiff.revision.editrules.recognition.match.RecognitionEdgeMatch;
import org.sidiff.revision.editrules.recognition.match.RecognitionMatch;
import org.sidiff.revision.editrules.recognition.match.RecognitionNodeMatch;
import org.sidiff.revision.editrules.recognition.match.RecognitionNodeMultiMatch;
import org.sidiff.revision.editrules.recognition.match.RecognitionNodeSingleMatch;

/**
 * Represents a single parameterized complementation operation.
 * 
 * @author Manuel Ohrndorf
 */
public class ComplementationPlanImpl implements ComplementationPlan {
	
	/**
	 * The rule that contains the repair changes.
	 */
	private ComplementRule complementRule;
	
	/**
	 * All complement matchings. 
	 */
	private List<Match> complementMatches;
	
	/**
	 * All possible parameters of the complement rule.
	 */
	private List<ParameterBinding> parameters;
	
	/**
	 * @param complementRule
	 *            The container of the complement rule.
	 * @param complementMatch
	 *            The pre-match of the complement rule.
	 */
	public ComplementationPlanImpl(ComplementRule complementRule, List<Match> complementMatch) {
		this.complementRule = complementRule;
		this.complementMatches = complementMatch;
	}

	@Override
	public Rule getRecognizedEditRule() {
		return complementRule.getRecognizedRule();
	}
	
	@Override
	public List<GraphElement> getRecognizedChanges() {
		return complementRule.getRecognizedChanges();
	}
	
	@Override
	public List<Change> getRecognizedChangeSet() {
		return complementRule.getRecognizedChangeSet();
	}
	
	@Override
	public List<EObject[]> getRecognitionDomain(Node node) {
		assert (node.getGraph().getRule() == complementRule.getRecognizedRule());
		
		List<EObject[]> recognitionDomain = new ArrayList<>(1);
		
		Node lhsNode = node.getGraph().isLhs() ? node : HenshinRuleAnalysisUtil.getLHS(node);
		Node rhsNode = node.getGraph().isRhs() ? node : HenshinRuleAnalysisUtil.getRHS(node);
		
		for (RecognitionMatch recognitionMatch : complementRule.getRecognitionMatching()) {
			
			if (recognitionMatch instanceof RecognitionNodeMatch) {
				Node matchedNode = ((RecognitionNodeMatch) recognitionMatch).getNode();
				
				if ((matchedNode == lhsNode) || (matchedNode == rhsNode)) {
					if (recognitionMatch instanceof RecognitionNodeSingleMatch) {
						addRecognitionMatch(recognitionDomain, 
								((RecognitionNodeSingleMatch) recognitionMatch).getModelAElement(),
								((RecognitionNodeSingleMatch) recognitionMatch).getModelBElement());
					}
					else if (recognitionMatch instanceof RecognitionNodeMultiMatch) {
						RecognitionNodeMultiMatch multiMatch = (RecognitionNodeMultiMatch) recognitionMatch;
						int size = multiMatch.getModelAElements().size() > multiMatch.getModelBElements().size() ? 
								multiMatch.getModelAElements().size() : multiMatch.getModelBElements().size();
						
						for (int i = 0; i < size; i++) {
							EObject objA = i < multiMatch.getModelAElements().size() ? 
									multiMatch.getModelAElements().get(i) : null;
							EObject objB = i < multiMatch.getModelBElements().size() ? 
									multiMatch.getModelBElements().get(i) : null;
							
							addRecognitionMatch(recognitionDomain, objA, objB);
						}
					}
				}
			}
			
			else if (recognitionMatch instanceof RecognitionEdgeMatch) {
				Node matchedSrcNode = ((RecognitionEdgeMatch) recognitionMatch).getEdge().getSource();
				Node matchedTgtNode = ((RecognitionEdgeMatch) recognitionMatch).getEdge().getTarget();
				
				if ((matchedSrcNode == lhsNode) || (matchedSrcNode == rhsNode)) {
					addRecognitionMatch(recognitionDomain, 
							((RecognitionEdgeMatch) recognitionMatch).getSrcModelAElement(),
							((RecognitionEdgeMatch) recognitionMatch).getSrcModelBElement());
				}
				if ((matchedTgtNode == lhsNode) || (matchedTgtNode == rhsNode)) {
					addRecognitionMatch(recognitionDomain, 
							((RecognitionEdgeMatch) recognitionMatch).getTgtModelAElement(),
							((RecognitionEdgeMatch) recognitionMatch).getTgtModelBElement());
				}
			}
		}
		
		return recognitionDomain;
	}
	
	private void addRecognitionMatch(List<EObject[]> recognitionMatch, EObject objA, EObject objB) {
		
		// Already contains match?
		for (EObject[] historyMatch : recognitionMatch) {
			if (historyMatch[0] == objA) {
				return;
			}
			if (historyMatch[1] == objB) {
				return;
			}
		}
		
		// Add new history matching tuple:
		recognitionMatch.add(new EObject[] {objA, objB});
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <G extends GraphElement> G getTrace(G editRuleGraphElement) {
		
		if (editRuleGraphElement instanceof Edge) {
			return (G) complementRule.getTrace((Edge) editRuleGraphElement);
		}
		
		else  if (editRuleGraphElement instanceof Node) {
			return (G) complementRule.getTrace((Node) editRuleGraphElement);
		}
		
		return null;
	}
	
	@Override
	public Rule getComplementingEditRule() {
		return complementRule.getComplementRule();
	}
	
	@Override
	public List<GraphElement> getComplementingChanges() {
		return complementRule.getComplementingChanges();
	}
	
	@Override
	public List<Match> getComplementMatches() {
		
		if ((parameters == null) || parameters.isEmpty()) {
			return complementMatches;
		}
		
		List<Match> selectedComplementMatches = new ArrayList<>();
		
		for (Match complementMatch : complementMatches) {
			if (matchesParameterBindings(complementMatch)) {
				selectedComplementMatches.add(complementMatch);
			}
		}
		
		return selectedComplementMatches;
	}
	
	@Override
	public List<EObject> getComplementDomain(Node node) {
		List<EObject> nodeTargets = new ArrayList<>();
		
		for (Match complementMatch : getComplementMatches()) {
			EObject target = complementMatch.getNodeTarget(node);
			
			if ((target != null) && !nodeTargets.contains(target)) {
				nodeTargets.add(target);
			}
		}
		
		return nodeTargets;
	}
	
	private boolean matchesParameterBindings(Match complementMatch) {
		for (ParameterBinding binding : parameters) {
			if (binding != null) {
				if (binding.isSet()) {
					Object matchBinding = complementMatch.getParameterValue(binding.getParameter());
					
					if ((matchBinding != null) && !matchBinding.equals(binding.getValue())) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	@Override
	public List<Parameter> getParameters() {
		return getParameterBindings().stream().map(ParameterBinding::getParameter).collect(Collectors.toList());
	}
	
	@Override
	public boolean isSetParameter(Parameter parameter) {
		return getParameterBinding(parameter).isSet();
	}
	
	@Override
	public List<Object> getParameterDomain(Parameter parameter) {
		return getParameterDomain(parameter, Object.class);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getParameterDomain(Parameter parameter, Class<T> type) {
		List<T> domain = new ArrayList<>(); 

		for (Match complementMatch : getComplementMatches()) {
			Object parameterValue = complementMatch.getParameterValue(parameter);

			if ((parameterValue != null) && (!domain.contains(parameterValue))) {
				if (type.isInstance(parameterValue)) {
					domain.add((T) parameterValue);
				}
			}
		}
		
		return domain;
	}

	@Override
	public void setParameterValue(Parameter parameter, Object value) {
		ParameterBinding binding = getParameterBinding(parameter);
		
		if (binding != null) {
			
			// store binding:
			binding.setValue(value);
			
			// set/unset string input values:
			for (Match match : complementMatches) {
				if ((value instanceof String) || (match.getParameterValue(parameter) instanceof String)) {
					match.setParameterValue(parameter, value);
				}
			}
		} else {
			throw new NoSuchElementException(parameter.toString());
		}
		
		autoSetParameterValues();
	}

	@Override
	public Object getParameterValue(Parameter parameter) {
		ParameterBinding binding = getParameterBinding(parameter);
		
		if (binding != null) {
			return binding.getValue();
		}
		
		return null;
	}
	
	private ParameterBinding getParameterBinding(Parameter parameter) {
		for(ParameterBinding binding : getParameterBindings()) {
			if (binding.getParameter() == parameter) {
				return binding;
			}
		}
		return null;
	}
	
	protected List<ParameterBinding> getParameterBindings() {
		
		if (parameters == null) {
			parameters = new ArrayList<>(complementRule.getComplementRule().getParameters().size());
			
			for (Parameter parameter : complementRule.getComplementRule().getParameters()) {
				if (!parameter.getKind().equals(ParameterKind.VAR) && !parameter.getKind().equals(ParameterKind.OUT)) {
					parameters.add(new ParameterBinding(parameter));
				}
			}
		}
		
		autoSetParameterValues();
		return parameters;
	}
	
	protected void autoSetParameterValues() {
		
		for (ParameterBinding binding : parameters) {
			if (binding.getValue() == null) {
				List<Object> domain = getParameterDomain(binding.getParameter());
				
				if (domain.size() == 1) {
					binding.setValue(domain.get(0));
				}
			}
		}
	}
}

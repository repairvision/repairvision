package org.sidiff.completion.ui.model.proposals.codebricks;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.henshin.model.Parameter;
import org.sidiff.completion.ui.codebricks.POJOCodebrickView;
import org.sidiff.completion.ui.codebricks.ValuePlaceholderBrick;
import org.sidiff.completion.ui.codebricks.impl.ValueDomainPolicyImpl;
import org.sidiff.completion.ui.model.proposals.ModelCompletionParameterBinding;
import org.sidiff.completion.ui.model.proposals.ModelCompletionProposal;

public class CompletionValueDomainPolicy extends ValueDomainPolicyImpl {

	public static CompletionValueDomainPolicy eINSTANCE = new CompletionValueDomainPolicy();
	
	@Override
	public EList<Object> getDomain(ValuePlaceholderBrick placeholder) {
		if (placeholder != null) {
			String name = placeholder.getName();
			
			if (name != null) {
				if (placeholder.getCodebrick() instanceof POJOCodebrickView) {
					POJOCodebrickView codebrick = (POJOCodebrickView) placeholder.getCodebrick();
					
					if (codebrick.getModel() instanceof ModelCompletionProposal) {
						ModelCompletionProposal completion = (ModelCompletionProposal) codebrick.getModel();
						ModelCompletionParameterBinding parameterBinding = completion.getParameterBinding();
						
						Parameter parameter = parameterBinding.getParameters().stream()
								.filter(p -> p.getName().equals(name)).findAny().orElseGet(() -> null);
						
						if (parameter != null) {
							return ECollections.asEList(parameterBinding.getParameterDomain(parameter, Object.class));
						}
					}
				}
			}
		}
		return super.getDomain(placeholder);
	}
	

	@Override
	public void assignValue(Object instanceValue, ValuePlaceholderBrick placeholder) {
		if (placeholder != null) {
			String name = placeholder.getName();
			
			if (name != null) {
				if (placeholder.getCodebrick() instanceof POJOCodebrickView) {
					POJOCodebrickView codebrick = (POJOCodebrickView) placeholder.getCodebrick();
					
					if (codebrick.getModel() instanceof ModelCompletionProposal) {
						ModelCompletionProposal completion = (ModelCompletionProposal) codebrick.getModel();
						ModelCompletionParameterBinding parameterBinding = completion.getParameterBinding();
						
						Parameter parameter = parameterBinding.getParameters().stream()
								.filter(p -> p.getName().equals(name)).findAny().orElseGet(() -> null);
						
						if (parameter != null) {
							parameterBinding.setParameterValue(parameter, instanceValue);
						}
					}
				}
			}
		}
	}
}

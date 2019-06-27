package org.sidiff.completion.ui.model.codebricks;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Parameter;
import org.sidiff.completion.ui.codebricks.ObjectPlaceholderBrick;
import org.sidiff.completion.ui.codebricks.POJOCodebrickView;
import org.sidiff.completion.ui.codebricks.impl.ObjectDomainPolicyImpl;
import org.sidiff.completion.ui.model.ModelCompletionParameterBinding;
import org.sidiff.completion.ui.model.ModelCompletionProposal;

public class CompletionObjectDomainPolicy extends ObjectDomainPolicyImpl {

	public static CompletionObjectDomainPolicy eINSTANCE = new CompletionObjectDomainPolicy();
	
	@Override
	public EList<EObject> getDomain(ObjectPlaceholderBrick placeholder) {
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
							return ECollections.asEList(parameterBinding.getParameterDomain(parameter, EObject.class));
						}
					}
				}
			}
		}
		return super.getDomain(placeholder);
	}
	
	@Override
	public void assignObject(ObjectPlaceholderBrick placeholder, EObject element) {
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
							parameterBinding.setParameterValue(parameter, element);
						}
					}
				}
			}
		}
	}
}

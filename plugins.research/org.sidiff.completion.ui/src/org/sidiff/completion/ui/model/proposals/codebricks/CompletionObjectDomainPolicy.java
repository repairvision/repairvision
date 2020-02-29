package org.sidiff.completion.ui.model.proposals.codebricks;

import java.util.List;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Parameter;
import org.sidiff.completion.ui.codebricks.Brick;
import org.sidiff.completion.ui.codebricks.Codebrick;
import org.sidiff.completion.ui.codebricks.ObjectPlaceholderBrick;
import org.sidiff.completion.ui.codebricks.POJOCodebrickView;
import org.sidiff.completion.ui.codebricks.ViewableBrick;
import org.sidiff.completion.ui.codebricks.impl.ObjectDomainPolicyImpl;
import org.sidiff.completion.ui.model.proposals.ModelCompletionParameterBinding;
import org.sidiff.completion.ui.model.proposals.ModelCompletionProposal;
import org.sidiff.completion.ui.model.proposals.util.ModelCompletionProposalUtil;

public class CompletionObjectDomainPolicy extends ObjectDomainPolicyImpl {

	public static CompletionObjectDomainPolicy eINSTANCE = new CompletionObjectDomainPolicy();
	
	@Override
	public EList<EObject> getDomain(ObjectPlaceholderBrick placeholder) {
		if (placeholder != null) {
			if (placeholder.getCodebrick() instanceof POJOCodebrickView) {
				POJOCodebrickView codebrick = (POJOCodebrickView) placeholder.getCodebrick();

				if (codebrick.getModel() instanceof ModelCompletionProposal) {
					EList<EObject> domain = getDomain(placeholder, (ModelCompletionProposal) codebrick.getModel());
					
					if (domain != null) {
						return domain;
					}
				} else {
					EList<EObject> domain = getHistoricDomain(placeholder, codebrick);
					
					if (domain != null) {
						return domain;
					}
				}
			}
		}
		return super.getDomain(placeholder);
	}

	private EList<EObject> getHistoricDomain(ObjectPlaceholderBrick placeholder, POJOCodebrickView codebrick) {
		// NOTE: Asserts that all historical edit rules are equal:

		// Is historical placeholder?
		if (indexOfPresenceBrick(codebrick.getBricks()) > codebrick.getBricks().indexOf(placeholder)) {

			// -> Delegate to first alternative:
			if (!codebrick.getCodebricks().getAlternatives().isEmpty()) {
				Codebrick firstAlternative = codebrick.getCodebricks().getAlternatives().get(0);

				if (firstAlternative instanceof POJOCodebrickView) {
					POJOCodebrickView firstAlternativeView = (POJOCodebrickView) firstAlternative;
					
					if (firstAlternativeView.getModel() instanceof ModelCompletionProposal) {
						return getDomain(placeholder, (ModelCompletionProposal) firstAlternativeView.getModel());
					}
				}
			}
		}
		
		return null;
	}
	
	public EList<EObject> getDomain(ObjectPlaceholderBrick placeholder, ModelCompletionProposal model) {
		if (placeholder != null) {
			String name = placeholder.getName();
			
			if (name != null) {
				if (placeholder.getCodebrick() instanceof POJOCodebrickView) {
					ModelCompletionParameterBinding parameterBinding = model.getParameterBinding();

					Parameter parameter = parameterBinding.getParameters().stream()
							.filter(p -> p.getName().equals(name)).findAny().orElseGet(() -> null);

					if (parameter != null) {
						return ECollections.asEList(parameterBinding.getParameterDomain(parameter, EObject.class));
					}
				}
			}
		}
		
		return null;
	}
	
	private int indexOfPresenceBrick(List<Brick> bricks) {
		
		for (int i = 0; i < bricks.size(); i++) {
			Brick brick = bricks.get(i);
			
			if (brick instanceof ViewableBrick) {
				String text = ((ViewableBrick) brick).getText();
				
				if (text.contains(ModelCompletionProposalUtil.TEMPLATE_PRESENCE_SEPARATOR_TRIM)) {
					return i;
				}
			}
		}
		
		return -1;
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

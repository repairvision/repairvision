package org.sidiff.completion.ui.codebricks.editor.views;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.sidiff.completion.ui.codebricks.Codebrick;
import org.sidiff.completion.ui.codebricks.Codebricks;
import org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick;
import org.sidiff.completion.ui.codebricks.ViewableBrick;
import org.sidiff.completion.ui.codebricks.editor.CodebricksEditor;
import org.sidiff.completion.ui.codebricks.editor.proposals.TemplateCodebricksProposal;
import org.sidiff.completion.ui.codebricks.util.CodebricksUtil;
import org.sidiff.completion.ui.proposals.ICompletionProposal;

public class TemplatePlaceholderBuilder {

	public static StyledText build(
			CodebricksEditor editor, Composite placeholderContainer, TemplatePlaceholderBrick placeholderBrick,
			boolean boldFont, Color foreground, Color background, Color hide) {
		
		// Create view:
		StyledText placeholderControl = buildPlaceholder(editor, placeholderContainer, placeholderBrick, boldFont, foreground, background);
		
		// Listen to model changes:
		Codebricks codebricks = placeholderBrick.getCodebrick().getCodebricks();
		
		Adapter modelListener = CodebricksUtil.onTemplatePlaceholderSelected(codebricks, (selectedPlaceholder) -> {
			if (selectedPlaceholder == placeholderBrick) {
				editor.update(() -> {

					if (!placeholderBrick.getChoice().isEmpty()) {
						ViewableBrick showChoice = placeholderBrick.getChoice().get(0);
						
						// Clear container:
						Control[] children = placeholderContainer.getChildren();
						
						for (int i = 0; i < children.length; i++) {
							children[i].dispose();
						}
						
						// Add composed bricks:
						ContentBuilder.build(editor, placeholderContainer, Collections.singletonList(showChoice), foreground, background, hide);
						
						// If this choice is not yet determined disable controls:
						if (placeholderBrick.getChoice().size() > 1) {
							children = placeholderContainer.getChildren();
							
							for (int i = 0; i < children.length; i++) {
								children[i].setEnabled(false);
							}
						}
					} else {
						
						// Clear container:
						Control[] children = placeholderContainer.getChildren();
						
						for (int i = 0; i < children.length; i++) {
							children[i].dispose();
						}
						
						buildPlaceholder(editor, placeholderContainer, placeholderBrick, boldFont, foreground, background);
					}
				});
			} else {
				
				// Auto-select update placeholder:
				if (placeholderBrick.getRemainingChoices().isEmpty()) {
					hideComposedPlaceholders(placeholderContainer, hide);
				} else {
					
					// Unhide (only unselected placeholders):
					if (placeholderBrick.getChoice().isEmpty()) {
						unhideComposedPlaceholders(placeholderContainer, foreground);
					}
					
					// Auto-select object placeholder:
					List<ViewableBrick> choices = getRemainingChoices(placeholderBrick, selectedPlaceholder);
					
					if (!choices.equals(placeholderBrick.getChoice())) {
						
						if (TemplateCodebricksProposal.canCombineProposals(choices)) {
							if (!placeholderBrick.getChoice().isEmpty()) {
								placeholderBrick.getChoice().clear();
							}
							placeholderBrick.getChoice().addAll(choices);
						} else {
							placeholderBrick.getChoice().retainAll(choices);
						}
					}
				}
			}
		});
		
		// Remove model change listener from model when disposing the control:
		placeholderContainer.addDisposeListener(new DisposeListener() {
			
			@Override
			public void widgetDisposed(DisposeEvent e) {
				if (modelListener.getTarget() != null) {
					modelListener.getTarget().eAdapters().remove(modelListener);
				}
			}
		});
		
		return placeholderControl;
	}

	private static StyledText buildPlaceholder(
			CodebricksEditor editor, Composite placeholderContainer, TemplatePlaceholderBrick placeholderBrick, 
			boolean boldFont, Color foreground, Color background) {
		
		StyledText placeholderControl =  PlaceholderBuilder.build(
				editor, placeholderContainer, placeholderBrick,
				TemplatePlaceholderBuilder::getProposals,
				boldFont, foreground, background, false);
		
		return placeholderControl;
	}
	
	private static void hideComposedPlaceholders(Composite containerView, Color hide) {
		for (int i = 0; i < containerView.getChildren().length; i++) {
			Control child = containerView.getChildren()[i];
			
			if ((child instanceof Composite) && !(child instanceof StyledText)) {
				hideComposedPlaceholders((Composite) child, hide);
			} else {
				hidePlaceholder(child, hide);
			}
		}
	}
	
	private static void unhidePlaceholder(Control control, Color foreground) {
		control.setForeground(foreground);
		control.setEnabled(true);
	}
	
	private static void unhideComposedPlaceholders(Composite containerView, Color foreground) {
		for (int i = 0; i < containerView.getChildren().length; i++) {
			Control child = containerView.getChildren()[i];
			
			if ((child instanceof Composite) && !(child instanceof StyledText)) {
				unhideComposedPlaceholders((Composite) child, foreground);
			} else {
				unhidePlaceholder(child, foreground);
			}
		}
	}
	
	private static void hidePlaceholder(Control control, Color hide) {
		control.setForeground(hide);
		control.setEnabled(false);
	}
	
	private static List<ViewableBrick> getRemainingChoices(
			TemplatePlaceholderBrick placeholderBrick,
			TemplatePlaceholderBrick selectedPlaceholder) {

		// Filter brick choices by current selection of other placeholders:
		EList<ViewableBrick> remaining = new BasicEList<>();

		List<ViewableBrick> superSet = placeholderBrick.getChoice().isEmpty() ? placeholderBrick.getChoices()
				: placeholderBrick.getChoice();

		for (ViewableBrick choice : superSet) {
			if (containsCodebricks(choice.getCodebrick(), selectedPlaceholder.getChoice())) {
				remaining.add(choice);
			}
		}

		return remaining;
	}
	
	private static boolean containsCodebricks(Codebrick matchCodebrick, EList<ViewableBrick> inCodebricks) {
		for (ViewableBrick inCodebrick : inCodebricks) {
			if (matchCodebrick == inCodebrick.getCodebrick()) {
				return true;
			}
		}
		return false;
	}
	
	public static List<ICompletionProposal> getProposals(TemplatePlaceholderBrick placeholderBrick) {
		List<ICompletionProposal> proposals = new ArrayList<>();
		List<ViewableBrick> choices = null;
		
		if (placeholderBrick.getChoice().isEmpty()) {
			choices = placeholderBrick.getRemainingChoices();
		} else {
			choices = placeholderBrick.getAlternativeChoices();
		}
		
		// Show equal choices in one proposal:
		Set<ViewableBrick> unlistedChoices = new HashSet<>(choices); 
		
		for (ViewableBrick choice : choices) {
			if (unlistedChoices.contains(choice)) {
				List<ViewableBrick> equalChoices = new ArrayList<>();
				
				for (ViewableBrick unlistedChoice : unlistedChoices) {
					if (TemplateCodebricksProposal.canCombineProposals(unlistedChoice, choice)) {
						equalChoices.add(unlistedChoice);
					}
				}
				
				unlistedChoices.removeAll(equalChoices);
				proposals.add(new TemplateCodebricksProposal(placeholderBrick, equalChoices));
			}
		}

		return proposals;
	}
}

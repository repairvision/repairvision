package org.sidiff.completion.ui.codebricks.editor.views;

import java.util.List;
import java.util.function.Function;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.sidiff.completion.ui.codebricks.PlaceholderBrick;
import org.sidiff.completion.ui.codebricks.editor.CodebricksEditor;
import org.sidiff.completion.ui.proposals.CompletionProposalList;
import org.sidiff.completion.ui.proposals.ICompletionProposal;

public class PlaceholderBuilder {
	
	public static <P extends PlaceholderBrick> StyledText build(
			CodebricksEditor editor, Composite parentContainer, P placeholderBrick, 
			Function<P, List<ICompletionProposal>> proposals, 
			boolean boldFont, Color foreground, Color background, boolean underline) {
		
		return build(
				editor, parentContainer, placeholderBrick, placeholderBrick.getText(),
				proposals, 
				boldFont, foreground, background, underline);
	}
	
	public static <P extends PlaceholderBrick> StyledText build(
			CodebricksEditor editor, Composite parentContainer, P placeholderBrick, String text, 
			Function<P, List<ICompletionProposal>> proposals, 
			boolean boldFont, Color foreground, Color background, boolean underline) {
		
		StyledText placeholderControl = EditableTextBrickBuilder.build(editor, parentContainer, 
				text, text, boldFont, foreground, background);
		
		// Underline the placeholder text:
		if (underline) {
			placeholderControl.addModifyListener(new ModifyListener() {
				
				@Override
				public void modifyText(ModifyEvent e) {
					StyleRange styleUnderline = new StyleRange();
					styleUnderline.start = 0;
					styleUnderline.length = placeholderControl.getText().length();
					styleUnderline.underline = true;
					placeholderControl.setStyleRange(styleUnderline);
				}
			});
		}
		
		installProposalList(editor, placeholderControl, placeholderBrick, proposals);
		
		return placeholderControl;
	}

	private static <P extends PlaceholderBrick> void installProposalList(CodebricksEditor editor,
			StyledText control, P placeholder, Function<P, List<ICompletionProposal>> proposals) {
		
		// Show proposal list:
		control.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				Display display = control.getDisplay(); // Control might be disposed during auto-completion.
				
				if(((e.stateMask & SWT.CTRL) == SWT.CTRL) && (e.keyCode == SWT.SPACE)) {
					List<ICompletionProposal> codebrickProposals = proposals.apply(placeholder);

					// Show proposals below editor:
					if (!codebrickProposals.isEmpty()) {
						CompletionProposalList proposals =  new CompletionProposalList(display);
						proposals.addProposals(codebrickProposals);
						
						int proposalsXPosition = editor.getShell().getLocation().x;
						int proposalsYPosition = editor.getShell().getLocation().y + editor.getShell().getSize().y + 5;
						proposals.showPopup(new Point(proposalsXPosition, proposalsYPosition));
					}
				}
			}
		});
	}
}

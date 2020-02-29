package org.sidiff.completion.ui.codebricks.editor.views;

import java.util.List;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.sidiff.completion.ui.codebricks.BlankBrick;
import org.sidiff.completion.ui.codebricks.Brick;
import org.sidiff.completion.ui.codebricks.ComposedBrick;
import org.sidiff.completion.ui.codebricks.IndentBrick;
import org.sidiff.completion.ui.codebricks.LineBreakBrick;
import org.sidiff.completion.ui.codebricks.ObjectPlaceholderBrick;
import org.sidiff.completion.ui.codebricks.RGB;
import org.sidiff.completion.ui.codebricks.ResetTemplatePlaceholderBrick;
import org.sidiff.completion.ui.codebricks.StyledBrick;
import org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick;
import org.sidiff.completion.ui.codebricks.TextBrick;
import org.sidiff.completion.ui.codebricks.ValuePlaceholderBrick;
import org.sidiff.completion.ui.codebricks.ViewableBrick;
import org.sidiff.completion.ui.codebricks.editor.CodebricksEditor;

public class ContentBuilder {

	public static void build(
			CodebricksEditor editor, Composite editorContent, List<? extends Brick> bricks, 
			Color foreground, Color background, Color hidde) {
		
		// Is content empty?
		if (editorContent.getChildren().length > 0) {
			clearContent(editorContent);
		}

		// Create content views:
		Composite templateExpression = null;
		
		for (Brick templateBrick : bricks) {
			Control viewControl = null;
			
			// Handle line break:
			if (templateBrick instanceof LineBreakBrick) {
				templateExpression = null;
			}
			
			// Create indent:
			if (templateBrick instanceof IndentBrick) {
				IndentBrick indentBrick = (IndentBrick) templateBrick;
				
				for (int i = 0; i < indentBrick.getBricks(); i++) {
					viewControl = EmptyBrickBuilder.build(editorContent);
				}
			}
			
			// Create composed bricks:
			else if (templateBrick instanceof ComposedBrick) {
				
				// Put template expression in last column(s):
				if (templateExpression == null) {
					templateExpression = BrickRowBuilder.build(editorContent, background);
				}
				
				Composite composedBrick = BrickRowBuilder.build(templateExpression, background);
				build(editor, composedBrick, ((ComposedBrick) templateBrick).getBricks(), foreground, background, hidde);
				viewControl = composedBrick;
			}
			
			// Create template expression:
			else if (templateBrick instanceof ViewableBrick) {
				
				// Put template expression in last column(s):
				if (templateExpression == null) {
					templateExpression = BrickRowBuilder.build(editorContent, background);
				}
				
				// Viewable brick:
				ViewableBrick viewableBrick = (ViewableBrick) templateBrick;
				boolean highlight = (viewableBrick instanceof StyledBrick) && ((StyledBrick) viewableBrick).isHighlight();
				
				if (viewableBrick instanceof StyledBrick) {
					StyledBrick styledBrick = (StyledBrick) viewableBrick;
					foreground = new Color(editor.getShell().getDisplay(), 
							styledBrick.getColor(RGB.RED),
							styledBrick.getColor(RGB.GREEN),
							styledBrick.getColor(RGB.BLUE));
				}
				
				/*
				 * Placeholder:
				 */
				
				// Create template placeholder:
				if (templateBrick instanceof TemplatePlaceholderBrick) {
					viewControl = BrickRowBuilder.build(templateExpression, background);
					TemplatePlaceholderBuilder.build(editor, (Composite) viewControl, (TemplatePlaceholderBrick) templateBrick, highlight, foreground, background, hidde);
				
				// Create value placeholder (parameter):
				} else if (templateBrick instanceof ValuePlaceholderBrick) {
					viewControl = ValuePlaceholderBuilder.build(editor, templateExpression, (ValuePlaceholderBrick) templateBrick, highlight, foreground, background);
					
				// Create object placeholder (parameter):
				} else if (templateBrick instanceof ObjectPlaceholderBrick) {
					viewControl = ObjectPlaceholderBuilder.build(editor, templateExpression, (ObjectPlaceholderBrick) templateBrick, highlight, foreground, background);
				}
				
				/*
				 * Placeholder Reset hook:
				 */
				
				else if (templateBrick instanceof ResetTemplatePlaceholderBrick) {
					StyledText resetTemplateControl = ResetTemplatePlaceholderBuilder.build(editor, templateExpression, (ResetTemplatePlaceholderBrick) templateBrick, highlight, foreground, background);
					viewControl = resetTemplateControl;
				}

				/*
				 * Basic bricks:
				 */
				
				// Create text:
				else if (viewableBrick instanceof TextBrick) {
					viewControl = TextBrickBuilder.build(templateExpression, viewableBrick.getText(), viewableBrick.getText(), highlight, foreground, background);
					
				// Create blank:
				} else if (viewableBrick instanceof BlankBrick) {
					viewControl = TextBrickBuilder.build(templateExpression, viewableBrick.getText(), viewableBrick.getText(), false, foreground, background);
				}
			}
		}
		
		// Do layout:
		editor.update();
	}
	
	private static void clearContent(Composite editorContent) {
		Control[] content = editorContent.getChildren();
		
		for (int i = 0; i < content.length; i++) {
			content[i].dispose();
		}
	}
}

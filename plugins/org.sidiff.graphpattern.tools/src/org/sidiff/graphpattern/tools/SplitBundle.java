package org.sidiff.graphpattern.tools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.IInputValidator;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.revision.common.emf.EMFHandlerUtil;
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;

public class SplitBundle extends AbstractHandler {
	
	protected int limit = 49; // count = 49 + 1

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// Ask for limit per slice:
		String limitValue = WorkbenchUtil.askForValue("Please enter the number of graphs per segment.", limit + 1 + "", new IInputValidator() {
			
			@Override
			public String isValid(String newText) {
				try {
					Integer.valueOf(newText);
				} catch (Exception e) {
					return "Please enter a positive number!";
				}
				return null;
			}
		});
		
		try {
			limit = Integer.valueOf(limitValue) - 1;
		} catch (Exception e) {
			return null;
		}
		
		// Start slicing:
		Bundle graphPatternBundle = EMFHandlerUtil.getSelection(event, Bundle.class);
		URI uri = graphPatternBundle.eResource().getURI();
		
		int checksum = 0;

		if (graphPatternBundle != null) {
			int graphPatternCount = countGraphPatterns(graphPatternBundle);
			int startCounter = 0;
			int splitCounter = 0;
			
			while (startCounter < graphPatternCount) {
				Bundle graphPatternBundleSplit = EMFHandlerUtil.getSelection(event, Bundle.class);
				startCounter = createSplit(graphPatternBundleSplit, startCounter, limit);
				
				graphPatternBundleSplit.eResource().setURI(uri.trimSegments(1).appendSegment(
						uri.trimFileExtension().lastSegment() + "_" + String.format("%03d", splitCounter))
						.appendFileExtension(uri.fileExtension()));
				++splitCounter;
				
				checksum += countGraphPatterns(graphPatternBundleSplit);
				try {
					graphPatternBundleSplit.eResource().save(Collections.EMPTY_MAP);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			assert checksum == graphPatternCount;
		}

		return null;
	}
	
	private int countGraphPatterns(Bundle graphPatternBundle) {
		int counter = 0;
		
		for (EObject element : (Iterable<EObject>) () -> graphPatternBundle.eAllContents()) {
			if (element instanceof GraphPattern) {
				++counter;
			}
		}
		
		return counter;
	}
	
	private int createSplit(Bundle graphPatternBundle, int start, int limit) {
		int startCounter = 0;
		int endCounter = 0;
		
		// split bundle by given bounds:
		List<GraphPattern> toBeRemovedGraphPatterns = new ArrayList<>();
		
		for (EObject element : (Iterable<EObject>) () -> graphPatternBundle.eAllContents()) {
			if (element instanceof GraphPattern) {
				if (startCounter < start) {
					toBeRemovedGraphPatterns.add((GraphPattern) element);
					++startCounter;
				} else {
					if (endCounter > limit) {
						toBeRemovedGraphPatterns.add((GraphPattern) element);
					} else {
						++endCounter;
					}
				}
			}
		}
		
		for (GraphPattern graphPattern : toBeRemovedGraphPatterns) {
			EcoreUtil.remove(graphPattern);
		}
		
		// remove empty graph patterns:
		List<Pattern> toBeRemovedPatterns = new ArrayList<>();
		
		for (EObject element : (Iterable<EObject>) () -> graphPatternBundle.eAllContents()) {
			if (element instanceof Pattern) {
				Pattern pattern = (Pattern) element;
				
				if (isEmptyPattern(pattern)) {
					toBeRemovedPatterns.add(pattern);
				}
			}
		}
		
		for (Pattern pattern : toBeRemovedPatterns) {
			EcoreUtil.remove(pattern);
		}
		
		assert (startCounter + endCounter) == (start + limit);
		return startCounter + endCounter;
	}
	
	private boolean isEmptyPattern(Pattern pattern) {
		if (pattern.getGraphs().isEmpty() && pattern.getPatterns().isEmpty()) {
			return true;
		} else {
			for (Pattern subpattern : pattern.getPatterns()) {
				if (!isEmptyPattern(subpattern)) {
					return false;
				}
			}
		}
		
		return pattern.getGraphs().isEmpty();
	}

}

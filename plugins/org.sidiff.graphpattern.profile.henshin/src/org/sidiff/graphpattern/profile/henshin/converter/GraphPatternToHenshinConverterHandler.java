package org.sidiff.graphpattern.profile.henshin.converter;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.profile.henshin.HenshinStereotypes;
import org.sidiff.revision.common.emf.EMFHandlerUtil;
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;

public class GraphPatternToHenshinConverterHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		Bundle bundle = EMFHandlerUtil.getSelection(event, Bundle.class);
		
		if (bundle != null) {
			convertBundle(bundle, bundle.eResource().getURI().trimFileExtension());
			WorkbenchUtil.refreshProject(event);
		}
		
		return null;
	}

	public void convertBundle(Bundle bundle, URI folder) {
		bundle.eAllContents().forEachRemaining(e -> {
			if (e instanceof GraphPattern) {
				GraphPattern graphPattern = (GraphPattern) e;
				
				if (graphPattern.getStereotypes().contains(HenshinStereotypes.rule)) {
					GraphPatternToHenshinConverter converter = createConverter(graphPattern.getPattern());
					
					URI uri = folder.appendSegment(graphPattern.getName().replaceAll("\\W", "")).appendFileExtension("henshin");
					Resource resource = converter.getResource(uri);
					
					try {
						resource.save(Collections.emptyMap());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}
	
	protected GraphPatternToHenshinConverter createConverter(Pattern editOperation) {
		return new GraphPatternToHenshinConverter(editOperation);
	}
}

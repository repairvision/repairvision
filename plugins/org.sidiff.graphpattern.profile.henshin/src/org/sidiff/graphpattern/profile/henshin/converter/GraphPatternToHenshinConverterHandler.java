package org.sidiff.graphpattern.profile.henshin.converter;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.modelstorage.EMFHandlerUtil;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.profile.henshin.HenshinStereotypes;

public class GraphPatternToHenshinConverterHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		Bundle bundle = EMFHandlerUtil.getSelection(event, Bundle.class);
		
		if (bundle != null) {
			bundle.eAllContents().forEachRemaining(e -> {
				if (e instanceof GraphPattern) {
					GraphPattern graphPattern = (GraphPattern) e;
					
					if (graphPattern.getStereotypes().contains(HenshinStereotypes.rule)) {
						GraphPatternToHenshinConverter converter = new GraphPatternToHenshinConverter();
						converter.convert(graphPattern);
						
						Resource resource = converter.getResource(bundle.eResource().getURI().trimFileExtension()
								.appendSegment(graphPattern.getName()).appendFileExtension("henshin"));
						
						try {
							resource.save(Collections.emptyMap());
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
		}
		
		return null;
	}

}

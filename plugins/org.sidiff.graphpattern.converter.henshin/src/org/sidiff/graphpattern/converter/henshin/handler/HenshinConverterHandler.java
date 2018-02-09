package org.sidiff.graphpattern.converter.henshin.handler;
import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.sidiff.graphpattern.converter.henshin.HenshinConverter;

public class HenshinConverterHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		if (!selection.isEmpty()) {
			if (selection instanceof IStructuredSelection) {
				Object firstElement = ((IStructuredSelection) selection).getFirstElement();
				
				if (firstElement instanceof IResource) {
					String fileExtension = ((IResource) firstElement).getFileExtension();
					
					if (fileExtension.equalsIgnoreCase("henshin")) {
						String fullPath = ((IResource) firstElement).getLocation().toFile().getAbsolutePath();
						String projectName = ((IResource) firstElement).getProject().getName();
						String filePath = ((IResource) firstElement).getProjectRelativePath().toOSString();
						String platformPath = projectName + "/" + filePath;
						
						ResourceSet henshinRSS = new ResourceSetImpl();
						Resource moduleRes = henshinRSS.getResource(
								URI.createPlatformResourceURI(platformPath, true), true);
						Module module = (Module) moduleRes.getContents().get(0);
						
						// TODO: Support multiple rules and graphs.
						Rule rule = (Rule) module.getUnits().get(0);
						
						HenshinConverter converter = new HenshinConverter(rule);
						ResourceSet patternRSS = new ResourceSetImpl();
						Resource patternRes = patternRSS.createResource(
								URI.createFileURI(fullPath + ".graphpattern"));
						patternRes.getContents().add(converter.getGraphPattern());
						
						try {
							patternRes.save(null);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		
		return null;
	}
}

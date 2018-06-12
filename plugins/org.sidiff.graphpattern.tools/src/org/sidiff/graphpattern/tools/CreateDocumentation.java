package org.sidiff.graphpattern.tools;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.common.tools.api.resource.ImageFileFormat;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.ui.handlers.HandlerUtil;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;

public class CreateDocumentation extends AbstractHandler {

	protected static final String FOLDER = "doc";
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);

		if (!selection.isEmpty() && (selection instanceof StructuredSelection) && (((StructuredSelection) selection).getFirstElement() instanceof IResource)) {
			IResource resource = ((IResource) ((StructuredSelection) selection).getFirstElement());
			IProject project = resource.getProject();
			URI uri = URI.createPlatformResourceURI(project.getName() + "/" + resource.getProjectRelativePath().toString(), true);
	        
			Bundle graphPatternBundle = null;
			
			// create SVG diagram:
			Map<GraphPattern, String> diagramPaths = new HashMap<>();
			Session session = SessionManager.INSTANCE.getSession(uri.trimFileExtension().appendFileExtension("aird"), new NullProgressMonitor());
	        
	        if (session != null) {
	            Collection<DRepresentation> dRepresentationsToExportAsImage = DialectManager.INSTANCE.getAllRepresentations(session);
	            
	            for (DRepresentation dRepresentation : dRepresentationsToExportAsImage) {
	            	
	            	// create output folder:
	            	String localPath = FOLDER + File.separator + dRepresentation.getName();
	            	new File(project.getLocation().toFile().getAbsolutePath() + File.separator + localPath).mkdirs();
	            	IPath outputPath = project.getFolder(localPath).getLocation();
	            	
	            	// export image:
	            	new DiagramExportAction(session, Collections.singleton(dRepresentation), outputPath, ImageFileFormat.SVG, true, true);
	            	
	            	// map diagram an graph pattern:
	            	String htmlDocLink = null;
	            	GraphPattern graphPattern = null;
	            	
					try {
						
						// get HTML path:
						IResource htmlDoc = Arrays.asList(project.getFolder(localPath).members()).stream()
								.filter(r -> r.getFileExtension().equals("html")).findFirst().get();
						htmlDocLink = htmlDoc.getLocation().makeRelativeTo(project.getFolder(FOLDER).getLocation())
								.toPortableString();

						// get Graph Pattern of diagram:
						graphPattern = ((NodePattern) dRepresentation.getRepresentationElements().stream()
								.filter(e -> e.getTarget() instanceof NodePattern).findFirst().get().getTarget())
										.getGraph();

					} catch (Exception e) {
						e.printStackTrace();
					}
					
					if ((htmlDocLink != null) && (graphPattern != null)) {
						diagramPaths.put(graphPattern, htmlDocLink);
						
						if (graphPatternBundle == null) {
							graphPatternBundle = graphPattern.getPattern().getBundle();
						}
					} else {
						System.err.println("Missing Diagram: " + dRepresentation);
					}
				}
	        }
			
			// create HTML list:
	        if (graphPatternBundle != null) {
	        	StringBuffer doc = new StringBuffer();
	        	
	        	doc.append("<ul>");
	        	doc.append("\n");
	        	
	        	for (Pattern pattern : graphPatternBundle.getPatterns()) {
	        		generateItem(doc, pattern, diagramPaths);
	        	}
	        	
	        	doc.append("</ul>");
	        	doc.append("\n");
	        	
	        	// write file:
	        	FileWriter fileWriter = null;
	        	
	        	try {
	        		File file = new File(project.getFolder(FOLDER).getLocation().toOSString() + File.separator + graphPatternBundle.getName() + ".html");
	        		fileWriter = new FileWriter(file);
	        		fileWriter.write(doc.toString());
	        		fileWriter.flush();
	        	} catch (IOException e) {
	        		e.printStackTrace();
	        	} finally {
	        		if (fileWriter != null) {
	        			try {
	        				fileWriter.close();
	        			} catch (IOException e) {
	        				e.printStackTrace();
	        			}
	        		}
	        	}
	        }
			
			// show new file in workspace:
			try {
				project.refreshLocal(IProject.DEPTH_INFINITE, new NullProgressMonitor());
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	public void generateItem(StringBuffer doc, Pattern pattern, Map<GraphPattern, String> diagramPaths) {
		
		// item:
		doc.append("<li>");
		doc.append(pattern.getName());
		doc.append("</li>");
		doc.append("\n");
		
		// children:
		doc.append("<ul>");
		doc.append("\n");
		
		// sub-patterns:
		for (Pattern subPattern : pattern.getSubpatterns()) {
			generateItem(doc, subPattern, diagramPaths);
		}
		
		// graph patterns:
		for (GraphPattern graphPattern : pattern.getGraphs()) {
			doc.append("<li>");
			doc.append("<a href=\"" + diagramPaths.get(graphPattern) + "\">");
			doc.append(graphPattern.getName());
			doc.append("</a>");
			doc.append("</li>");
		}
		
		doc.append("</ul>");
		doc.append("\n");
	}
}

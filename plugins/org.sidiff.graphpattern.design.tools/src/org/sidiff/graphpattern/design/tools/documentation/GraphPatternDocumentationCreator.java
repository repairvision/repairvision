package org.sidiff.graphpattern.design.tools.documentation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.common.tools.api.resource.ImageFileFormat;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.design.tools.diagram.DiagramExportAction;
import org.sidiff.graphpattern.edit.util.LabelServices;

public class GraphPatternDocumentationCreator {
	
	private String folder = "doc";
	
	private boolean simplifyTree = true;
	
	private boolean generateSVG = true;
	
	private boolean embeddedSVG  = true;
	
	/**
	 * @param folder       The the documentation folder relative to the project.
	 * @param simplifyTree Simplify/Merge tree nodes that contain just one child node?
	 * @param generateSVG  Generate diagrams?
	 * @param embeddedSVG  Embed SVG into HTML?
	 */
	public GraphPatternDocumentationCreator(String folder, boolean simplifyTree, boolean generateSVG, boolean embeddedSVG) {
		this.folder = folder;
		this.simplifyTree = simplifyTree;
		this.generateSVG = generateSVG;
		this.embeddedSVG = embeddedSVG;
	}
	
	/**
	 * @param simplifyTree Simplify/Merge tree nodes that contain just one child node?
	 * @param generateSVG  Generate diagrams?
	 * @param embeddedSVG  Embed SVG into HTML?
	 */
	public GraphPatternDocumentationCreator(boolean simplifyTree, boolean generateSVG, boolean embeddedSVG) {
		this.simplifyTree = simplifyTree;
		this.generateSVG = generateSVG;
		this.embeddedSVG = embeddedSVG;
	}
	
	public GraphPatternDocumentationCreator() {
	}
	
	public void createDocumentation(IResource resource, Bundle graphPatternBundle) {
		IProject project = resource.getProject();
		
		// create output folder:
		new File(project.getLocation().toFile().getAbsolutePath() + File.separator + folder).mkdirs();
		
		// generate SVG diagrams:
		if (generateSVG) {
			generateSVGDiagrams(resource);
		}
		
		// generate HTML list:
		String docPath = project.getFolder(folder).getLocation().toOSString() + File.separator + graphPatternBundle.getName().toLowerCase() + ".html";
    	generateHTMLList(graphPatternBundle, docPath);
		
		// show new file in workspace:
		try {
			project.refreshLocal(IProject.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	private Map<String, GraphPattern> generateSVGDiagrams(IResource diagramResource) {
		
		Map<String, GraphPattern> links = new HashMap<>();
		
		// create SVG diagram:
		URI uri = URI.createPlatformResourceURI(diagramResource.getProject().getName() + "/" + diagramResource.getProjectRelativePath().toString(), true);
		Session session = SessionManager.INSTANCE.getSession(uri.trimFileExtension().appendFileExtension("aird"), new NullProgressMonitor());
	
		if (session != null) {
			Collection<DRepresentation> dRepresentationsToExportAsImage = DialectManager.INSTANCE.getAllRepresentations(session);
	
			for (DRepresentation dRepresentation : dRepresentationsToExportAsImage) {
	
				// get Graph Pattern of diagram:
				GraphPattern graphPattern = ((NodePattern) dRepresentation.getRepresentationElements().stream()
						.filter(e -> e.getTarget() instanceof NodePattern).findFirst().get().getTarget())
						.getGraph();
				
				// create output path:
				String pathName = getDiagramPath(graphPattern);
				String localPath = folder + File.separator + pathName;
				File outputFolder = new File(diagramResource.getProject().getLocation().toFile().getAbsolutePath() + File.separator + localPath);
				
				// Skip already existing:
				if (outputFolder.exists()) {
					continue;
				}
				
				// create output folder:
				outputFolder.mkdir();
				IPath outputPath = diagramResource.getProject().getFolder(localPath).getLocation();
				
				// export image:
				new DiagramExportAction(session, Collections.singleton(dRepresentation), outputPath, ImageFileFormat.SVG, true, true);
	
				// map diagram an graph pattern:
				String htmlDocLink = null;
				String svgDocLink = null;
	
				BufferedReader docReaderBuffer = null;
				FileWriter htmlDocWriter = null;
	
				// get HTML path:
				IPath htmlPath = null; 
				
				try {
					IResource htmlDoc = Arrays.asList(diagramResource.getProject().getFolder(localPath).members()).stream()
							.filter(r -> r.getFileExtension().equals("html")).findFirst().get();
					htmlDoc.move(htmlDoc.getFullPath().removeLastSegments(1).append(getDiagramNameHTML(graphPattern)), true, null);
					
					htmlPath = htmlDoc.getLocation().removeLastSegments(1).append(getDiagramNameHTML(graphPattern));
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				htmlDocLink = htmlPath.makeRelativeTo(diagramResource.getProject().getFolder(folder).getLocation()).toPortableString();
				
				// get SVG path:
				IPath svgPath = null;
				
				try {
					IResource svgDoc = Arrays.asList(diagramResource.getProject().getFolder(localPath).members()).stream()
							.filter(r -> r.getFileExtension().equals("svg")).findFirst().get();
					svgDoc.move(svgDoc.getFullPath().removeLastSegments(1).append(getDiagramNameSVG(graphPattern)), true, null);
					
					svgPath = svgDoc.getLocation().removeLastSegments(1).append(getDiagramNameSVG(graphPattern));
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				svgDocLink = svgPath.makeRelativeTo(diagramResource.getProject().getFolder(localPath).getLocation()).toPortableString();
				
				try {
	
					// write HTML file:
					StringBuilder newHtmlDoc = new StringBuilder(); 
					
					if (embeddedSVG) {
						
						// create embedded SVG with Drag'n'Drop support:
						newHtmlDoc.append(
								"<html>\r\n" + 
								"<head>\r\n" + 
								"<title>" + graphPattern.getName() +"</title>\r\n" + 
								"<style>\r\n" + 
								"body {\r\n" + 
								"  font: 300 16px/1.2 'Roboto', Arial, sans-serif; color: #666;\r\n" + 
								"}\r\n" + 
								"@font-face {\r\n" + 
								"  font-family: 'Roboto';\r\n" + 
								"  font-style: normal;\r\n" + 
								"  font-weight: 300;\r\n" + 
								"  src: local('Roboto Light'), local('Roboto-Light'), url(https://fonts.gstatic.com/s/roboto/v15/Hgo13k-tfSpn0qi1SFdUfVtXRa8TVwTICgirnJhmVJw.woff2) format('woff2');\r\n" + 
								"  unicode-range: U+0000-00FF, U+0131, U+0152-0153, U+02C6, U+02DA, U+02DC, U+2000-206F, U+2074, U+20AC, U+2212, U+2215, U+E0FF, U+EFFD, U+F000;\r\n" + 
								"}\r\n" + 
								"</style>" +
								"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/gsap/2.1.2/TweenLite.min.js\"></script>\r\n" + 
								"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/gsap/2.1.2/utils/Draggable.min.js\"></script>\r\n" + 
								"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/gsap/2.1.2/plugins/CSSPlugin.min.js\"></script>\r\n" + 
								"</head>\r\n" + 
								"<body>"
								);
						newHtmlDoc.append("\n");
						
						String graphStereotype = LabelServices.getStereotypesLabel(graphPattern.getStereotypes()).replace("<", "&lt;").replace(">", "&gt;");
						newHtmlDoc.append("<hr style=\"border:solid #1abc9c 2px;\">");
						newHtmlDoc.append("<p>" + graphStereotype + " " + graphPattern.getName() + "</p>");
						newHtmlDoc.append("<hr style=\"border:solid #1abc9c 2px;\">");
						
						FileReader docReader = new FileReader(svgPath.toFile());
						docReaderBuffer = new BufferedReader(docReader);
	
						String line = docReaderBuffer.readLine();
						
						while (line != null) {
							newHtmlDoc.append(line + "\n");
							line = docReaderBuffer.readLine();
						}
						
						newHtmlDoc.append("<script>\r\n" + 
								"Draggable.create(document.getElementsByTagName('rect'), {type:\"x,y\"})\r\n" + 
								"Draggable.create(document.getElementsByTagName('text'), {type:\"x,y\"})\r\n" + 
								"Draggable.create(document.getElementsByTagName('line'), {type:\"x,y\"})\r\n" + 
								"Draggable.create(document.getElementsByTagName('image'), {type:\"x,y\"})\r\n" + 
								"</script>\r\n" + 
								"\r\n" + 
								"</body>\r\n" + 
								"</html>"
								);
					} else {
						
						// >> fix: make HTML hyperlinks relative <<
						FileReader docReader = new FileReader(htmlPath.toFile());
						docReaderBuffer = new BufferedReader(docReader);
	
						String line = docReaderBuffer.readLine();
						
						while (line != null) {
							line = line.replaceAll("data=\".*?\"", "data=\"" + svgDocLink + "\"");
							line = line.replaceAll("src=\".*?\"", "data=\"" + svgDocLink + "\"");
	
							newHtmlDoc.append(line + "\n");
							line = docReaderBuffer.readLine();
						}
					}
	
					htmlDocWriter = new FileWriter(htmlPath.toFile());
					htmlDocWriter.write(newHtmlDoc.toString());
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (docReaderBuffer != null) {
						try {
							docReaderBuffer.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (htmlDocWriter != null) {
						try {
							htmlDocWriter.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				
				// remove SVG file:
				if (embeddedSVG) {
					svgPath.toFile().delete();
				}
				
				links.put(htmlDocLink, graphPattern);
			}
		}
		
		return links;
	}

	private void generateHTMLList(Bundle graphPatternBundle, String docPath) {
		StringBuilder doc = new StringBuilder();
		
		doc.append(
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<title>" + graphPatternBundle.getName() + " Patterns</title>\r\n" + 
				"<style>\r\n" + 
				"body {\r\n" + 
				"  font: 300 16px/1.2 'Roboto', Arial, sans-serif; color: #666;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"a {\r\n" + 
				"  color: #1abc9c;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"@font-face {\r\n" + 
				"  font-family: 'Roboto';\r\n" + 
				"  font-style: normal;\r\n" + 
				"  font-weight: 300;\r\n" + 
				"  src: local('Roboto Light'), local('Roboto-Light'), url(https://fonts.gstatic.com/s/roboto/v15/Hgo13k-tfSpn0qi1SFdUfVtXRa8TVwTICgirnJhmVJw.woff2) format('woff2');\r\n" + 
				"  unicode-range: U+0000-00FF, U+0131, U+0152-0153, U+02C6, U+02DA, U+02DC, U+2000-206F, U+2074, U+20AC, U+2212, U+2215, U+E0FF, U+EFFD, U+F000;\r\n" + 
				"}\r\n" + 
				"		\r\n" + 
				"#searchBox {\r\n" + 
				"  background-image: url('searchicon.png'); /* Add a search icon to input */\r\n" + 
				"  background-position: 10px 12px; /* Position the search icon */\r\n" + 
				"  background-repeat: no-repeat; /* Do not repeat the icon image */\r\n" + 
				"  width: 100%; /* Full-width */\r\n" + 
				"  font-size: 16px; /* Increase font-size */\r\n" + 
				"  padding: 12px 20px 12px 40px; /* Add some padding */\r\n" + 
				"  border: 1px solid #ddd; /* Add a grey border */\r\n" + 
				"  margin-bottom: 12px; /* Add some space below the input */\r\n" + 
				"}\r\n" + 
				"</style>" +
				"</head>\r\n" + 
				"<body>"
				);
		
		// search box:
		doc.append("<input type=\"text\" id=\"searchBox\" onkeyup=\"search()\" placeholder=\"Search by keys..\">");
		
		// collapse all:
		doc.append("<a href=\"javascript:collapseAll()\">collapse all</a> &#124; <a href=\"javascript:uncollapseAll()\">expand all</a>");
		
		// list:
		doc.append("<ul id=\"searchContent\">");
		doc.append("\n");
		
		for (Pattern pattern : graphPatternBundle.getPatterns()) {
			generateHTMLListItem(doc, pattern);
		}
		
		doc.append("</ul>");
		doc.append("\n");
		
		// search script:
		doc.append("<script>\r\n");
		
		doc.append(
				"function search() {\r\n" + 
				"  // Declare variables\r\n" + 
				"  var input, filter, filters, ul, li, a, i, txtValue;\r\n" + 
				"  input = document.getElementById('searchBox');\r\n" + 
				"  filter = input.value.toUpperCase();\r\n" + 
				"  filters = filter.split(' ');\r\n" + 
				"  ul = document.getElementById('searchContent');\r\n" + 
				"  li = ul.getElementsByTagName('li');\r\n" + 
				"\r\n" + 
				"  if (filter == '') {\r\n" + 
				"    for (i = 0; i < li.length; i++) {\r\n" + 
				"      li[i].style.display = \"\";\r\n" + 
				"    }\r\n" + 
				"	return;\r\n" + 
				"  } else {\r\n" +
				"    uncollapseAll();" +
				"  }\r\n" + 
				"\r\n" + 
				"  // Loop through all list items, and hide those who don't match the search query\r\n" + 
				"  for (i = 0; i < li.length; i++) {\r\n" + 
				"    txtValue = li[i].innerText;\r\n" + 
				"    if (containsAll(filters, txtValue)) {\r\n" + 
				"      li[i].style.display = \"\";\r\n" + 
				"    } else {\r\n" + 
				"      li[i].style.display = \"none\";\r\n" + 
				"    }\r\n" + 
				"  }\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"function containsAll(filters, txtValue) {\r\n" + 
				"  for (i = 0; i < filters.length; i++) {\r\n" + 
				"    if (txtValue.toUpperCase().indexOf(filters[i]) < 0) {\r\n" + 
				"	  return false;\r\n" + 
				"	}\r\n" + 
				"  }\r\n" + 
				"  return true;\r\n" + 
				"}\r\n"
				);
		
		// collapse/uncollapse script:
		doc.append(
				"\r\n" + 
				"document.addEventListener('click', function(e) {\r\n" + 
				"  e = e || window.event;\r\n" + 
				"  var target = e.target || e.srcElement;\r\n" + 
				"\r\n" + 
				"  if (target.tagName == 'A') {\r\n" + 
				"    if (target.getAttribute('href') !== '#') {" +
				"      return;" +
				"    }" +
				"    target = target.parentNode;\r\n" + 
				"  }\r\n" + 
				"\r\n" + 
				"  if (target.tagName !== 'LI') {\r\n" + 
				"    return;\r\n" + 
				"  }\r\n" + 
				"\r\n" + 
				"  // set the style of the items:\r\n" + 
				"  if (target.nextSibling.nextSibling.tagName == 'UL') {\r\n" + 
				"    var ul = target.nextSibling.nextSibling;\r\n" + 
				"	\r\n" + 
				"	if (ul.style.display == 'none') {\r\n" + 
				"	  ul.style.display = ''\r\n" + 
				"	} else {\r\n" + 
				"	  ul.style.display = 'none'\r\n" + 
				"	}\r\n" + 
				"  }}, false);\r\n" + 
				"\r\n" + 
				"function collapseAll() {\r\n" + 
				"  ul = document.getElementById('searchContent');\r\n" + 
				"  uls = ul.getElementsByTagName('ul');\r\n" + 
				"\r\n" + 
				"  for (i = 0; i < uls.length; i++) {\r\n" + 
				"    uls[i].style.display = 'none';\r\n" + 
				"  }\r\n" + 
				"}\r\n" + 
				"function uncollapseAll() {\r\n" + 
				"  ul = document.getElementById('searchContent');\r\n" + 
				"  uls = ul.getElementsByTagName('ul');\r\n" + 
				"\r\n" + 
				"  for (i = 0; i < uls.length; i++) {\r\n" + 
				"    uls[i].style.display = '';\r\n" + 
				"  }\r\n" + 
				"}"
				);
		
		doc.append("</script>\r\n");
		
		doc.append(
				"</body>\r\n" + 
				"</html>"
				);
		
		// write file:
		FileWriter fileWriter = null;
		
		try {
			File file = new File(docPath);
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
	
	private void generateHTMLListItem(StringBuilder doc, Pattern pattern) {
		
		// item:
		// simplifyTree: Hide sub-patterns that contain only graph patterns and no other sub-patterns
		if (!simplifyTree || !(pattern.getPatterns().size() == 0)) {
			String patternStereotype = LabelServices.getStereotypesLabel(pattern.getStereotypes()).replace("<", "&lt;").replace(">", "&gt;");;
			
			doc.append("<li>");
			doc.append("<a href=\"#\" style=\"color:#666; text-decoration: none\">");
			doc.append(patternStereotype + " " + pattern.getName());
			doc.append("</a>");
			doc.append("</li>");
			doc.append("\n");	
		}
		
		// children:
		doc.append("<ul>");
		doc.append("\n");
		
		// sub-patterns:
		if (!simplifyTree) {
			for (Pattern subPattern : pattern.getPatterns()) {
				generateHTMLListItem(doc, subPattern);
			}
		}
		
		// graph patterns:
		for (GraphPattern graphPattern : pattern.getGraphs()) {
			String graphStereotype = LabelServices.getStereotypesLabel(graphPattern.getStereotypes()).replace("<", "&lt;").replace(">", "&gt;");
			String pathName = getDiagramPath(graphPattern);
			
			doc.append("<li>");
			doc.append("<a href=\"" + pathName + "/" + getDiagramNameHTML(graphPattern) + "\">");
			doc.append(graphStereotype + " " + graphPattern.getName());
			doc.append("</a>");
			doc.append("</li>");
		}
		
		if (!pattern.getGraphs().isEmpty()) {
			doc.append("\n");
		}
		
		// simplifyTree: generate sub-pattern after (leaf) graph patterns
		if (simplifyTree) {
			for (Pattern subPattern : pattern.getPatterns()) {
				generateHTMLListItem(doc, subPattern);
			}
		}
		
		doc.append("</ul>");
		doc.append("\n");
	}
	
	protected String getDiagramPath(GraphPattern graphPattern) {
		return LabelServices.getLabel(graphPattern).replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
	}
	
	protected String getDiagramNameHTML(GraphPattern graphPattern) {
		return "diagram.html";
	}
	
	protected String getDiagramNameSVG(GraphPattern graphPattern) {
		return "diagram.svg";
	}
}

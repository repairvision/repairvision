package org.sidiff.repair.history.generator.analyzer;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.repair.history.generator.metadata.DataSetMetadata;
import org.sidiff.repair.history.generator.metadata.HistoryMetadata;
import org.sidiff.repair.history.generator.metadata.VersionMetadata;

public class EcoreHistoryResolverApplication implements IApplication {
	
	Map<String, HistoryMetadata> modelFiles = new HashMap<>();

	@Override
	public Object start(IApplicationContext context) throws Exception {
		DataSetMetadata dataset = new DataSetMetadata("C:\\evaluation\\");
		
		for (HistoryMetadata history : dataset.getHistories()) {
			modelFiles.put(new File(history.getLatestFilePath()).getName(), history);
		}
		
		Set<String> repositories = new HashSet<>();
		
		// FILTER:
//		repositories.add("https://github.com/eclipse/birt");

		for (HistoryMetadata history : dataset.getHistories()) {
			if (!repositories.contains(history.getDatafile().getParent()) && !repositories.contains(history.getRepositoryURL())) {
				repositories.add(history.getDatafile().getParent());
				
				System.out.println(history.getProjectName() + " : " + history.getRepositoryURL());
				
				for (File commitFolder : history.getDatafile().getParentFile().listFiles()) {
					if (commitFolder.isDirectory() && !commitFolder.getName().contains("_resolved")) {
						try {
							resolve(searchModels(commitFolder));
						} catch (Exception e) {
							System.err.println(commitFolder);
							throw e;
						}
					}
				}
				
				System.out.println("FILTER: repositories.add(\"" +  history.getRepositoryURL()  + "\");");
			}
		}
		
		return IApplication.EXIT_OK;
	}
	
	protected void resolve(List<File> models) {
		
		// Make URIs to related models relative:
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		Set<String> modelNames = models.stream().map(File::getName).collect(Collectors.toSet()); 
		Set<String> relatedModelNames = new HashSet<>();
		
		URIHandlerImpl uriHandler = new URIHandlerImpl() {
			
			@Override
			public URI resolve(URI uri) {
				URI newURI = uri;
				
				if (uri.toString().contains("Ecore.ecore")) {
					
					// ../../../../../../../org.eclipse.emf.ecore/model/Ecore.ecore#//EString
					// platform:/resource/org.eclipse.emf.ecore/model/Ecore.ecore#//EString
					newURI = URI.createURI("http://www.eclipse.org/emf/2002/Ecore#" + uri.fragment());
				} else {
					
					// Make URIs to related models relative:
					String modelName = uri.lastSegment();
					
					if (modelNames.contains(modelName)) {
						newURI = URI.createURI(modelName).appendFragment(uri.fragment());
					} else {
						
						// Find model in other repository:
						if (modelFiles.containsKey(modelName)) {
							HistoryMetadata relatedHistory = modelFiles.get(modelName);
							VersionMetadata lastVersion = relatedHistory.getVersions().get(relatedHistory.getVersions().size() - 1);
							
							newURI = URI.createFileURI(relatedHistory.getDatafile().getParent() + lastVersion.getLocalFilePath());
							newURI = newURI.appendFragment(uri.fragment());
							
							relatedModelNames.add(new File(lastVersion.getLocalFilePath()).getName());
						}
						
						// Check if model element can be found:
						if (!tryResolve(newURI, true)) {
							System.err.println(uri);
							newURI = uri;
						}
					}
				}
				
				return newURI;
			}
			
			private boolean tryResolve(URI modelURI, boolean loadOnDemand) {
				try {
					EObject obj = resourceSet.getEObject(modelURI, loadOnDemand);
					
					if ((obj != null) && !obj.eIsProxy()) {
						return true;
					}
				} catch (Exception e) {
				}
				return false;
			}
		};
		
		// Load models:
		resourceSet.getLoadOptions().put(XMIResource.OPTION_URI_HANDLER, uriHandler);
		
		for (File model : models) {
			resourceSet.getResource(URI.createFileURI(model.getAbsolutePath()), true);
		}
		
		// Save resolved models:
		String folder = models.get(0).getParent() + "_resolved";
		
		for (Resource model : resourceSet.getResources()) {
			String modelName = model.getURI().segment(model.getURI().segmentCount() - 1);
			URI resolvedURI = URI.createFileURI(folder).appendSegment(modelName);
			model.setURI(resolvedURI);
		}
		
		for (Resource model : resourceSet.getResources()) {
			try {
				Map<String, Object> options = new HashMap<String, Object>();
				options.put(XMIResource.OPTION_URI_HANDLER, new URIHandlerImpl() {
					
					@Override
					public URI deresolve(URI uri) {
						
						if (modelNames.contains(uri.lastSegment()) || relatedModelNames.contains(uri.lastSegment())) {
							return URI.createURI(uri.lastSegment()).appendFragment(uri.fragment());
						}
						
						return super.resolve(uri);
					}
				});
				
				model.save(options);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	protected List<File> searchModels(File root) {
		List<File> files = new ArrayList<>();
		
		FileFilter filter = new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				if (!pathname.isDirectory()) {
					if (pathname.getName().toLowerCase().endsWith(".ecore")) {
						return true;
					}
				}
				return false;
			}
		};
		
		files.addAll(Arrays.asList(root.listFiles(filter)));
		Collections.sort(files);

		return files;
	}

	@Override
	public void stop() {
	}
}

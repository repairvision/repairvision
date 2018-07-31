package org.sidiff.repair.history.generator.analyzer;

import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
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
			for (VersionMetadata version : history.getVersions()) {
				String modelName = version.getFileName();
				
				// FIXME: Technically, we have to know the plug-in relative path!
				if (!modelFiles.containsKey(modelName)) {
					modelFiles.put(modelName, history);
				}
			}
		}
		
		Set<String> repositories = new HashSet<>();
		
		// FILTER:
		repositories.add("http://git.eclipse.org/c/eef/org.eclipse.eef.git"); // TODO
		repositories.add("http://git.eclipse.org/c/emfcompare/org.eclipse.emf.compare.git"); // TODO
		repositories.add("http://git.eclipse.org/c/edapt/org.eclipse.emf.edapt.git"); // TODO
		repositories.add("https://git.eclipse.org/c/emf/org.eclipse.emf.git"); // TODO
		repositories.add("http://git.eclipse.org/c/gmf-tooling/org.eclipse.gmf-tooling.git"); //TODO
		repositories.add("http://git.eclipse.org/c/ocl/org.eclipse.ocl.git"); // TODO
		repositories.add("http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.git"); // TODO
		repositories.add("http://git.eclipse.org/c/rmf/org.eclipse.rmf.git"); // TODO
		repositories.add("http://git.eclipse.org/c/sphinx/org.eclipse.sphinx.git"); // TODO
		repositories.add("http://git.eclipse.org/c/mmt/org.eclipse.atl.git"); // TODO
		repositories.add("http://git.eclipse.org/c/mmt/org.eclipse.qvto.git"); // TODO
		repositories.add("http://git.eclipse.org/c/acceleo/org.eclipse.acceleo.git"); // TODO
		repositories.add("http://git.eclipse.org/c/m2t/org.eclipse.xpand.git"); // TODO
		repositories.add("http://git.eclipse.org/c/mdht/org.eclipse.mdht.git"); // TODO
		repositories.add("http://git.eclipse.org/c/bpmn2/org.eclipse.bpmn2.git"); // TODO
		repositories.add("http://git.eclipse.org/c/modisco/org.eclipse.modisco.git"); // TODO
		repositories.add("http://git.eclipse.org/c/sirius/org.eclipse.sirius.git"); // TODO
		repositories.add("http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git"); // TODO

		
		repositories.add("https://github.com/eclipse/birt");
		repositories.add("http://git.eclipse.org/c/datatools/org.eclipse.datatools.git");
		repositories.add("http://git.eclipse.org/c/platform/eclipse.platform.ui.git");
		repositories.add("http://git.eclipse.org/c/eatop/org.eclipse.eatop.git");
		repositories.add("https://github.com/eclipse/elk");
		repositories.add("http://git.eclipse.org/c/cdo/cdo.git");
		repositories.add("http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.coevolution.git");
		repositories.add("http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.core.git");
		repositories.add("http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.patch.git");
		repositories.add("http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.patterns.git");
		repositories.add("http://git.eclipse.org/c/egf/org.eclipse.emf.egf.git");
		repositories.add("http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git");
		repositories.add("http://git.eclipse.org/c/emf-store/org.eclipse.emf.emfstore.core.git");
		repositories.add("http://git.eclipse.org/c/henshin/org.eclipse.emft.henshin.git");
		repositories.add("http://git.eclipse.org/c/texo/org.eclipse.emf.texo.git");
		repositories.add("https://github.com/eclipse/wazaabi");
		repositories.add("http://git.eclipse.org/c/epsilon/org.eclipse.epsilon.git");
		repositories.add("http://git.eclipse.org/c/fmc/org.eclipse.fmc.core.git");
		repositories.add("http://git.eclipse.org/c/gmf-notation/org.eclipse.gmf.notation.git");
		repositories.add("https://github.com/eclipse/gmp.graphiti");
		repositories.add("https://github.com/eclipse/xtext-core/");
		repositories.add("https://github.com/eclipse/eavp");
		repositories.add("http://git.eclipse.org/c/camf/org.eclipse.camf.git");
		repositories.add("https://github.com/eclipse/b3");
		repositories.add("http://git.eclipse.org/c/dltk/org.eclipse.dltk.core.git");
		repositories.add("https://github.com/eclipse/dltk.javascript");
		repositories.add("http://git.eclipse.org/c/ogee/org.eclipse.ogee.git");
		repositories.add("http://git.eclipse.org/c/pmf/org.eclipse.pmf.git");
		

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
							System.err.println(history.getRepositoryURL());
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
			try {
				resourceSet.getResource(URI.createFileURI(model.getAbsolutePath()), true);
			} catch (Exception e) {
				HistoryMetadata metadata = modelFiles.get(model.getName());
				
				if (metadata != null) {
					
					// FIXME: Automated repair of download content!
					String folder = model.getParent();
					String url = metadata.getRepositoryURL() + "/plain/" + metadata.getLatestFilePath() + "?id=" + folder.substring(folder.lastIndexOf("_") + 1, folder.length());
					
					try {
						URL file = new URL(url);
						ReadableByteChannel rbc = Channels.newChannel(file.openStream());
						FileOutputStream fos = new FileOutputStream(model);
						fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
						fos.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
					try {
						resourceSet.getResource(URI.createFileURI(model.getAbsolutePath()), true);
					} catch (Exception e2) {
						System.err.println(metadata.getLatestFilePath());
						System.err.println(model.getAbsolutePath());
						throw e;
					}
				} else {
					System.err.println(model.getAbsolutePath());
					throw e;
				}
			}
		}
		
		// Save resolved models:
		String folder = models.get(0).getParent() + "_resolved";
		
		for (Resource model : resourceSet.getResources()) {
			if (!model.getURI().isEmpty()) {
				String modelName = model.getURI().segment(model.getURI().segmentCount() - 1);
				URI resolvedURI = URI.createFileURI(folder).appendSegment(modelName);
				model.setURI(resolvedURI);
			}
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
				
				try {
					model.save(options);
				} catch(Exception e) {
					System.err.println(model.getURI());
					throw e;
				}
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

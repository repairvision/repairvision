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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.repair.history.generator.metadata.DataSetMetadata;
import org.sidiff.repair.history.generator.metadata.HistoryMetadata;
import org.sidiff.repair.history.generator.metadata.VersionMetadata;
import org.sidiff.repair.history.generator.miner.connectors.IRepositoryMiner;

public class EcoreHistoryResolverApplication implements IApplication {
	
	private Map<String, List<VersionMetadata>> modelFiles = new HashMap<>();
	
	private Set<String> repositoryFilter = new HashSet<>();
	{
		repositoryFilter.add("http://git.eclipse.org/c/eef/org.eclipse.eef.git");
		repositoryFilter.add("http://git.eclipse.org/c/emfcompare/org.eclipse.emf.compare.git");
		repositoryFilter.add("http://git.eclipse.org/c/edapt/org.eclipse.emf.edapt.git");
		repositoryFilter.add("https://git.eclipse.org/c/emf/org.eclipse.emf.git"); // TODO
		repositoryFilter.add("http://git.eclipse.org/c/gmf-tooling/org.eclipse.gmf-tooling.git"); //TODO
		repositoryFilter.add("http://git.eclipse.org/c/ocl/org.eclipse.ocl.git");
		repositoryFilter.add("http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.git"); // TODO
		repositoryFilter.add("http://git.eclipse.org/c/rmf/org.eclipse.rmf.git");
		repositoryFilter.add("http://git.eclipse.org/c/sphinx/org.eclipse.sphinx.git");
		repositoryFilter.add("http://git.eclipse.org/c/mmt/org.eclipse.atl.git"); // TODO
		repositoryFilter.add("http://git.eclipse.org/c/mmt/org.eclipse.qvto.git");
		repositoryFilter.add("http://git.eclipse.org/c/acceleo/org.eclipse.acceleo.git"); // TODO
		repositoryFilter.add("http://git.eclipse.org/c/m2t/org.eclipse.xpand.git");
		repositoryFilter.add("http://git.eclipse.org/c/mdht/org.eclipse.mdht.git");
		repositoryFilter.add("http://git.eclipse.org/c/bpmn2/org.eclipse.bpmn2.git");
		repositoryFilter.add("http://git.eclipse.org/c/modisco/org.eclipse.modisco.git");
		repositoryFilter.add("http://git.eclipse.org/c/sirius/org.eclipse.sirius.git"); // TODO
		repositoryFilter.add("http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git"); // TODO
//		repositoryFilter.add("http://git.eclipse.org/c/stem/org.eclipse.stem.git"); // TODO
		repositoryFilter.add("https://github.com/eclipse/birt");
		repositoryFilter.add("http://git.eclipse.org/c/datatools/org.eclipse.datatools.git");
		repositoryFilter.add("http://git.eclipse.org/c/platform/eclipse.platform.ui.git");
		repositoryFilter.add("http://git.eclipse.org/c/eatop/org.eclipse.eatop.git");
		repositoryFilter.add("https://github.com/eclipse/elk");
		repositoryFilter.add("http://git.eclipse.org/c/cdo/cdo.git");
		repositoryFilter.add("http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.coevolution.git");
		repositoryFilter.add("http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.core.git");
		repositoryFilter.add("http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.patch.git");
		repositoryFilter.add("http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.patterns.git");
		repositoryFilter.add("http://git.eclipse.org/c/egf/org.eclipse.emf.egf.git");
		repositoryFilter.add("http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git");
		repositoryFilter.add("http://git.eclipse.org/c/emf-store/org.eclipse.emf.emfstore.core.git");
		repositoryFilter.add("http://git.eclipse.org/c/henshin/org.eclipse.emft.henshin.git");
		repositoryFilter.add("http://git.eclipse.org/c/texo/org.eclipse.emf.texo.git");
		repositoryFilter.add("https://github.com/eclipse/wazaabi");
		repositoryFilter.add("http://git.eclipse.org/c/epsilon/org.eclipse.epsilon.git");
		repositoryFilter.add("http://git.eclipse.org/c/fmc/org.eclipse.fmc.core.git");
		repositoryFilter.add("http://git.eclipse.org/c/gmf-notation/org.eclipse.gmf.notation.git");
		repositoryFilter.add("https://github.com/eclipse/gmp.graphiti");
		repositoryFilter.add("https://github.com/eclipse/xtext-core/");
		repositoryFilter.add("https://github.com/eclipse/eavp");
		repositoryFilter.add("http://git.eclipse.org/c/camf/org.eclipse.camf.git");
		repositoryFilter.add("https://github.com/eclipse/b3");
		repositoryFilter.add("http://git.eclipse.org/c/dltk/org.eclipse.dltk.core.git");
		repositoryFilter.add("https://github.com/eclipse/dltk.javascript");
		repositoryFilter.add("http://git.eclipse.org/c/ogee/org.eclipse.ogee.git");
		repositoryFilter.add("http://git.eclipse.org/c/pmf/org.eclipse.pmf.git");
		repositoryFilter.add("http://git.eclipse.org/c/buckminster/buckminster.git");
		repositoryFilter.add("http://git.eclipse.org/c/uml2/org.eclipse.uml2.git");
	}

	@Override
	public Object start(IApplicationContext context) throws Exception {
		DataSetMetadata dataset = new DataSetMetadata("C:\\evaluation\\");
		
		// Index model files:
		Set<String> modelPaths = new HashSet<>();
		
		for (HistoryMetadata history : dataset.getHistories()) {
			for (VersionMetadata version : history.getVersions()) {
				String modelName = version.getFileName();

				// NOTE: Technically, we have to know the plug-in relative path!
				if (!modelPaths.contains(version.getRemoteFilePath())) {

					modelPaths.add(version.getRemoteFilePath());  
					if (!modelFiles.containsKey(modelName)) {
						List<VersionMetadata> modelNames = new ArrayList<>();
						modelNames.add(version);
						modelFiles.put(modelName, modelNames);
					} else {
						modelFiles.get(modelName).add(version);
					}
				}
			}
		}
		
		// Resolve model resource sets:
		for (HistoryMetadata history : dataset.getHistories()) {
			if (!repositoryFilter.contains(history.getDatafile().getParent()) && !repositoryFilter.contains(history.getRepositoryURL())) {
				repositoryFilter.add(history.getDatafile().getParent());
				
				System.out.println(history.getProjectName() + " : " + history.getRepositoryURL());
				Set<String> missingURIs = new HashSet<>();
				
				for (File commitFolder : history.getDatafile().getParentFile().listFiles()) {
					if (commitFolder.isDirectory() && !commitFolder.getName().contains("_resolved")) {
						try {
							Set<String> missingURIsInCommit = resolve(searchModels(commitFolder));
							missingURIs.addAll(missingURIsInCommit);
						} catch (Exception e) {
							System.err.println(commitFolder);
							System.err.println(history.getRepositoryURL());
							throw e;
						}
					}
				}
				
				if (!missingURIs.isEmpty()) {
					System.err.println("Missing referenced model elements:");
					
					for (String missingURI : missingURIs) {
						System.err.println(missingURI);
					}
				}
				
				System.out.println("repositoryFilter.add(\"" +  history.getRepositoryURL()  + "\");");
			}
		}
		
		return IApplication.EXIT_OK;
	}
	
	protected Set<String> resolve(List<File> models) {
		
		// Make URIs to related models relative:
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		URIHandler uriHandler = new URIHandler(resourceSet, models, modelFiles);
		
		// Load models:
		resourceSet.getLoadOptions().put(XMIResource.OPTION_URI_HANDLER, uriHandler);
		
		for (File model : models) {
//			System.out.println("Loading: " + model.getAbsolutePath());
			
			try {
				resourceSet.getResource(URI.createFileURI(model.getAbsolutePath()), true);
			} catch (Exception e) {
				// Try to reload the content:
				try {
					reloadModelContent(model);
					resourceSet.getResource(URI.createFileURI(model.getAbsolutePath()), true);
				} catch (Exception e2) {
					e2.printStackTrace();
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
				options.put(XMIResource.OPTION_URI_HANDLER, uriHandler);
				
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
		
		return uriHandler.getMissingURIs();
	}
	
	protected void reloadModelContent(File model) throws IOException {
		File datafile = new File(model.getParentFile().getParent() + "/" + model.getName() + ".json");
		
		if (datafile.exists()) {
			HistoryMetadata history = new HistoryMetadata(datafile);
			history.read();
			String versionURL = null;

			try {
				// Automated reloading of content!
				for (IRepositoryMiner miner : EcoreHistorySettings.getInstance().getMiners()) {
					if (miner.supports(history.getRepositoryURL())) {
						String folder = model.getParent();
						String commit = folder.substring(folder.lastIndexOf("_") + 1, folder.length());
						
						versionURL = miner.getVersionURL(history.getRepositoryURL(), history.getLatestRemoteFilePath(), commit);
						miner.mineVersion(history.getRepositoryURL(), history.getLatestRemoteFilePath(), commit, model.getAbsolutePath());

						break;
					}
				}
			} catch (IOException ioe) {
				System.err.println(history.getLatestRemoteFilePath());
				System.err.println(model.getAbsolutePath());
				
				if (versionURL != null) {
					System.err.println(versionURL);
				}
				throw ioe;
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

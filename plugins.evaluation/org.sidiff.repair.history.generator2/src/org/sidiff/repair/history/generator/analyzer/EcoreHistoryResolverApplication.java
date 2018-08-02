package org.sidiff.repair.history.generator.analyzer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.repair.history.generator.metadata.DataSetMetadata;
import org.sidiff.repair.history.generator.metadata.HistoryMetadata;
import org.sidiff.repair.history.generator.metadata.VersionMetadata;
import org.sidiff.repair.history.generator.miner.connectors.IRepositoryMiner;

public class EcoreHistoryResolverApplication implements IApplication {
	
	private Map<String, List<HistoryMetadata>> modelFiles = new HashMap<>();
	
	private Set<String> repositoryFilter = new HashSet<>();
	{
		repositoryFilter.add("http://git.eclipse.org/c/acceleo/org.eclipse.acceleo.git"); // NOTE: Wrong URI: http://www.eclipse.org/ocl/1.1.0/oclstdlib.ecore#/0/Integers in mtlnonstdlib.ecore at 2010-03-05T17-34-08Z e7b50a9df0c58a03a56b5dea4cbe476dbc32a9f6
//		repositoryFilter.add("https://github.com/eclipse/b3");
		repositoryFilter.add("https://github.com/eclipse/birt");
		repositoryFilter.add("http://git.eclipse.org/c/bpmn2/org.eclipse.bpmn2.git");
		repositoryFilter.add("http://git.eclipse.org/c/buckminster/buckminster.git");
		repositoryFilter.add("http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.coevolution.git");
		repositoryFilter.add("http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.core.git");
		repositoryFilter.add("http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.patch.git");
		repositoryFilter.add("http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.patterns.git");
		repositoryFilter.add("http://git.eclipse.org/c/datatools/org.eclipse.datatools.git");
		repositoryFilter.add("https://github.com/eclipse/dltk.javascript");
		repositoryFilter.add("http://git.eclipse.org/c/dltk/org.eclipse.dltk.core.git");
		repositoryFilter.add("http://git.eclipse.org/c/camf/org.eclipse.camf.git");
		repositoryFilter.add("http://git.eclipse.org/c/cdo/cdo.git");
		repositoryFilter.add("https://github.com/eclipse/eavp");
		repositoryFilter.add("http://git.eclipse.org/c/eef/org.eclipse.eef.git");
		repositoryFilter.add("http://git.eclipse.org/c/epsilon/org.eclipse.epsilon.git");
		repositoryFilter.add("http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git");
		repositoryFilter.add("http://git.eclipse.org/c/emf-store/org.eclipse.emf.emfstore.core.git");
		repositoryFilter.add("http://git.eclipse.org/c/emfcompare/org.eclipse.emf.compare.git");
		repositoryFilter.add("http://git.eclipse.org/c/edapt/org.eclipse.emf.edapt.git");
		repositoryFilter.add("https://git.eclipse.org/c/emf/org.eclipse.emf.git");
		repositoryFilter.add("https://github.com/eclipse/elk");
		repositoryFilter.add("http://git.eclipse.org/c/eatop/org.eclipse.eatop.git");
		repositoryFilter.add("http://git.eclipse.org/c/egf/org.eclipse.emf.egf.git");
		repositoryFilter.add("http://git.eclipse.org/c/gmf-tooling/org.eclipse.gmf-tooling.git");
		repositoryFilter.add("http://git.eclipse.org/c/gmf-notation/org.eclipse.gmf.notation.git");
		repositoryFilter.add("https://github.com/eclipse/gmp.graphiti");
		repositoryFilter.add("http://git.eclipse.org/c/fmc/org.eclipse.fmc.core.git");
		repositoryFilter.add("http://git.eclipse.org/c/henshin/org.eclipse.emft.henshin.git");
		repositoryFilter.add("http://git.eclipse.org/c/m2t/org.eclipse.xpand.git");
		repositoryFilter.add("http://git.eclipse.org/c/mdht/org.eclipse.mdht.git");
		repositoryFilter.add("http://git.eclipse.org/c/mmt/org.eclipse.atl.git");
		repositoryFilter.add("http://git.eclipse.org/c/mmt/org.eclipse.qvto.git");
		repositoryFilter.add("http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git"); // TODO
		repositoryFilter.add("http://git.eclipse.org/c/modisco/org.eclipse.modisco.git");
		repositoryFilter.add("http://git.eclipse.org/c/ocl/org.eclipse.ocl.git");
		repositoryFilter.add("http://git.eclipse.org/c/ogee/org.eclipse.ogee.git");
		repositoryFilter.add("http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.git");
		repositoryFilter.add("http://git.eclipse.org/c/platform/eclipse.platform.ui.git");
		repositoryFilter.add("http://git.eclipse.org/c/pmf/org.eclipse.pmf.git");
		repositoryFilter.add("http://git.eclipse.org/c/rmf/org.eclipse.rmf.git");
		repositoryFilter.add("http://git.eclipse.org/c/sphinx/org.eclipse.sphinx.git");
		repositoryFilter.add("http://git.eclipse.org/c/sirius/org.eclipse.sirius.git");
		repositoryFilter.add("http://git.eclipse.org/c/stem/org.eclipse.stem.git"); // NOTE: Incomplete Commit: 2011-07-15T19-30-57Z fe05cad1c20c9a3490ac2b263910dc769ac12112
		repositoryFilter.add("http://git.eclipse.org/c/texo/org.eclipse.emf.texo.git");
		repositoryFilter.add("http://git.eclipse.org/c/uml2/org.eclipse.uml2.git");
		repositoryFilter.add("https://github.com/eclipse/wazaabi");
		repositoryFilter.add("https://github.com/eclipse/xtext-core");
		repositoryFilter.add("https://github.com/eclipse/xtext-extras");
	}

	@Override
	public Object start(IApplicationContext context) throws Exception {
		DataSetMetadata dataset = new DataSetMetadata("C:\\evaluation\\");
		
		// Index model file names:
		buildModelIndex(dataset);
		
		// Build model resource sets:
		for (HistoryMetadata modelHistory : dataset.getHistories()) {
			if (!repositoryFilter.contains(modelHistory.getRepositoryURL())) {
				Set<String> missingURIs = buildResourceSets(modelHistory);
				analyzeMissingURIs(missingURIs);
				
				System.out.println(modelHistory.getLatestRemoteFilePath());
				System.out.println("repositoryFilter.add(\"" +  modelHistory.getRepositoryURL()  + "\");");
			}
		}
		
		return IApplication.EXIT_OK;
	}

	protected void buildModelIndex(DataSetMetadata dataset) {
		
		// Index model files:
		Set<String> modelPaths = new HashSet<>();
		
		for (HistoryMetadata history : dataset.getHistories()) {
			for (VersionMetadata version : history.getVersions()) {
				File localFile = new File(history.getDatafile().getParent() + "/" + version.getLocalFilePath());
				
				// Filter versions in which the model is deleted from the repository!
				if (localFile.exists()) {
					String modelName = version.getFileName();
					
					// NOTE: Technically, we have to know the plug-in relative path!
					if (!modelPaths.contains(version.getRemoteFilePath())) {
						modelPaths.add(version.getRemoteFilePath()); 
						
						if (!modelFiles.containsKey(modelName)) {
							List<HistoryMetadata> versions = new ArrayList<>();
							versions.add(history);
							modelFiles.put(modelName, versions);
						} else {
							modelFiles.get(modelName).add(history);
						}
					}
				}
			}
		}
	}
	
	protected void analyzeMissingURIs(Set<String> missingURIs) {
		
		if (!missingURIs.isEmpty()) {
			System.err.println();
			System.err.println("Missing referenced model elements:");
			
			for (String missingURI : missingURIs) {
				System.err.println(missingURI);
			}
			
			System.err.println();
			System.err.println("Missing referenced models:");
			Set<String> missingModelURIs = new HashSet<>();
			
			for (String missingURI : missingURIs) {
				URI uri = URI.createURI(missingURI);
				String modelURI = uri.trimFragment().toString();
				
				if (!missingModelURIs.contains(modelURI)) {
					missingModelURIs.add(modelURI);
					System.err.println(modelURI);
				}
			}
		}
	}
	
	protected Set<String> buildResourceSets(HistoryMetadata modelHistory) {
		Set<String> missingURIs = new HashSet<>();
		
		File localRepositoryFolder = modelHistory.getDatafile().getParentFile();
		File modelHistoryFolder = new File(
				localRepositoryFolder.getAbsoluteFile()
				+ File.separator + modelHistory.generateHistoryName());
		modelHistoryFolder.mkdirs();
		
		// Build resource set for model versions: 
		for (VersionMetadata modelVersion : modelHistory.getVersions()) {
			buildResourceSet(modelVersion, modelHistoryFolder);
		}
		
		return missingURIs;
	}
	
	protected Set<String> buildResourceSet(VersionMetadata modelVersion, File modelHistoryFolder) {
		EcoreHistoryURIHandlerResolve uriHandler = new EcoreHistoryURIHandlerResolve(modelFiles);
		
		// Resolve co-evolving model histories:
		Set<HistoryMetadata> coevolvingModelHistories = new HashSet<>();
		coevolvingModelHistories.add(modelVersion.getHistory());
		
		// Get co-evolving model versions:
		// NOTE: We virtually update the resource set at the time one of the co-evolving resources changes.
		List<Date> updateDates = new LinkedList<>();
		updateDates.add(modelVersion.getParsedDate());
		boolean foundMore = true;

		while (foundMore) {
			for (Date updateDate : updateDates) {
				Set<VersionMetadata> versionSet = getRepositoryAtTime(updateDate, coevolvingModelHistories);
				
				// Resolve updated versions:
				for (VersionMetadata coevolvingVersion : versionSet) {
					resolveCoevolving(coevolvingVersion, uriHandler);
					foundMore = coevolvingModelHistories.addAll(uriHandler.getCoevolvingHistories());
				}
				
				for (HistoryMetadata coevolvingModelHistory : coevolvingModelHistories) {
					updateDates = getCoevolvingVersions(coevolvingModelHistory, modelVersion)
							.stream().map(VersionMetadata::getParsedDate).collect(Collectors.toList());
				}
			}
		}
		
		// Deresolve co-evolving model histories:
		Collections.sort(updateDates);
		
		for (Date updateDate : updateDates) {
			String updateTimestamp = HistoryMetadata.DATE_ISO8601.format(updateDate).replace(":", "-");

			File resourceSetVersionFolder = new File(
					modelHistoryFolder.getAbsoluteFile() 
					+ File.separator + modelVersion.generateVersionName() + "_update_" + updateTimestamp);
			resourceSetVersionFolder.mkdirs();
			
			Set<VersionMetadata> versionSet = getRepositoryAtTime(updateDate, coevolvingModelHistories);
			deresolveCoevolving(versionSet, resourceSetVersionFolder, uriHandler.getURIMapping());
		} 
		
		return uriHandler.getMissingURIs();
	}

	protected void resolveCoevolving(VersionMetadata modelVersion, EcoreHistoryURIHandlerResolve uriHandler) {
		
		// Find co-evolving model histories:
		File modelFile = modelVersion.getLocalFile();

		try {
			ResourceSetImpl resourceSet = new ResourceSetImpl();
			resourceSet.getLoadOptions().put(XMIResource.OPTION_URI_HANDLER, uriHandler);
			resourceSet.getResource(URI.createFileURI(modelFile.getAbsolutePath()), true);
		} catch (Exception e) {
			// Try to reload the content:
			try {
				reloadModelContent(modelVersion);
				ResourceSetImpl resourceSet = new ResourceSetImpl();
				resourceSet.getLoadOptions().put(XMIResource.OPTION_URI_HANDLER, uriHandler);
				resourceSet.getResource(URI.createFileURI(modelFile.getAbsolutePath()), true);
			} catch (Exception e2) {
				e2.printStackTrace();
				System.err.println(modelFile.getAbsolutePath());
				throw e;
			}
		}
		
		if (!uriHandler.getMissingURIs().isEmpty()) {
			System.err.println("Unresolved References: " + modelVersion.getLocalFilePath());
		}
	}
	
	protected void deresolveCoevolving(
			Set<VersionMetadata> versionSet, 
			File resourceSetVersionFolder,
			Map<String, HistoryMetadata> uriMapping) {

		// setup URI mapping:
		EcoreHistoryURIHandlerDeresolve uriHandler = new EcoreHistoryURIHandlerDeresolve(uriMapping);
		
		for (VersionMetadata version : versionSet) {
			uriHandler.getSelectedVersions().put(version.getHistory(), version);
		}
		
		// Load resource set:
		ResourceSet resourceSet = new ResourceSetImpl();
		
		for (VersionMetadata modelVersion : versionSet) {
			File modelFile = modelVersion.getLocalFile();
			
			URI orignialURI = URI.createFileURI(modelFile.getAbsolutePath());
			Resource modelResource = resourceSet.getResource(orignialURI, true);
			
			URI resolvedURI = URI.createFileURI(
					resourceSetVersionFolder.getAbsolutePath()
					+ "/" + modelVersion.getFileName());
			modelResource.setURI(resolvedURI);
		}
		
		// Save resolved models:
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
	}

	protected Set<VersionMetadata> getRepositoryAtTime(Date date, Set<HistoryMetadata> coevolvingModelHistories) {
		Set<VersionMetadata> versionSet = new HashSet<>();
		
		for (HistoryMetadata coevolvingModelHistory : coevolvingModelHistories) {
			VersionMetadata coevolvingVersion = coevolvingModelHistory.getVersionAtTime(date);
			
			if (coevolvingVersion != null) {
				versionSet.add(coevolvingVersion);
			} else {
				// Fallback solution -> use oldest available version:
				versionSet.add(coevolvingModelHistory.getVersions().get(coevolvingModelHistory.getVersions().size() - 1));
			}
		}
		
		return versionSet;
	}
	
	protected List<VersionMetadata> getCoevolvingVersions(HistoryMetadata coevolvingModelHistory, VersionMetadata consideredModelVersion) {
		List<VersionMetadata> coevolvingModelVersions = new ArrayList<>();
		
		// Last co-evolving model versions:
		VersionMetadata versionAtTime = coevolvingModelHistory.getVersionAtTime(consideredModelVersion.getParsedDate());
		
		if (versionAtTime != null) {
			coevolvingModelVersions.add(versionAtTime);
		} else {
			// Fallback solution -> use oldest version:
			coevolvingModelVersions.add(coevolvingModelHistory.getVersions().get(coevolvingModelHistory.getVersions().size() - 1));
		}
		
		// Newer co-evolving model versions until next of considered model version:
		VersionMetadata newerConsideredModelVersion = consideredModelVersion.getHistory().getNewerVersion(consideredModelVersion);
		
		Date currentConsideredDate = consideredModelVersion.getParsedDate();
		Date newerConsideredDate = (newerConsideredModelVersion != null) ? newerConsideredModelVersion.getParsedDate() : null;
		
		
		for (VersionMetadata coevolvingModelVersion : coevolvingModelHistory.getVersions()) {
			Date coevolvingDate = coevolvingModelVersion.getParsedDate();
			
			if (coevolvingDate.equals(currentConsideredDate) || coevolvingDate.after(currentConsideredDate)) {
				if ((newerConsideredDate == null) || coevolvingDate.before(newerConsideredDate)) {
					coevolvingModelVersions.add(coevolvingModelVersion);
				}
			}
		}
		
		return coevolvingModelVersions;
	}
	
	protected void reloadModelContent(VersionMetadata modelVersion) throws IOException {
		HistoryMetadata modelHistory = modelVersion.getHistory();
		File modelFile = modelVersion.getLocalFile();
		String versionURL = null;

		try {
			// Automated reloading of content!
			for (IRepositoryMiner miner : EcoreHistorySettings.getInstance().getMiners()) {
				if (miner.supports(modelHistory.getRepositoryURL())) {
					String folder = modelFile.getParent();
					String commit = folder.substring(folder.lastIndexOf("_") + 1, folder.length());

					versionURL = miner.getVersionURL(modelHistory.getRepositoryURL(), modelHistory.getLatestRemoteFilePath(), commit);
					miner.mineVersion(
							modelHistory.getRepositoryURL(), 
							modelHistory.getLatestRemoteFilePath(), 
							modelVersion.getCommit(), 
							modelFile.getAbsolutePath());

					break;
				}
			}
		} catch (IOException ioe) {
			System.err.println(modelHistory.getLatestRemoteFilePath());
			System.err.println(modelFile.getAbsolutePath());

			if (versionURL != null) {
				System.err.println(versionURL);
			}
			throw ioe;
		}
	}

	@Override
	public void stop() {
	}
}

package org.sidiff.revision.repair.history.retrieval.ecore;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.revision.repair.history.retrieval.metadata.DataSetMetadata;
import org.sidiff.revision.repair.history.retrieval.metadata.HistoryMetadata;
import org.sidiff.revision.repair.history.retrieval.metadata.VersionMetadata;
import org.sidiff.revision.repair.history.retrieval.metadata.coevolution.CoevolutionVersionMetadata;
import org.sidiff.revision.repair.history.retrieval.miner.connectors.IRepositoryMiner;
import org.sidiff.revision.repair.history.retrieval.util.HistoryUtil;

/**
 * Original (All extracted model versions.) -> Resolved (Finding co-evolving versions.)
 * 
 * @author Manuel Ohrndorf
 */
public class EcoreHistoryResolverApplication implements IApplication {
	
	private Map<String, List<HistoryMetadata>> modelFiles = new HashMap<>();
	
	private File sourceDataSet = new File("C:\\evaluations\\org.eclipse.git_2018-08-22\\org.eclipse.git");
	
	private File targetDataSet = new File("C:\\evaluation_resolved\\");
	
	private Set<String> repositoryFilter = new HashSet<>();
	{
		repositoryFilter.add("https://github.com/eclipse/birt");
		repositoryFilter.add("http://git.eclipse.org/c/datatools/org.eclipse.datatools.git");
		repositoryFilter.add("http://git.eclipse.org/c/platform/eclipse.platform.ui.git");
		repositoryFilter.add("http://git.eclipse.org/c/eatop/org.eclipse.eatop.git");
		repositoryFilter.add("http://git.eclipse.org/c/eef/org.eclipse.eef.git");
		repositoryFilter.add("https://github.com/eclipse/elk");
		repositoryFilter.add("http://git.eclipse.org/c/cdo/cdo.git");
		repositoryFilter.add("http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.coevolution.git");
		repositoryFilter.add("http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.core.git");
		repositoryFilter.add("http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.patch.git");
		repositoryFilter.add("http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.patterns.git");
		repositoryFilter.add("http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.patterns.git");
		repositoryFilter.add("http://git.eclipse.org/c/diffmerge/org.eclipse.emf.diffmerge.patterns.git");
		repositoryFilter.add("http://git.eclipse.org/c/egf/org.eclipse.emf.egf.git");
		repositoryFilter.add("https://git.eclipse.org/c/emf/org.eclipse.emf.git");
		repositoryFilter.add("http://git.eclipse.org/c/emfcompare/org.eclipse.emf.compare.git");
		repositoryFilter.add("http://git.eclipse.org/c/edapt/org.eclipse.emf.edapt.git");
		repositoryFilter.add("http://git.eclipse.org/c/emfclient/org.eclipse.emf.ecp.core.git");
		repositoryFilter.add("http://git.eclipse.org/c/emf-store/org.eclipse.emf.emfstore.core.git");
		repositoryFilter.add("http://git.eclipse.org/c/henshin/org.eclipse.emft.henshin.git");
		repositoryFilter.add("http://git.eclipse.org/c/texo/org.eclipse.emf.texo.git");
		repositoryFilter.add("https://github.com/eclipse/wazaabi");
		repositoryFilter.add("http://git.eclipse.org/c/epsilon/org.eclipse.epsilon.git");
		repositoryFilter.add("http://git.eclipse.org/c/fmc/org.eclipse.fmc.core.git");
		repositoryFilter.add("http://git.eclipse.org/c/gmf-notation/org.eclipse.gmf.notation.git");
		repositoryFilter.add("http://git.eclipse.org/c/gmf-tooling/org.eclipse.gmf-tooling.git");
		repositoryFilter.add("https://github.com/eclipse/gmp.graphiti");
		repositoryFilter.add("http://git.eclipse.org/c/acceleo/org.eclipse.acceleo.git"); // NOTE: Wrong URI: http://www.eclipse.org/ocl/1.1.0/oclstdlib.ecore#/0/Integers in mtlnonstdlib.ecore at 2010-03-05T17-34-08Z e7b50a9df0c58a03a56b5dea4cbe476dbc32a9f6
		repositoryFilter.add("http://git.eclipse.org/c/m2t/org.eclipse.xpand.git");
		repositoryFilter.add("http://git.eclipse.org/c/mdht/org.eclipse.mdht.git");
		repositoryFilter.add("http://git.eclipse.org/c/bpmn2/org.eclipse.bpmn2.git");
		repositoryFilter.add("http://git.eclipse.org/c/modisco/org.eclipse.modisco.git");
		repositoryFilter.add("http://git.eclipse.org/c/ocl/org.eclipse.ocl.git");
		repositoryFilter.add("http://git.eclipse.org/c/papyrus/org.eclipse.papyrus.git");
		repositoryFilter.add("http://git.eclipse.org/c/rmf/org.eclipse.rmf.git");
		repositoryFilter.add("http://git.eclipse.org/c/sphinx/org.eclipse.sphinx.git");
		repositoryFilter.add("http://git.eclipse.org/c/uml2/org.eclipse.uml2.git");
		repositoryFilter.add("http://git.eclipse.org/c/mmt/org.eclipse.atl.git");
		repositoryFilter.add("http://git.eclipse.org/c/mmt/org.eclipse.qvtd.git");
		repositoryFilter.add("http://git.eclipse.org/c/mmt/org.eclipse.qvto.git");
		repositoryFilter.add("http://git.eclipse.org/c/pmf/org.eclipse.pmf.git");
		repositoryFilter.add("http://git.eclipse.org/c/sirius/org.eclipse.sirius.git");
		repositoryFilter.add("https://github.com/eclipse/xtext-core");
		repositoryFilter.add("https://github.com/eclipse/xtext-extras");
		repositoryFilter.add("https://github.com/eclipse/eavp");
		repositoryFilter.add("http://git.eclipse.org/c/camf/org.eclipse.camf.git");
		repositoryFilter.add("https://github.com/eclipse/b3");
		repositoryFilter.add("http://git.eclipse.org/c/dltk/org.eclipse.dltk.core.git");
		repositoryFilter.add("https://github.com/eclipse/dltk.javascript");
		repositoryFilter.add("http://git.eclipse.org/c/ogee/org.eclipse.ogee.git");
		repositoryFilter.add("http://git.eclipse.org/c/stem/org.eclipse.stem.git"); // NOTE: Incomplete Commit: 2011-07-15T19-30-57Z fe05cad1c20c9a3490ac2b263910dc769ac12112
		repositoryFilter.add("http://git.eclipse.org/c/buckminster/buckminster.git");
	}

	@Override
	public Object start(IApplicationContext context) throws Exception {
		DataSetMetadata dataset = new DataSetMetadata(sourceDataSet.getAbsolutePath(), true);
		
		// Index model file names:
		buildModelIndex(dataset);
		
		// Build model resource sets:
		for (HistoryMetadata modelHistory : dataset.getHistories()) {
			if (!repositoryFilter.contains(modelHistory.getRepositoryURL())) {
				Set<String> missingURIs = buildResourceSets(modelHistory, targetDataSet);
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
		Set<String> nsURIs = new HashSet<>();
		
		for (HistoryMetadata history : dataset.getHistories()) {
			for (VersionMetadata version : history.getVersions()) {
				File localFile = new File(history.getDatafile().getParent() + "/" + version.getLocalFilePath());
				
				// Filter versions in which the model is deleted from the repository!
				if (localFile.exists()) {
					String modelName = version.getFileName();
					
					// NOTE: Technically, we have to know the plug-in relative path!
					if (!modelPaths.contains(version.getHistory().getRepositoryURL() + version.getRemoteFilePath())) {
						modelPaths.add(version.getHistory().getRepositoryURL() + version.getRemoteFilePath()); 
						
						if (!modelFiles.containsKey(modelName)) {
							List<HistoryMetadata> versions = new ArrayList<>();
							versions.add(history);
							modelFiles.put(modelName, versions);
						} else {
							modelFiles.get(modelName).add(history);
						}
					}
					
					// Read namespaces:
					String nsURI = null;
					
					try {
						String nsURIAttribute = "nsURI=\"";
						String nsURILine = Files.lines(Paths.get(localFile.getAbsolutePath())).filter(line -> {
							return line.contains(nsURIAttribute);
						}).findFirst().get();
						nsURILine = nsURILine.substring(
								nsURILine.indexOf(nsURIAttribute) + nsURIAttribute.length(),
								nsURILine.length());
						nsURI = nsURILine.substring(0, nsURILine.indexOf("\""));
					} catch (Exception e) {
					}
					
					if (nsURI != null) {
						if (!nsURIs.contains(version.getHistory().getRepositoryURL() + version.getRemoteFilePath() + nsURI)) {
							nsURIs.add(version.getHistory().getRepositoryURL() + version.getRemoteFilePath() + nsURI);
							
							if (!modelFiles.containsKey(nsURI)) {
								List<HistoryMetadata> versions = new ArrayList<>();
								versions.add(history);
								modelFiles.put(nsURI, versions);
							} else {
								modelFiles.get(nsURI).add(history);
							}
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
	
	protected Set<String> buildResourceSets(HistoryMetadata modelHistory, File target) {
		Set<String> missingURIs = new HashSet<>();
		
		String datasetName = modelHistory.getDatafile().getName();
		File modelHistoryFolder = new File(target.getAbsoluteFile() + File.separator
				+ modelHistory.getProjectName() + File.separator
				+ datasetName.substring(0, datasetName.lastIndexOf(".")));
		modelHistoryFolder.mkdirs();
		
		// Build resource set for model versions: 
		HistoryMetadata coevolvinHistorygMetadata = new HistoryMetadata(modelHistory);
		coevolvinHistorygMetadata.setDatafile(new File(modelHistoryFolder.getAbsolutePath() 
				+ File.separator + modelHistory.getDatafile().getName()));
		
		for (VersionMetadata modelVersion : modelHistory.getVersions()) {
			Set<String> missingURIsInVersion = buildResourceSet(modelVersion, modelHistoryFolder, coevolvinHistorygMetadata);
			missingURIs.addAll(missingURIsInVersion);
		}
		
		// Write metadata:
		coevolvinHistorygMetadata.write();
		
		return missingURIs;
	}
	
	protected Set<String> buildResourceSet(VersionMetadata modelVersion, File modelHistoryFolder, HistoryMetadata coevolvinHistoryMetadata) {
		EcoreHistoryURIHandlerResolve uriHandler = new EcoreHistoryURIHandlerResolve(modelVersion, modelFiles);
		
		// Resolve co-evolving model histories:
		Set<HistoryMetadata> coevolvingModelHistories = new HashSet<>();
		coevolvingModelHistories.add(modelVersion.getHistory());
		
		// Get co-evolving model versions:
		// NOTE: We virtually update the resource set at the time one of the co-evolving resources changes.
		Set<Date> coevolutionDates = new HashSet<>();
		coevolutionDates.add(modelVersion.getParsedDate());
		
		Set<HistoryMetadata> foundCoevolvingModelHistories = new HashSet<>();
		foundCoevolvingModelHistories.add(modelVersion.getHistory());

		while (!foundCoevolvingModelHistories.isEmpty()) {
			foundCoevolvingModelHistories.clear();
			
			// Search referenced models:
			for (Date coevolutionDate : coevolutionDates) {
				Set<VersionMetadata> coevolutionSet = getRepositoryAtTime(coevolutionDate, coevolvingModelHistories);
				
				// Resolve co-evolving versions:
				for (VersionMetadata coevolvingVersion : coevolutionSet) {
					resolveCoevolving(coevolvingVersion, uriHandler);
					
					for (HistoryMetadata coevolvingModelHistory : uriHandler.getCoevolvingHistories()) {
						
						// More co-evolving histories found?
						if (!coevolvingModelHistories.contains(coevolvingModelHistory)) {
							coevolvingModelHistories.add(coevolvingModelHistory);
							foundCoevolvingModelHistories.add(coevolvingModelHistory);
						}
					}
				}
			}
			
			// Search co-evolving dates:
			for (HistoryMetadata foundCoevolvingModelHistory : foundCoevolvingModelHistories) {
				coevolutionDates.addAll(getCoevolvingDates(foundCoevolvingModelHistory, modelVersion));
			}
		}
		
		// Deresolve co-evolving model histories:
		List<Date> coevolutionDateList = new LinkedList<>(coevolutionDates);
		Collections.sort(coevolutionDateList);
		
		for (Date coevolutionDate : coevolutionDateList) {
			
			// NOTE: Filter older models that were not update with or after this model version:
			if (coevolutionDate.equals(modelVersion.getParsedDate()) || coevolutionDate.after(modelVersion.getParsedDate())) {
				String coevolutionTimestamp = !(coevolutionDate.equals(modelVersion.getParsedDate()))
						? "_coevolution_" + EcoreHistorySettings.DATE_ISO8601_PATH_COMPATIBLE.format(coevolutionDate)
						: "";
						
				File resourceSetVersionFolder = new File(modelHistoryFolder.getAbsoluteFile() + File.separator
						+ EcoreHistorySettings.getInstance().generateVersionName(modelVersion.getParsedDate(), modelVersion.getCommit())
						+ coevolutionTimestamp);
				resourceSetVersionFolder.mkdirs();

				Set<VersionMetadata> versionSet = getRepositoryAtTime(coevolutionDate, coevolvingModelHistories);
				deresolveCoevolving(versionSet, resourceSetVersionFolder, uriHandler.getURIMapping());

				// Store metadata:
				CoevolutionVersionMetadata coevolvingVersionMetadata = new CoevolutionVersionMetadata(coevolvinHistoryMetadata, modelVersion);
				coevolvingVersionMetadata.setLocalFilePath("/" + resourceSetVersionFolder.getName() + "/"
						+ EcoreHistoryURIHandlerDeresolve.getDeresolvedURI(coevolvingVersionMetadata));

				if (!(coevolutionDate.equals(modelVersion.getParsedDate()))) {
					coevolvingVersionMetadata.setCoevolutionDate(EcoreHistorySettings.DATE_ISO8601.format(coevolutionDate));
				}
				
				coevolvinHistoryMetadata.getVersions().add(coevolvingVersionMetadata);
			}
		}
		
		return uriHandler.getMissingURIs();
	}

	protected void resolveCoevolving(VersionMetadata modelVersion, EcoreHistoryURIHandlerResolve uriHandler) {
		
		// Find co-evolving model histories:
		File modelFile = modelVersion.getLocalFile();

		try {
			ResourceSetImpl resourceSet = new ResourceSetImpl();
			URI uri = URI.createFileURI(modelFile.getAbsolutePath());
			HistoryUtil.load(resourceSet, uri, uriHandler);
		} catch (Exception e) {
			// Try to reload the content:
			try {
				reloadModelContent(modelVersion);

				ResourceSetImpl resourceSet = new ResourceSetImpl();
				URI uri = URI.createFileURI(modelFile.getAbsolutePath());
				HistoryUtil.load(resourceSet, uri, uriHandler);
			} catch (Exception e2) {
				System.err.println(modelFile.getAbsolutePath());
				e2.printStackTrace();
				throw e;
			}
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
		List<Resource> deresolvedResources = new ArrayList<>();
		
		for (VersionMetadata modelVersion : versionSet) {
			File modelFile = modelVersion.getLocalFile();

			URI orignialURI = URI.createFileURI(modelFile.getAbsolutePath());
			Resource modelResource = null;
			
			try {
				ResourceSet resourceSet = new ResourceSetImpl();
				modelResource = HistoryUtil.load(resourceSet, orignialURI, uriHandler);
			} catch (Exception e2) {
				throw e2;
			}

			if (modelResource != null) {
				URI targetURI = EcoreHistoryURIHandlerDeresolve.getDeresolvedURI(modelVersion);
				URI targetFileURI = URI.createFileURI(
						resourceSetVersionFolder.getAbsolutePath() + "/" + targetURI.devicePath());
				modelResource.setURI(targetFileURI);
				deresolvedResources.add(modelResource);
			}
		}
		
		// Save resolved models:
		for (Resource model : deresolvedResources) {
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
	
	protected List<Date> getCoevolvingDates(HistoryMetadata coevolvingModelHistory, VersionMetadata consideredModelVersion) {
		List<Date> coevolvingModelVersions = new ArrayList<>();
		
		// Newer co-evolving model versions until next version of the considered model:
		if (coevolvingModelHistory != consideredModelVersion.getHistory()) {
			VersionMetadata newerConsideredModelVersion = consideredModelVersion.getHistory().getNewerVersion(consideredModelVersion);

			Date currentConsideredDate = consideredModelVersion.getParsedDate();
			Date newerConsideredDate = (newerConsideredModelVersion != null) ? newerConsideredModelVersion.getParsedDate() : null;

			for (VersionMetadata coevolvingModelVersion : coevolvingModelHistory.getVersions()) {
				Date coevolvingDate = coevolvingModelVersion.getParsedDate();

				if (coevolvingDate.equals(currentConsideredDate) || coevolvingDate.after(currentConsideredDate)) {
					// NOTE: null -> considered model version is the newest version.
					if ((newerConsideredDate == null) || coevolvingDate.before(newerConsideredDate)) {
						coevolvingModelVersions.add(coevolvingModelVersion.getParsedDate());
					}
				}
			}
		}
		
		return coevolvingModelVersions;
	}
	
	protected void reloadModelContent(VersionMetadata modelVersion) throws Exception {
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
		} catch (Exception e) {
			System.err.println(modelHistory.getLatestRemoteFilePath());
			System.err.println(modelFile.getAbsolutePath());

			if (versionURL != null) {
				System.err.println(versionURL);
			}
			throw e;
		}
	}

	@Override
	public void stop() {
	}
}

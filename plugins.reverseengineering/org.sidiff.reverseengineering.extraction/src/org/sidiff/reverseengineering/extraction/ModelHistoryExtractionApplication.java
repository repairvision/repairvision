package org.sidiff.reverseengineering.extraction;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.reverseengineering.dataset.history.model.History;
import org.sidiff.reverseengineering.dataset.history.model.Version;
import org.sidiff.reverseengineering.dataset.history.repository.GitRepository;
import org.sidiff.reverseengineering.dataset.history.repository.Repository;
import org.sidiff.reverseengineering.dataset.history.repository.filter.VersionFilter;
import org.sidiff.reverseengineering.java.util.EMFHelper;
import org.sidiff.reverseengineering.systemmodel.util.UMLUtil;

public class ModelHistoryExtractionApplication implements IApplication {

	@Override
	public Object start(IApplicationContext context) throws Exception {
		Path codeRepositoryPath = Path.of("C:\\Users\\manue\\git\\bCMS"); // C:\Users\manue\git\ppu // C:\\Users\\manue\\git\\bCMS
		String codeRepositoryURL = null; // only needed for automatic clone 

		Path modelFolderPath = Path.of(codeRepositoryPath.toString() + "_history");

		Repository codeRepository = new GitRepository(codeRepositoryURL, codeRepositoryPath.toFile());

		try {
			History history = codeRepository.getHistory(VersionFilter.FILTER_NOTHING);

			EMFHelper emfHelper = new EMFHelper();

			// Run Git History...
			Map<String, Resource> oldModels = new HashMap<>();
			Collections.reverse(history.getVersions());

			for (int i = 0; i < history.getVersions().size(); i++) {
				Version version = history.getVersions().get(i);
				
				System.out.println(i + 1 + " of " + history.getVersions().size() + " - " + version.getDate() + " - "
						+ version.getIdentification() + " - " + version.getCommitMessage().replaceAll("\n", ""));
				codeRepository.checkout(history, version);

				List<Path> modelPaths = getFiles(new ArrayList<>(), codeRepositoryPath, Collections.singleton("uml"));
				ResourceSet resourceSet = new ResourceSetImpl();

				Map<String, Resource> newModels = new HashMap<>();

				for (Path modelPath : modelPaths) {
					
					// Load model:
					Path modelRepositoryPath = codeRepositoryPath.relativize(modelPath);
					URI modelURI = URI.createFileURI(modelPath.toString());
					Resource newModel = resourceSet.getResource(modelURI, true);

					// Load diagram, so references will be updated by matched UUIDs from old model Version:
					URI newModelDiagramURI = modelURI.trimFileExtension().appendFileExtension("notation");
					Resource newModelDiagram = null;

					if (resourceSet.getURIConverter().exists(newModelDiagramURI, Collections.EMPTY_MAP)) {
						newModelDiagram = resourceSet.getResource(newModelDiagramURI, true);
						EcoreUtil.resolveAll(newModelDiagram); 
					}
					
					URI newModelDiagramDIURI = newModelDiagramURI.trimFileExtension().appendFileExtension("di");
					Resource newModelDiagramDI = null;
					
					if (resourceSet.getURIConverter().exists(newModelDiagramDIURI, Collections.EMPTY_MAP)) {
						newModelDiagramDI = resourceSet.getResource(newModelDiagramDIURI, true);
						EcoreUtil.resolveAll(newModelDiagramDI);
					}
					
					// Do model matching and replace UUIDs:
					if (oldModels.containsKey(modelRepositoryPath.toString())) {
						emfHelper.reuseObjectIDs((XMLResource) oldModels.get(modelRepositoryPath.toString()),
								(XMLResource) newModel, Collections.emptyMap());
					}

					// Save the model to the new location:
					String folderName = (version.getDate().toString() + "_" + version.getIdentification()).replace(":", "-");
					Path folderPath = modelFolderPath.resolve(folderName);
					Files.createDirectories(folderPath);

					saveModel(modelRepositoryPath, folderPath, newModel);
					newModels.put(modelRepositoryPath.toString(), newModel);
					
					// Save diagram to the new location:
					saveModel(modelRepositoryPath, folderPath, newModelDiagram);
					saveModel(modelRepositoryPath, folderPath, newModelDiagramDI);
				}
				
				// Fix UML (cross-referencer) resource leaks:
				UMLUtil.unloadUMLModels(oldModels.values());

				oldModels = newModels;
			}
		} finally {
			// Set to version before Git history iteration:
			codeRepository.reset();
		}

		return IApplication.EXIT_OK;
	}
	
	private static void saveModel(Path modelRepositoryPath, Path folderPath, Resource model) {
		if (model != null) {
			String modelPath = folderPath.resolve(modelRepositoryPath).toString();
			String modelFile = model.getURI().lastSegment();
			model.setURI(URI.createFileURI(modelPath).trimSegments(1).appendSegment(modelFile));

			try {
				model.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static String getFileExtension(Path path) {
		String fileName = path.getFileName().toString();
		int fileExtensionPos = fileName.lastIndexOf(".");

		if (fileExtensionPos > 0) {
			return fileName.substring(fileExtensionPos + 1, fileName.length());
		}
		
		return "";
	}

	private static List<Path> getFiles(List<Path> files, Path dir, Set<String> fileExtensions) {
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
			for (Path path : stream) {
				if (path.toFile().isDirectory()) {
					getFiles(files, path, fileExtensions);
				} else {
					if (fileExtensions.contains(getFileExtension(path))) {
						files.add(path);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return files;
	}

	@Override
	public void stop() {
	}

}

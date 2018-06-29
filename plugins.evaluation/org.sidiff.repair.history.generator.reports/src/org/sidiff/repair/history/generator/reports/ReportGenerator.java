package org.sidiff.repair.history.generator.reports;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.difference.lifting.api.LiftingFacade;
import org.sidiff.difference.lifting.api.settings.LiftingSettings;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.repair.history.generator.reports.validation.EMFDiagnosticAdapter;
import org.sidiff.repair.history.generator.reports.validation.EMFValidator;
import org.sidiff.repair.history.generator.reports.validation.IValidationError;
import org.sidiff.repair.history.generator.reports.validation.IValidator;

public abstract class ReportGenerator implements IApplication {

	// private static final String ROOT =
	// "/home/kehrer/Downloads/GitExtractedModels/versions";
	// private static final String ROOT =
	// "/home/kehrer/git/sidiff-lifting/research/org.sidiff.repair.casestudy.gmf/test";
	// private static final String ROOT =
	// "/home/kehrer/git/sipl/casestudies/bCMS/org.sidiff.deltamodeling.casestudy.bCMS.models/core_model_v2";
	private static final String ROOT = "/home/kehrer/Downloads/GitExtractedModels/versions";

//	private static final String REPORT = "/home/kehrer/git/sidiff-lifting/research/org.sidiff.repair.casestudy.gmf/report";

	private static final int MAX_CASES_PER_TYPE = 1000;
	
	private static boolean liftDifferences = false;

	private Collection<IValidationError> uniqueErrorKinds;
	private Collection<IValidationError> currentErrors;
	private Map<IValidationError, Resource> introducedErrors;
	private Map<IValidationError, Resource> resolvedErrors;
	
	private List<SymmetricDifference> symDiffs = new ArrayList<SymmetricDifference>();

	private Map<String, Integer> introducedAndResolvedErrorsCount;

	private StringBuffer bufOverview;
	private StringBuffer bufIntroducedAndResolvedErrors;
	private StringBuffer bufUnique;

	private IValidator validator = new EMFValidator();

	@Override
	public Object start(IApplicationContext context) throws Exception {
		
		String[] argument = (String[]) context.getArguments().get(IApplicationContext.APPLICATION_ARGS);
		String input_folder = argument.length > 0 && !argument[0].isEmpty() ? argument[0] : ROOT;
		liftDifferences = Boolean.valueOf(argument[1]);
		
		System.out.println(" ======================================== Start =================================");

		uniqueErrorKinds = new LinkedList<IValidationError>();
		bufIntroducedAndResolvedErrors = new StringBuffer("");
		bufOverview = new StringBuffer("");
		bufUnique = new StringBuffer("");

		// Do the analysis
		generate(input_folder);

		// Serialize results
		serializeResults(input_folder);

		System.out.println(" ======================================== Finished =================================");

		return IApplication.EXIT_OK;
	}

	
	
	private void generate(String folder) {

		// scan for model files within that folder
		File modelFolder = new File(folder);
		FilenameFilter filter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				boolean accept = false;
				for (String filter : getFileFilters()) {
					if (name.toLowerCase().endsWith(filter)) {
						accept = true;
						break;
					}
				}

				return accept;
			}
		};
		File[] files = modelFolder.listFiles(filter);
		Arrays.sort(files);
		if (files.length >= 3) {
			currentErrors = null;
			Arrays.sort(files);
			for (int i = 0; i < files.length; i++) {
				File modelFile = files[i];
				if (!modelFile.isDirectory() && (modelFile.length()) < maxModelFileLength()) {
					generate(modelFile);
				}
			}
			generateIntroducedAndResolved();
		}

		// scan for sub-directories recursively
		files = modelFolder.listFiles();
		Arrays.sort(files);
		for (File file : files) {
			if (file.isDirectory()) {
				generate(file.getAbsolutePath());
			}
		}
	}

	private void generate(File modelFile) {
		ResourceSet rs = new ResourceSetImpl();
		Resource model = null;
		try {
			model = rs.getResource(URI.createFileURI(modelFile.getAbsolutePath()), true);
			EcoreUtil.resolveAll(model);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return;
		}

		Collection<IValidationError> validationErrors = getValidationErrors(model);
		// Do not handle defect models
		for (IValidationError iValidationError : validationErrors) {
			if (iValidationError.getMessage().contains("contains an unresolved proxy")
					|| iValidationError.getMessage().contains("contains a dangling reference")) {
				return;
			}
		}

		appendToOverview(model, validationErrors);
		appendToIntroducedOrResolved(model, validationErrors);
		appendToUniqueErrorKinds(model, validationErrors);
	}

	/**
	 * Just the number of validation errors per model
	 */
	private void appendToOverview(Resource model, Collection<IValidationError> validationErrors) {
		bufOverview.append(model.getURI());
		bufOverview.append(" (" + validationErrors.size() + ")\n");
		System.out.print(model.getURI());
		System.out.print(" (" + validationErrors.size() + ")\n");
	}

	/**
	 * Just the unique kinds of validation errors in all models
	 */
	private void appendToUniqueErrorKinds(Resource model, Collection<IValidationError> validationErrors) {
		for (IValidationError validationError : validationErrors) {
			if (!containsUniqeErrorKind(validationError)) {
				uniqueErrorKinds.add(validationError);
				printValidationError(validationError, bufUnique);
				// StringBuffer buf = new StringBuffer("");
				// printValidationError(validationError, buf);
				// System.out.println(buf.toString());
			}
		}
	}

	private void appendToIntroducedOrResolved(Resource model, Collection<IValidationError> validationErrors) {
		// First time for that model history
		if (currentErrors == null) {
			currentErrors = validationErrors;
			introducedErrors = new HashMap<IValidationError, Resource>();
			resolvedErrors = new HashMap<IValidationError, Resource>();

			return;
		}

		// "Symmetric set difference"
		for (IValidationError iValidationError : validationErrors) {
			if (!currentErrors.contains(iValidationError)) {
				introducedErrors.put(iValidationError, model);
				// System.out.println(modelFile.getName());
				// System.out.println("\tINTRODUCE");
				// StringBuffer buf = new StringBuffer("");
				// printValidationError(iValidationError, buf);
				// System.out.println(buf.toString());
			}
		}
		for (IValidationError iValidationError : currentErrors) {
			if (!validationErrors.contains(iValidationError)) {
				resolvedErrors.put(iValidationError, model);
				// System.out.println(modelFile.getName());
				// System.out.println("\tRESOLVE");
				// StringBuffer buf = new StringBuffer("");
				// printValidationError(iValidationError, buf);
				// System.out.println(buf.toString());
			}
		}

		this.currentErrors = validationErrors;
	}

	private void generateIntroducedAndResolved() {
		if (introducedAndResolvedErrorsCount == null) {
			introducedAndResolvedErrorsCount = new HashMap<String, Integer>();
		}
		for (IValidationError ve : uniqueErrorKinds) {
			String characterizing = ve.getCharacterizingMessageFragment();
			if (!introducedAndResolvedErrorsCount.containsKey(characterizing)) {
				introducedAndResolvedErrorsCount.put(characterizing, new Integer(0));
			}
		}

		if(introducedErrors != null){
		for (IValidationError introduced : introducedErrors.keySet()) {
			if (resolvedErrors.keySet().contains(introduced)) {
				EObject invalidElement = (EObject) ((EMFDiagnosticAdapter) introduced).getAdaptee().getData().get(0);
				Resource resolvedModel = resolvedErrors.get(introduced);

				if (exists(invalidElement, resolvedModel)) {
					String characterizing = introduced.getCharacterizingMessageFragment();
					int count = introducedAndResolvedErrorsCount.get(characterizing).intValue();
					if (count < MAX_CASES_PER_TYPE) {
						bufIntroducedAndResolvedErrors
								.append("INTRODUCED: " + introducedErrors.get(introduced).getURI() + "\n");
						bufIntroducedAndResolvedErrors
								.append("RESOLVED: " + resolvedErrors.get(introduced).getURI() + "\n");
						printValidationError(introduced, bufIntroducedAndResolvedErrors);
							count++;
						introducedAndResolvedErrorsCount.put(characterizing, new Integer(count));
					}
				}
			
			}
		}
		}
	}

	private void printValidationError(IValidationError validationError, StringBuffer buf) {
		buf.append("\tsource: " + validationError.getSource() + "\n");
		buf.append("\tseverity: " + validationError.getSeverity() + "\n");
		buf.append("\tmessage: " + validationError.getMessage() + "\n");

		if (validationError instanceof EMFDiagnosticAdapter) {
			EMFDiagnosticAdapter adapter = (EMFDiagnosticAdapter) validationError;
			Diagnostic diagnostic = adapter.getAdaptee();
			buf.append("\t\t" + diagnostic.getData() + "\n");
		}
	}

	private Collection<IValidationError> getValidationErrors(Resource model) {
		Collection<IValidationError> validationErrors = null;
		try {
			validationErrors = validator.validate(model);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		if (validationErrors == null) {
			validationErrors = new ArrayList<IValidationError>();
		}

		for (Iterator<IValidationError> iterator = validationErrors.iterator(); iterator.hasNext();) {
			IValidationError iValidationError = iterator.next();
			boolean ignore = iValidationError.getCharacterizingMessageFragment().equals(iValidationError.getMessage());
			if (ignore) {
				iterator.remove();
			}
		}

		return validationErrors;
	}

	private boolean containsUniqeErrorKind(IValidationError validationError) {
		String characterizing = validationError.getCharacterizingMessageFragment();

		for (IValidationError existing : uniqueErrorKinds) {
			if (existing.getMessage().contains(characterizing)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public void stop() {
		System.out.println("Stop");
	}

	protected boolean exists(EObject element, Resource model){
		Resource modelIntroduced = element.eResource();
		Resource modelResolved = model;
		try{
			LiftingSettings settings = getLiftingSettings();
			SymmetricDifference symDiff = LiftingFacade.deriveTechnicalDifference(modelIntroduced, modelResolved, getLiftingSettings());
			if(!symDiff.getMatching().getUnmatchedA().contains(element)){
				symDiffs.add(symDiff);
				if(liftDifferences){
					LiftingFacade.liftTechnicalDifference(symDiff, settings);
				}
				return true;
			}
		}catch (Exception e){
			System.err.println(modelIntroduced.getURI().lastSegment() + "__" + modelResolved.getURI().lastSegment() + ": " + e.getMessage());
			
		}
		
		return false;
	}

	
	protected abstract LiftingSettings getLiftingSettings();

	protected abstract String[] getFileFilters();

	protected abstract long maxModelFileLength();

	protected abstract List<String> getCharacterizingMessageFragments();
	
	private void serializeResults(String folder) throws IOException{
		File report_folder = new File(folder + File.separator + "report") ;
		report_folder.mkdir();
		FileWriter writer = new FileWriter(report_folder.getAbsolutePath()  + File.separator + "report-overview.txt");
		writer.write(bufOverview.toString());
		writer.close();

		writer = new FileWriter(report_folder.getAbsolutePath() + File.separator + "report-introducedAndResolved.txt");
		writer.write(bufIntroducedAndResolvedErrors.toString());
		writer.close();

		writer = new FileWriter(report_folder.getAbsolutePath() + File.separator + "report-unique.txt");
		writer.write(bufUnique.toString());
		writer.close();
		
		for(SymmetricDifference symDiff : symDiffs){
			String filename = symDiff.getModelA().getURI().lastSegment().substring(0,  symDiff.getModelA().getURI().lastSegment().indexOf("_"))
					+ "__"  + symDiff.getModelB().getURI().lastSegment().substring(0,  symDiff.getModelA().getURI().lastSegment().indexOf("_"));
			LiftingFacade.serializeLiftedDifference(symDiff, report_folder.getAbsolutePath(), filename );
		}
	}
}

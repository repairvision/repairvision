package org.sidiff.repair.history.generator.run;

import java.io.File;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.configuration.IConfigurable;
import org.sidiff.difference.technical.ITechnicalDifferenceBuilder;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.difference.technical.api.util.TechnicalDifferenceUtils;
import org.sidiff.matcher.IMatcher;
import org.sidiff.matching.api.util.MatchingUtils;
import org.sidiff.repair.history.generator.HistoryModelGenerator;
import org.sidiff.repair.history.generator.settings.EvaluationSettings;
import org.sidiff.repair.history.generator.validation.EMFValidator;

public class RunHistoryModelGeneratorEcoreAndEMF implements IApplication {

	private static final String ROOT = "D:\\Git\\sidiff-lifting\\research\\org.sidiff.repair.casestudy\\ecore-versions\\www.eclipse.org\\epsilon";
	
	@Override
	public Object start(IApplicationContext context) throws Exception {
		System.out.println("########## Start History Model Generator ##########");
		File file = new File(ROOT);
		
		System.out.print("Root Folder: ");
		if(file.exists()){
			System.out.println(file.getName());
		}else{
			System.err.println(file.getName() + "does not exist!");
		}
		DifferenceSettings differenceSettings = new DifferenceSettings();
		
	
		IMatcher matcher = MatchingUtils.getMatcherByKey("org.sidiff.matcher.signature.name.NamedElementMatcher");
		ITechnicalDifferenceBuilder builder = TechnicalDifferenceUtils.getTechnicalDifferenceBuilder("org.sidiff.ecore.difference.technical.TechnicalDifferenceBuilderEcore");
		
		IConfigurable configurable = (IConfigurable) matcher;
		configurable.getConfigurationOptions();
		configurable.setConfigurationOption("Use Qualified Names", false);
		
		differenceSettings.setMatcher(matcher);
		differenceSettings.setTechBuilder(builder);
		
		EvaluationSettings evaluationSettings = new EvaluationSettings(file.getName(), new String[]{"ecore"}, differenceSettings, new EMFValidator());
		
		
		new HistoryModelGenerator().generateHistoryProject(ROOT, evaluationSettings);
		
		System.out.println("########## Finished History Model Generator ##########");
		return null;
	}

	@Override
	public void stop() {
	}
}

package org.sidiff.validation.laguage.fol.generator

import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IOutputConfigurationProvider
import org.eclipse.xtext.generator.OutputConfiguration

class FirstOrderLogicOutputConfigurationProvider implements IOutputConfigurationProvider {

	public static val PROJECT_ROOT = "PROJECT_ROOT"

	override getOutputConfigurations() {
		return newHashSet(createDefaultConfig, createProjectRootConfig)
	}
	
	protected def OutputConfiguration createProjectRootConfig() {
		val configProjectRoot = new OutputConfiguration(PROJECT_ROOT)
		configProjectRoot.setDescription("Project Root")
		configProjectRoot.setOutputDirectory(".")
		configProjectRoot.setOverrideExistingResources(true)
		configProjectRoot.setCleanUpDerivedResources(true)
		configProjectRoot.setKeepLocalHistory(true)
		configProjectRoot
	}
	
	protected def OutputConfiguration createDefaultConfig() {
		val defaultOutput = new OutputConfiguration(IFileSystemAccess.DEFAULT_OUTPUT)
		defaultOutput.setDescription("Output Folder")
		defaultOutput.setOutputDirectory("./src-gen")
		defaultOutput.setOverrideExistingResources(true)
		defaultOutput.setCreateOutputDirectory(true)
		defaultOutput.setCleanUpDerivedResources(true)
		defaultOutput.setKeepLocalHistory(true)
		defaultOutput
	}
	
}
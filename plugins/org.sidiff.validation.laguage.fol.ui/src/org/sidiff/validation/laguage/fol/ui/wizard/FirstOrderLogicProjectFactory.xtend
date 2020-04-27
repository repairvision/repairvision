package org.sidiff.validation.laguage.fol.ui.wizard

import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.SubMonitor
import org.eclipse.swt.widgets.Shell
import org.eclipse.xtext.ui.util.PluginProjectFactory
import org.eclipse.xtext.ui.util.TextFileContributor

class FirstOrderLogicProjectFactory extends PluginProjectFactory {

	String fileName

	override protected enhanceProject(IProject project, SubMonitor subMonitor, Shell shell) throws CoreException {
		super.enhanceProject(project, subMonitor, shell)

		if(fileName.endsWith(".fol")) {
			fileName = fileName.substring(0, fileName.length-4)
		}
		addContributor(new TextFileContributor('''src/«projectName.replace('.', '/')»/«fileName».fol''', ''))
	}
	
	def setFileName(String fileName) {
		this.fileName = fileName
	}
	
	def getFileName() {
		return fileName
	}
}
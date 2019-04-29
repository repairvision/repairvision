package org.sidiff.validation.ocl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor.EvaluationVisitorExtension;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.internal.complete.CompleteEnvironmentInternal;
import org.eclipse.ocl.pivot.internal.complete.CompleteModelInternal;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.evaluation.ExecutorInternal;
import org.eclipse.ocl.pivot.internal.library.ImplementationManager;
import org.eclipse.ocl.pivot.internal.manager.FlowAnalysis;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.manager.TemplateParameterSubstitutionVisitor;
import org.eclipse.ocl.pivot.internal.resource.EnvironmentFactoryAdapter;
import org.eclipse.ocl.pivot.internal.resource.ICSI2ASMapping;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.External2AS;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.internal.utilities.Technology;
import org.eclipse.ocl.pivot.messages.StatusCodes.Severity;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.resource.ProjectManager.IConflictHandler;
import org.eclipse.ocl.pivot.resource.ProjectManager.IResourceLoadStrategy;
import org.eclipse.ocl.pivot.utilities.Option;
import org.eclipse.ocl.pivot.utilities.ParserContext;
import org.eclipse.ocl.pivot.utilities.ParserException;

/**
 * Makes sure the evaluation visitor is wrapped by the TracingEvaluationVisitor.
 * The visitor factory methods are usually delegated to the
 * ExecutorInternal.getEvaluationVisitor(), so this TracingEnvironmentFactory
 * delegation is actually not needed by the default implementation.
 */
public class TracingOCLEnvironmentFactory implements EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension {

	EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension delegated;

	protected TracingOCLEnvironmentFactory(EnvironmentFactoryInternalExtension delegated) {
		this.delegated = delegated;
	}

	public EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension getTracedEnvironmentFactory() {
		return delegated;
	}
	
	@Override
	public @NonNull EvaluationVisitor createEvaluationVisitor(@Nullable Object context,
			@NonNull ExpressionInOCL expression, @Nullable ModelManager modelManager) {

		// NOTE: This factory is usually delegated to the
		// ExecutorInternal.getEvaluationVisitor()
		EvaluationVisitor visitor = delegated.createEvaluationVisitor(context, expression, modelManager);

		if (!(visitor instanceof TracingOCLEvaluationVisitor)) {
			visitor = new TracingOCLEvaluationVisitor((EvaluationVisitorExtension) visitor);
		}

		return visitor;
	}

	@Override
	public @NonNull EvaluationVisitor createEvaluationVisitor(@NonNull EvaluationEnvironment evalEnv) {

		// NOTE: This factory is usually delegated to the
		// ExecutorInternal.getEvaluationVisitor()
		EvaluationVisitor visitor = delegated.createEvaluationVisitor(evalEnv);

		if (!(visitor instanceof TracingOCLEvaluationVisitor)) {
			visitor = new TracingOCLEvaluationVisitor((EvaluationVisitorExtension) visitor);
		}

		return visitor;
	}

	/* delegations */

	@Override
	public <T> @Nullable T getAdapter(Class<T> adapterType) {
		return delegated.getAdapter(adapterType);
	}

	@Override
	public Map<Option<?>, Object> getOptions() {
		return delegated.getOptions();
	}

	@Override
	public <@Nullable T> T getValue(@NonNull Option<T> option) {
		return delegated.getValue(option);
	}

	@Override
	public boolean isEnabled(@NonNull Option<@Nullable Boolean> option) {
		return delegated.isEnabled(option);
	}

	@Override
	public <T> void setOption(@NonNull Option<T> option, @Nullable T value) {
		delegated.setOption(option, value);
	}

	@Override
	public @NonNull ExecutorInternal createExecutor(@NonNull ModelManager modelManager) {
		return delegated.createExecutor(modelManager);
	}

	@Override
	public <@Nullable T> void putOptions(@NonNull Map<? extends Option<T>, ? extends T> options) {
		delegated.putOptions(options);
	}

	@Override
	public boolean isEvaluationTracingEnabled() {
		return delegated.isEvaluationTracingEnabled();
	}

	@Override
	public <@Nullable T> @Nullable T removeOption(@NonNull Option<T> option) {
		return delegated.removeOption(option);
	}

	@Override
	public @Nullable ParserContext createParserContext(@NonNull Element element) {
		return delegated.createParserContext(element);
	}

	@Override
	public @NonNull TemplateParameterSubstitutionVisitor createTemplateParameterSubstitutionVisitor(
			@Nullable Type selfType, @Nullable Type selfTypeValue) {
		return delegated.createTemplateParameterSubstitutionVisitor(selfType, selfTypeValue);
	}

	@Override
	public <@Nullable T> @NonNull Map<Option<T>, T> removeOptions(@NonNull Collection<Option<T>> options) {
		return delegated.removeOptions(options);
	}

	@Override
	public @NonNull Map<Option<?>, Object> clearOptions() {
		return delegated.clearOptions();
	}

	@Override
	public void addExternal2AS(@NonNull External2AS external2as) {
		delegated.addExternal2AS(external2as);
	}

	@Override
	public org.eclipse.ocl.pivot.@Nullable Class getASClass(@NonNull String className) {
		return delegated.getASClass(className);
	}

	@Override
	public void addExternalResources(@NonNull ResourceSet externalResourceSet) {
		delegated.addExternalResources(externalResourceSet);
	}

	@Override
	public <T extends Element> @Nullable T getASOf(@NonNull Class<T> pivotClass, @Nullable EObject eObject)
			throws ParserException {
		return delegated.getASOf(pivotClass, eObject);
	}

	@Override
	public synchronized void attach(Object object) {
		delegated.attach(object);
	}

	@Override
	public void configureLoadFirstStrategy() {
		delegated.configureLoadFirstStrategy();
	}

	@Override
	public boolean isDisposed() {
		return delegated.isDisposed();
	}

	@Override
	public @NonNull ExpressionInOCL parseSpecification(@NonNull LanguageExpression specification)
			throws ParserException {
		return delegated.parseSpecification(specification);
	}

	@Override
	public void configureLoadStrategy(@NonNull IResourceLoadStrategy packageLoadStrategy,
			@Nullable IConflictHandler conflictHandler) {
		delegated.configureLoadStrategy(packageLoadStrategy, conflictHandler);
	}

	@Override
	public @NonNull EnvironmentFactoryAdapter adapt(@NonNull Notifier notifier) {
		return (EnvironmentFactoryAdapter) delegated.adapt(notifier);
	}

	@Override
	public @NonNull EvaluationEnvironment createEvaluationEnvironment(@NonNull NamedElement executableObject,
			@NonNull ModelManager modelManager) {
		return delegated.createEvaluationEnvironment(executableObject, modelManager);
	}

	@Override
	public @NonNull ResourceSetImpl createASResourceSet() {
		return delegated.createASResourceSet();
	}

	@Override
	public @NonNull FlowAnalysis createFlowAnalysis(@NonNull OCLExpression contextExpression) {
		return delegated.createFlowAnalysis(contextExpression);
	}

	@Override
	@Deprecated
	public @NonNull EvaluationEnvironment createEvaluationEnvironment(@NonNull EvaluationEnvironment parent,
			@NonNull NamedElement executableObject) {
		return delegated.createEvaluationEnvironment(parent, executableObject);
	}

	@Override
	public @NonNull CompleteEnvironmentInternal createCompleteEnvironment() {
		return delegated.createCompleteEnvironment();
	}

	@Override
	public @NonNull IdResolver createIdResolver() {
		return delegated.createIdResolver();
	}

	@Override
	public @NonNull ImplementationManager createImplementationManager() {
		return delegated.createImplementationManager();
	}

	@Override
	public @NonNull PivotMetamodelManager createMetamodelManager() {
		return delegated.createMetamodelManager();
	}

	@Override
	public @NonNull OCLInternal createOCL() {
		return delegated.createOCL();
	}

	@Override
	@Deprecated
	public @NonNull ParserContext createParserContext(@Nullable EObject context) throws ParserException {
		return delegated.createParserContext(context);
	}

	@Override
	public synchronized void detach(Object object) {
		delegated.detach(object);
	}

	@Override
	public void dispose() {
		delegated.dispose();
	}

	@Override
	public @Nullable ICSI2ASMapping getCSI2ASMapping() {
		return delegated.getCSI2ASMapping();
	}

	@Override
	public @NonNull CompleteEnvironmentInternal getCompleteEnvironment() {
		return delegated.getCompleteEnvironment();
	}

	@Override
	public @NonNull ModelManager createModelManager(@Nullable Object object) {
		return delegated.createModelManager(object);
	}

	@Override
	public @NonNull CompleteModelInternal getCompleteModel() {
		return delegated.getCompleteModel();
	}

	@Override
	public @Nullable String getDoSetupName(@NonNull URI uri) {
		return delegated.getDoSetupName(uri);
	}

	@Override
	public @NonNull PivotMetamodelManager getMetamodelManager() {
		return delegated.getMetamodelManager();
	}

	@Override
	public @NonNull StandardLibraryInternal getStandardLibrary() {
		return delegated.getStandardLibrary();
	}

	@Override
	public @NonNull Technology getTechnology() {
		return delegated.getTechnology();
	}

	@Override
	public EPackage loadEPackage(@NonNull EPackage ePackage) {
		return delegated.loadEPackage(ePackage);
	}

	@Override
	public @Nullable Element loadResource(@NonNull Resource resource, @Nullable URI uri) throws ParserException {
		return delegated.loadResource(resource, uri);
	}

	@Override
	public void setCSI2ASMapping(ICSI2ASMapping csi2asMapping) {
		delegated.setCSI2ASMapping(csi2asMapping);
	}

	@Override
	public void setEvaluationTracingEnabled(boolean b) {
		delegated.setEvaluationTracingEnabled(b);
	}

	@Override
	public void setProject(@Nullable IProject project) {
		delegated.setProject(project);
	}

	@Override
	public void setSafeNavigationValidationSeverity(@NonNull Severity severity) {
		delegated.setSafeNavigationValidationSeverity(severity);
	}

	@Override
	public @NonNull IdResolver getIdResolver() {
		return delegated.getIdResolver();
	}

	@Override
	public @NonNull ProjectManager getProjectManager() {
		return delegated.getProjectManager();
	}

	@Override
	public @NonNull ResourceSet getResourceSet() {
		return delegated.getResourceSet();
	}

	@Override
	public @Nullable Severity getSeverity(@Nullable Object validationKey) {
		return delegated.getSeverity(validationKey);
	}

	@Override
	public @Nullable synchronized Severity setSeverity(Object validationKey, @Nullable Severity severity) {
		return delegated.setSeverity(validationKey, severity);
	}
}

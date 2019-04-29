package org.sidiff.validation.ocl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor.EvaluationVisitorExtension;
import org.eclipse.ocl.pivot.internal.evaluation.BasicOCLExecutor;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactoryRegistry;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.ParserException;

public class TracingOCLExecutor extends BasicOCLExecutor {
	
	protected final @NonNull ExpressionInOCL expressionInOCL;
	
	protected final @Nullable EObject context;
	
	/**
	 * Evaluates the given constraint/invariant on the given context element.
	 * 
	 * @param environmentFactory see {@link #getEnviromentFactory(EObject, boolean)}
	 * @param constraint         see {@link #getInvariants(EnvironmentFactory, URI)}
	 * @param context            The model element to be validated.
	 * @throws ParserException
	 */
	public TracingOCLExecutor(
			EnvironmentFactoryInternal.@NonNull EnvironmentFactoryInternalExtension environmentFactory,
			@NonNull Constraint constraint, 
			@NonNull EObject context) throws ParserException {
		super(environmentFactory, environmentFactory.createModelManager(context));
		this.expressionInOCL = loadExpression(environmentFactory, constraint);
		this.context = context;
	}

	/**
	 * @param context The context element of the validation or <code>null</code>.
	 * @param wrapped Makes sure the evaluation visitor is wrapped by the
	 *                TracingEvaluationVisitor. The visitor factory methods are
	 *                usually delegated to the
	 *                ExecutorInternal.getEvaluationVisitor(), so the
	 *                TracingEnvironmentFactory delegation wrapper is actually not
	 *                needed by the default implementation.
	 * @return The enviroment factory for the given context element.
	 */
	public static EnvironmentFactoryInternal.@NonNull EnvironmentFactoryInternalExtension getEnviromentFactory(@Nullable EObject context, boolean wrapped) {
		EnvironmentFactoryInternal environmentFactory = null;
		
		if (context != null) {
			Resource eResource = context.eResource();
			
			if (eResource != null) {
				environmentFactory = PivotUtilInternal.findEnvironmentFactory(eResource);
			}
		}
		
		if (environmentFactory == null) {
			environmentFactory = ASResourceFactoryRegistry.INSTANCE.createEnvironmentFactory(OCL.NO_PROJECTS, null);
		}
		
		if (wrapped) {
			return (EnvironmentFactoryInternalExtension) environmentFactory;
		} else {
			return new TracingOCLEnvironmentFactory((EnvironmentFactoryInternalExtension) environmentFactory);
		}
	}

	/**
	 * @param environmentFactory The environment factory
	 *                           ({@link #getEnviromentFactory(EObject, boolean)}).
	 * @param oclURI             The URI of an *.ocl (concrete) or *.oclas
	 *                           (abstract) document.
	 * @return All invariants in the OCL document.
	 * @throws IOException
	 * @throws ParserException
	 */
	public static List<Constraint> getInvariants(@NonNull EnvironmentFactory environmentFactory, @NonNull URI oclURI) throws IOException, ParserException {
		List<Constraint> invariants = new ArrayList<>();
		
		if (oclURI.fileExtension().equals("ocl")) {
			oclURI = oclURI.appendFileExtension("oclas");
		}
		
		MetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
		Resource oclDoc = metamodelManager.getASResourceSet().getResource(oclURI, true);
		Model oclModel = (Model) oclDoc.getContents().get(0);
		
		for (Package oclPackage : oclModel.getOwnedPackages()) {
			for (Class oclClass : oclPackage.getOwnedClasses()) {
				invariants.addAll(oclClass.getOwnedInvariants());
			}
		}
		
		return invariants;
	}
	
	/**
	 * @param environmentFactory The environment factory
	 *                           ({@link #getEnviromentFactory(EObject, boolean)}).
	 * @param element            The context element of the validation.
	 * @param constraint         The constraint to be validated.
	 * @return <code>true</code> if the elements type matches the context type of
	 *         the constraint; <code>false</code> otherwise.
	 */
	public static boolean isMatchingContext(EnvironmentFactoryInternalExtension environmentFactory, EObject element, Constraint constraint) {
		try {
			Class type = environmentFactory.getASOf(Class.class, element.eClass());

			if (constraint.getContext().equals(type)) {
				return true;
			}
			
			// FIXME: different type objects - align loading of constraint and model!?
			if (constraint.getContext().toString().equals(type.toString())) {
				return true;
			}
		} catch (ParserException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * @return The result of the OCL validation.
	 */
	public Object execute() {
		initializeEvaluationEnvironment(expressionInOCL);
		getRootEvaluationEnvironment();
		Variable contextVariable = expressionInOCL.getOwnedContext();
		
		if (contextVariable != null) {
			add(contextVariable, context);
		}
		
		EvaluationVisitorExtension visitor = getEvaluationVisitor();
		Object result = expressionInOCL.accept(visitor);
		
		return result;
	}

	private static @NonNull ExpressionInOCL loadExpression(@NonNull EnvironmentFactory environmentFactory, Constraint constraint) throws ParserException {
		LanguageExpression specification = constraint.getOwnedSpecification();
		return ((EnvironmentFactoryInternalExtension)environmentFactory).parseSpecification(specification);
	}
	
	@Override
	protected @NonNull EvaluationVisitorExtension createEvaluationVisitor() {
		return new TracingOCLEvaluationVisitor(super.createEvaluationVisitor());
	}
}

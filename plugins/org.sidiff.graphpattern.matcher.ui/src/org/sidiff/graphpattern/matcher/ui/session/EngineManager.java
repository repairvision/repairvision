package org.sidiff.graphpattern.matcher.ui.session;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.matcher.IPatternMatchingEngine;
import org.sidiff.graphpattern.matcher.IPatternMatchingEngineFactory;
import org.sidiff.graphpattern.matcher.debug.PatternMatchingDebugger;
import org.sidiff.graphpattern.matcher.debug.PatternMatchingDebugger.BreakpointListener;
import org.sidiff.graphpattern.matcher.ui.util.SiriusUtil;
import org.sidiff.graphpattern.matching.IMatching;

public class EngineManager {

	private static EngineManager instance;

	/**
	 * Pattern matching engine.
	 */
	private PatternMatchingDebugger debuggableEngine;

	private IPatternMatchingEngine<? extends IMatching> matchingEngine;

	private GraphPattern graphpattern;

	private ResourceSet targetModels;

	public EngineManager() {
		targetModels = new ResourceSetImpl();
	}

	public static EngineManager getInstance() {

		if (instance == null) {
			instance = new EngineManager();
		}

		return instance;
	}

	public IPatternMatchingEngine<? extends IMatching> getMatchingEngine() {
		return matchingEngine;
	}

	public PatternMatchingDebugger getDebuggableEngine() {
		return debuggableEngine;
	}

	public Resource loadModel(IResource workbenchResource) {

		String projectName = workbenchResource.getProject().getName();
		String filePath = workbenchResource.getProjectRelativePath().toOSString();
		String platformPath = projectName + "/" + filePath;

		Resource modelRes = targetModels.getResource(
				URI.createPlatformResourceURI(platformPath, true), true);

		return modelRes;
	}

	public void removeModel(Resource modelResource) {
		targetModels.getResources().remove(modelResource);
	}

	public void clearModels() {
		targetModels = new ResourceSetImpl();
	}

	public List<Resource> getModels() {
		return targetModels.getResources();
	}

	public ResourceSet getModelResourceSet() {
		return targetModels;
	}

	public void setGraphpattern(GraphPattern graphpattern) {
		this.graphpattern = graphpattern;
	}

	public GraphPattern getGraphPattern() {
		return graphpattern;
	}

	public void startEngine(IPatternMatchingEngineFactory<? extends IMatching> targetEngine) {
		if (targetEngine == null) {
			return;
		}

		// Stop old engine:
		stopEngine();

		// Start new engine:
		this.matchingEngine = targetEngine.createPatternMatchingEngine(graphpattern, targetModels);
		this.matchingEngine.start();
	}

	public void startDebugger(IPatternMatchingEngineFactory<? extends IMatching> targetEngine, BreakpointListener... breakpointListeners) {
		if (targetEngine == null) {
			return;
		}
		
		// Stop old engine:
		stopEngine();

		// New engine:
		this.matchingEngine = targetEngine.createPatternMatchingEngine(graphpattern, targetModels);

		if (targetEngine != null) {

			// Install debuggable matching engine:
			SiriusUtil.edit(graphpattern, () -> {
				debuggableEngine = new PatternMatchingDebugger();
				debuggableEngine.install(matchingEngine);
			});

			// Breakpoint events:
			for (BreakpointListener breakpointListener : breakpointListeners) {
				debuggableEngine.addBreakpointListener(breakpointListener);
			}

			// Start engine:
			debuggableEngine.start(matchingEngine);
		}
	}

	public void stopEngine() {

		try {
			if (debuggableEngine != null) {
				// Debuggable engine:
				debuggableEngine.stop();
			} else {
				if (matchingEngine != null) {
					// Normal engine:
					matchingEngine.finish();
				}
			}
		} finally {

			// Reset Engine-Manager:
			debuggableEngine = null;
			matchingEngine = null;

			// FIXME[WORKAROUND]: Undeletable repair-operations!?
			ResourceSet oldRSS = targetModels;
			targetModels = new ResourceSetImpl();

			for (Resource oldRes : oldRSS.getResources()) {
				try {
					Resource newRes = targetModels.createResource(oldRes.getURI());
					newRes.load(null);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			System.gc();
			//---------------------------------------------------
		}
	}

	public void removeEvaluations() {
		SiriusUtil.edit(graphpattern, () -> {
			for (NodePattern node : EngineManager.getInstance().getGraphPattern().getNodes()) {
				node.setEvaluation(null);
			}
		});
	}

	public void resumeAllBreakpoints() {

		if (debuggableEngine != null) {
			debuggableEngine.resumeAllBreakpoints();
		}
	}
}

package org.sidiff.graphpattern.matcher.debug;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.sidiff.graphpattern.Evaluation;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.matcher.IPatternMatchingEngine;

public class PatternMatchingDebugger {

	protected CountDownLatch synchronizationBarrier;
	
	protected Thread engineThread;
	
	protected IPatternMatchingEngine<?> targetEngine;
	
	protected List<Breakpoint> waitingBreakpoints = new ArrayList<>();
	
	protected List<BreakpointListener> breakpointListeners = new ArrayList<>();
	
	public static class Breakpoint {
		public Evaluation evaluation;
		
		@Override
		public String toString() {
			return "Breakpoint:\n\n" + evaluation.toString();
		}
	}
	
	public static class Termination extends Breakpoint {
		
		@Override
		public String toString() {
			return "Termination!";
		}
	}
	
	public interface BreakpointListener {
		public void signalWait(Breakpoint breakpoint);
	}
	
	public void install(IPatternMatchingEngine<?> targetEngine) {
		this.targetEngine = targetEngine;
		
		// Install debuggable evaluation:
		for (NodePattern node : targetEngine.getGraphPattern()) {
			DebuggableEvaluation debuggableEvaluation = new DebuggableEvaluation(this);
			debuggableEvaluation.install(node.getEvaluation());
		}
	}
	
	/**
	 * Starts the given engine in a thread.
	 * 
	 * @param engine
	 *            The engine which should be debugged.
	 */
	public void start(IPatternMatchingEngine<?> engine) {
		synchronizationBarrier = new CountDownLatch(1);
		
		// Run as new thread:
		engineThread = new Thread(engine::start);
		engineThread.start();
		
		synchronizationBarrier.countDown();
	}
	
	public void stop() {
		if (engineThread != null) {
			engineThread.interrupt();
		}
		waitingBreakpoints.clear();
		targetEngine.finish();
	}
	
	public Thread getEngineThread() {
		return engineThread;
	}
	
	public CountDownLatch getSynchronizationBarrier() {
		return synchronizationBarrier;
	}
	
	public void addBreakpointListener(BreakpointListener breakpointListener) {
		breakpointListeners.add(breakpointListener);
	}
	
	public void removeBreakpointListener(BreakpointListener breakpointListener) {
		breakpointListeners.remove(breakpointListener);
	}
	
	private void notifyBreakpointListener(Breakpoint breakpoint) {
		breakpointListeners.forEach(listener -> listener.signalWait(breakpoint));
	}
	
	public List<Breakpoint> getWaitingBreakpoints() {
		return Collections.unmodifiableList(waitingBreakpoints);
	}

	public synchronized void addWaitingBreakpoint(Breakpoint waitingBreakpoint) {
		
		synchronized (waitingBreakpoints) {
			waitingBreakpoints.add(waitingBreakpoint);
			notifyBreakpointListener(waitingBreakpoint);
		}
	}
	
	public void resumeBreakpoints(Breakpoint breakpoint) {

		synchronized (waitingBreakpoints) {
			synchronized (breakpoint) {
				breakpoint.notify();
				waitingBreakpoints.remove(breakpoint);
			}
		}
	}
	
	public void resumeAllBreakpoints() {
		
		synchronized (waitingBreakpoints) {
			
			if (waitingBreakpoints.isEmpty()) {
				// Assume termination:
				notifyBreakpointListener(new Termination());
			} else {
				// Resume
				for (Breakpoint breakpoint : waitingBreakpoints) {
					synchronized (breakpoint) {
						breakpoint.notify();
					}
				}
				
				waitingBreakpoints.clear();
			}
		}
	}

	public IPatternMatchingEngine<?> getTargetEngine() {
		return targetEngine;
	}
}

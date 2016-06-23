package org.sidiff.consistency.graphpattern.matcher.debug;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.sidiff.consistency.graphpattern.Evaluation;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.IPatternMatchingEngine;

public class PatternMatchingDebugger {

	private IPatternMatchingEngine targetEngine;
	
	private List<Breakpoint> waitingBreakpoints = new ArrayList<>();
	
	private List<BreakpointListener> breakpointListeners = new ArrayList<>();
	
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
	
	public void install(IPatternMatchingEngine targetEngine) {
		this.targetEngine = targetEngine;
		
		// Install debuggable evaluation:
		// FIXME: AbstractPatternMatchingEngine#getAllNodePatterns() -> Graph model function
		for (NodePattern node : targetEngine.getGraphPattern().getNodes()) {
			DebuggableEvaluation debuggableEvaluation = new DebuggableEvaluation(this);
			debuggableEvaluation.install(node.getEvaluation());
		}
	}
	
	public void stop() {
		targetEngine.stop();
		waitingBreakpoints.clear();
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

	public IPatternMatchingEngine getTargetEngine() {
		return targetEngine;
	}
}

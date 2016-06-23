package org.sidiff.consistency.graphpattern.matcher.debug;

import org.sidiff.consistency.graphpattern.Evaluation;
import org.sidiff.consistency.graphpattern.Visitor;
import org.sidiff.consistency.graphpattern.impl.EvaluationImpl;
import org.sidiff.consistency.graphpattern.matcher.debug.PatternMatchingDebugger.Breakpoint;

public class DebuggableEvaluation extends EvaluationImpl  {

	private PatternMatchingDebugger debugger;
	
	private final Breakpoint breakpoint = new Breakpoint();
	
	private Evaluation targetEvaluation;

	public DebuggableEvaluation(PatternMatchingDebugger debugger) {
		this.debugger = debugger;
		this.breakpoint.evaluation = this;
	}
	
	public void install(Evaluation targetEvaluation) {
		this.targetEvaluation = targetEvaluation;
		
		targetEvaluation.getNode().setEvaluation(this);
		setStore(targetEvaluation.getStore());
	}
	
	public void uninstall() {
		getNode().setEvaluation(targetEvaluation);
		targetEvaluation.setStore(getStore());
	}
	
	@Override
	public void accept(Visitor visitor) {
		
		// Breakpoint:
		synchronized (breakpoint) {
			try {
				debugger.addWaitingBreakpoint(breakpoint);
				breakpoint.wait();
			} catch (InterruptedException e) {
				// Engine interrupted...
				debugger.stop();
			}
		}
		
		// Proceed with the execution:
		super.accept(visitor);
	}
}

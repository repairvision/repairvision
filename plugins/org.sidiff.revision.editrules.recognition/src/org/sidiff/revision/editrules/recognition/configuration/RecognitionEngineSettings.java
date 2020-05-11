package org.sidiff.revision.editrules.recognition.configuration;

public class RecognitionEngineSettings {

	private RecognitionEngineMonitor monitor = new RecognitionEngineMonitor();

	private int minimumSolutionSize = 1;

	/**
	 * @return The recognition engine logging monitor.
	 */
	public RecognitionEngineMonitor getMonitor() {
		return monitor;
	}

	/**
	 * @param monitor
	 *            The recognition engine logging monitor.
	 */
	public void setMonitor(RecognitionEngineMonitor monitor) {
		this.monitor = monitor;
	}

	/**
	 * @return The minimum size of the solutions to be found.
	 */
	public int getMinimumSolutionSize() {
		return minimumSolutionSize;
	}

	/**
	 * @param minimumSolutionSize
	 *            The minimum size of the solutions to be found or 1.
	 */
	public void setMinimumSolutionSize(int minimumSolutionSize) {
		this.minimumSolutionSize = minimumSolutionSize;
	}
}

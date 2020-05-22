package org.sidiff.revision.editrules.recognition.configuration;

public class RecognitionSettings {

	private RecognitionLogger logger = new RecognitionLogger();

	private int minimumSolutionSize = 1;

	/**
	 * @return The recognition engine logging monitor.
	 */
	public RecognitionLogger getLogger() {
		return logger;
	}

	/**
	 * @param logger
	 *            The recognition engine logging monitor.
	 */
	public void setLogger(RecognitionLogger logger) {
		this.logger = logger;
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

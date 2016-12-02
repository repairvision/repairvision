package org.sidiff.graphpattern.common.algorithms;

/**
 * Manages the lifecycle of an algorithm/calculation.
 * 
 * @author Manuel Ohrndorf
 */
public interface IAlgorithm extends Runnable {

	default public void run() {
		start();
	};
	
	/**
	 * Starts the calculation of the algorithm.
	 */
	public void start();

	/**
	 * Do some clean-up.
	 */
	public void finish(); 
}

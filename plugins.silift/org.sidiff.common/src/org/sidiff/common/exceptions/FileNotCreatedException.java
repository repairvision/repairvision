package org.sidiff.common.exceptions;

public class FileNotCreatedException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FileNotCreatedException(){
		super();
	}
	
	public FileNotCreatedException(String message){
		super(message);
	}

}

package org.sidiff.common.exceptions;

public class FileAlreadyExistsException extends Exception {

	public FileAlreadyExistsException(){
		super();
	}
	
	public FileAlreadyExistsException(String message){
		super(message);
	}
}

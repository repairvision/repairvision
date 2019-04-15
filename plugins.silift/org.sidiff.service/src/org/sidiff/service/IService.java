package org.sidiff.service;

public interface IService {
	
	public static final String EXTENSION_POINT_ID = "org.sidiff.service.extensionpoint";
	public static final String SERVICE_ID = "SiDiffService";
	
	public String getDescription();
	public String getServiceID();
	
	public abstract void reset();
	
	//public abstract boolean isInitialized();
	
	//TODO
	//public abstract void init(Settings settings);
	
}

package org.sidiff.configuration;

import org.w3c.dom.Document;

public interface IConfigurationCapable{
	
	public abstract void configure(Document configuration);
	public abstract void configure();
	
	public String getSubfolderName();
	
	public abstract Document getConfiguration();
	public abstract void setConfiguration(Document configuration);
	
}

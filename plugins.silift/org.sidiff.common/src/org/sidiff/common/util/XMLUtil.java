package org.sidiff.common.util;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

public class XMLUtil {

	private File file = null;
	private Document doc = null;
	private SAXBuilder builder;
	private XMLOutputter outputter;
	
	public XMLUtil(){
		builder = new SAXBuilder();
		outputter = new XMLOutputter();
	}
	
	public void loadXML(File file) throws JDOMException, IOException{
		this.file = file;
		doc = builder.build(file);
	}
	
	public void printXML() throws IOException{
		if(doc != null) outputter.output(doc, System.out);
	}
	
	public void save(String path) throws FileNotFoundException, IOException{
		if(file != null && doc != null)
			outputter.output(doc, new BufferedOutputStream(new FileOutputStream(path)));
	}
	
	/**
	 * 
	 * @return List of all attributes of a XML file
	 */
	public List<Attribute> getAttributes(){
		Iterator<Content> it = doc.getRootElement().getDescendants();
		ArrayList<Attribute> result = new ArrayList<Attribute>();
		result.addAll(doc.getRootElement().getAttributes());
		while(it.hasNext()){
			Object obj = it.next();
			if(obj instanceof Element){
				Element element = (Element)obj;
				result.addAll(element.getAttributes());
			}
		}
		return result;
	}
	
	/**
	 * 
	 * @param names of attributes to be searched
	 * @return List of attributes
	 */
	public List<Attribute> getAttributesByName(String...names){
		Iterator<Content> it = doc.getRootElement().getDescendants();
		ArrayList<Attribute> result = new ArrayList<Attribute>();
		for(int i = 0; i<names.length; i++){
			result.add(doc.getRootElement().getAttribute(names[i]));
			while(it.hasNext()){
				Object obj = it.next();
				if(obj instanceof Element){
					Element element = (Element)obj;
					result.add(element.getAttribute(names[i]));
				}
			}
		}
		return result;
	}
}
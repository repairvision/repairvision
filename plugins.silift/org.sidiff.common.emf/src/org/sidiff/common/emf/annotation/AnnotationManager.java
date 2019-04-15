package org.sidiff.common.emf.annotation;

import java.util.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.EMFAdapter;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.common.io.IOUtil;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.common.util.ObjectUtil;
import org.sidiff.common.util.ReflectionUtil;
import org.sidiff.common.xml.XMLParser;
import org.sidiff.common.xml.XMLWriter;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class AnnotationManager extends ObjectUtil {
	
	private static final String DOC_TYPE = "/workspaces_eclipse/sidiff_core/org.sidiff.common.emf/resources/org.sidiff.common.emf.annotations.dtd";
//	private static final String DOC_TYPE = "http://pi.informatik.uni-siegen.de/SiDiff/org.sidiff.common.emf.annotationPersistence.dtd";

	private static final String ROOT = "Annotations";
	private static final String OBJECT = "Object";
	private static final String ANNOTATION = "Annotation";
	
	private static final String ATTR_RESOURCE = "Resource";
	private static final String ATTR_ID = "id";
	private static final String ATTR_KEY = "key";
	private static final String ATTR_DATA = "data";
	private static final String ATTR_TYP = "typ";
	
	public static void serialize(Resource resource, String file){
		
		XMLWriter writer = new XMLWriter(IOUtil.getOutputStreamIntoFile(file));
				
		writer.initDocument(DOC_TYPE, null, ROOT, Collections.singletonMap(ATTR_RESOURCE, resource.getURI().toString()));

		AnnotateableElement element = EMFAdapter.INSTANCE.adapt(resource, AnnotateableElement.class);
		if(!element.getAnnotations().isEmpty()){
			writeAnnotations(writer, element, null);
		}
		
		for(EObject eObject : EMFUtil.getAllContentAsIterable(resource)){
			element = EMFAdapter.INSTANCE.adapt(eObject, AnnotateableElement.class);
			if(!element.getAnnotations().isEmpty()){
				writeAnnotations(writer, element, EMFUtil.getEObjectID(eObject));
			}
		}
		writer.finishDocument();
	}
	
	private static void writeAnnotations(XMLWriter writer, AnnotateableElement element, String id){
		
		
		writer.generateStartTag(OBJECT, (id!=null)? Collections.singletonMap(ATTR_ID, id) : null);
		
		
		// ** Serialize Elements
		Map<String, String> xmlAttributes = new LinkedHashMap<String, String>();
		for(String key : element.getAnnotations()){
			Object annotation = element.getAnnotation(key, Object.class);
			xmlAttributes.put(ATTR_KEY, key);
		
			String objectData = ObjectUtil.marshal(annotation);
			String[] type_data = objectData.split(AnnotationManager.TYPE_SEPERATOR, 2);
			assert(type_data.length==2) : "Missing type seperator! ("+objectData+")";
			
			xmlAttributes.put(ATTR_TYP, type_data[0]);
			xmlAttributes.put(ATTR_DATA, type_data[1]);
			writer.generateEmptyTag(ANNOTATION, xmlAttributes);
		}
		writer.generateEndTag(OBJECT);
	}
	
	public static void deserialize(final Resource resource, String file){
		
		XMLParser.parseXML(new InputSource(IOUtil.getInputStreamFromFile(file)),
				new DefaultHandler(){
			
				AnnotateableElement element = null;
				@Override
				public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
					
					if(localName.equals(OBJECT)){
						String id = attributes.getValue(uri, ATTR_ID);
						element = EMFAdapter.INSTANCE.adapt((id==null)?
								resource : resource.getEObject(id), AnnotateableElement.class);
					} else if(localName.equals(ANNOTATION)){
						assert(element!=null) : "Missing Element to perform annotation! "+attributes;
						handleAnnotation(element, attributes);
					}
				}	
			});		
	}
	

	private static void handleAnnotation(AnnotateableElement element, Attributes attributes){
	
			
			String key = attributes.getValue(ATTR_KEY);
			String typeName = attributes.getValue(ATTR_TYP);
			
			StringBuffer dataString = new StringBuffer();
			Object annotation = null;
			try {
				Class<?> type  = ReflectionUtil.loadClass(typeName);
			
				dataString.append(type.getName());
				dataString.append(ObjectUtil.TYPE_SEPERATOR);
				dataString.append(attributes.getValue(ATTR_DATA));
			
				annotation = ObjectUtil.unmarshal(type, dataString.toString());
			} catch (Exception e) {
				LogUtil.log(LogEvent.ERROR, String.format("Error while deserializing %s (Exception: %s, Message: %s)", element, e.getClass().getSimpleName(), e.getMessage()));
			}
			
			if (annotation != null){
				element.setAnnotation(key, annotation);
			} else {
				LogUtil.log(LogEvent.ERROR, "Null data while unmarshalling Annotations. Probably missing Converter");
			}
		
	}
	
	public static void disposeAnnotations(AnnotateableElement element) {
		for(String annotationKey : element.getAnnotations()){
			element.removeAnnotation(annotationKey);
		}
	}
	
	public static void disposeAnnotations(Resource resource) {
		AnnotateableElement element = EMFAdapter.INSTANCE.adapt(resource, AnnotateableElement.class);
		disposeAnnotations(element);
		
		for(EObject eObject : EMFUtil.getAllContentAsIterable(resource)){
			element = EMFAdapter.INSTANCE.adapt(eObject, AnnotateableElement.class);
			disposeAnnotations(element);
		}
	}

}

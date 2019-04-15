package org.sidiff.common.emf.annotation.internal;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.EMFAdapter;
import org.sidiff.common.emf.annotation.AnnotateableElement;
import org.sidiff.common.util.Debugger;
import org.sidiff.common.util.StringUtil;

/**
 * Debugger class that can reflectively be used by the SiDiffDebugger. 
 * @author wenzel
 *
 */
public class AnnotationDebugger implements Debugger {
	
	private static final String HELP = "AnnotationDebugger provides Functions to look into Annotations of EObjects or whole Resources\n";
	private static final String FUNCTION_PATTERN = "%s (%s) : %s\n";
	
	private static final String ANNOTATIONS_ELEM = "Shows all Annotations of the element";
	private static final String ANNOTATION_ELEM = "Shows the Annotation of the element returned by the key";
	private static final String ANNOTATIONS_RES = "Shows all Annotations of all elements inside the Resource";
	private static final String ANNOTATION_RES = "Shows all Annotations inside the Resource returend by the key";
	
	private static final String[] FUNCTIONS = {
			String.format(FUNCTION_PATTERN, "annotations", "EObject element", ANNOTATIONS_ELEM),
			String.format(FUNCTION_PATTERN, "annotation", "EObject element, String key", ANNOTATION_ELEM),
			String.format(FUNCTION_PATTERN, "annotations", "Resource resource", ANNOTATIONS_RES),
			String.format(FUNCTION_PATTERN, "annotation", "Resource resource, String key", ANNOTATION_RES)
		};

	
	public String annotations(EObject elem) {
		StringBuffer sb = new StringBuffer();
		sb.append("annotations for "+StringUtil.resolve(elem)+"\n");
		AnnotateableElement ae = EMFAdapter.INSTANCE.adapt(elem, AnnotateableElement.class);
		for (String s : ae.getAnnotations())
			sb.append(s+"\t"+StringUtil.resolve(ae.getAnnotation(s, Object.class))+"\n");
		return sb.toString();
	}

	public String annotation(EObject elem, String key) {
		StringBuffer sb = new StringBuffer();
		sb.append("annotations for "+StringUtil.resolve(elem)+"\n");
		AnnotateableElement ae = EMFAdapter.INSTANCE.adapt(elem, AnnotateableElement.class);
		sb.append(key+"\t"+StringUtil.resolve(ae.getAnnotation(key, Object.class))+"\n");
		return sb.toString();
	}

	public String annotations(Resource resource) {
		StringBuffer sb = new StringBuffer();
		sb.append("annotations for ");
		sb.append(StringUtil.resolve(resource));
		sb.append("\n");

		TreeIterator<EObject> iterator = resource.getAllContents();
		while (iterator.hasNext()) {
			EObject obj = iterator.next();
			sb.append(StringUtil.resolve(obj));
			sb.append("\n");
			AnnotateableElement ae = EMFAdapter.INSTANCE.adapt(obj, AnnotateableElement.class);
			for (String s : ae.getAnnotations())
				sb.append("\t"+s+"\t"+StringUtil.resolve(ae.getAnnotation(s, Object.class))+"\n");
		}
		return sb.toString();
	}

	public String annotation(Resource resource, String key) {
		StringBuffer sb = new StringBuffer();
		sb.append("annotations for ");
		sb.append(StringUtil.resolve(resource));
		sb.append("\n");

		TreeIterator<EObject> iterator = resource.getAllContents();
		while (iterator.hasNext()) {
			EObject obj = iterator.next();
			sb.append(StringUtil.resolve(obj));
			sb.append("\n");
			AnnotateableElement ae = EMFAdapter.INSTANCE.adapt(obj, AnnotateableElement.class);
			sb.append("\t"+key+"\t"+StringUtil.resolve(ae.getAnnotation(key, Object.class))+"\n");
		}
		return sb.toString();
	}

	@Override
	public String help() {
		StringBuffer result = new StringBuffer(HELP);
		
		for(String function : FUNCTIONS){
			result.append(function);
		}
		result.deleteCharAt(result.length()-1);
		return result.toString();
	}


}

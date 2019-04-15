package org.sidiff.matching.model.util;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.util.StringUtil;

public class CorrespondenceModelStringUtil {

	/**
	 * H�ngt ein Object, welches selbst von StringUtil resolved wird, an einen StringBuffer an.
	 * Dazu kann ein Titel gegeben werden, der die Bedeutung des Objekts erkl�rt.
	 * Ist das Object eine Collection, so wird jedes Object in der Collection resolved.
	 * 
	 * @param title Ein kurzer Titel der erkl�ren soll worum es sich handelt
	 * @param result Der verwendete StringBuffer
	 * @param object Das anzuh�ngende Objekt
	 * @param depth Die Tiefe der Einr�ckung
	 * 
	 * TODO Kein Titel-Parameter gegeben. Doku falsch!
	 */
	static void appendSomething(StringBuffer result, int depth, Object... objects){
			
		if(objects.length != 0){
			if(objects.length == 1){
				result.append(objects[0]);
			}
			else{
				for(Object obj : objects){	
					StringUtil.appendIndentation(result, computeDepth((EObject)obj), true);
					result.append(StringUtil.resolve(obj));
				}
			}
		}
	}

	static void appendSomething(StringBuffer result, int depth, Collection<?> coll){
		
		if(coll.size() != 0){
			for(Object obj : coll){	
				StringUtil.appendIndentation(result, computeDepth((EObject)obj), true);
				result.append(StringUtil.resolve(obj));
			}
		}
	}
	
	/**
	 * Berechnet die Einruecktiefe fuer einen String 
	 * @param eObj
	 * @return
	 */
	static int computeDepth(EObject eObj){
		int depth = 0;
		if(eObj != null){
			while(eObj.eContainer() != null){
				eObj = eObj.eContainer();
				depth = depth + 2;
			}
		}
		return depth;
	}

}

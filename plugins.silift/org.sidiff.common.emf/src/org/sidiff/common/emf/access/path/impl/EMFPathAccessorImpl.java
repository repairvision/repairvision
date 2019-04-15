package org.sidiff.common.emf.access.path.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.access.path.*;
import org.sidiff.common.emf.access.path.axis.EMFAxis;
import org.sidiff.common.emf.access.path.conditions.EMFCondition;
import org.sidiff.common.exceptions.SiDiffRuntimeException;
import org.sidiff.common.util.NestedParameterUtil;
import org.sidiff.common.util.ReflectionUtil;

/**
 * Implementation of a EMF-Navigation-Path Engine.
 * 
 * Syntax:
 * {AxisName}.{AxisParameter}#{NodeType}[{Condition}]/
 * 
 * AxisParameter and Condition statements are optional.
 * Nodetype can be '*' but is not allowed in any junktion.
 * 
 * Examples:
 * 
 *  "Incomming.myref#myobjects[justthebest]/Parent#*"
 *  "Incomming.myref#myobjects[justthebest]/Parent#*"
 *  
 *  @see org.sidiff.common.emf.access.path.axis
 *  @see org.sidiff.common.emf.access.path.conditions
 *  
 * @author Maik Schmidt
 *
 */
public class EMFPathAccessorImpl implements EMFPathAccessor {
	
	private static final String TYPE_WILDCAT = "*";

	private static final String NS_TYPENAME_SEPERATOR = ":";
	private static final String AXIX_ARGUMENT_SEPERATOR = "\\.";
	private static final String PATH_STEP_SEPERATOR = "/";
	private static final String STEP_AXIS_SEPERATOR = "#";
	private static final String CONDITION_START_CHARACTER = "[";
	private static final String CONDITION_END_CHARACTER = "]";
	
	private static final String AXIS_PREFIX = "org.sidiff.common.emf.access.path.axis.";
	private static final String CONDITION_PREFIX = "org.sidiff.common.emf.access.path.conditions.";
	
	private static final Map<String,EPackage> namespaces = new HashMap<String, EPackage>();

	private static final Map<Class<?>,PathEvaluationStrategy<?>> strategies = new HashMap<Class<?>,PathEvaluationStrategy<?>>();

	
	public EMFPathAccessorImpl() {
		// Apply known strategies (old stategies can be found in revision 2511 in the repository)
		strategies.put(TargetEvaluationStrategy.class, new TargetEvaluationStrategyImpl());
		strategies.put(CollectorAccessStrategy.class, new CollectorAccessStrategyImpl());
		strategies.put(SliceAccessStrategy.class, new SliceAccessStrategyImpl());
		strategies.put(PathsAccessStrategy.class, new PathsAccessStrategyImpl());
	}
	
	//***************************************************************************************************************

	@SuppressWarnings("unchecked")
	@Override
	public <T> T evaluatePath(EObject context, EMFPath path, Class<? extends PathEvaluationStrategy<T>> strategy) {
		assert(strategies.containsKey(strategy)) : "Unsupported Strategy: "+strategy.getName();
		return ((StrategyImpl<T>)strategies.get(strategy)).evaluate(context, path);
	}

	@Override
	public EMFPath translatePath(EClass eClass, String pathString) {
		
		EMFPathImpl result = new EMFPathImpl();
		
		for(String stepString : pathString.split(PATH_STEP_SEPERATOR)){
			result.addStep(createStep(stepString,eClass));
		}	
		return result.initPath(eClass);
	}
	
	@Override
	public EClass inferResultType(EMFPath path) {
		assert(path instanceof EMFPathImpl) : "Illegal argument:"+path;
		
		return ((EMFPathImpl)path).getTargetType();
	}

	//***************************************************************************************************************

	/**
	 * Interne Mehode zur erzeugung eines Navigationsschrittes
	 * 	 
	 * Beispiel: ref->outgoing#myns:TestNode[NoCycle]
	 * 
	 * @return Instanz eines EMFPathStep
	 */
	private EMFPathStepImpl createStep(String stepString,EClass context) {
		assert(stepString!=null);

		//*************************************************	
		String axisString = null;
		String nodeTypeString = null;
		String conditionString = null;
		
		String stepStringTokens[] = stepString.split(STEP_AXIS_SEPERATOR);
		if (stepStringTokens.length == 2) {
			axisString = stepStringTokens[0];
			if(stepStringTokens[1].indexOf(CONDITION_START_CHARACTER)==-1){
				// No Condition given
				nodeTypeString = stepStringTokens[1];
			} else {
				// Condition given
				nodeTypeString = stepStringTokens[1].substring(0, stepStringTokens[1].indexOf(CONDITION_START_CHARACTER));
				assert(stepStringTokens[1].lastIndexOf(CONDITION_END_CHARACTER)==stepStringTokens[1].length()-1) : "Condition Syntax Error:"+stepStringTokens[1];
				conditionString = stepStringTokens[1].substring(stepStringTokens[1].indexOf(CONDITION_START_CHARACTER) + 1,stepStringTokens[1].length()-1);
			}
		} else {
			// Workaround for old style paths
//			String mapped = "Outgoing."+stepString+"#*";
//			LogUtil.log(LogEvent.WARNING,
//					"You may use old style path! Try to map path into new experssion:\n",
//					stepString+"-->"+mapped);
//			return createStep(mapped, context);
			throw new SiDiffRuntimeException("Syntax Error:" + stepString);
		}
		//*************************************************
		
		EMFAxis axis = createAxis(axisString);
		
		EClass nodeTest= null;
		if(!nodeTypeString.equals(TYPE_WILDCAT)){
			nodeTest=getClassByString(context, nodeTypeString);
		}
		
		EMFCondition condition = null;
		if(conditionString!=null){
			condition = createCondition(conditionString);
		}
		
		return new EMFPathStepImpl(axis, nodeTest, condition);
	}
	
	

	/**
	 * Interne Mehode zur erzeugung einer 'Axis'
	 * 
	 * @param axisString Axis String in der Form '{axis name}.{axis parameter}
	 * 
	 * @return axis instance as defined in argument.
	 */
	private EMFAxis createAxis(String axisString){
		assert(axisString!=null);
		
		EMFAxis axis = null;
		
		String axisStringTokens[] = axisString.split(AXIX_ARGUMENT_SEPERATOR);
		if(axisStringTokens.length>0 && axisStringTokens.length<3){
			try{
				axis = ReflectionUtil.createInstance(AXIS_PREFIX+axisStringTokens[0],EMFAxis.class,
						(axisStringTokens.length==2)? axisStringTokens[1] : null);
			} catch (IllegalArgumentException e){
				throw new SiDiffRuntimeException("Illegal Argument:",axisString);
			}
		} else {
			throw new SiDiffRuntimeException("Illegal Argument:",axisString);
		}
		
		return axis;
	}
	
	private EMFCondition createCondition(String conditionString){
		assert(conditionString!=null);
		
		EMFCondition condition = null;
		
		if(NestedParameterUtil.getParameterSegments(conditionString).length==1){
			condition = ReflectionUtil.createInstance(CONDITION_PREFIX+NestedParameterUtil.getTopLevelParameterString(conditionString),EMFCondition.class,
					(NestedParameterUtil.hasNestedParameter(conditionString))? NestedParameterUtil.splitCompositeParamter(conditionString)[1] : null);
		} else {
			throw new SiDiffRuntimeException("Illegal Argument:",conditionString);
		}
		
		return condition;
	}
	
	private static EClass getClassByString(EClass contextClass,String typeString){
		
		assert(typeString!=null&&!typeString.isEmpty()): "Typestring needed!";
		assert(contextClass!=null) : "Context must be given!";
		
		EClass result = null;
		// *********************************************************************
		String[] tokenizedTypeString = typeString.split(NS_TYPENAME_SEPERATOR);
		if(tokenizedTypeString.length==1){
			// Means no ns-identifier was used, so lookup
			try{
				result = lookupClass(contextClass.getEPackage(), tokenizedTypeString[0]);
			} catch (EClassLookupException e1) {
				try{
					result = lookupClass(contextClass.eResource(), tokenizedTypeString[0]);
				} catch(EClassLookupException e2) {
					throw new SiDiffRuntimeException("Cannot get Type "+typeString,e1,e2);
				}
			}
		} else if(tokenizedTypeString.length==2){
			// Means identifier was used
			try{
				result = lookupClass(tokenizedTypeString[0], tokenizedTypeString[1]);
			} catch(EClassLookupException e) {
				throw new SiDiffRuntimeException("Cannot get Type ("+typeString+") using ns-identifier",e);
			}
		} else {
			
		}
		
		return result;
	}
	
	private static EClass lookupClass(EPackage ePackage, String className) throws EClassLookupException{
		
		EClassifier classifier = ePackage.getEClassifier(className);
		if(classifier==null||!(classifier instanceof EClass)){
			throw new EClassLookupException(ePackage.getName()+" does not contain class "+className);
		}
		return (EClass)classifier;
		
	}
	
	private static EClass lookupClass(Resource resource, String className) throws EClassLookupException{
		
		EClass result = null;
		TreeIterator<EObject> iterator = resource.getAllContents();
		while(iterator.hasNext()){
			EObject item = iterator.next();
			if(item instanceof EClass){
				EClass eClass = (EClass)item;
				if(eClass.getName().equals(className)){
					if(result==null){
					result=eClass;
					} else {
						throw new EClassLookupException("Ambiguous class "+result.getName()+" cannot be resolved");
					}
				}
				
			}
		}	
		return result;	
	}
	
	private static EClass lookupClass(String nsname, String className) throws EClassLookupException{
		
		EClass result = null;
		if(namespaces.containsKey(nsname)){
			EPackage ePackage = namespaces.get(nsname);
			EClassifier classifier = ePackage.getEClassifier(nsname);
			if(classifier!=null&&classifier instanceof EClass){
				result = (EClass)classifier;
			} else {
				throw new EClassLookupException("EClass '"+className+"' does not exist in EPackage '"+ePackage.getName()+"'");
			}
		} else {
			throw new EClassLookupException("undefined namespace identifier '"+nsname+"'");
		}
		return result;
	}
	

	public static void registerNSName(String nsname,EPackage ePackage){
		
	}
	
	private static class EClassLookupException extends Exception {

		public EClassLookupException(String string) {
			super(string);
		}
		private static final long serialVersionUID = 1L;
	}
	
	
	/**
	 * Engine specific implementation of a certain strategy.
	 * 
	 * @author Maik Schmidt
	 *
	 * @param <T> Return type of the strategy.
	 */
	static interface StrategyImpl<T> {	
		public T evaluate(EObject start, EMFPath path);
	}
}

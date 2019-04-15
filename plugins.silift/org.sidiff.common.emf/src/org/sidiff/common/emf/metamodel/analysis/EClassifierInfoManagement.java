package org.sidiff.common.emf.metamodel.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.common.emf.access.EMFMetaAccess;
import org.sidiff.common.emf.exceptions.NoRootElementFoundException;

/**
 * This class is responsible for the meta-model analysis. It offers methods to
 * gather and maintain additional collected information for EClassifiers of a meta-model
 * which are not easily accessible via the regular EMF API (e.g. mandatory children, sub types, stereotypes).
 * This class uses singleton pattern.
 * 
 * @author mrindt
 *
 */
public class EClassifierInfoManagement {

	/**
	 * The global storage of EClassifierInfos which are mapped onto the respective EClassifiers
	 */
	private HashMap<EClassifier,EClassifierInfo> eClassifierInfoMap = new HashMap<EClassifier, EClassifierInfo>();
	
	/**
	 * The global storage of concrete EClassifiers which are mapped onto their abstract EClassifiers
	 */
	private HashMap<EClassifier,Set<EClassifier>> abstractToConcreteEClassifierMap = new HashMap<EClassifier, Set<EClassifier>>();
	
	/**
	 * The global storage of sub type EClassifiers which are mapped onto their super type EClassifiers
	 */
	private HashMap<EClassifier,List<EClassifier>> subTypeMap =  new HashMap<EClassifier, List<EClassifier>>();
	
	
	/**
	 * The global set of stereotype EClassifiers
	 */
	private Set<EClassifier> profileStereotypesSet = new HashSet<EClassifier>();
	
	/**
	 * The global set of meta class ("stereotyped") EClassifiers
	 */
	private Set<EClassifier> profileMetaclassSet = new HashSet<EClassifier>();
	
	/**
	 * The global EClassifierInfoManagement Instance
	 */
	private static EClassifierInfoManagement instance = null;
	
	/**
	 * Flag to enable/disable stereotype mapping
	 */
	private Boolean stereotypeMapping = false;
	
	/**
	 * Singleton.
	 * 
	 * @return 
	 * 		EClassifierInfoManagement
	 */
	public static EClassifierInfoManagement getInstance() {
		if (instance==null) {
			instance = new EClassifierInfoManagement();
		}
		return instance;
	}
	
	/**
	 * Main method to gather all relevant information from the metamodel.
	 * 
	 * @param enableStereotypeMapping
	 * @param ePackagesStack
	 */
	public void gatherInformation(Boolean enableStereotypeMapping, Stack<EPackage> ePackagesStack, Boolean enableInnerContainmentCycleDetection) {
		
		//convert stack to array
		EPackage[] ePackageArray = new EPackage[ePackagesStack.size()];
		ePackagesStack.toArray(ePackageArray);
		
		// find subtype hierarchy & map abstract/concrete classifiers & gather all infos
		gatherSubtypeHierarchy(ePackageArray);
		mapConcreteEClassifiersToAbstractSuperTypes(ePackagesStack);
		gatherAllEClassifierInfos(ePackagesStack);
		
		// find and store Containment Cycles
		ContainmentCycleDetector ccDetector = new ContainmentCycleDetector(enableInnerContainmentCycleDetection);
		ccDetector.detectContainmentCycles(ePackagesStack);
	}
		
	/**
	 * Maps each sub type of each classifier to each super type.
	 * 
	 * @param ePackages
	 */
	private void gatherSubtypeHierarchy(EPackage[] ePackages) {

		//for each classifier in each package
		for(EPackage ePackage: ePackages) {
			for(EClassifier eClassifier: ePackage.getEClassifiers()) {
				if(eClassifier instanceof EClass) {
					EClass eClass = (EClass) eClassifier;
					List<EClassifier> subtypes = new ArrayList<EClassifier>();
					// find all sub classes in all ePackages
					subtypes.addAll(EMFMetaAccess.getAllSubclasses(eClass, ePackages));
					// and map supertype with subtypes
					subTypeMap.put(eClassifier,subtypes);			
				}
			}
		}
		
		
	}

	/**
	 * Maps each concrete specialization to each general abstract EClassifier.
	 * 
	 * @param ePackagesStack
	 */
	public void mapConcreteEClassifiersToAbstractSuperTypes(Stack<EPackage> ePackagesStack) {
		for (EPackage ePackage : ePackagesStack) {
			for (EClassifier eClassifier : ePackage.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass) eClassifier;
					if (eClass.isAbstract()) {				
						Set<EClassifier> concreteEClasses = new HashSet<EClassifier>();
						abstractToConcreteEClassifierMap.put(eClassifier, concreteEClasses);
					}
				}
			}
		}


		// check if it has an abstract ESuperType
		// and add it to abstractToConcreteEClassifierMap	
		for (EPackage ePackage : ePackagesStack) {
			for (EClassifier eClassifier : ePackage.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass) eClassifier;			
					if (!eClass.isAbstract()) {
						for(EClassifier abstractEClassifier: abstractToConcreteEClassifierMap.keySet()) {
							if(abstractEClassifier instanceof EClass) {
								EClass abstractEClass = (EClass) abstractEClassifier;
								if(abstractEClass.isSuperTypeOf(eClass)) {
									abstractToConcreteEClassifierMap.get(abstractEClassifier).add(eClassifier);
								}
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * This collects all EClassifierInfos for each EClasifier in the meta-model.
	 * 
	 * @param ePackagesStack
	 */
	public void gatherAllEClassifierInfos(Stack<EPackage> ePackagesStack) {
				
		for (EPackage ePackage : ePackagesStack) {
			for (EClassifier eClassifier : ePackage.getEClassifiers()) {	

					// get or create EClassifierInfo
					EClassifierInfo eClassifierInfo = getEClassifierInfo(eClassifier);
					
					// if using some profiled meta model: map stereotype / meta classes
					if (stereotypeMapping) findAndMapStereotypes(eClassifierInfo);

					if(eClassifier instanceof EClass) {
						
						EClass eClass = (EClass) eClassifier;

						for (EReference eRef : eClass.getEAllReferences()) {

							if(!eRef.isDerived()) {

								// get mandatory and optional children
								Set<EClassifier> mC = findMandatoryChild(eRef);
								Set<EClassifier> oC = findOptionalChild(eRef);

								// get neighbour
								Set<EClassifier> mN = findMandatoryNeighbour(eRef);
								Set<EClassifier> oN = findOptionalNeighbour(eRef);

								// get parent context
								Set<EClassifier> mPC = findMandatoryParentContext(eRef);
								Set<EClassifier> oPC = findOptionalParentContext(eRef);

								// get neighbour context
								Set<EClassifier> mNC = findMandatoryNeighbourContext(eRef);
								Set<EClassifier> oNC = findOptionalNeighbourContext(eRef);

								// add subtypes to all previous lists
								mC	= addSubtypes(mC);
								oC	= addSubtypes(oC);
								oN	= addSubtypes(oN);
								oN	= addSubtypes(oN);
								mPC = addSubtypes(mPC);
								oPC = addSubtypes(oPC);
								mNC = addSubtypes(mNC);
								oNC = addSubtypes(oNC);
								
								// fill mandatory children and mandatory parent context of children
								if(mC!=null) {
									// add mandatory child
									for(EClassifier child: mC) {
										// add each child as MC to current parent
										add_MC_to_parent(eClassifier, child, eRef);
										// add current parent as MPC to each child
										add_MPC_to_Child(child, eClassifier, eRef);
										for(EClassifier subtypeOfParent: subTypeMap.get(eClassifier)) {
											// add each parent to each child as MPC
											add_MPC_to_Child(child, subtypeOfParent, eRef);
											// add each child to each parent as MC
											add_MC_to_parent(subtypeOfParent, child, eRef);
										}
									}								
								}
								// fill optional children and mandatory parent context of children
								if(oC!=null) {
									for(EClassifier child: oC) {
										// add each child as OC to current parent
										add_OC_to_parent(eClassifier, child, eRef);
										// add current parent as OPC to each child
										add_OPC_to_Child(child, eClassifier, eRef);
										for(EClassifier subtypeOfParent: subTypeMap.get(eClassifier)) {
											// add each parent to each child as OPC
											add_OPC_to_Child(child, subtypeOfParent, eRef);
											// add each child to each parent as OC
											add_OC_to_parent(subtypeOfParent, child, eRef);
										}
									}									
								}
								// fill mandatory neighbour and mandatory neighbour context of neigbours
								if(mN!=null) {
									for(EClassifier neighbour: mN) {
										// add each neighbour as mN to current eClassifier (neighbour context)
										add_MN_to_Neighbour(eClassifier, neighbour, eRef);
										// add current eClassifier (neighbour context) as MNC to each neighbour
										add_MNC_to_Neighbour(neighbour, eClassifier, eRef);
										for(EClassifier subtypeOfEClassifierNeighbour: subTypeMap.get(eClassifier)) {
											// add each subtype of eClassifier (neighbour context) to each neighbour as MNC
											add_MNC_to_Neighbour(neighbour, subtypeOfEClassifierNeighbour, eRef);
											// add each neighbour to each subtype of eClassifier (neighbour context) as MN
											add_MN_to_Neighbour(subtypeOfEClassifierNeighbour, neighbour, eRef);
										}
									}
								}
								// fill optional neighbour and optional neighbour context of neigbours
								if(oN!=null) {
									for(EClassifier neighbour: oN) {
										// add each neighbour as ON to current eClassifier (neighbour context)
										add_ON_to_Neighbour(eClassifier, neighbour, eRef);
										// add current eClassifier (neighbour context) as ONC to each neighbour
										add_ONC_to_Neighbour(neighbour, eClassifier, eRef);
										for(EClassifier subtypeOfEClassifierNeighbour: subTypeMap.get(eClassifier)) {
											// add each subtype of eClassifier (neighbour context) to each neighbour as ONC
											add_ONC_to_Neighbour(neighbour, subtypeOfEClassifierNeighbour, eRef);
											// add each neighbour to each subtype of eClassifier (neighbour context) as ON
											add_ON_to_Neighbour(subtypeOfEClassifierNeighbour, neighbour, eRef);
										}
									}
									
								}
								// fill mandatory parent context of current eClassifier
								if(mPC!=null) {
									for(EClassifier p: mPC) {
										add_MPC_to_Child(eClassifier, p, eRef.getEOpposite());
									}
								}
								// fill optional parent context of current eClassifier
								if(oPC!=null) {
									for(EClassifier p: oPC) {	
										add_OPC_to_Child(eClassifier, p, eRef.getEOpposite());
									}
								}
								// fill mandatory neighbour context of current eClassifier
								if(mNC!=null) {
									for(EClassifier n: mNC) {	
										add_MNC_to_Neighbour(eClassifier, n, eRef.getEOpposite());								
									}
								}
								// fill optional neighbour context of current eClassifier
								if(oNC!=null) {
									for(EClassifier n: oNC) {
										add_ONC_to_Neighbour(eClassifier, n, eRef.getEOpposite());
									}
								}
							}
						}
					}
					eClassifierInfoMap.put(eClassifier,eClassifierInfo);
			}
		}
	}

	/**
	 * This method adds a set of several sub types of types contained in an existing sub type set
	 * in to exactly that existing sub type set.
	 * 
	 * @param existingSet
	 * 
	 * @return
	 * 		set of subtypes
	 */
	private Set<EClassifier> addSubtypes(Set<EClassifier> existingSet) {
		if(existingSet==null) return null;
		Set<EClassifier> newSet = new HashSet<EClassifier>();
		
		for(EClassifier exCl: existingSet) {
			List<EClassifier> subtypes = subTypeMap.get(exCl);
			if(subtypes!=null) {
				newSet.addAll(subtypes);
			}
		}
		existingSet.addAll(newSet);
		return existingSet;
	}

	/**
	 * Acess method to get an EClassifierInfo for an EClassifier.
	 * 
	 * @param eClassifier
	 * 
	 * @return
	 * 		EClassifierInfo
	 */
	public EClassifierInfo getEClassifierInfo(EClassifier eClassifier) {
		if(eClassifierInfoMap.get(eClassifier)==null) {
			eClassifierInfoMap.put(eClassifier, new EClassifierInfo(eClassifier));
		}
		return eClassifierInfoMap.get(eClassifier);
	}
	
	/**
	 * Returns all concrete specializations for an abstract EClassifer.
	 * 
	 * @param eClassifier
	 * 
	 * @return
	 * 		ArrayList of EClassifiers
	 */
	public ArrayList<EClassifier> getAllConcreteEClassifiersForAbstract(EClassifier eClassifier) {
		ArrayList<EClassifier> concreteEClasses = new ArrayList<EClassifier>();
		for(EClassifier abstractEClassifier: abstractToConcreteEClassifierMap.keySet()) {
			if(abstractEClassifier.equals(eClassifier)) {
				for(EClassifier replacement :abstractToConcreteEClassifierMap.get(abstractEClassifier)) {
					if(replacement instanceof EClass) {
						EClass replacementEClass = (EClass) replacement;
						if(replacementEClass.isAbstract()) {
							concreteEClasses = getAllConcreteEClassifiersForAbstract(replacement);
						}else{
							concreteEClasses.add(replacement);
						}					
					}
				}				
			}
		}
		return concreteEClasses;
	}
	
	/**
	 * Returns direct optional parent contexts and also parent contexts resulting from sub types of found parent contexts.
	 * It does not returns recursive parent contexts (e.g. parents of parents). One needs to provide information about
	 * whether or not super types should be used instead of each and every sub type of it. If true, then the sub types
	 * of an optional super type parent context will be discarded.
	 * 
	 * @param eClassifier
	 * 
	 * @param preferSuperTypes
	 * 
	 * @return
	 * 		A list of EClassifiers per EReference
	 */
	public HashMap<EReference,List<EClassifier>> getAllOptionalParentContext(EClassifier eClassifier, Boolean preferSuperTypes) {
		
		HashMap<EReference,List<EClassifier>> map = new HashMap<EReference,List<EClassifier>>();
		
		// add direct optional parent contexts
		map.putAll(getEClassifierInfo(eClassifier).getOptionalParentContext());

		// add indirect optional parent contexts (= superType's parents)
		if(eClassifier instanceof EClass) {
			EClass eClass = (EClass) eClassifier;
			for(EClassifier superType: eClass.getEAllSuperTypes()) {
				EClassifierInfo infoOfSuperType = getEClassifierInfo(superType);
				
				if(infoOfSuperType!=null) {
					map.putAll(infoOfSuperType.getOptionalParentContext());
				}			
			}
		}
		
		// preferSuperTypes==true:
		// 	drop sub types and use super type (which contains the EReference) instead.
		if(preferSuperTypes) {
			for(Entry<EReference,List<EClassifier>> entry: map.entrySet()) {
				EReference eRef = entry.getKey();
				entry.getValue().clear();
				entry.getValue().add(eRef.getEContainingClass());	
			}
		}
		
		return map;
	}
	
	/**
	 * Returns direct mandatory parent contexts and also parent contexts resulting from sub types of found parent contexts.
	 * It does not returns recursive parent contexts (e.g. parents of parents). One needs to provide information about
	 * whether or not super types should be used instead of each and every sub type of it. If true, then the sub types
	 * of a mandatory super type parent context will be discarded.
	 * 
	 * @param eClassifier
	 * 
	 * @param preferSuperTypes
	 * 
	 * @return
	 * 		A List of EClassifiers per EReference
	 */
	public HashMap<EReference,List<EClassifier>> getAllMandatoryParentContext(EClassifier eClassifier, Boolean preferSuperTypes) {
		
		HashMap<EReference,List<EClassifier>> map = new HashMap<EReference,List<EClassifier>>();
		
		// add direct mandatory parent contexts
		map.putAll(getEClassifierInfo(eClassifier).getMandatoryParentContext());

		// add indirect mandatory parent contexts (= superType's parents)
		if(eClassifier instanceof EClass) {
			EClass eClass = (EClass) eClassifier;
			for(EClassifier superType: eClass.getEAllSuperTypes()) {
				EClassifierInfo infoOfSuperType = getEClassifierInfo(superType);
				
				if(infoOfSuperType!=null) {
					map.putAll(infoOfSuperType.getMandatoryParentContext());
				}			
			}
		}
		
		// preferSuperTypes==true:
		// 	drop sub types and use super type (which contains the EReference) instead.
		if(preferSuperTypes) {
			for(Entry<EReference,List<EClassifier>> entry: map.entrySet()) {
				EReference eRef = entry.getKey();
				entry.getValue().clear();
				entry.getValue().add(eRef.getEContainingClass());	
			}
		}
		
		return map;
	}	
	
	/**
	 * This method checks if a given context EClassifier occurs somewhere else inside the given
	 * HashMap as listed EClassifier.
	 * 
	 * @param context
	 * 
	 * @param map
	 * 
	 * @return
	 * 		 true | false
	 */
	public boolean hasMultipleOccurences(EClassifier context, HashMap<EReference,List<EClassifier>> map) {
		int count = 0;
		for(Entry<EReference,List<EClassifier>>  entry: map.entrySet()) {
			List<EClassifier> contexts = entry.getValue();
			for(EClassifier currentContext: contexts) {
				if(currentContext.equals(context)) {
					count++;
				}
			}
		}
		if(count>1) {
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 *  Returns direct optional neighbor contexts and also neighbor contexts resulting from sub types of found neighbor contexts.
	 * It does not return recursive neighbor contexts (e.g. neighbor contexts of neighbor contexts).
	 * 
	 * @param eClassifier
	 * 
	 * @return
	 * 		A List of EClassifiers per EReference
	 */
	public HashMap<EReference,List<EClassifier>> getAllOptionalNeighbourContext(EClassifier eClassifier) {
		
		HashMap<EReference,List<EClassifier>> map = new HashMap<EReference,List<EClassifier>>();
		// add direct optional neighbour contexts
		map.putAll(getEClassifierInfo(eClassifier).getOptionalNeighbourContext());
		
		// add indirect optional neighbour contexts
		if(eClassifier instanceof EClass) {
			EClass eClass = (EClass) eClassifier;
			for(EClassifier superType: eClass.getESuperTypes()) {
				EClassifierInfo infoOfSuperType = getEClassifierInfo(superType);
				
				if(infoOfSuperType!=null) {
					map.putAll(infoOfSuperType.getOptionalNeighbourContext());
				}
				
			}
		}
				
		return map;
	}
	
	/**
	 *  Returns direct mandatory neighbor contexts and also neighbor contexts resulting from sub types of found neighbor contexts.
	 * It does not return recursive neighbor contexts (e.g. neighbor contexts of neighbor contexts).
	 * 
	 * @param eClassifier
	 * 
	 * @return
	 * 		A List of EClassifiers per EReference
	 */
	public HashMap<EReference,List<EClassifier>> getAllMandatoryNeighbourContext(EClassifier eClassifier) {
		
		HashMap<EReference,List<EClassifier>> map = new HashMap<EReference,List<EClassifier>>();
		// add direct mandatory neighbour contexts
		map.putAll(getEClassifierInfo(eClassifier).getMandatoryNeighbourContext());
		
		// add indirect mandatory neighbour contexts
		if(eClassifier instanceof EClass) {
			EClass eClass = (EClass) eClassifier;
			for(EClassifier superType: eClass.getESuperTypes()) {
				EClassifierInfo infoOfSuperType = getEClassifierInfo(superType);
				
				if(infoOfSuperType!=null) {
					map.putAll(infoOfSuperType.getMandatoryNeighbourContext());
				}
				
			}
		}
				
		return map;
	}
	
	
	/**
	 * This method returns all optional and mandatory neighbor contexts inclusively their sub types.
	 *  It does not return recursive neighbor contexts (e.g. neighbor context of neighbor context).
	 *  This is a convenience method which wraps getAllMandatoryNeighbourContext() and getAllOptionalNeighbourContext().
	 *  
	 * @param eClassifier
	 * 
	 * @return
	 * 		A List of EClassifiers per EReference
	 */
	public HashMap<EReference,List<EClassifier>> getAllNeighbourContexts(EClassifier eClassifier) {
		
		HashMap<EReference,List<EClassifier>> map = new HashMap<EReference,List<EClassifier>>();
		
		map.putAll(getAllOptionalNeighbourContext(eClassifier));
		map.putAll(getAllMandatoryNeighbourContext(eClassifier));
		
		return map;
		
	}
	
	/**
	 * This method returns all direct mandatory and optional parent contexts.
	 * It does not return recursive parent contexts (e.g. parents of parents). One needs to provide information about
	 * whether or not super types should be used instead of each and every sub type of it. If true, then the sub types
	 * of a mandatory/optional super type parent context will be discarded.
	 * This is a convenience method which wraps getAllMandatoryParentContext() and getAllOptionalParentContext().
	 * 
	 * @param eClass
	 * 
	 * @param preferSuperTypes
	 * 
	 * @return
	 * 		A List of EClassifiers per EReference
	 */
	public HashMap<EReference,List<EClassifier>> getAllParentContexts(EClassifier eClassifier, Boolean preferSuperTypes ) {
		
		HashMap<EReference,List<EClassifier>> map = new HashMap<EReference,List<EClassifier>>();
		
		map.putAll(getAllOptionalParentContext(eClassifier, preferSuperTypes));
		map.putAll(getAllMandatoryParentContext(eClassifier, preferSuperTypes));
		
		return map;
		
	}
	
	/**
	 * This method returns direct mandatory and optional children and includes their sub types.
	 * It does not recursively return children of children.
	 * 
	 * @param eClassifier
	 * 
	 * @return
	 * 		A List of EClassifiers per EReference
	 */
	public HashMap<EReference,List<EClassifier>> getAllChildren(EClassifier eClassifier) {
		
		HashMap<EReference,List<EClassifier>> map = new HashMap<EReference,List<EClassifier>>();
		EClassifierInfo eClassInfo = getEClassifierInfo(eClassifier);
		// add direct children
		map.putAll(eClassInfo.getOptionalChildren());
		map.putAll(eClassInfo.getMandatoryChildren());
		
		// add indirect children
		if(eClassifier instanceof EClass) {
			EClass eClass = (EClass) eClassifier;
			for(EClass superType: eClass.getESuperTypes()) {
				EClassifierInfo infoOfSuperType = getEClassifierInfo(superType);

				if(infoOfSuperType!=null) {
					map.putAll(infoOfSuperType.getOptionalChildren());
					map.putAll(infoOfSuperType.getMandatoryChildren());
				}			
			}
		}
				
		return map;
		
	}
		
	/**
	 * This method returns direct mandatory children and includes their sub types.
	 * It does not recursively return children of children.
	 * 
	 * @param eClassifier
	 * 
	 * @return
	 * 		A List of EClassifiers per EReference
	 */
	public HashMap<EReference,List<EClassifier>> getAllMandatoryChildren(EClassifier eClassifier) {
		
		HashMap<EReference,List<EClassifier>> map = new HashMap<EReference,List<EClassifier>>();
		EClassifierInfo eClassInfo = getEClassifierInfo(eClassifier);
		// add direct children
		map.putAll(eClassInfo.getMandatoryChildren());
		
		// add indirect children
		if(eClassifier instanceof EClass) {
			EClass eClass = (EClass) eClassifier;
			for(EClass superType: eClass.getESuperTypes()) {
				EClassifierInfo infoOfSuperType = getEClassifierInfo(superType);

				if(infoOfSuperType!=null) {
					map.putAll(infoOfSuperType.getMandatoryChildren());
				}			
			}
		}
				
		return map;
		
	}
	
	
	/**
	 * This method returns direct optional children and includes their sub types.
	 * It does not recursively return children of children.
	 * 
	 * @param eClassifier
	 * 
	 * @return
	 * 		A List of EClassifiers per EReference
	 */
	public HashMap<EReference,List<EClassifier>> getAllOptionalChildren(EClassifier eClassifier) {
		
		HashMap<EReference,List<EClassifier>> map = new HashMap<EReference,List<EClassifier>>();
		EClassifierInfo eClassInfo = getEClassifierInfo(eClassifier);
		// add direct children
		map.putAll(eClassInfo.getOptionalChildren());
		
		// add indirect children
		if(eClassifier instanceof EClass) {
			EClass eClass = (EClass) eClassifier;
			for(EClass superType: eClass.getESuperTypes()) {
				EClassifierInfo infoOfSuperType = getEClassifierInfo(superType);

				if(infoOfSuperType!=null) {
					map.putAll(infoOfSuperType.getOptionalChildren());
				}			
			}
		}
				
		return map;
		
	}
	
	/**
	 * This method returns direct mandatory and optional neighbours and includes their sub types.
	 * It does not recursively return neighbours of neighbours.
	 * 
	 * @param eClassifier
	 * 
	 * @return
	 * 		A List of EClassifiers per EReference
	 */
	public HashMap<EReference,List<EClassifier>> getAllNeighbours(EClassifier eClassifier) {
		
		HashMap<EReference,List<EClassifier>> map = new HashMap<EReference,List<EClassifier>>();
		EClassifierInfo eClassInfo = getEClassifierInfo(eClassifier);
		
		// add direct neighbours
		map.putAll(eClassInfo.getOptionalNeighbours());
		map.putAll(eClassInfo.getMandatoryNeighbours());
		
		// add indirect neighbours
		if(eClassifier instanceof EClass) {
			EClass eClass = (EClass) eClassifier;
			for(EClassifier superType: eClass.getESuperTypes()) {
				EClassifierInfo infoOfSuperType = getEClassifierInfo(superType);

				if(infoOfSuperType!=null) {
					map.putAll(infoOfSuperType.getOptionalNeighbours());
					map.putAll(infoOfSuperType.getMandatoryNeighbours());
				}			
			}
		}	
		return map;
		
	}
	
	/**
	 * This method returns direct mandatory neighbours and includes their sub types.
	 * It does not recursively return neighbours of neighbours.
	 * 
	 * @param eClassifier
	 * 
	 * @return
	 * 		A List of EClassifiers per EReference
	 */
	public HashMap<EReference,List<EClassifier>> getAllMandatoryNeighbours(EClassifier eClassifier) {
		
		HashMap<EReference,List<EClassifier>> map = new HashMap<EReference,List<EClassifier>>();
		EClassifierInfo eClassInfo = getEClassifierInfo(eClassifier);
		
		// add direct neighbours
		map.putAll(eClassInfo.getMandatoryNeighbours());
		
		// add indirect neighbours
		if(eClassifier instanceof EClass) {
			EClass eClass = (EClass) eClassifier;
			for(EClassifier superType: eClass.getESuperTypes()) {
				EClassifierInfo infoOfSuperType = getEClassifierInfo(superType);

				if(infoOfSuperType!=null) {
					map.putAll(infoOfSuperType.getMandatoryNeighbours());
				}			
			}
		}	
		return map;
		
	}
	
	/**
	 * This method returns direct optional neighbours and includes their sub types.
	 * It does not recursively return neighbours of neighbours.
	 * 
	 * @param eClassifier
	 * 
	 * @return
	 * 		A List of EClassifiers per EReference
	 */
	public HashMap<EReference,List<EClassifier>> getAllOptionalNeighbours(EClassifier eClassifier) {
		
		HashMap<EReference,List<EClassifier>> map = new HashMap<EReference,List<EClassifier>>();
		EClassifierInfo eClassInfo = getEClassifierInfo(eClassifier);
		
		// add direct neighbours
		map.putAll(eClassInfo.getOptionalNeighbours());
		
		// add indirect neighbours
		if(eClassifier instanceof EClass) {
			EClass eClass = (EClass) eClassifier;
			for(EClassifier superType: eClass.getESuperTypes()) {
				EClassifierInfo infoOfSuperType = getEClassifierInfo(superType);

				if(infoOfSuperType!=null) {
					map.putAll(infoOfSuperType.getOptionalNeighbours());
				}			
			}
		}	
		return map;
		
	}
	
	/**
	 * This method returns all (recursive) sub types mapped inside an EClassifierInfo object
	 * to an EClassifier.
	 * 
	 * @param eInfo
	 * 
	 * @return
	 * 		A Set of EClassifierInfos
	 */
	public Set<EClassifierInfo> getAllSubTypes(EClassifierInfo eInfo) {
		Set<EClassifierInfo> set = new HashSet<EClassifierInfo>();
		
		for(EClassifier subType: subTypeMap.get(eInfo.getTheEClassifier())) {
			EClassifierInfo subEInfo = getEClassifierInfo(subType);
			set.add(subEInfo);
			set.addAll(getAllSubTypes(subEInfo));			
		}
		return set;
	}
	
	/**
	 * Returns the direct subtypes of an EClassifier
	 * 
	 * @param eClassifier
	 * 
	 * @return
	 * 		A Set of EClassifiers
	 */
	public Set<EClassifier> getSubTypes(EClassifier eClassifier){
		return new HashSet<EClassifier>(subTypeMap.get(eClassifier));
	}

	/**
	 * This method returns all (recursive) sub types mapped to an EClassifier.
	 * 
	 * @param eInfo
	 * 
	 * @return
	 * 		A Set of EClassifiers
	 */
	public Set<EClassifier> getAllSubTypes(EClassifier eClassifier) {
		Set<EClassifier> set = new HashSet<EClassifier>();
		
		for(EClassifier subType: subTypeMap.get(eClassifier)) {
			set.add(subType);
			set.addAll(getAllSubTypes(subType));			
		}
		return set;
	}
	
	/**
	 * This method delivers every possible sub type of an input eClassifier recursively.
	 * In case a sub type is abstract, this sub type will not be included in the result set
	 * but its sub types will be.
	 * 
	 * @param eClassifier
	 * 
	 * @return
	 * 		A Set of EClassifiers
	 */
	public Set<EClassifier> getAllConcreteSubTypes(EClassifier eClassifier) {
		Set<EClassifier> set = new HashSet<EClassifier>();
		
		for(EClassifier subType: subTypeMap.get(eClassifier)) {
			if(subType instanceof EClassifier && !((EClass)subType).isAbstract()) {
				set.add(subType);
			}
			set.addAll(getAllConcreteSubTypes(subType));			
		}
		return set;
	}
	
	/**
	 * This method delivers all stereotypes that are extending the given eClassifier as meta-class
	 * and also all stereotypes  that inherit from stereotypes which have this eClassifier as meta-class
	 * (directly or over further inheritances).
	 * 
	 * @param eClassifier
	 * 
	 * @return
	 * 		A Set of EClassifiers
	 */
	public Set<EClassifier> getAllStereotypes(EClassifier eClassifier) {
		
		Set<EClassifier> connectedStereotypes = new HashSet<EClassifier>();
		EClassifierInfo eInfo = getEClassifierInfo(eClassifier);
		
		// all directly connected stereotypes via 'extensions'
		connectedStereotypes.addAll(eInfo.getStereotypes());
		for(EClassifier stereotype: profileStereotypesSet) {
			// try to find all indirectly connected stereotypes via inheritances
			// of connected stereotypes
			List<EClass> stereoSupertypes = stereotype.eClass().getEAllSuperTypes();
			for(EClassifier supertype: stereoSupertypes) {
				if(connectedStereotypes.contains(supertype)) {
					connectedStereotypes.add(stereotype);
					break;
				}
			}
		}
		return connectedStereotypes;
	}
	
	/**
	 * Returns all stereotypes contained in a profile.
	 * 
	 * @return
	 * 	 		A Set of EClassifiers
	 */
	public Set<EClassifier> getAllProfileStereotypes() {	
		return profileStereotypesSet;
	}
	
	/**
	 * Returns all meta-classes of stereotypes contained in a profile.
	 * 
	 * @return
	 * 		A Set of EClassifiers
	 */
	public Set<EClassifier> getAllProfileMetaClasses() {
		return profileMetaclassSet;
	}
	
	/**
	 * Checks if an EClassifier in an EClassInfo has any subordinated abstract, mandatory children.
	 * 
	 * @param eClassInfo
	 * 
	 * @return
	 * 		true | false
	 */
	public boolean hasAbstractMandatoryChildren(EClassifierInfo eClassInfo) {
		for(EClassifier child: eClassInfo.getMandatoryChildren().values().iterator().next()) {
			if(abstractToConcreteEClassifierMap.containsKey(child)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks if an EClassifier in an EClassInfo has any subordinated abstract, mandatory neighbours.
	 * 
	 * @param eClassInfo
	 * 
	 * @return
	 * 		true | false
	 */
	public boolean hasAbstractMandatoryNeighbours(EClassifierInfo eClassInfo) {
		for(EClassifier neighbour: eClassInfo.getMandatoryNeighbours().values().iterator().next()) {
			if(abstractToConcreteEClassifierMap.containsKey(neighbour)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns the EClassifier according to a given name.
	 * 
	 * @param name
	 * 
	 * @return
	 * 		EClassifier
	 */
	public EClassifier getEClassifierByName(String name) {
		for(EClassifier eClassifier:eClassifierInfoMap.keySet()) {
			if(eClassifier.getName().equals(name)) {
				return eClassifier;
			}
		}
		return null;
	}
	
	/**** private methods *********************************************************************************/

	/**
	 * Creates a Set for <b>mandatory children</b> targeted by a containment EReference.
	 * Only the direct target, which is defined in the meta-model, will be added to the set.
	 * A mandatory child is an EClassifier that is targeted by a containment EReference with
	 * lowerBound > 0.
	 * 
	 * @param eRef
	 * 
	 * @return
	 *		Set of EClassifiers
	 */
	private static Set<EClassifier> findMandatoryChild(EReference eRef) {
		if (eRef.isContainment() && eRef.getLowerBound() > 0) {
			EClassifier mC = eRef.getEType();
			HashSet<EClassifier> hs = new HashSet<EClassifier>();
			hs.add(mC);
			return hs;
		}
		return null;
	}

	/**
	 * Creates a Set for <b>optional children</b> targeted by a containment EReference.
	 * Only the direct target, which is defined in the meta-model, will be added to the set.
	 * An optional child is an EClassifier that is targeted by a containment EReference with
	 * either (lowerUpperbound-lowerBound > 0) or (upperBound == *).
	 * 
	 * @param eRef
	 * 
	 * @return
	 *		Set of EClassifiers
	 */
	private static Set<EClassifier> findOptionalChild(EReference eRef) {
		if (eRef.isContainment() && (eRef.getUpperBound() - eRef.getLowerBound() > 0 || eRef.getUpperBound() == -1)) {
			HashSet<EClassifier> hs = new HashSet<EClassifier>();
			hs.add(eRef.getEType());
			return hs;
		}
		return null;
	}

	/**
	 * Creates a Set for <b>mandatory neighbours</b> targeted by a non-containment EReference.
	 * Only the direct target, which is defined in the meta-model, will be added to the set.
	 * A mandatory neighbour is an EClassifier that is targeted by a non-containment EReference with
	 * lowerBound > 0.
	 * 
	 * @param eRef
	 * 
	 * @return
	 *		Set of EClassifiers
	 */
	private Set<EClassifier> findMandatoryNeighbour(EReference eRef) {

		if (!eRef.isContainment() && eRef.getLowerBound() > 0) {
			HashSet<EClassifier> hs = new HashSet<EClassifier>();
			hs.add(eRef.getEType());
			return hs;
			
		}
		return null;
	}

	/**
	 * Creates a Set for <b>optional neighbours</b> targeted by a non-containment EReference.
	 * Only the direct target, which is defined in the meta-model, will be added to the set.
	 * An optional neighbour is an EClassifier that is targeted by a non-containment EReference
	 * with (upperBound-lowerBound > 0) or (upperBound == *) and it either has an EOpposite which is non-containment
	 * or no EOpposite at all.
	 * 
	 * @param eRef
	 * 
	 * @return
	 *		Set of EClassifiers
	 */
	private Set<EClassifier> findOptionalNeighbour(EReference eRef) {

		EReference eOpposite = eRef.getEOpposite();
		EClassifier oN = null;
		if (!eRef.isContainment()
				&& eOpposite != null) {
			if (!eOpposite.isContainment()
					&& (eRef.getUpperBound() - eRef.getLowerBound() > 0 || eRef.getUpperBound() == -1)) {
				oN = eRef.getEType() ;
				if(oN instanceof EClass && ((EClass)oN).isAbstract()) {
					return abstractToConcreteEClassifierMap.get(oN);
				}
				HashSet<EClassifier> hs = new HashSet<EClassifier>();
				hs.add(oN);
				return hs;
			}
		} else if (!eRef.isContainment()
				&& eOpposite == null
				&& (eRef.getUpperBound() - eRef.getLowerBound() > 0 || eRef.getUpperBound() == -1)) {
			oN = eRef.getEType();
			if(oN instanceof EClass && ((EClass)oN).isAbstract()) {
				return abstractToConcreteEClassifierMap.get(oN);
			}
			HashSet<EClassifier> hs = new HashSet<EClassifier>();
			hs.add(oN);
			return hs;
		}
		return null;
	}

	/**
	 * Creates a Set for <b>mandatory parent context</b> identified by the containment EOpposite of a given EReference.
	 * Only the direct target of the EReference, which is defined in the meta-model, will be added to the set.
	 * A mandatory parent context is an EClassifier that is targeted by a non-containment EReference which has
	 * a containment EOpposite; i.e. <i>the source of the EReference is the 'child' and the target the 'parent' but only if
	 * there is a containment EOpposite from a 'parent' back to the 'child'</i>. The following conditions must additionally apply:
	 * The lowerBound of the EOpposite is > 0 and thus marks the child as mandatory.
	 * Additionally, only the concrete sub types of abstract parent contexts will be added.
	 * 
	 * @param eRef
	 * 
	 * @return
	 *		Set of EClassifiers
	 */
	private Set<EClassifier> findMandatoryParentContext(EReference eRef) {
		EReference eOpposite = eRef.getEOpposite();
		EClassifier mPC = null;
		if (eOpposite != null
				&& eOpposite.isContainment()
				&& eOpposite.getLowerBound() > 0) {
			mPC = eRef.getEType();
			if(mPC instanceof EClass && ((EClass)mPC).isAbstract()) {
				return abstractToConcreteEClassifierMap.get(mPC);
			}
			HashSet<EClassifier> hs = new HashSet<EClassifier>();
			hs.add(mPC);
			return hs;
		}
		return null;
	}

	/**
	 * Creates a Set for <b>optional parent context</b> identified by the containment EOpposite of a given EReference.
	 * Only the direct target of the EReference, which is defined in the meta-model, will be added to the set.
	 * An optional parent context is an EClassifier that is targeted by a non-containment EReference which has
	 * a containment EOpposite; i.e. <i>the source of the EReference is the 'child' and the target the 'parent' (parent context) but only if
	 * there is a containment EOpposite from a 'parent' back to the 'child'</i>. The following conditions must additionally apply:
	 * The EOpposite either has (upperBound-lowerBound >0) or (upperbound == *).
	 * Additionally, only the concrete sub types of abstract parent contexts will be added.
	 * 
	 * @param eRef
	 * 
	 * @return
	 *		Set of EClassifiers
	 */
	private Set<EClassifier> findOptionalParentContext(EReference eRef) {
		EReference eOpposite = eRef.getEOpposite();
		EClassifier oPC = null;
		if (eOpposite != null
				&& eOpposite.isContainment()
				&& ((eOpposite.getUpperBound() - eOpposite.getLowerBound() > 0 || eOpposite.getUpperBound() == -1))) {
			oPC = eRef.getEType();
			if(oPC instanceof EClass && ((EClass)oPC).isAbstract()) {
				return abstractToConcreteEClassifierMap.get(oPC);
			}
			HashSet<EClassifier> hs = new HashSet<EClassifier>();
			hs.add(oPC);
			return hs;
		}
		return null;
	}

	/**
	 * Creates a Set for <b>optional neighbour context</b> identified by the non-containment EOpposite of a given EReference.
	 * Only the direct target of the EReference, which is defined in the meta-model, will be added to the set.
	 * An optional neighbour context is an EClassifier that is targeted by a non-containment EReference which has
	 * a non-containment EOpposite; i.e. <i>the source of the EReference is the 'neighbour' and the target the 'neighbour context' but only if
	 * there is a non-containment EOpposite from a 'neighbour context' back to the 'neighbour'</i>. The following conditions must additionally apply:
	 * The EOpposite either has (upperBound-lowerBound >0) or (upperbound == *).
	 * Additionally, only the concrete sub types of abstract neighbour contexts will be added.
	 * 
	 * @param eRef
	 * 
	 * @return
	 *		Set of EClassifiers
	 */
	private Set<EClassifier> findOptionalNeighbourContext(EReference eRef) {
		EReference eOpposite = eRef.getEOpposite();
		EClassifier oNC = null;
		if(eOpposite !=null && (eOpposite.isContainment() || eRef.isContainment())) {
			return null;
		}
		else if (eOpposite != null
				&& !eOpposite.isContainment()
				&& (eOpposite.getUpperBound() - eOpposite.getLowerBound() > 0 || eOpposite.getUpperBound() == -1)) {
			oNC = eRef.getEType();
			if (oNC instanceof EClass && ((EClass)oNC).isAbstract()) {
				return abstractToConcreteEClassifierMap.get(oNC);
			}
			HashSet<EClassifier> hs = new HashSet<EClassifier>();
			hs.add(oNC);
			return hs;
		}	
		return null;
	}

	/**
	 * Creates a Set for <b>mandatory neighbour context</b> identified by the non-containment EOpposite of a given EReference.
	 * Only the direct target of the EReference, which is defined in the meta-model, will be added to the set.
	 * A mandatory neighbour context is an EClassifier that is targeted by a containment EReference which has
	 * a non-containment EOpposite; i.e. <i>the source of the EReference is the 'neighbour' and the target the 'neighbour context' but only if
	 * there is a non-containment EOpposite from a 'neighbour context' back to the 'neighbour'</i>. The following conditions must additionally apply:
	 * The lowerBound of the EOpposite is > 0 and thus marks the neighbour as mandatory.
	 * Additionally, only the concrete sub types of abstract neighbour contexts will be added.
	 * 
	 * @param eRef
	 * 
	 * @return
	 *		Set of EClassifiers
	 */
	private Set<EClassifier> findMandatoryNeighbourContext(EReference eRef) {
		EReference eOpposite = eRef.getEOpposite();
		EClassifier mNC = null;
		if (eOpposite != null && !eOpposite.isContainment() && eOpposite.getLowerBound()>0) {
			mNC = eRef.getEType();
			if(mNC instanceof EClass && ((EClass)mNC).isAbstract()) {
				return abstractToConcreteEClassifierMap.get(mNC);
			}
			HashSet<EClassifier> hs = new HashSet<EClassifier>();
			hs.add(mNC);
			return hs;
		}
		return null;
	}
	
	/**
	 * Adds a mandatory parent context to a child
	 * 
	 * @param child
	 * 
	 * @param parent
	 * 
	 * @param parentRef
	 */
	private void add_MPC_to_Child(EClassifier child, EClassifier parent, EReference parentRef) {
		
		EClassifierInfo eClassInfo = getEClassifierInfo(child);

		if(eClassInfo.getMandatoryParentContext().get(parentRef)==null) {
			ArrayList<EClassifier> list = new ArrayList<EClassifier>();
			list.add(parent);
			eClassInfo.getMandatoryParentContext().put(parentRef, list);
		}
		else{
			if(!(eClassInfo.getMandatoryParentContext().get(parentRef).contains(parent))) {
				 eClassInfo.getMandatoryParentContext().get(parentRef).add(parent);
			}
		}

	}
	
	/**
	 * Adds an optional parent context to a child
	 * 
	 * @param child
	 * 
	 * @param parent
	 * 
	 * @param parentRef
	 */
	private void add_OPC_to_Child(EClassifier child, EClassifier parent, EReference parentRef) {
		EClassifierInfo eClassInfo = getEClassifierInfo(child);
		
		if(eClassInfo.getOptionalParentContext().get(parentRef)==null) {
			ArrayList<EClassifier> list = new ArrayList<EClassifier>();
			list.add(parent);
			eClassInfo.getOptionalParentContext().put(parentRef,list);
		}
		else{
			if(!(eClassInfo.getOptionalParentContext().get(parentRef).contains(parent))) {
				 eClassInfo.getOptionalParentContext().get(parentRef).add(parent);
			}
		}
	}
	
	/**
	 * Adds an optional child to its parent
	 * 
	 * @param parent
	 * 
	 * @param child
	 * 
	 * @param eRef
	 */
	private void add_OC_to_parent(EClassifier parent, EClassifier child, EReference eRef) {
		
		EClassifierInfo parentInfo = getEClassifierInfo(parent);

		if(parentInfo.getOptionalChildren().get(eRef)==null) {
			ArrayList<EClassifier> list = new ArrayList<EClassifier>();
			list.add(child);	
			parentInfo.getOptionalChildren().put(eRef,list);

		}else{
			if(!parentInfo.getOptionalChildren().get(eRef).contains(child)) {
				parentInfo.getOptionalChildren().get(eRef).add(child);
			}
		}
		
	}
	
	/**
	 * Adds a mandatory child to its parent
	 * 
	 * @param parent
	 * 
	 * @param child
	 * 
	 * @param eRef
	 */
	private void add_MC_to_parent(EClassifier parent, EClassifier child, EReference eRef) {
		
		EClassifierInfo parentInfo = getEClassifierInfo(parent);

		if(parentInfo.getMandatoryChildren().get(eRef)==null) {
			ArrayList<EClassifier> list = new ArrayList<EClassifier>();
			list.add(child);	
			parentInfo.getMandatoryChildren().put(eRef,list);

		}else{
			if(!parentInfo.getMandatoryChildren().get(eRef).contains(child)) {
				parentInfo.getMandatoryChildren().get(eRef).add(child);
			}
		}
		
	}
	
	/**
	 * Adds an optional neighbour to its neighbour
	 * 
	 * @param fromNeighbourContext
	 * 
	 * @param toOptionalNeighbour
	 * 
	 * @param directedRef
	 */
	private void add_ON_to_Neighbour(EClassifier fromNeighbourContext, EClassifier toOptionalNeighbour, EReference directedRef) {
		
		EClassifierInfo fromNeighbourInfo = getEClassifierInfo(fromNeighbourContext);

		if(fromNeighbourInfo.getOptionalNeighbours().get(directedRef)==null) {
			ArrayList<EClassifier> list = new ArrayList<EClassifier>();
			list.add(toOptionalNeighbour);	
			fromNeighbourInfo.getOptionalNeighbours().put(directedRef,list);

		}else{
			if(!fromNeighbourInfo.getOptionalNeighbours().get(directedRef).contains(toOptionalNeighbour)) {
				fromNeighbourInfo.getOptionalNeighbours().get(directedRef).add(toOptionalNeighbour);
			}
		}
	
	}
	
	/**
	 * Adds a mandatory neighbour to its neighbour
	 * 
	 * @param fromNeighbourContext
	 * 
	 * @param toMandatoryNeighbour
	 * 
	 * @param directedRef
	 */
	private void add_MN_to_Neighbour(EClassifier fromNeighbourContext, EClassifier toMandatoryNeighbour, EReference directedRef) {
	
		EClassifierInfo fromNeighbourInfo = getEClassifierInfo(fromNeighbourContext);

		if(fromNeighbourInfo.getMandatoryNeighbours().get(directedRef)==null) {
			ArrayList<EClassifier> list = new ArrayList<EClassifier>();
			list.add(toMandatoryNeighbour);	
			fromNeighbourInfo.getMandatoryNeighbours().put(directedRef,list);

		}else{
			if(!fromNeighbourInfo.getMandatoryNeighbours().get(directedRef).contains(toMandatoryNeighbour)) {
				fromNeighbourInfo.getMandatoryNeighbours().get(directedRef).add(toMandatoryNeighbour);
			}
		}
	
	}
	
	/**
	 * Adds a mandatory neihbor context to a neighbour
	 * 
	 * @param toNeighbour
	 * 
	 * @param fromNeighbour
	 * 
	 * @param directedRef
	 */
	private void add_MNC_to_Neighbour(EClassifier toNeighbour, EClassifier fromNeighbour, EReference directedRef) {
		
		EClassifierInfo eClassInfo = getEClassifierInfo(toNeighbour);
		
		if(eClassInfo.getMandatoryNeighbourContext().get(directedRef)==null) {
			ArrayList<EClassifier> list = new ArrayList<EClassifier>();
			list.add(fromNeighbour);
			eClassInfo.getMandatoryNeighbourContext().put(directedRef,list);	
		}else{
			if(!eClassInfo.getMandatoryNeighbourContext().get(directedRef).contains(fromNeighbour)) {
				eClassInfo.getMandatoryNeighbourContext().get(directedRef).add(fromNeighbour);
			}
		}
		
	}
	
	/**
	 * Adds an optional neighbour context to its neighbour
	 * 
	 * @param toNeighbour
	 * 
	 * @param fromNeighbour
	 * 
	 * @param directedRef
	 */
	private void add_ONC_to_Neighbour(EClassifier toNeighbour, EClassifier fromNeighbour, EReference directedRef) {
		
		EClassifierInfo eClassInfo = getEClassifierInfo(toNeighbour);
		
		if(eClassInfo.getOptionalNeighbourContext().get(directedRef)==null) {
			ArrayList<EClassifier> list = new ArrayList<EClassifier>();
			list.add(fromNeighbour);
			eClassInfo.getOptionalNeighbourContext().put(directedRef,list);	
		}else{
			if(!eClassInfo.getOptionalNeighbourContext().get(directedRef).contains(fromNeighbour)) {
				eClassInfo.getOptionalNeighbourContext().get(directedRef).add(fromNeighbour);
			}
		}
	}
	

	/**
	 * This method checks the current EClassifier in the EClassifierInfo for containing
	 * EStructuralFeatures that are typically used in profiled meta models.
	 * Their names normally begin with "base_". If there are such so called "extensions"
	 * the involved EClassifierInfos are filled with a mapping from meta class to stereotype
	 * and vice versa.
	 * 
	 * @param eClassifierInfo
	 */
	private void findAndMapStereotypes(EClassifierInfo eClassifierInfo) {
		
		EClassifier eClassifier = eClassifierInfo.getTheEClassifier();
		EClass eClass = (eClassifier instanceof EClass) ? (EClass) eClassifier : null;
		
		// check for profile mechanism / extension of meta classes
		if(eClass !=null) {
			List<EStructuralFeature> featureList = EMFMetaAccess.getEStructuralFeaturesByRegEx(eClass, "^(base)_\\w+", true);
			for(EStructuralFeature extension: featureList) {

				// set extended meta class
				EClassifier metaClass = extension.getEType();
				eClassifierInfo.addExtendedMetaClass(metaClass);

				// set self as stereotype for the extended meta EClassifier
				EClassifierInfo eClassInfoOfMetaClass = getEClassifierInfo(metaClass);
				if(eClassInfoOfMetaClass == null) {
					eClassInfoOfMetaClass = new EClassifierInfo(metaClass);
					eClassifierInfoMap.put(metaClass,eClassInfoOfMetaClass);
				}
				eClassInfoOfMetaClass.addStereotype(eClassifier);
				profileMetaclassSet.add(metaClass);
				profileStereotypesSet.add(eClassifier);
			}
		}		
	}

	/**
	 * This method tries to find the element type which
	 * is supposed to be the root of an instance of the metamodel.
	 * If there is no root element an exception is thrown.
	 * @return root EClassifier
	 * @throws NoRootElementFoundException
	 * 
	 */
	public EClassifier findRoot() throws NoRootElementFoundException{
		
		EClassifier root;
		String nsUri;
		
		Set<EClassifier> allElements = new HashSet<EClassifier>(eClassifierInfoMap.keySet());
		nsUri = allElements.iterator().next().eResource().getURI().toString();
		
		for(Entry<EClassifier, EClassifierInfo> entry: eClassifierInfoMap.entrySet()) {
			EClassifierInfo eInfo = entry.getValue();
			
			Map<EReference, List<EClassifier>> mandatoryParents = eInfo.getMandatoryParentContext();
			Map<EReference, List<EClassifier>> optionalParents = eInfo.getOptionalParentContext();
			
			if(!mandatoryParents.isEmpty() && !optionalParents.isEmpty()) {
				allElements.remove(entry.getKey());
			}
		}
		
		if(allElements.size()!=1) {
			throw new NoRootElementFoundException(nsUri);
		}else {
			root = allElements.iterator().next();
		}
		
		return root;	
	}
}

package org.sidiff.common.util;

import java.util.*;

import org.sidiff.common.exceptions.SiDiffException;

/**
 * Diese Hilfsklasse ermoeglicht eine einfache verarbeitung von Parameter-Strings aus 
 * Konfigurationsdateien.
 * Argumente koennen in Manier einer Fabrik erzeugt und nach dem 
 * parsen des Argument-Strings direkt mit korrektem Typ verwendet werden.
 * 
 * Hinweis: Die Flags und Parameter koennen vor dem Parsen an beliebiger Stelle angelegt werden 
 * und nach dem Parsen auch dort abgefragt werden. 
 * Fuer Argumente ist dies leider nicht moeglich! 
 * 
 * Dabei werden die folgenden "Argumenttypen" unerschieden:
 * 
 * 	Argumenten	<<app>> argument1,argument2 ...
 *  Parametern	<<app>> parametername1=wert1,parametername2=wert1;wert2 ...
 *  Flags 		<<app>> flag1,flag2 ...
 * 
 * 	Die Reihenfolge ist lediglich bei Argumenten von Relevanz.
 *  
 * @author kehrer
 *
 */
public class ParamUtil {

	private static final String PARAM_SEPARATOR = ",";
	private static final String VALUE_LIST_SEPARATOR = ";";
	private static final String VALUE_ASSIGNMENT_OPERATOR = "=";
	
	/**
	 * List of defined arguments.
	 */
	private List<Argument<String>> arguments = new LinkedList<Argument<String>>();
	
	/**
	 * Map of defined parameters. Maps from the parameter name to its object.
	 */
	private Map<String, Argument<?>> parameterMap = new HashMap<String, Argument<?>>();
	
	/**
	 * Map of defined flags. Maps from the name of the flag to its object.
	 */
	private Map<String, Argument<Boolean>> flagMap = new HashMap<String, Argument<Boolean>>();
	
	private boolean hasBeenParsed = false;

	/**
	 * Erzeugt ein Argument. Der Datentyp eines Argumentes kann nur ein Zeichenketten (Strings) sein.
	 * 
	 * @param required Gibt an, ober das erzeugte Argument optional ist, oder ob das Argument spaeter
	 * in dem Argument-String enthalten sein muss; Dementsprechend kann das Argument spaeter einen
	 * "null"-Wert besitzen oder nicht.
	 * 
	 * @return Argument zur spaeteren nutzung.
	 */
	public Argument<String> createArgument(boolean required) {
		
		Argument<String> result = new Argument<String>(true, String.class);
		this.arguments.add(result);
		return result;
	}

	/**
	 * Erzeugt ein Flag-Argument. Der Datentyp eines Argumentes kann nur ein Boolscher wert sein.
	 * So kann das Flag entweder gesetzt worden sein (true) oder nicht (false).
	 * 
	 * @param Der Name unter dem das Flag ggf. gesetzt wird. 
	 * 
	 * @return Flag zur spaeteren nutzung.
	 */
	public Argument<Boolean> createFlag(String key) {
		
		assert(key!=null):"Name of a flag must not be null!";
		
		Argument<Boolean> result = new Argument<Boolean>(true, Boolean.class);
		if (!this.flagMap.containsKey(key)&&!this.parameterMap.containsKey(key)) {
			this.flagMap.put(key, result);
		} else {
			throw new IllegalArgumentException("CommandLine argument '" + key + "' already used!");
		}
		return result;
	}

	/**
	 * Erzeugt ein Parameter. Ein Parameter ist immer ein paar aus Parameter-Schluessel einem 
	 * dazugehoerigen wert, der einen beliebigen Datentyp besitzen kann. Daher ist der erwartete
	 * Datentyp zu Spezifizieren. Das erzeugte Argument besitzt anschliessend den entsprechenden
	 * Typ. 
	 * 
	 * @param key Name des Parameters.
	 * @param type Typ des Arguments (muss einen Konstruktor "public Typ(String s)" besitzen.
	 * @param required Gibt an, ober der erzeugte Parameter optional ist, oder ob der Parameter spaeter
	 * in dem Argument-String enthalten sein muss; Dementsprechend kann der Parameter spaeter einen
	 * "null"-Wert besitzen oder nicht.
	 * 
	 * @return Parameter zur spaeteren nutzung.
	 */
	public <T> Argument<T> createParameter(String key, Class<T> type, boolean required) {

		assert(key!=null):"Name of a paramter must not be null!";
		assert(type!=null):"Type of a paramter must not be null!";
		
		Argument<T> result = new Argument<T>(required, type);
		if (!this.parameterMap.containsKey(key)&&!this.flagMap.containsKey(key)) {
			this.parameterMap.put(key, result);
		} else {
			throw new IllegalArgumentException("CommandLine argument '" + key + "' already used!");
		}
		return result;
	}



	/**
	 * Diese Methode nimmt den Paramter-String entgegen und parst diesen.
	 * Anschliessend sind alle zuvor deklarierten Argumente initialisiert und koennen verwendet 
	 * werden.
	 * 
	 * @param parameterString Der Parameterstring im oben angegebenen Format.
	 * @return True, falls die der parameter String korrekt war; D.h. alle required sind angegeben und 
	 *  keine unbekannten Argumente gefunden.
	 */
	public boolean parse(String parameterString){
		
		assert(!hasBeenParsed):"Has already been parsed!";
		assert(parameterString!=null):"No parameterString to parse!";
		
		String[] args = parameterString.split(PARAM_SEPARATOR);
		boolean result = true;
		Argument<?> param = null;
		Iterator<Argument<String>> argumentIterator = this.arguments.iterator();

		for(String token : args){
			token.trim();
			if(token.contains("=")){
				// Token is a Parameter
				String[] fragments = token.split(VALUE_ASSIGNMENT_OPERATOR);
				String key = fragments[0].trim();
				String value = fragments[1].trim();
				
				assert(parameterMap.containsKey(key)):"The parameter '" + key + "'is undefined";
				
				// Parameter, so get next 
				param = this.parameterMap.get(key);
				param.setValue(value);				
			} else if(parameterMap.containsKey(token)){
				// Token is a Flag				
				this.flagMap.get(token).setValue(Boolean.TRUE.toString());
			} else {
				// Token is a Argument
				assert(argumentIterator.hasNext()):"Unexpected Argument "+token;
				argumentIterator.next().setValue(token);
			}
		}
		
		// Checks and cleanups
		
		// All Arguments are given...
		if(argumentIterator.hasNext()){
			StringBuffer buffer = new StringBuffer();
			
			while(argumentIterator.hasNext()){
				Argument<?> missing = argumentIterator.next();
				buffer.append("Missing Argument '");
				buffer.append(missing.type.getName());
				buffer.append("' (");
				buffer.append(this.arguments.indexOf(missing));
				buffer.append(")\n");
			}
			throw new IllegalArgumentException(buffer.toString());
		}
		
		// All required Parameters where given
		for(String key : this.parameterMap.keySet()){
			if(!parameterMap.get(key).satisfied){
				throw new IllegalArgumentException("Missing Parameter "+key);
			}
		}
		
		// All not given Flags to be set as false
		for(Argument<?> flag : this.flagMap.values()){
			if(!flag.satisfied){
				flag.setValue(Boolean.FALSE.toString());
			}
		}
		
		hasBeenParsed = true;
		return result;
	}

	/**
	 * Instanzen dieser Klasse stehen stellvertretend fuer Argumente der
	 * Komandozeile. Der Wert eines Argumentes kann nach dem Parsen
	 * der Komandozeile mittels getValue() abgefragt werden.
	 * Der Wert liegt im spezifizierten Datentyp vor.
	 * 
	 * @author Maik Schmidt
	 *
	 * @param <T> Datentyp des Arguments 
	 */
	public class Argument<T> {

		private Class<T> type = null;
		private T value = null;
		private boolean satisfied = false;

		private Argument(boolean required, Class<T> type) {
			this.satisfied = !required;
			this.type=type;
		}

		@SuppressWarnings("unchecked")
		private void setValue(String value) {
			if (Collection.class.isAssignableFrom(type)){
				// value list
				try {
					this.value = type.getConstructor().newInstance();
				} catch (Exception e) {
					throw new IllegalArgumentException("Cannot create '" + type.getName());
				}
				String[] values = value.split(VALUE_LIST_SEPARATOR);
				for (int i = 0; i < values.length; i++) {
					try {
						((Collection)this.value).add(String.class.getConstructor(String.class).newInstance(values[i]));
					} catch (Exception e) {
						throw new IllegalArgumentException("Cannot create '" + type.getName() + "' with '" + value + "'");
					}
				}
				this.satisfied = true;
				
			} else {
				// simple value
				try {
					this.value = type.getConstructor(String.class).newInstance(value);
				} catch (Exception e) {
					throw new IllegalArgumentException("Cannot create '" + type.getName() + "' with '" + value + "'");
				}
				this.satisfied = true;
			}
			
		}

		/**
		 * Returns the value of the argument.
		 * @return
		 */
		public T getValue() throws UnparsedParameterStringException {
			if(!hasBeenParsed)
				throw new UnparsedParameterStringException("Command line has not been parsed yet.");
			return value;
		}

	}
	
	public class UnparsedParameterStringException extends SiDiffException {

		private static final long serialVersionUID = -4894142120552595070L;

		public UnparsedParameterStringException(Object... message) {
			super(message);
		}
		
	}

}

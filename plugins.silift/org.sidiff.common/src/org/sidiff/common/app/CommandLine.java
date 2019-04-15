package org.sidiff.common.app;

import java.util.*;

import org.sidiff.common.exceptions.SiDiffException;

/**
 * Diese Hilfsklasse ermoeglicht eine einfache verarbeitung der Argumente einer
 * Applikation. Argumente koennen in Manier einer Fabrik erzeugt und nach dem 
 * parsen des Argument-Strings direkt mit korrektem Typ verwendet werden.
 * 
 * Hinweis: Die Flags und Parameter koennen vor dem Parsen an beliebiger Stelle angelegt werden 
 * und nach dem Parsen auch dort abgefragt werden. Beispiel: Module definieren ihre eigenen Flags.
 * Fuer Argumente ist diews leider nicht moeglich! 
 * 
 * Dabei werden die folgenden "Argumenttypen" unerschieden:
 * 
 * 	Argumenten	<<app>> argument1 argument2 ...
 *  Parametern	<<app>> -parametername1 wert1 -parametername2 wert2
 *  Flags 		<<app>> -flag1 -flag2
 * 
 * 	Die Reihenfolge ist lediglich bei Argumenten von relevanz.
 *  
 *  Beispiel:
 *  
 *  public class AscetDiff implements IApplication {
 *
 *	final static Argument<String> FILE_LEFT = CommandLine.createParameter("left", String.class, true);
 *	final static Argument<String> FILE_RIGHT = CommandLine.createParameter("right", String.class, true);
 *
 *	public Object start(IApplicationContext context) throws Exception {
 *		
 *		CommandLine.parse((String[]) context.getArguments().get(IApplicationContext.APPLICATION_ARGS), false);
 *
 *		loadFile(FILE_LEFT.getValue());
 *		loadFile(FILE_RIGHT.getValue());
 *
 *		...
 *
 *		return IApplication.EXIT_OK;
 *	}
 *  
 * @author Maik Schmidt
 *
 */
public class CommandLine {

	/**
	 * Prefix for parameters
	 */
	public static final String PARAMETER_PREFIX = "-";

	/**
	 * List of defined arguments.
	 */
	private static List<Argument<String>> arguments = new LinkedList<Argument<String>>();
	
	/**
	 * Map of defined parameters. Maps from the parameter name to its object.
	 */
	private static Map<String, Argument<?>> parameterMap = new HashMap<String, Argument<?>>();
	
	/**
	 * Map of defined flags. Maps from the name of the flag to its object.
	 */
	private static Map<String, Argument<Boolean>> flagMap = new HashMap<String, Argument<Boolean>>();
	
	private static boolean hasBeenParsed = false;

	/**
	 * No Instance allowed; Its a static Factory!
	 */
	private CommandLine() {
	}

	/**
	 * Erzeugt ein Argument. Der Datentyp eines Argumentes kann nur ein Zeichenketten (Strings) sein.
	 * 
	 * @param required Gibt an, ober das erzeugte Argument optional ist, oder ob das Argument spaeter
	 * in dem Argument-String enthalten sein muss; Dementsprechend kann das Argument spaeter einen
	 * "null"-Wert besitzen oder nicht.
	 * 
	 * @return Argument zur spaeteren nutzung.
	 */
	public static Argument<String> createArgument(boolean required) {
		
		Argument<String> result = new Argument<String>(true, String.class);
		CommandLine.arguments.add(result);
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
	public static Argument<Boolean> createFlag(String key) {
		
		assert(key!=null):"Name of a flag must not be null!";
		
		Argument<Boolean> result = new Argument<Boolean>(true, Boolean.class);
		if (!CommandLine.flagMap.containsKey(key)&&!CommandLine.parameterMap.containsKey(key)) {
			CommandLine.flagMap.put(key, result);
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
	public static <T> Argument<T> createParameter(String key, Class<T> type, boolean required) {

		assert(key!=null):"Name of a paramter must not be null!";
		assert(type!=null):"Type of a paramter must not be null!";
		
		Argument<T> result = new Argument<T>(required, type);
		if (!CommandLine.parameterMap.containsKey(key)&&!CommandLine.flagMap.containsKey(key)) {
			CommandLine.parameterMap.put(key, result);
		} else {
			throw new IllegalArgumentException("CommandLine argument '" + key + "' already used!");
		}
		return result;
	}



	/**
	 * Diese Methode nimmt die Komandozeilenargumente der applikation entgegen und parst diese.
	 * Anschliessend sind alle zuvor deklarierten Argumente initialisiert und koennen verwendet 
	 * werden.
	 * 
	 * @param args Komandozeilenargumente der client-Applikation.
	 * @param ignore Spezifiziert ob unbekannte Argumente (d.h. zu viel angegebene) ignoriert werden sollen, oder ob die
	 *  eine "IllegalArgumentException" werfen
	 * @return True, falls die komandozeie korrekt war; D.h. alle required sind angegeben und 
	 *  keine unbekannten Argumente gefunden.
	 */
	public static boolean parse(String[] args, boolean ignore){
		
		assert(!hasBeenParsed):"Has already been parsed!";
		assert(args!=null):"No arguments to parse!";
		
		boolean result = true;
		Argument<?> param = null;
		Iterator<Argument<String>> argumentIterator = CommandLine.arguments.iterator();

		for(String token : args){
			if(token.startsWith(PARAMETER_PREFIX)){
				// Token is a Flag or Parameter
				String key = token.substring(1);
				if(CommandLine.parameterMap.containsKey(key)){
					// Parameter, so get next 
					param = CommandLine.parameterMap.get(key);
				} else if(CommandLine.flagMap.containsKey(key)){
					// Flag, so set it
					CommandLine.flagMap.get(key).setValue(Boolean.TRUE.toString());
				} else {
					if(ignore){
						result &= false;
					} else {
						throw new IllegalArgumentException("CommandLine: Undefined Flag or Parameter: "+token);
					}
				}
				
			} else if(param!=null){
				// Token is a Parameter value
				param.setValue(token);
				param=null;
			} else {
				// Token is a Argument
				if(argumentIterator.hasNext()){
					argumentIterator.next().setValue(token);
				} else {
					if(ignore){
						result &= false;
					} else {
						throw new IllegalArgumentException("Unexpected Argument "+token);
					}
				}	
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
				buffer.append(CommandLine.arguments.indexOf(missing));
				buffer.append(")\n");
			}
			throw new IllegalArgumentException(buffer.toString());
		}
		
		// All required Parameters where given
		for(String key : CommandLine.parameterMap.keySet()){
			if(!parameterMap.get(key).satisfied){
				throw new IllegalArgumentException("Missing Parameter "+key);
			}
		}
		
		// All not given Flags to be set as false
		for(Argument<?> flag : CommandLine.flagMap.values()){
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
	public static class Argument<T> {

		private Class<T> type = null;
		private T value = null;
		private boolean satisfied = false;

		private Argument(boolean required, Class<T> type) {
			this.satisfied = !required;
			this.type=type;
		}

		private void setValue(String value) {

			try {
				this.value = type.getConstructor(String.class).newInstance(value);
			} catch (Exception e) {
				throw new IllegalArgumentException("Cannot create '" + type.getName() + "' with '" + value + "'");
			}
			this.satisfied = true;
		}

		/**
		 * Returns the value of the argument.
		 * @return
		 */
		public T getValue() throws UnparsedCommandLineException {
			if(!hasBeenParsed)
				throw new UnparsedCommandLineException("Command line has not been parsed yet.");
			return value;
		}

	}
	
	public static class UnparsedCommandLineException extends SiDiffException {

		private static final long serialVersionUID = -4894142120552595070L;

		public UnparsedCommandLineException(Object... message) {
			super(message);
		}
		
	}

}

package org.sidiff.common.io;

import java.io.*;
import java.net.URL;

import org.sidiff.common.exceptions.SiDiffRuntimeException;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;

/**
 * Utility class for IO-related stuff 
 */
public class IOUtil {

	/**
	 * Creates an input stream from a file.
	 * @param filename
	 * @return
	 */
	public static InputStream getInputStreamFromFile(String filename) {
		File file = new File(filename);
		InputStream result = null;
		try {
			result = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			LogUtil.log(LogEvent.ERROR, "File not found: "+filename);
		}
		return result;
	}

	/**
	 * Creates an input stream from a string.
	 * @param data
	 * @return
	 */
	public static InputStream getInputStreamFromString(String data) {
		return new StringInputStream(data);
	}

	/**
	 * Creates an input stream from a resource.
	 * (The resource has to be in the classpath of one of the class loaders registered at the ResourceUtil.)
	 * @param resourceName
	 * @return
	 */
	public static InputStream getInputStreamFromResource(String resourceName) {
		return ResourceUtil.getInputStreamByResourceName(resourceName);
	}

	/**
	 * Creates an input stream from a file or a resource.
	 * @param resourceOrFileName
	 * @return
	 */
	public static InputStream getInputStream(String resourceOrFileName) {
		InputStream result = null;
		URL url;
		assert(LogUtil.log(LogEvent.DEBUG, "Try to get '" + resourceOrFileName + "' as File ..."));
		try {
			result = new FileInputStream(new File(resourceOrFileName));
		} catch (FileNotFoundException e) {
		}
		if (result == null) {
			assert(LogUtil.log(LogEvent.DEBUG, "Try to get '" + resourceOrFileName + "' as Resource ..."));
			result = getInputStreamFromResource(resourceOrFileName);
		}
		if (result == null){
			assert(LogUtil.log(LogEvent.DEBUG, "Try to get '" + resourceOrFileName + "' as Plugin Resource..."));
			if(resourceOrFileName.startsWith("platform:/plugin")){
				try {
					url = new URL(resourceOrFileName);
					result = url.openConnection().getInputStream();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (result == null) {
			throw new IllegalArgumentException("Unable to get Input Stream '" + resourceOrFileName + "'");
		}
		return result;
	}
	/**
	 * Creates an output stream that writes into the given file.
	 * @param filename
	 * @return
	 */
	public static OutputStream getOutputStreamIntoFile(String filename) {
		File file = new File(filename);
		OutputStream result = null;
		try {
			result = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Creates an output stream that writes into the given string buffer.
	 * @param buffer
	 * @return
	 */
	public static OutputStream getOutputStreamIntoString(StringBuffer buffer) {
		return new StringOutputStream(buffer);
	}

	/**
	 * Reads all data from the given stream and returns it as string.
	 * @param stream
	 * @return
	 */
	public static String readFromStream(InputStream stream) {
		StringBuffer sbuffer = new StringBuffer();
		InputStreamReader istreamReader = new InputStreamReader(stream);
		BufferedReader breader = new BufferedReader(istreamReader);
		try {
			String line = breader.readLine();
			while (line != null) {
				sbuffer.append(line + "\n");
				line = breader.readLine();
			}
			stream.close();
		} catch (IOException e) {
			throw new SiDiffRuntimeException(IOUtil.class, "Error while Reading from stream ", e);
		}
		return sbuffer.toString();
	}
	
	/**
	 * Reads the first [charCount] chars from the given stream and returns them as string.
	 * @param stream
	 * @param charCount
	 * @return
	 */
	public static String readFromStream(InputStream stream,int charCount) {

		StringBuffer sbuffer = new StringBuffer(); 
		if (stream != null) {
			InputStreamReader istreamReader = new InputStreamReader(stream);
			try {
				for (int i = 0; i < charCount && istreamReader.ready(); i++) {
					sbuffer.append((char) istreamReader.read());
				}
				stream.close();
			} catch (IOException e) {
				throw new SiDiffRuntimeException(IOUtil.class, "Error while Reading from stream ", e);
			}
		}
		return sbuffer.toString();
	}

	/**
	 * Reads the whole input stream and writes it to the output stream.
	 * @param in the input stream
	 * @param out the output stream
	 * @throws IOException if an I/O error occurred
	 */
	public static void transfer(InputStream in, OutputStream out) throws IOException {
		byte[] buffer = new byte[10*1024];
		int length;
        while((length = in.read(buffer)) > 0) {
        	out.write(buffer, 0, length);
        }
	}

	/**
	 * OutputStream implementation for Strings
	 */
	private static class StringOutputStream extends OutputStream {
		
		private StringBuffer buffer = null;
		
		public StringOutputStream(StringBuffer buffer) {
			this.buffer = buffer;
		}
		
		public void write(int character) throws java.io.IOException {
			this.buffer.append((char) character);
		}
	}

	/**
	 * InputStream implementation for Strings
	 */
	//FIXME respecting encoding!
	private static class StringInputStream extends InputStream {
		
		private int position = 0;
		private String data = null;
		
		private StringInputStream(String data) {
			this.data = data;
		}
		
		public int read() throws java.io.IOException {
			if (position < data.length()) {
				return data.charAt(position++);
			} else {
				return -1;
			}
		}
	}
}

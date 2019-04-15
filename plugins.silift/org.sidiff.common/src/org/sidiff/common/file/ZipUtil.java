package org.sidiff.common.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import org.sidiff.common.exceptions.FileAlreadyExistsException;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;

public class ZipUtil {

	public static final String SYSTEM_SEPERATOR = System.getProperty("file.separator");
	public static final String ZIP_SEPERATOR = "/";

	/**
	 * Zips a directory that is given by an absolute path.
	 * 
	 * <p>
	 * <strong>Example:</strong>
	 * <code>zip("/example/folderToZip", "/example/zipFile")</code>
	 * </p>
	 * <p>
	 * The directory <code>folderToZip</code> in the directory example will be
	 * saved as <code>zipFile.zip</code> in the same directory.
	 * </p>
	 * 
	 * @param inputPath
	 *            absolute path of the directory to zip.
	 * @param outputPath
	 *            absolute path of the zip file.
	 * @param extension
	 *            the file extension of the zip.
	 * @param clear
	 * 			  flag to determine if the input folder should be deleted after compression
	 * 
	 * @see {@link #zipDir(String, String, File, ZipOutputStream)}
	 * 
	 */
	public static void zip(String inputPath, String outputPath, String extension, boolean clear){
		zip(inputPath, outputPath, extension);
		if(clear){
			FileOperations.removeFolder(inputPath);
		}
	}
	
	/**
	 * Zips a directory that is given by an absolute path.
	 * 
	 * <p>
	 * <strong>Example:</strong>
	 * <code>zip("/example/folderToZip", "/example/zipFile")</code>
	 * </p>
	 * <p>
	 * The directory <code>folderToZip</code> in the directory example will be
	 * saved as <code>zipFile.zip</code> in the same directory.
	 * </p>
	 * 
	 * @param inputPath
	 *            absolute path of the directory to zip.
	 * @param outputPath
	 *            absolute path of the zip file.
	 * @param extension
	 *            the file extension of the zip.
	 * 
	 * @see {@link #zipDir(String, String, File, ZipOutputStream)}
	 * 
	 */
	public static void zip(String inputPath, String outputPath, String extension) {
		try {
			File file = new File(outputPath + "." + extension);
			ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(file));
			zipDir(inputPath, new File(inputPath), zipOutputStream);
			zipOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Zips a directory that is given by an absolute path.
	 * 
	 * <p>
	 * <strong>Example:</strong>
	 * <code>zip("/example/folderToZip", "/example/zipFile")</code>
	 * </p>
	 * <p>
	 * The directory <code>folderToZip</code> in the directory example will be
	 * saved as <code>zipFile.zip</code> in the same directory.
	 * </p>
	 * 
	 * @param inputPath
	 *            absolute path of the directory to zip.
	 * @param outputPath
	 *            absolute path of the zip file.
	 * 
	 * @see {@link #zipDir(String, String, File, ZipOutputStream)}
	 * 
	 */
	public static void zip(String inputPath, String outputPath) {
		zip(inputPath, outputPath, "zip");
	}

	/**
	 * 
	 * @param dirToZip
	 *            absolute path of the directory to zip
	 * @param dirToZipFile
	 * @param zipOutputStream
	 */
	private static void zipDir(String dirToZip, File dirToZipFile, ZipOutputStream zipOutputStream) {
		if (dirToZip == null || dirToZipFile == null || zipOutputStream == null || !dirToZipFile.isDirectory())
			return;

		BufferedInputStream fileInputStream = null;
		try {
			File[] fileArray = dirToZipFile.listFiles();
			String path;
			
			for (File file : fileArray) {
				if (file.isDirectory()) {
					zipDir(dirToZip, file, zipOutputStream);
					continue;
				}
			
				// Parse entry name:
				path = file.getPath();
				String name = path.substring(dirToZip.length() + 1, path.length());
				name = name.replace(SYSTEM_SEPERATOR, ZIP_SEPERATOR);
				
				LogUtil.log(LogEvent.NOTICE, "zip " + name);
				
				// Zip enty:
				zipOutputStream.putNextEntry(new ZipEntry(name));
				fileInputStream = new BufferedInputStream(new FileInputStream(file));
				
				int len;
				byte[] buffer = new byte[fileInputStream.available()];
				
				while ((len = fileInputStream.read(buffer, 0, buffer.length)) > 0) {
					zipOutputStream.write(buffer, 0, len);
					zipOutputStream.closeEntry();
				}
				fileInputStream.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reads the content of a file.
	 * 
	 * @param zipFile
	 *            absolute path of the zip file
	 * @param fileName
	 *            name of the file to be read
	 * @return the content of the file as a String
	 */
	public static String readFileFromZip(String zipFile, String fileName) {
		BufferedInputStream in = null;
		BufferedReader br = null;

		StringBuffer text = new StringBuffer();

		ZipFile file = null;
		try {
			file = new ZipFile(zipFile);
			Enumeration<?> enu = file.entries();

			while (enu.hasMoreElements()) {
				ZipEntry zipEntry = (ZipEntry) enu.nextElement();
				String zipEntryName = zipEntry.getName();

				if (zipEntryName.equals(fileName)) {
					in = new BufferedInputStream(file.getInputStream(zipEntry));
					br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
					
					String line;
					
					while ((line = br.readLine()) != null) {
						text.append(line);
					}
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
				if (file != null)
					file.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return text.toString();
	}
	
	public static List<String> getEntries(String zipFile) {
		List<String> entries = new ArrayList<String>();
		ZipFile file = null;
		
		try {
			file = new ZipFile(zipFile);
			Enumeration<?> enu = file.entries();

			while (enu.hasMoreElements()) {
				ZipEntry zipEntry = (ZipEntry) enu.nextElement();
				String zipEntryName = zipEntry.getName();
				entries.add(zipEntryName);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return entries;
	}

	/**
	 * Extracts all files of a zip file.
	 * 
	 * @param zip
	 *            absolute path of the zip file
	 * @param output
	 *            absolute path of the directory, where the zip file will be
	 *            extracted
	 * @param dirName
	 *            name of directory containing all extracted files
	 * @param overwrite
	 *            if the target folder already exists and the flag is true, all
	 *            existing files will be overwritten.
	 * @throws FileAlreadyExistsException
	 */
	public static void extractFiles(String zipFile, String output, String dirName, boolean overwrite)
			throws FileAlreadyExistsException {

		if (!(output.endsWith("/") || output.endsWith("\\"))) {
			output += SYSTEM_SEPERATOR;
		}

		String path = output + dirName + SYSTEM_SEPERATOR;
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		
		try {
			File destDir = new File(path);
			FileOperations.createFolder(path, overwrite);

			ZipFile file = new ZipFile(zipFile);
			Enumeration<?> enu = file.entries();
			
			while (enu.hasMoreElements()) {
				ZipEntry zipEntry = (ZipEntry) enu.nextElement();
				String zipEntryName = zipEntry.getName();
				File dir = buildDirectoryHierarchy(zipEntryName, destDir);
				dir.mkdir();

				if (!zipEntry.isDirectory()) {
					in = new BufferedInputStream(file.getInputStream(zipEntry));
					byte[] buffer = new byte[in.available()];
					int len;
					while ((len = in.read(buffer, 0, buffer.length)) > 0) {
						out = new BufferedOutputStream(new FileOutputStream(path + zipEntryName, false));
						out.write(buffer, 0, len);
						out.flush();
					}
				}
			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
				if (out != null)
					out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param fileName
	 * @param destDir
	 * @return
	 */
	private static File buildDirectoryHierarchy(String fileName, File destDir) {
		int lastIndex = fileName.lastIndexOf(ZIP_SEPERATOR);
		String internalPathToEntry = fileName.substring(0, lastIndex + 1);

		return new File(destDir, internalPathToEntry);
	}
}

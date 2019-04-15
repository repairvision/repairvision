package org.sidiff.common.file;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class BufferedZipInputStream extends InputStream {

	private BufferedInputStream in;
	private ZipFile file;
	
	public BufferedZipInputStream(String zipFile, String fileName) {
		try {
			file = new ZipFile(zipFile);
			Enumeration<?> enu = file.entries();

			while (enu.hasMoreElements()) {
				ZipEntry zipEntry = (ZipEntry) enu.nextElement();
				String zipEntryName = zipEntry.getName();

				if (zipEntryName.equals(fileName)) {
					in = new BufferedInputStream(file.getInputStream(zipEntry));
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() throws IOException {
		in.close();
		file.close();
	}

	@Override
	public int read() throws IOException {
		return in.read();
	}

}

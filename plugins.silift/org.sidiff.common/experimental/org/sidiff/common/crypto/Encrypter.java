package org.sidiff.common.crypto;

import java.io.*;
import java.security.InvalidKeyException;

import javax.crypto.*;

/**
 * A class which can encrypt a streams and files.
 * 
 * @author mcguire
 * 
 * Completely untested and currently not used.
 */
@Deprecated 
public class Encrypter {

	/**
	 * Encrypts the given input stream and writes the content to the given output stream.
	 * 
	 * It uses the secret key from the EncryptionManager, so make sure the keys are loaded first.
	 * 
	 * @param plainInputStream
	 *            the stream to be encrypted
	 * @param encryptedOutputStream
	 *            the stream where to encypted content will be written to
	 * 
	 * @throws InvalidKeyException
	 * @throws IOException
	 */
	public void encrypt(InputStream plainInputStream, OutputStream encryptedOutputStream) throws InvalidKeyException, IOException {
		Cipher cipher = EncryptionManager.getInstance().getSymetricCipher(true);
		while (true) {
			byte[] inputBuffer = new byte[1024];
			int amountRead = plainInputStream.read(inputBuffer);
			if (amountRead == -1)
				break;
			encryptedOutputStream.write(cipher.update(inputBuffer, 0, amountRead));
		}
		try {
			encryptedOutputStream.write(cipher.doFinal());
		} catch (IllegalBlockSizeException e) {
			// Can't happen
			assert (false);
		} catch (BadPaddingException e) {
			// Can't happen
			assert (false);
		}

		plainInputStream.close();
		encryptedOutputStream.close();
	}

	/**
	 * Same a encryptStream(), only that it operates on files, not streams.
	 */
	public void encryptFile(String plaintextFile, String encryptedFile) throws InvalidKeyException, IOException {
		FileInputStream input = new FileInputStream(plaintextFile);
		FileOutputStream output = new FileOutputStream(encryptedFile);
		encrypt(input, output);
	}
}

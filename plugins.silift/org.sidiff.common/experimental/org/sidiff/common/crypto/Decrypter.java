package org.sidiff.common.crypto;

import java.io.*;
import java.security.InvalidKeyException;

import javax.crypto.*;

/**
 * A class which can decrypt streams and files which were encrypted with a Encrypter.
 * 
 * @author mcguire
 * 
 * Completely untested and currently not used.
 */
@Deprecated 
public class Decrypter {

	/**
	 * Decrypts a stream and writes the decrypted content to the given output stream. Both streams are closed when finished.
	 * 
	 * It uses the secret key from the EncryptionManager, so make sure the keys are loaded first.
	 */
	public void decrypt(InputStream encryptedInputStream, OutputStream plainOutputStream) throws InvalidKeyException, IOException {
		Cipher cipher = EncryptionManager.getInstance().getSymetricCipher(false);
		while (true) {
			byte[] inputBuffer = new byte[1024];
			int amountRead = encryptedInputStream.read(inputBuffer);
			if (amountRead == -1)
				break;
			plainOutputStream.write(cipher.update(inputBuffer, 0, amountRead));
		}

		try {
			plainOutputStream.write(cipher.doFinal());
		} catch (IllegalBlockSizeException e) {
			// Can't happen
			assert (false);
		} catch (BadPaddingException e) {
			// Can't happen
			assert (false);
		}

		encryptedInputStream.close();
		plainOutputStream.close();
	}
}

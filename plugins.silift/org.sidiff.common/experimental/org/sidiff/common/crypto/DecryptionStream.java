package org.sidiff.common.crypto;

import java.io.InputStream;
import java.security.InvalidKeyException;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;

/**
 * Completely untested and currently not used.
 */
@Deprecated 
public class DecryptionStream extends CipherInputStream {

	CipherInputStream cipherInputStream;
	Cipher cipher;

	public DecryptionStream(InputStream inputStream) throws InvalidKeyException {
		super(inputStream, EncryptionManager.getInstance().getSymetricCipher(false));
	}
}

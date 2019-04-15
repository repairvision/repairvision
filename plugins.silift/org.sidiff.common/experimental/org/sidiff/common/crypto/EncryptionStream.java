package org.sidiff.common.crypto;

import java.io.OutputStream;
import java.security.InvalidKeyException;

import javax.crypto.CipherOutputStream;

/**
 * Completely untested and currently not used.
 */
@Deprecated 
public class EncryptionStream extends CipherOutputStream {

	public EncryptionStream(OutputStream outputStream) throws InvalidKeyException {
		super(outputStream, EncryptionManager.getInstance().getSymetricCipher(true));
	}
}

package org.sidiff.common.crypto;

import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

/**
 * A class which manages the secret key used for encryption and decryption. It is a singleton.
 * 
 * @author mcguire
 * 
 * Completely untested and currently not used.
 */
@Deprecated 
public class EncryptionManager {

	private static EncryptionManager mInstance;
	private SecretKey mSecretKey;

	private final String algorithm = "AES";

	// A higher value would be better, but that requires "Unlimited Strength Jurisdiction Policy Files"
	private final int keySize = 128;

	public static EncryptionManager getInstance() {
		if (mInstance == null) {
			mInstance = new EncryptionManager();
		}
		return mInstance;
	}

	/**
	 * Reads the secret key from a stream. Call this before attempting any encryption or decryption.
	 * 
	 * @param keyStream
	 *            the stream to read the key from
	 * 
	 * @throws IOException
	 * @throws InvalidKeyException
	 * @throws InvalidKeySpecException
	 */
	public void loadSecretKey(InputStream keyStream) throws IOException, InvalidKeyException, InvalidKeySpecException {
		byte[] secretKey = CryptoUtil.readInputStream(keyStream);
		this.mSecretKey = new SecretKeySpec(secretKey, algorithm);
	}

	/**
	 * Same as loadSecretKey(), only that it loads the key from a file.
	 */
	public void loadSecretKeyFromFile(String fileName) throws InvalidKeyException, InvalidKeySpecException, IOException {
		FileInputStream input = new FileInputStream(fileName);
		loadSecretKey(input);
	}

	/**
	 * @return the secret key loaded with loadSecretKey()
	 */
	SecretKey getSecretKey() {
		return mSecretKey;
	}

	/**
	 * @param encrypt
	 *            wether to return a cipher suitable for encryption or decryption
	 * @return the cipher which should be used for encryption/decryption
	 * 
	 * @throws InvalidKeyException
	 */
	Cipher getSymetricCipher(boolean encrypt) throws InvalidKeyException {
		Cipher cipher;
		try {
			cipher = Cipher.getInstance(algorithm);
			cipher.init(encrypt ? Cipher.ENCRYPT_MODE : Cipher.DECRYPT_MODE, mSecretKey);
			return cipher;
		} catch (NoSuchAlgorithmException e) {
			// Can't happen
			assert (false);
		} catch (NoSuchPaddingException e) {
			assert (false);
		}
		return null;
	}

	/**
	 * Generates a random secret key and writes it to the output stream.
	 * 
	 * @param output
	 *            the stream to which the key is written
	 * @throws IOException
	 */
	public void writeExampleKey(OutputStream output) throws IOException {
		KeyGenerator generator;
		try {
			generator = KeyGenerator.getInstance(algorithm);
			generator.init(keySize);
			SecretKey secretKey = generator.generateKey();
			output.write(secretKey.getEncoded());
			output.close();
		} catch (NoSuchAlgorithmException e) {
			// Can't happen
			assert (false);
		}
	}

	/**
	 * Same as writeExampleKeyToStream(), only that this operates on a file instead.
	 */
	public void writeExampleKeyToFile(String fileName) throws IOException {
		FileOutputStream output = new FileOutputStream(fileName);
		writeExampleKey(output);
	}
}

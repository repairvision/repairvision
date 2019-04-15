package org.sidiff.common.crypto;

import java.io.*;
import java.security.*;
import java.security.spec.*;

/**
 * A class which manages the keys used for signing and verifying signatures. A public and a private key is managed: The private key is used for signing, and the public key is used to verify the signatures. Loading the private key is optional.
 * 
 * It is a singleton.
 * 
 * @author mcguire
 * 
 * Completely untested and currently not used.
 */
@Deprecated 
public class SignatureManager {

	private static final String KEY_ALGO = "DSA";
	private static SignatureManager mInstance;
	private PublicKey mPublicKey;
	private PrivateKey mPrivateKey;

	public static SignatureManager getInstance() {
		if (mInstance == null) {
			mInstance = new SignatureManager();
		}
		return mInstance;
	}

	/**
	 * Loads the public and the private key from streams. Loading the private key is optional, if the private key stream is null only the public key will be loaded.
	 * 
	 * Signing and verifing can only happen after the keys are loaded with this function.
	 * 
	 * @param publicKeyStream
	 *            the stream which contains the public key
	 * @param privateKeyStream
	 *            the stream which contains the private key, or null
	 * 
	 * @throws IOException
	 * @throws InvalidKeySpecException
	 */
	public void loadSignatureKeys(InputStream publicKeyStream, InputStream privateKeyStream) throws IOException, InvalidKeySpecException {
		KeyFactory keyFactory;
		try {
			keyFactory = KeyFactory.getInstance(KEY_ALGO);
			if (privateKeyStream != null) {
				byte[] privateKeyBytes = CryptoUtil.readInputStream(privateKeyStream);
				mPrivateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(privateKeyBytes));
			}

			byte[] publicKeyBytes = CryptoUtil.readInputStream(publicKeyStream);
			mPublicKey = keyFactory.generatePublic(new X509EncodedKeySpec(publicKeyBytes));
		} catch (NoSuchAlgorithmException e) {
			// Can't happen
			assert (false);
		}
	}

	/**
	 * Same as loadSignatureKeys(), only that this operates on files.
	 */
	public void loadSignatureKeysFromFile(String publicKeyFilename, String privateKeyFilename) throws InvalidKeySpecException, IOException {
		InputStream privateKeyStream = null;
		if (!privateKeyFilename.isEmpty())
			privateKeyStream = new FileInputStream(privateKeyFilename);
		loadSignatureKeys(new FileInputStream(publicKeyFilename), privateKeyStream);
	}

	/**
	 * @return the public key which was loaded with loadSignatureKeys()
	 */
	PublicKey getPublicKey() {
		return mPublicKey;
	}

	/**
	 * @return the private key which was loaded with loadSignatureKeys(), or null if the private key was not loaded.
	 */
	PrivateKey getPrivateKey() {
		return mPrivateKey;
	}

	/**
	 * Generates a random keypair (public and private key), and writes it to the given output stream.
	 * 
	 * @param publicKeyStream
	 *            the stream to write the public key to
	 * @param privateKeyStream
	 *            the stream to write the private key to
	 * 
	 * @throws IOException
	 */
	public void writeExampleKeys(OutputStream publicKeyStream, OutputStream privateKeyStream) throws IOException {
		KeyPairGenerator keyGen;
		try {
			keyGen = KeyPairGenerator.getInstance(KEY_ALGO);
			keyGen.initialize(1024);
			KeyPair keyPair = keyGen.generateKeyPair();
			PrivateKey privateKey = keyPair.getPrivate();
			PublicKey publicKey = keyPair.getPublic();
			privateKeyStream.write(privateKey.getEncoded());
			publicKeyStream.write(publicKey.getEncoded());
			privateKeyStream.close();
			publicKeyStream.close();

		} catch (NoSuchAlgorithmException e) {
			// Can't happen
			assert (false);
		}
	}

	/**
	 * Same as writeExampleKeysToStreams(), only that this operates on files.
	 */
	public void writeExampleKeysToFiles(String publicKeyFilename, String privateKeyFilename) throws FileNotFoundException, IOException {
		writeExampleKeys(new FileOutputStream(publicKeyFilename), new FileOutputStream(privateKeyFilename));
	}
}

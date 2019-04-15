package org.sidiff.common.crypto;

import java.io.*;
import java.security.*;

/**
 * A class which can verify the signatures of streams and files which were signed with a Verifier.
 * 
 * @author mcguire
 * 
 */
@Deprecated
public class Verifier {

	private static final String VERIFY_ALGO = "SHA/DSA";

	/**
	 * Tests if the signature of the signature stream is a valid signature of the data in the input stream.
	 * 
	 * This uses the public key of the SignatureManager, so make sure the key is loaded!
	 * 
	 * @param streamToVerify
	 *            the data to verify
	 * @param signatureStream
	 *            the stream of the signature
	 * @return true if the signature if OK, false otherwise
	 * 
	 * @throws IOException
	 * @throws InvalidKeyException
	 */
	public boolean verify(InputStream streamToVerify, InputStream signatureStream) throws IOException, InvalidKeyException {
		Signature signature;
		try {
			signature = Signature.getInstance(VERIFY_ALGO);
			signature.initVerify(SignatureManager.getInstance().getPublicKey());

			while (true) {
				byte[] inputBuffer = new byte[1024];
				int amountRead = streamToVerify.read(inputBuffer);
				if (amountRead == -1)
					break;
				try {
					signature.update(inputBuffer, 0, amountRead);
				} catch (SignatureException e) {
					// Can't happen
					assert (false);
				}
			}
			streamToVerify.close();

			byte[] signatureBytes = CryptoUtil.readInputStream(signatureStream);
			try {
				return signature.verify(signatureBytes);
			} catch (SignatureException e) {
				return false;
			}

		} catch (NoSuchAlgorithmException e1) {
			// Can't happen
			assert (false);
			return false;
		}
	}

	/**
	 * Same as verifyStream(), only that this operates on files.
	 */
	public boolean verifyFile(String fileToVerify, String signatureFile) throws InvalidKeyException, FileNotFoundException, IOException {
		FileInputStream signatureStream;
		try {
			signatureStream = new FileInputStream(signatureFile);
		} catch (FileNotFoundException e) {
			return false;
		}
		return verify(new FileInputStream(fileToVerify), signatureStream);
	}

}

package org.sidiff.common.crypto;

import java.io.*;
import java.security.*;

/**
 * A class which can sign streams and files.
 * 
 * @author mcguire
 * 
 */
@Deprecated
public class Signer {
	private static final String SIGN_ALGO = "SHA/DSA";

	/**
	 * Calculates the signature of an input stream and writes that signature to an output stream.
	 * 
	 * The private key of the SignatureManager is used, so make sure the key is loaded!
	 * 
	 * @param streamToSign
	 *            the stream to calculate the signature of
	 * @param signatureStream
	 *            the stream to write the signature to
	 * 
	 * @throws InvalidKeyException
	 * @throws IOException
	 * @throws SignatureException
	 */
	public void sign(InputStream streamToSign, OutputStream signatureStream) throws InvalidKeyException, IOException, SignatureException {
		Signature signature;
		try {
			signature = Signature.getInstance(SIGN_ALGO);
			signature.initSign(SignatureManager.getInstance().getPrivateKey());

			while (true) {
				byte[] inputBuffer = new byte[1024];
				int amountRead = streamToSign.read(inputBuffer);
				if (amountRead == -1)
					break;
				signature.update(inputBuffer, 0, amountRead);
			}
			byte[] signatureBytes = signature.sign();
			signatureStream.write(signatureBytes);
			streamToSign.close();
			signatureStream.close();

		} catch (NoSuchAlgorithmException e) {
			// Can't happen
			assert (false);
		}
	}

	/**
	 * Same as signStream(), only that it operates on files, not streams.
	 */
	public void signFile(String fileToSign, String signatureFile) throws InvalidKeyException, SignatureException, FileNotFoundException, IOException {
		sign(new FileInputStream(fileToSign), new FileOutputStream(signatureFile));
	}

}

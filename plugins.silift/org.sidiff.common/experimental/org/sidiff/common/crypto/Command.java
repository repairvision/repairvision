package org.sidiff.common.crypto;

import java.io.*;
/**
 * Completely untested and currently not used.
 */
@Deprecated 
public class Command {

	public static void decrypt(String[] args) {
		try {
			if (args.length != 4) {
				System.out.println("Usage: decrypt <secretkeyfile> <encryptedfile> <decryptedfile>");
				return;
			}

			String secretKeyFile = args[1];
			String encryptedFile = args[2];
			String decryptedFile = args[3];

			EncryptionManager.getInstance().loadSecretKeyFromFile(secretKeyFile);
			Decrypter decrypter = new Decrypter();
			decrypter.decrypt(new FileInputStream(encryptedFile), new FileOutputStream(decryptedFile));
			System.out.println("File decryped.");
			System.out.println("Plaintext output file:" + decryptedFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void encrypt(String[] args) {
		try {
			if (args.length != 4) {
				System.out.println("Usage: encrypt <secretkeyfile> <filetoencrypt> <encryptedfile>");
				return;
			}

			String secretKeyFile = args[1];
			String fileToEncrypt = args[2];
			String encryptedFile = args[3];

			EncryptionManager.getInstance().loadSecretKeyFromFile(secretKeyFile);
			Encrypter encrypter = new Encrypter();
			encrypter.encryptFile(fileToEncrypt, encryptedFile);
			System.out.println("File encrypted.");
			System.out.println("Encrypted output file:" + encryptedFile);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void generatekeys(String[] args) {
		try {
			EncryptionManager.getInstance().writeExampleKeyToFile("secret.key");
			SignatureManager.getInstance().writeExampleKeysToFiles("public.key", "private.key");
			System.out.println("Saved example keys.");
			System.out.println("Filenames: secret.key, public.key and private.key");
		} catch (Exception e) {
			System.err.println("Unable to generate and save example keys!");
			e.printStackTrace();
		}
	}

	public static void sign(String[] args) {
		try {
			if (args.length != 5) {
				System.out.println("Usage: sign <privatekeyfile> <publickeyfile> <filetosign> <signaturefile>");
				return;
			}

			String privateKeyFile = args[1];
			String publicKeyFile = args[2];
			String fileToSign = args[3];
			String signatureFile = args[4];

			SignatureManager.getInstance().loadSignatureKeysFromFile(publicKeyFile, privateKeyFile);
			Signer signer = new Signer();
			signer.signFile(fileToSign, signatureFile);
			System.out.println("File signed.");
			System.out.println("Signature file:" + signatureFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void verify(String[] args) {
		try {
			if (args.length != 4) {
				System.out.println("Usage: verify <publickeyfile> <signedfile> <signaturefile>");
				return;
			}

			String publicKeyFile = args[1];
			String signedFile = args[2];
			String signatureFile = args[3];

			SignatureManager.getInstance().loadSignatureKeysFromFile(publicKeyFile, "");
			Verifier verifier = new Verifier();
			boolean OK = verifier.verifyFile(signedFile, signatureFile);
			if (OK)
				System.out.println("Signature for file " + signedFile + " is OK.");
			else
				System.err.println("WARNING: Signature for file " + signedFile + " is invalid!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void xmlsign(String[] args) {
		try {
			if (args.length != 7) {
				System.out.println("Usage: xmlsign <privatekeyfile> <publickeyfile> <filetosign> <xpathfile> <signatureinfofile> <signaturefile>");
				System.out.println("<xpathfile> should contain a newline separated list of XPaths which should be signed.");
				return;
			}

			String privateKeyFile = args[1];
			String publicKeyFile = args[2];
			String fileToSign = args[3];
			String xPathFile = args[4];
			String signatureInfoFile = args[5];
			String signatureFile = args[6];

			SignatureManager.getInstance().loadSignatureKeysFromFile(publicKeyFile, privateKeyFile);
			XMLSigner signer = new XMLSigner();

			FileReader fileReader = new FileReader(xPathFile);
			BufferedReader reader = new BufferedReader(fileReader);
			String xPath;
			while ((xPath = reader.readLine()) != null) {
				signer.addXPathToSign(xPath);
			}

			signer.signXMLFile(fileToSign, signatureInfoFile, signatureFile);
			System.out.println("XML file signed.");
			System.out.println("Signature info file:" + signatureInfoFile);
			System.out.println("Signature file:" + signatureFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void xmlverify(String[] args) {
		try {
			if (args.length != 5) {
				System.out.println("Usage: xmlverify <publickeyfile> <signedfile> <signatureinfofile> <signaturefile>");
				return;
			}

			String publicKeyFile = args[1];
			String signedFile = args[2];
			String signatureInfoFile = args[3];
			String signatureFile = args[4];

			SignatureManager.getInstance().loadSignatureKeysFromFile(publicKeyFile, "");
			XMLVerifier verifier = new XMLVerifier();
			boolean OK = verifier.verifyXMLFile(signedFile, signatureInfoFile, signatureFile);
			if (OK)
				System.out.println("Signature for file " + signedFile + " is OK.");
			else
				System.err.println("WARNING: Signature for file " + signedFile + " is invalid!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Usage: Command <command>");
			System.out.println("<command> is one of the following:");
			System.out.println(" decrypt      - Decrypt a file");
			System.out.println(" encrypt      - Encrypt a file");
			System.out.println(" generatekeys - Generate example keys");
			System.out.println(" sign         - Sign a file");
			System.out.println(" verify       - Verify the signature of a file");
			System.out.println(" xmlsign      - Sign parts of a XML file defined by XPaths");
			System.out.println(" xmlverify    - Verify the signature of a XML file");
			return;
		}
		if (args[0].equals("decrypt"))
			decrypt(args);
		else if (args[0].equals("encrypt"))
			encrypt(args);
		else if (args[0].equals("generatekeys"))
			generatekeys(args);
		else if (args[0].equals("sign"))
			sign(args);
		else if (args[0].equals("verify"))
			verify(args);
		else if (args[0].equals("xmlsign"))
			xmlsign(args);
		else if (args[0].equals("xmlverify"))
			xmlverify(args);
		else
			System.out.println("Unknown command:" + args[0]);
	}

}

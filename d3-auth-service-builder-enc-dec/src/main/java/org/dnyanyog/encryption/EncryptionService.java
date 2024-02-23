package org.dnyanyog.encryption;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

@Component
public class EncryptionService {

	private static final String SECRET_KEY = "5F2708070EF2F0BAB8123A81036880E4";

	private static final String ALGORITHM = "AES"; // Encryption algorithm,

	private static SecretKey secretKey;

	private static Cipher cipher;

	static {
		secretKey = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), ALGORITHM);
		try {
			cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		} catch (InvalidKeyException e) {
			e.printStackTrace();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();

		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
	}

	public String encrypt(String data) throws Exception {

		byte[] encryptedData = cipher.doFinal(data.getBytes()); // Encrypt data in to b
		return Base64.getEncoder().encodeToString(encryptedData); // Encode byte data in

	}

	public static String decrypt(String encryptedData) throws Exception {

		byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));

		return new String(decryptedData, StandardCharsets.UTF_8);// Convert decrypted d
	}

	public static SecretKey generateAesKey() {
		try {

			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(256); // Use 256-bit key size
			return keyGenerator.generateKey();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Error generating AES key", e);
		}
	}

	public static SecretKey generateAESKey() throws NoSuchAlgorithmException {
		KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
		keygenerator.init(256);

		return keygenerator.generateKey();

	}
}

//	public static String encrypt(String plainText, SecretKey key) throws Exception {
//		Cipher cipher = Cipher.getInstance("AES");
//
//		cipher.init(Cipher.ENCRYPT_MODE, key);
//
//		byte[] plainTextByte = plainText.getBytes(StandardCharsets.UTF_8);
//		byte[] encryptedByte = cipher.doFinal(plainTextByte);
//
//		String encrptedDataInString = Base64.getEncoder().encodeToString(encryptedByte);
//		return encrptedDataInString;
//
//	}
//
//	public static String decrypt(String encryptedData, SecretKey key) throws Exception {
//		Cipher cipher = Cipher.getInstance("AES");
//		cipher.init(Cipher.ENCRYPT_MODE, key);
//
//		byte[] encryptedByteArrayData = Base64.getDecoder().decode(encryptedData);
//		byte[] decryptedBytes = cipher.doFinal(encryptedByteArrayData);
//
//		return new String(decryptedBytes, StandardCharsets.UTF_8);
//
//	}

//	public static void main(String[] args) throws Exception {
//		SecretKey key = generateAESKey();
////		
//		String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
//		System.out.println(encodedKey);
//	}
//}

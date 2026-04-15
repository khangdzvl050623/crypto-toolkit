package org.example.symmetric;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.Base64;

public class DESService {

    private static final String ALGORITHM = "DES/CBC/PKCS5Padding";

    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        return keyGen.generateKey();
    }

    public static IvParameterSpec generateIV() {
        byte[] iv = new byte[8];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    public static String encrypt(String plaintext, SecretKey key, IvParameterSpec iv) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);

        byte[] encrypted = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decrypt(String ciphertext, SecretKey key, IvParameterSpec iv) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key, iv);

        byte[] decoded = Base64.getDecoder().decode(ciphertext);
        byte[] decrypted = cipher.doFinal(decoded);

        return new String(decrypted);
    }
}
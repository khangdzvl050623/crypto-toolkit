package org.example.symmetric;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;

public class AESService {

    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";

    // ================= GENERATE KEY =================
    public static SecretKey generateKey(int keySize) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(keySize); // 128 hoặc 256
        return keyGen.generateKey();
    }

    // ================= GENERATE IV =================
    public static IvParameterSpec generateIV() {
        byte[] iv = new byte[16]; // AES cần 16 bytes
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    // ================= ENCRYPT =================
    public static String encrypt(String plaintext, SecretKey key, IvParameterSpec iv) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);

        byte[] encrypted = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    // ================= DECRYPT =================
    public static String decrypt(String ciphertext, SecretKey key, IvParameterSpec iv) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key, iv);

        byte[] decoded = Base64.getDecoder().decode(ciphertext);
        byte[] decrypted = cipher.doFinal(decoded);

        return new String(decrypted);
    }
}
package hash;

import java.security.MessageDigest;

public class HashUtil {

    public static String hashMD5(String input) {
        return hash(input, "MD5");
    }

    public static String hashSHA256(String input) {
        return hash(input, "SHA-256");
    }

    private static String hash(String input, String algorithm) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            byte[] hashBytes = md.digest(input.getBytes());

            StringBuilder hexString = new StringBuilder();

            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (Exception e) {
            throw new RuntimeException("Lỗi hash");
        }
    }
}
package org.example;

import org.example.symmetric.AESService;
import org.example.symmetric.DESService;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printHeader();
            System.out.println("1. Symmetric Encryption");
            System.out.println("2. Asymmetric Encryption (RSA)");
            System.out.println("3. Hash Functions");
            System.out.println("0. Exit");
            System.out.print("👉 Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    symmetricMenu();
                    break;
                case 0:
                    System.out.println("👋 Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }

    // ================= HEADER =================
    public static void printHeader() {
        System.out.println("\n====================================");
        System.out.println("   🔐 CRYPTOGRAPHY TOOLKIT 🔐");
        System.out.println("====================================");
    }

    // ================= SYMMETRIC =================
    public static void symmetricMenu() {
        System.out.println("\n--- Symmetric Encryption ---");
        System.out.println("1. AES");
        System.out.println("2. DES");
        System.out.print("👉 Choose algorithm: ");

        int algo = sc.nextInt();
        sc.nextLine();

        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        System.out.print("👉 Choose action: ");

        int action = sc.nextInt();
        sc.nextLine();

        System.out.print("👉 Enter text: ");
        String text = sc.nextLine();

        System.out.println("1. Enter key manually");
        System.out.println("2. Generate random key");
        System.out.print("👉 Choose key option: ");
        int keyOption = sc.nextInt();
        sc.nextLine();

        try {
            switch (algo) {
                case 1:
                    handleAES(action, text, keyOption);
                    break;
                case 2:
                    handleDES(action, text, keyOption);
                    break;
                default:
                    System.out.println("❌ Invalid algorithm!");
            }
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }

        retry();
    }

    // ================= AES =================
    public static void handleAES(int action, String text, int keyOption) throws Exception {
        SecretKey key;
        IvParameterSpec iv;

        if (keyOption == 1) {
            System.out.print("👉 Enter Base64 Key: ");
            String keyStr = sc.nextLine();

            System.out.print("👉 Enter Base64 IV: ");
            String ivStr = sc.nextLine();

            key = new SecretKeySpec(Base64.getDecoder().decode(keyStr), "AES");
            iv = new IvParameterSpec(Base64.getDecoder().decode(ivStr));

        } else {
            key = AESService.generateKey(128);
            iv = AESService.generateIV();

            System.out.println("🔑 Key (Base64): " + Base64.getEncoder().encodeToString(key.getEncoded()));
            System.out.println("🧊 IV  (Base64): " + Base64.getEncoder().encodeToString(iv.getIV()));
        }

        if (action == 1) {
            String cipher = AESService.encrypt(text, key, iv);
            System.out.println("🔒 Encrypted: " + cipher);
        } else {
            String plain = AESService.decrypt(text, key, iv);
            System.out.println("🔓 Decrypted: " + plain);
        }
    }

    // ================= DES =================
    public static void handleDES(int action, String text, int keyOption) throws Exception {
        SecretKey key;
        IvParameterSpec iv;

        if (keyOption == 1) {
            System.out.print("👉 Enter Base64 Key: ");
            String keyStr = sc.nextLine();

            System.out.print("👉 Enter Base64 IV: ");
            String ivStr = sc.nextLine();

            key = new SecretKeySpec(Base64.getDecoder().decode(keyStr), "DES");
            iv = new IvParameterSpec(Base64.getDecoder().decode(ivStr));

        } else {
            key = DESService.generateKey();
            iv = DESService.generateIV();

            System.out.println("🔑 Key (Base64): " + Base64.getEncoder().encodeToString(key.getEncoded()));
            System.out.println("🧊 IV  (Base64): " + Base64.getEncoder().encodeToString(iv.getIV()));
        }

        if (action == 1) {
            String cipher = DESService.encrypt(text, key, iv);
            System.out.println("🔒 Encrypted: " + cipher);
        } else {
            String plain = DESService.decrypt(text, key, iv);
            System.out.println("🔓 Decrypted: " + plain);
        }
    }

    // ================= RETRY =================
    public static void retry() {
        System.out.println("\n1. 🔁 Try again");
        System.out.println("0. 🔙 Back to main menu");
        System.out.print("👉 Choose: ");

        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            symmetricMenu();
        }
    }
}
package org.example.symmetric;

import java.util.Scanner;

public class SymmetricCLI {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Symmetric Encryption ===");
        System.out.println("1. AES");
        System.out.println("2. DES");
        System.out.println("3. 3DES");

        System.out.print("Chon: ");
        int choice = sc.nextInt();
        sc.nextLine();

        try {
            if (choice == 1) {
                System.out.print("Nhap text: ");
                String text = sc.nextLine();

                String key = AESUtil.generateKey();
                System.out.println("Key: " + key);

                String encrypted = AESUtil.encrypt(text, key);
                System.out.println("Encrypted: " + encrypted);

                String decrypted = AESUtil.decrypt(encrypted, key);
                System.out.println("Decrypted: " + decrypted);

            } else if (choice == 2) {
                System.out.print("Nhap text: ");
                String text = sc.nextLine();

                var key = DESUtil.generateKey();

                String encrypted = DESUtil.encrypt(text, key);
                System.out.println("Encrypted: " + encrypted);

                String decrypted = DESUtil.decrypt(encrypted, key);
                System.out.println("Decrypted: " + decrypted);

            } else if (choice == 3) {
                System.out.print("Nhap text: ");
                String text = sc.nextLine();

                String key = TripleDESUtil.generateKey();
                System.out.println("Key: " + key);

                String encrypted = TripleDESUtil.encrypt(text, key);
                System.out.println("Encrypted: " + encrypted);

                String decrypted = TripleDESUtil.decrypt(encrypted, key);
                System.out.println("Decrypted: " + decrypted);
            }

        } catch (Exception e) {
            System.out.println("Loi roi!");
        }
    }
}
package org.example.asymmetric;

import java.util.Scanner;

public class AsymmetricCLI {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new AsymmetricCLI().startMenu(sc);
    }

    public void startMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n========================================");
            System.out.println(" FEATURE 2: ASYMMETRIC ENCRYPTION (RSA)");
            System.out.println("========================================");
            System.out.println("1. Generate Key Pair (RSA 2048-bit)");
            System.out.println("2. Encrypt");
            System.out.println("3. Decrypt");
            System.out.println("4. Return to Main Menu");
            System.out.print("\nSelect an option (1-4): ");
            
            String choice = scanner.nextLine();
            
            try {
                switch (choice) {
                    case "1":
                        System.out.println("\n--- KEY GENERATION ---");
                        String[] keys = RSAUtil.generateKeys();
                        System.out.println("\n[PUBLIC KEY]\n" + keys[0]);
                        System.out.println("\n[PRIVATE KEY]\n" + keys[1]);
                        System.out.println("\nNote: Please copy and save these strings to use for options 2 and 3.");
                        break;
                        
                    case "2":
                        System.out.print("\n--- ENCRYPTION ---\nEnter Plaintext: ");
                        String plaintext = scanner.nextLine();
                        System.out.print("Enter Public Key (paste Base64 string here): ");
                        String pubKeyStr = scanner.nextLine();
                        
                        String ciphertext = RSAUtil.encrypt(plaintext, pubKeyStr);
                        System.out.println("\n[CIPHERTEXT (Base64)]:\n" + ciphertext);
                        break;
                        
                    case "3":
                        System.out.print("\n--- DECRYPTION ---\nEnter Ciphertext (Base64): ");
                        String cipherStr = scanner.nextLine();
                        System.out.print("Enter Private Key (paste Base64 string here): ");
                        String privKeyStr = scanner.nextLine();
                        
                        String decryptedText = RSAUtil.decrypt(cipherStr, privKeyStr);
                        System.out.println("\n[PLAINTEXT ORIGINAL]:\n" + decryptedText);
                        break;
                        
                    case "4":
                        System.out.println("Returning to Main Menu...");
                        return;
                        
                    default:
                        System.out.println("Invalid choice! Please select from 1 to 4.");
                }
            } catch (Exception e) {
                System.out.println("\n[ERROR] Invalid input data, incorrect key, or wrong format!");
            }
        }
    }
}
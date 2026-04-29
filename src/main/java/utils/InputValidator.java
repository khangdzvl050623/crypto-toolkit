package utils;

public class InputValidator {

    public static boolean isValidInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println("❌ Không được để trống!");
            return false;
        }

        if (input.length() < 3) {
            System.out.println("❌ Phải >= 3 ký tự!");
            return false;
        }

        return true;
    }
}
import java.security.SecureRandom;
import java.util.Scanner;

public class RandomPasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();

        if (length <= 0) {
            System.out.println("Invalid input. Please enter a positive length for the password.");
            return;
        }

        boolean includeNumbers, includeLowercase, includeUppercase, includeSpecialChars;
        System.out.print("Include numbers? (true/false): ");
        includeNumbers = scanner.nextBoolean();

        System.out.print("Include lowercase letters? (true/false): ");
        includeLowercase = scanner.nextBoolean();

        System.out.print("Include uppercase letters? (true/false): ");
        includeUppercase = scanner.nextBoolean();

        System.out.print("Include special characters? (true/false): ");
        includeSpecialChars = scanner.nextBoolean();

        String generatedPassword = generateRandomPassword(length, includeNumbers, includeLowercase, includeUppercase, includeSpecialChars);
        System.out.println("Your generated password is: " + generatedPassword);

        scanner.close();
    }

    public static String generateRandomPassword(int length, boolean includeNumbers, boolean includeLowercase, boolean includeUppercase, boolean includeSpecialChars) {
        String numbers = "0123456789";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialChars = "!@#$%^&*()_-+=<>?";

        String characters = "";
        if (includeNumbers) characters += numbers;
        if (includeLowercase) characters += lowercaseLetters;
        if (includeUppercase) characters += uppercaseLetters;
        if (includeSpecialChars) characters += specialChars;

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }
}

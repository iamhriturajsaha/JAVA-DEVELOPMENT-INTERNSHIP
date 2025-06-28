import java.util.Scanner;
import java.util.Random;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Character pools
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        String special = "!@#$%^&*()-_=+<>?/";

        // Final pool of characters to build from
        StringBuilder characterPool = new StringBuilder();

        // Prompt user for password length
        System.out.print("Enter desired password length: ");
        int length = scanner.nextInt();

        // Validation
        if (length <= 0) {
            System.out.println("Password length must be greater than 0.");
            return;
        }

        // Prompt user for character options
        System.out.print("Include lowercase letters? (y/n): ");
        if (scanner.next().equalsIgnoreCase("y")) {
            characterPool.append(lower);
        }

        System.out.print("Include uppercase letters? (y/n): ");
        if (scanner.next().equalsIgnoreCase("y")) {
            characterPool.append(upper);
        }

        System.out.print("Include numbers? (y/n): ");
        if (scanner.next().equalsIgnoreCase("y")) {
            characterPool.append(digits);
        }

        System.out.print("Include special characters? (y/n): ");
        if (scanner.next().equalsIgnoreCase("y")) {
            characterPool.append(special);
        }

        // Check if at least one type selected
        if (characterPool.length() == 0) {
            System.out.println("You must select at least one character type!");
            return;
        }

        // Generate password
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }

        // Display the password
        System.out.println("Generated Password: " + password.toString());
        scanner.close();
    }
}
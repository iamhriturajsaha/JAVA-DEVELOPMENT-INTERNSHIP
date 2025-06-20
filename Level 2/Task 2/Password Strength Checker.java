import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for password input
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Analyze the password
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else hasSpecial = true;
        }

        int strengthScore = 0;
        if (password.length() >= 8) strengthScore++;
        if (hasUpper) strengthScore++;
        if (hasLower) strengthScore++;
        if (hasDigit) strengthScore++;
        if (hasSpecial) strengthScore++;

        // Provide feedback
        System.out.println("\nPassword Strength Analysis:");
        if (password.length() < 8) {
            System.out.println("- Too short (minimum 8 characters recommended)");
        }
        if (!hasUpper) {
            System.out.println("- No uppercase letters");
        }
        if (!hasLower) {
            System.out.println("- No lowercase letters");
        }
        if (!hasDigit) {
            System.out.println("- No digits");
        }
        if (!hasSpecial) {
            System.out.println("- No special characters");
        }

        System.out.print("\nOverall Strength: ");
        switch (strengthScore) {
            case 5:
                System.out.println("Very Strong 💪");
                break;
            case 4:
                System.out.println("Strong 👍");
                break;
            case 3:
                System.out.println("Moderate 👌");
                break;
            case 2:
                System.out.println("Weak ⚠️");
                break;
            default:
                System.out.println("Very Weak ❌");
        }
        scanner.close();
    }
}
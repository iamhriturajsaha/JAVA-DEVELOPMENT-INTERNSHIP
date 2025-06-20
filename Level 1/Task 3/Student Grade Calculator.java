import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for number of grades
        System.out.print("Enter the number of grades: ");
        int numGrades = scanner.nextInt();

        // Validate number of grades
        if (numGrades <= 0) {
            System.out.println("Number of grades must be greater than 0.");
            return;
        }
        double[] grades = new double[numGrades];
        double sum = 0;

        // Input each grade
        for (int i = 0; i < numGrades; i++) {
            System.out.print("Enter grade #" + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();

            // Optional: Validate if grade is between 0 and 100
            if (grades[i] < 0 || grades[i] > 100) {
                System.out.println("Invalid grade entered. Please enter grades between 0 and 100.");
                return;
            }
            sum += grades[i];
        }

        // Calculate average
        double average = sum / numGrades;

        // Display the result
        System.out.printf("The average grade is: %.2f\n", average);
        scanner.close();
    }
}
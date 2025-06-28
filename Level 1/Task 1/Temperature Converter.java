import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user for temperature value
        System.out.print("Enter the temperature value: ");
        double temperature = scanner.nextDouble();
        
        // Prompt user for unit
        System.out.print("Enter the unit (C for Celsius, F for Fahrenheit): ");
        char unit = scanner.next().toUpperCase().charAt(0);
        
        // Perform conversion
        if (unit == 'C') {
            double fahrenheit = (temperature * 9 / 5) + 32;
            System.out.printf("%.2f°C = %.2f°F\n", temperature, fahrenheit);
        } else if (unit == 'F') {
            double celsius = (temperature - 32) * 5 / 9;
            System.out.printf("%.2f°F = %.2f°C\n", temperature, celsius);
        } else {
            System.out.println("Invalid unit. Please enter 'C' or 'F'.");
        }
        scanner.close();
    }
}
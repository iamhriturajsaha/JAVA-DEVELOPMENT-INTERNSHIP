import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose an option (1 = Encrypt, 2 = Decrypt): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter input file name (e.g., input.txt): ");
        String inputFileName = scanner.nextLine();

        System.out.print("Enter output file name (e.g., output.txt): ");
        String outputFileName = scanner.nextLine();

        int key = 3;

        try {
            File inputFile = new File(inputFileName);
            Scanner fileScanner = new Scanner(inputFile);
            FileWriter writer = new FileWriter(outputFileName);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String processedLine = "";

                for (char ch : line.toCharArray()) {
                    if (choice == 1) {
                        processedLine += (char)(ch + key);
                    } else if (choice == 2) {
                        processedLine += (char)(ch - key);
                    } else {
                        System.out.println("Invalid choice.");
                        return;
                    }
                }

                writer.write(processedLine + "\n");
            }

            fileScanner.close();
            writer.close();

            System.out.println("Operation completed. Output saved to: " + outputFileName);

        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file.");
        }
        scanner.close();
    }
}
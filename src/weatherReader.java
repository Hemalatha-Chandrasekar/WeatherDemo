import java.io.*;
import java.util.Scanner;

public class weatherReader {
    // Method to check if the file exists
    public void checkFileExists(File file) throws WeatherFileNotFoundException {
        if (!file.exists()) {
            throw new WeatherFileNotFoundException("Weather file not found!");
        }
    }

    // Method to read file using Scanner
    public void readFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
            e.printStackTrace();
        }
    }

    // Method to process the weather file
    public void processWeatherFile(String filePath) {
        File file = new File(filePath);
        try {
            checkFileExists(file);
            System.out.println("Reading weather data from file:");
            readFile(file);
        } catch (WeatherFileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to read file as bytes
    public void readFileAsBytes(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            int byteContent;
            while ((byteContent = fis.read()) != -1) {
                System.out.print((char) byteContent);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Error reading file as bytes.");
            e.printStackTrace();
        }
    }

    // Method to write content to a file as bytes
    public void writeFileAsBytes(String filePath, String content) {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(content.getBytes());
            System.out.println("Content written to file successfully as bytes.");
        } catch (IOException e) {
            System.out.println("Error writing file as bytes.");
            e.printStackTrace();
        }
    }

    // Method to get file name from user
    public String getFileNameFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name (with path): ");
        return scanner.nextLine();
    }
}





import java.io.File;

public class Main {
    public static void main(String[] args) throws WeatherFileNotFoundException {
        String defaultFilePath = "weather.txt";

        weatherReader weatherReader = new weatherReader();
        // Step 1: Get file path from user
        String filePath = weatherReader.getFileNameFromUser();

        // Step 2: Check if the file exists
        File file = new File(filePath);
        weatherReader.checkFileExists(file);

        // Step 3: Process the weather file (read it)
        weatherReader.processWeatherFile(filePath);

        // Step 4: Read the file as bytes and print it
        System.out.println("\nReading file as bytes:");
        weatherReader.readFileAsBytes(filePath);

        // Step 5: Write new content to the file as bytes
        String newFilePath = "new_weather.txt";
        String newContent = "Saturday: Foggy\nSunday: Rainy\n";
        weatherReader.writeFileAsBytes(newFilePath, newContent);

        // Step 6: Read the new file as bytes
        System.out.println("\nReading new file as bytes:");
        weatherReader.readFileAsBytes(newFilePath);

    }

}


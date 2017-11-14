package snippet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class ReadFile {
    public static void readFile() throws FileNotFoundException {
        String curPath = Paths.get(".").toAbsolutePath().normalize().toString();
        String jsonFilePath = Paths.get(curPath, "src/main/resources/test.json").toString();

        try (Stream<String> stream = Files.lines(Paths.get(jsonFilePath))) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile();
    }
}

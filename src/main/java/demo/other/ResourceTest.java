package demo.other;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by jingsz on 4/12/17.
 */

public class ResourceTest {
    void test() {
        StringBuilder result = new StringBuilder("");
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("test.txt").getFile());
        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(result.toString());


    }
    public static void main(String args[]) {
        ResourceTest rt = new ResourceTest();
        rt.test();
    }
}

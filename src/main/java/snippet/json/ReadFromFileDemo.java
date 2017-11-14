package snippet.json;


import java.io.*;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;


import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class ReadFromFileDemo {

    public static void readFile() throws FileNotFoundException {
        String curPath = Paths.get(".").toAbsolutePath().normalize().toString();
        String jsonFilePath = Paths.get(curPath, "src/main/resources/test.json").toString();
        try (Stream<String> stream = Files.lines(Paths.get(jsonFilePath))) {

            stream.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void demo2() throws FileNotFoundException {
        String curPath = Paths.get(".").toAbsolutePath().normalize().toString();
        String jsonFilePath = Paths.get(curPath, "src/main/resources/test.json").toString();
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(jsonFilePath));

            JSONObject jsonObject = (JSONObject) obj;

            // String name = (String) jsonObject.get("Name");
            // String author = (String) jsonObject.get("Author");
            // JSONArray companyList = (JSONArray) jsonObject.get("d1");
            JSONObject companyList = (JSONObject) jsonObject.get("d1");

            // System.out.println("Name: " + name);
            // System.out.println("Author: " + author);
            // System.out.println("\nCompany List:");
            // Iterator<String> iterator = companyList.iterator();
            // while (iterator.hasNext()) {
            //     System.out.println(iterator.next());
            // }
            companyList.forEach((k,v)->System.out.println("table : " + k + " fields: " + v));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException{
        // readFile();
        demo2();

    }
}

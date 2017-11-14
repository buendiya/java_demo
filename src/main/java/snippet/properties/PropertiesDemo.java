package snippet.properties;

// http://www.baeldung.com/java-properties

import java.io.*;
import java.util.Properties;
import java.nio.file.Paths;
import java.nio.file.Path;



public class PropertiesDemo {
    Properties loadFromFile() throws IOException{
        String curPath = Paths.get(".").toAbsolutePath().normalize().toString();

        String appConfigPath = Paths.get(curPath, "src/main/resources/app.properties").toString();

        Properties appProps = new Properties();
        appProps.load(new FileInputStream(appConfigPath));
        return appProps;
    }

    Properties loadFromXMLFile() throws IOException{
        String curPath = Paths.get(".").toAbsolutePath().normalize().toString();
        String iconConfigPath = Paths.get(curPath, "src/main/resources/icons.xml").toString();
        Properties iconProps = new Properties();
        iconProps.loadFromXML(new FileInputStream(iconConfigPath));
        return iconProps;
    }

    void getPropertyDemo() throws IOException{
        Properties appProps = loadFromFile();
        String appVersion = appProps.getProperty("version");
        String appName = appProps.getProperty("name", "defaultName");
        String appGroup = appProps.getProperty("group", "baeldung");
        String appDownloadAddr = appProps.getProperty("downloadAddr");
        System.out.println(appVersion);
        System.out.println(appName);
        System.out.println(appGroup);
        System.out.println(appDownloadAddr);

        Properties iconProps = loadFromXMLFile();
        System.out.println(iconProps.getProperty("fileIcon"));
    }

    public static void main(String[] args) throws IOException{
        PropertiesDemo demo = new PropertiesDemo();
        demo.getPropertyDemo();

    }

}

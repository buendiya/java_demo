package snippet.resource;


import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;


/*
如下可指定app.conf property，代码里通过 System.getProperty 获取
java -Dapp.conf=/Users/jingsz/IdeaProjects/demo/target/demo-1.0-SNAPSHOT-dist/conf/app.properties \
-cp lib/demo-1.0-SNAPSHOT.jar snippet.resource.ResourceDemo

注意在pom.xml里要配置 maven-jar-plugin 的exclude，否则生成jar文件时会把app.properties也打包进jar文件.
 */


public class ResourceDemo {

    void demo1() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL url = classLoader.getResource("");
        String rootPath = url.getPath();
        System.out.println(rootPath);
    }

    void demo2() throws IOException{
        String conf = System.getProperty("app.conf", "classpath:app.properties");

        Properties properties = new Properties();
        if (conf.startsWith("classpath")) {
            conf = conf.replace("classpath:", "");
            properties.load(ResourceDemo.class.getClassLoader().getResourceAsStream(conf));
        } else {
            properties.load(new FileInputStream(conf));
        }
        System.out.println(properties.getProperty("version"));
    }

    public static void main(String[] args) throws IOException{
        ResourceDemo demo = new ResourceDemo();
        demo.demo1();
        demo.demo2();
    }
}

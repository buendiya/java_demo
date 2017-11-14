package snippet.logging;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;

public class Demo1{

    final static Logger logger = Logger.getLogger(Demo1.class);

    public static void config() {
        BasicConfigurator.configure();

        String log4jConfigFile = System.getProperty("user.dir")
                + File.separator + "log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);
    }

    private void runMe(String parameter){
        if(logger.isDebugEnabled()){
            logger.debug("This is debug : " + parameter);
        }

        if(logger.isInfoEnabled()){
            logger.info("This is info : " + parameter);
        }

        logger.warn("This is warn : " + parameter);
        logger.error("This is error : " + parameter);
        logger.fatal("This is fatal : " + parameter);

    }

    public static void main(String[] args) {
        Demo1 obj = new Demo1();
        obj.runMe("mkyong");
    }


}

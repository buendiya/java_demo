package snippet.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;


public class LogbackDemo {
    protected final static Logger logger = LoggerFactory.getLogger(LogbackDemo.class);
    protected final static Logger rootLogger = LoggerFactory.getLogger("root");

    public static void demo1() {
        logger.info("hello world");
    }

    public static void rootDdemo() {
        rootLogger.info("hello world");
        rootLogger.info("hello {} {}", "world", "w");
        rootLogger.info("hello %s", "world");
    }


    public static void MDCDemo() {
        logger.info("hello world");

        MDC.put("destination", "test");

        logger.info("hello world");

        MDC.remove("destination");

        logger.info("hello world");

    }

    public static void main(String[] args) {
        rootDdemo();
    }
}

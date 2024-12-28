package testCaces;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jExample {
    private static final Logger logger = LogManager.getLogger(Log4jExample.class);

    public static void main(String[] args) {
        logger.info("This is an INFO log message.");
        logger.debug("This is a DEBUG log message.");
        logger.error("This is an ERROR log message.");
    }
}

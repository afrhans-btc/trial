import java.io.IOException;
import java.util.logging.*;

public class LogConfig {

    public static void setupLogger() {
        Logger logger = Logger.getLogger("");

        // Remove default console handlers
        for (Handler handler : logger.getHandlers()) {
            logger.removeHandler(handler);
        }

        try {
            // Create file handler
            FileHandler fileHandler = new FileHandler("inventory.log", true);
            fileHandler.setFormatter(new SimpleFormatter());

            logger.addHandler(fileHandler);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


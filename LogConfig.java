import java.io.IOException;
import java.util.logging.*;

public class LogConfig {

    public static void setupLogger() {
        Logger logger = Logger.getLogger("");

        
        for (Handler handler : logger.getHandlers()) {
            logger.removeHandler(handler);
        }

        try {
            
            FileHandler fileHandler = new FileHandler("inventory.log", true);
            fileHandler.setFormatter(new SimpleFormatter());

            logger.addHandler(fileHandler);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


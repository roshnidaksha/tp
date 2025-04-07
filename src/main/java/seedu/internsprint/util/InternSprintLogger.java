package seedu.internsprint.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class InternSprintLogger {
    private static Logger rootLogger;
    private static final String FILE_PATH = "./log/InternSprint.log";
    private static boolean isConfigured = false;

    /**
     * Sets up the root logger by removing default handlers and adding custom console and file handlers.
     * This method orchestrates the overall configuration while delegating details to helper methods.
     */
    private static void setUpLogger() {
        if (isConfigured) {
            return;
        }
        rootLogger = Logger.getLogger("");
        removeDefaultHandlers(rootLogger);
        configureConsoleHandler(rootLogger);
        configureFileHandler(rootLogger);
        isConfigured = true;
    }

    /**
     * Removes any default handlers from the given logger to avoid duplicate logs
     *
     * @param logger the logger from which to remove handlers
     */
    private static void removeDefaultHandlers(Logger logger) {
        for (var handler : rootLogger.getHandlers()) {
            rootLogger.removeHandler(handler);
        }
    }

    /**
     * Configures and adds a ConsoleHandler to the given logger.
     *
     * @param logger the logger to which the ConsoleHandler will be added
     */
    private static void configureConsoleHandler(Logger logger) {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.OFF);
        consoleHandler.setFormatter(new SimpleFormatter());
        rootLogger.addHandler(consoleHandler);
    }

    /**
     * Configures and adds a FileHandler to the given logger.
     * This method ensures that the log file and its parent directories exist.
     *
     * @param logger the logger to which the FileHandler will be added.
     */
    private static void configureFileHandler(Logger logger) {
        try {
            File file = new File(FILE_PATH);

            if (!file.exists()) {
                boolean dirCreated = file.getParentFile().mkdirs();
                boolean fileCreated = file.createNewFile();

                if (!fileCreated || !dirCreated) {
                    throw new FileNotFoundException();
                }
            }

            FileHandler fileHandler = new FileHandler(FILE_PATH, true);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new SimpleFormatter());
            rootLogger.addHandler(fileHandler);
        } catch (IOException e) {
            rootLogger.log(Level.SEVERE, "Unable to configure logging", e);
        }
    }

    /**
     * Returns the configured root logger
     *
     * @return the root Logger instance
     */
    public static Logger getLogger() {
        if (rootLogger == null) {
            setUpLogger();
        }
        return rootLogger;
    }
}

package utils;

import org.testng.Reporter;

/**
 * Utility class for logging messages.
 */
public final class LoggerUtil {

    private LoggerUtil() {
        // Prevent instantiation.
    }

    /** Logs a message to the TestNG reporter. */
    public static void log(String message) {
        Reporter.log(message, true);
    }
}

package utils;

import com.github.javafaker.Faker;

/**
 * Utility class for generating random test data.
 */
public final class FakerUtils {

    private static final Faker FAKER = new Faker();

    private FakerUtils() {
        // Prevent instantiation.
    }

    /** Returns a randomly generated full name. */
    public static String randomName() {
        return FAKER.name().fullName();
    }
}

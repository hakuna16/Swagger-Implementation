package com.rituj.swaggerImpl.common;

import org.springframework.util.Assert;

import java.util.UUID;

/**
 * This class can be use to generate document id for given class type.
 *
 * @author anishrajankurian
 */
public final class DocumentIdGenerator {

    /**
     * Generates a random unique id for given class type.
     * The simple name of the class is concatenated with a random UUID to generate the unique document id.
     * Format : <quote>class name(upper case)_{@link UUID#randomUUID()}</quote>.
     *
     * @param type {@link Class} instance of the class for which document id is to be generated
     * @param <T> type of the class for which the document id is to be generated
     * @return a unique document id
     * @throws IllegalArgumentException if given type is null
     */
    public static <T> String generateRandomUniqueId(final Class<T> type) {
        Assert.notNull(type, "Cannot generate document id for null class type!");
        return String.format("%s_%s", type.getSimpleName().toUpperCase(), UUID.randomUUID().toString().replaceAll("-", ""));
    }
}

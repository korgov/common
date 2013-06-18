package ru.korgov.util;

/**
 * Author: Kirill Korgov (korgov@korgov.ru)
 * Date: 13.05.13 0:54
 */
public class Parsers {
    private Parsers() {
    }

    public static Long parseLong(final String longAsStr, final Long def) {
        try {
            return Long.parseLong(longAsStr);
        } catch (NumberFormatException ignored) {
            return def;
        }
    }

    public static Long parseLong(final String longAsStr) {
        return parseLong(longAsStr, null);
    }
}

package ru.korgov.util;

import org.jetbrains.annotations.Nullable;
import ru.korgov.util.io.IOUtils;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Author: Kirill Korgov (kirill@korgov.ru)
 * Date: 12/18/11
 */
public class UrlUtils {

    private UrlUtils() {
    }

    public static String sendGetRequest(final String url) throws IOException {
        final URLConnection urlConnection = new URL(url).openConnection();
        return read(urlConnection);
    }

    public static String sendPostRequest(final String url, final String data) throws IOException {
        return sendPostRequest(url, data, null);
    }

    public static String sendPostRequest(final String url, final String data, final @Nullable String contentType) throws IOException {
        final URLConnection urlConnection = createPostConnection(url);
        if (contentType != null) {
            urlConnection.setRequestProperty("Content-Type", contentType);
        }
        write(urlConnection, data);
        return read(urlConnection);
    }

    public static byte[] sendPostRequestForBytes(final String url, final String data, final @Nullable String contentType) throws IOException {
        final URLConnection urlConnection = createPostConnection(url);
        if (contentType != null) {
            urlConnection.setRequestProperty("Content-Type", contentType);
        }
        write(urlConnection, data);
        return readBytes(urlConnection);
    }

    private static byte[] readBytes(final URLConnection urlConnection) throws IOException {
        return IOUtils.readBytes(urlConnection.getInputStream());
    }

    public static URLConnection createPostConnection(final String url) throws IOException {
        final URLConnection urlConnection = new URL(url).openConnection();
        urlConnection.setDoOutput(true);
        return urlConnection;
    }

    public static void write(final URLConnection urlConnection, final String data) throws IOException {
        IOUtils.write(urlConnection.getOutputStream(), data);
    }

    public static String read(final URLConnection urlConnection) throws IOException {
        return IOUtils.read(urlConnection.getInputStream());
    }

}

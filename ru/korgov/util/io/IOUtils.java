package ru.korgov.util.io;

import java.io.*;

/**
 * Author: Kirill Korgov (kirill@korgov.ru)
 * Date: 29.12.11
 */
public class IOUtils {
    private IOUtils() {
    }

    public static String readFile(final String filename) throws IOException {
        return read(new FileInputStream(filename));
    }

    public static void writeFile(final String filename, final String data) throws IOException {
        write(new FileOutputStream(filename), data);
    }

    public static void appendToFile(final String filename, final String data) throws IOException {
        write(new FileOutputStream(filename, true), data);
    }

    public static void write(final OutputStream outputStream, final String data) throws IOException {
        write(getWriter(outputStream), data, true);
    }

    public static void write(final Writer writer, final String data, final boolean closeAfterWrite) throws IOException {
        writer.write(data);
        if (closeAfterWrite) {
            writer.close();
        }
    }

    public static String read(final InputStream inputStream) throws IOException {
        return read(new BufferedReader(new InputStreamReader(inputStream, "UTF-8")), true);
    }

    public static byte[] readBytes(final InputStream is) throws IOException {
        final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        final byte[] data = new byte[16384];
        while ((nRead = is.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        buffer.flush();
        return buffer.toByteArray();
    }

    public static String read(final BufferedReader bufferedReader, final boolean closeAfterRead) throws IOException {
        final StringBuilder result = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            result.append(line);
        }
        if (closeAfterRead) {
            bufferedReader.close();
        }
        return result.toString();
    }

    public static Writer getWriter(final OutputStream outputStream) throws FileNotFoundException {
        return new BufferedWriter(new OutputStreamWriter(outputStream));
    }

    public static Writer getWriter(final String filename) throws FileNotFoundException {
        return getWriter(new FileOutputStream(filename));
    }


}

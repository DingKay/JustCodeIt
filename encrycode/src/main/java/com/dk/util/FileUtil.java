package com.dk.util;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @author Kay
 */
public class FileUtil {
    /**
     * 读取文件以字符串的形式返回
     *
     * @param filePath 文件路径
     * @return String
     */
    public static String readFileString(String filePath) throws IOException {
        File file;
        if ((file = (File) checkFile(filePath)) == null) {
            return "";
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }

    /**
     * 读取文件以字符串的形式返回
     *
     * @param filePath 文件路径
     * @param charset  文件编码
     * @return String
     */
    public static String readFileString(String filePath, Charset charset) throws IOException {
        File file;
        if ((file = (File) checkFile(filePath)) == null) {
            return "";
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }

    private static Object checkFile(String filePath) {
        if (filePath == null || filePath.length() == 0) {
            return null;
        }

        File file = new File(filePath);
        if (!file.exists() || !file.isFile() || file.length() > Integer.MAX_VALUE) {
            return null;
        }
        return file;
    }

    public static byte[] readFileByteArr(String filePath) throws IOException {
        File file;
        if ((file = (File) checkFile(filePath)) == null) {
            return new byte[]{};
        }

        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream((int) file.length());

        int bufferSize = 1024;
        byte[] buffer = new byte [bufferSize];
        int len;
        while ((len = inputStream.read(buffer, 0, bufferSize)) != -1) {
            outputStream.write(buffer, 0 , len);
        }
        return outputStream.toByteArray();
    }
}

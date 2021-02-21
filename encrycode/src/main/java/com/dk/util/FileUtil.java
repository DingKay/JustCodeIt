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
        if (filePath == null || filePath.length() == 0) {
            return "";
        }

        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
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
     * @param charset 文件编码
     * @return String
     */
    public static String readFileString(String filePath, Charset charset) throws IOException {
        if (filePath == null || filePath.length() == 0) {
            return "";
        }

        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
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
}

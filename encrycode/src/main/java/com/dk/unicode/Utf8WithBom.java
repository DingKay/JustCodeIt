package com.dk.unicode;

import com.dk.util.DigitUtil;
import com.dk.util.FileUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author Kay
 */
public class Utf8WithBom {
    public static void main(String[] args) throws IOException {
        String fileStringWithCharset = FileUtil.readFileString("C:\\Users\\Kay\\Desktop\\UTF8WithBOM.txt",
                StandardCharsets.UTF_8);
        System.out.println("fileStringWithCharset = " + fileStringWithCharset);
        char[] charArrayWithCharset = fileStringWithCharset.toCharArray();
        String hexadecimalWithCharset = DigitUtil.decimalArrayToHexadecimal(charArrayWithCharset);
        System.out.println("hexadecimalWithCharset = " + hexadecimalWithCharset);

        String fileString = FileUtil.readFileString("C:\\Users\\Kay\\Desktop\\UTF8WithBOM.txt");
        System.out.println("fileString = " + fileString);
        char[] charArray = fileString.toCharArray();
        String hexadecimal = DigitUtil.decimalArrayToHexadecimal(charArray);
        System.out.println("hexadecimal = " + hexadecimal);

        for (int i = 0; i < charArray.length; i++) {
            System.out.print("charArray = " + Integer.toHexString(charArray[i]) + " ");
        }
    }
}

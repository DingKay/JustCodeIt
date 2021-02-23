package com.dk.unicode;

import com.dk.util.DigitUtil;
import com.dk.util.FileUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author Kay
 */
public class BigEndian {
    public static void main(String[] args) throws IOException {
        String fileStringWithCharset = FileUtil.readFileString("C:\\Users\\Kay\\Desktop\\BigEndian.txt",
                StandardCharsets.UTF_16BE);
        System.out.println("fileStringWithCharset = " + fileStringWithCharset);
        char[] charArrayWithCharset = fileStringWithCharset.toCharArray();
        String hexadecimalWithCharset = DigitUtil.decimalArrayToHexadecimal(charArrayWithCharset);
        System.out.println("hexadecimalWithCharset = " + hexadecimalWithCharset);

        String fileString = FileUtil.readFileString("C:\\Users\\Kay\\Desktop\\BigEndian.txt");
        System.out.println("fileString = " + fileString);
        char[] charArray = fileString.toCharArray();
        String hexadecimal = DigitUtil.decimalArrayToHexadecimal(charArray);
        System.out.println("hexadecimal = " + hexadecimal);

        for (int i = 0; i < charArray.length; i++) {
            System.out.print("charArray = " + Integer.toHexString(charArray[i]) + " ");
        }

        byte[] bytes = FileUtil.readFileByteArr("C:\\Users\\Kay\\Desktop\\BigEndian.txt");
        String arrToHexadecimal = DigitUtil.byteArrToHexadecimal(bytes);
        System.out.println("\narrToHexadecimal = " + arrToHexadecimal);
    }
}

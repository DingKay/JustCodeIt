package com.dk.util;

/**
 * @author Kay
 */
public class DigitUtil {
    /**
     * hexadecimal char mapping
     */
    private static char[] hexCharArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String decimalArrayToHexadecimal(char[] decimalArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < decimalArr.length; i++) {
            StringBuilder recursion = new StringBuilder(recursionIntegerToHexadecimal(decimalArr[i]));
            sb.append(recursion.reverse());
        }
        return sb.toString();
    }

    private static String recursionIntegerToHexadecimal(int decimalChar) {
        if (decimalChar == 0) {
            return "";
        }
        return hexCharArr[decimalChar & 0xf] + recursionIntegerToHexadecimal(decimalChar >> 4);
    }

    public static String byteArrToHexadecimal(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] > 0 && bytes[i] < 16) {
                sb.append("0");
            } else {
                sb.append(hexCharArr[(bytes[i] >> 4) & 0xf]);
            }
            sb.append(hexCharArr[bytes[i] & 0xf]);
        }
        return sb.toString();
    }
}

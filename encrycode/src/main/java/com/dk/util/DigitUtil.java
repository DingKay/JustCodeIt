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
            StringBuilder recursion = new StringBuilder(recursionToHexadecimal(decimalArr[i]));
            sb.append(recursion.reverse());
        }
        return sb.toString();
    }

    private static String recursionToHexadecimal(int decimalChar) {
        if (decimalChar == 0) {
            return "";
        }
        return hexCharArr[decimalChar & 0xf] + recursionToHexadecimal(decimalChar >> 4);
    }
}

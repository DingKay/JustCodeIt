package com.dk.encode;

import com.dk.constant.Constant;

import java.util.Scanner;

/**
 * @author DingKay
 */
public class UnicodeZeroWidth {

    /**
     * use unicode zero width char to encode encryption text string and hiding in another garbled string
     *
     * @param text   to be encode string
     * @param garble encoded string hiding in garble string
     * @return String
     */
    public static String encodeUnicodeString(String text, String garble) {
        if (null == text || text.length() < 1 || null == garble || garble.length() < 1) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        double tmp;
        int v = Double.isNaN(tmp = Math.random() * (garble.length() - 1)) ? 0 : (int) tmp;
        sb.append(garble, 0, v);

        for (int aChar : text.toCharArray()) {
            String binaryStr = Integer.toBinaryString(aChar);
            for (char subChar : binaryStr.toCharArray()) {
                if (subChar == Constant.ZERO) {
                    sb.append(Constant.UNICODE_MIRROR_ZERO);
                } else {
                    sb.append(Constant.UNICODE_MIRROR_ONE);
                }
            }
            sb.append(Constant.UNICODE_MIRROR_SEGMENT);
        }
        sb.append(garble, v, garble.length());
        return sb.toString();
    }

    /**
     * decode unicode zero width char encryption
     *
     * @param decodeStr encoded string to be decode
     * @return String
     */
    public static String decodeUnicodeString(String decodeStr) {
        if (null == decodeStr || decodeStr.length() < 1) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        String[] split = decodeStr.split(String.valueOf(Constant.UNICODE_MIRROR_SEGMENT));
        for (String subStr : split) {
            char[] charArray = subStr.toCharArray();
            StringBuilder tmpBinary = new StringBuilder();
            for (char aChar : charArray) {
                switch (aChar) {
                    case Constant.UNICODE_MIRROR_ZERO:
                        tmpBinary.append("0");
                        break;
                    case Constant.UNICODE_MIRROR_ONE:
                        tmpBinary.append("1");
                        break;
                    default:
                        break;
                }
            }
            if (tmpBinary.length() < 1) {
                continue;
            }
            int parseInt = Integer.parseInt(tmpBinary.toString(), 2);
            sb.append((char) parseInt);
        }
        return sb.toString();
    }

    /**
     * decode unicode zero width char encryption
     *
     * @param decodeStr encoded string to be decode
     * @param one custom padding unicode zero width char mirror binary one
     * @param zero custom padding unicode zero width char mirror binary zero
     * @param segment custom setting unicode zero width char split string
     * @return String
     */
    public static String decodeUnicodeString(String decodeStr, char zero, char one, char segment) {
        if (null == decodeStr || decodeStr.length() < 1) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        String[] split = decodeStr.split(String.valueOf(segment));
        for (String subStr : split) {
            char[] charArray = subStr.toCharArray();
            StringBuilder tmpBinary = new StringBuilder();
            for (char aChar : charArray) {
                if (aChar == zero) {
                    tmpBinary.append("0");
                } else if (aChar == one) {
                    tmpBinary.append("1");
                }
            }
            if (tmpBinary.length() < 1) {
                continue;
            }
            int parseInt = Integer.parseInt(tmpBinary.toString(), 2);
            sb.append((char) parseInt);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String text = "我偷偷藏起来的秘密啊~!";
        String garble = "嘿嘿嘿嘿嘿嘿嘿嘿";
        String encodeUnicodeString = UnicodeZeroWidth.encodeUnicodeString(text, garble);

        System.out.println(encodeUnicodeString);
        System.out.println(decodeUnicodeString(encodeUnicodeString));

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String nextLine = scanner.nextLine();
            System.out.println(decodeUnicodeString(nextLine, '\u200B', '\u200C', '\uFEFF'));
        }
    }
}

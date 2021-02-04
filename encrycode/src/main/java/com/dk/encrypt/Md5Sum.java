package com.dk.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author DingKay
 */
public class Md5Sum {

    private static char[] hexCharArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * encryption md5sum value
     *
     * @param text some string need encrypt
     * @return String
     */
    public static String md5SumEncrypt(String text) throws NoSuchAlgorithmException {
        if (null == text || text.length() == 0) {
            return "";
        }

        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(text.getBytes());
        byte[] digest = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte v : digest) {
            if (v >= 0 && v < 16) {
                sb.append("0");
            } else {
                sb.append(hexCharArr[(v >> 4) & 0xf]);
            }
            sb.append(hexCharArr[v & 0xf]);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        // 023b3820611f130cb6ee0c86a784d0fa
        System.out.println(md5SumEncrypt("我是密文"));
    }
}

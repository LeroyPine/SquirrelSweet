package com.squirrel.java.util;

/**
 * @author luobaosong
 * @date 2023-12-14 11:40
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Utils {

    public static String sha256(String input) {
        try {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = sha256.digest(input.getBytes());

            // Convert the byte array to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = String.format("%02x", b);
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Handle exception appropriately
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String input = "Hello, SHA-256!111";
        String sha256Hash = sha256(input);
        System.out.println("SHA-256 Hash: " + sha256Hash);

        //d0e8b8f11c98f369016eb2ed3c541e1f01382f9d5b3104c9ffd06b6175a46271
    }
}

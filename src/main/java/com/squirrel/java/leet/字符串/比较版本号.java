package com.squirrel.java.leet.字符串;

public class 比较版本号 {

    public int compareVersion(String version1, String version2) {

        String[] word1 = version1.split("\\.");
        String[] word2 = version2.split("\\.");

        for (int i = 0; i < word1.length || i< word2.length; i++) {

            int x = 0;
            int y = 0;

            if (i<word1.length){
                x = Integer.parseInt(word1[i]);
            }

            if (i < word2.length){
                y = Integer.parseInt(word2[i]);
            }

            if (x < y){
                return -1;
            }
            if (x >y){
                return 1;
            }
        }
        return 0;
    }
}

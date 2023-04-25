package com.squirrel.java.algorithm.design;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseStr {

    public  String reverseStr(String str) {
        int right = str.length() - 1;
        StringBuilder stringBuilder = new StringBuilder();
        while (right >= 0) {
            stringBuilder.append(str.charAt(right));
            right--;
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        Short nu = 2;
        int a = 2;

        System.out.println(nu==a);


    }
}

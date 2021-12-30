package com.squirrel.java.acode;

public class Reverse {


    public static void main(String[] args) {

        String str = "abcssasgfqwr";
        int len = str.length();
        StringBuilder result = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            Character temp = str.charAt(i);
            result.append(temp);
        }
        System.out.println(result.toString());
    }


    public String generateClass(String param,String type){

        System.out.println("private "+type+"  "+param+"");
        return "";
    }

}

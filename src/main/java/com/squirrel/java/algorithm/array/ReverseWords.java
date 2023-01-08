package com.squirrel.java.algorithm.array;


public class ReverseWords {

    public static void main(String[] args) {
        String str = " the  sky is blue";
        ReverseWords re = new ReverseWords();
        String s = re.reverseWords(str);
        System.out.println(s);
    }

    public String reverseWords(String s) {
        // 格式化字符 去除前后的空格
        StringBuilder sb = new StringBuilder();
        int length = s.length();

        for (int i = 0; i < length; i++) {
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            } else if (!sb.toString().isEmpty() && sb.charAt(sb.length() - 1) != ' ') {
                sb.append(' ');
            }
        }
        if (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        char[] chars = sb.toString().toCharArray();
        System.out.println(chars);
        // 反转字符
        reverseChar(chars, 0, chars.length - 1);

        // 单独反转每个单词
        for (int i = 0; i < chars.length; ) {
            for (int j = i; j < chars.length; j++) {
                if (j + 1 == chars.length || chars[j + 1] == ' ') {
                    reverseChar(chars, i, j);
                    i = j + 2;
                    break;
                }
            }
        }
        return new String(chars);
    }

    private void reverseChar(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

    }
}


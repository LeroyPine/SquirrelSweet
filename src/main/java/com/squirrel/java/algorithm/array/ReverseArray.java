package com.squirrel.java.algorithm.array;

import lombok.extern.slf4j.Slf4j;

/**
 * 反向数组
 *
 * @author luobaosong
 * @date 2022/11/4 15:05
 * @description
 **/
@Slf4j
public class ReverseArray {

    /**
     * 反向字符串
     *
     * @param s 年代
     * @return {@link char[]}
     */
    public char[] reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return new char[0];
        }
        // 快慢指针 相互交换
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        return s;
    }


    /**
     * 判断是否是回文串
     *
     * @param s 年代
     * @return boolean
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    /**
     * 最长回文的回文子串
     *
     * @param s 年代
     * @return {@link String}
     */
    public String longestPalindrome(String s) {
        /*
         * 从中心向两边扩展,获取最大值
         * 会存在奇偶两种情况
         * 如果字符串是奇数,那么从当前节点向两边扩散即可
         * 如果字符串是偶数,那么从以两个节点向两边扩散即可
         */
        String palindromeStr = "";
        int length = s.length();
        for (int i = 0; i < length; i++) {
            String res1 = palindrome(s, i, i);
            String res2 = palindrome(s, i, i + 1);
            palindromeStr = palindromeStr.length() > res1.length() ? palindromeStr : res1;
            palindromeStr = palindromeStr.length() > res2.length() ? palindromeStr : res2;
        }
        return palindromeStr;
    }


    public String palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }


    public static void main(String[] args) {
        ReverseArray reverseArray = new ReverseArray();
        char[] chars = ArrayConstant.STRING_ARRAY;
        char[] result = reverseArray.reverseString(chars);
        log.info("result:{}", result);

        boolean palindrome = reverseArray.isPalindrome(ArrayConstant.PALINDROME);
        log.info("str:{},isPalindrome:{}", ArrayConstant.PALINDROME, palindrome);

        String res = reverseArray.longestPalindrome(ArrayConstant.PALINDROME);
        log.info("longRes:{}", res);

    }
}

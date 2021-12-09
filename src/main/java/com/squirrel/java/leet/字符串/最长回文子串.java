package com.squirrel.java.leet.字符串;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author luobs
 * @version 1.0
 * @date Created in 2021年09月23日 15:23
 * @since 1.0
 */
public class 最长回文子串 {


    /**
     * 思路:
     * 1.遍历字符串,并采用嵌套循环的方式记录当前的最长回文字串
     * 2.记录最长回文字串的开始下标,以及记录子串的最大长度
     * 3
     *
     * @param s 字符串
     * @return 最长回文子串
     */
    public String longestPalindrome(String s) {
        // 首先校验字符串是否和法
        if (s == null || s.length() < 2) {
            return s;
        }
        int begin = 0;
        int maxLen = 1;
        int len = s.length();
        char[] array = s.toCharArray();
        // 遍历整个字符串
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                // 下标长度如果大于了之前的最长子串再判断其是否为回文
                if (j - i + 1 > maxLen && isHuiW(array, i, j)) {
                    begin = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public boolean isHuiW(char[] array, int left, int right) {
        while (left < right) {
            if (array[left] != array[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

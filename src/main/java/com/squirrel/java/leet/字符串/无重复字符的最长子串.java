package com.squirrel.java.leet.字符串;

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
//
//
// 示例 1:
//
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
// 示例 4:
//
//
//输入: s = ""
//输出: 0
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 5 * 104
// s 由英文字母、数字、符号和空格组成
//
// Related Topics 哈希表 字符串 滑动窗口
// 👍 5759 👎 0


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
public class 无重复字符的最长子串 {

    // 滑动窗口思想

    /**
     * 滑动窗口使用指针才进行运算
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {

        if (s == null || s.equals("")) {
            return 0;
        }
        // 定义右指针
        int rk = -1;
        int ans = -999;
        // 定义  set集合进行去重
        Set<Character> set = new HashSet<>();
        // 从左向右滑
        for (int i = 0; i < s.length(); i++) {

            if (i > 0) {
                set.remove(s.charAt(i - 1));
            }
            // 计算不重复的子串长度
            while (rk + 1 < s.length() && !set.contains(s.charAt(rk + 1))) {
                set.add(s.charAt(rk + 1));
                rk++;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;

    }


    // 滑动窗口思想

    /**
     * 无重复的最长子串
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringV1(String s) {
        //  abcabcbb   "dvdf"
        //Set<Character> set = new HashSet<>();
        int ans = -999;
        for (int i = 0; i < s.length(); i++) {
            // 记录单词查找非重复字符的数量
            Set<Character> set = new HashSet<>();
            int len = 0;
            // 滑动 删除之前的字符
          /*  if (i > 0) {
                set.remove(s.charAt(i - 1));
              //  set.re
            }*/
            // 子部分进行计算长度1、  内部遍历: 右指针
            for (int j = i; j < s.length() && !set.contains(s.charAt(j)); j++) {
                set.add(s.charAt(j));
                len++;
            }
            ans = Math.max(len, ans);

        }
        return ans;

    }


    public static void main(String[] args) {
        final int abcabcbb = lengthOfLongestSubstring("dvdf");

        System.out.println(abcabcbb);
    }

}

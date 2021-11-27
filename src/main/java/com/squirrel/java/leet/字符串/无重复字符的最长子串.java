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
        if (s == "" || s.length() == 0) {
            return 0;
        }
        int ans = 0;
        //
        int rk = -1;

        // 使用一个set标记这个字符串是否存在过
        Set<Character> set = new HashSet<>();
        // 遍历这个字符串
        for (int i = 0; i < s.length(); i++) {

            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            // 然后去循环计算其长度
            while (rk + 1 < s.length() && !set.contains(s.charAt(rk + 1))) {
                set.add(s.charAt(rk + 1));
                rk++;
            }
            ans = Math.max(rk - i + 1, ans);
        }
        return ans;
    }


    public static void main(String[] args) {
        final int abcabcbb = lengthOfLongestSubstring("dvdf");

        System.out.println(abcabcbb);
    }

}

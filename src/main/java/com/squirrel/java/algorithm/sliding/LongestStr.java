package com.squirrel.java.algorithm.sliding;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luobaosong
 * @date 2022/11/24 21:49
 * @description
 **/
@Slf4j
public class LongestStr {

    public static void main(String[] args) {

        LongestStr longestStr = new LongestStr();
        int len = longestStr.lengthOfLongestSubstring("pwwkew");
        log.info("len:{}", len);

        boolean flag = longestStr.checkInclusion("aa", "eaaboaoo");
        log.info("flag:{}", flag);

    }

    /**
     * 最长无重复子串长度
     *
     * @param s 年代
     * @return int
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        // 右下标小于字符串的长度
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            // 如果大于1 证明重复了,缩小窗口
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }
            res = Math.max(res, right - left);
            // 如果重复了需要滑动窗口
        }
        return res;
    }


    /**
     * 检查包括
     * 字符串的排列
     * 给你一个字符串s和t
     * 判断s2是否包含s1
     *
     * @param s1 s1
     * @param s2 s2
     * @return boolean
     */
    public boolean checkInclusion(String s1, String s2) {
        // 窗口
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        // right < s的长度
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 如果窗口中字符的个数和需要的字符个数数量相同,那么有效数字才会增加
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 确定收缩窗口的时机
            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }


    /**
     * 寻找异位词
     * 相当于，输入一个串 S，一个串 T，找到 S 中所有 T 的排列，返回它们的起始索引。
     *
     * @param s 年代
     * @param t t
     * @return {@link List}<{@link Integer}>
     */
    public List<Integer> findAnagrams(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        char[] chars = t.toCharArray();
        for (Character c : chars) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        List<Integer> res = new ArrayList<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 滑动窗口
            while (right - left >= t.length()) {
                if (valid == need.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return res;
    }

}
package com.squirrel.java.algorithm.sliding;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luobaosong
 * @date 2022/11/24 09:36
 * @description
 **/
@Slf4j
public class MinWindow {

    public static void main(String[] args) {
        MinWindow window = new MinWindow();
        String str = window.minWindow("ABOBECODEBANC", "ABC");
        log.info("最小覆盖子串,str:{}", str);
    }

    /**
     * 最小覆盖子串
     *
     * @param s 年代
     * @param t t
     * @return {@link String}
     */
    public String minWindow(String s, String t) {
        // 滑动窗口框架
        // 窗口
        Map<Character, Integer> window = new HashMap<>();
        // 子串需要多少
        Map<Character, Integer> need = new HashMap<>();
        int left = 0;
        int right = 0;
        int valid = 0;
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        // 记录最小覆盖子串的起始索引位置以及长度
        int start = 0;
        int len = Integer.MAX_VALUE;
        // 如果右侧指针小于字符串 s的长度
        while (right < s.length()) {
            // c是将移入窗口的字符
            char c = s.charAt(right);
            // 扩大窗口
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 如果窗口的值和所需的值匹配到了,那么有效字符个数进行++
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 如果找到了有效的字符串t,那么在进行窗口收缩
            while (valid == need.size()) {
                // 更新最小子串,如果小于len,那么start = left
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // 收缩窗口,与扩大窗口相反
                char d = s.charAt(left);
                // 收缩窗口
                left++;
                if (need.containsKey(d)) {
                    // 如果窗口的值和所需的值匹配到了,那么有效字符个数进行--
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}

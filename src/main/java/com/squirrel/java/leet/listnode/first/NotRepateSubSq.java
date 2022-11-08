package com.squirrel.java.leet.listnode.first;

import java.util.HashSet;
import java.util.Set;

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
 * @date Created in 2021年04月27日 11:07
 * @since 1.0
 */
public class NotRepateSubSq {

    /**
     * 从第一个字符开始 遇到不重复的
     * // 定义 字符
     * <p>
     * repeat
     * <p>
     * // idea: 遍历每一个字符： 然后每个字符在进行往后枚举 （判断条件是：遇到第重复的字符（可以用set判断），然后第二次循环的时候 移除set集合中的第一个元素）
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {


        if ("".equals(s)) {
            return 0;
        }

        int length = s.length();


        Set<Character> set = new HashSet<>();

        int initStr = -1;
        int result = 0;
        for (int i = 0; i < length - 1; i++) {
            if (i != 0) {
                set.remove(s.charAt(i));
            }
            while (initStr + 1 < length && !set.contains(s.charAt(initStr + 1))) {
                set.add(s.charAt(initStr + 1));
                initStr++;
            }
            result = Math.max(i + 1, initStr);
        }
        return result;
    }
}

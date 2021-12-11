package com.squirrel.java.leet.栈;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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
 * @date Created in 2021年09月26日 11:16
 * @since 1.0
 */
public class 有效的括号 {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * ({[]})
     * 思路:
     * 1.通过栈来进行比较,如果遇到反括号，就要出栈,否则一致压栈
     *
     * @param s 字符串
     * @return 是否是有效的
     */
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        // 定义栈
        Deque<Character> stack = new LinkedList<>();
        // 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            // 如果属于左括号那么就压栈
            if (!map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                // 否则出栈并判断是否为有效
                if (map.get(s.charAt(i)) == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}

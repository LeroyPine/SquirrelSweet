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
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {

        if (s.length() % 2 == 1) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        //使用栈来进行判断
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {

            if (!map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty() && map.get(s.charAt(i)) == stack.peek()) {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        isValid("]");
    }
}

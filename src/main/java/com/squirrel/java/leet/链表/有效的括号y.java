package com.squirrel.java.leet.链表;

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
 * @date Created in 2021年04月17日 13:23
 * @since 1.0
 */
public class 有效的括号y {

    public static void main(String[] args) {

        System.out.println(isValid("{()"));
    }

    /**
     * ({[]})   (){}[]
     */

    public static boolean isValid(String s) {

        // 可以通过压栈出栈来实现：

        // 首先判断一下长度
        if (s.isEmpty() || s.length() % 2 != 0) {
            return false;
        }

        // 定义一个map存储括号对应的关系
        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put(')', '(');
        map.put('}', '{');

        // 定义一个栈
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            // 遍历每一个字符 //不在map中就压栈 // 在map中并且有对应的key就出战
            if (!stack.isEmpty() && map.containsKey(s.charAt(i)) && stack.peek().equals(map.get(s.charAt(i)))) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }

        }
        return stack.isEmpty();
    }

}

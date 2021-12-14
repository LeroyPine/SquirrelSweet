package com.squirrel.java.leet.栈;

import java.util.Deque;
import java.util.LinkedList;

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
 * @date Created in 2021年09月28日 14:37
 * @since 1.0
 */
public class 最长的有效括号 {


    /**
     * 思路: 最长的有效括号
     * 1.通过栈进行实现
     * 2.将元素的下标进行压栈。
     * 3.
     *
     * @param s 字符串
     * @return 有效括号的长度
     */
    public int longestValidParentheses(String s) {
        int maxAns = 0;
        // 栈
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1); // 用来计算长度
        // 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                // 如果栈空了,那么把此元素加入进去 证明其是不匹配的括号
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxAns = Math.max(maxAns, i - stack.peek());
                }
            }
        }
        return maxAns;
    }
}

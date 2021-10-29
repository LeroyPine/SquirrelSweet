package com.squirrel.java.leet.栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p></p>
 * <p>
 *
 *     32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 *
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 *
 * 输入：s = ""
 * 输出：0
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author luobs
 * @version 1.0
 * @date Created in 2021年09月11日 13:14
 * @since 1.0
 */
public class 最长的括号 {

    public int longestValidParentheses(String s) {

        int maxans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }


    public int longestValidParentheses1(String s) {

        int ans = 0;
        //
        if (s == null || s.length()==1){
            return 0;
        }
        //  定义栈来进行判断是否是合法的括号。
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '('){
                stack.push(i);
            }else {
                stack.pop();
                if (stack.isEmpty()){
                      stack.push(i);
                }else {
                    ans = Math.max(ans,i-stack.peek());
                }
            }

        }


        return ans;



    }
}

package com.squirrel.java.leet.递归;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 生成括号 {

    List<String> res = new ArrayList<>();

    // 生成括号
    public List<String> generateParenthesis(int n) {

        if (n == 0) {
            return null;
        }

        dfs("", n, n);

        return res;

    }

    private void dfs(String s, int left, int right) {

        // 递归结束条件
        if (left == 0 && right == 0) {
            res.add(s);
        }
        // 如果左括号和右括号相同
        if (left == right) {
            dfs(s + "(", left - 1, right);
        } else if (left < right) {
            if (left > 0) {
                dfs(s + "(", left - 1, right);
            } else {
                dfs(s + ")", left, right - 1);
            }
        }
    }
}

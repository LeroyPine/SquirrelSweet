package com.squirrel.java.leet.回溯;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {


    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, StringBuilder cur, int open, int close, int n) {

        // 结束条件
        if (cur.length() == 2 * n) {
            // 如果当前字符串已经到达最大长度 那么直接返回
            ans.add(cur.toString());
            return;
        }
        // 左括号数量小于n的时候进行
        if (open < n) {
            backtrack(ans, cur.append("("), open + 1, close, n);
            // 状态重置
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            backtrack(ans, cur.append(")"), open, close + 1, n);
            cur.deleteCharAt(cur.length() - 1);
        }

    }


    public static void main(String[] args) {
        括号生成  a = new 括号生成();
        List<String> strings = a.generateParenthesis(2);
        // as
        System.out.println(strings);
    }

}

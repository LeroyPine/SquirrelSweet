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
 * @date Created in 2021年08月27日 10:01
 * @since 1.0
 */
public class 编码字符串 {

    /**
     * 给定一个经过编码的字符串，返回它解码后的字符串。 s = "3[a]2[bc]",
     * 返回 "aaabcbc". s = "3[a2[c]]", 返回 "accaccacc". s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
     */

    public static void main(String[] args) {


        final String s = decodeString("3[a]2[bc]");
        System.out.printf("s");
    }

    public static String decodeString(String s) {

        // multi * 10
        StringBuilder res = new StringBuilder();
        StringBuilder finalRes = new StringBuilder();
        int multi = 0;
        Deque<Integer> numStack = new LinkedList<>();
        Deque<String> zmStack = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (c == '[') {
                numStack.push(multi);
                zmStack.push(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                final Integer popNum = numStack.removeLast();
                final String popZm = zmStack.removeLast();
                for (Integer i = 0; i < popNum; i++) {
                    finalRes.append(popZm);
                }
                res = finalRes;
            } else if (c >= '0' && c <= '9') {
                multi =  multi * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}

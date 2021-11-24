package com.squirrel.java.leet.栈;

import java.awt.image.ImageProducer;
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
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');


        Deque<Character> stack = new LinkedList<>();

        int len = s.length();

        for(int i=0;i<len;i++){

            if(map.containsKey(s.charAt(i))){

                if(!stack.isEmpty() && stack.peek() == map.get(s.charAt(i))){
                    stack.pop();
                }else{
                    return false;
                }
            }else{
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();


    }
    public static void main(String[] args) {
        //.isValid("([}}])");
    }
}

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
 * @date Created in 2021年09月26日 15:57
 * @since 1.0
 */
public class 用栈实现队列 {


    // 定义两个栈   --  一个输入栈 一个输出栈

    Deque<Integer> inStack = new LinkedList<>();
    Deque<Integer> outStack = new LinkedList<>();


    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        // 出栈
        if (!inStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();

    }

    public int peek() {
        if (!inStack.isEmpty()) {
            in2out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2out() {
        // 编程队列的顺序
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }


}

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
public class MyQueue {

    Deque<Integer> inStack;
    Deque<Integer> outStack;

    // 定义两个栈   --  一个输入栈 一个输出栈
    public MyQueue() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    //  peek()   pop()  push()  isEmpty()

    // 队列是先进先出
    // 栈是先进后出

    public void push(Integer x) {
        inStack.push(x);
    }


    public void pop() {
        if (inStack.isEmpty()) {
            in2Out();
        }
        outStack.pop();
    }

    public Integer peek() {
        if (inStack.isEmpty()) {
            in2Out();
        }
         return outStack.peek();
    }



    //
    public void in2Out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}

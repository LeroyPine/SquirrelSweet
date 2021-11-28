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
public class 用栈实现队列232 {

    class MyQueue {

        Deque<Integer> inStack ;
        Deque<Integer> outStack;

        public MyQueue() {
            inStack = new LinkedList<>();
            outStack = new LinkedList<>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            if(outStack.isEmpty()){
                in2OutStack();
            }
            return outStack.pop();
        }

        public int peek() {
            if(outStack.isEmpty()){
                in2OutStack();
            }
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty() &&outStack.isEmpty();
        }

        // 出站的时候使用 outStack
        public void in2OutStack(){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }


    }
}

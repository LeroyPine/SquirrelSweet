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

    class MyQueue {
        // 声明两个栈
        Deque<Integer> outStack = new LinkedList<>();
        Deque<Integer> inStack = new LinkedList<>();

        // 队列都有什么方法？
        // pop push peek
        public void push(int x) {
            inStack.push(x);
        }

        // 只需将inStack中的元素反向押入outStack中
        public void in2out() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
        }

        // 出栈
        public int pop() {
            in2out();
            return outStack.pop();
        }

        public int peek() {
            in2out();
            if (!outStack.isEmpty()) {
                return outStack.peek();
            }
            return -1;
        }

        public boolean isEmpty() {
            return outStack.isEmpty() && inStack.isEmpty();
        }
    }

}

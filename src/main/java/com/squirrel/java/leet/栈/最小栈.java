package com.squirrel.java.leet.栈;

import java.util.Deque;
import java.util.LinkedList;

public class 最小栈 {


    /**
     * 思路:
     * 1.采用两个栈
     * 2.正常栈,每次入栈的时候,最小栈都要进行压栈,（比较获取较小的值进行压栈）
     */
    class MinStack {

        // 采用两个栈
        Deque<Integer> normalStack;
        Deque<Integer> minStack;

        public MinStack() {
            normalStack = new LinkedList<>();
            minStack = new LinkedList<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            normalStack.push(val);
            minStack.push(Math.min(minStack.peek(), val));
        }

        public void pop() {
            normalStack.pop();
            minStack.pop();
        }

        public int top() {
            return normalStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}

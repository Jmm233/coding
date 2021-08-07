package stackqueue;

import java.util.Stack;

/*
    返回最小值的栈
    https://leetcode-cn.com/problems/min-stack/
    严格递减的栈
 */
public class MinStack01 {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack01() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.add(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.add(val);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }

        int temp = stack.pop();
        if (temp == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

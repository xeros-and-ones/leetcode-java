package min_stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class MinStack {
    /**
     * Design a stack that supports push, pop, top, and retrieving the minimum element in constant
     * time. Implement the MinStack class: MinStack() initializes the stack object. void push(int val)
     * pushes the element val onto the stack. void pop() removes the element on the top of the stack.
     * int top() gets the top element of the stack. int getMin() retrieves the minimum element in the
     * stack. You must implement a solution with O(1) time complexity for each function.
     */
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        minStack = new ArrayDeque<>();
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        int top = stack.pop();
        if (top == minStack.peek()) {
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

package com.leo.exercise.list;

import java.util.LinkedList;

public class MyStack {
    private LinkedList<Integer> list;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        list = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        int size = list.size();
        list.add(x);
        while (size != 0) {
            list.add(list.remove());
            size--;
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return list.remove();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return list.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return list.isEmpty();
    }
}

package com.leo.exercise.list;

import java.util.Stack;

public class CQueue {
    private Stack<Integer> s1, s2;
    private int size;

    public CQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void appendTail(Integer value) {
        if (value == null) {
            return;
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(value);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        size++;
    }

    public Integer deleteHead() {
        if (size == 0) {
            return null;
        }
        size--;
        return s1.pop();
    }
}

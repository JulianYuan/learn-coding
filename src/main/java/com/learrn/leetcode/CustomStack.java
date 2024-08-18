package com.learrn.leetcode;

/**
 * 1381. 设计一个支持增量操作的栈
 * Design a stack that supports increment operations on its elements.
 *
 * Implement the CustomStack class:
 *
 * CustomStack(int maxSize) Initializes the object with maxSize which is the maximum number of elements in the stack.
 * void push(int x) Adds x to the top of the stack if the stack has not reached the maxSize.
 * int pop() Pops and returns the top of the stack or -1 if the stack is empty.
 * void inc(int k, int val) Increments the bottom k elements of the stack by val. If there are less than k elements in the stack, increment all the elements in the stack.
 */

public class CustomStack {

    private int[] content;
    private int maxSize;
    private int cur = 0;

    public CustomStack(int maxSize) {
        content = new int[maxSize];
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if (cur < maxSize) {
            content[cur++] = x;
            //cur++;
        }
    }

    public int pop() {
        if (cur == 0) {
            return -1;
        }
        return content[--cur];
    }

    public void increment(int k, int val) {
        for (int i = 0; i < cur && i < k; i++) {
            content[i] += val;
        }
    }

    //["CustomStack","push","push","pop","push","push","push","increment","increment","pop","pop","pop","pop"]
    //[[3],[1],[2],[],[2],[3],[4],[5,100],[2,100],[],[],[],[]]
    public static void main(String[] args) {
        CustomStack stack = new CustomStack(3);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.increment(5, 100);
        stack.increment(2, 100);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}

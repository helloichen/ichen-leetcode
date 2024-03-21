package com.github.helloichen.demo;

import java.util.LinkedList;

/**
 * @author iChen
 * @since 2024-03-21
 */
public class MyStack<T> {

    private final LinkedList<T> list;

    public MyStack() {
        this.list = new LinkedList<>();
    }

    public void push(T e) {
        list.addLast(e);
    }

    public T pop() {
        if (list.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return list.removeLast();
    }

    public T peek() {
        if (list.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return list.getLast();
    }

    static class Test {
        public static void main(String[] args) {
            MyStack<Integer> stack = new MyStack<>();
            stack.push(1);
            stack.push(2);
            stack.push(3);
            System.out.println(stack.peek());
            System.out.println(stack.pop());
            stack.push(4);
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
        }
    }
}




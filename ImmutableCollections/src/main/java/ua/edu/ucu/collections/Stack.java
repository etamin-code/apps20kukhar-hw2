package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import ua.edu.ucu.collections.immutable.Node;

public class Stack {
    private ImmutableLinkedList stack = new ImmutableLinkedList();

    public Stack(ImmutableLinkedList stack) {
        this.stack = stack;
    }

    public Object peek() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("empty stack");
        }
        Node first = (Node) stack.getFirst();
        return first.getObject();
    }

    public Object pop() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("empty stack");
        }
        Node first = (Node) stack.getFirst();
        stack.removeFirst();
        return first.getObject();
    }

    public void push(Object e) {
        stack.addFirst(e);
    }

    
}

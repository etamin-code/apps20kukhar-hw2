package ua.edu.ucu.collections;

import org.junit.Test;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void testStack() {
        ImmutableLinkedList immutableLinkedList = new ImmutableLinkedList();
        Stack stack = new Stack(immutableLinkedList);
        stack.push(2);
        assertEquals(2, stack.peek());
        stack.push(3);
        assertEquals(3, stack.peek());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.peek());
        assertEquals(2, stack.pop());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testEmptyPeek() {
        ImmutableLinkedList immutableLinkedList = new ImmutableLinkedList();
        Stack stack = new Stack(immutableLinkedList);
        stack.peek();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyPop() {
        ImmutableLinkedList immutableLinkedList = new ImmutableLinkedList();
        Stack stack = new Stack(immutableLinkedList);
        stack.pop();
    }
}

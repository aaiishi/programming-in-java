package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyStack;
import java.util.NoSuchElementException;

/**
 * Stack implementation using a doubly-linked list.
 */
public class MyStackDLLBImpl<E> implements MyStack<E> {
    private DLinkList<E> elems = new DLinkList<>();

    /**
     * Removes and returns the element at the top of the stack.
     * @return the element at the top of the stack
     * @throws NoSuchElementException if the stack is empty
     */
    @Override
    public E pop() {
        if (elems.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return elems.removeLast();
    }

    /**
     * Pushes an element onto the stack.
     * @param x the element to push
     */
    @Override
    public void push(E x) {
        elems.addLast(x);
    }

    /**
     * Returns the number of elements in the stack.
     * @return the number of elements
     */
    @Override
    public int numOfElems() {
        return elems.size();
    }

    /**
     * Retrieves, but does not remove, the top of the stack.
     * @return the top of the stack
     * @throws NoSuchElementException if the stack is empty
     */
    @Override
    public E peek() {
        if (elems.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return elems.getLast();
    }
}

package agh.ii.prinjava.proj1.impl;

/**
 * Represents a doubly linked list data structure.
 *
 * @param <E> the type of elements held in this list
 */
public class DLinkList<E> {

    private Node<E> head;  // reference to the first node
    private Node<E> tail;  // reference to the last node
    private int size;  // number of elements in the list

    /**
     * Creates an empty doubly linked list.
     */
    public DLinkList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Represents a node in the doubly linked list.
     *
     * @param <T> the type of element held in the node
     */
    private static class Node<T> {
        T elem;
        Node<T> next;
        Node<T> prev;

        /**
         * Creates a new node with the given element, previous node, and next node references.
         *
         * @param elem the element to be stored in the node
         * @param prev reference to the previous node in the list
         * @param next reference to the next node in the list
         */
        public Node(T elem, Node<T> prev, Node<T> next) {
            this.elem = elem;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * Adds an element to the beginning of the list.
     *
     * @param e the element to be added
     */
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e, null, head);
        if (head == null) {
            tail = newNode;
        } else {
            head.prev = newNode;
        }
        head = newNode;
        size++;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param e the element to be added
     */
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e, tail, null);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    /**
     * Removes and returns the first element from the list.
     *
     * @return the removed element
     * @throws IllegalStateException if the list is empty
     */
    public E removeFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty.");
        }
        E removedElem = head.elem;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;  // list became empty after removing
        }
        size--;
        return removedElem;
    }

    /**
     * Removes and returns the last element from the list.
     *
     * @return the removed element
     * @throws IllegalStateException if the list is empty
     */
    public E removeLast() {
        if (tail == null) {
            throw new IllegalStateException("List is empty.");
        }
        E removedElem = tail.elem;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;  // list became empty after removing
        }
        size--;
        return removedElem;
    }

    /**
     * Returns a string representation of the list.
     *
     * @return a comma-separated string representation of the list elements enclosed in square brackets
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = head;
        while (current != null) {
            sb.append(current.elem);
            current = current.next;
            if (current != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // ... (rest of the DLinkList class)

    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the last element in the list without removing it.
     *
     * @return the last element in the list
     * @throws IllegalStateException if the list is empty
     */
    public E getLastElem() {
        if (tail == null) {
            throw new IllegalStateException("List is empty.");
        }
        return tail.elem;
    }

    // ... (rest of the DLinkList class)

    /**
     * Returns the first element in the list without removing it.
     *
     * @return the first element in the list
     * @throws IllegalStateException if the list is empty
     */
    public E getFirstElem() {
        if (head == null) {
            throw new IllegalStateException("List is empty.");
        }
        return head.elem;
    }
}

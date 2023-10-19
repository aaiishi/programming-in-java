package agh.ii.prinjava.proj1.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for {@link DLinkList}.
 */
class DLinkListTest {

    /** The doubly-linked list instance used for testing */
    private DLinkList<Integer> dLinkList;

    /**
     * Initializes a new doubly-linked list instance before each test.
     */
    @BeforeEach
    void setUp() {
        dLinkList = new DLinkList<>();
    }

    /**
     * Cleans up the doubly-linked list instance after each test.
     */
    @AfterEach
    void tearDown() {
        dLinkList = null;
    }

    /**
     * Test the addition of elements at the beginning of the doubly-linked list.
     */
    @Test
    void testAddFirst() {
        dLinkList.addFirst(2);
        dLinkList.addFirst(1);
        assertEquals("[1, 2]", dLinkList.toString());

        dLinkList.addFirst(0);
        assertEquals("[0, 1, 2]", dLinkList.toString());
    }

    /**
     * Test the addition of elements at the end of the doubly-linked list.
     */
    @Test
    void testAddLast() {
        dLinkList.addLast(1);
        dLinkList.addLast(2);
        assertEquals("[1, 2]", dLinkList.toString());

        dLinkList.addLast(3);
        assertEquals("[1, 2, 3]", dLinkList.toString());
    }

    /**
     * Test the removal of elements from the beginning of the doubly-linked list.
     */
    @Test
    void testRemoveFirst() {
        dLinkList.addLast(1);
        dLinkList.addLast(2);
        dLinkList.addLast(3);

        assertEquals(1, dLinkList.removeFirst());
        assertEquals("[2, 3]", dLinkList.toString());

        assertEquals(2, dLinkList.removeFirst());
        assertEquals("[3]", dLinkList.toString());

        assertEquals(3, dLinkList.removeFirst());
        assertEquals("[]", dLinkList.toString());

        assertThrows(IllegalStateException.class, () -> dLinkList.removeFirst());
    }

    /**
     * Test the removal of elements from the end of the doubly-linked list.
     */
    @Test
    void testRemoveLast() {
        dLinkList.addLast(1);
        dLinkList.addLast(2);
        dLinkList.addLast(3);

        assertEquals(3, dLinkList.removeLast());
        assertEquals("[1, 2]", dLinkList.toString());

        assertEquals(2, dLinkList.removeLast());
        assertEquals("[1]", dLinkList.toString());

        assertEquals(1, dLinkList.removeLast());
        assertEquals("[]", dLinkList.toString());

        assertThrows(IllegalStateException.class, () -> dLinkList.removeLast());
    }

    /**
     * Test the string representation of the doubly-linked list.
     */
    @Test
    void testToString() {
        assertEquals("[]", dLinkList.toString());

        dLinkList.addLast(1);
        assertEquals("[1]", dLinkList.toString());

        dLinkList.addLast(2);
        assertEquals("[1, 2]", dLinkList.toString());

        dLinkList.addLast(3);
        assertEquals("[1, 2, 3]", dLinkList.toString());
    }
}

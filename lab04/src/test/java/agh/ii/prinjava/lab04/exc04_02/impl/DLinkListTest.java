package agh.ii.prinjava.lab04.exc04_02.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

class DLinkListTest {

    DLinkList<Integer> dLinkList;

    @BeforeEach
    void setUp() {
        dLinkList = new DLinkList<>();
    }

    @AfterEach
    void tearDown() {
        dLinkList = null;
    }

    @Test
    void addFirst_thenRemoveFirst_elementsShouldMatch() {
        dLinkList.addFirst(1);
        assertEquals(1, dLinkList.removeFirst());
    }

    @Test
    void addLast_thenRemoveLast_elementsShouldMatch() {
        dLinkList.addLast(2);
        assertEquals(2, dLinkList.removeLast());
    }

    @Test
    void whenEmptyList_removeFirst_shouldThrowException() {
        assertThrows(NoSuchElementException.class, () -> dLinkList.removeFirst());
    }

    @Test
    void whenEmptyList_removeLast_shouldThrowException() {
        assertThrows(NoSuchElementException.class, () -> dLinkList.removeLast());
    }
}

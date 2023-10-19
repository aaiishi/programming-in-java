package agh.ii.prinjava.lab04.exc04_01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairTest {

    Pair<Integer, String> pairOfIntStr;

    @BeforeEach
    void setUp() {
        pairOfIntStr = new Pair<>(1, "one");
    }

    @AfterEach
    void tearDown() {
        pairOfIntStr = null; // Not strictly necessary; facilitates garbage collection
    }

    @Test
    void creatingNewPair_ShouldNotBeNull() {
        assertNotNull(pairOfIntStr);
    }

    @Test
    void pairValues_ShouldBeAccessibleViaGetters() {
        assertEquals(1, pairOfIntStr.getFirst());
        assertEquals("one", pairOfIntStr.getSecond());
    }

    @Test
    void pairValues_ShouldBeMutable() {
        pairOfIntStr.setFirst(2);
        pairOfIntStr.setSecond("two");

        assertEquals(2, pairOfIntStr.getFirst());
        assertEquals("two", pairOfIntStr.getSecond());
    }

    @Test
    void pairsWithSameValues_ShouldBeEqual() {
        Pair<Integer, String> anotherPair = new Pair<>(1, "one");
        assertEquals(pairOfIntStr, anotherPair);
    }

    @Test
    void pairsWithDifferentValues_ShouldNotBeEqual() {
        Pair<Integer, String> anotherPair = new Pair<>(2, "one");
        assertNotEquals(pairOfIntStr, anotherPair);
    }

    @Test
    void clonedPair_ShouldBeEqualButNotSame() {
        Pair<Integer, String> clonedPair = pairOfIntStr.clone();
        assertEquals(pairOfIntStr, clonedPair);
        assertNotSame(pairOfIntStr, clonedPair);
    }

    @Test
    void pairToString_ShouldReturnExpectedResult() {
        String expected = "Pair{first=1, second=one}";
        assertEquals(expected, pairOfIntStr.toString());
    }
}

package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.NoSuchElementException;

class IntegerSetTest {
    private IntegerSet setA;
    private IntegerSet setB;
    private IntegerSet emptySet;

    @BeforeEach
    void setUp() {
        // Initialize setA with elements.
        setA = new IntegerSet();
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setA.add(5);
        setA.add(7);
        
        // Initialize setB with elements and partial overlap with setA.
        setB = new IntegerSet();
        setB.add(2);
        setB.add(4);
        setB.add(5);
        setB.add(6);
        
        emptySet = new IntegerSet();
    }
    
    
    @Test
    @DisplayName("Test add adds a new element")
    void testAddNewElement() {
        setA.add(10);
        assertTrue(setA.contains(10));
        assertEquals(6, setA.length());
    }

    
    @Test
    @DisplayName("Test adding duplicate elements")
    void testAddDuplicates() {
        setA.add(2); // Already exists in setA.
        assertEquals(5, setA.length()); // Length should not increase.
    }
    
    @Test
    @DisplayName("Test largest returns correct value")
    void testLargestReturnsCorrectValue() {
        assertEquals(7, setA.largest());
        assertEquals(6, setB.largest());
    }

    @Test
    @DisplayName("Test smallest returns correct value")
    void testSmallestReturnsCorrectValue() {
        assertEquals(1, setA.smallest());
        assertEquals(2, setB.smallest());
    }

    
    @Test
    @DisplayName("Test largest throws exception on empty set")
    void testLargestThrowsExceptionOnEmptySet() {
        assertThrows(NoSuchElementException.class, () -> {
            emptySet.largest();
        });
    }

    @Test
    @DisplayName("Test smallest throws exception on empty set")
    void testSmallestThrowsExceptionOnEmptySet() {
        assertThrows(NoSuchElementException.class, () -> {
            emptySet.smallest();
        });
    }

    @Test
    @DisplayName("Test contains with existing elements")
    void testContainsExistingElements() {
        assertAll(
            () -> assertTrue(setA.contains(1)),
            () -> assertTrue(setA.contains(5)),
            () -> assertTrue(setB.contains(4))
        );
    }

    @Test
    @DisplayName("Test union combines elements from both sets")
    void testUnionCombinesElements() {
        setA.union(setB);
        assertAll(
            () -> assertEquals(7, setA.length()),
            () -> assertTrue(setA.contains(1)),
            () -> assertTrue(setA.contains(4)),
            () -> assertTrue(setA.contains(7))
        );
    }
    
    @Test
    @DisplayName("Test union with an empty set")
    void testUnionWithEmptySet() {
        setA.union(emptySet);
        assertEquals(5, setA.length());
    }


    @Test
    @DisplayName("Test intersect keeps only common elements")
    void testIntersectKeepsCommonElements() {
        setA.intersect(setB);
        assertAll(
            () -> assertEquals(2, setA.length()),
            () -> assertTrue(setA.contains(2)),
            () -> assertTrue(setA.contains(5)),
            () -> assertFalse(setA.contains(1))
        );
    }

    @Test
    @DisplayName("Test diff removes common elements")
    void testDiffRemovesCommonElements() {
        setA.diff(setB);
        assertAll(
            () -> assertEquals(3, setA.length()),
            () -> assertTrue(setA.contains(1)),
            () -> assertTrue(setA.contains(3)),
            () -> assertTrue(setA.contains(7)),
            () -> assertFalse(setA.contains(2))
        );
    }

    @Test
    @DisplayName("Test complement keeps elements not in other set")
    void testComplementKeepsUniqueElements() {
        setA.complement(setB);
        assertAll(
            () -> assertEquals(2, setA.length()),
            () -> assertTrue(setA.contains(4)),
            () -> assertTrue(setA.contains(6))
        );
    }

    @Test
    @DisplayName("Test equals with identical elements")
    void testEqualsWithIdenticalElements() {
        IntegerSet testSet = new IntegerSet();
        testSet.add(2);
        testSet.add(5);
        testSet.add(4);
        testSet.add(6);
        assertTrue(setB.equals(testSet));
    }

    @Test
    @DisplayName("Test equals with different elements")
    void testEqualsWithDifferentElements() {
        assertFalse(setA.equals(setB));
    }

    
    @Test
    @DisplayName("Test length returns correct size")
    void testLengthReturnsCorrectSize() {
        assertEquals(5, setA.length());
        assertEquals(4, setB.length());
        assertEquals(0, emptySet.length());
    }

    @Test
    @DisplayName("Test remove deletes element if present")
    void testRemoveElement() {
        setA.remove(5);
        assertFalse(setA.contains(5));
        assertEquals(4, setA.length());
    }
    
    @Test
    @DisplayName("Test isEmpty returns false for non-empty set and true after clear")
    void testIsEmptyReturnsCorrectValue() {
        assertFalse(setA.isEmpty());
        emptySet.clear();
        assertTrue(emptySet.isEmpty());
    }

    
    @Test
    @DisplayName("Test clear empties the set")
    void testClearEmptiesSet() {
        setA.clear();
        assertAll(
            () -> assertEquals(0, setA.length()),
            () -> assertTrue(setA.isEmpty())
        );
    }
}
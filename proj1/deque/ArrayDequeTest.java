package deque;

import org.junit.Test;
import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class ArrayDequeTest {

    @Test
    public void addIsEmptySizeTest() {
        ArrayDeque<String> a = new ArrayDeque<String>();

        assertTrue("A newly initialized LLDeque should be empty", a.isEmpty());
        a.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, a.size());
        assertFalse("lld1 should now contain 1 item", a.isEmpty());
        a.addLast("middle");
        assertEquals(2, a.size());

        a.addLast("back");
        assertEquals(3, a.size());

        System.out.println("Printing out deque: ");
        a.printDeque();
    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {
        ArrayDeque<Integer> a = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", a.isEmpty());

        a.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", a.isEmpty());

        a.removeFirst();
        // should be empty
        assertTrue("lld1 should be empty after removal", a.isEmpty());
    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        a.addFirst(3);

        a.removeLast();
        a.removeFirst();
        a.removeLast();
        a.removeFirst();

        int size = a.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {
        ArrayDeque<String>  a1 = new ArrayDeque<String>();
        ArrayDeque<Double>  a2 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> a3 = new ArrayDeque<Boolean>();

        a1.addFirst("string");
        a2.addFirst(3.14159);
        a3.addFirst(true);

        String s = a1.removeFirst();
        double d = a2.removeFirst();
        boolean b = a3.removeFirst();
    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {
        LinkedListDeque<Integer> a = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, a.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, a.removeLast());
    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {
        ArrayDeque<Integer> a = new ArrayDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            a.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) a.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) a.removeLast(), 0.0);
        }
    }

    @Test
    public void getTest() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        for (int i = 0; i < 20; i++) {
            a.addLast(i);
        }

        assertNotNull(a.get(0));
        assertEquals(0, (int) a.get(0));

        assertNotNull(a.get(3));
        assertEquals(3, (int) a.get(3));

        assertNotNull(a.get(9));
        assertEquals(9, (int) a.get(9));
    }

    @Test
    public void getEmptyListTest() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        assertEquals(null, a.get(0));
    }

    @Test
    public void getAtIndexBiggerThanSize() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        assertEquals(null, a.get(1));
    }

    @Test
    public void fillUpEmptyFillUpAgainTest() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        for (int i = 0; i < 8; i++) {
            a.addLast(i);
        }

        for (int i = 0; i < 8; i++) {
            a.removeLast();
        }

        for (int i = 0; i < 8; i++) {
            a.addLast(i);
        }
    }
}

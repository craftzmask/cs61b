package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> buggy = new BuggyAList<>();

        for (int i = 0; i < 3; i++) {
            correct.addLast(i);
            buggy.addLast(i);
        }

        for (int i = 0; i < 3; i++) {
            assertEquals(correct.removeLast(), buggy.removeLast());
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
            } else if (operationNumber == 1) {
                assertEquals(B.size(), L.size());
            } else if (operationNumber == 2) {
                if (L.size() > 0 && B.size() > 0) {
                    assertEquals(B.getLast(), L.getLast());
                }
            } else if (operationNumber == 3) {
                if (L.size() > 0) {
                    assertEquals(B.removeLast(), L.removeLast());
                }
            }
        }
    }
}

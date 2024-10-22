package tester;

import static org.junit.Assert.*;

import edu.princeton.cs.introcs.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;

import java.util.ArrayList;
import java.util.List;

public class TestArrayDequeEC {
    List<String> messages = new ArrayList<>();

    @Test
    public void testMethods() {
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sol = new ArrayDequeSolution<>();

        while(true) {
            double random = StdRandom.uniform(6);
            int randomNum = StdRandom.uniform(100);

            if (random == 0) {
                messages.add("addLast(" + randomNum + ")");
                student.addLast(randomNum);
                sol.addLast(randomNum);
            } else if (random == 1) {
                messages.add("addFirst(" + randomNum + ")");
                student.addFirst(randomNum);
                sol.addFirst(randomNum);
            } else if (random == 2) {
                if (!(sol.isEmpty() && student.isEmpty())) {
                    messages.add("removeFirst()");
                    assertEquals(String.join("\n", messages), sol.removeFirst(), student.removeFirst());
                }
            } else if (random == 3) {
                if (!(sol.isEmpty() && student.isEmpty())) {
                    messages.add("removeLast()");
                    assertEquals(String.join("\n", messages), sol.removeLast(), student.removeLast());
                }
            } else if (random == 4) {
                messages.add("isEmpty()");
                assertEquals(String.join("\n", messages), sol.isEmpty(), student.isEmpty());
            } else if (random == 5) {
                messages.add("size()");
                assertEquals(String.join("\n", messages), sol.size(), student.size());
            }
        }
    }
}

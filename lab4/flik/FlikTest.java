package flik;

import org.junit.Test;
import static org.junit.Assert.*;

public class FlikTest {

    @Test
    public void testIsSame() {
        Flik f = new Flik();
        int a = 128;
        int b = 128;
        assertTrue(f.isSameNumber(a, b));
    }

    @Test
    public void testIsDifferent() {
        Flik f = new Flik();
        int a = 10;
        int b = 128;
        assertFalse(f.isSameNumber(a, b));
    }
}

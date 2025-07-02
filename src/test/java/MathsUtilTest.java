import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathsUtilTest {
    @Test
    void testAddition() {
        int a = 5;
        int b = 3;
        int result = a + b;
        assertEquals(8, result);
    }

    @Test
    void testSubtraction() {
        int a = 10;
        int b = 4;
        int result = a - b;
        assertEquals(6, result);
    }

    @Test
    void testMultiplication(){
        int a = 2;
        int b = 5;

        int result = a*b;

        assertEquals(10, result);
    }
}

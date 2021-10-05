import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
        int actual = Calculator.add(2,3);
        assertEquals(5,actual);
    }

    @Test
    void testCase1(){
        assertTrue(Calculator.operator.equals("add"));
    }

    @Test
    void testCase2(){
        fail("Not implemented");
    }
}
package br.unb.cic.test.unit.samples;

import br.unb.cic.test.unit.TestCase;

public class MathTestCase extends TestCase  {
    public void testSumOfIntegers() {
        assertTrue(2+2 > 0);
    }

    public void testSquareFunction() {
        assertEquals(4.0, Math.pow(2,2));
        assertEquals(16.0, Math.pow(2, 4));
    }

    public void testSquareFunctionError() {
        assertEquals(0, Math.pow(2,2));
    }
}

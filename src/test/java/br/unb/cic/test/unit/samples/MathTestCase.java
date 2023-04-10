package br.unb.cic.test.unit.samples;

import br.unb.cic.test.unit.TestCase;

public class MathTestCase extends TestCase  {
    private int base;

    @Override
    public void before() {
        base = 10;
    }

    public void testSumOfIntegers() {
        assertTrue(2+2 > 0);
    }

    public void testSquareFunction() {
        assertEquals(100.0, Math.pow(base,2));
        assertEquals(1000.0, Math.pow(base, 3));
    }

    public void testSquareFunctionError() {
        assertEquals(0.0, Math.pow(2,2));
    }

    public void testFactorial() {
        base = 5;

        for(int i = base-1; i > 1; i--) {
            base = base * i;
        }
        assertEquals(120, base);
    }
}

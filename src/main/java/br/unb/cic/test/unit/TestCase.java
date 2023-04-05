package br.unb.cic.test.unit;

import br.unb.cic.test.unit.eh.AssertEqualsException;
import br.unb.cic.test.unit.eh.AssertException;
import br.unb.cic.test.unit.eh.AssertTrueException;

import java.lang.reflect.Method;

/**
 * Define the root of the Test Case class hierarchy.
 * All test case classes must inherit from this abstract class.
 *
 * The name of the test methods must start with the "test" prefix.
 */
public abstract class TestCase {
    private static String TEST_PREFIX = "test";

    /** This constructor defines an additional design rule. All test case classes
     * must have a default constructor (without any argument).
     */
    protected TestCase() { }

    /**
     * Throws AssertTrueException when value = False
     */
    protected void assertTrue(boolean value) {
        if (!value) {
            throw new AssertTrueException();
        }
    }

    /**
     * Throws AssertEqualsException when o1 != o2
     */
    protected void assertEquals(Object o1, Object o2) {
        if (!o1.equals(o2)) {
            throw new AssertEqualsException();
        }
    }

    /**
     * Runs all test methods of a TestCase class.
     */
    public TestResult run() {
        Method[] methods = this.getClass().getDeclaredMethods();
        TestResult result = new TestResult(this.getClass().getName());
        for (Method m : methods) {
            try {
                if (m.getName().startsWith(TEST_PREFIX)) {
                    m.invoke(this);
                    result.reportSuccess(m.getName());
                }
            } catch (AssertException e) {
                result.reportError(m.getName());
            } catch (Throwable e) {
                result.reportFailure(m.getName());
            }
        }
        return result;
    }
}
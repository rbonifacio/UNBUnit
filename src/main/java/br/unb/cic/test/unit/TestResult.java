package br.unb.cic.test.unit;

import java.util.HashSet;
import java.util.Set;

/**
 * Collect the results of a test execution.
 * It might be useful either for a single test case
 * or a test runner.
 */
public class TestResult {
    private String testCaseName;
    private Set<String> successes;
    private Set<String> errors;
    private Set<String> failures;

    public TestResult(String testCaseName) {
        this.testCaseName = testCaseName;
        successes = new HashSet<>();
        errors = new HashSet<>();
        failures = new HashSet<>();
    }


    public void reportSuccess(String testName) {
        successes.add(testName);
    }

    public void reportError(String testName) {
        errors.add(testName);
    }


    public void reportFailure(String testName) {
        failures.add(testName);
    }

    public String getTestCaseName() {
        return testCaseName;
    }

    public Set<String> getSuccesses() {
        return successes;
    }

    public Set<String> getErrors() {
        return errors;
    }

    public Set<String> getFailures() {
        return failures;
    }
}

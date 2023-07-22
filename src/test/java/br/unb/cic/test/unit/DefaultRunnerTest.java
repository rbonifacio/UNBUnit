package br.unb.cic.test.unit;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * A JUnit test case for the <code>DefaultRunner</code>> class.
 */
public class DefaultRunnerTest {

    @Test
    public void listTestCases() {
        Set<Report> reports = new HashSet<>();
        DefaultRunner runner = new DefaultRunner(reports);
        String packagePath = "br.unb.cic.test.unit.samples";
        
        Assert.assertTrue(!runner.listTestCases(packagePath).isEmpty());
        Assert.assertEquals(2, runner.listTestCases(packagePath).size());
    }


    @Test
    public void executeSampleTestes() {
        Set<Report> reports = new HashSet<>();
        DefaultRunner runner = new DefaultRunner(reports);

        Set<TestResult> results = runner.runAllTests("br.unb.cic.test.unit.samples");

        int success = results.stream().map(result -> result.getSuccesses().size()).reduce(Integer::sum).get();
        int failures = results.stream().map(result -> result.getFailures().size()).reduce(Integer::sum).get();
        int errors = results.stream().map(result -> result.getErrors().size()).reduce(Integer::sum).get();

        Assert.assertEquals(3, success);
        Assert.assertEquals(1, failures);
        Assert.assertEquals(0, errors);
    }
}

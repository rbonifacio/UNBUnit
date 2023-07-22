package br.unb.cic.test.unit;

import br.unb.cic.test.unit.eh.Failure;
import com.google.inject.Inject;
import org.reflections.Reflections;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashSet;
import java.util.Set;

/**
 * A <code>TestRunner</code> that searches for all classes that inherit
 * from <code>TestCase</code>.
 */
public class DefaultRunner extends TestRunner {

    @Inject
    public DefaultRunner(Set<Report> reports) {
        super(reports);
    }
    
    @Override
    public Set<TestCase> listTestCases(String packagePath) {
        try {


            Reflections reflections = new Reflections(packagePath);
            Set<Class<? extends TestCase>> testCaseClasses = reflections.getSubTypesOf(TestCase.class);
            Set<TestCase> testCases = new HashSet<>();



            for (Class<? extends TestCase> c : testCaseClasses) {
                testCases.add(c.newInstance());
            }
            return testCases;
        }
        catch(Throwable e) {
            throw new Failure(e.getMessage());
        }
    }
}

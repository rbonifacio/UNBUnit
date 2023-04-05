package br.unb.cic.test.unit.eh;

import br.unb.cic.test.unit.TestCase;

public class TestCaseInstantiationError extends RuntimeException {
    public TestCaseInstantiationError(Class<? extends TestCase> c) {
        super("Error instantiating class " + c.getName());
    }
}

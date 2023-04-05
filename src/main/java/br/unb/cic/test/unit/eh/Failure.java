package br.unb.cic.test.unit.eh;

public class Failure extends RuntimeException {
    public Failure(String message) {
        super(message);
    }
}

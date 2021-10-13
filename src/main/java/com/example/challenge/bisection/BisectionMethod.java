package com.example.challenge.bisection;

import java.util.function.DoubleUnaryOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BisectionMethod {

    private static final Logger log = LoggerFactory.getLogger(BisectionMethod.class);

    private BisectionMethod() {
        throw new IllegalStateException("Class should not be instantiated");
    }

    public static double findRoot(
        DoubleUnaryOperator f,
        double a,
        double b,
        double tolerance,
        int maxIterations
    ) {
        throw new UnsupportedOperationException();
    }

}

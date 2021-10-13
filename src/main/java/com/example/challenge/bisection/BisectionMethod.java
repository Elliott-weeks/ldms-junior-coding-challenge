package com.example.challenge.bisection;

import java.util.function.DoubleUnaryOperator;

import com.example.challenge.exceptions.BisectionInvalidArguments;
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


        if (a >= b) {
            log.error("Illegal parameters a must be smaller than b. Parameters passed: " + a +" " +  b);
            throw new BisectionInvalidArguments("Illegal parameters a must be smaller than b");
        }


        double fa = f.applyAsDouble(a);

        int N = 1;
        while (N<= maxIterations){
            double c = (a+b) /2;
            double fc = f.applyAsDouble(c);
            if(fc == 0 || (b-a) /2 < tolerance){
                return c;
            }
            N++; // increment

            if (Math.signum(fc) == Math.signum(fa)){
                a = c;
                fa = fc;
            }else{
                b = c;
            }



        }


    return Double.NaN;


    }


}

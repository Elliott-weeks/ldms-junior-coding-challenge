package com.example.challenge.bisection;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.DoubleUnaryOperator;

import com.example.challenge.exceptions.BisectionInvalidArguments;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Unit :: Bisection :: Bisection Method")
class BisectionMethodTests {

    DoubleUnaryOperator f = (x) -> Math.pow(x, 3) - x - 2;
    double tolerance = 1e-6;
    int maxIterations = 100;

    @Test
    @DisplayName("Should find an acceptable root if interval is valid")
    void findRoot_validInterval_shouldFindAnAcceptableRoot() {
        var root = BisectionMethod.findRoot(f, 1, 2, tolerance, maxIterations);

        Assertions.assertThat(
            BigDecimal.valueOf(root)
                .setScale(3, RoundingMode.HALF_UP)
                .doubleValue())
            .isEqualTo(1.521d);
    }


    @Test
    @DisplayName("Should throw illegal argument exception due to a and b being the same")
    void findRoot_invalidArgumentGreaterThanArg_shouldThrowError() {
        Assertions.assertThatExceptionOfType(BisectionInvalidArguments.class)
                .isThrownBy(() -> {
                    var root = BisectionMethod.findRoot(f, 2, 2, tolerance, maxIterations);
                }).withMessage("Illegal parameters a must be smaller than b");


    }
    @Test
    @DisplayName("Ensure Nan never return with max decimal numbers ")
    void findRoot_invalidArgument_shouldThrowError() {
        var root = BisectionMethod.findRoot(f, -99999999, 999999999, tolerance, maxIterations);
        Assertions.assertThat(Double.isNaN(root)).isEqualTo(false);


    }




}

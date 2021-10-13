package com.example.challenge.bisection;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.DoubleUnaryOperator;
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

}

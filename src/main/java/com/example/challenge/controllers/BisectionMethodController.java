package com.example.challenge.controllers;

import com.example.challenge.bisection.BisectionMethod;
import com.example.challenge.exceptions.BisectionInvalidArguments;
import com.example.challenge.model.BisectionMethodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.DoubleUnaryOperator;

@RestController
public class BisectionMethodController {


    private static final Logger log = LoggerFactory.getLogger(BisectionMethod.class);

    @GetMapping("/BisectionMethodService")
    public BisectionMethodService greeting(@RequestParam(value = "a") Double a, @RequestParam(value = "b") Double b) {
        DoubleUnaryOperator f = (x) -> Math.pow(x, 3) - x - 2;
        double tolerance = 1e-6;
        int maxIterations = 100;
        double root = BisectionMethod.findRoot(f,a,b,tolerance,maxIterations);
        if(Double.isNaN(root)){ // Nan is present because when values above a double is passed to the api e.g. extremely large it results in NaN
            log.error("The provided arguments resulted in no root being found within the max interval specified. Parms were - " + a + " " + b);
            throw new BisectionInvalidArguments("The provided arguments resulted in no root being found within the max interval specified.");
        }

        return new BisectionMethodService(root);
    }


}

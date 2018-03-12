package com.lis.core.model.operations.calculation;

import com.lis.core.model.tests.AbstractTest;
import org.springframework.stereotype.Component;

/**
 * Created by xgimenez on 7/3/18.
 */
@Component
public class DefaultCalculationOperation implements ICalculationOperation<AbstractTest> {

    public void execute(AbstractTest test) {
        System.out.println("Default test");
    }
}

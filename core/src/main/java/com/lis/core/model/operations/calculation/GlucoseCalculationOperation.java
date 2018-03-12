package com.lis.core.model.operations.calculation;

import com.lis.core.model.tests.impl.GlucoseTest;
import org.springframework.stereotype.Component;

/**
 * Created by xgimenez on 7/3/18.
 */
@Component
public class GlucoseCalculationOperation implements ICalculationOperation<GlucoseTest> {

    public void execute(GlucoseTest test) {
        System.out.println("GlucoseTest test");
    }
}

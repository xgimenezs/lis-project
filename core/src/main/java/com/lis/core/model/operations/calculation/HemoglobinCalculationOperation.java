package com.lis.core.model.operations.calculation;

import com.lis.core.model.tests.impl.HemoglobinTest;
import org.springframework.stereotype.Component;

/**
 * Created by xgimenez on 7/3/18.
 */
@Component
public class HemoglobinCalculationOperation implements ICalculationOperation<HemoglobinTest> {

    public void execute(HemoglobinTest test) {
        System.out.println("HemoglobinTest test");
    }
}

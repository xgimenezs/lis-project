package com.lis.core.model.operations.calculation;

import com.lis.core.model.tests.ImmunologyTest;
import org.springframework.stereotype.Component;

/**
 * Created by xgimenez on 7/3/18.
 */
@Component
public class ImmunologyCalculationOperation implements ICalculationOperation<ImmunologyTest> {

    public void execute(ImmunologyTest test) {
        System.out.println("Immunology test");
    }
}

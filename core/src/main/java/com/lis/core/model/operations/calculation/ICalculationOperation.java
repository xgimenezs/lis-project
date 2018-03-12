package com.lis.core.model.operations.calculation;

import com.lis.core.model.operations.IOperation;
import com.lis.core.model.tests.AbstractTest;

/**
 * Created by xgimenez on 7/3/18.
 */
public interface ICalculationOperation<T extends AbstractTest> extends IOperation<T> {

    default String getName() {
        return "Calculation operation";
    }
}

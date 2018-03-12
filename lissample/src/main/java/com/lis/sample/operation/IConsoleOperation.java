package com.lis.sample.operation;

import com.lis.core.model.operations.IOperation;
import com.lis.core.model.tests.AbstractTest;

/**
 * Created by xgimenez on 8/3/18.
 */
public interface IConsoleOperation extends IOperation<AbstractTest> {

    default String getName() {
        return "Console operation";
    }
}

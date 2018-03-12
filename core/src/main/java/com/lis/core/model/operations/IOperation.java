package com.lis.core.model.operations;

import com.lis.core.model.tests.AbstractTest;

/**
 * Created by xgimenez on 7/3/18.
 */
public interface IOperation<T extends AbstractTest> {

    String getName();

    void execute(T test);
}

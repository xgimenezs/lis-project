package com.lis.sample.operation;

import com.lis.core.model.tests.AbstractTest;
import org.springframework.stereotype.Component;

/**
 * Created by xgimenez on 8/3/18.
 */
@Component
public class ConsoleOperation implements IConsoleOperation {

    @Override
    public void execute(AbstractTest test) {
        System.out.println("Executing ConsoleOperation over "
                + test.getClass().getSimpleName());
    }
}

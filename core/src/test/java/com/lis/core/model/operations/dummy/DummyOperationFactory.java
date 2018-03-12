package com.lis.core.model.operations.dummy;

import com.lis.core.model.operations.AbstractOperationFactory;
import com.lis.core.model.operations.IOperation;
import com.lis.core.model.tests.AbstractTest;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by xgimenez on 8/3/18.
 */
@Component
public class DummyOperationFactory extends AbstractOperationFactory<DummyOperationFactory.IDummyOperation> {

    @PostConstruct
    public void init() {
        System.out.println("DummyOperationFactory.init");
    }

    @Component
    public class DummyOperation implements IDummyOperation<AbstractTest> {

        public static final int DUMMY_VALUE = 2001;

        @Override
        public String getName() {
            return "Dummy Operation";
        }

        @Override
        public void execute(AbstractTest test) {
            test.setPropertyA(DUMMY_VALUE);
        }
    }
    public interface IDummyOperation<T extends AbstractTest> extends IOperation<T> {

    }
}

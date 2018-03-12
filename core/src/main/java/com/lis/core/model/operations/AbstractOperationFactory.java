package com.lis.core.model.operations;

import com.lis.core.model.tests.AbstractTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

/**
 * Created by xgimenez on 7/3/18.
 */
public abstract class AbstractOperationFactory<T extends IOperation> {

    @Autowired
    private List<T> operations;

    @PostConstruct
    public void init() {
        Collections.sort(operations, new ByGenericTypeComparator());
    }

    public T getOperation(AbstractTest test) {
        for (T operation : operations) {
            if(operationAcceptsTest(operation, test)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("The operation can't be executed in test: " + test.getClass());
    }

    protected boolean operationAcceptsTest(T operation, AbstractTest test) {
        Class<T> operationDestType = (Class<T>) GenericTypeResolver.resolveTypeArgument(operation.getClass(), IOperation.class);
        return  operationDestType.isAssignableFrom(test.getClass());
    }

    public List<T> getOperations() {
        return operations;
    }
}

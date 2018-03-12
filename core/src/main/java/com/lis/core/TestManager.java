package com.lis.core;

import com.lis.core.model.Order;
import com.lis.core.model.operations.AbstractOperationFactory;
import com.lis.core.model.operations.IOperation;
import com.lis.core.model.operations.calculation.ICalculationOperation;
import com.lis.core.model.tests.AbstractTest;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.GenericTypeResolver;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Created by xgimenez on 7/3/18.
 */
@Component()
public class TestManager  {

    @Autowired
    private List<AbstractOperationFactory> factories;

    private Map<Class, AbstractOperationFactory> factoriesByType;

    @PostConstruct
    public void init() {
        factoriesByType = new HashMap<>();
        factories.forEach(x -> {
            Class c1 = (Class) ((ParameterizedType) x.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            factoriesByType.put(c1, x);
        });
    }

    public void executeOperation(Order order, Class<? extends IOperation> operationType) {
        executeOperation(order, operationType, (test -> true));

    }

    public void executeOperation(Order order, Class<? extends IOperation> operationType, Predicate<AbstractTest> filter) {
        if(order.getTests() == null || order.getTests().isEmpty()) {
            throw new IllegalArgumentException("It's not allowed execute operationes over orders without tests");
        }
        if(operationType == null) {
            throw new IllegalArgumentException("Null operation");
        }
        AbstractOperationFactory factory = factoriesByType.get(operationType);
        if(factory == null) {
            throw new IllegalArgumentException("Unknown operation");
        }
        order.getTests().stream()
                .filter(x -> filter.test(x))
                .forEach(x -> factory.getOperation(x).execute(x));
    }
}

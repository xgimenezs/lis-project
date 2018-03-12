package com.lis.core.model.operations.calculation;

import com.lis.core.TestManagerConfig;
import com.lis.core.model.tests.impl.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by xgimenez on 8/3/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestManagerConfig.class })
public class CalculationOperationFactoryTest {

    @Autowired(required = false)
    private CalculationOperationFactory calculationOperationFactory;

    @Test
    public void testNotNull() {
        assertNotNull(calculationOperationFactory);
    }

    @Test
    public void testConcreteImplementation() {
        ICalculationOperation operation = calculationOperationFactory.getOperation(new GlucoseTest());
        assertNotNull(operation);
        assertTrue(operation instanceof GlucoseCalculationOperation);

        operation = calculationOperationFactory.getOperation(new HemoglobinTest());
        assertNotNull(operation);
        assertTrue(operation instanceof HemoglobinCalculationOperation);
    }

    @Test
    public void testGenericTypeImplementation() {
        ICalculationOperation operation = calculationOperationFactory.getOperation(new LymphocyteTest());
        assertNotNull(operation);
        assertTrue(operation instanceof ImmunologyCalculationOperation);
    }

    @Test
    public void testDefaultImplementation() {
        ICalculationOperation operation1 = calculationOperationFactory.getOperation(new SodiumTest());
        assertNotNull(operation1);
        ICalculationOperation operation2 = calculationOperationFactory.getOperation(new StreptococcusATest());
        assertNotNull(operation2);
        assertEquals(operation1, operation2);
        assertTrue(operation1 instanceof DefaultCalculationOperation);
    }
}
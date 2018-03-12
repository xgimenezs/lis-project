package com.lis.core;

import com.lis.core.model.Order;
import com.lis.core.model.Patient;
import com.lis.core.model.Sample;
import com.lis.core.model.operations.dummy.DummyOperationFactory;
import com.lis.core.model.operations.calculation.ICalculationOperation;
import com.lis.core.model.tests.impl.GlucoseTest;
import com.lis.core.model.tests.impl.HemoglobinTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by xgimenez on 7/3/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestManagerConfig.class })
public class TestManagerTest {

    @Autowired(required = false)
    private TestManager manager;

    @Test
    public void defaultOperationsLoaded() {
        assertNotNull("TestManager don't exist", manager);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExecuteEmptyOrder() {
        Order order = new Order.OrderBuilder()
                .setSample(new Sample("Blood", new Patient("Xavier")))
                .setEntryDate(new Date())
                .setTests(null)
                .createOrder();
        manager.executeOperation(order, ICalculationOperation.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExecuteNullOperation() {
        Order order = new Order.OrderBuilder()
                .setSample(new Sample("Blood", new Patient("Xavier")))
                .setEntryDate(new Date())
                .setTests(Arrays.asList(new GlucoseTest(), new HemoglobinTest()))
                .createOrder();
        manager.executeOperation(order, null);
    }

    @Test()
    public void testExecuteOperationOverAllTestInOrder() {
        GlucoseTest glucoseTest = new GlucoseTest();
        HemoglobinTest hemoglobinTest = new HemoglobinTest();
        Order order = new Order.OrderBuilder()
                .setSample(new Sample("Blood", new Patient("Xavier")))
                .setEntryDate(new Date())
                .setTests(Arrays.asList(glucoseTest, hemoglobinTest))
                .createOrder();

        manager.executeOperation(order, DummyOperationFactory.IDummyOperation.class);
        assertEquals(DummyOperationFactory.DummyOperation.DUMMY_VALUE, glucoseTest.getPropertyA());
        assertEquals(DummyOperationFactory.DummyOperation.DUMMY_VALUE, hemoglobinTest.getPropertyA());
    }

    @Test()
    public void testExecuteOperationOverFilteredTestInOrder() {
        GlucoseTest glucoseTest = new GlucoseTest();
        HemoglobinTest hemoglobinTest = new HemoglobinTest();
        Order order = new Order.OrderBuilder()
                .setSample(new Sample("Blood", new Patient("Xavier")))
                .setEntryDate(new Date())
                .setTests(Arrays.asList(glucoseTest, hemoglobinTest))
                .createOrder();

        manager.executeOperation(order, DummyOperationFactory.IDummyOperation.class, (test -> test instanceof GlucoseTest));
        assertEquals(DummyOperationFactory.DummyOperation.DUMMY_VALUE, glucoseTest.getPropertyA());
        assertEquals(0, hemoglobinTest.getPropertyA());
    }
}
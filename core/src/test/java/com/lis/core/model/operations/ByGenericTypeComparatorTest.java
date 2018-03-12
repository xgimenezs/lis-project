package com.lis.core.model.operations;

import com.lis.core.model.operations.calculation.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by xgimenez on 8/3/18.
 */
public class ByGenericTypeComparatorTest {

    private DefaultCalculationOperation defaultOp = new DefaultCalculationOperation();

    private ImmunologyCalculationOperation immOp = new ImmunologyCalculationOperation();

    private GlucoseCalculationOperation glucoseOp = new GlucoseCalculationOperation();

    private HemoglobinCalculationOperation hemoglobinOp = new HemoglobinCalculationOperation();

    @Test
    public void testOverOrderedList1() {
        List<? extends ICalculationOperation> init = Arrays.asList(immOp, defaultOp);
        List<? extends ICalculationOperation> sorted = buildSortedList(init);
        assertEquals(init, sorted);
    }

    @Test
    public void testOverOrderedList2() {
        List<? extends ICalculationOperation> init = Arrays.asList(hemoglobinOp, glucoseOp, immOp, defaultOp);
        List<? extends ICalculationOperation> sorted = buildSortedList(init);
        assertEquals(init, sorted);
    }

    @Test
    public void testOrderList1() {
        List<? extends ICalculationOperation> init = Arrays.asList(defaultOp, immOp);
        List<? extends ICalculationOperation> expected = Arrays.asList(immOp, defaultOp);
        List<? extends ICalculationOperation> sorted = buildSortedList(init);
        assertEquals(expected, sorted);
    }

    @Test
    public void testOrderList2() {
        List<? extends ICalculationOperation> init = Arrays.asList(defaultOp, immOp, glucoseOp, hemoglobinOp);
        List<? extends ICalculationOperation> expected = Arrays.asList(immOp, glucoseOp, hemoglobinOp, defaultOp);
        List<? extends ICalculationOperation> sorted = buildSortedList(init);
        assertEquals(expected, sorted);
    }

    @Test
    public void testOrderList() {
        List<? extends ICalculationOperation> init = Arrays.asList(defaultOp, immOp, glucoseOp, hemoglobinOp);
        List<? extends ICalculationOperation> expected = Arrays.asList(immOp, glucoseOp, hemoglobinOp, defaultOp);
        List<? extends ICalculationOperation> sorted = buildSortedList(init);
        assertEquals(expected, sorted);
    }

    private List<? extends ICalculationOperation> buildSortedList(List<? extends ICalculationOperation> init) {
        ArrayList<? extends ICalculationOperation> sorted = new ArrayList<ICalculationOperation>(init);
        Collections.sort(sorted, new ByGenericTypeComparator());
        return sorted;
    }
}
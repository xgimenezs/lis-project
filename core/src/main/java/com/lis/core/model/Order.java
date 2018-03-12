package com.lis.core.model;

import com.lis.core.model.tests.AbstractTest;

import java.util.Date;
import java.util.List;

/**
 * Created by xgimenez on 7/3/18.
 */
public class Order {

    private Sample sample;

    private Date entryDate;

    private List<AbstractTest> tests;

    Order(Sample sample, Date entryDate, List<AbstractTest> tests) {
        this.sample = sample;
        this.entryDate = entryDate;
        this.tests = tests;
    }

    public Sample getSample() {
        return sample;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public List<AbstractTest> getTests() {
        return tests;
    }

    public static class OrderBuilder {
        private Sample sample;
        private Date entryDate;
        private List<AbstractTest> tests;

        public OrderBuilder setSample(Sample sample) {
            this.sample = sample;
            return this;
        }

        public OrderBuilder setEntryDate(Date entryDate) {
            this.entryDate = entryDate;
            return this;
        }

        public OrderBuilder setTests(List<AbstractTest> tests) {
            this.tests = tests;
            return this;
        }

        public Order createOrder() {
            return new Order(sample, entryDate, tests);
        }
    }

}

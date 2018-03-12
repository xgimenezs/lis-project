package com.lis.core.model;

/**
 * Created by xgimenez on 12/3/18.
 */
public class Sample {

    private String description;

    private Patient patient;

    public Sample(String description, Patient patient) {
        this.description = description;
        this.patient = patient;
    }

    public String getDescription() {
        return description;
    }

    public Patient getPatient() {
        return patient;
    }
}

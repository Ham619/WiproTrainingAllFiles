package com.healthcare.module;

public class GeneralPhysicians extends Doctor {
    public GeneralPhysicians(String name) {
        super(name, "General Physician");
    }

    @Override
    public void diagnosePatient(Patient patient) {
        System.out.println("Dr. " + getName() + " (" + getSpecialization() + ") is diagnosing patient " + patient.getName());
        System.out.println("Diagnosis: " + patient.getIllness());
    }
}
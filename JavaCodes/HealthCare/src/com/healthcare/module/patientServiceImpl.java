package com.healthcare.module;

public class patientServiceImpl implements PatientService {

    private Patient[] patientArray = new Patient[100]; 
    private int count = 0; 

    @Override
    public void registerPatient(Patient patient) {
        if (count < patientArray.length) {
            patientArray[count] = patient;
            count++;
            System.out.println("Patient " + patient.getName() + " registered successfully with ID: " + patient.getId());
        } else {
            System.out.println("Registration failed: Patient storage is full.");
        }
    }

    @Override
    public void showPatientDetails(int patientId) {
        for (int i = 0; i < count; i++) {
            if (patientArray[i].getId() == patientId) {
                System.out.println("Patient Details:");
                System.out.println("ID: " + patientArray[i].getId());
                System.out.println("Name: " + patientArray[i].getName());
                System.out.println("Age: " + patientArray[i].getAge());
                System.out.println("Illness: " + patientArray[i].getIllness());
                return;
            }
        }
        System.out.println("Patient with ID " + patientId + " not found.");
    }
}

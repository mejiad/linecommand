package com.evoltech.linecommand.model;

import lombok.Data;

@Data
public class PatientBase {
    String patientId;
    double bmi;
    double height;
    double weight;
    String birthDate;
}
package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Patient;

public interface PatientService 
{
	Patient  addPatient(Patient patient);
	List<Patient> displayAllPatients();
	Patient updatePatient(Patient p);
	Patient displayPatientbyId(Long id);
	//save performs 2 ops insert and update
	//list,one object,string --> these are only the return types
	String deletePatientById(Long id);
	List<Patient> displayPatientByGender(String gender);
	

}
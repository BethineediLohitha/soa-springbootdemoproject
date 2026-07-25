package com.klef.soa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Patient;
import com.klef.soa.repository.PatientRepository;
@Service
public class PatientServiceImpl implements PatientService 
{
	@Autowired
	private PatientRepository repo;

	@Override
	public Patient addPatient(Patient patient) {
		// TODO Auto-generated method stub
		return repo.save(patient);
	}

	@Override
	public List<Patient> displayAllPatients() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Patient updatePatient(Patient p) {
		Optional<Patient> optional = repo.findById(p.getId());
		if(optional.isPresent())
		{
			Patient patient = optional.get();
			patient.setName(p.getName());
			patient.setAge(p.getAge());
			patient.setContact(p.getContact());
			patient.setRemarks(p.getRemarks());
			return repo.save(patient);
		} else {
			
		}
	}

	@Override
	public Patient displayPatientByid(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public String deletePatientById(Long id) {
		boolean status = repo.existsById(id);
		if(status)
		{
			repo.deleteById(id);
			return "Patient Deleted Successfully";
		}
		else {
			return "Patient Id not found";
		}
	}

	@Override
	public List<Patient> displayPatientByGender(String gender) {
		// TODO Auto-generated method stub
		return repo.findByGender(gender);
	}

}

package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Patient;
import com.klef.soa.repository.PatientRepository;
@Service
public class PatientServiceImpl implements PatientService 
{
	
	
	@Autowired
	private PatientRepository repo;
	//autowired is the concept of communication b/w two managed objects

	@Override
	public Patient addPatient(Patient patient) 
	{	
		return repo.save(null);
	}

	
	
	
	@Override
	public List<Patient> displayAllPatients() 
	{
		return repo.findAll();
	}

	@Override
	public Patient updatePatient(Patient p) 
	{
		Optional<Patient> optional = repo.findById(p.getId());
		if(optional.isPresent())
		{
			Patient patient = optional.get();
			//here we have two patient objects pa nd patient --> p is the input and patient is the existing object
			patient.setName(p.getName());
			patient.setAge(p.getAge());
			patient.setContact(p.getContact());
			patient.setRemarks(p.getRemarks());
			return repo.save(patient);
		}
		else
		{
			return null;
		}
	}


	
	
	
	@Override
	public Patient displayPatientbyId(Long id) 
	{
		return repo.findById(id).orElse(null);//findby id give the return type as optional class
	}
//optional class is container that may or maynot give the object--it can be checked by isclass
	
	
	
	
	
	@Override
	public String deletePatientById(Long id) 
	{
		boolean status = repo.existsById(id);
		if(status)
		{
			repo.deleteById(id);
			return "Patient Deleted Successfully";
		}
		else
		{
			return "Patient Id not Found";
		}
	}

	
	
	@Override
	public List<Patient> displayPatientByGender(String gender) 
	{
		return repo.findByGender(gender);
	}

}
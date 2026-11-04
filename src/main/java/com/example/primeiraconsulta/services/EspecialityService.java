package com.example.primeiraconsulta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.primeiraconsulta.entities.Especiality;
import com.example.primeiraconsulta.repositories.EspecialityRepository;
import java.util.List;

@Service
public class EspecialityService {
	@Autowired	
	private EspecialityRepository repos;
	
	public List<Especiality> getAllEspecialities() {
        return repos.findAll();
    }
}

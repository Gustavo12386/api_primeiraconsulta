package com.example.primeiraconsulta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.primeiraconsulta.entities.Hour;

import com.example.primeiraconsulta.repositories.HourRepository;

@Service
public class HourService {
	@Autowired	
	private HourRepository repos;
	
	public List<Hour> getAllHours() {
        return repos.findAll();
    }
}

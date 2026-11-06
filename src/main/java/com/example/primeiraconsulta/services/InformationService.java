package com.example.primeiraconsulta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.primeiraconsulta.entities.Information;
import com.example.primeiraconsulta.dto.InformationDTO;
import com.example.primeiraconsulta.entities.Date;
import com.example.primeiraconsulta.entities.Especiality;
import com.example.primeiraconsulta.repositories.DateRepository;
import com.example.primeiraconsulta.repositories.EspecialityRepository;
import com.example.primeiraconsulta.repositories.HourRepository;
import com.example.primeiraconsulta.repositories.InformationRepository;


import java.util.List;


@Service
public class InformationService {
	
	@Autowired	
	private InformationRepository repository_information;	
	
	@Autowired	
	private EspecialityRepository repository_especialization;	
	
	@Autowired
	private DateRepository repository_date;
	
	@Autowired
	private HourRepository repository_hour;
	
	  public Information save(InformationDTO dto) {

	
	        Especiality especiality =
	            repository_especialization.findById(dto.especialityId())
	                .orElseThrow(() ->
	                    new RuntimeException("Especialidade não encontrada!")
	                );

	    
	        Date date = repository_date
	            .findByEspeciality_EspecializationIdAndCurrentDate(
	                dto.especialityId(),
	                dto.date_scheduled()
	            )
	            .orElseThrow(() ->
	                new RuntimeException(
	                    "Data não disponível para esta especialidade!"
	                )
	            );

	   
	        boolean validHour = repository_hour
	            .findByDate_DateId(date.getDateId())
	            .stream()
	            .anyMatch(hour ->
	                hour.getCurrentHour().equals(dto.hour())
	            );

	        if (!validHour) {
	            throw new RuntimeException(
	                "Horário não disponível para esta data!"
	            );
	        }

	        boolean alreadyScheduled =
	            repository_information.existsScheduledAppointment(
	                dto.especialityId(),
	                dto.date_scheduled(),
	                dto.hour()
	            );

	        if (alreadyScheduled) {
	            throw new RuntimeException(
	                "Este horário já foi reservado!"
	            );
	        }

	        Information information = new Information();

	        information.setEspeciality(especiality);

	        information.setEspeciality_name(
	            especiality.getEspecializationName()
	        );

	        information.setName(dto.name());
	        information.setPhone(dto.phone());
	        information.setEmail(dto.email());
	        information.setDate_birth(dto.date_birth());
	        information.setDate_scheduled(dto.date_scheduled());
	        information.setHour(dto.hour());

	        information.setQuestion1(dto.question1());
	        information.setQuestion2(dto.question2());
	        information.setQuestion3(dto.question3());

	        return repository_information.save(information);
	    }
	  
	public List<Information> getAllInformations() {
        return repository_information.findAll();
    }

}

package com.example.primeiraconsulta.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.primeiraconsulta.entities.Date;

import com.example.primeiraconsulta.repositories.DateRepository;
import com.example.primeiraconsulta.repositories.HourRepository;
import com.example.primeiraconsulta.repositories.InformationRepository;

@Service
public class DateService {
	@Autowired	
	private DateRepository dateRepository;
	@Autowired
	private HourRepository hourRepository;
	@Autowired
    private InformationRepository informationRepository;
	
	public List<Date> getAllDates() {
        return dateRepository.findAll();
    }
	
	 public List<Date> getDatesByEspeciality(UUID especialityId) {

	        List<Date> dates =
	            dateRepository.findByEspeciality_EspecializationId(especialityId);

	        return dates.stream()
	            .filter(date ->
	                hourRepository.findByDate_DateId(date.getDateId())
	                    .stream()
	                    .anyMatch(hour ->
	                        !informationRepository.existsScheduledAppointment(
	                            especialityId,
	                            date.getCurrentDate(),
	                            hour.getCurrentHour()
	                        )
	                    )
	            )
	            .toList();
	    }
	
}

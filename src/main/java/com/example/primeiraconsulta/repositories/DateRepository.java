package com.example.primeiraconsulta.repositories;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.primeiraconsulta.entities.Date;
import com.example.primeiraconsulta.entities.Especiality;



public interface DateRepository extends JpaRepository<Date, UUID>  {
	 List<Date> findByEspeciality_EspecializationId(UUID especialityId);

	    Optional<Date> findByEspeciality_EspecializationIdAndCurrentDate(
	        UUID especialityId,
	        LocalDate currentDate
	    );

}

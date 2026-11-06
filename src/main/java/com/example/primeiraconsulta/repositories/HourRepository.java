package com.example.primeiraconsulta.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.primeiraconsulta.entities.Date;
import com.example.primeiraconsulta.entities.Hour;

public interface HourRepository extends JpaRepository<Hour, UUID> {
	List<Hour> findByDate_DateId(UUID dateId);
}

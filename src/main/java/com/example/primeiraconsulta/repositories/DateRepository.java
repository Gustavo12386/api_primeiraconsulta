package com.example.primeiraconsulta.repositories;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.primeiraconsulta.entities.Date;


public interface DateRepository extends JpaRepository<Date, UUID>  {
	
}

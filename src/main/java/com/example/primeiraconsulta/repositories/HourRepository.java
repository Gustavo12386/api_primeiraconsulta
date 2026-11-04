package com.example.primeiraconsulta.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.primeiraconsulta.entities.Hour;

public interface HourRepository extends JpaRepository<Hour, UUID> {

}

package com.example.primeiraconsulta.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.primeiraconsulta.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, UUID>{
	Optional<Payment> findByExternalReference(String externalReference);

    Optional<Payment> findByMercadoPagoPaymentId(String mercadoPagoPaymentId);
}

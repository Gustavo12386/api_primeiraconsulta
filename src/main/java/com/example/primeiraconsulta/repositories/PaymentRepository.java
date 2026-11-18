package com.example.primeiraconsulta.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.primeiraconsulta.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, UUID>{
	Optional<Payment> findByExternalReference(String externalReference);
    Optional<Payment> findByMercadoPagoPaymentId(String mercadoPagoPaymentId);
    @Query("""
            SELECT p
            FROM Payment p
            JOIN FETCH p.information i
            ORDER BY p.createdAt DESC
        """)
        List<Payment> findAllWithPatient();
}

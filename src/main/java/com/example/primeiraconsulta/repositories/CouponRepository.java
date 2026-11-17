package com.example.primeiraconsulta.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.primeiraconsulta.entities.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, UUID> {
	Optional<Coupon> findByCouponCode(String couponCode);

    boolean existsByCouponCode(String couponCode);
}

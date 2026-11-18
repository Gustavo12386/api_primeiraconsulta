package com.example.primeiraconsulta.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.primeiraconsulta.dto.CouponResponse;

import com.example.primeiraconsulta.services.CouponService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/coupons")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class CouponController {
	
	@Autowired
	private CouponService couponService;
	
	@GetMapping("/validate/{couponCode}")
    public ResponseEntity<CouponResponse> validateCoupon(
            @PathVariable String couponCode) {

        CouponResponse response =
                couponService.validateCoupon(couponCode);

        return ResponseEntity.ok(response);
    }
}

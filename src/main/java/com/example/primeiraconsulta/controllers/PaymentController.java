package com.example.primeiraconsulta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.primeiraconsulta.dto.PaymentRequest;
import com.example.primeiraconsulta.dto.PaymentResponse;
import com.example.primeiraconsulta.services.PaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	 @PostMapping("/checkout")
	 public ResponseEntity<PaymentResponse> createCheckout(
	     @RequestBody PaymentRequest request
	 ) {

	 PaymentResponse response =
	 paymentService.createCheckout(request);

	   return ResponseEntity.ok(response);
	 }
}

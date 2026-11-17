package com.example.primeiraconsulta.dto;

import java.util.UUID;

public record PaymentRequest(UUID informationId,
	    String couponCode,
	    String paymentMethod) {

}

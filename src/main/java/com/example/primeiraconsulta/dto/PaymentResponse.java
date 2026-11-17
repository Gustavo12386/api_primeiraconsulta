package com.example.primeiraconsulta.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentResponse(  UUID paymentId,

	    String preferenceId,

	    String checkoutUrl,

	    BigDecimal originalAmount,

	    BigDecimal discountAmount,

	    BigDecimal finalAmount,

	    String status) {

}

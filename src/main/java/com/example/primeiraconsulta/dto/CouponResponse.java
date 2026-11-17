package com.example.primeiraconsulta.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record CouponResponse(UUID couponId,

	    String couponCode,

	    BigDecimal discountPercentage,

	    LocalDateTime validUntil) {

}

package com.github.hotechbackend.payments.interfaces.rest.resources;


public record CreatePaymentResource(
    Long userId,
    String paymentMethod,
    String status
) { }

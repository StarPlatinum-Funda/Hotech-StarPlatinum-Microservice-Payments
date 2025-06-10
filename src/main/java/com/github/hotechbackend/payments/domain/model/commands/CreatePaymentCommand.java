package com.github.hotechbackend.payments.domain.model.commands;

import java.util.Date;

public record CreatePaymentCommand(Long userId, String paymentMethod, String status) {
}

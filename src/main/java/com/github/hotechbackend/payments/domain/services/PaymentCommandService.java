package com.github.hotechbackend.payments.domain.services;

import com.github.hotechbackend.payments.domain.model.aggregates.Payment;
import com.github.hotechbackend.payments.domain.model.commands.CreatePaymentCommand;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PaymentCommandService {
    Optional<Payment> handle(CreatePaymentCommand command);
}

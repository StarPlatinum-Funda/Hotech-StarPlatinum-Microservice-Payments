package com.github.hotechbackend.payments.application.commandservices;

import com.github.hotechbackend.payments.domain.model.aggregates.Payment;
import com.github.hotechbackend.payments.domain.model.commands.CreatePaymentCommand;
import com.github.hotechbackend.payments.domain.model.valueobjects.PaymentMethod;
import com.github.hotechbackend.payments.domain.services.PaymentCommandService;
import com.github.hotechbackend.payments.infrastructure.persistence.jpa.repositories.PaymentRepository;

import java.util.Optional;

public class PaymentCommandServiceImpl implements PaymentCommandService {
    private final PaymentRepository paymentRepository;

    public PaymentCommandServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Optional<Payment> handle(CreatePaymentCommand command) {
        var paymentMethod = new PaymentMethod(command.paymentMethod());
        if(paymentRepository.existsByPaymentMethod(paymentMethod))
            throw new IllegalArgumentException("Payment method " + command.paymentMethod() + " already exists");
        var payment = new Payment(command);
        paymentRepository.save(payment);
        return Optional.of(payment);
    }
}

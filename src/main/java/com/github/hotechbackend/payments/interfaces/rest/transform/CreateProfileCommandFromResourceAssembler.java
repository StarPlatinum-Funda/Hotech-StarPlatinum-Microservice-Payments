package com.github.hotechbackend.payments.interfaces.rest.transform;

import com.github.hotechbackend.payments.domain.model.commands.CreatePaymentCommand;
import com.github.hotechbackend.payments.interfaces.rest.resources.CreatePaymentResource;

public class CreateProfileCommandFromResourceAssembler {
    public static CreatePaymentCommand toCommandFromResource(CreatePaymentResource resource) {
        return new CreatePaymentCommand(resource.userId(), resource.paymentMethod(), resource.status());
    }
}

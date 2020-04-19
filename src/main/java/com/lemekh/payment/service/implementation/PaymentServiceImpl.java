package com.lemekh.payment.service.implementation;

import com.lemekh.payment.dto.Context;
import com.lemekh.payment.dto.OrderDTO;
import com.lemekh.payment.handler.EventHandler;
import com.lemekh.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final EventHandler eventHandler;

    @Override
    public void pay(final Context context) {
        final OrderDTO order = context.getData();
        verifyPaymentData(order);
        context.setType("OrderPayed");
        eventHandler.producer("order_saga_server", context);
    }

    private static void verifyPaymentData(final OrderDTO order) {
        if (!order.getCart().matches("^[0-9]*$")) {
            throw new RuntimeException("Wrong cart number!");
        }
    }
}

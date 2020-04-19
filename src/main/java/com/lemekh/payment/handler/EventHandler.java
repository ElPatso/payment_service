package com.lemekh.payment.handler;

import com.lemekh.payment.dto.Context;
import com.lemekh.payment.dto.OrderDTO;
import com.lemekh.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventHandler {

    private final KafkaTemplate<String, Context> kafkaTemplate;
    private final PaymentService paymentService;

    @KafkaListener(groupId = "order", topics = "payment_service", containerFactory = "kafkaListenerContainerFactory")
    public void listener(@Payload final Context context) {
        paymentService.pay(context);
    }

    public void producer(final String topic, final Context value) {
        kafkaTemplate.send(topic, value);
    }

}

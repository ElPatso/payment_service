package com.lemekh.payment.service;

import com.lemekh.payment.dto.Context;
import com.lemekh.payment.dto.OrderDTO;
import com.lemekh.payment.service.implementation.PaymentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PaymentServiceImplTest {

    @InjectMocks
    private PaymentServiceImpl paymentService;

    @Test(expected = RuntimeException.class)
    public void pay__order__wrongCartNumber() {
        final Context context = new Context();
        final OrderDTO order = new OrderDTO();
        order.setCart("qweqwe");
        context.setData(order);

        paymentService.pay(context);
    }
}

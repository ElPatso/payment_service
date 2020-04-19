package com.lemekh.payment.dto;

import com.lemekh.payment.enumeration.OrderStateEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@Accessors(chain = true)
public class OrderDTO {
    private List<String> goods;
    private String note;
    private BigDecimal price;
    private OrderStateEnum stateEnum;
    private String cart;
    private int cvv;
}

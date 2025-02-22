package com.automation.pojo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CreateOrderPojo {
    private int id;
    private int petId;
    private int quantity;
    private LocalDateTime shipDate;
    private String status;
    private boolean complete;
}

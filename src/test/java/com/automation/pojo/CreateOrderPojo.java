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
    int id;
    int petId;
    int quantity;
    LocalDateTime shipDate;
    String status;
    boolean complete;
}

package com.blackcode.book_store_be.dto.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrdersTransactionReq {
    private String ordersId;
    private String userId;
    private String totalPrice;
    private List<OrdersItemsReq> orderItemsReq;
}

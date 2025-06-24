package com.blackcode.book_store_be.dto.orders;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrdersItemsRes {
    private String orderItemsId;
    private String orderId;
    private String booksId;
    private String quantity;
    private String unitPrice;
}

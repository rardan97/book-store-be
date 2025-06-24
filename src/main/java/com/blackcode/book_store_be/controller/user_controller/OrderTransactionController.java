package com.blackcode.book_store_be.controller.user_controller;

import com.blackcode.book_store_be.dto.orders.OrdersItemsReq;
import com.blackcode.book_store_be.dto.orders.OrdersItemsRes;
import com.blackcode.book_store_be.dto.orders.OrdersTransactionReq;
import com.blackcode.book_store_be.dto.orders.OrdersTransactionRes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orderTransaction")
public class OrderTransactionController {

    @PostMapping("/addOrderTransaction")
    public ResponseEntity<OrdersTransactionRes> addOrderTransaction(@RequestBody OrdersTransactionReq ordersTransactionReq){
        List<OrdersItemsRes> ordersItemsRes = new ArrayList<>();
        OrdersTransactionRes ordersTransactionRes = new OrdersTransactionRes();
        List<OrdersItemsReq> ordersItemsReq = ordersTransactionReq.getOrderItemsReq();

        ordersTransactionRes.setOrdersId("ORDER-001");
        ordersTransactionRes.setStatus("PENDING");
        ordersTransactionRes.setTotalPrice(ordersTransactionReq.getTotalPrice());
        ordersTransactionRes.setUserId(ordersTransactionReq.getUserId());

        for (OrdersItemsReq rowOrderItems : ordersItemsReq){
            OrdersItemsRes ordersItem = new OrdersItemsRes();
            ordersItem.setOrderItemsId(rowOrderItems.getOrdersItemsId());
            ordersItem.setOrderId(String.valueOf(ordersTransactionRes.getOrdersId()));
            ordersItem.setBooksId(rowOrderItems.getBooksId());
            ordersItem.setQuantity(rowOrderItems.getQuantity());
            ordersItem.setUnitPrice(rowOrderItems.getUnitPrice());
            ordersItemsRes.add(ordersItem);
        }

        ordersTransactionRes.setOrdersItemsRes(ordersItemsRes);
        return ResponseEntity.ok(ordersTransactionRes);
    }

}

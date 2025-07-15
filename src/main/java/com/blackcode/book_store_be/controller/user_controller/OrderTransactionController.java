package com.blackcode.book_store_be.controller.user_controller;

import com.blackcode.book_store_be.dto.ordersitems.OrdersItemsReq;
import com.blackcode.book_store_be.dto.ordersitems.OrdersItemsRes;
import com.blackcode.book_store_be.dto.ordertransaction.OrdersTransactionReq;
import com.blackcode.book_store_be.dto.ordertransaction.OrdersTransactionRes;
import com.blackcode.book_store_be.service.BooksService;
import com.blackcode.book_store_be.service.OrdersTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user/orderTransaction")
public class OrderTransactionController {

    @Autowired
    private OrdersTransactionService ordersTransactionService;

    @PostMapping("/addOrderTransaction")
    public ResponseEntity<OrdersTransactionRes> addOrderTransaction(@RequestBody OrdersTransactionReq ordersTransactionReq){
        OrdersTransactionRes ordersTransactionRes = ordersTransactionService.addOrdersTransaction(ordersTransactionReq);
        return ResponseEntity.ok(ordersTransactionRes);
    }

}

package com.blackcode.book_store_be.dto.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DataTotalTransactionDto {
    private String order_id;
    private String total_amount;
}

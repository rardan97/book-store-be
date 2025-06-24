package com.blackcode.book_store_be.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_orders_items")
public class OrdersItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ordersItemsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    private Orders orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booksId")
    private Books booksId;

    private Integer quantity;

    private Integer unit_price;

//    CREATE TABLE order_items (
//            id SERIAL PRIMARY KEY,
//            order_id INT REFERENCES orders(id) ON DELETE CASCADE,
//        book_id INT REFERENCES books(id),
//        quantity INT NOT NULL,
//        unit_price NUMERIC(10,2) NOT NULL
//    );
}

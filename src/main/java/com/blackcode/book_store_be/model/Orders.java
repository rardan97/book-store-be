package com.blackcode.book_store_be.model;

import com.blackcode.book_store_be.model.user.User;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ordersId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User userId;

    private String orderTotalPrice;

    private String ordersStatus;

    private String ordersCreateAt;

//    CREATE TABLE orders (
//            id SERIAL PRIMARY KEY,
//            user_id INT REFERENCES users(id),
//        total_price NUMERIC(10,2) NOT NULL,
//        status VARCHAR(20) NOT NULL CHECK (status IN ('pending', 'paid', 'shipped', 'cancelled')),
//        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
//    );
}

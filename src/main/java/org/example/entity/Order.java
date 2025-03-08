package org.example.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity(name = "orders")//e bejme orders sepse order eshte e zene nga sql (ORDER BY)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatusEnum orderStatusEnum;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status")
    private PaymentStatusEnum paymentStatusEnum;

    private Double total;


    @ManyToOne
    @JoinColumn(name = "client_id") //per foreign key
    private Client client;




    @CreationTimestamp
    @Column (name = "created at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column (name = "updated at")
    private LocalDateTime updatedAt;



}

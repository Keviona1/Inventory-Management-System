package org.example.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
public class OrderItems {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}

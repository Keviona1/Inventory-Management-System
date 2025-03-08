package org.example.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

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

    @OneToMany(mappedBy = "order_table")
    private List<OrderItems> orderItemsList;

    @ManyToOne
    @JoinColumn(name = "client_id") //per foreign key
    private Client client;




    @CreationTimestamp
    @Column (name = "created at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column (name = "updated at")
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatusEnum getOrderStatusEnum() {
        return orderStatusEnum;
    }

    public void setOrderStatusEnum(OrderStatusEnum orderStatusEnum) {
        this.orderStatusEnum = orderStatusEnum;
    }

    public PaymentStatusEnum getPaymentStatusEnum() {
        return paymentStatusEnum;
    }

    public void setPaymentStatusEnum(PaymentStatusEnum paymentStatusEnum) {
        this.paymentStatusEnum = paymentStatusEnum;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<OrderItems> getOrderItemsList() {
        return orderItemsList;
    }

    public void setOrderItemsList(List<OrderItems> orderItemsList) {
        this.orderItemsList = orderItemsList;
    }

}

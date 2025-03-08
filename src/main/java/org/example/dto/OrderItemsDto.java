package org.example.dto;

public class OrderItemsDto {

    private Long productId;
    private Integer quantity;
//vetem entiteti do konstruktor bosh, dto nuk jemi te detyruar

    public OrderItemsDto(Long productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

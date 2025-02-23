package org.example.converter;

import org.example.dto.ProductDto;
import org.example.entity.Category;
import org.example.entity.Product;

public class ProductConverter {
    public static Product convertDtoToEntity(ProductDto productDto){
        Product product = new Product();
        product.setQuantity(productDto.getQuantity());
        product.setPrice(productDto.getPrice());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setCategory(new Category(productDto.getCategoryId()));

        return product;

    }
}
